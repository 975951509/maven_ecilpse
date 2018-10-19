package cn.xiaochui.dao;

import cn.xiaochui.domain.Member;
import cn.xiaochui.domain.Orders;
import cn.xiaochui.domain.Product;
import cn.xiaochui.domain.Traveller;
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
    @Select("select * from  orders where id=#{id}")
    @Results({
            @Result(id = true ,property = "id" ,column = "id"),
            @Result(property = "orderNum" ,column = "orderNum"),
            @Result(property = "orderTime" ,column = "orderTime"),
            @Result(property = "peopleCount" ,column = "peopleCount"),
            @Result(property = "orderDesc" ,column = "orderDesc"),
            @Result(property = "payType" ,column = "payType"),
            @Result(property = "orderStatus" ,column = "orderStatus"),
            @Result(property = "product" ,column = "productId",javaType = Product.class,one =@One(select ="cn.xiaochui.dao.ProductDao.findById" ) ),
            @Result(property = "member" ,column = "memberId",javaType = Member.class,one =@One(select ="cn.xiaochui.dao.MemberDao.findById" ) ),
            @Result(property = "traveller" ,column = "travellerId",javaType = Traveller.class,many =@Many(select ="cn.xiaochui.dao.TravellerDao.findByOrdersId" ) ),
    })
        public Orders findById(String id);
}
