/* 
 * Copyright (C) 2014 Center of Excellence in Information Assurance
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.coeia.main;

/**
 *
 * @author wajdyessam
 *
 */

import edu.coeia.gutil.JTableUtil;
import edu.coeia.util.Utilities ;

import javax.swing.table.DefaultTableModel;

import java.util.List ;

public class WindowsInfoDialog extends javax.swing.JDialog {

    private List<String> data ;

    /** Creates new form WindowsInfoDialog */
    public WindowsInfoDialog(java.awt.Frame parent, boolean modal, List<String> data) {
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
             JTableUtil.removeAllRows(windowsSystemTable);

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
       JTableUtil.packColumns(windowsSystemTable, margin);
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
