package test.mvvm.demo.frag;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.InvocationTargetException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import test.mvvm.demo.R;

public class DemoActivity extends AppCompatActivity {
    private static final String TAG = "DemoActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        View viewById = findViewById(R.id.getDemoeFragment);
        viewById.setOnClickListener((v ->
                getDemoeFragment()));


        if (savedInstanceState==null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            DemoFragment demoFragment=DemoFragment.newInstance(123456);
            fragmentTransaction.add(R.id.fragment_container,demoFragment);
            fragmentTransaction.commit();
        }
    }

    private void getDemoeFragment(){
        String fragmentName="test.mvvm.demo.frag.DemoFragment";
        DemoFragment o=null;
        try {
            Class<?> fr= getClassLoader().loadClass(fragmentName);
             o = (DemoFragment) fr.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Log.e(TAG, "getDemoeFragment: "+o );

    }




}
