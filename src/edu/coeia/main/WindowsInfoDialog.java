/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WindowsInfoDialog.java
 *
 * Created on Jul 22, 2010, 10:44:21 AM
 */

package edu.coeia.main;

/**
 *
 * @author wajdyessam
 *
 */

import edu.coeia.main.util.Utilities ;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList ;

public class WindowsInfoDialog extends javax.swing.JDialog {

    private ArrayList<String> data ;

    /** Creates new form WindowsInfoDialog */
    public WindowsInfoDialog(java.awt.Frame parent, boolean modal, ArrayList<String> data) {
        super(parent, modal);
        initComponents();

        this.data = data ;
        setLocationRelativeTo(parent);
        setTitle("Windows System Informations");
        
        fillTable();
    }

    private void fillTable () {
        // remove all data
        if ( windowsSystemTable.getModel().getRowCount() > 0 )
             Utilities.removeAllRows(windowsSystemTable);

        for (int i=1 ; i<data.size() ; i++){
            String[] row = data.get(i).split(":");

            if ( row.length > 1 ) {
                String col1 = row[0].trim();
                String col2 = "" ;

                for (int j=1 ; j<row.length ; j++)
                    col2 += row[j].trim() ;

                ((DefaultTableModel) windowsSystemTable.getModel()).addRow( new Object[] {
                col1,col2
                });
            }
            else {
                String col1 = row[0].trim();

                ((DefaultTableModel) windowsSystemTable.getModel()).addRow( new Object[] {
                col1
                });
            }
        }

       // Pack the all columns of the table
       int margin = 1;
       Utilities.packColumns(windowsSystemTable, margin);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane11 = new javax.swing.JScrollPane();
        windowsSystemTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        windowsSystemTable.setAutoCreateRowSorter(true);
        windowsSystemTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        windowsSystemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Name" , "Value"
            }
        ));
        windowsSystemTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane11.setViewportView(windowsSystemTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable windowsSystemTable;
    // End of variables declaration//GEN-END:variables

}
