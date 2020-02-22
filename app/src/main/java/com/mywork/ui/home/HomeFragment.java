package com.mywork.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mywork.R;
import com.mywork.base.BaseFragment;
import com.mywork.interfaces.IBasePersenter;
import com.mywork.interfaces.home.HomeConstract;
import com.mywork.models.beans.IndexBean;
import com.mywork.persenters.home.HomePersenter;

public class HomeFragment extends BaseFragment<HomeConstract.Persenter> implements HomeConstract.View {


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getIndexData();
    }

    @Override
    protected HomeConstract.Persenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void getIndexDataReturn(IndexBean result) {
        //数据加载返回
        Log.i("result",result.getData().toString());
    }
}