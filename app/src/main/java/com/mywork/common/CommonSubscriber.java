package com.mywork.common;

import android.text.TextUtils;

import com.mywork.interfaces.IBaseView;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private IBaseView view;
    private String tips;
    public CommonSubscriber(IBaseView view){
        this.view = view;
    }

    public CommonSubscriber(IBaseView view,String tips){
        this.view = view;
        this.tips = tips;
    }

    @Override
    public void onError(Throwable t) {
        if(view != null){
            if(!TextUtils.isEmpty(tips)){
                view.showTips(tips);
            }
            if(!TextUtils.isEmpty(t.getMessage())){
                view.showTips(t.getMessage());
            }
        }
    }

    @Override
    public void onComplete() {

    }
}
