package vane.fm.delitos.modules.users.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;// el netbeans lo pone cuando ve que se implementa serializable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Este espacio no debe estar vacio")
    @Email(message = "El email proporcionado no es Valido, por favor verifiquelo e intente nuevamente. email@email.com ")
    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 80)
    private String password;

    @NotEmpty(message = "Es obligatorio proporcionar un nombre valido")
    @Column(nullable = false, length = 20)
    private String nombre;

    @NotEmpty(message = "Es obligatorio proporcionar un Apellido valido")
    @Size(min = 3, max = 20, message = "verifique caracteres, minimo:3 Maximo:20")
    @Column(nullable = true, length = 20)
    private String apellido;

    @JsonProperty("fecha_nacimiento")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private Boolean enabled;

    @Column(name = "red_social")
    private Boolean redSocial;

    private String image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_usuarios",
            joinColumns = {@JoinColumn(name = "usuarios_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private List<Role> roles;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getRedSocial() {
        return redSocial;
    }

    public void setRedSocial(Boolean redSocial) {
        this.redSocial = redSocial;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
