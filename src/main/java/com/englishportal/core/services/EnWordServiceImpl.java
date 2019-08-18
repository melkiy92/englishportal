package com.englishportal.core.services;

import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.User;
import com.englishportal.core.repositories.EnWordRepository;
import com.englishportal.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EnWordServiceImpl implements EnWordService {

    private final EnWordRepository enWordRepository;

    @Override
    public EnWord getEnWord(Long id) {
        return enWordRepository.getById(id);
    }
}
