package clv.project.com.springtest.ServiceImp;


import clv.project.com.springtest.Model.Clientes;
import clv.project.com.springtest.Repository.ClienteRepository;
import clv.project.com.springtest.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteSrvImp implements ClienteService {

    @Autowired
    ClienteRepository cli;

    @Override
    public List<Clientes> readAllCliente() {
        return cli.findAll();
    }

    @Override
    public Optional<Clientes> readClienteById(int idcliente) {
        return cli.findById(idcliente);
    }

    @Override
    public List<Clientes> findByCodigopago(int codigopago) {
        return cli.findByCodigopago(codigopago);
    }

    @Override
    public Clientes createCliente(Clientes cliente) {
        return cli.save(cliente);
    }

    @Override
    public Clientes updateCliente(int idcliente, Clientes cliente) {
        return null;
    }

    @Override
    public void deleteCliente(int idcliente) {
        cli.deleteById(idcliente);

    }
}
