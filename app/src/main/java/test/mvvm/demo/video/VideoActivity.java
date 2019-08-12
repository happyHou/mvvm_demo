package test.mvvm.demo.video;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import test.mvvm.demo.R;

public class VideoActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        hihiss();
    }

    public native String hihiss();


}
