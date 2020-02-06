package com.hdu.canteen.services.Impl;

import com.hdu.canteen.dataobject.ProductCategory;
import com.hdu.canteen.repository.ProductCategoryRepository;
import com.hdu.canteen.services.CatetoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/6 19:22
 */
@Service
public class CatetoryServicesImpl implements CatetoryServices {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory getOne(Integer categoryId) {
        return repository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList){
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
