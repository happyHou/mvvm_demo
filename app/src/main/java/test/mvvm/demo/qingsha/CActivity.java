package test.mvvm.demo.qingsha;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import test.mvvm.demo.App;
import test.mvvm.demo.R;

public class CActivity extends AppCompatActivity {
    private static final String TAG = "CActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: "+ App.hi);
    }
}
