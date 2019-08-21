package com.englishportal.core.services.servicesImpl;

import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.User;
import com.englishportal.core.repositories.EnWordRepository;
import com.englishportal.core.repositories.UserRepository;
import com.englishportal.core.services.EnWordService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EnWordServiceImpl implements EnWordService {

    @NonNull
    private final EnWordRepository enWordRepository;

    @Override
    public EnWord getEnWord(Long id) {
        return enWordRepository.getById(id);
    }
}
