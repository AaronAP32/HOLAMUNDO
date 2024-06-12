package clv.project.com.springtest.Service;

import clv.project.com.springtest.Model.Clientes;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Clientes> readAllCliente();
    Optional<Clientes> readClienteById(int idcliente);
    List<Clientes> findByCodigopago(int codigopago);
    Clientes createCliente(Clientes cliente);
    Clientes updateCliente(int idcliente, Clientes cliente);
    void deleteCliente(int idcliente);
}
