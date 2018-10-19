package cn.xiaochui.service;

import cn.xiaochui.dao.OrdersDao;
import cn.xiaochui.domain.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findAll( int page,int size);
    public Orders findById(String id);
}
