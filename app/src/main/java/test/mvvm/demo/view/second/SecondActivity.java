package test.mvvm.demo.view.second;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.mvvm.demo.BR;
import test.mvvm.demo.R;
import test.mvvm.demo.databinding.ActivityMainBinding;
import test.mvvm.demo.view.adapter.ItemBean;
import test.mvvm.demo.view.adapter.MainPagerAdapter;
import test.mvvm.demo.view.adapter.MyListAdapter;
import test.mvvm.demo.viewmodel.MainViewModel;


@Route(path = "/test/secondAct")
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    // 界面上的控件
    private ListView mListView;
    private MyListAdapter mAdapter;
    private LinearLayout mTitleLayout ;

    // 相关的数据
    private List<ItemBean> dataList = new ArrayList<>();
    private ItemBean bean;
    private List<String> idList = new ArrayList<>();

    private static final int COLUMN_NUM = 10;
    private static final int ROW_NUM = 10;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ARouter.getInstance().inject(this);
        String hi = getIntent().getStringExtra("hi");
        Log.e(TAG, "onCreate: "+hi );
        setContentView(R.layout.activity_second);

        mListView = (ListView) findViewById(R.id.mListView);
        mTitleLayout = (LinearLayout) findViewById(R.id.titleLayout);

        for (int i = 0; i < COLUMN_NUM; i++) {
            View titleView = LayoutInflater.from(this).inflate(R.layout.item_text,null);
            TextView title = (TextView) titleView.findViewById(R.id.itemTitleTv);
            title.setText("标题"+i);
            mTitleLayout.addView(titleView,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        }

        // 准备数据
        for (int i = 1; i <= COLUMN_NUM; i++) {
            for (int j = 1; j <= ROW_NUM; j++){
                Log.e("CJT","MainActivity---------- idList.add=="+i+"-"+j);
                idList.add(i+"-"+j);
            }
        }

        for (int i = 0; i < idList.size(); i++) {
            bean = new ItemBean();
            bean.setId(idList.get(i));
            bean.setPictureName("同学" + i);
            bean.setPictureResId(R.mipmap.ic_launcher);
            dataList.add(bean); // 添加到数据集合
        }

        Log.e("CJT","MainActivity----------dataList.size()=="+dataList.size());
        // 设置适配器
        mAdapter = new MyListAdapter(this, dataList, COLUMN_NUM );
        mListView.setAdapter(mAdapter);
    }


}
