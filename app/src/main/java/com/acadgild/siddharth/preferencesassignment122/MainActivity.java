package com.acadgild.siddharth.preferencesassignment122;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static final String mypreferences="mypref";
    public static final String Name="nameKey";
    public static final String Age="ageKey";
    public static final String Pno = "phoneKey";
    public static final String City = "cityKey";
    EditText e1,e2,e3,e4;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.age);
        e3 = (EditText) findViewById(R.id.pno);
        e4 = (EditText) findViewById(R.id.city);
        b1 = (Button) findViewById(R.id.Save);
        b2 = (Button) findViewById(R.id.show);
        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(Name) && sharedPreferences.contains(Age) && sharedPreferences.contains(Pno) && sharedPreferences.contains(City))
        {

        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save(view);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Get(view);
            }
        });
    }
        public void Save(View v)
        {
            String nm = e1.getText().toString();
            String ag = e2.getText().toString();
            String pn = e3.getText().toString();
            String city = e4.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Name,nm);
            editor.putString(Age,ag);
            editor.putString(Pno,pn);
            editor.putString(City,city);
            editor.commit();
        }

        public void Get(View v)
        {
            String nm = e1.getText().toString();
            String ag = e2.getText().toString();
            String pn = e3.getText().toString();
            String city = e4.getText().toString();

            if(sharedPreferences.contains(Name) && sharedPreferences.contains(Age) && sharedPreferences.contains(Pno) && sharedPreferences.contains(City))
            {
                Toast.makeText(MainActivity.this,"Name : "+sharedPreferences.getString(Name,"")+"\nAge : "+sharedPreferences.getString(Age,"")+"\nPno : "+sharedPreferences.getString(Pno,"")+"\nCity : "+sharedPreferences.getString(City,""),Toast.LENGTH_LONG).show();
            }


        }
}
