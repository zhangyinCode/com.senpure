package com.senpure.base.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public class VersionEntity implements Serializable {
    private static final long serialVersionUID = 7122128889134800822L;
    @Version
    private int version;//个人觉得整型比时间类型好
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
