package com.how2java;

import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestElasticSearch4J
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/27 16:08
 * @Version: V1.0
 */
public class TestElasticSearch4J {
    private static String indexName = "how2java";
    private static String fileName = "140k_products.txt";
    private static RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(new HttpHost("localhost", 9200, "http"))
    );

    public static void main(String[] args) throws IOException {
        try {
            //============查询=================
            String keyWords = "炫酷太阳镜";
            int start = 0;
            int count = 10;
            long time1 = new Date().getTime();
            SearchHits hits = search(keyWords, start, count);
            for (SearchHit hit : hits) {
                System.out.println(hit.getSourceAsString());
            }
            long time2 = new Date().getTime();
            System.out.println("根据关键词"+keyWords+"查询完毕，查询耗时"+(time2-time1)+"ms");
            //============批量插入==============
            /*//确保索引存在
            if(!checkExistIndex(indexName)){
                createIndex(indexName);
            }

            List<Product> products = ProductUtil.file2List(fileName);
            System.out.println("准备数据，总共 "+ products.size() + "条");
            batchInsert(products);*/

            //==========================================
            /*//准备数据
            Product product = new Product();
            product.setId(1);
            product.setName("product 1");

            //增加文档
            addDocument(product);

            //获取文档
            getDocument(1);

            //修改数据
            product.setName("product 2");

            //更新文档
            updateDocument(product);

            //获取文档
            getDocument(1);

            //删除文档
            deleteDocument(product.getId());

            getDocument(1);*/
        } finally {
            client.close();
        }
    }

    private static SearchHits search(String keyWords, int start, int count) throws IOException {
        SearchRequest searchRequest = new SearchRequest(indexName);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //关键词匹配
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", keyWords);
        //模糊匹配
        matchQueryBuilder.fuzziness(Fuzziness.AUTO);
        sourceBuilder.query(matchQueryBuilder);
        //第几页 第几条
        sourceBuilder.from(start);
        sourceBuilder.size(count);

        searchRequest.source(sourceBuilder);
        //匹配度从高到低
        sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        SearchResponse response = client.search(searchRequest);
        SearchHits hits = response.getHits();
        return hits;
    }

    private static void batchInsert(List<Product> products) throws IOException {
        BulkRequest bkRequest = new BulkRequest();
        for (Product p : products) {
            Map<String, Object> map = p.toMap();
            IndexRequest request = new IndexRequest(indexName, "product", String.valueOf(p.getId())).source(map);
            bkRequest.add(request);
        }
        client.bulk(bkRequest);
        System.out.println("批量插入完成！");
    }

    private static void deleteDocument(int id) throws IOException {
        DeleteRequest request = new DeleteRequest(indexName, "product", String.valueOf(id));
        client.delete(request);
        System.out.println("已经从Elastic Search服务器上删除 id="+id+"的文档");
    }

    private static void updateDocument(Product product) throws IOException {
        UpdateRequest request = new UpdateRequest(indexName, "product", String.valueOf(product.getId())).doc("name", product.getName());
        UpdateResponse response = client.update(request);
        System.out.println("已经在Elastic Search服务器上修改产品为："+product);
    }

    private static void getDocument(int id) throws IOException {
        GetRequest request = new GetRequest(indexName, "product", String.valueOf(id));
        GetResponse response = client.get(request);
        if(!response.isExists()){
            System.out.println("检查到服务器上 id=" +id+ " 的文档不存在！");
        } else {
            String source = response.getSourceAsString();
            System.out.println("获取到服务器上 id=" +id+ " 的文档内容是");
            System.out.println(source);
        }
    }

    private static void addDocument(Product product) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", product.getName());
        IndexRequest indexRequest = new IndexRequest(indexName, "product", String.valueOf(product.getId())).source(map);
        client.index(indexRequest);
        System.out.println("已经向Elastic Search服务器增加产品："+product);
    }


    private static boolean checkExistIndex(String indexName) throws IOException {
        boolean result = true;
        try {
            OpenIndexRequest openIndexRequest = new OpenIndexRequest(indexName);
            client.indices().open(openIndexRequest).isAcknowledged();
        } catch (ElasticsearchStatusException e) {
            String m = "Elasticsearch exception [type=index_not_found_exception, reason=no such index]";
            if(m.equals(e.getMessage())){
                result = false;
            }
        }
        if (result)
            System.out.println("索引"+ indexName + "是存在的！");
        else
            System.out.println("索引"+ indexName + "是不存在的！");
        return result;
    }

    private static void createIndex(String indexName) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        client.indices().create(request);
        System.out.println("创建了索引"+ indexName);
    }

    private static void deleteIndex(String indexName) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        client.indices().delete(request);
        System.out.println("删除了索引"+ indexName);
    }

}
