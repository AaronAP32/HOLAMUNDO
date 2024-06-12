package clv.project.com.springtest.Auth;

import clv.project.com.springtest.Jwt.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @MockBean
    private JwtService jwtService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testLogin() throws Exception {
        // Mocking del servicio Login
        LoginRequest loginRequest = new LoginRequest("testeo9", "1234", "73776464");
        AuthResponse expectedResponse = new AuthResponse("testtoken");

        when(authService.login(any(LoginRequest.class))).thenReturn(expectedResponse);
        when(jwtService.getUsernameFromToken(any(String.class))).thenReturn("testeo9");

        // Realizar la solicitud
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/auth/loging")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verificar Respuesta
        AuthResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AuthResponse.class);
        assert response.getToken().equals(expectedResponse.getToken());
    }

    @Test
    public void testRegister() throws Exception {
        // Mocking del servicio de registro
        RegisterRequest registerRequest = new RegisterRequest("user20", "password", "12345", "USER");
        AuthResponse expectedResponse = new AuthResponse("testtoken");

        when(authService.register(any(RegisterRequest.class))).thenReturn(expectedResponse);
        when(jwtService.getUsernameFromToken(any(String.class))).thenReturn("user10");

        // Realizar la solicitud
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/auth/registro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verificar Respuesta
        AuthResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AuthResponse.class);

        // Verificar que la respuesta no es nula y tiene el token esperado
        assertNotNull(response);
        assertNotNull(response.getToken());
        assertEquals(expectedResponse.getToken(), response.getToken());
    }
}