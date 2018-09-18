package com.imooc.weixin.util;

import com.alibaba.fastjson.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author conshu
 * @date 2018/9/16.
 */
public class DB2Entity {

    public static String DB2String(ResultSet rs,String spliceType) {

        Map<String, String> map = new HashMap<String, String>();
        //获取列表
        try {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                //遍历ResultSetMetaData数据每一列
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    map.put(columnName, value);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            }

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append(spliceType);
        }

        sb.deleteCharAt(sb.lastIndexOf(spliceType));
        return sb.toString();
    }
}
