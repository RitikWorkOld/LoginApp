package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.os.Bundle;

import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_books);
        new FirebaseDatabaseHelper().readBooks(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataisLoaded(List<Book> books, List<String> keys) {
                new RecyclerView_config().setConfig(mRecyclerView, BookListActivity.this,books,keys);
            }

            @Override
            public void DataisInserted() {

            }

            @Override
            public void DataisUpdated() {

            }
        });
    }
}
