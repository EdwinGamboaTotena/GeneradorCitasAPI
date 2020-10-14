package adn.edwin.generadorcitasapi.infraestructura;

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
public class ControladorProductoTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getProductoPorId() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/producto/{id}", "10")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("SoloTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precio").value(10000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.porcetajeCuponGenerar").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.generaCupo").value(false));
    }

    @Test
    public void getProductos() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/producto")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("Solo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].precio").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].porcetajeCuponGenerar").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].generaCupo").value(false));
    }

}
