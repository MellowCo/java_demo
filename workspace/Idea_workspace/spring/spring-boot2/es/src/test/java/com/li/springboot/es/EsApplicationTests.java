package com.li.springboot.es;

import com.li.springboot.es.domain.Admin;
import com.li.springboot.es.domain.User;
import com.li.springboot.es.repository.AdminRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

    @Autowired
    JestClient jestClient;

    @Test
    public void jestAdd(){
        //创建一个文档
        User user = new User(1,"li","男");

        //指定保存的文档,索引,类型
        Index index = new Index.Builder(user).index("lies").type("user").build();

        try {
            //保存
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jestSearch(){
        //查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"name\" : \"li\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        //指定搜索的索引，类型
        Search search = new Search.Builder(json).addIndex("lies").addType("user").build();

        try {
            //执行搜索
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    AdminRepository adminRepository;

    @Test
    public void admin(){
        //添加数据
        Admin a = new Admin();
        a.setId(1);
        a.setName("li");
        adminRepository.index(a);
    }
    
}
