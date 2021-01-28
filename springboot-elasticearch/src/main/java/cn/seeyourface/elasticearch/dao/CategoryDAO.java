package cn.seeyourface.elasticearch.dao;

import cn.seeyourface.elasticearch.entity.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CategoryDAO
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/28 11:23
 * @Version: V1.0
 */
@Component
public interface CategoryDAO extends ElasticsearchRepository<Category,Integer> {
}
