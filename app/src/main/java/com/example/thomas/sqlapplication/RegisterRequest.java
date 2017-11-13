package com.example.thomas.sqlapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by Thomas on 11/11/2017.
 */

public class RegisterRequest extends StringRequest{

    private static final String Register_Request_URL = "http://celtech-securty.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String FirstName, String LastName, String Email, String Password, Response.Listener<String> listener){
        super(Method.POST, Register_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("FirstName", FirstName);
        params.put("LastName", LastName);
        params.put("Email", Email);
        params.put("Password", Password);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
