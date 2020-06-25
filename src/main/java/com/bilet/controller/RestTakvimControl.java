package com.bilet.controller;


import com.bilet.exception.HavaYoluNotFoundException;
import com.bilet.exception.TakvimNotFoundException;
import com.bilet.model.HavaYoluHavaAlani;
import com.bilet.model.Havayolu;
import com.bilet.model.Takvim;
import com.bilet.repositories.HavaalaniRepository;
import com.bilet.repositories.HavayoluRepository;
import com.bilet.repositories.TakvimRapository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/takvim")
public class RestTakvimControl {

    @Autowired
    TakvimRapository takvimrepisorty;

    @Autowired
    HavayoluRepository havayolurepository;


    @Autowired
    HavaalaniRepository havaalaniRepository;



    @PostMapping(path="/yeni")
    public ResponseEntity<Takvim> addTakvim(@RequestBody Takvim takvim) {
        Takvim takvimres = takvimrepisorty.save(takvim);
         return new ResponseEntity<Takvim>(takvimres, HttpStatus.CREATED);
    }

    @PutMapping(path="/guncelle/{id}")
    public ResponseEntity<Takvim> updateTakvim(@RequestBody Takvim newTakvim,@PathVariable Long id) {

       return  takvimrepisorty.findById(id).map(takvim -> {
            takvim.setAd(takvim.getAd());
            takvim.setDonustarih(takvim.getDonustarih());
            takvim.setEmail(takvim.getEmail());
            takvim.setError(takvim.getError());
            takvim.setGidistarih(takvim.getGidistarih());
            takvim.setHavaalanId(takvim.getHavaalanId());
            takvim.setHavayoluId(takvim.getHavayoluId());
            takvim.setMusteriId(takvim.getMusteriId());
            takvim.setRezarvasyontarih(takvim.getRezarvasyontarih());
            takvim.setPnr(takvim.getPnr());
            takvim.setSoyad(takvim.getSoyad());
            takvim.setTcno(takvim.getTcno());
            takvim.setYon(takvim.getYon());
            
            return new  ResponseEntity<Takvim>(takvim,HttpStatus.ACCEPTED);
        }).orElseThrow(()->new TakvimNotFoundException("Güncellemek istediğiniz takvim bulunamadı "));

    }

    @GetMapping(path = "/getTakvimById/{id}")
    public ResponseEntity<Takvim> getTakvimById(@PathVariable Long id){
       return  takvimrepisorty.findById(id).map(takvim -> {
             return new ResponseEntity<Takvim>(takvim,HttpStatus.ACCEPTED);
         }).orElseThrow(()->new TakvimNotFoundException("Aradığınız takvim bulunamadı "));

    }
    @GetMapping(path = "/getTakvimByPnr/{pnr}")
    public ResponseEntity<Takvim> getTakvimByPnr(@PathVariable String pnr){
     return    takvimrepisorty.findByPnr(pnr).map(takvim -> {
            return new ResponseEntity<Takvim>(takvim,HttpStatus.ACCEPTED);
        }).orElseThrow(()->new TakvimNotFoundException("Aradığınız takvim bulunamadı "));
    }

    @GetMapping(path="/getTakvimList")
    public List<Takvim> getTakvimList(){
        return (List<Takvim>)takvimrepisorty.findAll();
    }



    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        takvimrepisorty.deleteById(id);
    }



    @GetMapping(path = "/getHavaYolu/{id}")
    public ResponseEntity<Havayolu> getHavaYoluById(@PathVariable Long id) {
        return  havayolurepository.findById(id).map(havayolu -> {
            return new ResponseEntity<Havayolu>(havayolu,HttpStatus.OK);
        }).orElseThrow(()->  new HavaYoluNotFoundException("Aradığınız  Hava Yolu Şirketi Bulunumadı"));
    }


    @GetMapping(path = "/getHavayoluList")
    public List<Havayolu> getHavaYoluList() {
        return (List<Havayolu>) havayolurepository.findAll();
    }




}
