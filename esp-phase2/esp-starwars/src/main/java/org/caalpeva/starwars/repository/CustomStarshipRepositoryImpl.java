package org.caalpeva.starwars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.caalpeva.starwars.repository.model.Film;
import org.caalpeva.starwars.repository.model.Film_;
import org.caalpeva.starwars.repository.model.People;
import org.caalpeva.starwars.repository.model.Starship;
import org.caalpeva.starwars.repository.model.Starship_;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase repositorio para la entidad Starship encargada de implementar m�todos
 * de consultas din�micas
 * 
 * @author Alberto
 */
public class CustomStarshipRepositoryImpl implements CustomStarshipRepository {

	@Autowired
	private EntityManager entityManager;

	/**
	 * M�todo encargado de obtener la nave espacial pilotada que aparece m�s veces
	 * en las pel�culas especificadas. En caso de coincidencia en n�mero de apariciones
	 * se devolver� la nave espacial seg�n ordenaci�n alfab�tica
	 */
	@Override
	public String getStarshipThatAppearsMostInTheFilms(List<Integer> filmIds) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);

		// Se crea la consulta mediante CriteriaQuery
		Root<Starship> starshipEntity = criteriaQuery.from(Starship.class);
		Join<Starship, Film> filmEntity = starshipEntity.join(Starship_.films);
		Join<Starship, People> peopleEntity = starshipEntity.join(Starship_.peoples);

		criteriaQuery.select(starshipEntity.get(Starship_.name));
		if (filmIds != null && filmIds.size() > 0) {
			criteriaQuery.where(filmEntity.get(Film_.id).in(filmIds));
		}
		criteriaQuery.groupBy(starshipEntity.get(Starship_.name));
		criteriaQuery.orderBy(builder.desc(builder.count(peopleEntity)),
				builder.asc(starshipEntity.get(Starship_.name)));

		// Extrayendo el primer elemento del resultado ordenado descendentemente se
		// obtiene el m�ximo
		TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
		List<String> results = typedQuery.getResultList();
		if (!results.isEmpty()) {
			return results.get(0);
		}
		return null;
	}
}