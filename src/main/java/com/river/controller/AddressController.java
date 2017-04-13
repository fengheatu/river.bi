package com.river.controller;

import com.river.entity.Address;
import com.river.entity.User;
import com.river.service.AddressService;
import com.river.utils.CreateUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AddressController {

	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	@Resource
	AddressService addressService;
	
	
	@RequestMapping("/addAddress")
	public  String addAddress(HttpServletRequest request,HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		logger.info("用户【" + user.getUserId() + "】 添加地址信息");
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
		logger.info("用户【" + user.getUserId() + "】 修改地址信息");
		address.setUser(user);
		addressService.updateAddress(address);
		List<Address> addressList = addressService.findAddressByUserId(user.getUserId());
		request.setAttribute("addressList", addressList);
		return "userjsps/userdojsp/order/order.jsp";
	}
	
	
	@RequestMapping("/findByAddressId")
	public String findByAddressId(HttpServletRequest request) {
		String addressId = request.getParameter("addressId");
		logger.info("查找【" + addressId + "】 地址信息");
		request.setAttribute("address", addressService.findByAddressId(addressId));

		return "userjsps/userdojsp/address/updateAddress.jsp";

	}
	
	@RequestMapping("/deleteAddress")
	public String deleteAddress(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		String addressId =request.getParameter("addressId");
		addressService.deleteAddressByAddressId(addressId);
		logger.info("用户【" + user.getUserId() + "】删除【" + addressId + "】 地址信息");
		List<Address> addressList = addressService.findAddressByUserId(user.getUserId());
		request.setAttribute("addressList", addressList);
		return "userjsps/userdojsp/order/order.jsp";
	}
}
