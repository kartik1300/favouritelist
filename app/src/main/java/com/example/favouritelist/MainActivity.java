package com.example.favouritelist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView myrecyclerview;
private CategoryManager mcategorymanager=new CategoryManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Category>categories=mcategorymanager.retrievecategory();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayCreateCategoryDialog();

            }
        });

    myrecyclerview=findViewById(R.id.category_listrecyclerview);
    myrecyclerview.setAdapter(new CategoryRecyclerAdapter(categories));
    myrecyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayCreateCategoryDialog(){
        String alertTitle="Enter the name of category";
        String positivebuttontitle="Create";
        AlertDialog.Builder alertbuilder=new AlertDialog.Builder(this);
        final EditText categoryedit=new EditText(this);
        categoryedit.setInputType(InputType.TYPE_CLASS_TEXT);
        alertbuilder.setTitle(alertTitle);
        alertbuilder.setView(categoryedit);
        alertbuilder.setPositiveButton(positivebuttontitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Category category=new Category(categoryedit.getText().toString(),new ArrayList<String>());
                mcategorymanager.setCategory(category);
                CategoryRecyclerAdapter categoryRecyclerAdapter=(CategoryRecyclerAdapter) myrecyclerview.getAdapter();
                categoryRecyclerAdapter.addCategory(category);

                dialog.dismiss();

            }
        });
        alertbuilder.show();
        

    }
}