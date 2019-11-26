package com.example.akhilesh.admincheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button login;
EditText mail,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 mail=findViewById(R.id.edit1);
 password=findViewById(R.id.editText);

        login = (Button) findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mail.getText().toString();
                String pass=password.getText().toString();
                if(email.equals("sportscommittee@snu.edu.in")&&pass.equals("snusports"))
                launchActivity();
            else
                    Toast.makeText(MainActivity.this,"Wrong emailId/Password ",Toast.LENGTH_LONG).show();

            }

        });
    }
private void launchActivity(){

            Intent intent=new Intent(this,category.class);
startActivity(intent);        }


    }




