package com.imooc.weixin.entry.message.req;

/**
 * 文本消息
 * @author conshu
 * @date 2018/9/15.
 */
public class TextMessage extends BaseMessage {
    //消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
