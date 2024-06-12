package clv.project.com.springtest.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idpagos;
    private int codigopago;
    private String recibido;
    private String descripcion;
    private String importe;
    private String vencimiento;
    private String Estado;
    private String vencido;
}
