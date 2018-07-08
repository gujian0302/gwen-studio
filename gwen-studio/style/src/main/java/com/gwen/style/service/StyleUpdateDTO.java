package com.gwen.style.service;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StyleUpdateDTO {
    private Long id;
    private String name;
    private Integer ordinate;
}
