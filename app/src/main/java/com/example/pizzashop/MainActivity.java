package com.example.pizzashop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.pizzashop.Pizza;
import com.example.pizzashop.R;

public class MainActivity extends Activity {

    private Button button1,button2,button3,button4,button5,button6,button7;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         *Each activity must have a corresponding layout XML file
         */
        setContentView(R.layout.activity_main);// activity_main is corresponding XML file
        final Intent intent = getIntent();
        username = intent.getStringExtra("username");
        /*
         * Initializing button XML button id. findViewById is a method which
         * helps to initialize with particular id. btn_go_to_another_activity is
         * a button name which I have given in XML file
         */
        button1 = (Button) findViewById(R.id.bPizza);
        button2 = (Button) findViewById(R.id.bCalzones);
        button3 = (Button) findViewById(R.id.bPasta);
        button4 = (Button) findViewById(R.id.bWings);
        button5 = (Button) findViewById(R.id.bFries);
        button6 = (Button) findViewById(R.id.bPop);
        button7 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(MainActivity.this, Pizza.class);
                 intent.putExtra("username",username);
                startActivity(intent); // startActivity allow you to move
            }
        });

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(MainActivity.this, Calzones.class);
                intent.putExtra("username",username);
                 startActivity(intent); // startActivity allow you to move
            }
        });

        button3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(MainActivity.this, Pasta.class);
                intent.putExtra("username",username);
                 startActivity(intent); // startActivity allow you to move
            }
        });

        button4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(MainActivity.this,ChikenWings.class);
                intent.putExtra("username",username);
                 startActivity(intent); // startActivity allow you to move
            }
        });

        button5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(MainActivity.this, FrenchFries.class);
                intent.putExtra("username",username);
                startActivity(intent); // startActivity allow you to move
            }
        });

        button6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(MainActivity.this, SodaPop.class);
                intent.putExtra("username",username);
                startActivity(intent); // startActivity allow you to move
            }
        });
        button7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */Intent intent = new Intent(MainActivity.this, ViewOrders.class);
                intent.putExtra("username",username);
                startActivity(intent); // startActivity allow you to move
            }
        });
    }

}