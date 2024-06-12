package clv.project.com.springtest.Model;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "Cliente")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcliente;
    private int codigopago;
    private String asesor;
    private String mzlts;
    private String captacion;
    private String apellidopaterno;
    private String apellidomaterno;
    private String nombres;
    private String doc;
    private String numero;
    private String direccion;
    private String distrito;
    private String celular;
    private String email;
    private int m2;
    private String ubicacion;
    private String inicipago;
    private String precioventa;
    private int inicial;
    private int saldo;
    private int coutas;
    private int coutamensual;
    private String comentario;

    public void setNombre(String nuevoNombre) {
    }

    public String getNombre() {
        return "";
    }
}
