package com.example.loginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerView_config {


    private Context mContext;
    private BookAdapter mBookAdapter;

    public void setConfig(RecyclerView recyclerView,Context context,List<Book> books,List<String> keys){
        mContext=context;
        mBookAdapter=new BookAdapter(books,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mBookAdapter);

    }

    class BookItemView extends RecyclerView.ViewHolder{

        private TextView mtitle;
        private TextView mauthor;

        private String key;

            public BookItemView(ViewGroup parent){

                super(LayoutInflater.from(mContext).inflate(R.layout.book_list_item,parent,false));

                mtitle=(TextView) itemView.findViewById(R.id.author_txtview);
                mauthor=(TextView) itemView.findViewById(R.id.update_txtview);
            }

            public void bind(Book book,String key){

                mtitle.setText(book.getHello());
                mauthor.setText(book.getUpdate_please());
                this.key=key;
            }

    }

    class BookAdapter extends RecyclerView.Adapter<BookItemView>{

        private List<Book> mBookList;
        private  List<String> mKeys;

        public BookAdapter(List<Book> mBookList, List<String> mKeys) {
            this.mBookList = mBookList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public BookItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BookItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BookItemView holder, int position) {
        holder.bind(mBookList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }
    }
}
