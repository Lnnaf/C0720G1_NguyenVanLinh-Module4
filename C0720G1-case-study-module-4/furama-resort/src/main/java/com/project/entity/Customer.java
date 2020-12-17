package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.generator.GeneratorIdPrefix;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity(name = "customer")
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
//    @GenericGenerator(
//            name = "book_seq",
//            strategy = "java/com/project/entity/GeneratorIdPrefix.java",
//            parameters = {
//                    @Parameter(name = GeneratorIdPrefix.INCREMENT_PARAM, value = ""),
//                    @Parameter(name = GeneratorIdPrefix.VALUE_PREFIX_PARAMETER, value = "KH-"),
//                    @Parameter(name = GeneratorIdPrefix.NUMBER_FORMAT_PARAMETER, value = "%04d") })
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
    private Integer customerId;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;
    @NotBlank(message = "Name may not be blank")
    private String customerName;
    @NotBlank(message = "Birthday may not be blank")
    private String customerBirthDay;
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Wrong numberphone format")
    private String customerPhone;
    @NotNull
    @Email
    private String customerEmail;
    @Pattern(regexp = "\\d{9}",message = "wrong ID Card")
    private String customerIdCard;
    private String customerGender, customerAddress;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Contract> contracts;

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
