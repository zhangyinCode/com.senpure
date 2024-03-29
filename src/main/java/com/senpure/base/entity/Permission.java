package com.senpure.base.entity;


import com.senpure.AppConstant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = AppConstant.DB_BASE_PREFIX + "_PERMISSION")
public class Permission extends IntEntity {

    /**
     *
     */
    private static final long serialVersionUID = -7137920267258203370L;


    //@Id
   // @GeneratedValue(generator = "hibernate")
    //@GenericGenerator(name = "hibernate", strategy = "assigned")
    @Column(nullable = false, length = 128)
    private String name;


    @OneToMany(mappedBy = "permission",cascade = {CascadeType.PERSIST})
    private List<URIPermission> uris;

    /**
     * NORMAL 正常 ，OWNER 检查所有者，IGNORE 可以忽略(正常放行)
     */
    @Column(nullable = false, length = 12)
    private String type;
    /**
     * 由那个类来验证资源所有者
     */

    private String resourceVerifyName;
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResourceVerifyName() {
        return resourceVerifyName;
    }

    public void setResourceVerifyName(String resourceVerifyName) {
        this.resourceVerifyName = resourceVerifyName;
    }

    public List<URIPermission> getUris() {
        return uris;
    }

    public void setUris(List<URIPermission> uris) {
        this.uris = uris;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        if(uris!=null)
        {
            uris.stream().forEach(uriPermission -> sb.append(uriPermission.getUriAndMethod()).append(" "));
        }

        return "Permission{" +
                "name='" + name + '\'' +
                ", uris=" +sb.toString() +
                ", type='" + type + '\'' +
                ", resourceVerifyName='" + resourceVerifyName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<String> strs=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strs.add(i+"");
        }
        strs.stream().forEach( str -> System.out.println(str));
    }
}
