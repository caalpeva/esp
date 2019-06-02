package org.caalpeva.startwars.ws.api;

import java.io.IOException;

import org.caalpeva.commons.utils.DateUtils;
import org.caalpeva.starwars.configuration.AppConfig;
import org.caalpeva.starwars.service.DatabaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class DatabaseServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DatabaseService databaseService;
	
	@Test
	public void testRepository() throws IOException {
		long startTime = System.currentTimeMillis();
		databaseService.importData();
		long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + DateUtils.formatElapsedTime(endTime -startTime, true, true));
	}
}