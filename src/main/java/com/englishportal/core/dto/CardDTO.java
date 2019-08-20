package com.englishportal.core.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private Long id;
    private EnWordDTO enWord;
    private RuWordDTO ruWord;
    private ImageDTO image;
    private Long rating;
}
