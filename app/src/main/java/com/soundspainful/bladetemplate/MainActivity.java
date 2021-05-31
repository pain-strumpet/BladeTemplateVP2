package com.soundspainful.bladetemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vuzix.hud.actionmenu.ActionMenuActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends ActionMenuActivity {

    private MenuItem HelloMenuItem;
    private MenuItem VuzixMenuItem;
    private MenuItem BladeMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* This is a Blade Template
        *  The initial version is from the Sample App
        *
        * This is a Blade Template -- File Spawner
        * When this app is activated, it will check
        * the existing file list for content, then
        * fill the directory to twenty mock files.*/

        mockFiles();

    }

    private void mockFiles() {
        String path = getExternalFilesDir(null).toString();
        File directory = new File(path);
        File[] files = directory.listFiles();
        if (files.length<50) {
            for (int i=0; i<50; i++) {
                String fileName = "MockFile: " + i +".txt";
                String fileBody = getString(R.string.placeholder_text);
                File file = new File(path, fileName);
                FileWriter bladeWriter = null;
                Date date = Calendar.getInstance().getTime();
                DateFormat formatter = new SimpleDateFormat("dd MMM yyyy, HH:mm a");
                String timeStamp = formatter.format(date);
                String addText = "***\n" + timeStamp + "\n" + fileBody + "\n**";
                try {
                    bladeWriter = new FileWriter(file, true);
                    bladeWriter.write(addText);
                    bladeWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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