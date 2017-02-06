package com.king.girl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.king.base.BaseFragment;
import com.king.base.model.EventMessage;
import com.king.base.util.LogUtils;
import com.king.base.util.SharedPreferencesUtils;
import com.king.base.util.SystemUtils;
import com.king.girl.Constants;
import com.king.girl.MainActivity;
import com.king.girl.R;
import com.king.girl.activity.ContentActivity;
import com.king.girl.adapter.EsayGirlAdapter;
import com.king.girl.http.APIRetrofit;
import com.king.girl.http.APIService;
import com.king.girl.model.GirlResult;
import com.king.girl.util.DensityUtil;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/11
 */
public class GirlsFragment extends BaseFragment implements MainActivity.OnScrollListener {



    public enum LayoutType{
        LinearLayout,GridLayout,StaggeredGridLayout
    }

    private LayoutType layoutType = LayoutType.StaggeredGridLayout;

    private static final int PAGE_SIZE = 20;

    private TextView tvTips;

    private EasyRecyclerView recyclerView;

    private EsayGirlAdapter esayGirlAdapter;

    private List<GirlResult.Girl> listData;

    private int curPage;

    public static GirlsFragment newInstance(LayoutType layoutType) {

        Bundle args = new Bundle();

        GirlsFragment fragment = new GirlsFragment();
        fragment.setArguments(args);
        fragment.layoutType = layoutType;
        return fragment;
    }

    @Override
    public void onScroll() {
        if(recyclerView!=null)
            recyclerView.scrollToPosition(0);
    }

    @Override
    public int inflaterRootView() {
        return R.layout.fragment_girl;
    }

    @Override
    public void initUI() {

        recyclerView = findView(R.id.recyclerView);

        tvTips = (TextView) recyclerView.findViewById(R.id.tvTips);

        listData = new ArrayList<>();
        esayGirlAdapter = new EsayGirlAdapter(context,listData,layoutType == LayoutType.GridLayout);

        initLayoutManager(layoutType);

        SpaceDecoration spaceDecoration = new SpaceDecoration(DensityUtil.dp2px(context,2));
        recyclerView.addItemDecoration(spaceDecoration);
//        recyclerView.setRefreshingColor(R.color.colorPrimary);
        recyclerView.setRefreshingColorResources(R.color.colorPrimary);

        recyclerView.setAdapter(esayGirlAdapter );

        esayGirlAdapter.setMore(R.layout.load_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                getGirls(curPage,PAGE_SIZE);
            }
        });

//        recyclerView.addItemDecoration(new DividerGridItemDecoration(context));

    }

    private void initLayoutManager(LayoutType layoutType){
        switch (layoutType){
            case LinearLayout:
                recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
                break;
            case GridLayout:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
                gridLayoutManager.setSpanSizeLookup(esayGirlAdapter.obtainGridSpanSizeLookUp(2));
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
            case StaggeredGridLayout:
            default:
                final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
                recyclerView.getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        //防止第一行到顶部有空白区域
                        staggeredGridLayoutManager.invalidateSpanAssignments();
                    }
                });
                break;
        }
    }

    @Override
    public void addListeners() {

        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                curPage = 1;
                getGirls(curPage,PAGE_SIZE);
            }
        });

        esayGirlAdapter.setOnClickHolderItemListener(new EsayGirlAdapter.OnClickHolderItemListener() {
            @Override
            public void onItemClick(BaseViewHolder holder, int position) {
                startGirlDetail((ArrayList<GirlResult.Girl>) esayGirlAdapter.getAllData(),position,holder.itemView);
            }
        });

    }

    /**
     *
     * @param listData
     * @param position
     * @param source
     */
    private void startGirlDetail(ArrayList<GirlResult.Girl> listData,int position,View source){
        Intent intent = new Intent(context, ContentActivity.class);
        intent.putExtra(KEY_FRAGMENT,ContentActivity.GIRL_DETAIL_FRAGMENT);
        intent.putParcelableArrayListExtra(Constants.LIST_GIRL,listData);
        intent.putExtra(Constants.CURRENT_POSTION,position);

        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(source,source.getWidth()/2,source.getHeight()/2,0,0);
        ActivityCompat.startActivity(getActivity(),intent,activityOptionsCompat.toBundle());
    }


    @Override
    public void initData() {

        curPage = 1;
        getGirls(curPage,PAGE_SIZE);

    }


    private <T> void toSetList(List<T> list,List<T> newList,boolean isMore){

        if(list == null || newList == null)
            return;

        if(!isMore){
            list.clear();
        }
        list.addAll(newList);

    }


    private void getGirls(final int page,final int size){

        APIRetrofit.getIntance()
                .create(APIService.class)
                .getGirs("福利",size,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlResult>() {
                    @Override
                    public void onCompleted() {
                        LogUtils.d("onCompleted");
                        recyclerView.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e);

                        if(SystemUtils.isNetWorkActive(context)){
                            tvTips.setText(R.string.page_load_failed);
                        }else{
                            tvTips.setText(R.string.network_unavailable);
                        }

                        recyclerView.showError();
                    }

                    @Override
                    public void onNext(GirlResult girlResult) {
                        LogUtils.d(girlResult.toString());
                        if(!girlResult.isError()){
//                            toSetList(listData,girlResult.getResults(),page>1);
                            List<GirlResult.Girl> list = girlResult.getResults();
                            if(page<=1){
                                esayGirlAdapter.clear();
                                if(list!=null && list.size()>0){
                                    SharedPreferencesUtils.put(context,Constants.FIRST_GIRL_URL,list.get(0).getUrl());
                                }
                            }
                            esayGirlAdapter.addAll(girlResult.getResults());
//                            refreshView();
                            if(esayGirlAdapter.getCount() >= page * size){
                                curPage++;
                            }else if(esayGirlAdapter.getCount()==0){
                                recyclerView.showEmpty();
                            }

                        }else{
                            recyclerView.showEmpty();
                        }
                    }
                });
    }


    @Override
    public void onEventMessage(EventMessage em) {

    }
}
