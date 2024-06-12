package clv.project.com.springtest.ServiceImp;


import clv.project.com.springtest.Model.Pagos;
import clv.project.com.springtest.Repository.PagosRepository;
import clv.project.com.springtest.Service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagosSrvImp implements PagosService {

    @Autowired
    PagosRepository pa;


    @Override
    public List<Pagos> readAllPagos() {
        return pa.findAll();
    }

    @Override
    public Optional<Pagos> readById(int idpagos) {
        return pa.findById(idpagos);
    }

    @Override
    public List<Pagos> findByCodigopago(int codigopago) {
        return pa.findByCodigopago(codigopago);
    }

    @Override
    public Pagos createPago(Pagos pago) {
        return pa.save(pago);
    }

    @Override
    public Pagos updatePago(int idpagos, Pagos pago) {
        return null;
    }

    @Override
    public void deletePago(int idpagos) {
        pa.deleteById(idpagos);

    }
}
