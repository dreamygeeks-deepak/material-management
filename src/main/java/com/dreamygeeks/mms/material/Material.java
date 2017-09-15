package com.dreamygeeks.mms.material;

import javax.persistence.*;

/**
 * Created by deepak_shingan on 9/13/2017.
 */
@Entity
@Table(name="Material")
public class Material {
    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    public Material() {
    }

    public Material(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
