package com.mywork.interfaces.home;

import com.mywork.interfaces.IBasePersenter;
import com.mywork.interfaces.IBaseView;
import com.mywork.models.beans.IndexBean;

public interface HomeConstract {

    interface View extends IBaseView{
        void getIndexDataReturn(IndexBean result);
    }

    interface Persenter extends IBasePersenter<View>{
        void getIndexData();
    }

}
