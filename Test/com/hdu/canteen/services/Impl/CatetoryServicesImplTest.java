package com.hdu.canteen.services.Impl;

import com.hdu.canteen.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatetoryServicesImplTest {
    @Autowired
    private CatetoryServicesImpl catetoryServices;
    @Test
    public void findeOne() {
        ProductCategory category = catetoryServices.getOne(1);
        System.out.println(category);

    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = catetoryServices.findAll();
        System.out.println(productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = catetoryServices.findByCategoryTypeIn(Arrays.asList(1, 2));
        System.out.println(productCategoryList.size());

    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专享", 5);
        ProductCategory result = catetoryServices.save(productCategory);
        Assert.assertNotNull(result);
    }
}