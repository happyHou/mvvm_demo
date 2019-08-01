package test.mvvm.demo.qingsha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import test.mvvm.demo.App;
import test.mvvm.demo.R;
import test.mvvm.demo.video.VideoActivity;

public class AActivity extends AppCompatActivity {
    private static final String TAG = "AActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
        setContentView(R.layout.activity_a);
        findViewById(R.id.gotob).setOnClickListener(
                v -> {
                    Intent intent=new Intent(AActivity.this,BActivity.class);
                    startActivity(intent);
                }
        );

        findViewById(R.id.gotovideo).setOnClickListener(
                v -> {
                    Intent intent=new Intent(AActivity.this, VideoActivity.class);
                    startActivity(intent);
                }
        );


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: "+ App.hi);
    }
}
