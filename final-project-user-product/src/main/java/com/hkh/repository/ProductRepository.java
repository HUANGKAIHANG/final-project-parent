package com.hkh.repository;

import com.hkh.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:44
 * @update 2019/6/9 21:44
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
