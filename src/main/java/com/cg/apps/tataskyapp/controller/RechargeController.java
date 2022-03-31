package com.cg.apps.tataskyapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dao.PackDao;
import com.cg.apps.tataskyapp.dao.RechargeDao;
import com.cg.apps.tataskyapp.dto.RechargeDto;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;
import com.cg.apps.tataskyapp.service.RechargeService;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import com.cg.apps.tataskyapp.utils.PackNotFoundException;
import com.cg.apps.tataskyapp.utils.RechargeNotFoundException;

@RestController
@RequestMapping("/recharge")
public class RechargeController {
	@Autowired
	RechargeService rechargeService;
	@Autowired
	PackDao packDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	RechargeDao rechargeDao;

	@PostMapping("/{accountId}/{packId}")
	public ResponseEntity<String> createRecharge(@PathVariable long packId, @PathVariable long accountId){
		Pack pack = packDao.findById(packId).orElse(null);
		Account account = accountDao.findById(accountId).orElse(null);
		if(pack == null) {
			throw new PackNotFoundException();
		}
		if(account == null) {
			throw new AccountNotFoundException();
		}
		Recharge recharge = rechargeService.createRecharge(pack, account);
		return new ResponseEntity<String>("recharge done", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Recharge> update(@RequestBody RechargeDto rechargeDto){
		Recharge recharge = new Recharge();
		recharge.setAccount(accountDao.findById(rechargeDto.getAccountId()).orElse(null));
		recharge.setActive(rechargeDto.isActive());
		recharge.setPack(packDao.findById(rechargeDto.getPackId()).orElse(null));
		recharge.setAmount(rechargeDto.getAmount());
		recharge.setChannels(rechargeDto.getChannels());
		recharge.setDaysValidity(rechargeDto.getDaysValidity());
		recharge.setId(rechargeDto.getRechargeId());
		recharge.setPlanDescription(rechargeDto.getPlanDescription());
		recharge.setPlanName(rechargeDto.getPlanName());
		recharge.setPurchasedDate(rechargeDto.getPurchasedDate());
		return new ResponseEntity<Recharge>(rechargeService.update(recharge), HttpStatus.OK);
	}

	@GetMapping("/list-by-date-desc/{accountId}")
	public ResponseEntity<List<Recharge>> findRechargesForUserInDescendingOrderByPurchasedDate(@PathVariable long accountId){
		Account account = accountDao.findById(accountId).orElse(null);
		if(account == null) {
			throw new AccountNotFoundException();
		}
		List<Recharge> rechargeInDescendingOrder = rechargeService.findRechargesForUserInDescendingOrderByPurchasedDate(account);
		return new ResponseEntity<List<Recharge>>(rechargeInDescendingOrder, HttpStatus.OK);
	}

	@GetMapping("/recharge-count/{accountId}")
	public ResponseEntity<Integer> rechargesForUserCount(@PathVariable long accountId){
		Account account = accountDao.findById(accountId).orElse(null);
		if(account == null) {
			throw new AccountNotFoundException();
		}
		return new ResponseEntity<Integer>(rechargeService.rechargesForUserCount(account), HttpStatus.OK);
	}

	@GetMapping("/period/{startDate}/{endDate}")
	public ResponseEntity<List<Recharge>> findAllRechargesInPeriod(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
		List<Recharge> rechargeListInPeriod = rechargeService.findAllRechargesInPeriod(startDate, endDate);
		return new ResponseEntity<List<Recharge>>(rechargeListInPeriod, HttpStatus.OK);
	}

	@GetMapping("/period-count/{startDate}/{endDate}")
	public ResponseEntity<Integer> countRechargesInPeriod(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
		return new ResponseEntity<Integer>(rechargeService.countRechargesInPeriod(startDate, endDate), HttpStatus.OK);
	}

	@GetMapping("/total-revenue/{startDate}/{endDate}")
	public ResponseEntity<Double> totalRevenueInPeriod(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
		return new ResponseEntity<Double>(rechargeService.totalRevenueInPeriod(startDate, endDate), HttpStatus.OK);
	}

	@GetMapping("/pack-count/{packId}")
	public ResponseEntity<Integer> rechargesCount(@PathVariable long packId){
		Pack pack = packDao.findById(packId).orElse(null);
		if(pack == null) {
			throw new PackNotFoundException();
		}
		return new ResponseEntity<Integer>(rechargeService.rechargesCount(pack), HttpStatus.OK);
	}

	@GetMapping("/validity/{accountId}/{rechargeId}")
	public ResponseEntity<String> expireIfValidityFinished(@PathVariable long accountId, @PathVariable long rechargeId){
		Account account = accountDao.findById(accountId).orElse(null);
		Recharge recharge = rechargeDao.findById(rechargeId).orElse(null);
		if(recharge == null) {
			throw new RechargeNotFoundException();
		}
		if(account == null) {
			throw new AccountNotFoundException();
		}
		String message = rechargeService.expireIfValidityFinished(account, recharge);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}