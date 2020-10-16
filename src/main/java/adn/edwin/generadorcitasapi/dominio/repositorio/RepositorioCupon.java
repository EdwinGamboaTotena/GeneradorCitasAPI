package adn.edwin.generadorcitasapi.dominio.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;

public interface RepositorioCupon {

    Cupon agregar(Cupon cupon);

    Cupon obtener(Long id);

    Cupon obtenerCuponConsumido(Cita cita);

    Cupon obtenerCuponGeneradoId(Cita cita);

    Cupon editar(Cupon cupon, Cita citaConsumidora);

}
