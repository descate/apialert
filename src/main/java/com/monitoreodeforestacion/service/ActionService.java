package com.monitoreodeforestacion.service;

import com.monitoreodeforestacion.dto.ActionDto;

import java.util.List;

public interface ActionService {
    ActionDto createAction(ActionDto actionDto);

    ActionDto getActionById(Long actionId);

    ActionDto getActionByAlertCode(String actionAlertCode);

    List<ActionDto> getAllActions();

    ActionDto updateAction(Long actionId, ActionDto updateAction);
}
