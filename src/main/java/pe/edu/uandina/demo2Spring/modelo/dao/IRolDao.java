package pe.edu.uandina.demo2Spring.modelo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pe.edu.uandina.demo2Spring.modelo.Rol;

public interface IRolDao extends CrudRepository<Rol, Long> {
    //Extendemos a CRUDREPOSITORY con Ctrl b podemos ver lo que este nos ofrece
}


