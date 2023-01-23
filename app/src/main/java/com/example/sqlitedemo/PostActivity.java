package com.example.sqlitedemo;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    EditText location, sublessor, duration, description;
    Button back, submit;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        location = findViewById(R.id.location);
        sublessor = findViewById(R.id.sublessor);
        duration = findViewById(R.id.duration);
        description = findViewById(R.id.description);
        back = findViewById(R.id.back);
        submit = findViewById(R.id.submit);
        DB = new DBHelper(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loca = location.getText().toString();
                String subl = sublessor.getText().toString();
                String dura = duration.getText().toString();
                String desc = description.getText().toString();

                if (TextUtils.isEmpty(loca) || TextUtils.isEmpty(subl) || TextUtils.isEmpty(dura) || TextUtils.isEmpty(desc))
                    Toast.makeText(PostActivity.this, "All Fields Required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert =  DB.insertSublet(loca,subl,dura,desc);
                    if (insert == true) {
                        Toast.makeText(PostActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(PostActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

}
