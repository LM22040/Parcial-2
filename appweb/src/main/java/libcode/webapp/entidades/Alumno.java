package libcode.webapp.entidades;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "carnet", nullable = false)
    private String carnet;

    // Constructor por defecto
    public Alumno() {
        // Constructor vacío por defecto
    }

    // Constructor con todos los campos
    public Alumno(Long id, String nombre, String carnet) {
        this.id = id;
        this.nombre = nombre;
        this.carnet = carnet;
    }

    // Constructor con solo ID
    public Alumno(Long id) {
        this.id = id;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    // Equals y HashCode basados en el ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return Objects.equals(id, alumno.id);
    }

    // Método toString()
    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre='" + nombre + '\'' + ", carnet='" + carnet + '\'' + '}';
    }
}
