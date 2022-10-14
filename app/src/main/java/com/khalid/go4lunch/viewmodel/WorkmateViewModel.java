package com.khalid.go4lunch.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.khalid.go4lunch.model.Workmate;
import com.khalid.go4lunch.repository.GoRepository;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author khalid
 */
public class WorkmateViewModel extends ViewModel {

    Context context;
    private GoRepository goRepository;
    private final Executor executor;
    private LiveData<List<Workmate>> workmatesLiveData;

    public WorkmateViewModel(GoRepository goRepository, Executor executor, LiveData<List<Workmate>> workmatesLiveData) {
        this.goRepository = goRepository;
        this.executor = executor;
        this.workmatesLiveData = workmatesLiveData;
    }


    public LiveData<List<Workmate>> getProjectsLiveData() { return workmatesLiveData;  }

    public LiveData<List<Workmate>> getAllWorkmates() { return goRepository.getAllWorkmates(); }

// lesquelles utiles
//
//    public void deleteWorkmate(long workmateId) { executor.execute(() -> goRepository.deleteWorkmate(workmateId)); }
//
//    public void addWorkmate(Workmate workmate) { executor.execute(() -> goRepository.addWorkmate(workmate)); }

// autres à rajouter


}
