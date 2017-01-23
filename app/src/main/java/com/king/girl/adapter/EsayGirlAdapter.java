package com.king.girl.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.king.base.util.LogUtils;
import com.king.girl.R;
import com.king.girl.model.GirlResult;

import java.util.List;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/20
 */
public class EsayGirlAdapter extends RecyclerArrayAdapter<GirlResult.Girl> {

    private boolean isGrid;

    public EsayGirlAdapter(Context context, List<GirlResult.Girl> objects,boolean isGrid) {
        super(context, objects);
        this.isGrid = isGrid;
    }

    public void setListData(List<GirlResult.Girl> objects){
        this.mObjects = objects;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {

        GirlViewHolder girlViewHolder = new GirlViewHolder(parent, R.layout.list_girls_item);

        return girlViewHolder;
    }

    public class GirlViewHolder extends BaseViewHolder<GirlResult.Girl> {

        private ImageView iv;


        public GirlViewHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            iv = $(R.id.ivImage);
        }

        @Override
        public void setData(GirlResult.Girl data) {
            super.setData(data);
            LogUtils.d("setData:" + data);
            if(isGrid){
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
                Glide.with(getContext()).load(data.getUrl()).error(R.drawable.default_picture).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);


        }
    }
}
