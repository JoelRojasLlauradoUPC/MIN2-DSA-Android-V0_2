package com.example.android_proyecto.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_proyecto.Adapters.TeamRankingAdapter;
import com.example.android_proyecto.Models.Team;
import com.example.android_proyecto.R;
import com.example.android_proyecto.RetrofitClient;
import com.example.android_proyecto.Services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamRankingActivity extends AppCompatActivity {

    private ApiService api;
    private TeamRankingAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_ranking);

        api = RetrofitClient.getApiService();

        RecyclerView rvTeams = findViewById(R.id.rvTeams);
        rvTeams.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeamRankingAdapter();
        rvTeams.setAdapter(adapter);

        loadTeamsRanking();
    }

    private void loadTeamsRanking() {
        Call<List<Team>> call = api.getTeamsRanking();
        call.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setTeams(response.body());
                } else {
                    Toast.makeText(TeamRankingActivity.this,
                            "Error loading ranking: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                Toast.makeText(TeamRankingActivity.this,
                        "Connection error: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
