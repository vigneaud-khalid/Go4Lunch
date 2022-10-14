package com.khalid.go4lunch.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.khalid.go4lunch.R;
import com.khalid.go4lunch.retrofit.RetroRestaurants;

import java.util.ArrayList;
import java.util.List;


//Extend the RecyclerView.Adapter class
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<RetroRestaurants> dataList = new ArrayList<>();

    public MyAdapter(List<RetroRestaurants> dataList) {
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //Get a reference to the Views in our layout
        public final View myView;
        TextView textUser;
        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            textUser = myView.findViewById(R.id.restaurant);
        }
    }

    @Override
    //Construct a RecyclerView.ViewHolder
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    //Set the data
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textUser.setText(dataList.get(position).getRestaurant());
    }

    //Calculate the item count for the RecylerView
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
