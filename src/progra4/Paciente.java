
package progra4;

import progra4.ui.GuiPaciente;

public abstract class Paciente extends GuiPaciente{
    
    java.util.Date date = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

    private int idPaciente;
    private String nombre;
    private String telefono;
    private String correo;
    private String fechaNacimiento;
    private String tipoSangre;

    Conexiondb conect = new Conexiondb();

    public Paciente() {
        
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public boolean agregar() {
        boolean agregado = false;
        idPaciente = 12345;
        nombre = "Pedro";
        telefono = "8888-8888";
        correo = "abcd@gmail.com";
        fechaNacimiento = sdf.format(date);
        tipoSangre = "O+";
        String tabla = "Pacientes";
        String datos = "idPaciente->'" + idPaciente
                + "', Nombre->'" + nombre + "',"
                + "Telefono->'" + telefono
                + "Correo->'" + correo
                + "FechaNacimiento->'" + fechaNacimiento
                + "TipoSangre->'" + tipoSangre;
        if (conect.agregar(tabla, datos)) {
            agregado = true;
        }

        return agregado;
    }

    public boolean editar() {
        boolean editado = false;
        idPaciente = 12345;
        nombre = "Pedro";
        telefono = "8888-8888";
        correo = "abcd@gmail.com";
        fechaNacimiento = sdf.format(date);
        tipoSangre = "O+";
        String tabla = "Pacientes";
        String datos = "idPaciente->'" + idPaciente
                + "', Nombre->'" + nombre + "',"
                + "Telefono->'" + telefono
                + "Correo->'" + correo
                + "FechaNacimiento->'" + fechaNacimiento
                + "TipoSangre->'" + tipoSangre;
        String condicion = "idPaciente->12345";
        if (conect.editar(tabla, datos, condicion)) {
            editado = true;
        }
        return editado;
    }

    public boolean eliminar() {
        boolean eliminado = false;
        String tabla = "Pacientes";
        String condicion = "idPaciente->12345";
        if (conect.eliminar(tabla, condicion)) {
            eliminado = true;
        }
        return eliminado;
    }

    public void consultar() {
        String tabla = "Pacientes";
        String datos = "*";
        String condicion = null;
        String[][] resultado = conect.imprimir(tabla, datos, condicion);
        for (int x = 0; x < resultado.length; x++) {
            for (int y = 0; y < resultado[x].length; y++) {
                System.out.println(resultado[x][y]);
            }
        }
    }
    

}
