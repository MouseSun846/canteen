package com.hdu.canteen.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.web.JsonPath;

import java.math.BigDecimal;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/7 19:38
 */
@Data
public class ProductInfoVO {
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}
