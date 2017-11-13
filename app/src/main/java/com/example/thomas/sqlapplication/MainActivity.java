package com.example.thomas.sqlapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextView registerlink = (TextView) findViewById(R.id.txtRegisterHere);

        registerlink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerIntent = new Intent(MainActivity.this,Register.class);
                MainActivity.this.startActivity(registerIntent);


            }
        });
    }
}
