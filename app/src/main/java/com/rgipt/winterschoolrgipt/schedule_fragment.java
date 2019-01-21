package com.rgipt.winterschoolrgipt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

/**
 * Created by Abhilash on 08-12-2018.
 */


public class schedule_fragment extends Fragment {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Schedule");
    private ScheduleAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.ws_schedule,container,false);
        Query query = notebookRef.orderBy("priority", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Schedule> options = new FirestoreRecyclerOptions.Builder<Schedule>()
                .setQuery(query, Schedule.class)
                .build();

        adapter = new ScheduleAdapter(options);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.schedule_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}
