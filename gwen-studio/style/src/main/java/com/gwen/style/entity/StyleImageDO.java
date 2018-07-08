package com.gwen.style.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author: Jian Gu
 * @version: 1.0.0
 * last edit: 2018-07-02
 * style related image
 */
@Data
@Entity
@ToString
@Builder
@Table(name = "T_STYLE_IMAGE")
public class StyleImageDO {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STYLE_ID")
    private Long styleId;

    @Column(name = "URL")
    private String url;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
}
