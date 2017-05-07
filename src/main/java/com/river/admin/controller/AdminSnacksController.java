package com.river.admin.controller;

import com.river.entity.Category;
import com.river.entity.Snacks;
import com.river.entity.UploadFile;
import com.river.service.CategoryService;
import com.river.service.SnacksService;
import com.river.service.UploadFileService;
import com.river.utils.CreateUUID;
import com.river.utils.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminSnacksController {

	@Resource
	SnacksService snacksService;

	@Resource
	CategoryService categoryService;

	@Resource
	UploadFileService uploadFileService;

	@RequestMapping("/showSnacks")
	public String showSnacks(HttpServletRequest request, @RequestParam int page) {
		showAllSnacks(request, page);
		return "../adminjsps/admin/snacks/list.jsp";
	}

	/**
	 * 获取请求连接
	 *
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = request.getQueryString();
		String url = contextPath + servletPath + "?" + queryString;
		if (url.contains("page=")) {
			int index = url.indexOf("page=");
			return url.substring(0, index);
		} else {
			return url;
		}
	}

	@RequestMapping("/findSnacksById")
	public String findSnacksById(HttpServletRequest request) {

		request.setAttribute("snacks",snacksService.findById(request.getParameter("snacksId")));
		List<Category> categoryList = categoryService.getAllCategory();
		request.setAttribute("categoryList", categoryList);
		return "../adminjsps/admin/snacks/desc.jsp";
	}

	@RequestMapping("/adminUpdateSnacksById")
	public String adminUpdateSnacksById(@RequestParam("image") MultipartFile image,HttpServletRequest request) {

		String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"snacksImages/";
		String snacksId = CreateUUID.uuid();
		String  fileName = image.getOriginalFilename();
		String   rex = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = snacksId + File.separator + System.currentTimeMillis() + rex;
		String fileUrl = uploadUrl + newFileName;
		File file = new File(uploadUrl);
		if(!file.exists()) {
			file.mkdirs();
		}
		try {
			image.transferTo(new File(fileUrl));
		} catch (IOException e) {
			e.printStackTrace();
		}


		Snacks snacks = new Snacks();
		snacks.setSnacksId(request.getParameter("snacksId"));
		snacks.setSnackName(request.getParameter("snackName"));
		snacks.setState(Integer.valueOf(request.getParameter("state")));
		snacks.setCategoryId(request.getParameter("categoryId"));
		snacks.setDescription(request.getParameter("description"));
		snacks.setImage(newFileName);
		snacks.setPrice(Double.valueOf(request.getParameter("price")));
		snacksService.adminUpdateSnacksById(snacks);
		showAllSnacks(request, 1);
		return "../adminjsps/admin/snacks/list.jsp";
	}



	public void showAllSnacks(HttpServletRequest request,int page) {
		if (page <= 0) {
			page = 1;
		}
		int pageSize = 45;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", ((page - 1) * pageSize));
		map.put("pageSize", pageSize);
		List<Snacks> snacksList = snacksService.getPageBean(map);
		PageBean<Snacks> pageBean = new PageBean<Snacks>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeanList(snacksList);
		pageBean.setTotalcount(snacksService.getTotalcount());
		pageBean.setUrl(getUrl(request));
		request.setAttribute("pageBean", pageBean);
	}

	@RequestMapping("/adminAddSnacks")
	public String adminAddSnacks(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest  request) {

		String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"snacksImages/";
		String snacksId = CreateUUID.uuid();

		File dir = new File(uploadUrl,snacksId);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		Snacks snacks = new Snacks();
		int i = 1;
		for(CommonsMultipartFile file : files ) {
			String  fileName = file.getOriginalFilename();
			String   rex = fileName.substring(fileName.lastIndexOf("."));
			String newFileName =snacksId + File.separator +  System.currentTimeMillis() + rex;
			String fileUrl = uploadUrl + newFileName;
			File dirFile = new File(fileUrl);
			if(i<=1) {
				snacks.setImage(newFileName);
				try {
					file.transferTo(dirFile);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				++i;
				continue;
			}
			UploadFile uploadFile = new UploadFile();
			uploadFile.setId(CreateUUID.uuid());
			uploadFile.setFileName(fileName);
			uploadFile.setSnacksId(snacksId);
			uploadFile.setUrl(newFileName);
			uploadFile.setReateTime(new Date());
			try {
				file.transferTo(dirFile);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			uploadFileService.insertSelective(uploadFile);
		}

		/*File targetFile = new File(uploadUrl,filename);
		if(!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}*/


		snacks.setSnacksId(snacksId);
		snacks.setCategoryId(request.getParameter("categoryId"));
		snacks.setDescription(request.getParameter("description"));
		snacks.setPrice(Double.valueOf(request.getParameter("price")));
		snacks.setSnackName(request.getParameter("snackName"));
		snacks.setState(Integer.valueOf(request.getParameter("state")));
		snacksService.adminAddSnacks(snacks);
		request.setAttribute("msg", "添加成功");
		request.setAttribute("categoryList",categoryService.getAllCategory());
		return "../adminjsps/admin/snacks/add.jsp";
	}
}