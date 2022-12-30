package com.example.needblood.Activity;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.needblood.R;
import com.example.needblood.entities.Donor;

import java.util.ArrayList;
import java.util.List;

public class DonorListAdapter extends RecyclerView.Adapter<DonorListAdapter.DonorViewHolder> {
    private List<Donor> donor = new ArrayList<>();

    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_layout, parent, false);
        return new DonorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DonorViewHolder holder, int position) {
        Donor currentDonor = donor.get(position);
        holder.textViewName.setText(currentDonor.getName());
        holder.textViewCity.setText(currentDonor.getCity());
        holder.textViewBloodGroup.setText(currentDonor.getBloodGroup());
    }

    @Override
    public int getItemCount() {
        return donor.size();
    }

    public void setDonor(List<Donor> donor) {
        this.donor = donor;
        notifyDataSetChanged();
    }

    class DonorViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewCity;
        private TextView textViewBloodGroup;

        public DonorViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewCity = itemView.findViewById(R.id.textViewCity );
            textViewBloodGroup = itemView.findViewById(R.id.textViewBloodGroup );
        }
    }
}
