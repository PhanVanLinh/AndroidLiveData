package toong.vn.androidlivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textScoreNumber;
    private TextView textScoreString;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textScoreNumber = findViewById(R.id.text_score_number);
        textScoreString = findViewById(R.id.text_score_string);

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
                textScoreNumber.setText(String.valueOf(integer));
            }
        });

        viewModel.getScoreInString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String score) {
                textScoreString.setText(score);
            }
        });
    }
}
