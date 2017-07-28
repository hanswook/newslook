package com.demo.newsdemo.adapter;

import android.widget.TextView;

import com.demo.newsdemo.R;
import com.demo.newsdemo.bean.StoriesBean;
import com.demo.newsdemo.utils.recycler.BaseViewHolder;
import com.demo.newsdemo.utils.recycler.ItemViewDelegate;


/**
 * Created by hans on 2017/5/15 11:19.
 */

public class ZhihuDateDelegate implements ItemViewDelegate<StoriesBean> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recycler_date_layout;
    }

    @Override
    public boolean isForViewType(StoriesBean item, int position) {
        if (item.getDelegateType()==1){
            return true;
        }
        return false;
    }

    @Override
    public void convert(BaseViewHolder holder, StoriesBean storiesBean, int position) {
        TextView dateSpace=holder.getView(R.id.item_date_space);
        dateSpace.setText(storiesBean.getDataDate());

    }
}
