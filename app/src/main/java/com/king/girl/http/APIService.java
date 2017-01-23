package com.king.girl.http;

import com.king.girl.model.GirlResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2016/10/11
 */
public interface APIService {


    /**
     *
     * @param type 可选参数: Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * @param count
     * @param page
     * @return
     */
    @GET("api/data/{type}/{count}/{page}")
    Observable<GirlResult> getGirs(@Path("type") String type, @Path("count") int count, @Path("page") int page);


}
