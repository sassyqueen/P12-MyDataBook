package democooldrawer.android.myapplicationdev.com.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {

    AlertDialog.Builder dialog;
    AlertDialog alertDialog;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference vaccinationRef;


    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.vaccinationfragment, container, false);
        Button btnEdit = (Button)view.findViewById(R.id.btnFragVaccination);
        final TextView tvVac = (TextView)view.findViewById(R.id.tvFragVac);


        firebaseDatabase = FirebaseDatabase.getInstance();
        vaccinationRef = firebaseDatabase.getReference("/Vaccination");

        vaccinationRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String vac = dataSnapshot.getValue(String.class);
                tvVac.setText(vac);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater2 = (LayoutInflater)
                        getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout passPhrase =
                        (LinearLayout) inflater2.inflate(R.layout.passphrase, null);
                final EditText etPassphrase = (EditText) passPhrase
                        .findViewById(R.id.editTextPassPhrase);


                dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Edit your Vaccination").setView(passPhrase).setCancelable(false)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                vaccinationRef.setValue(etPassphrase.getText().toString());
                            }
                        }).setNegativeButton("Cancel", null);
                alertDialog = dialog.create();
                alertDialog.show();

            }
        });
        return view;
    }

}
