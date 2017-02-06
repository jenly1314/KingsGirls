package com.king.girl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.king.base.adapter.ViewHolderRecyclerAdapter;
import com.king.base.adapter.holder.ViewHolder;
import com.king.girl.R;
import com.king.girl.model.GirlResult;

import java.util.List;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/12
 */
public class GirlAdapter extends ViewHolderRecyclerAdapter<GirlResult.Girl> {

    public GirlAdapter(Context context, List<GirlResult.Girl> listData) {
        super(context, listData);
    }

    @Override
    public View buildConvertView(LayoutInflater layoutInflater, int viewType) {
        return inflate(R.layout.list_girls_item);
    }

    @Override
    public void bindViewDatas(ViewHolder holder, GirlResult.Girl girl, int position) {
        ImageView iv = holder.getView(R.id.ivImage);
//        ViewGroup.LayoutParams lp = iv.getLayoutParams();
//        lp.width = context.getResources().getDisplayMetrics().widthPixels / 2;
//        iv.setLayoutParams(lp);
        Glide.with(context).load(girl.getUrl()).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
    }
}
