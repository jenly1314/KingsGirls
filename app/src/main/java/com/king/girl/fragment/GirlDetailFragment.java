package com.king.girl.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.king.base.BaseFragment;
import com.king.base.model.EventMessage;
import com.king.girl.R;
import com.king.girl.adapter.GirlDetailAdapter;
import com.king.girl.model.GirlResult;

import java.util.List;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/23
 */
public class GirlDetailFragment extends BaseFragment {


    private ViewPager viewPager;

    private TextView tvCount;

    private GirlDetailAdapter adapter;

    private List<GirlResult.Girl> listData;

    private int position;

    private int total;


    public static GirlDetailFragment newInstance(@NonNull List<GirlResult.Girl> listData,int position) {

        Bundle args = new Bundle();
        GirlDetailFragment fragment = new GirlDetailFragment();
        fragment.listData = listData;
        fragment.position = position;
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public int inflaterRootView() {
        return R.layout.fragment_girl_detail;
    }

    @Override
    public void initUI() {

        viewPager = findView(R.id.viewPager);
        tvCount = findView(R.id.tvCount);

        total = listData!=null ? listData.size() : 0;
    }

    @Override
    public void addListeners() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateCurPostionView(position+1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void initData() {

        adapter = new GirlDetailAdapter(context,listData);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
        updateCurPostionView(position+1);

    }

    public void updateCurPostionView(int position){
        tvCount.setText(String.format("%d/%d",position,total));
    }

    @Override
    public void onEventMessage(EventMessage em) {

    }
}
