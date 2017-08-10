package com.demo.newsdemo.presenter;

import android.content.Context;

import com.demo.newsdemo.base.BasePresenter;
import com.demo.newsdemo.model.bean.zhihu.StoriesBean;
import com.demo.newsdemo.contract.callback.GetDataCallBack;
import com.demo.newsdemo.contract.HomeContract;
import com.demo.newsdemo.utils.LogUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by hans on 2017/7/25 13:57.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter<HomeContract.View> {

    private HomeContract.Model model;

    @Inject
    public HomePresenter(HomeContract.View mView, HomeContract.Model model) {
        this.model = model;
    }

    @Override
    public void loadData(Context context) {
        LogUtil.e(context.getClass().getSimpleName(), "loadDetailData");
        model.requestLastDailyData(context, new GetDataCallBack<List<StoriesBean>>() {
            @Override
            public void getDataSuccess(List<StoriesBean> zhihuEntity) {
                mView.updateList(zhihuEntity);
            }

            @Override
            public void getDataFailed() {
                mView.showGetdataFailed();
            }
        });
    }

    @Override
    public void loadMoreData(String date, Context context) {
        model.requestMoreData(date, context, new GetDataCallBack<List<StoriesBean>>() {
            @Override
            public void getDataSuccess(List<StoriesBean> zhihuEntity) {
                mView.updateList(zhihuEntity);
            }

            @Override
            public void getDataFailed() {
                mView.showGetdataFailed();
            }
        });
    }


}