package com.example.teht3v2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Date> lista = new ArrayList<>();
    private omaAdapteri adapter;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        adapter = new omaAdapteri(this, R.layout.listatemplate, R.id.textView, lista);
        ListView listview = findViewById(R.id.listView);
        listview.setAdapter(adapter);


        /*findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date aika = Calendar.getInstance().getTime();
                lista.add(aika);
                adapter.notifyDataSetChanged();
            }
        });*/
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Haluatko lisätä ajan?");

                builder.setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Date aika = Calendar.getInstance().getTime();
                        lista.add(aika);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("Ei", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }
}
