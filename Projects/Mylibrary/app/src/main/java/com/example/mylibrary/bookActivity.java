package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class bookActivity extends AppCompatActivity {

    private static final String TAG = "bookActivity";

    private TextView bookName, authorName, description, pageNumber;
    private ImageView bookImage;
    private Button btnCurrentlyReading, btnAlreadyRead, btnWantToRead;

    private util  ut;

    private book incomingBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //overridePendingTransition(R.anim.in, R.anim.out );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId", 0);
        ut = new util();
        ArrayList<book> books = ut.getAll_books();
        for(book b:books)
            if(b.getId() == id)
            {
                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("Pages: " + b.getPages());
                Glide.with(this).asBitmap()
                        .load(b.getImage_url())
                        .into(bookImage);
            }

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurrentlyReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });

    }

    private void btnWantToReadTapped()
    {
        Log.d(TAG, "btnWantToReadTapped: Started");

        ArrayList<book> wantToReadBooks= ut.getWant_to_read_books();

        if(wantToReadBooks.contains(incomingBook))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You already added to want to read list");

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(false);

            builder.create().show();
        }
        else {
            ut.add_want_to_read_books(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName()
                            + " Added to Want to Read List"
                    , Toast.LENGTH_SHORT).show();
        }
    }

    private void btnAlreadyReadTapped()
    {
        Log.d(TAG, "btnAlreadyReadTapped: Started");

        boolean doesExist = false;

        ArrayList<book> alreadyReadBooks= ut.getAlready_read_books();
        for(book bb: alreadyReadBooks)
        {
            if (bb.getId() == incomingBook.getId())
                doesExist = true;
        }

        if(doesExist)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You already added to already read list");

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(false);

            builder.create().show();
        }
        else {
            ut.add_already_read_books(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName()
                            + " Added to Already Read List"
                    , Toast.LENGTH_SHORT).show();
        }
    }

    private void btnCurrentlyReadingTapped()
    {
        Log.d(TAG, "btnCurrentlyReadingTapped: Started");

        boolean doesExist = false;

        ArrayList<book> currentlyReadingBooks= ut.getCurrent_books();
        for(book bb: currentlyReadingBooks)
        {
            if (bb.getId() == incomingBook.getId())
                doesExist = true;
        }

        if(doesExist)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You already added to current list");

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(false);

            builder.create().show();
        }
        else {
            ut.add_currently_reading_books(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName()
                     + " Added to Current List"
                    , Toast.LENGTH_SHORT).show();
        }
    }


    private void init()
    {
        bookName = (TextView) findViewById(R.id.book_name_2);
        authorName= (TextView) findViewById(R.id.book_author);
        description = (TextView) findViewById(R.id.book_description);
        pageNumber = (TextView) findViewById(R.id.book_pages);


        bookImage = (ImageView) findViewById(R.id.book_image_2);

        btnCurrentlyReading = (Button) findViewById(R.id.btnCurrentReading);
        btnWantToRead = (Button) findViewById(R.id.btnWantToRead);
        btnAlreadyRead = (Button) findViewById(R.id.btnAlreadyRead);
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

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
