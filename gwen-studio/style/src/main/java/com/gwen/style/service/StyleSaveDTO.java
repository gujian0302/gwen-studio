package com.gwen.style.service;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class StyleSaveDTO {
    private String name;
    private Integer ordinate;
}
