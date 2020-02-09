package com.hdu.canteen.services;

import com.hdu.canteen.dataobject.ProductCategory;

import java.util.List;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/6 19:19
 */
public interface CatetoryServices {
    ProductCategory getOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
