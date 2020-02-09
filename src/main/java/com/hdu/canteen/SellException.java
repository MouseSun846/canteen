package com.hdu.canteen;

import com.hdu.canteen.enums.ResultEnum;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 20:22
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
