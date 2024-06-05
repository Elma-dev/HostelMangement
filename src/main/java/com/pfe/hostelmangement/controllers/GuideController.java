package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.GuideDto;
import com.pfe.hostelmangement.services.imp.GuideServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/guide")
public class GuideController {
    private GuideServiceImpl guideService;

    @GetMapping("/all")
    public ResponseEntity<List<GuideDto>> allBookings(){

        return new ResponseEntity<>(guideService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public  ResponseEntity<Boolean> delete(@PathVariable Long id){
        guideService.delete(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<GuideDto> save(@RequestBody  GuideDto guideDto){
        return  new ResponseEntity<>(guideService.save(guideDto),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<GuideDto> update(@RequestBody  GuideDto guideDto){
        return new ResponseEntity<>(guideService.save(guideDto),HttpStatus.OK);
    }


}
