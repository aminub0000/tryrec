package com.example.tryrec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewlist;
    ProcustAdapter carteadapter;
    ArrayList<products> li = new ArrayList<products>();
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference() ;
    FirebaseStorage firestore= FirebaseStorage.getInstance();
    StorageReference storageRef =firestore.getReference();
    String nom;
    String prix;
    String categorie;
    String img;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(MainActivity.this, test.class);
                resultIntent.putParcelableArrayListExtra("QuestionsExtra", (ArrayList<? extends Parcelable>)li);
                startActivity(resultIntent);
            }
        });
        li.add(new products("img1","nom1","categorie","prix",1));
        li.add(new products("img2","nom2","categorie","prix",1));
        li.add(new products("img3","nom3    ","categorie","prix",1));
        recyclerViewlist=findViewById(R.id.rec);
        recyclerViewlist.setHasFixedSize(true);
        recyclerViewlist.setLayoutManager(new LinearLayoutManager(this));
        carteadapter =new ProcustAdapter(li,this);
        recyclerViewlist.setAdapter(carteadapter);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerViewlist);
        carteadapter.notifyDataSetChanged();
    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            li.remove(viewHolder.getAdapterPosition());
            carteadapter.notifyDataSetChanged();
        }
    };
}