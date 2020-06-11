package com.bilet.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bilet.exception.HavaAlaniNotFoundException;
import com.bilet.exception.HavaYoluNotFoundException;
import com.bilet.exception.KullaniciNotFoundException;
import com.bilet.exception.MusteriNotFoundException;
import com.bilet.exception.TakvimNotFoundException;
import com.bilet.model.HavaYoluHavaAlani;
import com.bilet.model.Havaalani;
import com.bilet.model.Havayolu;
import com.bilet.model.Kullanici;
import com.bilet.model.Musteri;
import com.bilet.model.Takvim;
import com.bilet.repositories.HavaalaniRepository;
import com.bilet.repositories.HavayoluHavaalaniRepository;
import com.bilet.repositories.HavayoluRepository;
import com.bilet.repositories.KullaniciRepository;
import com.bilet.repositories.MusteriRepository;
import com.bilet.repositories.TakvimRapository;

@RestController
@RequestMapping(path = "/bilet")
public class RestControllerDefault {
	
	
	@Autowired
	HavaalaniRepository havaalaniRepository;

	@Autowired
	HavayoluRepository havayolurepository;
	
	@Autowired
	HavayoluHavaalaniRepository havayoluhavaalanirepository;
	
	@Autowired
	KullaniciRepository kullanicirepository;
	
	@Autowired
	MusteriRepository musterirepository;
	
	@Autowired
	TakvimRapository takvimrepisorty;
	
	@GetMapping(path = "/getHavalaniList", produces = "application/json")
	public List<Havaalani> getHavalaniList() {
		System.out.println("test---223VVVV4344");
		return (List<Havaalani>) havaalaniRepository.findAll();
	}
	
	@GetMapping(path = "/getHavayoluList", produces = "application/json")
	public List<Havayolu> getHavaYoluList() {
		return (List<Havayolu>) havayolurepository.findAll();
	}

	@GetMapping(path = "/getHavaAlaniHavaYoluList",produces = "application/json")
	public List<HavaYoluHavaAlani> getHavaAlaniHavaYoluList(){
		return  (List<HavaYoluHavaAlani>) havayoluhavaalanirepository.findAll();
	}

	/******** havaAlani *****/
	@GetMapping(path="/getHavaalani/{id}",produces  = "application/json")
	@ResponseBody
	public ResponseEntity<Havaalani> getHavalaniById(@Valid @PathVariable(value = "id",name = "id") Long id) {
		Optional<Havaalani> havaalani = havaalaniRepository.findById(id);
		if (!havaalani.isPresent())
			throw new HavaAlaniNotFoundException("Havalanı Kaydı Bulunamadı ID="+id);
		ResponseEntity<Havaalani> responseEntity = new ResponseEntity<Havaalani>(havaalani.get(), HttpStatus.ACCEPTED);
		return responseEntity;
		
	}

	
	@PostMapping(path = "/havaalani/yeni", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Havaalani> addHavaalani(@RequestBody Havaalani havaalani) {
		
		Havaalani havaalanires = havaalaniRepository.save(havaalani);
		ResponseEntity<Havaalani> responseEntity = new ResponseEntity<Havaalani>(havaalani, HttpStatus.CREATED);
		return responseEntity;

	}
	@PostMapping(path = "/havaalani/guncelle", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Havaalani> updateHavaalani(@RequestBody Havaalani havaalani) {
		
		
		Optional<Havaalani> havaalani2 = havaalaniRepository.findById(havaalani.getId());
		
		if (havaalani2.isPresent()) {
			havaalani2.get().setHavalaniad(havaalani.getHavalaniad());
			havaalani2.get().setSehir(havaalani.getSehir());
			Havaalani havaalanires = havaalaniRepository.save(havaalani2.get());
			ResponseEntity<Havaalani> responseEntity = new ResponseEntity<Havaalani>(havaalanires, HttpStatus.CREATED);
			return responseEntity;
		} else {
			throw new HavaAlaniNotFoundException("Güncellemek istediğiniz Havalanı Bulunamadı ID="+havaalani.getId());
		}

	}


	/******************** havayolu ************/
		
	
	@PostMapping(path = "/havayolu/yeni", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Havayolu> addHavaYolu(@RequestBody Havayolu havayolu) {
		
		Havayolu havayolures = havayolurepository.save(havayolu);
		ResponseEntity<Havayolu> responseEntity = new ResponseEntity<Havayolu>(havayolu, HttpStatus.CREATED);
		return responseEntity;

	}
	
	
	@PostMapping(path = "/havayolu/guncelle", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Havayolu> updateHavaYolu(@RequestBody Havayolu havayolu) {
	Optional<Havayolu> havayolu2 = havayolurepository.findById(havayolu.getId());
	if (havayolu2.isPresent()) {
		Havayolu havayolu3 = havayolu2.get();
		havayolu3.setHavayoluad(havayolu.getHavayoluad());
		havayolurepository.save(havayolu3);
		ResponseEntity<Havayolu> responseEntity = new ResponseEntity<Havayolu>(havayolu3, HttpStatus.CREATED);
		return responseEntity;
	} else {
		throw new HavaYoluNotFoundException("Güncellenmek istenen Havayolu yok ID="+havayolu.getId());
	}
		
	}
	
	
	@PostMapping(path = "/havayoluhavaalani/yeni", consumes = "application/json", produces = "application/json")
	public ResponseEntity<HavaYoluHavaAlani> addHavaYoluHavaalani(@RequestBody HavaYoluHavaAlani havaYoluHavaAlani) {
		
		HavaYoluHavaAlani havayoluhavaalanires = havayoluhavaalanirepository.save(havaYoluHavaAlani);
		ResponseEntity<HavaYoluHavaAlani> responseEntity = new ResponseEntity<HavaYoluHavaAlani>(havayoluhavaalanires, HttpStatus.CREATED);
		return responseEntity;

	}
	/************************************KUllanıcı***********************************************************/
	@PostMapping(path="/kullanici/yeni",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Kullanici> addKullanici(@RequestBody Kullanici kullanici){
		Kullanici kullanicires = kullanicirepository.save(kullanici);
		
		ResponseEntity<Kullanici> responseEntity = new ResponseEntity<Kullanici>(kullanicires, HttpStatus.CREATED);
		return responseEntity;
		
	}
	
	@PostMapping(path = "/kullanici/guncelle",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Kullanici> updateKullanici(@RequestBody Kullanici kullanici) {
		Optional<Kullanici> kullaniciupdate = kullanicirepository.findById(kullanici.getId());
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
	
	}
	
	@GetMapping(path="/kullanici/{id}",produces = "application/json")
	public ResponseEntity<Kullanici> getKullanici(@Valid @PathVariable(value = "id",name = "id") Long id){
		
		Optional<Kullanici> kullanici  = kullanicirepository.findById(id);
		if (kullanici.isPresent()) {
			ResponseEntity<Kullanici> responseEntity = new ResponseEntity<Kullanici>(kullanici.get(),HttpStatus.ACCEPTED);
			return responseEntity;
		} else {
			throw new KullaniciNotFoundException("Aradığınız kullanici yok ID="+kullanici.get().getId());
		}
	
	}
	
	@GetMapping(path="/kullanici/getKullaniciList",produces = "application/json")
	public List<Kullanici> getKullaniciList() {
		List<Kullanici> listKullanici = (List<Kullanici>) kullanicirepository.findAll();
		return listKullanici;
	}
	/************************ Müşteri***************************/
	
	@PostMapping(path="/musteri/yeni",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Musteri> addMusteri(@RequestBody Musteri musteri){
		Musteri musterires = musterirepository.save(musteri);
		return new ResponseEntity<Musteri>(musterires,HttpStatus.CREATED);
		
	}
	@PostMapping(path="/musteri/guncelle",consumes = "application/json", produces = "application/json") 
	public ResponseEntity<Musteri> updateMusteri(@RequestBody Musteri musteri) {
		Optional<Musteri> musterires = musterirepository.findById(musteri.getId());
		
		if(musterires.isPresent()) {
			musterires.get().setAd(musteri.getAd());
			musterires.get().setSoyad(musteri.getSoyad());
			musterires.get().setEmail(musteri.getEmail());
			musterires.get().setGsm(musteri.getGsm());
			musterires.get().setTcno(musteri.getTcno());
			musterirepository.save(musterires.get());
			return  new ResponseEntity<Musteri>(musterires.get(),HttpStatus.CREATED);
		} else {
			throw new MusteriNotFoundException("Güncellemek istediğiniz Müşteri Bulanamadı ID="+musteri.getId());
		}
	}
	@GetMapping(path="/musteri/{id}", produces = "application/json")
	public ResponseEntity<Musteri> getMusteri(@PathVariable Long id) {
		Optional<Musteri> musterires = musterirepository.findById(id);
		if (musterires.isPresent()) {
			return  new ResponseEntity<Musteri>(musterires.get(),HttpStatus.ACCEPTED);

		} else {
			throw new MusteriNotFoundException("Aradığınız Müşteri Bulanamadı ID="+id);
		}
	}
	@GetMapping(path="/musteri/getMusteriList",produces = "application/json")
	public List<Musteri> getMusteriList() {
		 return (List<Musteri>)musterirepository.findAll();
				 
	}
	
	/***************************************Takvim *******************************/
	@PostMapping(path="/takvim/yeni",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Takvim> addTakvim(@RequestBody Takvim takvim) {
		Takvim takvimres = takvimrepisorty.save(takvim);
		return new ResponseEntity<Takvim>(takvimres,HttpStatus.CREATED);
	}
	
	@PostMapping(path="/takvim/guncelle",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Takvim> updateTakvim(@RequestBody Takvim takvim) {
		Optional<Takvim> takvimres = takvimrepisorty.findById(takvim.getId());
		if (takvimres.isPresent()) {
			takvimres.get().setAd(takvim.getAd());
			takvimres.get().setDonustarih(takvim.getDonustarih());
			takvimres.get().setEmail(takvim.getEmail());
			takvimres.get().setError(takvim.getError());
			takvimres.get().setGidistarih(takvim.getGidistarih());
			takvimres.get().setHavaalanId(takvim.getHavaalanId());
			takvimres.get().setHavayoluId(takvim.getHavayoluId());
			takvimres.get().setMusteriId(takvim.getMusteriId());
			takvimres.get().setRezarvasyontarih(takvim.getRezarvasyontarih());
			takvimres.get().setPnr(takvim.getPnr());
			takvimres.get().setSoyad(takvim.getSoyad());
			takvimres.get().setTcno(takvim.getTcno());
			takvimres.get().setYon(takvim.getYon());
			return new  ResponseEntity<Takvim>(takvimres.get(),HttpStatus.ACCEPTED);
		} else {
			throw new TakvimNotFoundException("Güncellemek istediğiniz takvim bulunamadı ID="+takvim.getId());
		}
		
	}
	public ResponseEntity<Takvim> getTakvim(@PathVariable Long id){
		Optional<Takvim> takvim = takvimrepisorty.findById(id);
		if (takvim.isPresent()) {
			return new ResponseEntity<Takvim>(takvim.get(),HttpStatus.CREATED);
		} else {
			throw new TakvimNotFoundException("Aradığınız takvim bulunamadı ID="+id);
		}
	}
	public ResponseEntity<Takvim> getTakvimByPnr(@PathVariable String pnr){
		Optional<Takvim> takvim = takvimrepisorty.findByPnr(pnr);
		if (takvim.isPresent()) {
			return new ResponseEntity<Takvim>(takvim.get(),HttpStatus.CREATED);
		} else {
			throw new TakvimNotFoundException("Aradığınız takvim bulunamadı ID="+pnr);
		}
	}
	
	@GetMapping(path="/takvim/getTakvimList",produces = "application/json")
	public List<Takvim> getTakvimList(){
		return (List<Takvim>)takvimrepisorty.findAll();
	}
	
}
