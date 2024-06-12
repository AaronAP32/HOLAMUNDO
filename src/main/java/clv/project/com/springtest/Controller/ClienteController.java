package clv.project.com.springtest.Controller;


import clv.project.com.springtest.Model.Clientes;
import clv.project.com.springtest.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cliente")
@CrossOrigin({"*"})
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/listar")
    public List<Clientes> getAllClientes() {
        return clienteService.readAllCliente();
    }

    @GetMapping("/buscar/{idcliente}")
    public Optional<Clientes> getClienteById(@PathVariable int idcliente) {
        return clienteService.readClienteById(idcliente);
    }

    @GetMapping("/buscar/cod/{codigopago}")
    public List<Clientes> getClienteByCodigopa(@PathVariable int codigopago) {
        return clienteService.findByCodigopago(codigopago);
    }


    @GetMapping("/crear")
    public Clientes create(@RequestBody Clientes cliente) {
        return clienteService.createCliente(cliente);
    }


    @DeleteMapping("/borrar/{idcliente}")
    public void delete(@PathVariable int idcliente) {
        clienteService.deleteCliente(idcliente);
    }





}
