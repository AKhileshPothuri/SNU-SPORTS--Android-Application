package com.example.akhilesh.aaaaa;

import android.app.Fragment;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static com.example.akhilesh.aaaaa.login.TAG;


public class jnews extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private DatabaseReference mDatabase;
    private ProgressDialog progressDialog;
    private List<highlights> highlights;
    View myView;
    FirebaseDatabase firebaseDatabase;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.news_layout, container, false);
        //myView=inflater.inflate(R.layout.news_layout,container,false);

        recyclerView = (RecyclerView) myView.findViewById(R.id.news_recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressDialog = new ProgressDialog(getActivity());

        highlights = new ArrayList<>();

        //displaying progress dialog while fetching images
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = firebaseDatabase.getReference("highlights");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                highlights.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    highlights value = ds.getValue(highlights.class);
                    Log.d(TAG,  "heeeererrererer"+value.getSport());
                    highlights.add(value);
                }
                adapter = new MyAdapter3(getActivity(), highlights);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return myView;
    }
}


//        high = new highlights();
//        listView = (ListView) myView.findViewById(R.id.news_list);
//        list = new ArrayList<>();
//        adapter = new ArrayAdapter<String>(myView.getContext(), android.R.layout.simple_list_item_1, list);
//
//
//
//        db = firebaseDatabase.getReference("highlights");
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //db.child("highlights").orderByChild("timestamp").limitToLast(10);
//                list.clear();
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//
//                    high = ds.getValue(highlights.class);
//
//
//
//                    list.add(high.getHighlight());
//                } Collections.reverse(list);
//
//                listView.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        return myView;
//    }
//
//







//    String name;
//    View myView;
//    ListView listView;
//    highlights high;
//    FirebaseDatabase firebaseDatabase;
// //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jnews.retrieve());
//    DatabaseReference db;
//    Boolean saved = null;
//    ArrayList<String> list;
//    ArrayAdapter<String> adapter;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        myView = inflater.inflate(R.layout.news_layout, container, false);
//
//        //     lv.setAdapter(adapter);
//        //return myView;
//        high = new highlights();
//        listView = (ListView) myView.findViewById(R.id.news_list);
//        list = new ArrayList<>();
//        adapter = new ArrayAdapter<String>(myView.getContext(), android.R.layout.simple_list_item_1, list);
//
//
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        db = firebaseDatabase.getReference("highlights");
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //db.child("highlights").orderByChild("timestamp").limitToLast(10);
//                list.clear();
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//
//                    high = ds.getValue(highlights.class);
//
//
//
//                    list.add(high.getHighlight());
//                } Collections.reverse(list);
//
//                listView.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        return myView;
//    }
//}
////    private ArrayList<String> retrieve()
////    {
////        db.addChildEventListener(new ChildEventListener() {
////            @Override
////            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
////                fetchData(dataSnapshot);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                fetchData(dataSnapshot);
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//        return news;
//    }
//
//    private void fetchData(DataSnapshot dataSnapshot)
//    {
//        news.clear();
//
//        for (DataSnapshot ds : dataSnapshot.getChildren())
//        {
//            String name=ds.getValue(jnews.class).getName();
//            news.add(name);
//        }
//    }
//
//    private String getName() {
//        return name;   }
//
//}