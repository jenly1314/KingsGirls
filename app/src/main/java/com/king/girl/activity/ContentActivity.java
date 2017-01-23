package com.king.girl.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.king.base.BaseActivity;
import com.king.base.model.EventMessage;
import com.king.base.util.LogUtils;
import com.king.girl.Constants;
import com.king.girl.R;
import com.king.girl.fragment.GirlDetailFragment;
import com.king.girl.model.GirlResult;

import java.util.List;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/23
 */
public class ContentActivity extends BaseActivity {

    public static final int GIRL_DETAIL_FRAGMENT = 0X01;




    @Override
    public void initUI() {
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();

        int fragmentId = intent.getIntExtra(KEY_FRAGMENT,0);

        switch (fragmentId){
            case GIRL_DETAIL_FRAGMENT:
                List<GirlResult.Girl> listData = intent.getParcelableArrayListExtra(Constants.LIST_GIRL);
                int position = intent.getIntExtra(Constants.CURRENT_POSTION,0);
                replaceFragment(GirlDetailFragment.newInstance(listData,position));
                break;
            default:
                LogUtils.w("Not found fragment.");
                break;
        }

    }

    public void replaceFragment(Fragment fragment){
        replaceFragment(R.id.fragment_content,fragment);
    }

    @Override
    public void addListeners() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onEventMessage(EventMessage em) {

    }
}
