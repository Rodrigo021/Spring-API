package dio.spring_api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dio.spring_api.model.Usuario;
import dio.spring_api.repository.UserRepository;


@RestController
public class WelcomeController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/wel")
    public String welcome(){
        return "welcome spring api";
    }

    @GetMapping("/user/{id}")
    public Optional<Usuario> getUser(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    @GetMapping("/userall")
    public List<Usuario> getUser(){
        return userRepository.findAll();
    }

    @PostMapping("/userborn")
    public void addUsuario(@RequestBody Usuario user){
        userRepository.save(user);
    }

    @PutMapping("/attuser/{id}")
    public void updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario user){
        Optional<Usuario> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            Usuario usuario = userOptional.get();
            usuario.setNome(user.getNome());
            usuario.setEmail(user.getEmail());
            userRepository.save(usuario);
        }
    }

    @DeleteMapping("/killuser/{id}")
    public void deleteUsuario(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

}
