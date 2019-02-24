package com.example.favcontacts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCall1, btnText1, btnCall2, btnText2, btnCall3, btnText3;
    TextView txtNumber1, txtNumber2, txtNumber3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupTextViews();
        SetupButtons();
        CallButtons();
        TextButtons();

    }

    public void SetupTextViews() {
        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        txtNumber3 = findViewById(R.id.txtNumber3);
    }

    public void SetupButtons() {
        btnCall1 = findViewById(R.id.btnCall1);
        btnCall2 = findViewById(R.id.btnCall2);
        btnCall3 = findViewById(R.id.btnCall3);
        btnText1 = findViewById(R.id.btnText1);
        btnText2 = findViewById(R.id.btnText2);
        btnText3 = findViewById(R.id.btnText3);
    }

    public void CallButtons() {
        btnCall1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + txtNumber1.getText().toString()));
                if (callIntent.resolveActivity(getPackageManager()) != null && ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    startActivity(callIntent);
                }
            }
        });

        btnCall2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + txtNumber2.getText().toString()));
                if (callIntent.resolveActivity(getPackageManager()) != null && ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    startActivity(callIntent);
                }
            }
        });

        btnCall3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + txtNumber3.getText().toString()));
                if (callIntent.resolveActivity(getPackageManager()) != null && ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    startActivity(callIntent);
                }
            }
        });
    }


    public void TextButtons(){
        btnText1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + txtNumber1.getText().toString()));
                sendIntent.putExtra("sms_body", "Hello");
                if(sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });

        btnText2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + txtNumber2.getText().toString()));
                sendIntent.putExtra("sms_body", "Hello");
                if(sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });

        btnText3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + txtNumber3.getText().toString()));
                sendIntent.putExtra("sms_body", "Hello");
                if(sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });
    }
}
