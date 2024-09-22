package com.supervisor.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supervisor.entity.Supervisor;

@Service
public class SupervisorService {

	private static final Logger LGR = LoggerFactory.getLogger(SupervisorService.class);
    private final ExternalAPIService externalAPIService;

    public SupervisorService(ExternalAPIService externalAPIService) {
		this.externalAPIService = externalAPIService;
	}
	
	public List<Supervisor> getAllSupervisors(){
		List<Supervisor> supervisors = new ArrayList<>();
		String fetchedSupervisors = externalAPIService.fetchSupervisorDataFromExternalAPI();
		ObjectMapper mapper = new ObjectMapper();
        try {
			supervisors = mapper.readValue(fetchedSupervisors, new TypeReference<List<Supervisor>>(){});
			supervisors = supervisors.stream().filter(s -> !isNumeric(s.getJurisdiction())).sorted(Comparator.comparing(Supervisor::getJurisdiction)
                    .thenComparing(Supervisor::getLastName)
                    .thenComparing(Supervisor::getFirstName))
            .collect(Collectors.toList());;
            
		} catch (Exception e) {
			LGR.info(LGR.isInfoEnabled()? "Exception occured while fetching all supervisros: " : null, e);
		}
		return supervisors;
	}
	
	private boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

}
