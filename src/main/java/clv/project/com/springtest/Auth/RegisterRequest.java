package clv.project.com.springtest.Auth;


import clv.project.com.springtest.Model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
   private String username;
   private String password;
   private String codigodepagoL;
   private Rol rol;

    public RegisterRequest(String user10, String password, String number, String user) {
    }
}
