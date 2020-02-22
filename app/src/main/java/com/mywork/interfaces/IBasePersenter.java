package com.mywork.interfaces;

public interface IBasePersenter<V extends IBaseView> {

    void attachView(V view);

    void dettachView();

}
