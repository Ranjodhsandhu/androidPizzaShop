package com.example.pizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Pasta extends AppCompatActivity {

    CheckBox cb,cb3,cb4;
    Button b1,b2;
    LoginDataBaseAdapter loginDataBaseAdapter;
    String username;
    String orderDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);

        final Intent intent = getIntent();
        username = intent.getStringExtra("username");
        orderDesc = "";
        //dataBaseHelper = new DataBaseHelper(getApplicationContext());
        loginDataBaseAdapter = new LoginDataBaseAdapter(getApplicationContext());
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        cb = findViewById(R.id.checkBox3);
        cb3 = findViewById(R.id.checkBox7);
        cb4 = findViewById(R.id.checkBox8);


        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Pasta.this,MainActivity.class);
                intent1.putExtra("username",username);
                startActivity(intent1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserSelection();
                loginDataBaseAdapter.addOrder("Pasta",orderDesc,username);
                Toast.makeText(Pasta.this,"Item Added with "+orderDesc,Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(Pasta.this,MainActivity.class);
                intent2.putExtra("username",username);
                startActivity(intent2);
                finish();
            }
        });
    }
    public void getUserSelection(){
        orderDesc = "";
        if(cb.isChecked()){
            orderDesc += cb.getText();
        }
        if(cb3.isChecked()){
            orderDesc += cb3.getText();
        }
        if(cb4.isChecked()){
            orderDesc += cb4.getText();
        }
        Toast.makeText(Pasta.this, "Desc "+orderDesc, Toast.LENGTH_SHORT).show();

    }

}
