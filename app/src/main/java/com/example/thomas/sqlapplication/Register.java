package com.example.thomas.sqlapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText txtFirstName = (EditText)findViewById(R.id.txtFirstName);
        final EditText txtLastName = (EditText)findViewById(R.id.txtLastName);
        final EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        final EditText txtPassword  = (EditText)findViewById(R.id.txtPassword);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String FirstName = txtFirstName.getText().toString();
                final String LastName = txtLastName.getText().toString();
                final String Email = txtEmail.getText().toString();
                final String Password = txtPassword.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>(){


                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(Register.this, MainActivity.class);
                                Register.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(FirstName, LastName, Email, Password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);

            }
        });
    }
}
