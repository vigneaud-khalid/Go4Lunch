package com.khalid.go4lunch.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * @author khalid
 */
public class FirebaseHelper {

    private static FirebaseHelper sFirebaseHelper;

    public static FirebaseHelper getInstance() {
        if (sFirebaseHelper == null) {
            sFirebaseHelper = new FirebaseHelper();
        }
        return sFirebaseHelper;
    }
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    public final CollectionReference workmatesRef = db.collection("workmate");

    public Task<QuerySnapshot> getAllWorkmates(){
        return workmatesRef.get();
    }


    // autres méthodes

    // public Task<QuerySnapshot> getWorkmatexxxxxxx() {
    // return workmatesRef.orderBy("xxxxxxx").get();
    //  }


}

