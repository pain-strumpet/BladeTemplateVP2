package com.soundspainful.bladetemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vuzix.hud.actionmenu.ActionMenuActivity;

public class MainActivity extends ActionMenuActivity {

    private MenuItem HelloMenuItem;
    private MenuItem VuzixMenuItem;
    private MenuItem BladeMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected boolean onCreateActionMenu(Menu menu) {
        super.onCreateActionMenu(menu);

        getMenuInflater().inflate(R.menu.menu, menu);

        HelloMenuItem = menu.findItem(R.id.item1);
        VuzixMenuItem = menu.findItem(R.id.item2);
        BladeMenuItem = menu.findItem(R.id.item3);
        updateMenuItems();

        return true;
    }

    @Override
    protected boolean alwaysShowActionMenu() {
        return false;
    }

    private void updateMenuItems() {
        if (HelloMenuItem == null) {
            return;
        }

        VuzixMenuItem.setEnabled(false);
        BladeMenuItem.setEnabled(false);
    }


    //Action Menu Click events
    //This events where register via the XML for the menu definitions.
    public void showHello(MenuItem item){
        // Set the click listener for the button.
        showToast("Hello World!");
        VuzixMenuItem.setEnabled(true);
        BladeMenuItem.setEnabled(false);
    }

    public void showVuzix(MenuItem item){
        showToast("Vuzix!");
    }

    public void showBlade(MenuItem item){
        showToast("Blade");
    }

    private void showToast(final String text){

        final Activity activity = this;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}