package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.ForfaitDto;
import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.services.imp.ForfaitServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forfait")
@AllArgsConstructor
public class ForfaitController {
    private ForfaitServicesImpl forfaitServices;

    @GetMapping("/all")
    public ResponseEntity<List<ForfaitDto>> allHotels(){
        return new ResponseEntity<>(forfaitServices.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ForfaitDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(forfaitServices.findById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ForfaitDto> save(@RequestBody ForfaitDto forfaitDto){

        return new ResponseEntity<>(forfaitServices.save(forfaitDto),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        forfaitServices.delete(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ForfaitDto> update(@RequestBody ForfaitDto forfaitDto){
        return new ResponseEntity<>(forfaitServices.save(forfaitDto),HttpStatus.OK);
    }
}
