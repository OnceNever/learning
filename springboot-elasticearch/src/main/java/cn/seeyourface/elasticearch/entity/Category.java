package cn.seeyourface.elasticearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName: Category
 * @Description: @Document就表明了要连接到 ElasticSearch 的哪个索引和哪个 type 上
 * 索引相当于就是数据库，type 相当于就是表
 * @Author: Yanglei
 * @Date: 2021/1/28 11:19
 * @Version: V1.0
 */
@Document(indexName = "how2java", type = "category")
public class Category {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
