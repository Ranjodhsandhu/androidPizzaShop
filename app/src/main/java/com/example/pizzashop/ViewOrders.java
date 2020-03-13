package com.example.pizzashop;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewOrders extends AppCompatActivity {

    ListView listView;
    String username;
    LoginDataBaseAdapter loginDataBaseAdapter;
    Button checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);
        final Intent intent = getIntent();
        username = intent.getStringExtra("username");

        loginDataBaseAdapter = new LoginDataBaseAdapter(getApplicationContext());
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        listView = (ListView) findViewById(R.id.listView);
        checkout = (Button) findViewById(R.id.checkout);

        ArrayList<String> list = new ArrayList<>();

        Cursor c = loginDataBaseAdapter.getOrder(username);

        if(c.getCount()>0){
            while(c.moveToNext()){
                list.add(c.getString(1));
            }
        }else{
            Toast.makeText(ViewOrders.this,"No Order to checkout ",Toast.LENGTH_LONG).show();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ViewOrders.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = loginDataBaseAdapter.deleteOrder(username);
                Toast.makeText(ViewOrders.this,"Checkout Successful for "+count+" items",Toast.LENGTH_LONG).show();
                Intent intent3= new Intent(ViewOrders.this,MainActivity.class);
                intent3.putExtra("username",username);
                startActivity(intent3);
            }
        });
    }

}
