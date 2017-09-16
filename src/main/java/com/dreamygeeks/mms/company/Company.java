package com.dreamygeeks.mms.company;

import com.dreamygeeks.mms.material.Material;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepak_shingan on 9/16/2017.
 */
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    private Long phoneNumber1;
    private Long phoneNumber2;
    private String email;
    @ManyToMany(mappedBy = "companies")
    private Set<Material> materials;
    private boolean isSuppier = false;
    private boolean isCustomer = false;

    public Company() {
    }

    public Company(String name, String description, Long phoneNumber1, Long phoneNumber2, String email, Set<Material> materials, boolean isSuppier, boolean isCustomer) {
        this.name = name;
        this.description = description;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.email = email;
        this.materials = materials;
        this.isSuppier = isSuppier;
        this.isCustomer = isCustomer;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(Long phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public Long getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(Long phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    public boolean isSuppier() {
        return isSuppier;
    }

    public void setSuppier(boolean suppier) {
        isSuppier = suppier;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber1=" + phoneNumber1 +
                ", phoneNumber2=" + phoneNumber2 +
                ", email='" + email + '\'' +
                ", materials=" + materials +
                ", isSuppier=" + isSuppier +
                ", isCustomer=" + isCustomer +
                '}';
    }
}
