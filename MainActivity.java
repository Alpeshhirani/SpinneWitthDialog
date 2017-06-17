package com.exaple.dialogandspinner;

import android.app.Dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    ArrayList<String> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        array.add(0, "alpesh");
        array.add(1, "mehul");
        spinner = (Spinner) findViewById(R.id.spinner);
//        Forgot_password_dialog();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" + array.get(position), Toast.LENGTH_SHORT).show();
                if (position > 0) {

                } else {

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.spinnerblack, array) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
//                if (position == 0) {
//                    ((TextView) v).setText("Select");
//
//                } else {
                ((TextView) v).setText(array.get(position));
//                }
                return v;
            }

            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
//                if (position == 0) {
//                    ((TextView) v).setText("Select");
//                } else {
                ((TextView) v).setText(array.get(position));
//                }

                return v;
            }
        };

        adapter.setDropDownViewResource(R.layout.spinnerblack);

        spinner.setAdapter(adapter);
    }

    protected void Forgot_password_dialog() {

        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_xml);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        width = width - 100;
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

        lp.copyFrom(dialog.getWindow().getAttributes());

        lp.width = width;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.getWindow().setAttributes(lp);

        dialog.show();

    }

}
