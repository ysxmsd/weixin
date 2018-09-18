package jdbc;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author conshu
 * @date 2018/8/7.
 */
public class IniRead {

    public static String iniFileRead(String filepath, String valueKey) {
        String value="";
        try {
            //创建文件输入流
            FileInputStream fis = new FileInputStream(filepath);
            //创建Properties属性对象用来接收ini文件中的属性
            Properties pps = new Properties();
            //从文件流中加载属性
            pps.load(fis);
            //通过getProperty("属性名")获取key对应的值
            value=(pps.getProperty(valueKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}

