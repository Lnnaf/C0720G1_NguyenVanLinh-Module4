package com.project.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "10000"),
                    @Parameter(name = "increment_size", value = "2")
            }
    )
    private int idCart;
    @ManyToMany()
    @JoinTable(
            name = "card_item",
            joinColumns = @JoinColumn(name = "id_card"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
     List<Items> listItems;

    public Cart() {
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public List<Items> getListItems() {
        return listItems;
    }

    public void setListItems(List<Items> listItems) {
        this.listItems = listItems;
    }
}
