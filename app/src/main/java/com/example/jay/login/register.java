package com.example.jay.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText name=(EditText) findViewById(R.id.E_name);
        final EditText UID = (EditText) findViewById(R.id.E_UID);
        final EditText password = (EditText) findViewById(R.id.E_password);
        final Button register= (Button) findViewById(R.id.B_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname= name.getText().toString();
                String spass= password.getText().toString();
                int sUID = Integer.parseInt(UID.getText().toString());
                Response.Listener<String> listener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("msg", "onResponse: response recieved ");
                            JSONObject j = new JSONObject(response);
                            if(j.getString("status").equals("yes"))
                                Toast.makeText(register.this, "Success", Toast.LENGTH_SHORT).show();
                            else Toast.makeText(register.this, "fail", Toast.LENGTH_SHORT).show();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest request = new RegisterRequest(sUID,sname,spass,listener);
                RequestQueue queue = Volley.newRequestQueue(com.example.jay.login.register.this);
                queue.add(request);
            }
        });

    }
}
