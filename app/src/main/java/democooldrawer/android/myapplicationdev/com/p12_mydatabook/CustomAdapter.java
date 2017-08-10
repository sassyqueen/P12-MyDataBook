package democooldrawer.android.myapplicationdev.com.p12_mydatabook;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15004557 on 10/8/2017.
 */

public class CustomAdapter extends ArrayAdapter {

    private ArrayList<NavigationDrawer> nd;
   // private String[] strObjects;
    private Context context;
    private TextView tvItemName;
    private ImageView ivIcon;

    public CustomAdapter(Context context, int resource, ArrayList<NavigationDrawer> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        nd = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvItemName = (TextView) rowView.findViewById(R.id.itemName);
        // Get the ImageView object
        ivIcon = (ImageView) rowView.findViewById(R.id.icon);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        NavigationDrawer currentItem = nd.get(position);
        // Set the TextView to show the food

        tvItemName.setText(currentItem.getNavListName());
        // Set the image to star or nostar accordingly
        if (currentItem.getItemNumber() == 0){

            ivIcon.setImageResource(android.R.drawable.ic_dialog_info);

        }
        else if(currentItem.getItemNumber() == 1){

            ivIcon.setImageResource(android.R.drawable.ic_menu_edit);

        }else if (currentItem.getItemNumber() == 2){

            ivIcon.setImageResource(android.R.drawable.ic_menu_my_calendar);

        }
        else if (currentItem.getItemNumber() == 3){

            ivIcon.setImageResource(android.R.drawable.btn_star_big_on);

        }
        return rowView;
    }

}
