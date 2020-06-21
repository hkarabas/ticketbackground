package com.bilet.controller;

import com.bilet.exception.HavaYoluNotFoundException;
import com.bilet.model.HavaYoluHavaAlani;
import com.bilet.model.Havayolu;
import com.bilet.repositories.HavayoluHavaalaniRepository;
import com.bilet.repositories.HavayoluRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping(path = "/havayolu")
public class RestHavaYoluControl {

    @Autowired
    HavayoluRepository havayolurepository;

    @Autowired
    HavayoluHavaalaniRepository havayoluhavaalanirepository;





    @PostMapping(path = "/yeni")
    public ResponseEntity<Havayolu> addHavaYolu(@RequestBody Havayolu havayolu) {

        Havayolu havayolures = havayolurepository.save(havayolu);
        ResponseEntity<Havayolu> responseEntity = new ResponseEntity<Havayolu>(havayolu, HttpStatus.CREATED);
        return responseEntity;

    }



    @PutMapping(path = "/guncelle/{id}")
    public ResponseEntity<Havayolu> updateHavaYolu(@RequestBody Havayolu newHavayolu,@PathVariable Long id) {

        return   havayolurepository.findById(id).map( havayolu ->{
              havayolu.setHavayoluad(newHavayolu.getHavayoluad());
              havayolurepository.save(havayolu);
              return new ResponseEntity<Havayolu>(havayolu, HttpStatus.OK);
        }).orElseThrow(()->  new HavaYoluNotFoundException("Güncellemek istedğiniz  hava yolu şirketi bulunamadı"));
    }

    @GetMapping(path = "/getHavaAlaniHavaYoluList")
    public List<HavaYoluHavaAlani> getHavaAlaniHavaYoluList(){
        return  (List<HavaYoluHavaAlani>) havayoluhavaalanirepository.findAll();
    }

    @PostMapping(path = "/havayoluhavaalani/yeni")
    public ResponseEntity<HavaYoluHavaAlani> addHavaYoluHavaalani(@RequestBody HavaYoluHavaAlani havaYoluHavaAlani) {

        HavaYoluHavaAlani havayoluhavaalanires = havayoluhavaalanirepository.save(havaYoluHavaAlani);
        ResponseEntity<HavaYoluHavaAlani> responseEntity = new ResponseEntity<HavaYoluHavaAlani>(havayoluhavaalanires, HttpStatus.CREATED);
        return responseEntity;

    }
    @GetMapping(path = "/getHavaYolu/{id}")
    public ResponseEntity<Havayolu> getHavaYoluById( @PathVariable Long id) {
        return  havayolurepository.findById(id).map(havayolu -> {
              return new ResponseEntity<Havayolu>(havayolu,HttpStatus.OK);
        }).orElseThrow(()->  new HavaYoluNotFoundException("Aradığınız  Hava Yolu Şirketi Bulunumadı"));
    }


    @GetMapping(path = "/getHavayoluList")
    public List<Havayolu> getHavaYoluList() {
        return (List<Havayolu>) havayolurepository.findAll();
    }

    @DeleteMapping("/deletebyId/{id}")
    public void deleteById(@PathVariable Long id) {
        havayolurepository.deleteById(id);
    }



}
