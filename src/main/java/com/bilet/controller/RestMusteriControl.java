package com.bilet.controller;


import com.bilet.exception.MusteriNotFoundException;
import com.bilet.model.Musteri;
import com.bilet.repositories.MusteriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/musteri")
public class RestMusteriControl {

    @Autowired
    MusteriRepository musterirepository;


    @PostMapping(path="/yeni")
    public ResponseEntity<Musteri> addMusteri(@RequestBody Musteri musteri){
        Musteri musterires = musterirepository.save(musteri);
        return new ResponseEntity<Musteri>(musterires, HttpStatus.CREATED);

    }
    @PostMapping(path="/guncelle/{id}")
    public ResponseEntity<Musteri> updateMusteri(@RequestBody Musteri newMusteri,@PathVariable Long id) {

      return  musterirepository.findById(id).map(musteri -> {
          musteri.setAd(newMusteri.getAd());
          musteri.setSoyad(newMusteri.getSoyad());
          musteri.setEmail(newMusteri.getEmail());
          musteri.setGsm(newMusteri.getGsm());
          musteri.setTcno(musteri.getTcno());
          musterirepository.save(musteri);
          return  new ResponseEntity<Musteri>(musteri,HttpStatus.ACCEPTED);

        }).orElseThrow( ()-> new MusteriNotFoundException("Güncellemek istediğiniz müşteri bulanamadı"));

    }
    @GetMapping(path="/getMusteriById/{id}")
    public ResponseEntity<Musteri> getMusteri(@PathVariable Long id) {
        return musterirepository.findById(id).map(musteri -> {
            return  new ResponseEntity<Musteri>(musteri,HttpStatus.ACCEPTED);
         }).orElseThrow(()->new MusteriNotFoundException("Aradığınız Müşteri Bulanamadı"));


    }
    @GetMapping(path="/getMusteriList",produces = "application/json")
    public List<Musteri> getMusteriList() {
        return (List<Musteri>)musterirepository.findAll();

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        musterirepository.deleteById(id);
    }


}
