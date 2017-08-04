/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra4;
/**
 *
 * @author yoorda
 */
public class Doctor {
    /*Declaración de variables*/
    private int idDoctor;//Identificación entera del doctor
    private int idEspecialidad;//Id entero de la especicalidad del doctor
    private String nombre;//Nombre del doctor
    private String telefono;//Número de telefono del doctor
    private String correo;//Correo electronico del doctor
    Conexiondb conect = new Conexiondb();
    
    //metodo constructor
    Doctor(){}

    /*Get y Set de los datos*/
    //metodo que devuelve entero la identificación del doctorentero
    public int getIdDoctor() {
        return idDoctor;
    }//fin metodo getIdDoctor
    //metodo void que almacena la identificación del doctor
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }//fin metodo setIdDoctor
    //metodo que devuelve en entero la identificación de la especialidad el doctor
    public int getIdEspecialidad() {
        return idEspecialidad;
    }//fin metodo getIdEspecialidad
    //metodo void que almacena la identificación de la especialidad del doctor
    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }//fin metodo setIdEspecialidad
    //metodo que devuelve en caracter el nombre del doctor
    public String getNombre() {
        return nombre;
    }//fin metodo getNombre
    //metodo void que almacena el nombre del doctor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//fin metodo setNombre
    //metodo que devuelve en caracter  el número de telefono del doctor
    public String getTelefono() {
        return telefono;
    }//fin metodo getTelefono
    //metodo void que almacena el telefono del doctor
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }//fin metodo setTelefono
    //metodo que devuelve en caracter el correo del doctor
    public String getCorreo() {
        return correo;
    }//fin metodo getCorreo
    //metodo void que almacena el correo del doctor
    public void setCorreo(String correo) {
        this.correo = correo;
    }//fin metodo setCorreo   
   
    /*metodo para agregar un doctor*/
     public boolean agregar(){
        boolean agregado = false;
        idDoctor= 0;
        idEspecialidad= 0;
        nombre= "";
        telefono= "";
        correo= "";
        String tabla = "Doctores";
        String datos = "idDoctor->'"+idDoctor+"',idEspecialidad->'"+idEspecialidad+"',"
                + "nombre->'"+nombre+"',telefono->'"+telefono+"',correo->'"+correo+"'";
                if(conect.agregar(tabla,datos)){
            agregado = true;
        }//fin del if
        return agregado;
    }//fin metodo agregar
    /*metodo para editar algun dato de un doctor*/
    public boolean editar(){
        boolean editado = false;
        telefono = "";
        String tabla = "Doctores";
        String datos = "telefono->'"+telefono+"'";
        String condicion = "idDoctor->12";
        if(conect.editar(tabla,datos,condicion)){
            editado = true;
        }//fin del if
        return editado;
    }//fin metodo editar   
    /*metodo para eliminar un doctor*/
    public boolean eliminar(){
        boolean eliminado = false;
        String tabla = "Doctores";
        String condicion = "idDoctor->80";
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;
        }//fin del if
        return eliminado;
    }//fin metodo eliminar   
    /*metodo para imprimir todos los doctores*/
    public void imprimir(){
        String tabla = "Doctores";
        String datos = "*";
        String condicion = null;
        String [][] resultado = conect.imprimir(tabla,datos,condicion);
        for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
              System.out.println (resultado[x][y]);
            }//fin for interno
        }//fin for
    }//fin metodo imprimir
}//fin clase Doctor
