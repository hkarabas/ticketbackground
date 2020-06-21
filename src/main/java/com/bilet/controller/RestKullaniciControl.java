package com.bilet.controller;


import com.bilet.exception.KullaniciNotFoundException;
import com.bilet.model.Kullanici;
import com.bilet.repositories.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/kullanici")
public class RestKullaniciControl {


    @Autowired
    KullaniciRepository kullanicirepository;

    @PostMapping(path="/yeni")
    public ResponseEntity<Kullanici> addKullanici(@RequestBody Kullanici kullanici){
        kullanicirepository.save(kullanici);
        return new ResponseEntity<Kullanici>(kullanici, HttpStatus.CREATED);
    }

    @PostMapping(path = "/guncelle/{id}")
    public ResponseEntity<Kullanici> updateKullanici(@RequestBody Kullanici newKullanici,@PathVariable Long id) {
        return kullanicirepository.findById(id).map(kullanici -> {
            kullanici.setKullanici(kullanici.getKullanici());
            kullanici.setRolid(kullanici.getRolid());
            kullanici.setSifre(kullanici.getSifre());
            kullanicirepository.save(kullanici);
            return  new ResponseEntity<Kullanici>(kullanici, HttpStatus.CREATED);
         }).orElseThrow(()->new KullaniciNotFoundException("Güncellenmek istenen kullanici yok "));
        /*
         if (kullaniciupdate.isPresent()) {
            kullaniciupdate.get().setKullanici(kullanici.getKullanici());
            kullaniciupdate.get().setRolid(kullanici.getRolid());
            kullaniciupdate.get().setSifre(kullanici.getSifre());
            Kullanici kullanici2 =	kullanicirepository.save(kullaniciupdate.get());
            ResponseEntity<Kullanici> responseEntity = new ResponseEntity<Kullanici>(kullanici2, HttpStatus.CREATED);
            return responseEntity;

        }  else {
            throw new KullaniciNotFoundException("Güncellenmek istenen kullanici yok ID="+kullanici.getId());

        }
        */
    }

    @GetMapping(path="/getKullaniciById/{id}")
    public ResponseEntity<Kullanici> getKullanici(@PathVariable Long id){

        return kullanicirepository.findById(id).map(kullanici -> {
            return new ResponseEntity<Kullanici>(kullanici,HttpStatus.ACCEPTED);
         }).orElseThrow(()-> new KullaniciNotFoundException("Aradığınız kullanici yok"));

    }

    @GetMapping(path="/getKullaniciList")
    public List<Kullanici> getKullaniciList() {
        List<Kullanici> listKullanici = (List<Kullanici>) kullanicirepository.findAll();
        return listKullanici;
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        kullanicirepository.deleteById(id);
    }



}
