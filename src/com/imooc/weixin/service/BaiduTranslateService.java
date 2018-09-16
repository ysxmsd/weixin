package com.imooc.weixin.service;

import com.google.gson.Gson;
import com.imooc.weixin.entry.baidufayi.TransApi;
import com.imooc.weixin.entry.baidufayi.TranslateResult;

/**
 * @author conshu
 * @date 2018/9/15.
 */
public class BaiduTranslateService {

    /**
     * 发起http请求获取返回结果
     *
     * @param requestUrl 请求地址
     * @return
     */
    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20180914000207112";
    private static final String SECURITY_KEY = "iUDu6YNf5wqaLpk3QfJ5";

    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    public static String baiduTrans(String query) {

        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String dst=null;
        // 查询并解析结果
        try {
            // 查询并获取返回结果
            String json = (api.getTransResult(query, "auto", "auto"));
            // 通过Gson工具将json转换成TranslateResult对象
            TranslateResult translateResult = new Gson().fromJson(json, TranslateResult.class);
            // 取出translateResult中的译文
            dst = translateResult.getTrans_result().get(0).getDst();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null == dst)
            dst = "翻译系统异常，请稍候尝试！";
        return dst;
    }


}
