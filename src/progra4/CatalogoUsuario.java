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
public class CatalogoUsuario {
    /*Declaración de variables*/
    private int idUsuario;//Id del usuario tipo entero
    private int codigoUsuario;//Codigo del usuario tipo entero
    private String usuario;//Usuario tipo cadena de carecteres
    private String passwordUser;//Contraseña del usuario tipo cararter
    Conexiondb conect = new Conexiondb();
    
    //metodo constructor
    CatalogoUsuario(){}
   
    /*Get y Set de los datos*/
    //metodo que devuelve un entero del id del usuario
    public int getIdUsuario() {
        return idUsuario;
    }//fin metodo getIdUsuario
    //metodo void que almacena en entero el id del usuario
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }//fin metodo setIdUsuario
    //metodo que devuelve un entero del codigo del usuario
    public int getCodigoUsuario() {
        return codigoUsuario;
    }//fin metodo getCodigoUsuario
    //metodo void que almacena en entero el codigo del usuario
    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }//fin metodo setCodigoUsuario
    //metodo que devuelve un caracter del usuario
    public String getUsuario() {
        return usuario;
    }//fin metodo getUsuario
    //metodo void que almacena en caracter el usuario
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }//fin metodo setUsuario
    //metodo que devuelve un caracter de la contraseña del usuario
    public String getPasswordUser() {
        return passwordUser;
    }//fin metodo getPasswordUser
    //metodo void que almacena en caracter la contraseña del usuario
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }//fin metodo setPasswordUser
    
   /*metodo para agregar un doctor*/
     public boolean agregar(){
        boolean agregado = false;
        idUsuario= 0;
        codigoUsuario= 0;
        usuario= "";
        passwordUser = "";
        String tabla = "Usuario";
        String datos = "idUsuario->'"+idUsuario+"', codigoUsuario->'"+codigoUsuario+"',"
                + "usuario->'"+usuario+", passwordUser->'"+passwordUser+"'";
        if(conect.agregar(tabla,datos)){
            agregado = true;
        }//fin del if
        return agregado;
    }//fin metodo agregar
    /*metodo para editar algun dato de un doctor*/
    public boolean editar(){
        boolean editado = false;
        passwordUser = "";
        String tabla = "Usuarios";
        String datos = "password->'"+passwordUser+"'";
        String condicion = "idUsuario->5";
        if(conect.editar(tabla,datos,condicion)){
            editado = true;
        }//fin del if
        return editado;
    }//fin metodo editar   
    /*metodo para eliminar un doctor*/
    public boolean eliminar(){
        boolean eliminado = false;
        String tabla = "Usuarios";
        String condicion = "idUsuario->3";
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;
        }//fin del if
        return eliminado;
    }//fin metodo eliminar   
    /*metodo para imprimir todos los doctores*/
    public void imprimir(){
        String tabla = "Usuarios";
        String datos = "*";
        String condicion = null;
        String [][] resultado = conect.imprimir(tabla,datos,condicion);
        for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
              System.out.println (resultado[x][y]);
            }//fin for interno
        }//fin for
    }//fin metodo imprimir

}//fin clase CatalogoUsuario
