package com.hdu.canteen.controller;

import com.hdu.canteen.Utils.ResultVOUtil;
import com.hdu.canteen.VO.ProductInfoVO;
import com.hdu.canteen.VO.ProductVO;
import com.hdu.canteen.VO.ResultVO;
import com.hdu.canteen.dataobject.ProductCategory;
import com.hdu.canteen.dataobject.ProductInfo;
import com.hdu.canteen.services.CatetoryServices;
import com.hdu.canteen.services.ProductServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**'买家商品
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/7 19:10
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private CatetoryServices categoryServices;
    @GetMapping("/list")
    public ResultVO list(){
        /*1、查询所有上架的商品*/
        List<ProductInfo> productInfoList = productServices.findUpAll();
        /*2、查询类目(一次性查询)*/
        ArrayList<Integer> categoryList =new ArrayList<>();
        /*精简方法 lamba表达式*/
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryServices.findByCategoryTypeIn(categoryTypeList);
        /*3、数据拼装*/
        ArrayList<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList ) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            ArrayList<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
