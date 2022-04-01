package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dao.ServiceRequestDao;
import com.cg.apps.tataskyapp.dto.ServiceRequestDto;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    ServiceRequestDao serDao;
    @Autowired
    AccountDao accDao;

    @Override
    public String createServiceRequestForUser(ServiceRequestDto dto) {
        Optional<Account> opt = accDao.findById(dto.getAccount_id());
        Account acc = opt.get();
        ServiceRequest req = new ServiceRequest();
        req.setAccount(acc);
        req.setMessage(dto.getMessage());
        req.setRequestDate(dto.getRequestDate());
        req.setStatusOpened(dto.getStatusOpened());
        serDao.save(req);
        List<ServiceRequest> sr = acc.getRequests();
        sr.add(req);
        return "service request is created";
    }

    @Override
    public List<ServiceRequest> openedServiceRequest(Long accountId) {
        Optional<Account> opt = accDao.findById(accountId);
        Account acc = opt.get();
        List<ServiceRequest> reqlist = acc.getRequests();
        return reqlist;
    }

    @Override
    public ServiceRequest close(Long serviceRequestId) {
        Optional<ServiceRequest> opt = serDao.findById(serviceRequestId);
        ServiceRequest req = opt.get();
        req.setStatusOpened(false);
        req.setMessage("request is closed");
        serDao.save(req);
        return req;
    }

}