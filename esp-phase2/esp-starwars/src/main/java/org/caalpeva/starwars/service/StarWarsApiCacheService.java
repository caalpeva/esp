package org.caalpeva.starwars.service;

/**
 * Interfaz encargada de declarar los m�todos para acceder al webservice
 * @author Alberto
 */
public interface StarWarsApiCacheService extends StarWarsApiService {
	public void cleanCache();
}