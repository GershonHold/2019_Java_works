package com.Students;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class Index_Teacher extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTable table;
	private Vector Data;
	private Vector ColName;
	private JTabbedPane tabbedPane;
	private JPanel pAdd;
	private JLabel lAddName;
	private JTextField tAddID;
	private JTextField tAddName;
	private JLabel lAddAge;
	private JTextField tAddAge;
	private JTextField tAddSex;
	private JTextField tAddScore;
	private JButton btnAdd;
	private JTextField tDelID;
	private JPanel pDel;
	private JLabel lDelName;
	private JTextField tDelName;
	private JButton btnDel;
	private JPanel pUp;
	private JLabel lUpOldName;
	private JTextField tUpOldName;
	private JLabel lUpNewName;
	private JTextField tUpNewName;
	private DefaultTableModel dtm;
	private JLabel lUpNewAge;
	private JTextField tUpNewAge;
	private JButton btnUp;
	private JLabel lblSex;
	private JLabel lblScore;
	private String command;
	private JLabel label;
	private JLabel label_1;
	private FileReader fr;
	private JTextField getDelID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Index_Teacher frame = new Index_Teacher();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Index_Teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 456);
		setLocation(442,236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Data = new Vector();
		ShowData();
		ColName = new Vector();
		ColName.add("ID");
		ColName.add("name");
		ColName.add("age");
		ColName.add("sex");
		ColName.add("score");

		dtm = new DefaultTableModel(Data, ColName);
		dtm.setDataVector(Data, ColName);
		contentPane.setLayout(null);

		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 115, 704, 281);
		contentPane.add(scrollPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 45, 694, 69);
		contentPane.add(tabbedPane);

		pAdd = new JPanel();
		tabbedPane.addTab("录入学生信息", pAdd);
		pAdd.setLayout(null);

		lAddName = new JLabel("Name");
		lAddName.setBounds(83, 14, 40, 18);
		pAdd.add(lAddName);
		
		tAddName = new JTextField();
		tAddName.setBounds(124, 7, 50, 24);
		tAddName.setColumns(8);
		pAdd.add(tAddName);

		lAddAge = new JLabel("Age");
		lAddAge.setBounds(188, 14, 24, 18);
		pAdd.add(lAddAge);

		tAddAge = new JTextField();
		tAddAge.setBounds(215, 7, 50, 24);
		tAddAge.setColumns(8);
		pAdd.add(tAddAge);

		btnAdd = new JButton("add");
		btnAdd.setBounds(618, 7, 57, 27);
		btnAdd.addActionListener(this);
		
		lblSex = new JLabel("Sex");
		lblSex.setBounds(277, 14, 24, 18);
		pAdd.add(lblSex);
		
		tAddSex = new JTextField();
		tAddSex.setBounds(304, 8, 50, 24);
		pAdd.add(tAddSex);
		tAddSex.setColumns(8);
		
		lblScore = new JLabel("Score");
		lblScore.setBounds(368, 14, 40, 18);
		pAdd.add(lblScore);
		
		tAddScore = new JTextField();
		tAddScore.setBounds(415, 7, 50, 24);
		pAdd.add(tAddScore);
		tAddScore.setColumns(8);
		pAdd.add(btnAdd);
		
		tAddID = new JTextField();
		tAddID.setColumns(8);
		tAddID.setBounds(27, 8, 50, 24);
		pAdd.add(tAddID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(0, 14, 24, 18);
		pAdd.add(lblId);

		pDel = new JPanel();
		tabbedPane.addTab("删除学生信息", null, pDel, null);
		pDel.setLayout(null);

		lDelName = new JLabel("ID");
		lDelName.setBounds(282, 9, 16, 18);
		pDel.add(lDelName);

		btnDel = new JButton("Delete");
		btnDel.setBounds(404, 5, 81, 27);
		pDel.add(btnDel);
		
		getDelID = new JTextField();
		getDelID.setBounds(312, 6, 86, 24);
		pDel.add(getDelID);
		getDelID.setColumns(10);
		btnDel.addActionListener(this);

		pUp = new JPanel();
		tabbedPane.addTab("修改学生信息", null, pUp, null);

		lUpOldName = new JLabel("oldName");
		pUp.add(lUpOldName);

		tUpOldName = new JTextField();
		tUpOldName.setColumns(10);
		pUp.add(tUpOldName);

		lUpNewName = new JLabel("newName");
		pUp.add(lUpNewName);

		tUpNewName = new JTextField();
		tUpNewName.setColumns(10);
		pUp.add(tUpNewName);

		lUpNewAge = new JLabel("newAge");
		pUp.add(lUpNewAge);

		tUpNewAge = new JTextField();
		tUpNewAge.setColumns(10);
		pUp.add(tUpNewAge);

		btnUp = new JButton("Update");
		btnUp.addActionListener(this);
		pUp.add(btnUp);
		
		label = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u6559\u5E08\u7248");
		label.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 32));
		label.setBounds(218, 13, 319, 34);
		contentPane.add(label);
		
		label_1 = new JLabel("\u5E2E\u52A9\uFF1F");
		label_1.setBounds(634, 14, 56, 18);
		contentPane.add(label_1);
		label_1.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		Vector row = new Vector();
		if (command.equals("add")) {
			if(tAddName.getText()!=null&&tAddAge.getText()!=null&&tAddSex.getText()!=null&&tAddScore.getText()!=null) {
			String addID=tAddID.getText();
			String addName = tAddName.getText();
			String addAge = tAddAge.getText();
			String addSex=tAddSex.getText();
			String addScore=tAddScore.getText();
			
			if (!(addID.equals(""))&&!(addName.equals("")) && !(addAge.equals(""))&& !(addSex.equals(""))&& !(addScore.equals(""))) {
				Outputdata(addID);
				Outputdata(addName);
				Outputdata(addAge);
				Outputdata(addSex);
				Outputdata(addScore);
				
				RandomAccessFile raf = null;
				try {
					raf = new RandomAccessFile(new File("C://MIS//lib//Student.txt"),"rw");
					raf.seek(raf.length());
					raf.write(("\n").getBytes());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				row.add(addID);
				row.add(addName);
				row.add(addAge);
				row.add(addSex);
				row.add(addScore);
				
				Data.add(row);
				dtm.setDataVector(Data, ColName);
			tAddID.setText("");
			tAddName.setText("");
			tAddAge.setText("");
			tAddSex.setText("");
			tAddScore.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "您未输入信息或者信息不完整", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		} 
			
		String delName = getDelID.getText();
		if (command.equals("Delete")) {
			if (!(delName.equals(""))) {
				for (int i = 0; i < Data.size(); i++) {
					Object obj = Data.get(i);
					Vector v = (Vector) obj;
					Object n = v.get(0);
					String rowDataName = String.valueOf(n);
					if (delName.equals(rowDataName)) {
						Data.remove(obj);
						dtm.setDataVector(Data, ColName);
						
						break;
					}
				}
			}
			tDelName.setText("");
		}
		if (command.equals("Update")) {
			String upOldName = tUpOldName.getText();
			String upNewName = tUpNewName.getText();
			String upNewSex = tUpNewName.getText();
			String upNewScore = tUpNewName.getText();

			String upNewAge = tUpNewAge.getText();
			if (upOldName != null ) {
				for (int i = 0; i < Data.size(); i++) {
					Object obj = Data.get(i);
					Vector v = (Vector) obj;
					Object n = v.get(0);

					if (upOldName.equals(String.valueOf(n))) {
						if(upNewName.equals("")&&!upNewAge.equals("")&&!upNewSex.equals("")&&!upNewScore.equals("")) {
							v.set(1, upNewAge);
						}else if(!upNewName.equals("")&&upNewAge.equals("")) {
							v.set(0, upNewName);
						}else if(!upNewName.equals("")&&!upNewAge.equals("")){
							v.set(0, upNewName);
							v.set(1, upNewAge);
						}
						dtm.setDataVector(Data, ColName);
						break;
					}
				}
			}
			tUpOldName.setText("");
			tUpNewName.setText("");
			tUpNewAge.setText("");
		}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JOptionPane.showMessageDialog(null, "1.本地学生数据保存在目录'C://MIS//lib'下", "提示", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		label_1.setForeground(Color.blue);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		label_1.setForeground(Color.black);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void Outputdata(String str) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(new File("C://MIS//lib//Student.txt"),"rw");
			try {
				raf.seek(raf.length());
				raf.write((str+" ").getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(raf==null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	}
	
	public void ShowData() {
		
		File bf=new File("C://MIS//lib//Student.txt");
		FileOutputStream os = null;
		if(!bf.exists()){
			 try {
				bf.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("C://MIS//lib//Student.txt")));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String data = null;
		try {
			while((data = br.readLine())!=null)
			{
				String[] str = data.split("\\s+");
				
				Vector row = new Vector();
				for(String s:str) {
					row.add(s);
				}
				Data.add(row);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	}
