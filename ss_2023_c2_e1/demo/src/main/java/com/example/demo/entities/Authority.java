package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by Admin on 5/6/2023
 *
 * @author : Admin
 * @date : 5/6/2023
 * @project : ss_2023_c2_e1
 */
@Entity
@Data
@Getter
@Setter
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}
