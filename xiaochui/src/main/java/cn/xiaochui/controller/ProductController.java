package cn.xiaochui.controller;

import cn.xiaochui.domain.Product;
import cn.xiaochui.service.Productservice;
import cn.xiaochui.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private Productservice service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> ps = service.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list1");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Product product){
        service.save(product);
        return "redirect:findAll.do";
    }
}
