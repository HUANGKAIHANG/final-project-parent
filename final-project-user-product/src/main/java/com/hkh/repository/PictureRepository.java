package com.hkh.repository;

import com.hkh.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HUANG Kaihang
 * @create 2019/6/9 21:40
 * @update 2019/6/9 21:40
 */

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

}
