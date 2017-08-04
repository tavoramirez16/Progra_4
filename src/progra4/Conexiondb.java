/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jmanu
 */
public class Conexiondb {
Statement s;
    Connection connection;
    String url = "jdbc:mysql://progressivehostcr.com:3306/progress_progra4";
    String user = "progress_progra4";
    String pass = "2iQcq^9q#S4m";
    
    public boolean connect(){
        boolean coneccion = false;
        System.out.println("Conectando...");
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            System.out.println("Conectado!!");
            s = connection.createStatement();
            coneccion = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return coneccion;
    }
    
    public boolean agregar(String tabla, String data){
        boolean agregado = false;
        String campos = "";
        String valores = "";
        if(data != null){
            String[] parte1 = data.split(",");
            for (int y=0; y < parte1.length; y++) {
              if( y != 0){
                  campos = campos+" , ";
                  valores = valores+" , ";
              }
              String[] parte2= parte1[y].split("->");
              campos = campos +" "+parte2[0];
              valores = valores +" "+parte2[1];
            }
        }else{
            campos = "";
            valores = "";
        }
        String query = "INSERT INTO "+tabla+" ("+campos+") VALUES ("+valores+")";
        System.out.println(query);
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            System.out.println("ingresando!!");
            s = connection.createStatement();
            s.executeUpdate(query);
            agregado = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return agregado;
    }
    public boolean editar(String tabla, String data, String condicion){
        boolean editar = false;
        String datos = "";
        if(data != null){
            String[] parte1 = data.split(",");
            for (int y=0; y < parte1.length; y++) {
              if( y != 0){
                  datos = datos+" , ";
              }
              String[] parte2= parte1[y].split("->");
              datos = datos +" "+parte2[0]+" = "+parte2[1];
            }
        }else{
            datos = "";
        }
        String condiciondata = "";
        if(condicion != null){
            String[] parte1 = condicion.split(",");
            for (int y=0; y < parte1.length; y++) {
              if( y != 0){
                  condiciondata = condiciondata+" , ";
              }
              String[] parte2= parte1[y].split("->");
              condiciondata = condiciondata +" "+parte2[0]+" = "+parte2[1];
            }
            condicion = " where "+condiciondata; 
        }else{
            condicion = "";
        }
        String query = "UPDATE "+tabla+" SET "+datos+""+condicion;
        System.out.println(query);
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            System.out.println("editando!!");
            s = connection.createStatement();
            s.executeUpdate(query);
            editar = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return editar;
    }
    
    public boolean eliminar(String tabla, String condicion){
        boolean eliminar = false;
        String condiciondata = "";
        if(condicion != null){
            String[] parte1 = condicion.split(",");
            for (int y=0; y < parte1.length; y++) {
              if( y != 0){
                  condiciondata = condiciondata+" , ";
              }
              String[] parte2= parte1[y].split("->");
              condiciondata = condiciondata +" "+parte2[0]+" = "+parte2[1];
            }
            condicion = " where "+condiciondata; 
        }else{
            condicion = "";
        }
        String query = "DELETE FROM "+tabla+""+condicion;
        System.out.println(query);
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            System.out.println("elimando!!");
            s = connection.createStatement();
            s.executeUpdate(query);
            eliminar = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return eliminar;
    }
    
    public String [][] imprimir(String tabla, String datos, String condicion){
        ResultSet r = null;
        String [][] resultado =  new String[0][0];
        String condiciondata = "";
        if(condicion != null){
            String[] parte1 = condicion.split(",");
            for (int y=0; y < parte1.length; y++) {
              if( y != 0){
                  condiciondata = condiciondata+" , ";
              }
              String[] parte2= parte1[y].split("->");
              condiciondata = condiciondata +" "+parte2[0]+" = "+parte2[1];
            }
            condicion = " where "+condiciondata; 
        }else{
            condicion = "";
        }
        String query = "SELECT "+datos+" FROM "+tabla+""+condicion;
        System.out.println(query);
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            System.out.println("imprimiendo!!");
            s = connection.createStatement();
            r = s.executeQuery(query); 
            ResultSetMetaData rs = r.getMetaData();
            int columnsNumber = rs.getColumnCount();
            if(!r.next())
            {
                System.out.println("NO TIENE DATOS");
            }else{
                int j = 1;
                while(r.next())
                {
                   j++;
                }

                System.out.println(j+"/"+columnsNumber);
                resultado =  new String[j][columnsNumber];
                r = s.executeQuery(query); 
                for(int h=0; h < j; h++)
                {
                   r.next(); 
                   int k = 0;
                   for(int i=1; i <= columnsNumber; i++){
                       resultado[h][k] = r.getString(i);
                       k++;
                   }
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
}
