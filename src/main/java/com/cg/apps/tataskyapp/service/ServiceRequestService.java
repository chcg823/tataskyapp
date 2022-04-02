package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dto.ServiceRequestDto;
import com.cg.apps.tataskyapp.entities.ServiceRequest;

import java.util.List;

public interface ServiceRequestService {

    //void addServiceRequest(ServiceRequest sr);
    String createServiceRequestForUser(ServiceRequestDto dto);

    List<ServiceRequest> openedServiceRequest(Long accountId);

    ServiceRequest close(Long serviceRequestId);
}