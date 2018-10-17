package cn.xiaochui.service.impl;

import cn.xiaochui.service.Productservice;
import cn.xiaochui.dao.ProductDao;
import cn.xiaochui.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements Productservice{
    @Autowired
    private ProductDao dao;
    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Product product) {
     dao.save(product);
    }
}
