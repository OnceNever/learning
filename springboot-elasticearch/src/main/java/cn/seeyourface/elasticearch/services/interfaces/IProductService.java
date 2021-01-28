package cn.seeyourface.elasticearch.services.interfaces;

import cn.seeyourface.elasticearch.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IProductService
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/28 15:34
 * @Version: V1.0
 */
public interface IProductService {
    public void insertProd(List<Product> productList);
}
