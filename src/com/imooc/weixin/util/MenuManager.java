package com.imooc.weixin.util;

import com.imooc.weixin.entry.Menu.*;
import com.imooc.weixin.common.AccessTokenInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MenuManager {
        private static Logger log = LoggerFactory.getLogger(MenuManager.class);
        /*
        static {
            String path1 = System.getProperty("user.dir");
            PropertyConfigurator.configure(path1 + "/config/log4j.properties");
        }

*/


        public static void wxMenu() {
            // 第三方用户唯一凭证
            //String appId = "wx1274d2b852be5d40";
            // 第三方用户唯一凭证密钥
            //String appSecret = "9f5c0cb2b9c181c40152127b05584d3b";

            // 调用接口获取access_token
            //AccessToken at = AccessTokenServlet.getAccessToken(appId, appSecret);
            //AccessTokenInfo.accessToken


            if (null != AccessTokenInfo.accessToken) {
                // 调用接口创建菜单
                int result = MenuUtil.createMenu(getMenu(), AccessTokenInfo.accessToken.getAccessToken());

                // 判断菜单创建结果
                if (0 == result)
                    log.info("菜单创建成功！");
                else
                    log.error("菜单创建失败，错误码：" + result);


                //Logger log = LoggerFactory.getLogger(M.class);
                //log.debug( " debug " );
                //log.error( " error " );
            }
        }

        /**
         * 组装菜单数据
         *
         * @return
         */
        private static Menu getMenu() {
            CommonButton btn11 = new CommonButton();
            btn11.setName("天气预报");
            btn11.setType("click");
            btn11.setKey("11");

            CommonButton btn12 = new CommonButton();
            btn12.setName("公交查询");
            btn12.setType("click");
            btn12.setKey("12");

            CommonButton btn13 = new CommonButton();
            btn13.setName("周边搜索");
            btn13.setType("click");
            btn13.setKey("13");

            CommonButton btn14 = new CommonButton();
            btn14.setName("美食天下");
            btn14.setType("click");
            btn14.setKey("14");

            CommonButton btn21 = new CommonButton();
            btn21.setName("歌曲点播");
            btn21.setType("click");
            btn21.setKey("21");

            CommonButton btn22 = new CommonButton();
            btn22.setName("经典游戏");
            btn22.setType("click");
            btn22.setKey("22");

            CommonButton btn23 = new CommonButton();
            btn23.setName("美女电台");
            btn23.setType("click");
            btn23.setKey("23");

            CommonButton btn24 = new CommonButton();
            btn24.setName("人脸识别");
            btn24.setType("click");
            btn24.setKey("24");

            CommonButton btn25 = new CommonButton();
            btn25.setName("聊天唠嗑");
            btn25.setType("click");
            btn25.setKey("25");

            CommonButton btn31 = new CommonButton();
            btn31.setName("Q友圈");
            btn31.setType("click");
            btn31.setKey("31");

            CommonButton btn32 = new CommonButton();
            btn32.setName("电影排行榜");
            btn32.setType("view");
            btn32.setUrl("http://www.baidu.com");

            CommonButton btn33 = new CommonButton();
            btn33.setName("考勤查询2");
            btn33.setType("click");
            btn33.setKey("33");


            /**
             * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
             */

            ComplexButton mainBtn1 = new ComplexButton();
            mainBtn1.setName("生活助手");
            //一级下有4个子菜单
            mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });


            ComplexButton mainBtn2 = new ComplexButton();
            mainBtn2.setName("休闲驿站");
            mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });


            ComplexButton mainBtn3 = new ComplexButton();
            mainBtn3.setName("更多体验");
            mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });


            /**
             * 封装整个菜单
             */
            Menu menu = new Menu();
            menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

            return menu;
        }
    }

