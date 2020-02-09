package com.hdu.canteen.services;

import com.hdu.canteen.dataobject.ProductInfo;
import com.hdu.canteen.dataobject.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/7 18:25
 */
public interface ProductServices {
    /*查询所有在架的商品列表*/
    ProductInfo findOne(String productId);
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
