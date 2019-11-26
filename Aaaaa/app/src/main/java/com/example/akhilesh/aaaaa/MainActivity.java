package com.example.akhilesh.aaaaa;

import android.app.FragmentManager;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public  FirebaseAuth firebaseAuth;
    public GoogleApiClient googleApiClient;
    String name;
    public  TextView namey;
    View myView;
    ListView lv;
    ArrayAdapter<String> adapter;
    DatabaseReference db;
    Boolean saved=null;
    private  FirebaseAuth mAuth;

    login log=new login();
    ArrayList<String> news=new ArrayList<>();

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_news:
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout
                                    , new jnews()).commit();
                    return true;
                case R.id.navigation_favourites:
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout
                                    , new jfavourites()).commit();

                    return true;
                case R.id.navigation_scores:
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout
                                    , new jscore()).commit();
                    return true;
                case R.id.navigation_statistics:
                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout
                                    , new jstatistics()).commit();
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        FirebaseUser user=mAuth.getCurrentUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        TextView userView = (TextView) findViewById (R.id.display_name);
        TextView emailView = (TextView) findViewById (R.id.display_email);
//        userView.setText(user.getDisplayName().toString().trim());
//        emailView.setText(user.getEmail().toString().trim());

        //namey=(TextView)findViewById(R.id.display_name);
        //Intent intenty=getIntent();
      //  String dnames=intenty.getStringExtra("display name");
       // namey.setText(dnames);



        firebaseAuth = FirebaseAuth.getInstance();
        googleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(MainActivity.this , new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();

        fragmentManager.beginTransaction().replace(R.id.frame_layout, new jnews()).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        namey=(TextView)findViewById(R.id.displayname);
//        namey.setText(log.displayname);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationBottom);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
finish();    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
    FragmentManager fragmentManager = getFragmentManager();

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.navigation_leagues) {
            Intent intent=new Intent(this,jleague.class);
            startActivity(intent);

        } else if (id == R.id.navigation_catalogue) {
            Intent intent=new Intent(this,jcatalogue.class);
            startActivity(intent);

        } else if (id == R.id.navigation_settings) {
            Intent intent=new Intent(this,SettingsActivity.class);
            startActivity(intent);

        } else if (id == R.id.navigation_logout) {
            UserSignOutFunction();

        Intent intent=new Intent(MainActivity.this,login.class);
               startActivity(intent);
             }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void UserSignOutFunction() {


        firebaseAuth.getInstance().signOut();
        Log.d("check","hii"+googleApiClient.getContext());
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        //  updateUI(null);
                        Toast.makeText(MainActivity.this, "Logout Successfully", Toast.LENGTH_LONG).show();
                    }
                });


    }




}
