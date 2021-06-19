import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.logging.*;


public class Export extends JFrame {

	private JPanel contentPane;
	JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Export frame = new Export();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Export() {
		setTitle("History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExportHistory = new JButton("Export History");
		btnExportHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		                //the file path
		               File file = new File("C:\\Users\\Betlog\\Desktop\\table.txt");
		               //if the file does not exist create one
		               if(!file.exists()){
		                   file.createNewFile();
		               }
		               
		               FileWriter fw = new FileWriter(file.getAbsoluteFile());
		               BufferedWriter bw = new BufferedWriter(fw);
		               
		               //loop for jtable rows
		               for(int i = 0; i < table.getRowCount(); i++){
		                   //loop for jtable column
		                   for(int j = 0; j < table.getColumnCount(); j++){
		                       bw.write(table.getModel().getValueAt(i, j)+" ");
		                   }
		                   //break line at the begin 
		                   //break line at the end 
		                   	bw.write("\n_________\n");
		               }
		               //close BufferedWriter
		               		bw.close();
		               //close FileWriter 
		               		fw.close();
		               		JOptionPane.showMessageDialog(null, "Data Exported");
		               
		               }	catch(Exception ex){
		                   	ex.printStackTrace();
		               }
		           }
		        });
			
		btnExportHistory.setBounds(140, 13, 115, 20);
		contentPane.add(btnExportHistory);

	/*	DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setBounds(15, 275, 250, 200);
		frmCalculator.getContentPane().add(table);
		table.setVisible(true); */
		
		DefaultTableModel model2 = new DefaultTableModel();
		table = new JTable(model2);
		table.setBounds(74, 54, 250, 200);
		contentPane.add(table);
	}
}
