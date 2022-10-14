package com.khalid.go4lunch.ui;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.facebook.FacebookSdk;

import com.khalid.go4lunch.R;
import com.khalid.go4lunch.retrofit.GetData;
import com.khalid.go4lunch.retrofit.RetroRestaurants;
import com.khalid.go4lunch.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author khalid
 */
public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;

    BottomNavigationView bottomNavigationView;
    MapviewFragment mapviewFragment = new MapviewFragment();
    ListviewFragment listviewFragment = new ListviewFragment();
    WorkmatesFragment workmatesFragment = new WorkmatesFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FacebookSdk.sdkInitialize(getApplicationContext());

        // Create and launch sign-in intent
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build();
        signInLauncher.launch(signInIntent);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, workmatesFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mapview:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapviewFragment).commit();
                        return true;
                    case R.id.listview:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, listviewFragment).commit();
                        return true;
                    case R.id.workmates:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, workmatesFragment).commit();
                        return true;
                }
                return false;
            }
        });

        // Registration of app activations for Facebook Login
        //        FacebookSdk.sdkInitialize(getApplicationContext());
        //        AppEventsLogger.activateApp(this);

        //        CallbackManager callbackManager = CallbackManager.Factory.create();
        //
        //        LoginManager.getInstance().registerCallback(callbackManager,
        //                new FacebookCallback<LoginResult>() {
        //                    @Override
        //                    public void onSuccess(LoginResult loginResult) {
        //                        // App code
        //                    }
        //                }

        //Create a handler for the RetrofitInstance interface
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Call<List<RetroRestaurants>> call = service.getAllRestaurants();

        //Execute the request asynchronously
        call.enqueue(new Callback<List<RetroRestaurants>>() {
            @Override
            //Handle a successful response
            public void onResponse(Call<List<RetroRestaurants>> call, Response<List<RetroRestaurants>> response) {
                loadDataList(response.body());
            }

            @Override
            //Handle execution failures//
            public void onFailure(Call<List<RetroRestaurants>> call, Throwable throwable) {
                //If the request fails, then display the following toast//
                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Display the retrieved data as a list//
    private void loadDataList(List<RetroRestaurants> restaurantsList) {

        //Get a reference to the RecyclerView//
        myRecyclerView = findViewById(R.id.myRecyclerView);
        //myAdapter = new MyAdapter(restaurantsList);
        myAdapter = new MyAdapter(new ArrayList<>());
        //myAdapter = new Adapter(restaurantsList);

        //Use a LinearLayoutManager with default vertical orientation//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView//
        myRecyclerView.setAdapter(myAdapter);


    }


    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.GoogleBuilder().build(),
            new AuthUI.IdpConfig.FacebookBuilder().build());


    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == RESULT_OK) {
            // Successfully signed in
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            // ...
        } else {

            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
            Log.d("FFFFF", result.toString());
        }
    }
//dans le bottom Navigation
// Create new fragment and transaction
//Fragment newFragment = new ExampleFragment();
    //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    // Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
//transaction.replace(R.id.fragment_container, newFragment);
//transaction.addToBackStack(null);

// Commit the transaction
//transaction.commit();

}