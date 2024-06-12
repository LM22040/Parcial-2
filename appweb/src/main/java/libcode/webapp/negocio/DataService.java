package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Materia;

@Stateless
public class DataService {

    private static final Logger LOGGER = Logger.getLogger(DataService.class.getName());

    @PersistenceContext
    private EntityManager em;

    public List<Alumno> getAlumnos() {
        return em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
    }

    public List<Materia> getMaterias() {
        return em.createQuery("SELECT m FROM Materia m", Materia.class).getResultList();
    }

    public void saveAlumno(Alumno alumno) {
        LOGGER.info("Persistiendo alumno: " + alumno);
        em.persist(alumno);
    }

    public void editAlumno(Alumno alumno) {
        LOGGER.info("Editando alumno: " + alumno);
        em.merge(alumno);
    }

    public void deleteAlumno(Alumno alumno) {
        Alumno toRemove = em.merge(alumno);
        em.remove(toRemove);
    }

    public void saveMateria(Materia materia) {
        em.persist(materia);
    }

    public void editMateria(Materia materia) {
        em.merge(materia);
    }

    public void deleteMateria(Materia materia) {
        Materia toRemove = em.merge(materia);
        em.remove(toRemove);
    }
}
