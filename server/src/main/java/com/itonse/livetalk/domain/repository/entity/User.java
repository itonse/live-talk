package com.itonse.livetalk.domain.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "t_id")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long t_id;

    @Column(nullable = false)
    private String name;

    @Column
    private Timestamp created_at;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserCredentials userCredentials;

    private User(String name) {
        this.name = name;
        this.created_at = new Timestamp(System.currentTimeMillis());
    }

    public static User newUser(String name) {
        return new User(name);
    }

    public void setCredentials(UserCredentials credentials) {
        this.userCredentials = credentials;
    }
}
