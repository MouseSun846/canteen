package com.hdu.canteen.Utils;

import java.util.Random;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 20:37
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间 + 随机数
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
