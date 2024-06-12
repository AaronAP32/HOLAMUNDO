package clv.project.com.springtest.Service;



import clv.project.com.springtest.Model.Pagos;

import java.util.List;
import java.util.Optional;
public interface PagosService {

    List<Pagos> readAllPagos();
    Optional<Pagos> readById(int idpagos);
    List<Pagos> findByCodigopago(int codigopago);
    Pagos createPago(Pagos pago);
    Pagos updatePago(int idpagos, Pagos pago);
    void deletePago(int idpagos);
}
