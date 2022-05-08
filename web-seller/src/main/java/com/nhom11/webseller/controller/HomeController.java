package com.nhom11.webseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nhom11.webseller.service.ProductOptionService;
import com.nhom11.webseller.service.ProductService;

@Controller
public class HomeController{

    @GetMapping(value = {"/", "/home"})
    public String getHome(){

        return "admin/layout-page-admin";

    }

    @GetMapping("/hello")
    public String hello(){
        return "user-donhang";
    }

}