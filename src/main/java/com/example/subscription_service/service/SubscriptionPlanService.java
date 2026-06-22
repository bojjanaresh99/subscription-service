package com.example.subscription_service.service;

import com.example.subscription_service.dto.SubscriptionPlanRequest;
import com.example.subscription_service.entity.PlanModule;
import com.example.subscription_service.entity.SubscriptionPlan;
import com.example.subscription_service.repository.SubscriptionPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionPlanService {

    private final SubscriptionPlanRepository repository;

    public SubscriptionPlanService(
            SubscriptionPlanRepository repository) {

        this.repository = repository;
    }

    public SubscriptionPlan createPlan(
            SubscriptionPlanRequest request) {

        List<PlanModule> modules =
                request.getModules()
                        .stream()
                        .map(module -> {

                            PlanModule planModule =
                                    new PlanModule();

                            planModule.setModuleName(module);

                            return planModule;
                        })
                        .toList();

        SubscriptionPlan plan =
                new SubscriptionPlan();

        plan.setPlanName(
                request.getPlanName());

        plan.setPrice(
                request.getPrice());

        plan.setDurationDays(
                request.getDurationDays());

        plan.setModules(
                modules);

        return repository.save(plan);
    }

    public List<SubscriptionPlan> getAllPlans() {

        return repository.findAll();
    }
}