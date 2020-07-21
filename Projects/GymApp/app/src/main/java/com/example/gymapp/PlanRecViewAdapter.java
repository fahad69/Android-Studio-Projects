package com.example.gymapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlanRecViewAdapter extends RecyclerView.Adapter<PlanRecViewAdapter.ViewHolder> {
    private static final String TAG = "PlanRecViewAdapter";

    private Context mContext;
    private ArrayList<Plan> plans = new ArrayList<>();
    private String type = "";

    public interface DeletePlan{
        void OnDeletePlan(String day);
    }

    private DeletePlan deletePlan;

    public PlanRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public PlanRecViewAdapter() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView activityName, time, shortDesc;
        private ImageView activityImage, emptyCheckBox, filledCheckBox;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            activityName = (TextView) itemView.findViewById(R.id.trainingName1);
            time = (TextView) itemView.findViewById(R.id.trainingTime);
            shortDesc = (TextView) itemView.findViewById(R.id.trainingShortDescription1);
            parent = (CardView) itemView.findViewById(R.id.planList);
            activityImage = (ImageView) itemView.findViewById(R.id.trainingImage1);
            emptyCheckBox = (ImageView) itemView.findViewById(R.id.emptyCheckBox);
            filledCheckBox = (ImageView) itemView.findViewById(R.id.filledCheckBox);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.plan_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.activityName.setText(plans.get(position).getTraining().getName());
        Glide.with(mContext)
                .asBitmap()
                .load(plans.get(position).getTraining().getImageUrl())
                .into(holder.activityImage);
        holder.time.setText("Time : " + String.valueOf(plans.get(position).getMinutes()) + " minutes");
        holder.shortDesc.setText(plans.get(position).getTraining().getShortDesc());

        if(plans.get(position).isComplete()){
            holder.emptyCheckBox.setVisibility(View.GONE);
            holder.filledCheckBox.setVisibility(View.VISIBLE);
        }
        else {
            holder.filledCheckBox.setVisibility(View.GONE);
            holder.emptyCheckBox.setVisibility(View.VISIBLE);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TrainingActivity.class);
                intent.putExtra("training", plans.get(position).getTraining());
                mContext.startActivity(intent);
            }
        });

        if(type.equals("edit"))
        {
            holder.emptyCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Accomplished?")
                            .setMessage("Have you finished it?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    plans.get(position).setComplete(true);
                                    for(Plan plan:Util.getUserPlans())
                                    {
                                        if(plan.equals(plans.get(position)))
                                            plan.setComplete(true);
                                    }
                                    notifyDataSetChanged();
                                }

                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    builder.create().show();
                }
            });


            try {
                deletePlan = (DeletePlan) mContext;

            }catch (ClassCastException e)
            {
                e.printStackTrace();
            }

            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Delete?")
                            .setMessage("Are you sure about deleting it?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Util.removePlan(plans.get(position));
                                    deletePlan.OnDeletePlan(plans.get(position).getDay());
                                }

                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    builder.create().show();

                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }
}
