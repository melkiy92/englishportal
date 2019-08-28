package com.englishportal.core.services.servicesImpl;

import com.englishportal.core.model.User;
import com.englishportal.core.repositories.UserRepository;
import com.englishportal.core.services.servicesInterfaces.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }


}
