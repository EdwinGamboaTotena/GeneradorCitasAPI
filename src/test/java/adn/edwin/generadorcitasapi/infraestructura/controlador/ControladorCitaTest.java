package adn.edwin.generadorcitasapi.infraestructura.controlador;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoCita;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.ProductoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorCitaTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getCitaPorId() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/cita/{id}", "30")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cedulaCliente").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioProducto").value(18000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productoSolicitado.id").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productoSolicitado.precio").value(20000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cuponUsado.id").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cuponUsado.porcentajeDescuento").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaGeneracion").value("2020-10-10"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaSolicitud").value("2020-10-14"));
    }

    @Test
    public void getCitas() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/cita")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cedulaCliente").value("1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].precioProducto").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productoSolicitado.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productoSolicitado.precio").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cuponUsado").isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fechaGeneracion").value("2020-10-10"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fechaSolicitud").value("2020-10-12"));
    }

    @Test
    public void agregarCita() throws Exception {
        ComandoCita comandoCita = new CitaTestDataBuilder().conId(null).conCedula("123456789")
                .conComandoProducto(new ProductoTestDataBuilder().conId(2L).buildComando())
                .conCupon(new CuponTestDataBuilder().conId(1L).build()).buildComando();
        mvc.perform(MockMvcRequestBuilders
                .post("/cita")
                .content(objectMapper.writeValueAsString(comandoCita))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(31))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cedulaCliente").value("123456789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioProducto").value(18000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaSolicitud").value("2020-11-09"));
    }
}
