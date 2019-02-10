package com.mdc.logging.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DAORepository {

	private static final Logger LOG = LoggerFactory.getLogger(DAORepository.class);

	public String lookupData() {
		LOG.info("Retrieving standard greeting from the \"database\"");
		return "Hello World";
	}
}
