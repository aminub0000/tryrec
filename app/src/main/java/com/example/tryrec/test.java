package com.example.tryrec;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class test extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        ArrayList<products> object = new ArrayList<products>();
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        object = (ArrayList<products>) args.getSerializable("QuestionsExtra");
        Toast.makeText(this,String.valueOf(object.size()), Toast.LENGTH_SHORT).show();
    }
}
