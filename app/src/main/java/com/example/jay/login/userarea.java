package com.example.jay.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class userarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userarea);
        final EditText UID = (EditText) findViewById(R.id.E_UID);
        final EditText name = (EditText) findViewById(R.id.E_name);
        Intent i=getIntent();
        String j=i.getStringExtra("name");
        String s=i.getIntExtra("UID",0)+"";
        UID.setText(s);
        name.setText(j);
    }
}
