package com.cg.apps.tataskyapp.controller;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dao.PackDao;
import com.cg.apps.tataskyapp.dao.RechargeDao;
import com.cg.apps.tataskyapp.dto.RechargeDisplayDto;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;
import com.cg.apps.tataskyapp.service.RechargeService;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import com.cg.apps.tataskyapp.utils.PackNotFoundException;
import com.cg.apps.tataskyapp.utils.RechargeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<RechargeDisplayDto> createRecharge(@PathVariable long packId, @PathVariable long accountId) {
        Pack pack = packDao.findById(packId).orElse(null);
        Account account = accountDao.findById(accountId).orElse(null);
        if (pack == null) {
            throw new PackNotFoundException();
        }
        if (account == null) {
            throw new AccountNotFoundException();
        }
        Recharge recharge = rechargeService.createRecharge(pack, account);
        RechargeDisplayDto rechargeDisplayDto = new RechargeDisplayDto(recharge);
        return new ResponseEntity<RechargeDisplayDto>(rechargeDisplayDto, HttpStatus.OK);
    }

    @PutMapping("/update/{packId}/{accountId}/{rechargeId}")
    public ResponseEntity<RechargeDisplayDto> update(@PathVariable long packId, @PathVariable long accountId, @PathVariable long rechargeId) {
        Account account = accountDao.findById(accountId).orElse(null);
        Pack pack = packDao.findById(packId).orElse(null);
        Recharge recharge = rechargeDao.findById(rechargeId).orElse(null);
        if (pack == null) {
            throw new PackNotFoundException();
        }
        if (account == null) {
            throw new AccountNotFoundException();
        }
        if (recharge == null) {
            throw new RechargeNotFoundException();
        }
        Recharge recharge2 = rechargeService.update(pack, account, rechargeId);
        RechargeDisplayDto rechargeDisplayDto = new RechargeDisplayDto(recharge2);
        return new ResponseEntity<>(rechargeDisplayDto, HttpStatus.OK);
    }

    @GetMapping("/find/{accountId}")
    public ResponseEntity<List<RechargeDisplayDto>> findRechargesForUserInDescendingOrderByPurchasedDate(@PathVariable long accountId) {
        Account account = accountDao.findById(accountId).orElse(null);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        List<Recharge> rechargeInDescendingOrder = rechargeService.findRechargesForUserInDescendingOrderByPurchasedDate(account);
        List<RechargeDisplayDto> rechargeDisplayDtos = new ArrayList<>();
        for (Recharge recharge : rechargeInDescendingOrder)
            rechargeDisplayDtos.add(new RechargeDisplayDto(recharge));
        return new ResponseEntity<>(rechargeDisplayDtos, HttpStatus.OK);
    }

    @GetMapping("/find/foruser/{accountId}")
    public ResponseEntity<Integer> rechargesForUserCount(@PathVariable long accountId) {
        Account account = accountDao.findById(accountId).orElse(null);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        int count = rechargeService.rechargesForUserCount(account);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/findall/{startDate}/{endDate}")
    public ResponseEntity<List<RechargeDisplayDto>> findAllRechargesInPeriod(@PathVariable String startDate, @PathVariable String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        List<Recharge> rechargeListInPeriod = rechargeService.findAllRechargesInPeriod(startLDate, endLDate);
        List<RechargeDisplayDto> rechargeDisplayDtos = new ArrayList<>();
        for (Recharge recharge : rechargeListInPeriod)
            rechargeDisplayDtos.add(new RechargeDisplayDto(recharge));
        return new ResponseEntity<>(rechargeDisplayDtos, HttpStatus.OK);
    }

    @GetMapping("/find/inperiod/{startDate}/{endDate}")
    public ResponseEntity<Integer> countRechargesInPeriod(@PathVariable String startDate, @PathVariable String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        return new ResponseEntity<Integer>(rechargeService.countRechargesInPeriod(startLDate, endLDate), HttpStatus.OK);
    }

    @GetMapping("/totalrevenue/inperiod/{startDate}/{endDate}")
    public ResponseEntity<Double> totalRevenueInPeriod(@PathVariable String startDate, @PathVariable String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        return new ResponseEntity<Double>(rechargeService.totalRevenueInPeriod(startLDate, endLDate), HttpStatus.OK);
    }

    @GetMapping("/rechargecount/forpack/{packId}")
    public ResponseEntity<Integer> rechargesCount(@PathVariable long packId) {
        Pack pack = packDao.findById(packId).orElse(null);
        if (pack == null) {
            throw new PackNotFoundException();
        }
        return new ResponseEntity<Integer>(rechargeService.rechargesCount(pack), HttpStatus.OK);
    }

    @GetMapping("/validity/foraccount/{accountId}/{rechargeId}")
    public ResponseEntity<String> expireIfValidityFinished(@PathVariable long accountId, @PathVariable long rechargeId) {
        Account account = accountDao.findById(accountId).orElse(null);
        Recharge recharge = rechargeDao.findById(rechargeId).orElse(null);
        if (recharge == null) {
            throw new RechargeNotFoundException();
        }
        if (account == null) {
            throw new AccountNotFoundException();
        }
        String message = rechargeService.expireIfValidityFinished(account, recharge);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}