package com.senpure.base.dao;

import com.senpure.base.entity.URIPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Repository
public interface URIPermissionDao extends JpaRepository<URIPermission,Integer>{

    public List<URIPermission> findByUriAndMethod(String uriAndMethod);

}
