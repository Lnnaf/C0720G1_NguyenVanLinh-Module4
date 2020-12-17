package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.generator.GeneratorIdPrefix;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Entity(name = "service")
public class Service {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service")
//    @GenericGenerator(
//            name = "service",
//            strategy = "java/com/project/entity/GeneratorIdPrefix.java",
//            parameters = {
//                    @Parameter(name = GeneratorIdPrefix.INCREMENT_PARAM, value = ""),
//                    @Parameter(name = GeneratorIdPrefix.VALUE_PREFIX_PARAMETER, value = "DV-"),
//                    @Parameter(name = GeneratorIdPrefix.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer serviceId;
    private String serviceName;
    @NotNull
    @PositiveOrZero
    private Integer serviceArea;
    @NotNull
    @PositiveOrZero
    private Double serviceCost;
    @NotNull
    @PositiveOrZero
    private Integer serviceMaxPeople;
    private String standardRoom, descriptionOtherConvenience;
    @NotNull
    @PositiveOrZero
    private Double poolArea;
    @NotNull
    @PositiveOrZero
    private Integer numOfFloor;
    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;
    @OneToMany(mappedBy = "service")
    @JsonBackReference
    private Set<Contract> contracts;

    public Service() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(Integer numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
