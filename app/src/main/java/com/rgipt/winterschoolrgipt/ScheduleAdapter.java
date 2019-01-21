package com.rgipt.winterschoolrgipt;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ScheduleAdapter extends FirestoreRecyclerAdapter<Schedule, ScheduleAdapter.ScheduleHolder> {

    public ScheduleAdapter(@NonNull FirestoreRecyclerOptions<Schedule> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ScheduleHolder holder, int position, @NonNull Schedule model) {
        holder.textViewDate.setText(model.getDate());
        holder.textViewEvent.setText(model.getEvent());


    }

    @NonNull
    @Override
    public ScheduleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule,
                parent, false);
        return new ScheduleHolder(v);
    }

    class ScheduleHolder extends RecyclerView.ViewHolder {
        TextView textViewDate;
        TextView textViewEvent;

        public ScheduleHolder(View itemView) {
            super(itemView);
            textViewDate = itemView.findViewById(R.id.text_view_date_schedule);
            textViewEvent = itemView.findViewById(R.id.text_view_Event);

        }
    }
}