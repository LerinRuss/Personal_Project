package personal.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import personal.security.controller.dto.SignUpRequest;
import personal.security.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signup")
    public void signUp(@Valid @RequestBody SignUpRequest req) {
        // TODO email is unique
        // TODO password is good
        authService.signUp(req.getEmail(), req.getPassword());
    }
}
