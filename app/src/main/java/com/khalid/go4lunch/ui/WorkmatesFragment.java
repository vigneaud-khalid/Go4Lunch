package com.khalid.go4lunch.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khalid.go4lunch.R;
import com.khalid.go4lunch.di.DI;
import com.khalid.go4lunch.di.ViewModelFactory;
import com.khalid.go4lunch.model.Workmate;
import com.khalid.go4lunch.repository.GoRepository;
import com.khalid.go4lunch.viewmodel.WorkmateViewModel;

import java.util.List;

public class WorkmatesFragment extends Fragment {

    private GoRepository mGoRep;
    private MutableLiveData<List<Workmate>> mWorkmates;
    private RecyclerView mRecyclerView;
    private WorkmateViewModel mWorkmateViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureViewModel();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workmates, container, false);
        Context context = view.getContext();
        mRecyclerView = view.findViewById(R.id.list_workmates);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    /**
     * Init the List of neighbours
     */
    private void initList() {
        mWorkmateViewModel.getAllWorkmates().observe(this,  allWorkmates -> {
        mRecyclerView.setAdapter(new WorkmatesAdapter(allWorkmates));
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }
    // Configuring ViewModel
    private void configureViewModel() {
        this.mWorkmateViewModel = new ViewModelProvider(this, ViewModelFactory.getInstance(requireContext())).get(WorkmateViewModel.class);
    }

}