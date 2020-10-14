package adn.edwin.generadorcitasapi.dominio.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cupon;

public interface RepositorioCupon {

    Cupon agregar(Cupon cupon);

    Cupon obtener(Long id);

}
