package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";

    private ListView listView;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        //overridePendingTransition(R.anim.in, R.anim.out );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate: Started");

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_AllBooks);

        books_rec_view_adapter adapter = new books_rec_view_adapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2 ));

        ArrayList<book> books = new ArrayList<>();

        util utl = new util();
        books = utl.getAll_books();
        adapter.setBooks(books);



        /*listView = (ListView) findViewById(R.id.ListView_AllBooks);

        ArrayList<String> allbooks = new ArrayList<>();

        allbooks.add("Macbeth");
        allbooks.add("Ilyad");
        allbooks.add("Me before You");
        allbooks.add("sapiens");
        allbooks.add("homo");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                allbooks);

        listView.setAdapter(adapter);*/

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
