package com.ascrud.mybatisplus.test.plugins.optimisticLocker.entity;

import java.io.Serializable;

import com.ascrud.mybatisplus.annotations.TableField;
import com.ascrud.mybatisplus.annotations.TableName;
import com.ascrud.mybatisplus.annotations.Version;

@TableName("version_user")
public class LongVersionUser implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
