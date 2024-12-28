package com.nequi.franchises.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("branch")
public class BranchEntity {
    @Id
    private Long id;
    private String name;
    private Long franchiseId;

    public BranchEntity() {
    }

    public BranchEntity(Long id, String name, Long franchiseId) {
        this.id = id;
        this.name = name;
        this.franchiseId = franchiseId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }
}
