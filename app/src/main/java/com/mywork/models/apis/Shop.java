package com.mywork.models.apis;

import com.mywork.models.beans.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Shop {

    @GET("index")
    Flowable<IndexBean> getIndexData();

}
