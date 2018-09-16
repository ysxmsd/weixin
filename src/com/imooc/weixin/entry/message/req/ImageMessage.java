package com.imooc.weixin.entry.message.req;

/**
 * 图片消息
 * @author conshu
 * @date 2018/9/15.
 */
public class ImageMessage extends BaseMessage {

    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
