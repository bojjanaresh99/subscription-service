package com.example.subscription_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plan_module")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
}