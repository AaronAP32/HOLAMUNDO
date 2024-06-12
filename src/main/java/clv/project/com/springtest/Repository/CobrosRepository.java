package clv.project.com.springtest.Repository;


import clv.project.com.springtest.Model.Cobros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CobrosRepository extends JpaRepository<Cobros, Integer> {
    List<Cobros> findByCodigopago(int codigopago);
}
