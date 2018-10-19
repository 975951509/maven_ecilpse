package cn.xiaochui.controller;


import cn.xiaochui.domain.Orders;
import cn.xiaochui.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Orders的控制器
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                 @RequestParam(name = "size",required = true,defaultValue = "2") int size  ){
        ModelAndView mv=new ModelAndView();
        List<Orders> list = service.findAll(page,size);
        PageInfo info = new PageInfo(list);
        mv.addObject("pageInfo",info);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv=new ModelAndView();
        Orders orders = service.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
