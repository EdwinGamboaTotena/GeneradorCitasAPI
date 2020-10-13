package adn.edwin.generadorcitasapi.infraestructura.configuracion;

import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioAgregarCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioListarCitas;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioObtenerCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioAgregarCupon;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioObtenerCupon;
import adn.edwin.generadorcitasapi.dominio.servicio.producto.ServicioAgregarProducto;
import adn.edwin.generadorcitasapi.dominio.servicio.producto.ServicioListarProductos;
import adn.edwin.generadorcitasapi.dominio.servicio.producto.ServicioObtenerProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioObtenerProducto servicioObtenerProducto(RepositorioProducto repositorioProducto) {
        return new ServicioObtenerProducto(repositorioProducto);
    }

    @Bean
    public ServicioListarProductos servicioListarProductos(RepositorioProducto repositorioProducto) {
        return new ServicioListarProductos(repositorioProducto);
    }

    @Bean
    public ServicioAgregarProducto servicioAgregarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioAgregarProducto(repositorioProducto);
    }

    @Bean
    public ServicioObtenerCupon servicioObtenerCupon(RepositorioCupon repositorioCupon) {
        return new ServicioObtenerCupon(repositorioCupon);
    }

    @Bean
    public ServicioAgregarCupon servicioAgregarCupon(RepositorioCupon repositorioCupon) {
        return new ServicioAgregarCupon(repositorioCupon);
    }

    @Bean
    public ServicioObtenerCita servicioObtenerCita(RepositorioCita repositorioCita) {
        return new ServicioObtenerCita(repositorioCita);
    }

    @Bean
    public ServicioListarCitas servicioListarCitas(RepositorioCita repositorioCita) {
        return new ServicioListarCitas(repositorioCita);
    }

    @Bean
    public ServicioAgregarCita servicioAgregarCita(RepositorioCita repositorioCita) {
        return new ServicioAgregarCita(repositorioCita);
    }
}