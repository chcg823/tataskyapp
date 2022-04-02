package com.cg.apps.tataskyapp.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cg.apps.tataskyapp.dto.RechargeDisplayDto;
import com.cg.apps.tataskyapp.dto.RechargeDtoForAcc;
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

    @PostMapping("/create/{packId}/{accountId}")
    public ResponseEntity<RechargeDtoForAcc> createRecharge(@PathVariable long packId, @PathVariable long accountId){
        Pack pack = packDao.findById(packId).orElse(null);
        Account account = accountDao.findById(accountId).orElse(null);
        if(pack == null) {
            throw new PackNotFoundException();
        }
        if(account == null) {
            throw new AccountNotFoundException();
        }
        Recharge recharge = rechargeService.createRecharge(pack, account);
        RechargeDtoForAcc rechargeDtoForAcc = new RechargeDtoForAcc(recharge);
        return new ResponseEntity<RechargeDtoForAcc>(rechargeDtoForAcc, HttpStatus.OK);
    }

    @PutMapping("/update/{rechargeDto}")
    public ResponseEntity<RechargeDisplayDto> update(@RequestBody RechargeDto rechargeDto){
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
        rechargeService.update(recharge);
        RechargeDisplayDto rechargeDisplayDto = new RechargeDisplayDto(recharge);
        return new ResponseEntity<>(rechargeDisplayDto, HttpStatus.OK);
    }

    @GetMapping("/find/{accountId}")
    public ResponseEntity<List<RechargeDisplayDto>> findRechargesForUserInDescendingOrderByPurchasedDate(@PathVariable long accountId){
        Account account = accountDao.findById(accountId).orElse(null);
        if(account == null) {
            throw new AccountNotFoundException();
        }
        List<Recharge> rechargeInDescendingOrder = rechargeService.findRechargesForUserInDescendingOrderByPurchasedDate(account);
        List<RechargeDisplayDto> rechargeDisplayDtos = new ArrayList<>();
        for(Recharge recharge: rechargeInDescendingOrder)
            rechargeDisplayDtos.add(new RechargeDisplayDto(recharge));
        return new ResponseEntity<>(rechargeDisplayDtos, HttpStatus.OK);
    }

    @GetMapping("/find/foruser/{accountId}")
    public ResponseEntity<Integer> rechargesForUserCount(@PathVariable long accountId){
        Account account = accountDao.findById(accountId).orElse(null);
        if(account == null) {
            throw new AccountNotFoundException();
        }
        int count = rechargeService.rechargesForUserCount(account);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/findall/{startDate}/{endDate}")
    public ResponseEntity<List<RechargeDisplayDto>> findAllRechargesInPeriod(@PathVariable String startDate, @PathVariable String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        List<Recharge> rechargeListInPeriod = rechargeService.findAllRechargesInPeriod(startLDate, endLDate);
        List<RechargeDisplayDto> rechargeDisplayDtos = new ArrayList<>();
        for(Recharge recharge: rechargeListInPeriod)
            rechargeDisplayDtos.add(new RechargeDisplayDto(recharge));
        return new ResponseEntity<>(rechargeDisplayDtos, HttpStatus.OK);
    }

    @GetMapping("/find/inperiod/{startDate}/{endDate}")
    public ResponseEntity<Integer> countRechargesInPeriod(@PathVariable String startDate, @PathVariable String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        return new ResponseEntity<Integer>(rechargeService.countRechargesInPeriod(startLDate, endLDate), HttpStatus.OK);
    }

    @GetMapping("/totalrevenue/inperiod/{startDate}/{endDate}")
    public ResponseEntity<Double> totalRevenueInPeriod(@PathVariable String startDate, @PathVariable String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        return new ResponseEntity<Double>(rechargeService.totalRevenueInPeriod(startLDate, endLDate), HttpStatus.OK);
    }

    @GetMapping("/rechargecount/forpack/{packId}")
    public ResponseEntity<Integer> rechargesCount(@PathVariable long packId){
        Pack pack = packDao.findById(packId).orElse(null);
        if(pack == null) {
            throw new PackNotFoundException();
        }
        return new ResponseEntity<Integer>(rechargeService.rechargesCount(pack), HttpStatus.OK);
    }

    @GetMapping("/validity/foraccount/{accountId}/{rechargeId}")
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