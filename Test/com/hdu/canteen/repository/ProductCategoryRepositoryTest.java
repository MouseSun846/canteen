package com.hdu.canteen.repository;

import com.hdu.canteen.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.getOne(1);
        System.out.println(productCategory);
    }
    @Test
    public void saveTest(){
//        ProductCategory productCategory = repository.getOne(1);
//        productCategory.setCategoryType(1);
        ProductCategory productCategory = new ProductCategory("宝宝不爱",22);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> type = Arrays.asList(1, 3, 22);
        List<ProductCategory> result = repository.findByCategoryTypeIn(type);
        Assert.assertNotEquals(0,result.size());
    }
}