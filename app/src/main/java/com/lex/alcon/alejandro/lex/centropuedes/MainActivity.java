package com.lex.alcon.alejandro.lex.centropuedes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ingresar(View view)
    {
        Intent intent=new Intent(this,ModuleActivity.class);
        startActivity(intent);
    }
    public void register(View view)
    {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    public void govideo(View view)
    {
        Intent intent=new Intent(this,VideoActivity.class);
        startActivity(intent);
    }

}
