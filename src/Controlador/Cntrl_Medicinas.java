package Controlador;

import Modelo.Mdl_Medicinas;
import Vista.Principal_0;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cntrl_Medicinas implements ActionListener {
    
    private Mdl_Medicinas modeloMedicinas;
    private Principal_0 vistaMedicinas;

    public Cntrl_Medicinas(Mdl_Medicinas modeloMedicinas, Principal_0 vistaMedicinas) {
        this.modeloMedicinas = modeloMedicinas;
        this.vistaMedicinas = vistaMedicinas;
        
        this.vistaMedicinas.btnAgregar.addActionListener(this);
        this.vistaMedicinas.btnEditar.addActionListener(this);
        this.vistaMedicinas.btnEliminar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == vistaMedicinas.btnAgregar)
       {
           modeloMedicinas.setNombreMedicina(vistaMedicinas.txtNombre.getText());
           modeloMedicinas.setPrecioMedicina(Double.parseDouble(vistaMedicinas.txtPrecio.getText()));
           modeloMedicinas.setCantidadMedicina( Integer.parseInt(vistaMedicinas.txtCantidad.getText()));
           modeloMedicinas.setSolucionMedicina(vistaMedicinas.txtSolucion.getText());
           modeloMedicinas.setObservacionMedicina(vistaMedicinas.txtObservacion.getText());
           
           modeloMedicinas.addMedicina(modeloMedicinas);
       }
     
     if(e.getSource() == vistaMedicinas.btnEditar)
     {
           modeloMedicinas.setNombreMedicina(vistaMedicinas.txtNombre.getText());
           modeloMedicinas.setPrecioMedicina(Double.parseDouble(vistaMedicinas.txtPrecio.getText()));
           modeloMedicinas.setCantidadMedicina( Integer.parseInt(vistaMedicinas.txtCantidad.getText()));
           modeloMedicinas.setSolucionMedicina(vistaMedicinas.txtSolucion.getText());
           modeloMedicinas.setObservacionMedicina(vistaMedicinas.txtObservacion.getText());
           modeloMedicinas.setIdMedicina(vistaMedicinas.Id);
           
           modeloMedicinas.updateMedicina(modeloMedicinas);
     }
     
       if(e.getSource() == vistaMedicinas.btnEliminar)
     {
           modeloMedicinas.setIdMedicina(vistaMedicinas.Id);
           
           modeloMedicinas.deleteMedicina(modeloMedicinas);
     }
    }
    
}
