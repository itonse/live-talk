package com.itonse.livetalk.domain.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Id
    @OneToOne
    @JoinColumn(name = "user_t_id")
    private User user;

    @Column(nullable = false)
    private String hashed_password;
}
