package com.river.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.river.entity.Address;
import com.river.entity.User;
import com.river.service.AddressService;
import com.river.utils.CreateUUID;

import static com.oracle.jrockit.jfr.ContentType.Address;

@Controller
public class AddressController {
	
	@Resource
	AddressService addressService;
	
	
	@RequestMapping("/addAddress")
	public  String addAddress(HttpServletRequest request,HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		Address address = new Address();
		address.setAddressId(CreateUUID.uuid());
		address.setUser(user);
		address.setAddress(request.getParameter("address"));
		address.setPhone(request.getParameter("phone"));
		address.setZipcode(request.getParameter("zipcode"));
		address.setConsignee(request.getParameter("consignee"));
		addressService.addAddress(address);
		List<Address> addressList = addressService.findAddressByUserId(user.getUserId());
		request.setAttribute("addressList", addressList);
		return "userjsps/userdojsp/order/order.jsp";
	}
	
	@RequestMapping("/updateAddress")
	public String updateAddress(HttpServletRequest request,Address address) {
		User user = (User)request.getSession().getAttribute("user");
		address.setUser(user);
		addressService.updateAddress(address);
		List<Address> addressList = addressService.findAddressByUserId(user.getUserId());
		request.setAttribute("addressList", addressList);
		return "userjsps/userdojsp/order/order.jsp";
	}
	
	
	@RequestMapping("/findByAddressId")
	public String findByAddressId(HttpServletRequest request) {
		String addressId = request.getParameter("addressId");
		request.setAttribute("address", addressService.findByAddressId(addressId));
		
		return "userjsps/userdojsp/address/updateAddress.jsp";
	}
	
	@RequestMapping("/deleteAddress")
	public String deleteAddress(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		addressService.deleteAddressByAddressId(request.getParameter("addressId"));
		List<Address> addressList = addressService.findAddressByUserId(user.getUserId());
		request.setAttribute("addressList", addressList);
		return "userjsps/userdojsp/order/order.jsp";
	}
}
