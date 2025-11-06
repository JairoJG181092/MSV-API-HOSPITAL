package com.example.citas.services;

import org.springframework.stereotype.Service;

import com.example.citas.dto.CitaRequest;
import com.example.citas.dto.CitaResponse;
import com.example.commons.services.CommonService;

@Service
public interface CitaService extends CommonService<CitaRequest, CitaResponse>{
	
}
