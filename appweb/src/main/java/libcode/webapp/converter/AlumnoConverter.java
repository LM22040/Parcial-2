package libcode.webapp.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import libcode.webapp.entidades.Alumno;


@FacesConverter("alumnoConverter")
public class AlumnoConverter implements Converter {

    private AlumnoService alumnoService; // Suponiendo que tienes un servicio para manejar las operaciones con alumnos

    // Método setter para inyectar AlumnoService
    public void setAlumnoService(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            // Intenta convertir el ID del alumno a un objeto Alumno
            try {
                Integer id = Integer.valueOf(value);
                return alumnoService.buscarAlumnoPorId(id); // Implementa este método en tu servicio de alumno
            } catch (NumberFormatException e) {
                // Manejo de excepciones si el valor no es un número
                // Puedes lanzar un FacesMessage para notificar al usuario sobre el error si lo deseas
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Alumno) {
            // Convierte el objeto Alumno a su ID como String
            Alumno alumno = (Alumno) value;
            return String.valueOf(alumno.getId());
        }
        return null;
    }
}
