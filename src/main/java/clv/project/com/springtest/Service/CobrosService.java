package clv.project.com.springtest.Service;



import clv.project.com.springtest.Model.Cobros;

import java.util.List;
import java.util.Optional;
public interface CobrosService {

    List<Cobros> readAllCobros();
    Optional<Cobros> readCobrosById(int idcobros);
    List<Cobros> findByCodigopago(int codigopago);
    Cobros createCobros(Cobros cobros);
    Cobros updateCobros(int idcobros, Cobros cobros);
    void deleteCobros(int idcobros);
}
