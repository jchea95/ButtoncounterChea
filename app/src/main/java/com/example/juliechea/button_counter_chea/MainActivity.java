package com.example.juliechea.button_counter_chea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // init objects
    private Button incrementButton;
    private Button decrementButton;
    private Button resetButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);
        resetButton = findViewById(R.id.resetButton);
        textView = findViewById(R.id.textView);

        if(savedInstanceState != null){

            textView.setText(savedInstanceState.getString("text"));
        }
        else{
            textView.setText("0");
        }

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("On create", "I clicked increment.");
                // make sure that convert to int, but update textView

                // grab str convert to int
                int intText = Integer.parseInt(textView.getText().toString());

                //increment
                intText++;

                // grab int convert to str
                textView.setText(String.valueOf(intText));

            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("On create", "I clicked decrement");

                // grab str convert to int
                int intText = Integer.parseInt(textView.getText().toString());

                //decrement
                intText--;

                // grab int convert to str
                textView.setText(String.valueOf(intText));
            }


        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("On create", "I clicked reset");

                textView.setText("0");

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // look at saveState example in github
        // use putString

        outState.putString("text", textView.getText().toString());
    }
}
