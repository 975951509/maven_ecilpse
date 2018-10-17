package cn.xiaochui.service;

import cn.xiaochui.dao.ProductDao;
import cn.xiaochui.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Productservice {
    public List<Product> findAll();
    public void save(Product product);
}
