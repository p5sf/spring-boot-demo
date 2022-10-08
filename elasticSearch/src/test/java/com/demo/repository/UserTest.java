package com.demo.repository;

import com.demo.entity.UserEntity;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月23日 14:50
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


   public void createIndex(){
       elasticsearchTemplate.createIndex(UserEntity.class);
       elasticsearchTemplate.putMapping(UserEntity.class);
   }
    /**
     * 模糊查询
     */
    @Test
    public void queryItem() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
       builder.withQuery(QueryBuilders.matchQuery("name", "小"));
        builder.withPageable(PageRequest.of(2, 2));



    }
}
