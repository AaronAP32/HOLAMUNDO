package clv.project.com.springtest.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cobros")
public class Cobros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcobros;
    private int codigopago;
    private String recibo;
    private String descripcionrecibo;
    private String pagado;
    private String Fechapago;
    private String Formapago;
}
