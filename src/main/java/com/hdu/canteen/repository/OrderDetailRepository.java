package com.hdu.canteen.repository;

import com.hdu.canteen.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MouseSun
 * @Address 杭州电子科技大学
 * @date 2020/2/9 19:22
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
