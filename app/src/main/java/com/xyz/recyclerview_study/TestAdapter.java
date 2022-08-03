package com.xyz.recyclerview_study;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xyz.recyclerview_study.viewholder.BaseViewHolder

import java.util.List;


public class TestAdapter extends BaseQuickAdapter<TestBean, BaseViewHolder> {


    public TestAdapter(int layoutResId, @Nullable List<TestBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, TestBean item) {

    }
}
