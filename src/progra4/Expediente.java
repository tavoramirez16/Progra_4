package progra4;

import progra4.ui.GuiExpediente;

public abstract class Expediente extends GuiExpediente {

    //Variables Expediente
    java.util.Date date = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

    private int idExpediente;
    private int idPaciente;
    private String antecedentes;
    private String tratamiento;
    private String alergias;
    private String fechaExpediente;
    private String comentarios;
    private String otros;

    Conexiondb conect = new Conexiondb();

    public Expediente( ) {
        
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getFechaExpediente() {
        return fechaExpediente;
    }

    public void setFechaExpediente(String fechaExpediente) {
        this.fechaExpediente = fechaExpediente;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public boolean agregar() {
        boolean agregado = false;
        idExpediente = 1234;
        idPaciente = 12345;
        fechaExpediente = sdf.format(date);
        antecedentes = "Alergias";
        tratamiento = "Talerdin";
        alergias = "Frio";
        otros = "Nada";
        String tabla = "Expediente";
        String datos = "idExpediente->'" + idExpediente
                + "', idPaciente->'" + idPaciente + "',"
                + "Fecha->'" + fechaExpediente
                + "Antecedentes->'" + antecedentes
                + "Tratamiento->'" + tratamiento
                + "Alergias->'" + alergias
                + "Otros->'" + otros;
        if (conect.agregar(tabla, datos)) {
            agregado = true;
        }

        return agregado;
    }

    public boolean editar() {
        boolean editado = false;
        idExpediente = 1234;
        idPaciente = 12345;
        fechaExpediente = sdf.format(date);
        antecedentes = "Gripe";
        tratamiento = "Talerdin";
        alergias = "Sol";
        otros = "Nada";
        String tabla = "Expediente";
        String datos = "idExpediente->'" + idExpediente
                + "', idPaciente->'" + idPaciente + "',"
                + "Fecha->'" + fechaExpediente
                + "Antecedentes->'" + antecedentes
                + "Tratamiento->'" + tratamiento
                + "Alergias->'" + alergias
                + "Otros->'" + otros;
        String condicion = "idPaciente->12345";
        if (conect.editar(tabla, datos, condicion)) {
            editado = true;
        }
        return editado;
    }

    public boolean eliminar() {
        boolean eliminado = false;
        String tabla = "Expediente";
        String condicion = "idPaciente->12345";
        if (conect.eliminar(tabla, condicion)) {
            eliminado = true;
        }
        return eliminado;
    }

    public void consultar() {
        String tabla = "Expediente";
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
