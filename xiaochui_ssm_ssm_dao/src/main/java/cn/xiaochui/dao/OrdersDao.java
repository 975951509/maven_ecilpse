package cn.xiaochui.dao;

import cn.xiaochui.domain.Orders;
import cn.xiaochui.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from  orders")
    @Results({
            @Result(id = true ,property = "id" ,column = "id"),
            @Result(property = "orderNum" ,column = "orderNum"),
            @Result(property = "orderTime" ,column = "orderTime"),
            @Result(property = "peopleCount" ,column = "peopleCount"),
            @Result(property = "orderDesc" ,column = "orderDesc"),
            @Result(property = "payType" ,column = "payType"),
            @Result(property = "orderStatus" ,column = "orderStatus"),
            @Result(property = "product" ,column = "productId",javaType = Product.class,one =@One(select ="cn.xiaochui.dao.ProductDao.findById" ) ),
    })
    public List<Orders> findAll();
}
