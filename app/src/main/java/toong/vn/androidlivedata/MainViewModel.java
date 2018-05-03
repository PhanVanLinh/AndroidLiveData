package toong.vn.androidlivedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by PhanVanLinh on 03/05/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class MainViewModel extends AndroidViewModel {

    private final String TAG = getClass().getSimpleName();
    private MutableLiveData<Integer> score = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        score.setValue(0);
    }

    public MutableLiveData<Integer> getScore() {
        return score;
    }

    public void increaseScore() {
        this.score.setValue(score.getValue() + 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "onCleared: ");
    }
}
