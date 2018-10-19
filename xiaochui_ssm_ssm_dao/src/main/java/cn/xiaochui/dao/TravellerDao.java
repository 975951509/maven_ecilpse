package cn.xiaochui.dao;

import cn.xiaochui.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    @Select("select * from Traveller where id=(select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findByOrdersId(String orderId);
}
