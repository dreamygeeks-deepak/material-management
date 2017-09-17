package com.dreamygeeks.mms.material;

import com.dreamygeeks.mms.company.Company;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepak_shingan on 9/13/2017.
 */
@Entity
@Table(name="Material")
public class Material {
    @Column(nullable = false, unique = true)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;

    private String description;
    private String hsn;
    private String unit;
    private int minimumStockLimit;
    private int currentMaterialStock;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "material_company", joinColumns = @JoinColumn(name = "material_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
    private Set<Company> companies;

    public Material() {
    }

    public Material(String name, String description, String hsn, String unit, Set<Company> companies) {
        this.name = name;
        this.description = description;
        this.hsn = hsn;
        this.unit = unit;
        this.companies = companies;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", hsn='" + hsn + '\'' +
                ", unit=" + unit +
                ", companies=" + companies +
                '}';
    }
}
