package toong.vn.androidlivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textScoreTeamA;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textScoreTeamA = findViewById(R.id.text_score);

        findViewById(R.id.button_increase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.increaseScore();
            }
        });

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        registerLiveDataListener();
    }

    public void registerLiveDataListener() {
        viewModel.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textScoreTeamA.setText(String.valueOf(integer));
            }
        });
    }
}
