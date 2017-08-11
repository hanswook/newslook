package com.demo.newsdemo.presenter;

import android.content.Context;

import com.demo.newsdemo.base.BaseActivity;
import com.demo.newsdemo.base.BaseContract;
import com.demo.newsdemo.base.BasePresenter;
import com.demo.newsdemo.model.bean.zhihu.TheStoryBean;
import com.demo.newsdemo.contract.callback.GetDataCallBack;
import com.demo.newsdemo.contract.ZhihuDetailContract;

import javax.inject.Inject;

/**
 * Created by hans on 2017/7/25 15:24.
 */

public class ZhihuDetailPresenter extends BasePresenter<ZhihuDetailContract.View> implements ZhihuDetailContract.Presenter<ZhihuDetailContract.View> {

    private ZhihuDetailContract.Model model;

    @Inject
    public ZhihuDetailPresenter(ZhihuDetailContract.View view, ZhihuDetailContract.Model model) {
        attachView(view);
        this.model = model;
    }

    @Override
    public void loadDetailData(String id) {
        model.getDetailData(mView, id, new GetDataCallBack<TheStoryBean>() {
            @Override
            public void getDataSuccess(TheStoryBean theStoryBean) {
                mView.updateUI(theStoryBean);
            }

            @Override
            public void getDataFailed() {
                mView.requestFailed();
            }
        });
    }


}
