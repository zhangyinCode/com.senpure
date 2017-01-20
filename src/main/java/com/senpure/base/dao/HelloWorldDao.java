package com.senpure.base.dao;

import com.senpure.base.entity.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/16.
 */
@Repository
public interface HelloWorldDao extends JpaRepository<HelloWorld,Integer> {
}
