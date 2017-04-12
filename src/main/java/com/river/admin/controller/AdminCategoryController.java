package com.river.admin.controller;

import com.river.entity.Category;
import com.river.service.CategoryService;
import com.river.utils.CreateUUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

    @Resource
    CategoryService categoryService;

    @RequestMapping("/adminFindAllCategory")
    public String adminFindAllCategory(HttpServletRequest request) {

        request.setAttribute("categoryList", categoryService.getAllCategory());
        return "../adminjsps/admin/category/list.jsp";
    }


    @RequestMapping("/adminAddCategory")
    public String adminAddCategory(HttpServletRequest request) {

        Category category = new Category();
        category.setCategoryId(CreateUUID.uuid());
        category.setCategoryName(request.getParameter("categoryName"));
        categoryService.adminAddCategory(category);
        request.setAttribute("categoryList", categoryService.getAllCategory());
        return "../adminjsps/admin/category/list.jsp";
    }

    @RequestMapping("/adminDelCategory")
    public String adminDelCategory(HttpServletRequest request) {

        categoryService.adminDelCategory(request.getParameter("categoryId"));

        request.setAttribute("categoryList", categoryService.getAllCategory());
        return "../adminjsps/admin/category/list.jsp";
    }

    @RequestMapping("/adminFindBycategoryId")
    public String adminFindBycategoryId(HttpServletRequest request) {

        request.setAttribute("category", categoryService.adminFindBycategoryId(request.getParameter("categoryId")));
        return "../adminjsps/admin/category/mod.jsp";
    }


    @RequestMapping("/adminUpdateCategory")
    public String adminUpdateCategory(HttpServletRequest request, Category category) {

        categoryService.adminUpdateCategory(category);
        request.setAttribute("categoryList", categoryService.getAllCategory());
        return "../adminjsps/admin/category/list.jsp";
    }

    @RequestMapping("/adminFindAllCategoryToAdd")
    public String adminFindAllCategoryToAdd(HttpServletRequest request) {
        request.setAttribute("categoryList", categoryService.getAllCategory());
        return "../adminjsps/admin/snacks/add.jsp";
    }


}
