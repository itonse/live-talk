package com.itonse.livetalk.domain.repository.entity;

import com.itonse.livetalk.security.Hasher;
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

    private UserCredentials(String password, User user) {
        this.hashed_password = password;
        this.user = user;
    }

    public static UserCredentials newCredentials(String password, User user) {
        String hashedValue = Hasher.getHashingValue(password);

        return new UserCredentials(hashedValue, user);
    }
}
