package com.example.akhilesh.aaaaa;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import android.app.ProgressDialog;
import android.app.Person;
public class login extends AppCompatActivity {

    // TAG is for show some tag logs in LOG screen.
    public static final String TAG = "NAME";

    // Request sing in code. Could be anything as you required.
    public static final int RequestSignInCode = 7;
public static String displayname,mail;
    // Firebase Auth Object.
    public static FirebaseAuth firebaseAuth;

    // Google API Client object.
    public GoogleApiClient googleApiClient;

    // Sing out button.
    Button SignOutButton;

    // Google Sign In button .
    com.google.android.gms.common.SignInButton signInButton;

    // TextView to Show Login User Email and Name.
    TextView LoginUserName, LoginUserEmail;
//    ProgressDialog progress = new ProgressDialog(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        signInButton = (SignInButton) findViewById(R.id.sign_in_button);

        SignOutButton= (Button) findViewById(R.id.sign_out);

        LoginUserName = (TextView) findViewById(R.id.textViewName);

        LoginUserEmail = (TextView) findViewById(R.id.textViewEmail);

        signInButton = (com.google.android.gms.common.SignInButton)findViewById(R.id.sign_in_button);

// Getting Firebase Auth Instance into firebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();

// Hiding the TextView on activity start up time.
        LoginUserEmail.setVisibility(View.GONE);
        LoginUserName.setVisibility(View.GONE);

// Creating and Configuring Google Sign In object.
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

// Creating and Configuring Google Api Client.
        googleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(login.this , new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();


// Adding Click listener to User Sign in Google button.
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

signInButton.setVisibility(View.GONE);
                UserSignInMethod();

            }
        });

// Adding Click Listener to User Sign Out button.
        SignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserSignOutFunction();

            }
        });

    }


    // Sign In function Starts From Here.
    public void UserSignInMethod(){

// Passing Google Api Client into Intent.
        Toast.makeText(login.this,"Loading...",Toast.LENGTH_LONG).show();

        Intent AuthIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);

        startActivityForResult(AuthIntent, RequestSignInCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
//        progress.setTitle("Loading");
//        progress.setMessage("Wait while loading...");
//        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
//        progress.show();

        if (requestCode == RequestSignInCode){

            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        //    Person person  = Plus.PeopleApi.getCurrentPerson(googleApiClient);
            if (googleSignInResult.isSuccess()){

                GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();

                FirebaseUserAuth(googleSignInAccount);
//                GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
//                if (acct != null) {
//                    String personName = acct.getDisplayName();
//                    // String personGivenName = acct.getGivenName();
//                    //String personFamilyName = acct.getFamilyName();
//                    String personEmail = acct.getEmail();
//                    //String personId = acct.getId();
//                    Uri personPhoto = acct.getPhotoUrl();
//                }
            }

        }
    }

    public void FirebaseUserAuth(GoogleSignInAccount googleSignInAccount) {

        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);

     //   Toast.makeText(login.this,""+ authCredential.getProvider(),Toast.LENGTH_LONG).show();

        firebaseAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> AuthResultTask) {

                        if (AuthResultTask.isSuccessful()){

// Getting Current Login user details.
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
 displayname=firebaseUser.getDisplayName();
 Uri picture=firebaseUser.getPhotoUrl();
 mail=firebaseUser.getEmail();

                        //    Toast.makeText(login.this,displayname,Toast.LENGTH_LONG).show();

// Showing Log out button.
// progress.dismiss();
                            Intent intenty=new Intent(login.this,MainActivity.class);
                            intenty.putExtra(TAG,displayname);
                            intenty.putExtra("mail id",mail);
                            startActivity(intenty);
                          //  SignOutButton.setVisibility(View.VISIBLE);

// Hiding Login in button.
                            //signInButton.setVisibility(View.GONE);

// Showing the TextView.
                            //LoginUserEmail.setVisibility(View.VISIBLE);
                            //LoginUserName.setVisibility(View.VISIBLE);

// Setting up name into TextView.
                            //LoginUserName.setText("NAME = "+ firebaseUser.getDisplayName().toString());

// Setting up Email into TextView.
                            //LoginUserEmail.setText("Email = "+ firebaseUser.getEmail().toString());

                        }else {
                            Toast.makeText(login.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void UserSignOutFunction() {

// Sing Out the User.
       // firebaseAuth.signOut()
        firebaseAuth.getInstance().signOut();
        Log.d("check","hii"+googleApiClient.getContext());
       // Log.d("check",googleApiClient.toString()+"hii");
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                      //  updateUI(null);
                        Toast.makeText(login.this, "Logout Successfully", Toast.LENGTH_LONG).show();
                    }
                });

      /*  Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {

// Write down your any code here which you want to execute After Sign Out.

// Printing Logout toast message on screen.
                     //   Toast.makeText(login.this, "Logout Successfully", Toast.LENGTH_LONG).show();
String name="name";
                    }
                });*/

// After logout Hiding sign out button.
//        SignOutButton.setVisibility(View.GONE);
//
//// After logout setting up email and name to null.
//        LoginUserName.setText(null);
//        LoginUserEmail.setText(null);
//
//// After logout setting up login button visibility to visible.
//        signInButton.setVisibility(View.VISIBLE);
//
}

}

