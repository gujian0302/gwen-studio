package com.gwen.style.service;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StyleImageSaveDto {
    private Long styleId;
    private String url;
}
