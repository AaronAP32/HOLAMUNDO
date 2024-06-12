package clv.project.com.springtest.ServiceImp;

import clv.project.com.springtest.Model.Clientes;
import clv.project.com.springtest.Repository.ClienteRepository;
import clv.project.com.springtest.ServiceImp.ClienteSrvImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClienteSrvImpTest {

    @InjectMocks
    private ClienteSrvImp clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReadAllCliente() {
        List<Clientes> clientesList = new ArrayList<>();
        clientesList.add(new Clientes());
        clientesList.add(new Clientes());

        when(clienteRepository.findAll()).thenReturn(clientesList);

        List<Clientes> result = clienteService.readAllCliente();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testReadClienteById() {
        Clientes cliente = new Clientes();
        cliente.setIdcliente(1);

        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        Optional<Clientes> result = clienteService.readClienteById(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getIdcliente());
        verify(clienteRepository, times(1)).findById(1);
    }

    @Test
    public void testFindByCodigopago() {
        List<Clientes> clientesList = new ArrayList<>();
        clientesList.add(new Clientes());

        when(clienteRepository.findByCodigopago(73776464)).thenReturn(clientesList);

        List<Clientes> result = clienteService.findByCodigopago(73776464);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(clienteRepository, times(1)).findByCodigopago(73776464);
    }

    @Test
    public void testCreateCliente() {
        Clientes cliente = new Clientes();
        when(clienteRepository.save(any(Clientes.class))).thenReturn(cliente);

        Clientes result = clienteService.createCliente(cliente);

        assertNotNull(result);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testUpdateCliente() {
        // Implementa esta prueba cuando la funcionalidad esté disponible
        Clientes cliente = new Clientes();
        cliente.setIdcliente(1);

        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));
        when(clienteRepository.save(any(Clientes.class))).thenReturn(cliente);

        Clientes updatedCliente = new Clientes();
        updatedCliente.setNombre("Nuevo Nombre");

        Clientes result = clienteService.updateCliente(1, updatedCliente);

        assertNotNull(result);
        assertEquals("Nuevo Nombre", result.getNombre());
        verify(clienteRepository, times(1)).findById(1);
        verify(clienteRepository, times(1)).save(any(Clientes.class));
    }

    @Test
    public void testDeleteCliente() {
        doNothing().when(clienteRepository).deleteById(1);

        clienteService.deleteCliente(1);

        verify(clienteRepository, times(1)).deleteById(1);
    }
}