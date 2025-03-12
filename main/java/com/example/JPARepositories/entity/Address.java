package com.example.JPARepositories.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Address(Long id, String street, String city, Person person) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.person = person;
    }
}