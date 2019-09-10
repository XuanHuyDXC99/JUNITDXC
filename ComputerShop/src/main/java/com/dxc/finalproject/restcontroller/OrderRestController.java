/*
	Code of me
*/
package com.dxc.finalproject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.finalproject.dao.OrderDAO;
import com.dxc.finalproject.model.Order;


@RestController
@RequestMapping("/orders")
public class OrderRestController {
    @Autowired
    private OrderDAO orderDAO;
    
    @RequestMapping(value = "/order", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Order> getAllOrders(){
        return orderDAO.getAllOrder();
    }
    
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order saveOrder(@RequestBody Order order){
        orderDAO.saveOrder(order);
        return order;
    }
}
