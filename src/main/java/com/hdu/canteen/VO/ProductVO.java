package com.hdu.canteen.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hdu.canteen.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * 商品包含的类目
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/7 19:36
 */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
