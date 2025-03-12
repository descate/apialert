package com.monitoreodeforestacion.service.impl;

import com.monitoreodeforestacion.dto.ActionDto;
import com.monitoreodeforestacion.entity.Action;
import com.monitoreodeforestacion.exception.ResourceNotFoundException;
import com.monitoreodeforestacion.mapper.ActionMapper;
import com.monitoreodeforestacion.repository.ActionRepository;
import com.monitoreodeforestacion.service.ActionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActionServiceImpl implements ActionService {

    private ActionRepository actionRepository;

    @Override
    public ActionDto createAction(ActionDto actionDto){

        Action action = ActionMapper.mapToAction(actionDto);
        Action saveAction = actionRepository.save(action);
        return ActionMapper.mapToActionDto(saveAction);
    }

    @Override
    public ActionDto getActionById(Long actionId) {
        Action action = actionRepository.findById(actionId)
                .orElseThrow(() -> new ResourceNotFoundException("La acción indicada no existe: " + actionId));

        return ActionMapper.mapToActionDto(action);
    }

    @Override
    public ActionDto getActionByAlertCode(String actionAlertCode) {
        Action action = actionRepository.findByAlertCode(actionAlertCode)
                .orElseThrow(() -> new ResourceNotFoundException("La acción indicada no existe: " + actionAlertCode));

        return ActionMapper.mapToActionDto(action);
    }

    @Override
    public List<ActionDto> getAllActions() {
        List<Action> actions = actionRepository.findAll();
        return actions.stream().map((action) -> ActionMapper.mapToActionDto(action))
                .collect(Collectors.toList());
    }

    @Override
    public ActionDto updateAction(Long actionId, ActionDto updateAction) {

       Action action = actionRepository.findById(actionId).orElseThrow(
                () -> new ResourceNotFoundException("La acción que desea actualizar no existe")
        );

       action.setAlertCode(updateAction.getAlertCode());
       action.setRegDate(updateAction.getRegDate());
       action.setAlertConfirmation(updateAction.getAlertConfirmation());
       action.setPatrolCode(updateAction.getPatrolCode());
       action.setAlertType(updateAction.getAlertType());
       action.setAlertSummary(updateAction.getAlertSummary());

       Action updateActionObj = actionRepository.save(action);
        return ActionMapper.mapToActionDto(updateActionObj);
    }
}
