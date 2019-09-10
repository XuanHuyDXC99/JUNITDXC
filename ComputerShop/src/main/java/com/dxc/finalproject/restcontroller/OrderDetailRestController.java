/*
	Code of me
*/
package com.dxc.finalproject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.finalproject.dao.OrderDetailDAO;
import com.dxc.finalproject.model.OrderDetail;


@RestController
@RequestMapping("/orderdetails")
public class OrderDetailRestController {
    @Autowired
    private OrderDetailDAO orderDetailDAO;
    
    @RequestMapping(value = "/getAllOrderDetails", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OrderDetail> getAllOrderDetails(){
        return orderDetailDAO.getAllOrderDetail();
    }
    
    
    @RequestMapping(value = "/getOdDetailsByOID/{oid}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OrderDetail> getOdDetailsByOID(@PathVariable("oid") String oid){
        return orderDetailDAO.getAllOrderDetailByOrderId(Integer.parseInt(oid));
    }
    
    
    
    @RequestMapping(value = "/orderdetail", method = RequestMethod.POST)
    public OrderDetail saveOrderDetails(@RequestBody OrderDetail orderDetail) {
        orderDetailDAO.saveOrderDetail(orderDetail);
        return orderDetail;
    }
}
