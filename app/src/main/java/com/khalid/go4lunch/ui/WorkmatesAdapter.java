package com.khalid.go4lunch.ui;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.khalid.go4lunch.R;
import com.khalid.go4lunch.model.Workmate;

import java.util.List;

/**
 * Created by ordinateur _ Khalid _  on 17/10/2022.
 */
public class WorkmatesAdapter extends RecyclerView.Adapter<WorkmatesAdapter.WorkmatesViewHolder> {
    /**
     * The list of tasks the adapter deals with
     */
    @NonNull
    private List<Workmate> workmates;


    /**
     * Instantiates a new WorkmatesAdapter.
     *
     */
    WorkmatesAdapter(List<Workmate> listWorkmate) {

        this.workmates = listWorkmate;
         }

    /**
     * Updates the list of tasks the adapter deals with.
     *
     * @param workmates the list of workmates the adapter deals with to set
     */
    void updateWorkmates(@NonNull final List<Workmate> workmates) {
        this.workmates = workmates;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public WorkmatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_workmate, viewGroup, false);
        return new WorkmatesViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull WorkmatesViewHolder workmatesViewHolder, int position) {
        WorkmatesViewHolder.bind(workmates.get(position));
    }

    @Override
    public int getItemCount() {
        return workmates.size();
    }



    /**
     * <p>ViewHolder for task items in the tasks list</p>
     *
     * @author Gaëtan HERFRAY
     */
    class WorkmatesViewHolder extends RecyclerView.ViewHolder {
        /**
         * The circle icon showing the color of the project
         */
        private final AppCompatImageView imgProject;

        /**
         * The TextView displaying the name of the task
         */
        private final TextView lblTaskName;

        /**
         * The TextView displaying the name of the project
         */
        private final TextView lblProjectName;

        /**
         * The delete icon
         */
        private final AppCompatImageView imgDelete;



        /**
         * Instantiates a new TaskViewHolder.
         *
         * @param itemView the view of the task item
         * @param deleteTaskListener the listener for when a task needs to be deleted to set
         */
        WorkmatesViewHolder(@NonNull View itemView) {
            super(itemView);


            imgProject = itemView.findViewById(R.id.img_project);
            lblTaskName = itemView.findViewById(R.id.lbl_task_name);
            lblProjectName = itemView.findViewById(R.id.lbl_project_name);
            imgDelete = itemView.findViewById(R.id.img_delete);

        }

        /**
         * Binds a task to the item view.
         *
         * @param task the task to bind in the item view
         */
        @RequiresApi(api = Build.VERSION_CODES.N)
        void bind(Workmate workmate) {
            lblTaskName.setText(workmate.getName());
            imgDelete.setTag(workmate);


        }
    }
}

