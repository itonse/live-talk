package com.itonse.livetalk.domain.auth.service;

import com.itonse.livetalk.domain.auth.model.request.CreateUserRequest;
import com.itonse.livetalk.domain.auth.model.response.CreateUserResponse;
import com.itonse.livetalk.domain.repository.UserRepository;
import com.itonse.livetalk.domain.repository.entity.User;
import com.itonse.livetalk.domain.repository.entity.UserCredentials;
import com.itonse.livetalk.security.Hasher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional(transactionManager = "createUserTransactionManager")
    public CreateUserResponse createUser(CreateUserRequest request) {
        Optional<User> user = userRepository.findByName(request.name());

        if (!user.isPresent()) {
            // TODO 에러 처리
        }

        try {
            User newUser = User.newUser(request.name());
            UserCredentials newCredential = UserCredentials.newCredentials(request.password(), newUser);
            newUser.setCredentials(newCredential);
        } catch (Exception e) {
            // TODO 에러 처리
        }

        return new CreateUserResponse(request.name());
    }
}
