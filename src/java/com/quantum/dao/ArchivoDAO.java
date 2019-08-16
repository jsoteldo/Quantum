package com.quantum.dao;

import com.quantum.modelos.Archivo;
import com.quantum.modelos.Mensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QUANTUM
 */
public class ArchivoDAO extends DAO {

    public Mensaje registrar(Archivo archivo) throws Exception {
        Mensaje validosesion;
        try {
            this.Conectar();
            PreparedStatement declaracion = this.getConexion().prepareStatement("INSERT INTO ARCHIVO (NAME, DIR, FECHA, PROCESADO) VALUES (?,?,?,?)");
            declaracion.setString(1, archivo.getName());
            declaracion.setString(2, archivo.getDir());
            declaracion.setString(3, archivo.getFecha());
            declaracion.setString(4, archivo.getProcesado());
            declaracion.executeUpdate();
            validosesion = new Mensaje("", "Registrado Exitosamente.", "mdi-checkbox-marked-circle-outline", "success");
            return validosesion;
        } catch (Exception e) {
            validosesion = new Mensaje("", e.getMessage(), "mdi-close-circle-outline", "danger");
            return validosesion;
        } finally {
            this.Cancelar();
        }

    }

    

    public Archivo consultaanuncio(String idanuncio) throws Exception {
        Archivo anuncioconsultado = new Archivo();;
        ResultSet resultado;
        try {
            this.Conectar();
            PreparedStatement declaracion = this.getConexion().prepareStatement(""
                    + "SELECT NAME, DIR, FECHA, PROCESADO FROM ARCHIVO "
                    + "WHERE FECHA = ?");
            declaracion.setString(1, idanuncio);

            resultado = declaracion.executeQuery();
            while (resultado.next()) {
                anuncioconsultado.setName(resultado.getString("NAME"));
                anuncioconsultado.setDir(resultado.getString("DIR"));
                anuncioconsultado.setFecha(resultado.getString("FECHA"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cancelar();
        }
        return anuncioconsultado;
    }

    public void borrar(Archivo archivo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement declaracion = this.getConexion().prepareStatement(""
                    + "DELETE FROM ARCHIVO WHERE NAME = ?");
            declaracion.setString(1, archivo.getName());
            declaracion.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            this.Cancelar();
        }

    }

    public Mensaje procesar() throws Exception {
        Mensaje validosesion;

        try {
            this.Conectar();
            PreparedStatement declaracion = this.getConexion().prepareStatement(""
                    + "UPDATE ARCHIVO set PROCESADO = ? WHERE FECHA in (SELECT MAX(STR_TO_DATE(FECHA,'%Y-%m-%d %H:%i:%s')) FROM ARCHIVO )");

            declaracion.setString(1, "true");
            declaracion.executeUpdate();
            validosesion = new Mensaje("", "Actualizado Exitosamente.", "mdi-checkbox-marked-circle-outline", "success");
            return validosesion;
        } catch (Exception e) {
            validosesion = new Mensaje("", e.getMessage(), "mdi-close-circle-outline", "danger");
            return validosesion;
        } finally {
            this.Cancelar();
        }
    }

    
}
