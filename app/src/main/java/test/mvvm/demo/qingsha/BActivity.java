package test.mvvm.demo.qingsha;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import test.mvvm.demo.App;
import test.mvvm.demo.R;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        App.hi="hihi";

        findViewById(R.id.gotoc).setOnClickListener(
                v -> {
                    Intent intent=new Intent(BActivity.this,CActivity.class);
                    startActivity(intent);
                }
        );
    }
}
