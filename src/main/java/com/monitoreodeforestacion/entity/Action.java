package com.monitoreodeforestacion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="acciones")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="md_alert")
    private String alertCode;

    @Column(name="act_fecreg")
    private Date regDate;

    @Column(name="act_cfm")
    private Integer alertConfirmation;

    @Column(name="cod_pat")
    private String patrolCode;


    @Column(name="ta_id")
    private Integer alertType;

    @Column(name="act_res")
    private String alertSummary;
}
