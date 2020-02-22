package com.mywork.persenters.home;

import com.mywork.base.BasePersenter;
import com.mywork.common.CommonSubscriber;
import com.mywork.interfaces.home.HomeConstract;
import com.mywork.models.HttpManager;
import com.mywork.models.beans.IndexBean;
import com.mywork.utils.RxUtils;

import org.greenrobot.greendao.annotation.Index;

public class HomePersenter extends BasePersenter<HomeConstract.View> implements HomeConstract.Persenter {

    @Override
    public void getIndexData() {
        addScrible(HttpManager.getInstance().getShop().getIndexData()
            .compose(RxUtils.<IndexBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<IndexBean>(mView){
            @Override
            public void onNext(IndexBean indexBean) {
                mView.getIndexDataReturn(indexBean);
            }
        }));
    }

}
