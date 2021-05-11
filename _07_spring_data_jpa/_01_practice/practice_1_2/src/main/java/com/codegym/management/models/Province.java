package com.codegym.management.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.util.CustomObjectInputStream;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<Customer> customers;
}
