package pe.edu.uandina.demo2Spring.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Column(name = "createdat")
    private LocalDateTime createdAt; // Para manejo de fechas
    @Column(name = "salarioBase", scale = 2, precision = 7)
    private BigDecimal salarioBase; //Para manejo de salarios por ejemplo
    @OneToMany(mappedBy = "tieneRol")
    @JsonManagedReference
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(String nombre, LocalDateTime createdAt, BigDecimal salarioBase, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.createdAt = createdAt;
        this.salarioBase = salarioBase;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }
}

