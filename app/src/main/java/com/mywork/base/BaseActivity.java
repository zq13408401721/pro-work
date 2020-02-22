package com.mywork.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mywork.interfaces.IBaseView;
import com.mywork.interfaces.IBasePersenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends IBasePersenter> extends AppCompatActivity implements IBaseView {

    protected P persenter;

    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
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
        Toast.makeText(this, tips, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.dettachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }
}
