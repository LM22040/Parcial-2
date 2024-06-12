package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Materia; 
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class IndexController {

    private List<Alumno> alumnoList = new ArrayList<>();
    private List<Materia> materiaList = new ArrayList<>(); // Lista de Materias
    private Alumno alumno = new Alumno();
    private Materia materia = new Materia(); // Instancia de Materia

    @EJB
    private DataService servicio;

    @EJB
    private DataService servicioMateria; // Servicio para Materia

    @PostConstruct
    public void cargarDatos() {
        cargarAlumnos();
        cargarMaterias(); // Cargar también las materias al iniciar
    }

    public void cargarAlumnos() {
        alumnoList = servicio.getAlumnos();
    }

    public void cargarMaterias() {
        materiaList = servicioMateria.getMaterias();
    }

    public void guardarAlumno() {
        if(alumno.getId()!=null){
            servicio.editAlumno(alumno);
        } else {
            servicio.saveAlumno(alumno);
        }
        alumno = new Alumno();
        cargarAlumnos();
    }

    public void guardarMateria() {
        if(materia.getId() != null) {
            servicioMateria.editMateria(materia);
        } else {
            servicioMateria.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }

    public void llenarFormEditar(Alumno alumno) {
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
    }

    public void llenarFormEditarMateria(Materia materia) {
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigoMateria(materia.getCodigoMateria());
    }

    public void eliminarAlumno(Alumno alumno){
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }

    public void eliminarMateria(Materia materia){
        servicioMateria.deleteMateria(materia);
        cargarMaterias();
    }

    // Getters y Setters

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
