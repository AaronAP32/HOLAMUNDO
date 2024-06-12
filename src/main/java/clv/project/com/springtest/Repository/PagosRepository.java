package clv.project.com.springtest.Repository;


import clv.project.com.springtest.Model.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, Integer> {
    List<Pagos> findByCodigopago(int codigopago);
}
