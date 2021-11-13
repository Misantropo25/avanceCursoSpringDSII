package pe.edu.uandina.demo2Spring.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "tieneRol")
    @JsonManagedReference
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(String nombre, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.usuarios = usuarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        if (this.usuarios == null){
            this.usuarios = new ArrayList<>();
        }
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

