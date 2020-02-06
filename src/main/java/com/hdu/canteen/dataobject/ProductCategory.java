package com.hdu.canteen.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/5 20:19
 * @DynamicUpdate 动态更新，在读取数据时候，顺便设置数据，数据库就得到了更新
 */
@Entity
@Proxy(lazy = false)
@DynamicUpdate
@Data
public class ProductCategory {
    /**
     * 类目id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类目的名字
     */
    private String categoryName;
    /**
     * 类目的编号
     */
    private Date createTime;
    private Date updateTime;
    private Integer categoryType;

    public ProductCategory() {
    }
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
