package com.gwen.style.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


/**
 * @author: Jian Gu
 * @version: 1.0.0
 * last edit: 2018-07-02
 *
 * entity style
 * id primary id
 * name style name
 */
@Data
@Entity
@Table(name = "T_STYLE")
@Builder
@ToString
public class StyleDO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ORDINATE")
    private Integer ordinate;
}
