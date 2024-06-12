package clv.project.com.springtest.Repository;


import clv.project.com.springtest.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
    List<Clientes> findByCodigopago(int codigopago);
}
