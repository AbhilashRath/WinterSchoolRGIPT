package com.rgipt.winterschoolrgipt;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class NewsAdapter extends FirestoreRecyclerAdapter<News, NewsAdapter.NewsHolder> {

    public NewsAdapter(@NonNull FirestoreRecyclerOptions<News> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NewsHolder holder, int position, @NonNull News model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDescription.setText(model.getDescription());


    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news,
                parent, false);
        return new NewsHolder(v);
    }

    class NewsHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDescription;

        public NewsHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);

        }
    }
}