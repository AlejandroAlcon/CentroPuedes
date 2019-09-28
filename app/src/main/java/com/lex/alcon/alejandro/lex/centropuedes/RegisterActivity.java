package com.lex.alcon.alejandro.lex.centropuedes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void register(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
