package com.khalid.go4lunch.di;

import android.content.Context;
import com.khalid.go4lunch.repository.GoRepository;

/**
 * @author khalid
 */
public class DI {

    private static GoRepository goRepository = null;

    /**
     * Get an instance on @{@link GoRepository}
     * @return
     */
    public static GoRepository getGoRepository(Context context) {
        if(goRepository == null){

            // todo

//                GoDatabase db = GoDatabase.getInstance(context);
//                goRepository = new GoRepository(db.workmateDao());
            }
        return goRepository;
    }
}