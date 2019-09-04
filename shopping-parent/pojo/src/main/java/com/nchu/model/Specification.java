package com.nchu.model;

import java.io.Serializable;
import java.util.List;

public class Specification implements Serializable {
    private Long id;

    private String specName;

    private List<SpecificationOption> options;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public List<SpecificationOption> getOptions() {
        return options;
    }

    public void setOptions(List<SpecificationOption> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", specName:'" + specName + '\'' +
                ", options:" + options +
                '}';
    }
}