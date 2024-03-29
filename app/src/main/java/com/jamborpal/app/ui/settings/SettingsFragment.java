package com.jamborpal.app.ui.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jamborpal.app.R;
import com.jamborpal.app.ui.login.LoginHandler;

public class SettingsFragment extends Fragment {
    private SettingsViewModel settingsViewModel;
    private TextView number;
    private String phone = "";
    private TextView email;
    private String Email = "";
    private TextView pass;
    private TextView land_email;
    private String land_e = "";
    private TextView land_phone;
    private String land_p = "";
    private String Pass = "";
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        root = inflater.inflate(R.layout.fragment_settings, container, false);
        number = root.findViewById(R.id.change_phone);
        email = root.findViewById(R.id.change_email);
        pass = root.findViewById(R.id.change_pass);
        land_email = root.findViewById(R.id.change_landlord_email);
        land_phone = root.findViewById(R.id.change_landlord_phone);
        setEmailListener();
        setPassListener();
        setPhoneListener();
        setDeleteFlatListener();
        setDeleteProfileListener();
        setLand_emailListener();
        setLand_phoneListener();
        Logout(root);
        return root;
    }

    public void Logout(View v) {
        final Button logout = v.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginHandler.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void setLand_phoneListener() {
        land_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("New phone number for the landlord");

                final EditText input = new EditText(root.getContext());
                input.setInputType(InputType.TYPE_CLASS_PHONE);
                builder.setView(input);

                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!(input.getText().toString().equals(""))) {
                            land_p = input.getText().toString();
                            settingsViewModel.saveLandPhone(land_p);
                            Toast.makeText(getContext(), "Phone number changed successfully", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "Try again, provide a phone number", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void setLand_emailListener() {
        land_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("New email for the landlord");

                final EditText input = new EditText(root.getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!(input.getText().toString().equals(""))) {
                            land_e = input.getText().toString();
                            settingsViewModel.saveLandEmail(land_e);
                            Toast.makeText(getContext(), "Email changed successfully", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "Try again, provide an email", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void setPhoneListener() {
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("New phone number");

                final EditText input = new EditText(root.getContext());
                input.setInputType(InputType.TYPE_CLASS_PHONE);
                builder.setView(input);

                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!(input.getText().toString().equals(""))) {
                            phone = input.getText().toString();
                            settingsViewModel.SavePhone(phone);
                            Toast.makeText(getContext(), "Phone number changed successfully", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "Try again, provide a phone number", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void setEmailListener() {
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("New email address");

                final EditText input = new EditText(root.getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (input.getText().toString().contains("@")) {
                            Email = input.getText().toString();
                            settingsViewModel.SaveEmail(Email);
                            Toast.makeText(getContext(), "Email changed successfully", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "Try again, provide a valid email", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void setPassListener() {
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("New password");


                LinearLayout layout = new LinearLayout(root.getContext());
                layout.setOrientation(LinearLayout.VERTICAL);

                final EditText password1 = new EditText(root.getContext());
                password1.setHint("Password");
                layout.addView(password1);


                final EditText password = new EditText(root.getContext());
                password.setHint("Repeat password");
                layout.addView(password);

                builder.setView(layout);

                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (password.getText().toString().equals(password1.getText().toString())) {
                            Pass = password.getText().toString();
                            settingsViewModel.SavePassword(Pass);
                            Toast.makeText(getContext(), "Password changed successfully", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), "Try again, passwords did not match", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void setDeleteProfileListener() {
        Intent intent = new Intent(getActivity(), LoginHandler.class);
        final Button deleteProf = root.findViewById(R.id.delete_profile);
        deleteProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(root.getContext())
                        .setTitle("Delete profile")
                        .setMessage("Are you sure you want to delete this profile?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                settingsViewModel.deleteProfile();
                                startActivity(intent);
                                getActivity().finish();
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

    }

    private void setDeleteFlatListener() {
        Intent intent = new Intent(getActivity(), LoginHandler.class);
        final Button deleteFlat = root.findViewById(R.id.delete_flat);
        deleteFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(root.getContext())
                        .setTitle("Delete flat")
                        .setMessage("Are you sure you want to delete this flat?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                settingsViewModel.deleteFlat();
                                startActivity(intent);
                                getActivity().finish();
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

    }


}
