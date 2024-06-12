package clv.project.com.springtest.Controller;

import clv.project.com.springtest.Model.Cobros;
import clv.project.com.springtest.Service.CobrosService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CobrosController.class)
public class CobrosControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CobrosService cobrosService;

    private Cobros cobros;

    @BeforeEach
    void setUp() {
        cobros = new Cobros();
        cobros.setIdcobros(1);
        cobros.setCodigopago(123);
        cobros.setRecibo("REC-001");
        cobros.setDescripcionrecibo("Pago mensual");
        cobros.setPagado("Si");
        cobros.setFechapago("2024-06-03");
        cobros.setFormapago("Tarjeta");
    }

    @Test
    public void guardarCobro() throws Exception {
        Mockito.when(cobrosService.createCobros(Mockito.any(Cobros.class))).thenReturn(cobros);

        mockMvc.perform(post("/cobros/guardar")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content("{\n" +
                                "    \"codigopago\": 123,\n" +
                                "    \"recibo\": \"REC-001\",\n" +
                                "    \"descripcionrecibo\": \"Pago mensual\",\n" +
                                "    \"pagado\": \"Si\",\n" +
                                "    \"fechapago\": \"2024-06-03\",\n" +
                                "    \"formapago\": \"Tarjeta\"\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.idcobros").value(cobros.getIdcobros()))
                .andExpect((ResultMatcher) jsonPath("$.codigopago").value(cobros.getCodigopago()))
                .andExpect((ResultMatcher) jsonPath("$.recibo").value(cobros.getRecibo()))
                .andExpect((ResultMatcher) jsonPath("$.descripcionrecibo").value(cobros.getDescripcionrecibo()))
                .andExpect((ResultMatcher) jsonPath("$.pagado").value(cobros.getPagado()))
                .andExpect((ResultMatcher) jsonPath("$.fechapago").value(cobros.getFechapago()))
                .andExpect((ResultMatcher) jsonPath("$.formapago").value(cobros.getFormapago()));
    }

}