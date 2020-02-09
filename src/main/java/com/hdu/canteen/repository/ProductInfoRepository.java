package com.hdu.canteen.repository;

import com.hdu.canteen.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/7 16:26
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
        List<ProductInfo> findByProductStatus(Integer productStatus);

}
