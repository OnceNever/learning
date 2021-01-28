package cn.seeyourface.elasticearch.mapper;

import cn.seeyourface.elasticearch.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: ProductMapper
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/28 14:51
 * @Version: V1.0
 */
@Mapper
public interface ProductMapper {

    public void insertProd(List<Product> productList);

    public List<Product> qryByCondition(int id);
}
