package com.example.loginapp;

import android.app.Notification;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRefrencebooks;
    private List<Book> books= new ArrayList<>();

    public interface DataStatus{
        void DataisLoaded(List<Book> books ,List<String> keys);
        void DataisInserted();
        void DataisUpdated();

    }

    public FirebaseDatabaseHelper() {

        mDatabase=FirebaseDatabase.getInstance();
        mRefrencebooks=mDatabase.getReference("Notification");




    }


    public void readBooks(final DataStatus dataStatus){

        mRefrencebooks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            books.clear();
            List<String> keys=new ArrayList<>();
            for(DataSnapshot keyNode : dataSnapshot.getChildren()){

                keys.add(keyNode.getKey());
                Book book=keyNode.getValue(Book.class);
                books.add(book);
            }
            dataStatus.DataisLoaded(books,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
