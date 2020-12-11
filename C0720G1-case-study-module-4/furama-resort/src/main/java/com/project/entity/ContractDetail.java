package com.project.entity;

import javax.persistence.*;

@Entity(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractDetailId;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id",nullable = false)
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",nullable = false)
    private AttachService attachService;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
