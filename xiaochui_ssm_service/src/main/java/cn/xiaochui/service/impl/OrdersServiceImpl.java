package cn.xiaochui.service.impl;

import cn.xiaochui.dao.OrdersDao;
import cn.xiaochui.domain.Orders;

import cn.xiaochui.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao dao;

    public List<Orders> findAll( int page,int size) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page,size);
        return dao.findAll();
    }
}
