package controlador;

import modelo.Persona;
import modelo.PersonaDAO;
import vista.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona();
    vista vista = new vista();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(vista v) {
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnDelete.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnListar) {
            limpiarTabla();
            listar(vista.tabla);
            nuevo();
        }
        if (e.getSource() == vista.btnAgregar) {
            add();
            listar(vista.tabla);
            nuevo();
        }
        if (e.getSource() == vista.btnEditar) {
            int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debee Seleccionar Una fila..!!");
            } else {
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nombre = (String) vista.tabla.getValueAt(fila, 1);
                String apellido = (String) vista.tabla.getValueAt(fila, 2);
                String tipoDocumento = (String) vista.tabla.getValueAt(fila, 3);
                String numeroDocumento = (String) vista.tabla.getValueAt(fila, 4);
                String telefono = (String) vista.tabla.getValueAt(fila, 5);
                String correo = (String) vista.tabla.getValueAt(fila, 6);
                String rol = (String) vista.tabla.getValueAt(fila, 7);
                String profesion = (String) vista.tabla.getValueAt(fila, 8);
                vista.txtId.setText("" + id);
                vista.txtNombre.setText(nombre);
                vista.txtApellido.setText(apellido);
                vista.cbxTipoDocumento.setSelectedItem(tipoDocumento);
                vista.txtnumeroIdentidad.setText(numeroDocumento);
                vista.txtTelefono.setText(telefono);
                vista.txtCorreo.setText(correo);
                vista.cbxRol.setSelectedItem(rol);
                vista.txtProfesion.setText(profesion);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            Actualizar();
            listar(vista.tabla);
            nuevo();

        }
        if (e.getSource() == vista.btnDelete) {
            delete();
            listar(vista.tabla);
            nuevo();
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevo();
        }

    }

    void nuevo() {
        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtTelefono.setText("");
        vista.txtCorreo.setText("");
        vista.txtNombre.requestFocus();
    }

    public void delete() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe Seleccionar una Fila...!!!");
        } else {
            int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            dao.Delete(id);
            System.out.println("El Reusltaod es" + id);
            JOptionPane.showMessageDialog(vista, "Usuario Eliminado...!!!");
        }
        limpiarTabla();
    }

    public void add() {
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        String correo = vista.txtCorreo.getText();
        String telefono = vista.txtTelefono.getText();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setCorreo(correo);
        p.setTelefono(telefono);
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario Agregado con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
    }

    public void Actualizar() {
        if (vista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            int id = Integer.parseInt(vista.txtId.getText());
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            String tipoDocumento = vista.cbxTipoDocumento.getSelectedItem()+"";
            String numeroDocumento = vista.txtnumeroIdentidad.getText();
            String telefono = vista.txtTelefono.getText();
            String correo = vista.txtCorreo.getText();
            String profesion = vista.txtProfesion.getText();
            String rol = vista.cbxRol.getSelectedItem()+"";
            p.setId(id);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setTipoDocumento(tipoDocumento);
            p.setNumeroIdentidad(numeroDocumento);
            p.setCorreo(correo);
            p.setTelefono(telefono);
            p.setProfesion(profesion);
            p.setRol(rol);
            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Usuario Actualizado con Exito.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }
        }
        limpiarTabla();
    }

    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Persona> lista = dao.listar();
        Object[] objeto = new Object[9];
        System.out.println(lista.size());
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getApellido();
            objeto[3] = lista.get(i).getTipoDocumento();
            objeto[4] = lista.get(i).getNumeroIdentidad();
            objeto[5] = lista.get(i).getTelefono();
            objeto[6] = lista.get(i).getCorreo();
            objeto[7] = lista.get(i).getRol();
            objeto[8] = lista.get(i).getProfesion();
            
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
