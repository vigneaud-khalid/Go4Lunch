package com.khalid.go4lunch.di;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.khalid.go4lunch.repository.GoRepository;
import com.khalid.go4lunch.viewmodel.WorkmateViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author khalid
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final GoRepository goRepository;

    private final Executor executor;

    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance(Context context) {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory(context);
                }
            }
        }
        return factory;
    }

    private ViewModelFactory(Context context) {
        this.goRepository = DI.getGoRepository(context);
        this.executor = Executors.newSingleThreadExecutor();
    }

    @Override
    @NotNull
    public <T extends ViewModel>  T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(WorkmateViewModel.class)) {


            //return (T) new WorkmateViewModel(goRepository, executor);
            return null;


        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}