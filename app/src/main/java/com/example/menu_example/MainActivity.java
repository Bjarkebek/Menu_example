package com.example.menu_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // sætter knappen til at have en popup menu
        Button btn = (Button) findViewById(R.id.popupBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.popup_menu);


                popup.show();
            }
        });


        // sætter textView til at have context menu
        TextView textView = (TextView) findViewById(R.id.contextView);
        registerForContextMenu(textView);
    }

    // opretter options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // opretter context menu + adder items til menuen
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Item 1");
        menu.add(0, v.getId(), 0, "Item 2");
        menu.add(0, v.getId(), 0, "Item 3");
    }


    // Click-events til options menu
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.help) {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    // Click-events til context menu
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Item 1") {
            Toast.makeText(this, "Item 1 pressed", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getTitle() == "Item 2") {
            Toast.makeText(this, "Item 2 pressed", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getTitle() == "Item 3") {
            Toast.makeText(this, "Item 3 pressed", Toast.LENGTH_LONG).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }


    // Click-events til popup menu
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId() == R.id.help) {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else return false;

    }

    // click events til group items i popup menuen
    public void onGroupItemClick(MenuItem item) {
        Button button = findViewById(R.id.popupBtn);

        if (item.getItemId() == R.id.groupPopup1) {
            button.setBackgroundColor(getColor(R.color.pink));
        }
        if (item.getItemId() == R.id.groupPopup2) {
            button.setBackgroundColor(getColor(R.color.black));
        }
    }
}