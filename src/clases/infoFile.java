package clases;

public class infoFile
{
    public String Nombre;
    public long Tamaño;
    public String UltModificacion;
    public String Tipo;
    public String Content_id;

    public infoFile(String _Nombre, long _Tamaño, String _UltModificacion, String _Tipo, String _Content_id)
    {
        setNombre(_Nombre);
        setTamaño(_Tamaño);
        setUltModificacion(_UltModificacion);
        setTipo(_Tipo);
        setContent_id(_Content_id);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public long getTamaño() {
        return Tamaño;
    }

    public void setTamaño(long Tamaño) {
        this.Tamaño = Tamaño;
    }

    public String getUltModificacion() {
        return UltModificacion;
    }

    public void setUltModificacion(String ultModificacion) {
        this.UltModificacion = ultModificacion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    } 
    
    public String getContent_id() {
        return Content_id;
    }

    public void setContent_id(String Content_id) {
        this.Content_id = Content_id;
    } 
}
