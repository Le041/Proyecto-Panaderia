
package modelo;


import controlador.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
    ConexionDB conexion = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        String sql = "select * from productos";
        List<Producto> lista = new ArrayList<>();
        
        try {
            con = conexion.ConectarBaseDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setInventario(rs.getInt(4));
                lista.add(producto);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: "+e);
        }
        return lista;
    }

    public void agregar(Producto producto) {
        String sql = "insert into productos(nombre, precio, inventario) values(?, ?, ?)";
        try {
            con = conexion.ConectarBaseDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1,producto.getNombre());
            ps.setDouble(2,producto.getPrecio());
            ps.setInt(3,producto.getInventario());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en agregar: "+e);
        }
    }

    
}
