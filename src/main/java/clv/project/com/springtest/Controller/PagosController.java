package clv.project.com.springtest.Controller;


import clv.project.com.springtest.Model.Pagos;
import clv.project.com.springtest.Service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pagos")
@CrossOrigin({"*"})
public class PagosController {

    @Autowired
    PagosService pagosService;

    @GetMapping("/listar")
    public List<Pagos> getAllPagos(){
        return pagosService.readAllPagos();
    }

    @GetMapping("/buscar/{idpagos}")
    public Optional<Pagos> getPagosById(@PathVariable int idpagos){
        return pagosService.readById(idpagos);
    }

    @GetMapping("/buscar/cod/{codigopago}")
    public List<Pagos> getPagosByCodigo(@PathVariable int codigopago){
        return pagosService.findByCodigopago(codigopago);
    }

    @GetMapping("/crear")
    public Pagos create(@RequestBody Pagos pagos){
        return pagosService.createPago(pagos);
    }

    @DeleteMapping("/borrar/{idpagos}")
    public void delete(@PathVariable int idpagos){
        pagosService.deletePago(idpagos);
    }

}
