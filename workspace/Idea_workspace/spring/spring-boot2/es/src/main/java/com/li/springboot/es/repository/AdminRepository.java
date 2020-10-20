package com.li.springboot.es.repository;

import com.li.springboot.es.domain.Admin;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-14 12:11
 */

public interface AdminRepository extends ElasticsearchRepository<Admin,Integer> {
}
