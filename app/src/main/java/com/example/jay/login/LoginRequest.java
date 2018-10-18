package com.example.jay.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String URL = "http://192.168.43.169/android/login.php";
    private Map<String,String> params;
    public LoginRequest(Response.Listener<String> listener,int UID,String password) {
        super(Method.POST, URL, listener, null);
        params=new HashMap<>();
        params.put("UID",UID+"");
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
