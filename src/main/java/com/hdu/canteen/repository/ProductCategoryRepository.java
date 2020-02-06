package com.hdu.canteen.repository;

import com.hdu.canteen.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/5 20:25
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
