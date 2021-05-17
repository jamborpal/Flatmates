package com.jamborpal.app.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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
import com.jamborpal.app.login.LoginHandler;
import com.jamborpal.app.model.Chore;
import com.jamborpal.app.model.Event;
import com.jamborpal.app.model.Expense;
import com.jamborpal.app.model.Flatmate;
import com.jamborpal.app.ui.contact.ContactsAdapter;
import com.jamborpal.app.ui.events.EventAdapter;
import com.jamborpal.app.ui.home.CostAdapter;
import com.jamborpal.app.ui.home.OwnChoresAdapter;
import com.jamborpal.app.ui.messageboard.MessageAdapter;
import com.jamborpal.app.ui.tasks.TaskAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataStorageImpl implements DataStorage {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String flatID;
    private String flatmateID;
    private String flatAddress;
    private Flatmate flatmate;
    private Context context;


    public DataStorageImpl() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("flats");
    }

    private void setLoggedInUser(String id) {
        this.flatmateID = id;

    }

    private void setFlatUsed(String id) {
        this.flatID = id;
    }


    @Override
    public void retrieveUser(String username, String password) {

        try{
            myRef.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        for (DataSnapshot snapshot2 : snapshot1.child("tenants").getChildren()) {
                            Flatmate flatmateTemp = snapshot2.getValue(Flatmate.class);
                            if (flatmateTemp.getUsername().equals(username) && flatmateTemp.getPassword().equals(password)) {
                                flatmate = flatmateTemp;
                                flatAddress = (String) snapshot1.child("address").getValue() + "," +
                                        (String) snapshot1.child("city").getValue() + ","
                                        + (String) snapshot1.child("country").getValue();
                                setLoggedInUser(snapshot2.getKey());
                                setFlatUsed(snapshot1.getKey());
                                return;

                            }
                            else{

                            }
                        }

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addExpense(Expense expense) {
        double spent = expense.getPrice() + flatmate.getMoneyspent();
        flatmate.setMoneyspent(spent);
        myRef.child(flatID).child("expenses").push().setValue(expense);
        myRef.child(flatID).child("tenants").child(flatmateID).child("moneyspent").setValue(spent);

    }

    @Override
    public void addChore(Chore chore) {
        myRef.child(flatID).child("chores").child(chore.getChoreID()).setValue(chore);

    }

    @Override
    public void addEvent(Event event) {
        myRef.child(flatID).child("events").push().setValue(event);

    }

    @Override
    public void addMessage(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        myRef.child(flatID).child("messages").push().setValue(dtf.format(now) + " " + flatmate.getFullname() + ": " + message);

    }

    @Override
    public void deleteChore(String ChoreID) {
        myRef.child(flatID).child("chores").addValueEventListener(new ValueEventListener() {
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
    public void deleteEvent(String title, String description) {
        myRef.child(flatID).child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    if (snapshot1.getValue(Event.class).getDescription().equals(description) && snapshot1.getValue(Event.class).getTitle().equals(title)) {
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
    public String getFlatmateID() {
        return flatmateID;
    }

    @Override
    public String getAddress() {
        return flatAddress;
    }


    @Override
    public void assignChore(String choreID) {
        myRef.child(flatID).child("chores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                    System.out.println(snapshot1);
                    if (snapshot1.getKey().equals(choreID)) {
                        snapshot1.child("assignedto").getRef().setValue(flatmateID);
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
        Query query = myRef
                .child(flatID).child("chores").orderByChild("assignedto").equalTo("")
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
                                assignChore(model.getChoreID());
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
    public void getChoresByFlatmate(RecyclerView recyclerView) {
        Query query = myRef
                .child(flatID).child("chores").orderByChild("assignedto").equalTo(flatmateID)
                .limitToLast(50);
        FirebaseRecyclerOptions<Chore> options = new FirebaseRecyclerOptions.Builder<Chore>()
                .setQuery(query, Chore.class).build();
        FirebaseRecyclerAdapter<Chore, OwnChoresAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<Chore, OwnChoresAdapter.ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull OwnChoresAdapter.ViewHolder holder, int position, @NonNull Chore model) {
                        holder.getTitle().setText(model.getTitle());
                        holder.getDesc().setText(model.getDescription());
                        holder.getDone().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                deleteChore(model.getChoreID());
                            }
                        });
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
        Query query = myRef
                .child(flatID).child("expenses")
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
    public void getMessages(RecyclerView recyclerView) {
        Query query = myRef
                .child(flatID).child("messages")
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
    public void getTenants(RecyclerView recyclerView) {

        Query query = myRef
                .child(flatID).child("tenants")
                .limitToLast(50);
        FirebaseRecyclerOptions<Flatmate> options = new FirebaseRecyclerOptions.Builder<Flatmate>()
                .setQuery(query, Flatmate.class).build();
        FirebaseRecyclerAdapter<Flatmate, ContactsAdapter.ViewHolder> adapter =
                new FirebaseRecyclerAdapter<Flatmate, ContactsAdapter.ViewHolder>(options) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    protected void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position, @NonNull Flatmate model) {
                        holder.getName().setText(model.getFullname());
                        holder.getMoneySpent().setText(model.getMoneyspent() + "");
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + model.getPhonenumber()));
                        context.startActivity(intent);


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
        Query query = myRef
                .child(flatID).child("events")
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
                                deleteEvent(model.getTitle(), model.getDescription());
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
    public void giveContext(Context context) {
        this.context = context;
    }
}
