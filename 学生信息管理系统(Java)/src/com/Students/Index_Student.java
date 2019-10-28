/**
 * 
 */
package com.Students;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;


public class Index_Student extends JFrame implements MouseListener{

	private JPanel contentPane;
	private Vector Data;
	private Vector ColName;
	private DefaultTableModel dtm;
	private JTabbedPane tabbedPane;
	private JLabel label_help;
	private static String ID;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_3;
	private JLabel lblId;
	private JLabel label_4;
	private JLabel lblNewLabel_2;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private String text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index_Student frame = new Index_Student(ID);
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
	public Index_Student(String ID) {
		
		this.ID=ID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 456);
		setLocation(442,246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Data = new Vector();
		ColName = new Vector();
		ShowData();
//		ColName.add("ID");
//		ColName.add("name");
//		ColName.add("age");
//		ColName.add("sex");
//		ColName.add("score");

		dtm = new DefaultTableModel(Data, ColName);
		dtm.setDataVector(Data, ColName);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 276, 704, 133);
		contentPane.add(scrollPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 45, 704, 69);
		contentPane.add(tabbedPane);
		
		JLabel label = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u5B66\u751F\u7248");
		label.setFont(new Font("Dialog", Font.PLAIN, 32));
		label.setBounds(202, 13, 315, 34);
		contentPane.add(label);
		
		label_help = new JLabel("\u5E2E\u52A9\uFF1F");
		label_help.setBounds(634, 14, 56, 18);
		contentPane.add(label_help);
		
		label_1 = new JLabel("\u7CFB\u7EDF\u65F6\u95F4");
		label_1.setBounds(0, 0, 65, 18);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(63, 0, 121, 18);
		contentPane.add(label_2);
		label_help.addMouseListener(this);
		
		MyThread mt=new MyThread(label_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(14, 120, 51, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("同学，你好！");
		lblNewLabel_1.setBounds(74, 120, 110, 18);
		contentPane.add(lblNewLabel_1);
		
		label_3 = new JLabel("你的基本信息");
		label_3.setBounds(298, 151, 97, 18);
		contentPane.add(label_3);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(14, 176, 72, 18);
		contentPane.add(lblId);
		
		label_4 = new JLabel("姓名");
		label_4.setBounds(112, 176, 72, 18);
		contentPane.add(label_4);
		
		lblNewLabel_2 = new JLabel("年龄");
		lblNewLabel_2.setBounds(221, 176, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		label_5 = new JLabel("性别");
		label_5.setBounds(308, 176, 72, 18);
		contentPane.add(label_5);
		
		label_6 = new JLabel("查看分数");
		label_6.setBounds(448, 176, 72, 18);
		contentPane.add(label_6);
		
		label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(14, 207, 72, 18);
		contentPane.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setBounds(100, 207, 72, 18);
		contentPane.add(label_8);
		
		label_9 = new JLabel("");
		label_9.setBounds(202, 207, 72, 18);
		contentPane.add(label_9);
		
		label_10 = new JLabel("");
		label_10.setBounds(295, 207, 72, 18);
		contentPane.add(label_10);
		Thread t=new Thread(mt);
		t.start();
	}
public void ShowData() {
		String id=ID;
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
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String data = null;
		try {
			Vector row = null;
			while((data = br.readLine())!=null)
			{
				String[] str = data.split("\\s+");
				row = new Vector();
				for(String s:str) {
					row.add(s);
				}
				Data.add(row);
			}
			
				String SuitID=row.firstElement().toString();
				String ID1 = null;
				String name = null;
				String age = null;
				String sex = null;
				String score=null;
				for (int i = 0; i < Data.size(); i++) {
						Object obj = Data.get(i);
						Vector v = (Vector) obj;
						if(ID.equals(v.firstElement())){
						int j=0;
						for(;j<v.size();j++){
						Object n = v.get(j);
						System.out.println(v.get(j));
						
						text=(String) (v.get(j));
						if(j==0){
						ID1=text;
						System.out.println(ID1);
						}if(j==1){
						name=text;
						}if(j==2){
						age=text;
						}if(j==3){
						score=text;
						}
				}
		} }
				label_7.setText(ID1);
				label_8.setText(name);
				label_9.setText(age);
				label_10.setText(sex);
				lblNewLabel.setText(ID1);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
}


@Override
public void mouseClicked(MouseEvent arg0) {
	JOptionPane.showMessageDialog(null, "1.本地学生数据保存在目录C://MIS//lib下", "提示", JOptionPane.INFORMATION_MESSAGE);
}

@Override
public void mouseEntered(MouseEvent arg0) {
	label_help.setForeground(Color.blue);
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	label_help.setForeground(Color.black);
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
