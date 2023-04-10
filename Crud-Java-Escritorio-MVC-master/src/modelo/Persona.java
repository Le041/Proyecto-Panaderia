package modelo;

public class Persona {

    int id;
    String nombre;
    String apellido;
    String tipoDocumento;
    String numeroIdentidad;
    String profesion;
    String telefono;
    String correo;
    String rol;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String tipoDocumento, String numeroIdentidad, String profesion, String telefono, String correo, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroIdentidad = numeroIdentidad;
        this.profesion = profesion;
        this.telefono = telefono;
        this.correo = correo;
        this.rol = rol;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
