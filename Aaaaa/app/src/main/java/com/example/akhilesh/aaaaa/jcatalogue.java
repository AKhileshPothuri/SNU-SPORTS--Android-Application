package com.example.akhilesh.aaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.support.annotation.Nullable;


public class jcatalogue extends AppCompatActivity {
    public static String teamname;
    String name;
   // public String teamname;
    View myView;
    ListView listView;
    players player;
    FirebaseDatabase firebaseDatabase;
    //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jnews.retrieve());
    DatabaseReference db;
    Boolean saved = null;
    //ArrayList<String> list;
    ArrayAdapter<String> adapter;
    ListView list;
    String[] web = {
            "Bulls",
            "Panthers",
            "Phoenix",
            "Falcons",
            "SNU Main Team"

    } ;
    Integer[] imageId = {
            R.drawable.bulls,
            R.drawable.panthers,
            R.drawable.phoenix,
R.drawable.falcons,
            R.drawable.snu
    };
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalgoue_layout);

        //     lv.setAdapter(adapter);
        //return myView;
        CustomList adapter = new
                CustomList(jcatalogue.this, web, imageId);
        list=(ListView)findViewById(R.id.catalogue_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(jcatalogue.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
String team=web[position];
if(!team.equals("SNU Main Team")){
teamname=team;
    Intent intent=new Intent(jcatalogue.this,slsports.class);
    startActivity(intent);
}
else
{
    Intent intent=new Intent(jcatalogue.this,snusports.class);
    startActivity(intent);

}
            }
        });

    }




}

//    private ArrayList<String> retrieve()
//    {
//        db.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                fetchData(dataSnapshot);
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