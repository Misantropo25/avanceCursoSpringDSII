package pe.edu.uandina.demo2Spring.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.uandina.demo2Spring.modelo.Rol;
import pe.edu.uandina.demo2Spring.modelo.dao.IRolDao;

import java.util.List;

public interface IRolService {
   //Su objetivo es la exposicion de ciertos metodos que ya estan implementados en el DAO y si no estan, se implementan
   public List<Rol> findAll();

}
