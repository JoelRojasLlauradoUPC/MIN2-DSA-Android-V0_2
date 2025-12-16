package com.example.android_proyecto.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_proyecto.Models.FishingRod;
import com.example.android_proyecto.Models.Team;
import com.example.android_proyecto.R;
import com.example.android_proyecto.RetrofitClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamsRankingAdapter extends RecyclerView.Adapter<TeamsRankingAdapter.VH> {

    private List<Team> data = new ArrayList<>();

    public void setData(List<Team> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team_ranking, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Team t = data.get(position);
        h.txtName.setText(t.getName());
        h.txtPoints.setText("Puntos: " + t.getPoints());

        Glide.with(h.itemView.getContext())
                .load(t.getAvatar())
                .into(h.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView txtName, txtPoints;

        VH(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtName = itemView.findViewById(R.id.txtName);
            txtPoints = itemView.findViewById(R.id.txtPoints);
        }
    }
}
