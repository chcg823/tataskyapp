package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dto.ServiceRequestDto;
import com.cg.apps.tataskyapp.entities.ServiceRequest;

import java.util.List;

public interface ServiceRequestService {

    String createServiceRequestForUser(ServiceRequestDto dto);

    List<ServiceRequest> serviceRequests(Long accountId);
    List<ServiceRequest>openedServiceRequests(Long accountId);

    ServiceRequest close(Long serviceRequestId);
}