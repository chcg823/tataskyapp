package com.cg.apps.tataskyapp.controller;

import java.util.List;

import com.cg.apps.tataskyapp.utils.PackAlreadyExistException;
import com.cg.apps.tataskyapp.utils.PackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.apps.tataskyapp.dao.PackDao;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.service.PackService;

@RestController
@RequestMapping("/pack")
public class PackController {

	@Autowired
	PackService packService;
	@Autowired
	PackDao pDao;

	@PostMapping("/add")
	public ResponseEntity<String> addPack(@RequestBody Pack pack) {
		Pack pk = pDao.findById(pack.getId()).orElse(null);
		if(pk!=null)
			throw new PackAlreadyExistException();
		packService.addPack(pack);
		return new ResponseEntity<>("Pack added",HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Pack> updatePack(@RequestBody Pack pack){
		Pack pk = pDao.findById(pack.getId()).orElse(null);
		if(pk!=null)
			throw new PackAlreadyExistException();
		Pack p=packService.update(pack);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteByPack(@RequestBody Pack pack){
		Pack pk = pDao.findById(pack.getId()).orElse(null);
		if(pk==null)
			throw new PackNotFoundException();
		packService.removePack(pack);
		return new ResponseEntity<>("Pack deleted",HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pack> getPackById(@PathVariable long id){
		Pack pk = pDao.findById(id).orElse(null);
		if(pk==null)
			throw new PackNotFoundException();
		Pack p=packService.findPackById(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	@GetMapping("amount/{amount}")
	public ResponseEntity<List<Pack>> getPacksGreaterThanAmount(@PathVariable double amount){
		List<Pack> packList=packService.findPacksGreaterThanAmount(amount);
		return new ResponseEntity<>(packList,HttpStatus.OK);
	}
	@GetMapping("/asc-by-cost/")
	public ResponseEntity<List<Pack>> getPacksInAscendingOrderByCost(){
		List<Pack> packList=packService.findPacksInAscendingOrderByCost();

		return new ResponseEntity<>(packList,HttpStatus.OK);
	}
	@GetMapping("/asc-by-validity")
	public ResponseEntity<List<Pack>> getPacksInAscendingOrderByDaysValidity(){
		List<Pack> packList=packService.findPacksInAscendingOrderByDaysValidity();
		return new ResponseEntity<>(packList,HttpStatus.OK);
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeById(@PathVariable Long id){
		Pack p = pDao.findById(id).orElse(null);
		if (p==null)
			throw new PackNotFoundException();
		packService.deleteByPackId(id);
		return new ResponseEntity<>("Pack deleted..",HttpStatus.OK);
	}
}