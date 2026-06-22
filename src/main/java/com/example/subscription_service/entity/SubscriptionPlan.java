package com.example.subscription_service.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscription_plan")
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;

    private Double price;

    private Integer durationDays;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PlanModule> modules;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public List<PlanModule> getModules() {
        return modules;
    }

    public void setModules(List<PlanModule> modules) {
        this.modules = modules;
    }
}