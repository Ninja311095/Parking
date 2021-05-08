package JDialog;
import Base_de_Datos.conexion;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;

public class MyDefaultTableModel extends DefaultTableModel {
    private Vector<Object> ultimosDatos = new Vector<>();
    private boolean isCellEditable = false;
    private int rowEditable = -1;
    private JTable table = null;
    private ArrayList <String> lista = new ArrayList<>();

    //Rendereres
    final TableCellRenderer rendererColor = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (row == rowEditable && column < 6) {
                final JLabel jLabel = new JLabel(value.toString());
                jLabel.setForeground(Color.ORANGE);
                return jLabel;
            } else {
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }
    };
    final TableCellRenderer rendererAccion = (JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) -> new JButton(o.toString());
    final TableCellRenderer rendererEditar = (table, value, isSelected, hasFocus, row, column) -> {
        if (value instanceof Boolean) {
            final JCheckBox jcb = new JCheckBox();
            jcb.setSelected((boolean) value);
            return jcb;
        } else {
            return new JLabel(value.toString());
        }
    };
    //Editors
    final TableCellEditor editorAccion = new TableCellEditor() {
        private Object lastValue = "Editar";
        private CellEditorListener cellEditorListener = null;

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            final JButton jButton = new JButton();
            jButton.addActionListener(e -> {
                if (isCellEditable && rowEditable > -1) {
                    setRowEditable(false, -1);
                    lastValue = isCellEditable && row == rowEditable ? "Guardar/Cancelar" : "Editar";
                    table.setValueAt(lastValue.toString(), row, column);
                    final int decision = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los cambios? Si preciona 'No', se descartara los cambios.", "Guardar o Cancelar", JOptionPane.YES_NO_OPTION);

                    if (decision == JOptionPane.NO_OPTION && ultimosDatos != null) {
                        establecerData(row, ultimosDatos);
                    } else {
                        final Vector<Object> data = guardarData(row);
                        if (onGuardarDatosListener != null && data != null)
                            onGuardarDatosListener.onGuardar(data.toArray());
                    }
                } else {
                    setRowEditable(true, row);
                    lastValue = isCellEditable && row == rowEditable ? "Guardar/Cancelar" : "Editar";
                    ultimosDatos = guardarData(row);
                    table.setValueAt(lastValue.toString(), row, column);
                }
                jButton.setText(lastValue.toString());
            });
            return jButton;
        }

        @Override
        public Object getCellEditorValue() {
            return lastValue;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return false;
        }

        @Override
        public boolean stopCellEditing() {
            if (cellEditorListener != null) cellEditorListener.editingStopped(new ChangeEvent(this));
            return true;
        }

        @Override
        public void cancelCellEditing() {
            if (cellEditorListener != null) cellEditorListener.editingCanceled(new ChangeEvent(this));
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
            cellEditorListener = l;
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            cellEditorListener = null;
        }
    };

    interface OnGuardarDatosListener {
        void onGuardar(Object[] datos);
    }

    private OnGuardarDatosListener onGuardarDatosListener = null;

    public MyDefaultTableModel() {
        super(new String[]{"Nombre", "Cedula", "Correo", "Telefono", "Posicion","Estado", "Accion", "Seleccionar"}, 0);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (rowEditable == -1) {
            return column == 6;
        } else {
            return rowEditable == row && isCellEditable;
        }
    }

    public void setRowEditable(boolean cellEditable, int row) {
        isCellEditable = cellEditable;
        rowEditable = row;
        if (table != null) {
            table.repaint();
            if (cellEditable) table.getSelectionModel().clearSelection();
        }
    }

    public void setTable(JTable table) {
        this.table = table;
        //Configurando tabla
        String consulta = "SELECT * FROM cargo";
        String dato = "cargo_posicion";
        
        table.setDefaultRenderer(Object.class, rendererColor);
        final JComboBox<String> jcbxPosiciones = new JComboBox<>();
        jcbxPosiciones.removeAllItems();
        
//        final JComboBox<String> jcbxEstado = new JComboBox<>();
//        jcbxEstado.removeAllItems();
        
        lista = conexion.llenacombo(consulta,dato);
        
        lista.forEach(e -> {
            jcbxPosiciones.addItem(e);
        });

//        jcbxEstado.addItem("Activo");
//        jcbxEstado.addItem("Inactivo");
        
        //Renderer
        table.getColumnModel().getColumn(6).setCellRenderer(rendererAccion);
        table.getColumnModel().getColumn(7).setCellRenderer(rendererEditar);

        //Editor
        table.getColumnModel().getColumn(6).setCellEditor(editorAccion);
        table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(jcbxPosiciones));
        //table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(jcbxEstado));
        table.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    }

    private Vector<Object> guardarData(int row) {
        if (row > -1 && row < dataVector.size()) {
            ultimosDatos.clear();
            for (int i = 0; i < getColumnCount(); i++) {
                ultimosDatos.add(getValueAt(row, i));
            }
            return ultimosDatos;
        } else {
            return null;
        }
    }

    private void establecerData(int row, Vector<Object> data) {
        if (data != null && data.size() == getColumnCount()) {
            final Iterator<Object> iterator = data.iterator();
            int contador = 0;
            while (iterator.hasNext()) {
                setValueAt(iterator.next(), row, contador);
                contador++;
            }
        }
    }

    public void setOnGuardarDatosListener(OnGuardarDatosListener onGuardarDatosListener) {
        this.onGuardarDatosListener = onGuardarDatosListener;
    }
}
