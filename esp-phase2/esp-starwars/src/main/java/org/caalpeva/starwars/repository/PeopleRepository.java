package org.caalpeva.starwars.repository;

import java.util.List;
import java.util.Optional;

import org.caalpeva.starwars.repository.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
	public Optional<People> findByName(String name);
	
	/**
	 * M�todo que se encarga de obtener el listado de pel�culas agrupadas
	 * por cada uno de los personajes que ha participado en ellas.
	 * Este m�todo es m�s eficiente que realizar una consulta por cada uno
	 * de los personajes para obtener su listado de pel�culas.
	 * @return
	 */
	@Query("select p.name, f.title from People p inner join Film f order by p.name")
	public List<Object[]> getPeopleWithFilms();

//	select p.name, count(*) from people p
//	inner join PEOPLE_FILMS pf on p.id = pf.characterList_id
//	inner join FILMS f on pf.filmList_id = f.id
//	group by p.name

}