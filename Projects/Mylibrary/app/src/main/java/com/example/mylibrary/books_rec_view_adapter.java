package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class books_rec_view_adapter extends RecyclerView.Adapter<books_rec_view_adapter.viewHolder>{

    private ArrayList<book> books = new ArrayList<>();
    private Context context;
    private String type = "";
    private util ut;

    public books_rec_view_adapter(Context context)
    {
        this.context = context;
        ut = new util();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rec_view_book, parent, false);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.bookName.setText(books.get(position).getName());

        holder.bookcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, books.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, bookActivity.class);
                intent.putExtra("bookId", books.get(position).getId());
                context.startActivity(intent);
            }
        });

        holder.bookcard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                final book bb = books.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Warning")
                        .setMessage("Do you want to delete this book?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });


                switch (type)
                {
                    case "want to read":
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(ut.remove_want_to_read_books(books.get(position))) {
                                notifyDataSetChanged();
                                Toast.makeText(context, bb.getName() + " removed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).create().show();
                        break;
                    case "already read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(ut.remove_already_read_books(books.get(position))) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, bb.getName() + " removed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();

                        break;
                    case "currently reading":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (ut.remove_currently_reading_books(books.get(position))) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, bb.getName() + " removed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        break;

                    default:
                        break;
                }
                return true;
            }
        });

        Glide.with(context).asBitmap().load(books.get(position).getImage_url()).into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    private static final String TAG = "books_rec_view_adapter";

    public class viewHolder extends RecyclerView.ViewHolder{

        private ImageView bookImage;
        private TextView bookName;
        private CardView bookcard;


        public viewHolder(View itemView)
        {
            super(itemView);
             bookImage = (ImageView) itemView.findViewById(R.id.book_image_1);
             bookName = (TextView) itemView.findViewById(R.id.book_name_1);
             bookcard = (CardView) itemView.findViewById(R.id.book_card);
        }

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBooks(ArrayList<book> books) {
        this.books = books;
        notifyDataSetChanged();
    }
}
