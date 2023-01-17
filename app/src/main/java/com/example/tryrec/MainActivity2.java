package com.example.tryrec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity2 extends AppCompatActivity {

    TextView signup;
    BottomSheetDialog diyalog;
    View B;
    ImageFilterView add_picture;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        signup =findViewById(R.id.signup);


        signup.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                diyalog =new BottomSheetDialog(MainActivity2.this , R.style.BottomSheetDialogTheme);
                B = LayoutInflater.from(v.getContext())
                        .inflate(R.layout.layoutproduct,
                                (LinearLayout)v.findViewById(R.id.llm));
                diyalog.setContentView(B);

                diyalog.show();
            }
        });
    }
}