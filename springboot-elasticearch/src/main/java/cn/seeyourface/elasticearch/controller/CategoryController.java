package cn.seeyourface.elasticearch.controller;

import cn.seeyourface.elasticearch.dao.CategoryDAO;
import cn.seeyourface.elasticearch.entity.Category;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: CategoryController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/28 11:26
 * @Version: V1.0
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "5") int size){
        //查询条件，这里并没有使用，目的是将来使用时有个参考
        String query = "商品";
        //SearchQuery searchQuery = getEntitySearchQuery(start, size, query);
        //Page<Category> page = categoryDAO.search(searchQuery);
        //m.addAttribute("page", page);
        return "listCategory";
    }


}
