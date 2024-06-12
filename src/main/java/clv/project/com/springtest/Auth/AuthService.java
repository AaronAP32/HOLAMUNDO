package clv.project.com.springtest.Auth;


import clv.project.com.springtest.Jwt.JwtService;
import clv.project.com.springtest.Model.Rol;
import clv.project.com.springtest.Model.User;
import clv.project.com.springtest.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user=userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        String rol = ((User) user).getRol().name();
        String codigodepagoL = ((User) user).getCodigodepagoL();
        String usuario = ((User) user).getUsername();

        return AuthResponse.builder()
                .token(token)
                .rol(rol)
                .codigodepagoL(codigodepagoL)
                .Usuario(usuario)
                .build();
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode( registerRequest.getPassword()))
                .codigodepagoL(registerRequest.getCodigodepagoL())
                .rol(registerRequest.getRol())
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
