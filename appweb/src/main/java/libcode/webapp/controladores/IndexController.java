import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class IndexController {

    private static final Logger LOGGER = Logger.getLogger(IndexController.class.getName());

    private List<Alumno> alumnoList = new ArrayList<>();
    private List<Materia> materiaList = new ArrayList<>();
    private Alumno alumno = new Alumno();
    private Materia materia = new Materia();

    @EJB
    private DataService servicio;

    @PostConstruct
    public void cargarDatos() {
        cargarAlumnos();
        cargarMaterias();
    }

    public void cargarAlumnos() {
        alumnoList = servicio.getAlumnos();
    }

    public void cargarMaterias() {
        materiaList = servicio.getMaterias();
    }

    public void guardarAlumno() {
        LOGGER.info("Método guardarAlumno llamado");
        if (alumno.getId() != null) {
            servicio.editAlumno(alumno);
        } else {
            servicio.saveAlumno(alumno);
        }
        alumno = new Alumno();
        cargarAlumnos();
    }

    public void llenarFormEditar(Alumno alumno) {
        this.alumno = alumno;
    }

    public void eliminarAlumno(Alumno alumno) {
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }

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
