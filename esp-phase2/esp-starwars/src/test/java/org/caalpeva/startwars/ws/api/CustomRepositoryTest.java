package org.caalpeva.startwars.ws.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.caalpeva.starwars.configuration.AppConfig;
import org.caalpeva.starwars.repository.PeopleRepository;
import org.caalpeva.starwars.repository.model.People;
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
public class CustomRepositoryTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Test
	public void testRepository() throws IOException {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(34);
		lista.add(35);
		List<People> people = peopleRepository.getPilotOfStarshipThatMostHasAppeared2(lista);
		for (People person: people) {
			System.out.println(person.getName());
		} // for
	}
}