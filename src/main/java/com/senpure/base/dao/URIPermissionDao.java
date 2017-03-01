package com.senpure.base.dao;

import com.senpure.base.entity.URIPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Repository
public interface URIPermissionDao extends JpaRepository<URIPermission,Integer>{
    //
    @Query(value = "from  URIPermission  where  uriAndMethod = :uriAndMethod")
    public List<URIPermission> findByUriAndMethod( @Param(value = "uriAndMethod")String uriAndMethod);

}
