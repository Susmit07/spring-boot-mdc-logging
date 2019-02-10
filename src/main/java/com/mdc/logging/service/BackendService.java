package com.mdc.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdc.logging.repository.DAORepository;

@Service
public class BackendService {

	private static final Logger LOG = LoggerFactory.getLogger(BackendService.class);

	@Autowired
	private DAORepository daoRepository;

	public String getData(String caller) {
		String standardGreeting = daoRepository.lookupData();
		LOG.info("Formatting greeting for [{}]", caller);
		return String.format("%s, %s", standardGreeting, caller);
	}
}
