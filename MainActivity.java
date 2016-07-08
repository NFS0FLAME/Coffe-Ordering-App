package com.example.programmershub.ordercofee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView quantity , ordersummary ;
    public EditText name ;
    public Button plus , minus , order ;
    public CheckBox wippedcream , chocolate ;

    int numberOfCups = 0 , price = 5 , total = 0 , costOfWippedCream = 1 , costOfChocolate = 2 ;
    boolean c ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   REFERRANCE CREATED

        quantity = (TextView) findViewById(R.id.quantity) ;
        ordersummary = (TextView) findViewById(R.id.ordersummary) ;

        plus = (Button) findViewById(R.id.plus) ;
        minus = (Button) findViewById(R.id.minus) ;
        order = (Button) findViewById(R.id.order) ;

        name = (EditText) findViewById(R.id.name) ;

        wippedcream = (CheckBox) findViewById(R.id.wippedcream) ;
        chocolate = (CheckBox) findViewById(R.id.chocolate) ;

        // setting on click listner

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberOfCups++ ;

                quantity.setText(String.valueOf(numberOfCups));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(numberOfCups == 0){
                    numberOfCups = 0 ;
                    quantity.setText(numberOfCups);
                }else{
                    numberOfCups-- ;
                    quantity.setText(String.valueOf(numberOfCups));
                }

            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = name.getText().toString() ;

                if(wippedcream.isChecked() && chocolate.isChecked()){
                    price = price + costOfChocolate +costOfWippedCream ;
                    total = numberOfCups * price ;

                    String value = n ;
                    value = value + "\nPrice : Rs." + total ;
                    value = value + "\nWith WIPPED CREAM and CHOCOLATE." ;
                    value = value + "\nThanks Come Again!!" ;
                    ordersummary.setText(String.valueOf(value));

                }else if(wippedcream.isChecked()){
                    price = price + costOfWippedCream ;
                    total = numberOfCups * price ;

                    String value = n ;
                    value = value + "\nPrice : Rs." + total ;
                    value = value + "\nWith WIPPER CREAM." ;
                    value = value + "\nThanks Come Again!!" ;
                    ordersummary.setText(String.valueOf(value));

                }else if(chocolate.isChecked()){
                    price = price + costOfChocolate ;
                    total = numberOfCups * price ;

                    String value = n ;
                    value = value + "\nPrice : Rs." + total ;
                    value = value + "\nWith CHOCOLATE." ;
                    value = value + "\nThanks Come Again!!" ;
                    ordersummary.setText(String.valueOf(value));

                }else{
                    total = numberOfCups * price ;

                    String value = n ;
                    value = value + "\nPrice : Rs." + total ;
                    value = value + "\nThanks Come Again!!" ;
                    ordersummary.setText(String.valueOf(value));
                }


            }
        });



    }
}
