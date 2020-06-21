package com.bilet.controller;

import com.bilet.exception.HavaAlaniNotFoundException;
import com.bilet.model.Havaalani;
import com.bilet.model.Havayolu;
import com.bilet.repositories.HavaalaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/havaalani")
public class RestHavalanıControl {

    @Autowired
    HavaalaniRepository havaalaniRepository;



    @GetMapping(path="/getHavaalani/{id}")
    public ResponseEntity<Havaalani> getHavalaniById( @PathVariable(value = "id") Long id) {

        return havaalaniRepository.findById(id).map(havaalani -> {
            return new ResponseEntity<Havaalani>(havaalani,HttpStatus.OK);
        }).orElseThrow(()->new HavaAlaniNotFoundException(" Havalanı Bulunamadı"));
    }




    @PostMapping(path = "/yeni")
    public ResponseEntity<Havaalani> addHavaalani(@RequestBody Havaalani havaalani) {

        Havaalani havaalanires = havaalaniRepository.save(havaalani);
        ResponseEntity<Havaalani> responseEntity = new ResponseEntity<Havaalani>(havaalani, HttpStatus.CREATED);
        return responseEntity;

    }
    @PutMapping(path = "/guncelle/{id}")
    public ResponseEntity<Havaalani> updateHavaalani(@RequestBody Havaalani newHavaalani,@PathVariable Long id) {
          return   havaalaniRepository.findById(id).map(havaalani -> {
              havaalani.setHavalaniad(newHavaalani.getHavalaniad());
              havaalani.setSehir(newHavaalani.getSehir());
              havaalaniRepository.save(havaalani);
             return new ResponseEntity<Havaalani>(havaalani,HttpStatus.OK);
        }).orElseThrow(()->new HavaAlaniNotFoundException("Güncellemek istediğiniz Havalanı Bulunamadı"));
    }



    @GetMapping(path = "/getHavalaniList")
    public List<Havaalani> getHavalaniList() {
          return (List<Havaalani>) havaalaniRepository.findAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        havaalaniRepository.deleteById(id);
    }


}
