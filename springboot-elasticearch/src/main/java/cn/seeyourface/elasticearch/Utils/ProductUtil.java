package cn.seeyourface.elasticearch.Utils;

import cn.seeyourface.elasticearch.entity.Product;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ProductUtil
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/27 17:26
 * @Version: V1.0
 */
public class ProductUtil {
    public static void main(String[] args) throws IOException {
        String fileName = "140k_products.txt";
        List<Product> products = file2List(fileName);
        System.out.println("产品数量："+products.size());
    }

    public static List<Product> file2List(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        List<Product> products = new ArrayList<>();
        for (String line : lines){
            Product p = line2Product(line);
            products.add(p);
        }
        return products;
    }

    private static Product line2Product(String line){
        Product p = new Product();
        String[] fields = line.split(",");
        p.setId(Integer.parseInt(fields[0]));
        p.setName(fields[1]);
        p.setCategory(fields[2]);
        p.setPrice(Float.parseFloat(fields[3]));
        p.setPlace(fields[4]);
        p.setCode(fields[5]);
        return p;
    }
}
