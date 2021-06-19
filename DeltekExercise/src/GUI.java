import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GUI {

	private JFrame frmCalculator;
	private JTextField Display;
	private JButton MRBtn;
	private JButton MSBtn;
	private JButton MPBtn;
	private JButton MMBtn;
	private JButton MCBtn;
	private JButton ClrBtn;
	private JButton BackBtn;
	private JButton DivBtn;
	private JButton Num7Btn;
	private JButton Num8Btn;
	private JButton Num9Btn;
	private JButton MulBtn;
	private JButton Num4Btn;
	private JButton Num5Btn;
	private JButton Num6Btn;
	private JButton SubBtn;
	private JButton Num1Btn;
	private JButton Num2Btn;
	private JButton Num3Btn;
	private JButton PlsBtn;
	private JButton ZeroBtn;
	private JButton DecBtn;
	private JButton SignBtn;
	private JButton EqBtn;
	private double total1 = 0.0;
	private double total2 = 0.0;
	private double temp;
	private double temp1;
	private char operation;	
	private JMenuBar menuBar;
	private JMenu MenuEdit;
	private JMenuItem MenuCopy;
	private JMenuItem MenuPaste;
	private JMenuItem MenuImp;
	private JTable table;
	String s,ID,action,value;
	DefaultTableModel model;
	int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void backspace() {
		Display.setText(Display.getText().substring(0,Display.getText().length()-1));		
		 if (Display.getText().length() < 1)
            Display.setText(""); 
	}
	private void getOperator(String TextButton) {
		operation = TextButton.charAt(0);
		total1 = total1 + Double.parseDouble(Display.getText());
		Display.setText("");
	}
	
	private void CreateColumns() {
		model=(DefaultTableModel) table.getModel();
		model.addColumn("ID");
		model.addColumn("Action");
		model.addColumn("Value");
	}
	
	private void populate(String ID, String action, String value) {
		String[] rowData= {ID, action, value};
		model.addRow(rowData);
	}
	
	 private void openHistory() {
		JDialog dialog = new JDialog();
		dialog.setBounds(100, 100, 400, 340);
        JPanel panel = new JPanel();
        JButton SaveBtn = new JButton("Export");
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Action");
        model.addColumn("Value");
    
        panel.add(table);
        panel.add(SaveBtn);
        dialog.getContentPane().add(panel);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
        dialog.pack();
	} 
	
	private void openTable() {
		
	     Export exp = new Export();
	/*     Vector data = model.getDataVector();
	     for(int i = 0; i < count ; i++) {
	    	 Vector row = (Vector)data.elementAt(i);
	    	 		row = (Vector)row.clone();
	     } */
//	 	(model.getValueAt(table.getSelectedRow(), 0).toString())
	     exp.setVisible(true);
	}
	
	/**
	 * Create the application.
	 */
	
	public GUI() {
		initialize();
		CreateColumns();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setResizable(false);
		frmCalculator.setBounds(0, 0, 455, 540);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setBounds(15, 275, 250, 200);
		frmCalculator.getContentPane().add(table);
		table.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 120);
		frmCalculator.getContentPane().add(panel);
		panel.setLayout(null);
		
		Display = new JTextField();
		Display.setEditable(false);
		Display.setHorizontalAlignment(SwingConstants.TRAILING);
		Display.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Display.setBounds(110,60, 315, 60);
		panel.add(Display);
		Display.setColumns(10);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 116, 22);
		panel.add(menuBar);
		
		JMenu MenuFile = new JMenu("File");
		menuBar.add(MenuFile);
		
		JMenuItem MenuClear = new JMenuItem("Clear");
		MenuFile.add(MenuClear);
		
		JMenuItem MenuExit = new JMenuItem("Exit");
		MenuFile.add(MenuExit);
		
		JMenu MenuEdit = new JMenu("Edit");
		menuBar.add(MenuEdit);
		
		JMenuItem MenuCopy = new JMenuItem("Copy");
		MenuEdit.add(MenuCopy);
		
		JMenuItem MenuPaste = new JMenuItem("Paste");
		MenuEdit.add(MenuPaste);
		
		JMenu MenuHist = new JMenu("History");
		menuBar.add(MenuHist);
		
		JMenuItem MenuView = new JMenuItem("View History");
		MenuHist.add(MenuView);
		
		JMenuItem MenuImp = new JMenuItem("Import");
		MenuHist.add(MenuImp);
		
		MenuClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Display.setText("");
		}
			});
		
		MenuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.exit(0);
		}
			});
		
		MenuCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				temp1 = Double.parseDouble(Display.getText());
		}
			});
		
		MenuPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Display.setText(Double.toString(temp1));
		}
			});
		
		MenuView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				//openHistory();
				TableModel model1 = table.getModel();
				int index[] = table.getSelectedRows();
				Object[] row = new Object[3];
				
				Export exp = new Export();
				DefaultTableModel model2 = (DefaultTableModel)exp.table.getModel();
				
				for(int i = 0 ; i < index.length; i++) {
					row[0] = model1.getValueAt(index[i], 0);
					row[1] = model1.getValueAt(index[i], 1);
					row[2] = model1.getValueAt(index[i], 2);
					row[3] = model1.getValueAt(index[i], 3);
					
					model2.addRow(row);
				}
				exp.setVisible(true);
	    }        
			
		}
			);
		
		MenuImp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Import imp = new Import();
				imp.setVisible(true);
		}
			});
		
		PlsBtn = new JButton("+");
		PlsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String button_text = PlsBtn.getText();
				count++;
				String s = Integer.toString(count);
				populate(s, PlsBtn.getText(), Display.getText());
				getOperator(button_text);
			}
		});
		
		PlsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PlsBtn.setBounds(335, 370, 100, 60);
		frmCalculator.getContentPane().add(PlsBtn);
		
		SubBtn = new JButton("-");
		SubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String button_text = SubBtn.getText();
				count++;
				String s = Integer.toString(count);
				populate(s, SubBtn.getText(), Display.getText());
				getOperator(button_text);
			}
		});
		SubBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SubBtn.setBounds(335, 310, 100, 60);
		frmCalculator.getContentPane().add(SubBtn);
		
		MulBtn = new JButton("*");
		MulBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String button_text = MulBtn.getText();
				count++;
				String s = Integer.toString(count);
				populate(s, MulBtn.getText(), Display.getText());
				getOperator(button_text);
			}
		});
		MulBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MulBtn.setBounds(335, 250, 100, 60);
		frmCalculator.getContentPane().add(MulBtn);
		
		DivBtn = new JButton("/");
		DivBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String button_text = DivBtn.getText();
				count++;
				String s = Integer.toString(count);
				populate(s, DivBtn.getText(), Display.getText());
				getOperator(button_text);
			}
		});
		DivBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DivBtn.setBounds(335, 190, 100, 60);
		frmCalculator.getContentPane().add(DivBtn);
		
		MRBtn = new JButton("MR");
		MRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display.setText(Double.toString(temp));
			}
		});
		MRBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MRBtn.setBounds(5, 130, 100, 60);
		frmCalculator.getContentPane().add(MRBtn);
		
		MSBtn = new JButton("MS");
		MSBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = Double.parseDouble(Display.getText());
			}
		});
		MSBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MSBtn.setBounds(115, 130, 100, 60);
		frmCalculator.getContentPane().add(MSBtn);
		
		MPBtn = new JButton("M+");
		MPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total2 = total2 + temp;
				Display.setText(Double.toString(total2));
			}
		});
		MPBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MPBtn.setBounds(225, 130, 100, 60);
		frmCalculator.getContentPane().add(MPBtn);
		
		MMBtn = new JButton("M-");
		MMBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total2 = total2 - temp;
				Display.setText(Double.toString(total2));
			}
		});
		MMBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MMBtn.setBounds(335, 130, 100, 60);
		frmCalculator.getContentPane().add(MMBtn);
		
		MCBtn = new JButton("MC");
		MCBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = 0;
			}
		});
		MCBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MCBtn.setBounds(5, 190, 100, 60);
		frmCalculator.getContentPane().add(MCBtn);
		
		ClrBtn = new JButton("C");
		ClrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String button_text = ClrBtn.getText();
				total2 = 0;
				Display.setText("0");
				count++;
				String s = Integer.toString(count);
				populate(s, ClrBtn.getText(), Display.getText());
				getOperator(button_text);
				
			}
		});
		ClrBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ClrBtn.setBounds(115, 190, 100, 60);
		frmCalculator.getContentPane().add(ClrBtn);
		
		BackBtn = new JButton("<-");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backspace();  
			}
		});
		BackBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BackBtn.setBounds(225, 190, 100, 60);
		frmCalculator.getContentPane().add(BackBtn);
		
		Num7Btn = new JButton("7");
		Num7Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn7Text = Display.getText() + Num7Btn.getText();
				Display.setText(Btn7Text);
			}
		});
		Num7Btn.setBounds(5, 250, 100, 60);
		frmCalculator.getContentPane().add(Num7Btn);
		
		Num8Btn = new JButton("8");
		Num8Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn8Text = Display.getText() + Num8Btn.getText();
				Display.setText(Btn8Text);
			}
		});
		Num8Btn.setBounds(115, 250, 100, 60);
		frmCalculator.getContentPane().add(Num8Btn);
		
		Num9Btn = new JButton("9");
		Num9Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn9Text = Display.getText() + Num9Btn.getText();
				Display.setText(Btn9Text);
			}
		});
		Num9Btn.setBounds(225, 250, 100, 60);
		frmCalculator.getContentPane().add(Num9Btn);
		
		Num4Btn = new JButton("4");
		Num4Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn4Text = Display.getText() + Num4Btn.getText();
				Display.setText(Btn4Text);
			}
		});
		Num4Btn.setBounds(5, 310, 100, 60);
		frmCalculator.getContentPane().add(Num4Btn);
		
		Num5Btn = new JButton("5");
		Num5Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn5Text = Display.getText() + Num5Btn.getText();
				Display.setText(Btn5Text);
			}
		});
		Num5Btn.setBounds(115, 310, 100, 60);
		frmCalculator.getContentPane().add(Num5Btn);
		
		Num6Btn = new JButton("6");
		Num6Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn6Text = Display.getText() + Num6Btn.getText();
				Display.setText(Btn6Text);
			}
		});
		Num6Btn.setBounds(225, 310, 100, 60);
		frmCalculator.getContentPane().add(Num6Btn);
		
		Num1Btn = new JButton("1");
		Num1Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn1Text = Display.getText() + Num1Btn.getText();
				Display.setText(Btn1Text);
			}
		});
		Num1Btn.setBounds(5, 370, 100, 60);
		frmCalculator.getContentPane().add(Num1Btn);
		
		Num2Btn = new JButton("2");
		Num2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn2Text = Display.getText() + Num2Btn.getText();
				Display.setText(Btn2Text);
			}
		});
		Num2Btn.setBounds(115, 370, 100, 60);
		frmCalculator.getContentPane().add(Num2Btn);
		
		Num3Btn = new JButton("3");
		Num3Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn3Text = Display.getText() + Num3Btn.getText();
				Display.setText(Btn3Text);
			}
		});
		Num3Btn.setBounds(225, 370, 100, 60);
		frmCalculator.getContentPane().add(Num3Btn);
		
		ZeroBtn = new JButton("0");
		ZeroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Btn0Text = Display.getText() + ZeroBtn.getText();
				Display.setText(Btn0Text);
			}
		});
		ZeroBtn.setBounds(5, 430, 100, 60);
		frmCalculator.getContentPane().add(ZeroBtn);
		
		DecBtn = new JButton(".");
		DecBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BtnDecText = Display.getText() + DecBtn.getText();
				Display.setText(BtnDecText);
			}
		});
		DecBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DecBtn.setBounds(115, 430, 100, 60);
		frmCalculator.getContentPane().add(DecBtn);
		
		SignBtn = new JButton("+/-");
		SignBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total2 = total2 * (-1.0);
				Display.setText(Double.toString(total2));
				count++;
				String s = Integer.toString(count);
				populate(s, SignBtn.getText(), Display.getText());
			}
		});
		SignBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignBtn.setBounds(225, 430, 100, 60);
		frmCalculator.getContentPane().add(SignBtn);
		
		EqBtn = new JButton("=");
		EqBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (operation) {
				case '+':
					total2 = total1 + Double.parseDouble(Display.getText());
					break;
				case '-':
					total2 = total1 - Double.parseDouble(Display.getText());
					break;
				case '*':
					total2 = total1 * Double.parseDouble(Display.getText());
					break;
				case '/':
					total2 = total1 / Double.parseDouble(Display.getText());
					break;
				}
				Display.setText(Double.toString(total2));
				count++;
				String s = Integer.toString(count);
				populate(s, EqBtn.getText(), Display.getText());
				total1 = 0;
			}
		});
		
		EqBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EqBtn.setBounds(335, 430, 100, 60);
		frmCalculator.getContentPane().add(EqBtn);
}
}
