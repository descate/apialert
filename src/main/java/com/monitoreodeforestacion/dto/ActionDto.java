package com.monitoreodeforestacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ActionDto {

    private Long id;
    private String alertCode;
    private Date regDate;
    private String patrolCode;
    private Integer alertConfirmation;
    private Integer alertType;
    private String alertSummary;

}
