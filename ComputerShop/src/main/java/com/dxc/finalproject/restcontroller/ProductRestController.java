/*
	Code of me
*/
package com.dxc.finalproject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.finalproject.dao.ProductDAO;
import com.dxc.finalproject.model.Product;

@RestController
@RequestMapping("/productr")
public class ProductRestController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@GetMapping(value="/allProduct",headers = "Accept=application/json")
	public List<Product> listProduct(){
		List<Product> list = productDAO.findAllProduct();
		return list;
	}
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Product getProduct(@PathVariable("id") String id) {
        Product product = productDAO.findProductById(Integer.parseInt(id));
        return product;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json")
    public Product saveProduct(Product p) {
        productDAO.addProduct(p);
        return p;
    }
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product p) {
        boolean b =productDAO.updateProduct(p);
        return p;
    }
}
