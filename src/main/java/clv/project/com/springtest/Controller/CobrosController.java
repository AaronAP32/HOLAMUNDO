package clv.project.com.springtest.Controller;


import clv.project.com.springtest.Model.Cobros;
import clv.project.com.springtest.Service.CobrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cobros")
@CrossOrigin({"*"})
public class CobrosController {

    @Autowired
    CobrosService cobrosService;

    @GetMapping("/listar")
    public List<Cobros> getAllCobros() {
        return cobrosService.readAllCobros();
    }

    @GetMapping("/buscar/{idcobros}")
    public Optional<Cobros> getCobrosById(@PathVariable int idcobros) {
        return cobrosService.readCobrosById(idcobros);
    }

    @GetMapping("/buscar/cod/{codigopago}")
    public List<Cobros> getCobrosByCodigo(@PathVariable int codigopago) {
        return cobrosService.findByCodigopago(codigopago);
    }

    @GetMapping("/crear")
    public Cobros create(@RequestBody Cobros cobros) {
        return cobrosService.createCobros(cobros);
    }

    @DeleteMapping("/borrar/{idcobros}")
    public void delete(@PathVariable int idcobros) {
        cobrosService.deleteCobros(idcobros);
    }
}
