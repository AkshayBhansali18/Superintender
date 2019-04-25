package com.example.superintender;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.superintender.Login.LoginActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private ArrayList<String> names = new ArrayList<>();
    String testArray[] = new String[5];
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<Integer> images = new ArrayList<>();
    CollectionReference officers;
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        addnames();

    }

    private void addnames() {
        officers=db.collection("officers");
        officers.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot queryDocumentSnapshot:queryDocumentSnapshots)
                {
                    Namesclass namesclass=queryDocumentSnapshot.toObject(Namesclass.class);
                    names.add(namesclass.getName());
                }
                images.add(R.drawable.ic_archive_black_24dp);
                images.add(R.drawable.ic_announcement_black_24dp);
                Officers_adapter adapter=new Officers_adapter(names,images,MainActivity.this);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(MainActivity.this,Map.class);
                        startActivity(intent);

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        {
            Intent intent=new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }
    }
}
