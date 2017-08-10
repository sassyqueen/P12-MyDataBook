package democooldrawer.android.myapplicationdev.com.p12_mydatabook;

import android.widget.ImageView;

/**
 * Created by 15004557 on 10/8/2017.
 */

public class NavigationDrawer {
    private String navListName;
    private int itemNumber;


    public NavigationDrawer(String navListName, int itemNumber) {
        this.navListName = navListName;
        this.itemNumber = itemNumber;
    }

    public String getNavListName() {
        return navListName;
    }

    public void setNavListName(String navListName) {
        this.navListName = navListName;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}
