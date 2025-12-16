package com.example.android_proyecto.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android_proyecto.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_proyecto.Models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamRankingAdapter extends RecyclerView.Adapter<TeamRankingAdapter.TeamVH> {

    private final List<Team> teams = new ArrayList<>();

    public void setTeams(List<Team> newTeams) {
        teams.clear();
        if (newTeams != null) teams.addAll(newTeams);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team_ranking, parent, false);
        return new TeamVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamVH holder, int position) {
        Team t = teams.get(position);

        holder.txtName.setText(t.getName());
        holder.txtPoints.setText(String.valueOf(t.getPoints()));

        String avatarUrl = t.getAvatar();

        if (avatarUrl == null || avatarUrl.trim().isEmpty()) {
            holder.imgAvatar.setImageDrawable(null);
        } else {
            Glide.with(holder.itemView)
                    .load(avatarUrl)
                    .into(holder.imgAvatar);
        }
    }


    @Override
    public int getItemCount() {
        return teams.size();
    }

    static class TeamVH extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView txtName;
        TextView txtPoints;

        TeamVH(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtName = itemView.findViewById(R.id.txtName);
            txtPoints = itemView.findViewById(R.id.txtPoints);
        }
    }
}
