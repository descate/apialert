package com.monitoreodeforestacion.controller;

import com.monitoreodeforestacion.dto.ActionDto;
import com.monitoreodeforestacion.service.ActionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/actions")
public class ActionController {

    private ActionService actionService;

    @PostMapping
    public ResponseEntity<ActionDto> createAction(@RequestBody ActionDto actionDto){
        ActionDto savedAction = actionService.createAction(actionDto);
        return new ResponseEntity<>(savedAction, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ActionDto> getActionById(@PathVariable("id") Long actionId){
        ActionDto actionDto = actionService.getActionById(actionId);
        return ResponseEntity.ok(actionDto);
    }

    @GetMapping("alert/{alertCode}")
    public ResponseEntity<ActionDto> getActionByAlertCode(@PathVariable("alertCode") String actionAlertCode){
        ActionDto actionDto = actionService.getActionByAlertCode(actionAlertCode);
        return ResponseEntity.ok(actionDto);
    }

    @GetMapping
    public ResponseEntity<List<ActionDto>> getAllActions(){
        List<ActionDto> actions = actionService.getAllActions();
        return ResponseEntity.ok(actions);
    }

    @PutMapping("{id}")
    public ResponseEntity<ActionDto> updateAction(@PathVariable("id") Long actionId,
                                                  @RequestBody ActionDto updateAction){
        ActionDto actionDto = actionService.updateAction(actionId, updateAction);
        return ResponseEntity.ok(actionDto);
    }
}
