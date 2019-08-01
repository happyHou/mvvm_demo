package test.mvvm.demo.frag;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import test.mvvm.demo.R;

public class DemoFragment extends Fragment {
    int someVar;
    private static final String TAG = "DemoFragment";


    public DemoFragment(){

    }

    public static DemoFragment newInstance(int someInt){
        DemoFragment fragment=new DemoFragment();
        Bundle args=new Bundle();
        args.putInt("args",someInt);
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: " );
        View inflate = inflater.inflate(R.layout.fragment_demo_a, container, false);
        TextView viewById = inflate.findViewById(R.id.demo_a_txt);
        viewById.setText("hello>>>"+someVar);
        return inflate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         someVar=getArguments().getInt("args");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: "+someVar);
    }
}
