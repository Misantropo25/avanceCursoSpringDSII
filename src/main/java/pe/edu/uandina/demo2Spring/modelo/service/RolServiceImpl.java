package pe.edu.uandina.demo2Spring.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uandina.demo2Spring.modelo.Rol;
import pe.edu.uandina.demo2Spring.modelo.dao.IRolDao;

import java.util.List;

//Como esta no extiende a nadie es necesaria la notacion de Service y son administradas por el contexto de ejecucion de Spring
@Service //algo similar a un decorador - la convierte a un servicio desde el punto de vista de spring framework
public class RolServiceImpl implements IRolService { //Debo tener una implementacion del servicio por buenas practicas
    @Autowired //Se usa para poder hacer una referencia, en este caso hacia una interface y me de una instancia en automatico
    private IRolDao rolDao;
    //a travez de este objeto tengo acceso a la base de datos
    @Override //Porque estamos reescribiendo el meto de IRolService
    @Transactional(readOnly = true) //Esta notaion permite establecer un control de una transaccion, una transaccion desde un gestor de base de datos relacional la transaccion corresponde a un espacio de trabajo en el que todas las instrucciones se ejecuten como una sola, cuando la transaccion se completa todos los cambios en bloque son llevados a la base de datos, CRUD repository tiene transacciones por default
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll(); //Este metodo no es null porque autowired nos permite el enlace //esta linea ya es una transaccion
        //En caso de que necesitemos usar mas metodos seria factible usar @Transactional(readOnly = false) para que sea transactional, si se realiza escritura o manipulacion a nivel transaccional es readOnly = False
    }

    @Override
    @Transactional(readOnly = true)
    public Rol findById(Long id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Rol save(Rol rol) {
        return rolDao.save(rol);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        rolDao.deleteById(id);
    }

}
