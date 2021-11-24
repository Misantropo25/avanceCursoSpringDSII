package pe.edu.uandina.demo2Spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.uandina.demo2Spring.modelo.Rol;
import pe.edu.uandina.demo2Spring.modelo.service.IRolService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController //Con esto indicamos que la clase sera un controlador
@RequestMapping("/api")
public class RolRestController {
    @Autowired
    private IRolService rolService;

    @GetMapping("/rol")
    public List<Rol> listar(){
        return rolService.findAll();
    }

    @GetMapping("/rol/{id}")
    public Rol mostrar(@PathVariable Long id){
        return rolService.findById(id);
    }

    @PostMapping("/rol")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol crear(@RequestBody Rol rol){
        rol.setCreatedAt(LocalDateTime.now());
        rol.setSalarioBase(rol.getSalarioBase().setScale(2, RoundingMode.HALF_UP)); //Redondeo de BigDecimal
        return rolService.save(rol);
    }

    @PutMapping("/rol/{id}")  //OJO PARA MODIFICAR NUESTRO PROYECTO
    public Rol actualizar(@RequestBody Rol rol, @PathVariable Long id){
        Rol rolOriginal = rolService.findById(id);
        rolOriginal.setNombre(rol.getNombre());
        return rolService.save(rolOriginal);
    }

    @DeleteMapping("/rol/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        rolService.delete(id);
    }

}
