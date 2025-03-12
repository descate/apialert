package com.monitoreodeforestacion.mapper;

import com.monitoreodeforestacion.dto.ActionDto;
import com.monitoreodeforestacion.entity.Action;

public class ActionMapper {

    public static ActionDto mapToActionDto(Action action){
        return new ActionDto(
            action.getId(),
            action.getAlertCode(),
            action.getRegDate(),
            action.getPatrolCode(),
            action.getAlertConfirmation(),
            action.getAlertType(),
            action.getAlertSummary()
        );
    }

    public static Action mapToAction(ActionDto actionDto){
        return new Action(
            actionDto.getId(),
            actionDto.getAlertCode(),
            actionDto.getRegDate(),
            actionDto.getAlertConfirmation(),
            actionDto.getPatrolCode(),
            actionDto.getAlertType(),
            actionDto.getAlertSummary()
        );
    }
}
