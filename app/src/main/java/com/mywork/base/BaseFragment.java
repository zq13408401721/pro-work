package com.mywork.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mywork.interfaces.IBasePersenter;
import com.mywork.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends IBasePersenter> extends Fragment implements IBaseView {

    protected P persenter;
    Unbinder unbinder;

    protected Context context;
    protected Activity activity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        activity = getActivity();
        View view = LayoutInflater.from(context).inflate(getLayout(),null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(context,view);
        persenter = createPersenter();
        if(persenter != null){
            persenter.attachView(this);
        }
        initView();
        initData();

    }

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P createPersenter();

    @Override
    public void showTips(String tips) {

    }
}
