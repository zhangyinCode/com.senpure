package com.senpure.base.init;

import com.senpure.AppConstant;
import com.senpure.base.annotation.PermissionVerify;
import com.senpure.base.entity.Permission;
import com.senpure.base.entity.URIPermission;
import com.senpure.base.service.PermissionService;
import com.senpure.base.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@Repository
@Order(value = 1)
public class PermissionsGenerator implements
        ApplicationListener<ContextRefreshedEvent> {
    private static Logger LOG = LogManager.getLogger(PermissionsGenerator.class);

    @Autowired
    private PermissionService permissionService;

    private Map<String,List<Permission>> uriPermissionS=new HashMap<>();
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.debug("准备检查代码中的权限，生成数据");
        RequestMappingHandlerMapping rm = event.getApplicationContext().getBean(RequestMappingHandlerMapping.class);

        Map<RequestMappingInfo, HandlerMethod> map = rm.getHandlerMethods();
        Iterator<Map.Entry<RequestMappingInfo, HandlerMethod>> iterator = map.entrySet().iterator();
        List<Permission> createPermissions = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<RequestMappingInfo, HandlerMethod> entry = iterator.next();
            RequestMappingInfo info = entry.getKey();
          //  LOG.debug(info);

            HandlerMethod handlerMethod = entry.getValue();
            PermissionVerify permissionVerify = handlerMethod.getMethod().getAnnotation(PermissionVerify.class);
            if (permissionVerify != null) {
                String suffix = "retrieve";
                if (info.getMethodsCondition().isEmpty()) {
                    suffix = method2Suffix(handlerMethod, false);
                } else if (
                        info.getMethodsCondition().getMethods().contains("DELETE")) {
                    suffix = "delete";
                } else if (
                        info.getMethodsCondition().getMethods().contains("PUT")) {
                    suffix = "create";
                } else if (
                        info.getMethodsCondition().getMethods().contains("POST")) {
                    suffix = method2Suffix(handlerMethod, true);

                }
                StringBuilder sname = new StringBuilder();
                Iterator<String> it = info.getPatternsCondition().getPatterns().iterator();
                List<String> uriAndMethod=new ArrayList<>();
                while (true) {
                    String uri=it.next();
                    uriAndMethod.add(uri+"->"+handlerMethod.getMethod().getName());
                    sname.append(uri);
                    if (it.hasNext()) {
                        sname.append("||");
                    } else {
                        break;
                    }
                }
                sname.append("_").append(suffix);
               // LOG.debug(sname);
                Permission permission = new Permission();
                permission.setName(sname.toString());
                permission.setType(AppConstant.PERMISSION_TYPE_NORMAL);
                List<URIPermission> uriPermissions=new ArrayList<>();
                for(String um:uriAndMethod)
                {
                    URIPermission uriPermission=new URIPermission();
                    uriPermission.setUriAndMethod(um);
                    uriPermission.setPermission(permission);
                    uriPermissions.add(uriPermission);
                }
               permission.setUris(uriPermissions);
               createPermissions.add(permission);
                if (StringUtil.isExist(permissionVerify.resourceVerifyName())) {

                    Permission resourcePermission = new Permission();
                    resourcePermission.setResourceVerifyName(permissionVerify.resourceVerifyName());
                    resourcePermission.setName(sname.append("_owner").toString());
                    resourcePermission.setType(AppConstant.PERMISSION_TYPE_NORMAL);
                   List<URIPermission> uriPermissions2=new ArrayList<>();
                    for(String um:uriAndMethod)
                    {
                        URIPermission uriPermission=new URIPermission();
                        uriPermission.setPermission(resourcePermission);
                        uriPermission.setUriAndMethod(um);
                        uriPermissions2.add(uriPermission);
                    }
                   resourcePermission .setUris(uriPermissions2);
                    createPermissions.add(resourcePermission);
                }

            }
        }
        if (!createPermissions.isEmpty()) {
            permissionService.syncPermissions(createPermissions);
        }


        LOG.info("SpringContextRefreshedEvent ----------------------------------------------------------------------");

    }

    private String method2Suffix(HandlerMethod handlerMethod, boolean post) {
        String suffix = "create";
        if (handlerMethod.getMethod().getName().startsWith("add") || handlerMethod.getMethod().getName().startsWith("create")) {
            suffix = "create";
        } else if (handlerMethod.getMethod().getName().startsWith("del")) {
            suffix = "delete";
        } else if (handlerMethod.getMethod().getName().startsWith("update") || handlerMethod.getMethod().getName().startsWith("change")) {
            suffix = "update";
        } else {
            suffix = post ? "update" : "retrieve";
        }
        return suffix;
    }



    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        System.out.println(set);
    }
}
