package com.xyz.recyclerview_study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shencoder.pagergridlayoutmanager.PagerGridLayoutManager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.set(20, 10, 20, 10);
            }
        });
         PagerGridLayoutManager layoutManager = new PagerGridLayoutManager(
               3,
                3,
                 PagerGridLayoutManager.HORIZONTAL
//                 PagerGridLayoutManager.VERTICAL
         );

        //是否反向布局
        layoutManager.setReverseLayout(false);

        layoutManager.setPagerChangedListener(new PagerGridLayoutManager.PagerChangedListener() {
            @Override
            public void onPagerCountChanged(int pagerCount) {
                Log.w(TAG, "onPagerCountChanged-pagerCount:" + pagerCount);
            }

            @Override
            public void onPagerIndexSelected(int prePagerIndex, int currentPagerIndex) {
                Log.w(TAG, "onPagerIndexSelected-prePagerIndex " + prePagerIndex + ",currentPagerIndex:" + currentPagerIndex);
            }
        });

        //设置滑动每像素需要花费的时间
        layoutManager.setMillisecondPreInch(100);
        //设置最大滚动时间
        layoutManager.setMaxScrollOnFlingDuration(500);

        rv.setLayoutManager(layoutManager);
        TestAdapter adapter = new TestAdapter();
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter1, view1, position) -> {
//            Toast.makeText(this, "点击了位置：" + position, Toast.LENGTH_SHORT).show();
        });
        //长按删除数据
        adapter.setOnItemLongClickListener((adapter12, view12, position) -> {
//            Toast.makeText(this, "删除了位置：" + position, Toast.LENGTH_SHORT).show();
//            adapter12.removeAt(position);
            return true;
        });

    }
}