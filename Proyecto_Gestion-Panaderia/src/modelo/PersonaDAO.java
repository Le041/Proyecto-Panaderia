package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Persona p = new Persona();

    public List listar() {
        List<Persona> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from persona");
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setTipoDocumento(rs.getString(4));
                p.setNumeroIdentidad(rs.getString(5));
                p.setProfesion(rs.getString(6));
                p.setTelefono(rs.getString(7));
                p.setCorreo(rs.getString(8));
                p.setRol(rs.getString(9));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    public int agregar(Persona per) {
        int r = 0;
        String sql = "insert into persona(Nombres,Apellidos,tipo_documento,numero_documento,profesion,telefono,Correo,rol)values(?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getTipoDocumento());
            ps.setString(4, per.getNumeroIdentidad());
            ps.setString(5, per.getProfesion());
            ps.setString(6, per.getTelefono());
            ps.setString(7, per.getCorreo());
            ps.setString(8, per.getRol());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;
    }

    public int Actualizar(Persona per) {
        int r = 0;
        String sql = "update persona set Nombres=?,Apellidos=?,tipo_documento=?,numero_documento=?,profesion=?,Telefono=?,Correo=?,rol=? where Id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getTipoDocumento());
            ps.setString(4, per.getNumeroIdentidad());
            ps.setString(5, per.getProfesion());
            ps.setString(6, per.getTelefono());
            ps.setString(7, per.getCorreo());
            ps.setString(8, per.getRol());
            ps.setString(9, per.getId()+"");
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;
    }

    public int Delete(int id) {
        int r = 0;
        String sql = "delete from persona where Id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
