package com.khalid.go4lunch.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.khalid.go4lunch.model.Workmate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author khalid
 */
public class GoRepository {



    private final MutableLiveData<List<Workmate>> listOfWorkmate = new MutableLiveData<>();

    private static GoRepository sGoRepository;
    private final FirebaseHelper mFirebaseHelper;

    public static GoRepository getInstance() {
        if (sGoRepository == null) {
            sGoRepository = new GoRepository();
        }
        return sGoRepository;
    }

    public GoRepository() {
        mFirebaseHelper = FirebaseHelper.getInstance();
        // Uncomment this method to populate your firebase database, it will upload some data
        // Comment it again after the first launch
        initData();
    }


    public MutableLiveData<List<Workmate>> getAllWorkmates() {
        mFirebaseHelper.getAllWorkmates().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<Workmate> workmates = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    workmates.add(document.toObject(Workmate.class));
                }
                listOfWorkmate.postValue(workmates);
            } else {
                Log.d("Error", "Error getting documents: ", task.getException());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //handle error
                listOfWorkmate.postValue(null);
            }
        });
        return listOfWorkmate;
    }


    // autres méthodes
    // public MutableLiveData<List<Workmate>> getWorkmatexxxxxxx() {    }




    private void initData() {
        FirebaseHelper.getInstance().workmatesRef.add(new Workmate("Ali", "Gator", "2", new HashMap(3,7), 4));
        FirebaseHelper.getInstance().workmatesRef.add(new Workmate("Franck", "Dubosc", "https://brandandcelebrities.com/wp-content/uploads/2017/04/Franck_Dubosc.jpg", new HashMap(3,7), 5));
    }
}

