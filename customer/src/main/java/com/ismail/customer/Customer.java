package com.ismail.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer
{
    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    private Integer id;

    private String firstName;

    public String lastName;

    public String email;
}
