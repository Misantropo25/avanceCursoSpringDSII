package pe.edu.uandina.demo2Spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.uandina.demo2Spring.modelo.Rol;
import pe.edu.uandina.demo2Spring.modelo.service.IRolService;

import java.util.List;

@RestController //Con esto indicamos que la clase sera un controlador
@RequestMapping("/api")
public class RolRestController {
    @Autowired
    private IRolService rolService;

    @GetMapping("/roles")
    public List<Rol> listar(){
        return rolService.findAll();
    }

    @PostMapping("/roles")
    private String mensaje(){
        return "Desde peticion POST";
    }
}
