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

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn = (Button) findViewById(R.id.popupBtn);
        TextView textView = (TextView) findViewById(R.id.contextView);

        // sætter knappen til at have en popup menu
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
        registerForContextMenu (textView);
    }

    // opretter options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // opretter context menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    // Click-events til options menu
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.help) {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    // Click-events til context menu
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            // action
            return true;
        } else if (id == R.id.item2) {
            // action
            return true;
        } else if (id == R.id.item3) {
            // action
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }


    // Click-events til popup menu
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.help) {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else return false;

    }

    // click events til group items i popup menuen
    public void onGroupItemClick(MenuItem item) {
        Button button = findViewById(R.id.popupBtn);
        int id = item.getItemId();

        if (id == R.id.groupPopup1) {
            button.setBackgroundColor(getColor(R.color.pink));
        }
        if (id == R.id.groupPopup2) {
            button.setBackgroundColor(getColor(R.color.black));
        }
    }
}