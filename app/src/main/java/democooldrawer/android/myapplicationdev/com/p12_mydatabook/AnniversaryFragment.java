package democooldrawer.android.myapplicationdev.com.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnniversaryFragment extends Fragment {

    AlertDialog.Builder dialog;
    AlertDialog alertDialog;
    Context context;
    String text;

    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.anniversaryfragment, container, false);
        Button btnEdit = (Button)view.findViewById(R.id.btnFragAnniversary);
        final TextView tvAnniv = (TextView)view.findViewById(R.id.tvFragAnniv);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater2 = (LayoutInflater)
                        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout passPhrase =
                        (LinearLayout) inflater2.inflate(R.layout.passphrase, null);
                final EditText etPassphrase = (EditText) passPhrase
                        .findViewById(R.id.editTextPassPhrase);


                dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Edit your anniversary").setView(passPhrase).setCancelable(false)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvAnniv.setText(etPassphrase.getText().toString());
                            }
                        }).setNegativeButton("Cancel", null);
                alertDialog = dialog.create();
                alertDialog.show();
            }
        });

        return view;
    }

}
