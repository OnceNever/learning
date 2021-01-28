package cn.seeyourface.elasticearch.controller;

import cn.seeyourface.elasticearch.Utils.ProductUtil;
import cn.seeyourface.elasticearch.entity.Product;
import cn.seeyourface.elasticearch.services.impl.ProductServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: ProductController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/28 15:36
 * @Version: V1.0
 */
@RestController
public class ProductController {
    @Autowired
    ProductServicesImpl services;

    @RequestMapping("/startInsert")
    public String insertProducts() throws IOException {
        String retMsg = "";
        try {
            List<Product> productList = ProductUtil.file2List("140k_products.txt");
            System.out.println("文件数量为："+productList.size());
            services.insertProd(productList);
            retMsg = "导入成功！";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retMsg;
    }

    @GetMapping("/product/{id}")
    public String qryByCondition(@PathVariable int id){
        List<Product> products = services.qryByCondition(id);
        if (products != null && products.size() > 0)
            return products.get(0).toString();
        return "0";
    }
}
