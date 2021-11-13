package pe.edu.uandina.demo2Spring.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name="tieneRol", referencedColumnName = "id")
    @JsonBackReference
    private Rol tieneRol;


    public Usuario() {
    }

    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getTieneRol() {
        return tieneRol;
    }

    public void setTieneRol(Rol tieneRol) {
        this.tieneRol = tieneRol;
    }
}
