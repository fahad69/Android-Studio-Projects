package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class CurrentlyReadingActivity extends AppCompatActivity {

    private static final String TAG = "CurrentlyReadingActivity";

    private RecyclerView recyclerView;
    private util ut;
    private books_rec_view_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);

        //overridePendingTransition(R.anim.in, R.anim.out );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new books_rec_view_adapter(this);
        adapter.setType("currently reading");
        ut = new util();

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_CurrentBooks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter.setBooks(ut.getCurrent_books());
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
