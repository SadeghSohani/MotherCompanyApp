package com.example.mothercompanyapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<ChickenAsset> dataList;
    private Context context;

    public CustomAdapter(Context context,List<ChickenAsset> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_chicken_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvID.setText("-CHICKEN ID :\n     "+dataList.get(position).getChickenId());
        holder.tvMotherCompany.setText("-MOTHER COMPANY :\n     "+dataList.get(position).getMotherCompany());
        holder.tvFeedingCompany.setText("-FEEDING COMPANY :\n     "+dataList.get(position).getFeedingCompany());
        holder.tvSlaughterHouse.setText("-SLAUGHTERHOUSE :\n     "+dataList.get(position).getSlaughterHouse());
        holder.tvOwner.setText("-OWNER :\n     "+dataList.get(position).getOwner());
        holder.tvFarm.setText("-FARM :\n     "+dataList.get(position).getChickenFarm());
        holder.chickenItem.setOnClickListener(v -> {
            Intent intent = new Intent(context,ChickenHistoryActivity.class);
            intent.putExtra("chickenId", dataList.get(position).getChickenId());
            intent.putExtra("chickenFarm", dataList.get(position).getChickenFarm());
            intent.putExtra("feedingCompany", dataList.get(position).getFeedingCompany());
            intent.putExtra("motherCompany", dataList.get(position).getMotherCompany());
            intent.putExtra("slaughterHouse", dataList.get(position).getSlaughterHouse());
            intent.putExtra("owner", dataList.get(position).getOwner());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    static class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView tvID, tvMotherCompany, tvFeedingCompany, tvSlaughterHouse, tvOwner, tvFarm;
        CardView chickenItem;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvID = mView.findViewById(R.id.tv_chickenID);
            tvMotherCompany = mView.findViewById(R.id.tv_motherCompany);
            tvFeedingCompany = mView.findViewById(R.id.tv_feedingCompany);
            tvSlaughterHouse = mView.findViewById(R.id.tv_slaughterHouse);
            tvOwner = mView.findViewById(R.id.tv_owner);
            tvFarm = mView.findViewById(R.id.tv_chickenFarm);
            chickenItem = mView.findViewById(R.id.chickenItem);
        }
    }

}