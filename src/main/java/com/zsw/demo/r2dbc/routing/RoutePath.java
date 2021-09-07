package com.zsw.demo.r2dbc.routing;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 17:29
 */
public class RoutePath {
    public static final String root = "/clientUser/product";


    public static final String save = root + "/save";
    public static final String saveMany = root + "/saveMany";
    public static final String find = root + "/find/{userId}";
    public static final String findAll = root + "/findAll";
    public static final String findAllPage = root + "/findAllByPage";
    public static final String findByCategory = root + "/findByCategory";
    public static final String update = root + "/update";
    public static final String delete = root + "/delete/{userId}";

    public static final String findStock = root + "/stock/get/{productId}";
}
