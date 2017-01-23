package com.king.girl.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.king.girl.R;
import com.king.girl.model.GirlResult;

import java.io.File;
import java.util.List;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/23
 */
public class GirlDetailAdapter extends BasePagerAdapter<GirlResult.Girl> {


    private LayoutInflater layoutInflater;

    public GirlDetailAdapter(Context context, List<GirlResult.Girl> listData) {
        super(context,listData);
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(ViewGroup container, final GirlResult.Girl girl, int position) {
        View view = layoutInflater.inflate(R.layout.list_girl_detail_item,container,false);
        final PhotoView photoView = (PhotoView)view.findViewById(R.id.photoView);
        photoView.enable();
        Glide.with(context).load(girl.getUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(photoView);

//        photoView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//
//
//                return false;
//            }
//        });

        return view;
    }


}
