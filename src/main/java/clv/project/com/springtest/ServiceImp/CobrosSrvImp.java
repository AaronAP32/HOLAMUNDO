package clv.project.com.springtest.ServiceImp;


import clv.project.com.springtest.Model.Cobros;
import clv.project.com.springtest.Repository.CobrosRepository;
import clv.project.com.springtest.Service.CobrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CobrosSrvImp implements CobrosService {

    @Autowired
    private CobrosRepository co;

    @Override
    public List<Cobros> readAllCobros() {
        return co.findAll();
    }

    @Override
    public Optional<Cobros> readCobrosById(int idcobros) {
        return co.findById(idcobros);
    }

    @Override
    public List<Cobros> findByCodigopago(int codigopago) {
        return co.findByCodigopago(codigopago);
    }

    @Override
    public Cobros createCobros(Cobros cobros) {
        return co.save(cobros);
    }

    @Override
    public Cobros updateCobros(int idcobros, Cobros cobros) {
        return null;
    }

    @Override
    public void deleteCobros(int idcobros) {
        co.deleteById(idcobros);

    }
}
