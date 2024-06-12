package libcode.webapp.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import libcode.webapp.entidades.Materia;

@FacesConverter("materiaConverter")
public class MateriaConverter implements Converter<Materia> {

    @Override
    public Materia getAsObject(FacesContext context, UIComponent component, String value) {
        // Implementa la lógica para convertir el valor de cadena (ID de materia) a un objeto Materia
        // Por ejemplo, busca la materia en la base de datos por su ID y devuelve el objeto Materia encontrado
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Materia value) {
        // Implementa la lógica para convertir el objeto Materia a su representación de cadena (por ejemplo, el ID)
        // Por ejemplo, si value es un objeto Materia, devuelve su ID como una cadena
        return null;
    }
}
