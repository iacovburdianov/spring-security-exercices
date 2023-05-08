package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


/**
 * Created by Admin on 5/5/2023
 *
 * @author : Admin
 * @date : 5/5/2023
 * @project : ss_2023_c2_e1
 */
@Entity
@Data
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities;
}