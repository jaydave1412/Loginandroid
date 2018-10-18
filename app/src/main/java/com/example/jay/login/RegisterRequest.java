package com.example.jay.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String URL = "http://192.168.43.169/android/register.php";
    private Map<String,String> params;
    public RegisterRequest(int UID,String name,String password, Response.Listener<String> listener) {
        super(Method.POST,URL,listener,null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("password",password);
        params.put("UID",UID+"");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
