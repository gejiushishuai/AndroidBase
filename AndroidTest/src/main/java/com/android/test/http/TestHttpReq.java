package com.android.test.http;

import android.os.Handler;
import android.support.v4.util.ArrayMap;

import com.android.base.common.utils.HandlerUtil;
import com.android.base.http.OkHttpClientManager;
import com.android.base.http.callback.ResultCallback;
import com.android.base.http.request.OkHttpRequest;
import com.android.test.AppConfig;
import com.apkfuns.logutils.LogUtils;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/9 0009.
 */
public class TestHttpReq {

    public static final String reqUrl1 = "https://api.douban.com/v2/user/googolmo";
    //public static final String reqUrl2 = "http://ixiada.153.cn:50081/exter.shtml?baseLine=400&serviceType=1007";
    //public static final String reqUrl2 = "http://110.84.128.74:8081/geyeapi/geye/getRtsp?geyeId=1590&isNeedff=1";
    public static final String reqUrl2 = "http://110.84.128.74:8081/geyeapi/geye/getRtsp";

    public static void request1(final Handler handler) {
        /*OkHttpClientManager.getAsyn(reqUrl1, new OkHttpClientManager.ResultCallback<String>() {

            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_GET_FAIL);
            }

            @Override
            public void onResponse(String response) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_GET_SUCCESS, response.toString());
            }
        });*/
        new OkHttpRequest.Builder().url(reqUrl1).get(new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_GET_FAIL);
            }

            @Override
            public void onResponse(String response) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_GET_SUCCESS, response.toString());
            }
        });
    }

    public static void request2(final Handler handler) {

        ArrayMap<String, String> map = new ArrayMap<String, String>();
        map.put("geyeId", "1590");
        map.put("isNeedff", "1");

        /*OkHttpClientManager.postAsyn(reqUrl2, map, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_FAIL);
            }

            @Override
            public void onResponse(String response) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_SUCCESS, response);
            }
        });*/

        new OkHttpRequest.Builder().url(reqUrl2).params(map).post(new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_FAIL);
            }

            @Override
            public void onResponse(String response) {
                LogUtils.e(response);
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_SUCCESS, response);
            }
        });

    }

    public static void request3(final Handler handler) {

        ArrayMap<String, String> map = new ArrayMap<String, String>();
        map.put("geyeId", "1590");
        map.put("isNeedff", "1");

        /*OkHttpClientManager.postAsyn(reqUrl2, map, new OkHttpClientManager.ResultCallback<TestBean>() {
            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_FAIL_FOR_BEAN);
            }

            @Override
            public void onResponse(TestBean response) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_SUCCESS_FOR_BEAN, response);
            }
        });*/

        new OkHttpRequest.Builder().url(reqUrl2).params(map).post(new ResultCallback<TestBean>() {
            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_FAIL_FOR_BEAN);
            }

            @Override
            public void onResponse(TestBean response) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_SUCCESS_FOR_BEAN, response);
            }
        });
    }

    public static void request4(final Handler handler) {

        ArrayMap<String, String> map = new ArrayMap<String, String>();
        map.put("geyeId", "1590");
        map.put("isNeedff", "1");

        /*OkHttpClientManager.postAsyn(reqUrl2, map, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_FAIL);
            }

            @Override
            public void onResponse(String response) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_POST_SUCCESS, response);
            }
        });*/

        new OkHttpRequest.Builder().url(reqUrl2).params(map).get(new ResultCallback<TestBean>() {
            @Override
            public void onError(Request request, Exception e) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_GET_FAIL_FOR_BEAN);
            }

            @Override
            public void onResponse(TestBean response) {
                HandlerUtil.sendMessage(handler, AppConfig.REQUEST_GET_SUCCESS_FOR_BEAN, response);
            }
        });

    }
}