package com.hdu.canteen.services.Impl;

import com.hdu.canteen.dataobject.ProductInfo;
import com.hdu.canteen.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServicesImplTest {

    @Autowired
    private ProductServicesImpl productServices;
    @Test
    public void findOne() {
        ProductInfo result = productServices.findOne("123456");
        System.out.println(result);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productServices.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        /*查询第0页，每页两条数据*/
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = productServices.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productServices.save(productInfo);
        Assert.assertNotNull(result);
    }
}