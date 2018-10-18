package com.example.jay.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText UID = (EditText) findViewById(R.id.E_UID);
        final EditText password = (EditText) findViewById(R.id.E_password);
        final Button login =(Button) findViewById(R.id.B_login);
        final TextView RegisterLink = (TextView) findViewById(R.id.T_register);

        RegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(login.this,register.class);
                login.this.startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tag", "onClick: done");
                String spass= password.getText().toString();
                int sUID = Integer.parseInt(UID.getText().toString());
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("tag", "response recieved");
                            JSONObject j =new JSONObject(response);
                            if(j.getString("status").equals("success"))
                            {
                                Log.d("tag", "success");
                                String rname=j.getString("name");
                                int rUID=j.getInt("UID");
                                Intent intent=new Intent(login.this,userarea.class);
                                intent.putExtra("name",rname);
                                intent.putExtra("UID",rUID);
                                startActivity(intent);
                            }
                            else if(j.getString("status").equals("fail")){
                                Log.d("tag", "fail");
                                Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginrequest =new LoginRequest(listener,sUID,spass);
                RequestQueue queue = Volley.newRequestQueue(com.example.jay.login.login.this);
                queue.add(loginrequest);
            }
        });

    }
}
