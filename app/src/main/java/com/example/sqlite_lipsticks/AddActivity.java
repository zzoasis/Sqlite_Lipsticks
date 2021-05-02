package com.example.sqlite_lipsticks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText name_input, company_input, price_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.name_input);
        company_input = findViewById(R.id.company_input);
        price_input = findViewById(R.id.price_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(com.example.sqlite_lipsticks.AddActivity.this);
                myDB.addLipstick(name_input.getText().toString().trim(),
                        company_input.getText().toString().trim(),
                        Integer.valueOf(price_input.getText().toString().trim()));
            }
        });
    }
}
