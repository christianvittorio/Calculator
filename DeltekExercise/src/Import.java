import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.logging.*;

public class Import extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Import frame = new Import();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void ImportFile() {
        String filePath = "C:\\Users\\Betlog\\Desktop\\Text.txt";
        File file = new File(filePath);
        
        try {
            FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
            // get the first line
            // get the columns name from the first line
            // set columns name to the table model
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setColumnIdentifiers(columnsName);
            
            // get lines from text file
            Object[] tableLines = br.lines().toArray();
            
            // extract data from lines
            // set data to table model
            for(int i = 0; i < tableLines.length; i++)
            {
                String lines = tableLines[i].toString().trim();
                String[] rows = lines.split("/");
                model.addRow(rows);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	/**
	 * Create the frame.
	 */
	public Import() {
		setTitle("History");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 239);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImportHistory = new JButton("Import History");
		btnImportHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportFile();
			}
		});
		
		btnImportHistory.setLocation(95, 13);
		btnImportHistory.setSize(120,20);
		getContentPane().setLayout(null);
		getContentPane().add(btnImportHistory);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 45, 200, 150);
		contentPane.add(panel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		panel.add(table);
	}
}

