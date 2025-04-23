package com.testesapi.api_testes.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
@Table(name="users")
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
}
