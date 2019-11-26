package com.example.akhilesh.admincheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_high extends AppCompatActivity {
    private Button update_highlight;
private EditText ighlight,sport,leagueID;
private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_highlight);
        update_highlight=(Button)findViewById(R.id.update_highlight);
        ighlight=(EditText)findViewById(R.id.highlight);
        sport=(EditText)findViewById(R.id.sports);
        leagueID=(EditText)findViewById(R.id.leagueId);
db=FirebaseDatabase.getInstance().getReference();
update_highlight.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String check=leagueID.getText().toString();

String sports=sport.getText().toString();
String highlight=ighlight.getText().toString();
high high=new high();
high.setHighlight(highlight);
high.setLeaguename(check);
high.setSports(sports);
db.child("highlights").push().setValue(high);

        finish();

   }
});
    }
}
