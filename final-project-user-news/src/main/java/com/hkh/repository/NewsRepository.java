package com.hkh.repository;

import com.hkh.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HUANG Kaihang
 * @create 2019/6/8 20:54
 * @update 2019/6/8 20:54
 */

public interface NewsRepository extends JpaRepository<News, Integer> {

}
