package pe.edu.uandina.demo2Spring.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.uandina.demo2Spring.modelo.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
