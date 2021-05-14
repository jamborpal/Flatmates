package com.jamborpal.app.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jamborpal.app.R;
import com.jamborpal.app.ui.contact.ContactsAdapter;
import com.jamborpal.app.ui.events.EventAdapter;
import com.jamborpal.app.ui.home.CostAdapter;
import com.jamborpal.app.ui.home.OwnChoresAdapter;
import com.jamborpal.app.ui.messageboard.MessageAdapter;
import com.jamborpal.app.ui.tasks.TaskAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModelManager implements Model {
    //Add variable of database instance
    public Flatmate LoggedInUser;
    public Flat flat;
    private String flatID;
    private String flatmateID;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private static ModelManager modelManager;

    public synchronized static ModelManager getInstance() {
        if (modelManager == null) {
            modelManager = new ModelManager();
        }
        return modelManager;
    }

    public ModelManager(String flatmateID, String flatID) {
        database = FirebaseDatabase.getInstance();
        myref = database.getReference();
        setFlatUsed(flatID);
        setLoggedInUser(flatmateID);
    }

    public ModelManager() {
        database = FirebaseDatabase.getInstance();
        myref = database.getReference();
    }
    @Override
    public String getEmail() {
        return "LoggedInUser.getEmail()";
    }

    @Override
    public String getPhoneNumber() {
        return "LoggedInUser.getPhonenumber()";
    }


    @Override
    public String getExpensesPaidByFlatmate() {
        return "LoggedInUser.getMoneyspent()";
    }
    @Override
    public void login(String username, String password) {

        myref.child("flats").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public synchronized void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    for (DataSnapshot snapshot2 : snapshot1.child("tenants").getChildren()) {
                        Flatmate flatmate = snapshot2.getValue(Flatmate.class);
                        if (flatmate.getUsername().equals(username) && flatmate.getPassword().equals(password)) {
                            LoggedInUser = flatmate;
                            setLoggedInUser(snapshot2.getKey());
                            setFlatUsed(snapshot1.getKey());
                            return;

                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void setLoggedInUser(String flatmate) {
        this.flatmateID = flatmate;

    }

    @Override
    public void setFlatUsed(String flat) {
        this.flatID = flat;

    }


    @Override
    public void AddExpense(Expense expense) {
        double spent = expense.getPrice() + LoggedInUser.getMoneyspent();
        LoggedInUser.setMoneyspent(spent);
        myref.child("flats").child(getFlatID()).child("expenses").push().setValue(expense);
        myref.child("flats").child(getFlatID()).child("tenants").child(getFlatmateID()).child("moneyspent").setValue(spent);


    }

    @Override
    public String getFullName() {
        return myref.child("flats").child("hi").child("tenants").child("17641908").get().getResult().getValue(Flatmate.class).getFullname();
    }



    @Override
    public void AddChore(Chore chore) {
        myref.child("flats").child(getFlatID()).child("chores").child(chore.getChoreID()).setValue(chore);
    }

    @Override
    public void deleteChore(String ChoreID) {
        myref.child("flats").child(getFlatID()).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    System.out.println(snapshot1);
                    if (snapshot1.getKey().equals(ChoreID)) {
                        snapshot1.getRef().setValue(null);
                        return;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });
    }

    @Override
    public void AssignChore(String ChoreID) {
        myref.child("flats").child(getFlatID()).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    System.out.println(snapshot1);
                    if (snapshot1.getKey().equals(ChoreID)) {
                        snapshot1.child("assignedto").getRef().setValue(getFlatmateID());
                        return;
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });

    }

    @Override
    public void getChoresNotAssigned(RecyclerView recyclerView) {
        Query query = myref
                .child("flats").child(getFlatID()).child("chores").orderByChild("assignedto").equalTo("")
                .limitToLast(50);
        FirebaseRecyclerOptions<Chore> options = new FirebaseRecyclerOptions.Builder<Chore>()
                .setQuery(query, Chore.class).build();
        FirebaseRecyclerAdapter<Chore, TaskAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<Chore, TaskAdapter.ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position, @NonNull Chore model) {
                        holder.getTitle().setText(model.getTitle());
                        holder.getDescription().setText(model.getDescription());
                        holder.getAccept().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AssignChore(model.getChoreID());
                            }
                        });
                        holder.getDelete().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                deleteChore(model.getChoreID());
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singletask, parent, false);
                        return new TaskAdapter.ViewHolder(v);
                    }
                };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getChoresByFlatmate(RecyclerView recyclerView, String id) {
        Query query = myref
                .child("flats").child(getFlatID()).child("chores").orderByChild("assignedto").equalTo(id)
                .limitToLast(50);
        FirebaseRecyclerOptions<Chore> options = new FirebaseRecyclerOptions.Builder<Chore>()
                .setQuery(query, Chore.class).build();
        FirebaseRecyclerAdapter<Chore, OwnChoresAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<Chore, OwnChoresAdapter.ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull OwnChoresAdapter.ViewHolder holder, int position, @NonNull Chore model) {
                        holder.getTitle().setText(model.getTitle());
                        holder.getDesc().setText(model.getDescription());
                    }

                    @NonNull
                    @Override
                    public OwnChoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleownchore, parent, false);
                        return new OwnChoresAdapter.ViewHolder(v);
                    }
                };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getExpenses(RecyclerView recyclerView) {
        Query query = myref
                .child("flats").child(getFlatID()).child("expenses")
                .limitToLast(50);
        FirebaseRecyclerOptions<Expense> options = new FirebaseRecyclerOptions.Builder<Expense>()
                .setQuery(query, Expense.class).build();
        FirebaseRecyclerAdapter<Expense, CostAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<Expense, CostAdapter.ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull CostAdapter.ViewHolder holder, int position, @NonNull Expense model) {
                        holder.getExpenseName().setText(model.title);
                        holder.getExpenseCost().setText("" + model.price);
                    }

                    @NonNull
                    @Override
                    public CostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singelexpense, parent, false);
                        return new CostAdapter.ViewHolder(v);
                    }
                };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OrganizeEvent(Event event) {
        myref.child("flats").child(getFlatID()).child("events").push().setValue(event);
    }

    @Override
    public void getMessages(RecyclerView recyclerView) {
        Query query = myref
                .child("flats").child(getFlatID()).child("messages")
                .limitToLast(20);
        FirebaseRecyclerOptions<String> options = new FirebaseRecyclerOptions.Builder<String>()
                .setQuery(query, String.class).build();
        FirebaseRecyclerAdapter<String, MessageAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<String, MessageAdapter.ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position, @NonNull String model) {
                        holder.getMessage().setText(model);
                    }

                    @NonNull
                    @Override
                    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlemessage, parent, false);
                        return new MessageAdapter.ViewHolder(v);
                    }
                };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void sendMessage(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        myref.child("flats").child(getFlatID()).child("messages").push().setValue(dtf.format(now) + " " + LoggedInUser.getFullname() + ": " + message);
    }

    @Override
    public String getCity() {
        return flat.getCity();
    }

    @Override
    public String getCountry() {
        return flat.getCountry();
    }

    @Override
    public String getAddress() {
        return flat.getAddress();
    }

    @Override
    public void getTenants(RecyclerView recyclerView) {
        Query query = myref
                .child("flats").child(getFlatID()).child("tenants")
                .limitToLast(50);
        FirebaseRecyclerOptions<Flatmate> options = new FirebaseRecyclerOptions.Builder<Flatmate>()
                .setQuery(query, Flatmate.class).build();
        FirebaseRecyclerAdapter<Flatmate, ContactsAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<Flatmate, ContactsAdapter.ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position, @NonNull Flatmate model) {
                        holder.getName().setText(model.getFullname());
                        holder.getMoneySpent().setText(model.getMoneyspent()+"");


                    }

                    @NonNull
                    @Override
                    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlecontact, parent, false);
                        return new ContactsAdapter.ViewHolder(v);
                    }
                };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void getEvents(RecyclerView recyclerView) {
        Query query = myref
                .child("flats").child(getFlatID()).child("events")
                .limitToLast(50);
        FirebaseRecyclerOptions<Event> options = new FirebaseRecyclerOptions.Builder<Event>()
                .setQuery(query, Event.class).build();
        FirebaseRecyclerAdapter<Event, EventAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<Event, EventAdapter.ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position, @NonNull Event model) {
                        holder.getTitle().setText(model.getTitle());
                        holder.getDesc().setText(model.getDescription());
                        holder.getTime().setText(model.getTime());
                        holder.getOrganizer().setText(model.getOrganiser());
                        holder.getDelete().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                deleteEvent(model.getTitle(),model.getDescription());
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleevent, parent, false);
                        return new EventAdapter.ViewHolder(v);
                    }
                };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void deleteEvent(String title, String description) {
        myref.child("flats").child(getFlatID()).child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    if (snapshot1.getValue(Event.class).getDescription().equals(description)&&snapshot1.getValue(Event.class).getTitle().equals(title)) {
                        snapshot1.getRef().setValue(null);
                        return;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Getting chores error", error.getDetails());
            }
        });
    }


    public String getFlatID() {
        return flatID;
    }

    public String getFlatmateID() {
        return flatmateID;
    }
}
