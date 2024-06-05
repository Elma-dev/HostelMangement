package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.ActivityDto;
import com.pfe.hostelmangement.services.imp.ActivityServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/activity")
public class ActivityController {
    private ActivityServicesImpl activityServices;

    @GetMapping("/all")
    public ResponseEntity<List<ActivityDto>> allBookings(){

        return new ResponseEntity<>(activityServices.findAll(),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public  ResponseEntity<Boolean> delete(@PathVariable Long id){
        activityServices.delete(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ActivityDto> save(@RequestBody  ActivityDto activityDto){
        return  new ResponseEntity<>(activityServices.save(activityDto),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ActivityDto> update(@RequestBody  ActivityDto activityDto){
        return new ResponseEntity<>(activityServices.save(activityDto),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(activityServices.findById(id),HttpStatus.OK);
    }


}
