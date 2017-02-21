package com.senpure.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/7.
 */

public abstract class GenericService<T,ID extends Serializable>  extends  BaseService {

    @Autowired
    protected JpaRepository<T,ID> dao;

}
