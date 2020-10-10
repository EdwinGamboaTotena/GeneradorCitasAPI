package adn.edwin.generadorcitasapi.dominio.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cupon;

public interface RepositorioCupon {

    void agregar(Cupon cupon);

    Cupon obtener(Long id);

}
