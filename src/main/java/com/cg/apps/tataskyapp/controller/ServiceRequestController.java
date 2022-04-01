package com.cg.apps.tataskyapp.controller;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dao.ServiceRequestDao;
import com.cg.apps.tataskyapp.dto.ServiceRequestDto;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.ServiceRequest;
import com.cg.apps.tataskyapp.service.ServiceRequestService;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import com.cg.apps.tataskyapp.utils.RequestNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicerequest")
public class ServiceRequestController {
    @Autowired
    ServiceRequestService serReq;
    @Autowired
    AccountDao accDao;
    @Autowired
    ServiceRequestDao srDao;

    @PostMapping("/add")
    public ResponseEntity<String> createServiceRequestForUser(@RequestBody ServiceRequestDto dto) {
        Long id = dto.getAccount_id();
        Account acc;
        acc = accDao.findById(id).orElse(null);
        if (acc == null)
            throw new AccountNotFoundException();
        String str = serReq.createServiceRequestForUser(dto);
        return new ResponseEntity<String>(str, HttpStatus.OK);
        //return str;
    }

    @GetMapping("/find_opened_req/{accountId}")
    public ResponseEntity<List<ServiceRequest>> openedServiceRequest(@PathVariable Long accountId) {
        Account acc;
        acc = accDao.findById(accountId).orElse(null);
        if (acc == null)
            throw new AccountNotFoundException();
        List<ServiceRequest> serReqList = serReq.openedServiceRequest(accountId);
        if (serReqList == null)
            throw new RequestNotFoundException();
        return new ResponseEntity<List<ServiceRequest>>(serReqList, HttpStatus.OK);
    }

    @GetMapping("/close/{service_id}")
    public ResponseEntity<ServiceRequest> close(@PathVariable Long service_id) {
        ServiceRequest req;
        req = srDao.findById(service_id).orElse(null);
        if (req == null)
            throw new RequestNotFoundException();
        ServiceRequest sr = serReq.close(service_id);
        return new ResponseEntity<ServiceRequest>(sr, HttpStatus.OK);
    }
}