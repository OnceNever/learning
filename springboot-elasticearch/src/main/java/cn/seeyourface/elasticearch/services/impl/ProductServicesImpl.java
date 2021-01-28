package cn.seeyourface.elasticearch.services.impl;

import cn.seeyourface.elasticearch.entity.Product;
import cn.seeyourface.elasticearch.mapper.ProductMapper;
import cn.seeyourface.elasticearch.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProductServicesImpl
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/28 15:35
 * @Version: V1.0
 */
@Service
public class ProductServicesImpl implements IProductService {
    @Autowired
    ProductMapper mapper;

    @Override
    public void insertProd(List<Product> productList) {
        mapper.insertProd(productList);
    }
}
