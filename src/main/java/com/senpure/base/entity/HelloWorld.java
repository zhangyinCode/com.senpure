package com.senpure.base.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/16.
 */
@Entity
@Table(name = "HelloWorld")
public class HelloWorld implements Serializable {
    private static final long serialVersionUID = -9021617118180954012L;
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 12)
    private String str;
    @Column
    private  int number;
    @Version
    private int version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
