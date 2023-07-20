package Modelo;

import Vista.Principal_0;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Mdl_Medicinas {
    
    private int idMedicina;
    private String nombreMedicina;
    private double precioMedicina;
    private int cantidadMedicina;	
    private String solucionMedicina;
    private String observacionMedicina;

    public int getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(int idMedicina) {
        this.idMedicina = idMedicina;
    }

    public String getNombreMedicina() {
        return nombreMedicina;
    }

    public void setNombreMedicina(String nombreMedicina) {
        this.nombreMedicina = nombreMedicina;
    }

    public double getPrecioMedicina() {
        return precioMedicina;
    }

    public void setPrecioMedicina(double precioMedicina) {
        this.precioMedicina = precioMedicina;
    }

    public int getCantidadMedicina() {
        return cantidadMedicina;
    }

    public void setCantidadMedicina(int cantidadMedicina) {
        this.cantidadMedicina = cantidadMedicina;
    }

    public String getSolucionMedicina() {
        return solucionMedicina;
    }

    public void setSolucionMedicina(String solucionMedicina) {
        this.solucionMedicina = solucionMedicina;
    }

    public String getObservacionMedicina() {
        return observacionMedicina;
    }

    public void setObservacionMedicina(String observacionMedicina) {
        this.observacionMedicina = observacionMedicina;
    }
    
     //Metodo agregar
    public boolean addMedicina(Mdl_Medicinas MdlMedicinas)
    {
        try {
           PreparedStatement addMedicina = ConexionSQL.getConexion().
           prepareStatement("Insert Into tbMedicinas(nombreMedicina, precioMedicina, cantidadMedicina, solucionMedicina, observacionMedicina)" + "Values (?, ?, ?, ?, ?)");
           
           addMedicina.setString(1, MdlMedicinas.getNombreMedicina());
           addMedicina.setDouble(2, MdlMedicinas.getPrecioMedicina()); //Podria dar error
           addMedicina.setInt(3, MdlMedicinas.getCantidadMedicina());
           addMedicina.setString(4, MdlMedicinas.getSolucionMedicina());
           addMedicina.setString(5, MdlMedicinas.getObservacionMedicina());
           
           addMedicina.executeUpdate();
           JOptionPane.showMessageDialog(null, "Medicina Agregada");
           return true;
           
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } 
    }
    
//     //Metodo leer
//    public boolean readMedicina(Mdl_Medicinas MdlMedicinas)
//    {
//        try {
//           PreparedStatement readMedicina = ConexionSQL.getConexion().
//           prepareStatement("Select idMedicina, nombreMedicina, precioMedicina, cantidadMedicina, solucionMedicina, observacionMedicina From tbMedicinas");
//           
//           readMedicina.executeUpdate();
//           return true;
//           
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//            return false;
//        } 
//    }
//    
       public void mostrar(Principal_0 vistaMedicina){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object []{"idMedicina","Nombre", "Precio", "Cantidad", "Solucion", "Observacion"});

        try{
            Statement statement =  (Statement) ConexionSQL.getConexion().createStatement();
            String query = "SELECT * FROM tbMedicinas";

            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){

                modelo.addRow(new Object[] {rs.getString("idMedicina"),rs.getString("nombreMedicina"),rs.getString("precioMedicina"), rs.getString("cantidadMedicina"), rs.getString("solucionMedicina"),  rs.getString("observacionMedicina") });

            }
            
            vistaMedicina.jTable1.setModel(modelo);

        }catch(SQLException ex){

            System.out.println(ex.toString());

        }

    }
    
    //Metodo actualizar
    public boolean updateMedicina(Mdl_Medicinas MdlMedicinas)
    {        
        try {
           PreparedStatement updateMedicina = ConexionSQL.getConexion().
           prepareStatement("Update tbMedicinas Set " +
" nombreMedicina = ?, precioMedicina = ?, " +
" cantidadMedicina = ?, solucionMedicina = ?, " +
" observacionMedicina =  ?" +
" Where idMedicina = ?");
           
           updateMedicina.setString(1, MdlMedicinas.getNombreMedicina());
           updateMedicina.setDouble(2, MdlMedicinas.getPrecioMedicina()); //Podria dar error
           updateMedicina.setInt(3, MdlMedicinas.getCantidadMedicina());
           updateMedicina.setString(4, MdlMedicinas.getSolucionMedicina());
           updateMedicina.setString(5, MdlMedicinas.getObservacionMedicina());
           updateMedicina.setInt(6, MdlMedicinas.getIdMedicina());
           
           updateMedicina.executeUpdate();
            System.out.println(MdlMedicinas.getIdMedicina());
           JOptionPane.showMessageDialog(null, "Medicina Actualizada");
           return true;
           
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } 
    }
    
    //Metodo eliminar
    public boolean deleteMedicina(Mdl_Medicinas MdlMedicinas)
    {
        try {
           PreparedStatement deleteMedicina = ConexionSQL.getConexion().
           prepareStatement("Delete From tbMedicinas Where idMedicina = ?");
           
          deleteMedicina.setInt(1, MdlMedicinas.getIdMedicina());
           
           deleteMedicina.executeUpdate();
           JOptionPane.showMessageDialog(null, "Medicina Eliminada");
           return true;
           
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } 
    }
}
