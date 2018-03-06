package com.nys.role.domain;

import org.springframework.stereotype.Repository;

@Repository
public class Module {
    private Integer moduleId;

    private String name;

    public Module(Integer moduleId, String name) {
        this.moduleId = moduleId;
        this.name = name;
    }

    public Module() {
        super();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}