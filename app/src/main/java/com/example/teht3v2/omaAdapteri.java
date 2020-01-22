package com.example.teht3v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

public class omaAdapteri extends ArrayAdapter<Date> {

    private int line_layout;
    private int textviewid;
    private ArrayList<Date> lista;
    private LayoutInflater inflater;
    private Context context;

    public omaAdapteri(@NonNull Context context,
                       int resource,
                       int textViewResourceId,
                       @NonNull ArrayList<Date> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        line_layout = resource;
        textviewid = textViewResourceId;
        lista = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View v;
        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.listatemplate, parent, false);
            ((TextView)v.findViewById(R.id.textView)).setText(lista.get(position).toString());
            v.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lista.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
        else {
            v = convertView;
        }

        return v;


    }

    public class ViewHolder {
        private TextView textView;
        private Button button;

        public ViewHolder(View v){
            textView = v.findViewById(textviewid);
            button = v.findViewById(R.id.button2);
        }
    }
}
