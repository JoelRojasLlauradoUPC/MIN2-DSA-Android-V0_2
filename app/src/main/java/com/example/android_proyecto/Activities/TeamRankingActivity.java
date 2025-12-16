package com.example.android_proyecto.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_proyecto.Adapters.TeamsRankingAdapter;
import com.example.android_proyecto.Models.Team;
import com.example.android_proyecto.R;
import com.example.android_proyecto.RetrofitClient;
import com.example.android_proyecto.Services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsRankingActivity extends AppCompatActivity {

    private ApiService api;

    private RecyclerView recycler;
    private TeamsRankingAdapter adapter;

    private ProgressBar progress;
    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_ranking);

        recycler = findViewById(R.id.recyclerTeams);
        progress = findViewById(R.id.progressTeams);
        tvMsg = findViewById(R.id.tvMsgTeams);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeamsRankingAdapter();
        recycler.setAdapter(adapter);

        api = RetrofitClient.getApiService();

        loadRanking();
    }

    private void showLoading(boolean show) {
        progress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void loadRanking() {
        showLoading(true);
        tvMsg.setText("");

        Call<List<Team>> call = api.getTeamsRanking();
        call.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                showLoading(false);

                if (response.isSuccessful() && response.body() != null) {
                    adapter.setData(response.body());
                }
                else {
                    tvMsg.setText("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                showLoading(false);
                tvMsg.setText("Connection error: " + t.getMessage());
            }
        });
    }
}
