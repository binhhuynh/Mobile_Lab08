package com.se.mobile_lab08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FaceActivity extends AppCompatActivity {
    private static final String TAG = "";
    private ImageButton ibSadFace, ibBoredFace, ibSmileFace;
    private Button btnLogout;
    private DatabaseReference mDatabase;
    private User user;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");

        ibBoredFace = findViewById(R.id.ibBoredFace);
        ibSadFace = findViewById(R.id.ibSadFace);
        ibSmileFace = findViewById(R.id.ibSmileFace);

        btnLogout = findViewById(R.id.btnLogout);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase.child(currentUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ibBoredFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = user.getnBored();
                count++;
                mDatabase.child(currentUser.getUid()).child("nBored").setValue(count);
                Toast.makeText(FaceActivity.this, "Number bored: " + count, Toast.LENGTH_SHORT).show();
            }
        });

        ibSmileFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = user.getnSmile();
                count++;
                mDatabase.child(currentUser.getUid()).child("nSmile").setValue(count);
                Toast.makeText(FaceActivity.this, "Number smile: " + count, Toast.LENGTH_SHORT).show();
            }
        });

        ibSadFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = user.getnSad();
                count++;
                mDatabase.child(currentUser.getUid()).child("nSad").setValue(count);
                Toast.makeText(FaceActivity.this, "Number sad: " + count, Toast.LENGTH_SHORT).show();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(FaceActivity.this, MainActivity.class));
            }
        });
    }
}