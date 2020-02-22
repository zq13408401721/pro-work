package com.mywork.base;

import com.mywork.interfaces.IBasePersenter;
import com.mywork.interfaces.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePersenter<V extends IBaseView> implements IBasePersenter<V> {

    protected V mView;

    WeakReference<V> weakReference;

    //网络请求的内存处理
    CompositeDisposable compositeDisposable;

    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<>(view);
        mView = weakReference.get();
    }

    @Override
    public void dettachView() {
        mView = null;
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }

    /**
     * 保存当前需要进行网络请求的对象
     * @param disposable
     */
    public void addScrible(Disposable disposable){
        if(compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }

}
