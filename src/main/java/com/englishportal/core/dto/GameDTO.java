package com.englishportal.core.dto;

import com.englishportal.core.model.Image;
import com.englishportal.core.model.WinState;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Long userId;
    private Long cardId;
    private String word;
}
