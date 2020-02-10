/**
 * 
 */
package com.index;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.subpage.Java_SubPage;
import com.subpage.Myself_SubPage;
import com.subpage.Scientific_Reaseach_SubPage;

import java.awt.Font;

/**
 
 * @version 2019年12月23日下午7:13:15
 * @author Gershon
 *
 * 
 */
public class MyWorldIndex extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField GET_STU_SCORE;
	private ArrayList<String> arr;
	private JLabel BACKGROUND;
	private JLabel CAPITAL;
	private JLabel DATE;
	private JLabel CITY2;
	private JLabel CITY2_NAME;
	private JLabel STATUS;
	private JLabel CITY3;
	private JLabel CITY3_NAME;
	private JLabel CITY4;
	private JLabel CITY4_NAME;
	private JLabel FWWB;
	private JLabel FWWB_NAME;
	private JLabel TOWN6;
	private JLabel TOWN6_NAME;
	private JLabel TOWN7;
	private JLabel TOWN7_NAME;
	private JLabel CITY8;
	private JLabel lblNewLabel_1;
	private JLabel CITY8_NAME;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWorldIndex frame = new MyWorldIndex();
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
	public MyWorldIndex() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("日期");
		label.setBounds(50, 39, 46, 18);
		
		JLabel label_1 = new JLabel("国情");
		label_1.setBounds(50, 84, 30, 18);
		
		GET_STU_SCORE = new JTextField();
		GET_STU_SCORE.setBounds(372, 84, 86, 24);
		GET_STU_SCORE.setColumns(10);
		
		JButton button = new JButton("完成");
		button.setBounds(1757, 84, 63, 27);
		button.addActionListener(this);
		
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(GET_STU_SCORE);
		contentPane.add(button);
		
		ImageIcon mapBackground = new ImageIcon(MyWorldIndex.class.getResource("/world_map.png"));
		ImageIcon city = new ImageIcon(MyWorldIndex.class.getResource("/city.png"));
		ImageIcon town = new ImageIcon(MyWorldIndex.class.getResource("/town.png"));
		contentPane.setLayout(null);
		
		CAPITAL = new JLabel("");
		CAPITAL.setFont(new Font("宋体", Font.PLAIN, 90));
		CAPITAL.setBounds(1435, 561, 24, 18);
		CAPITAL.setIcon(city);
		CAPITAL.addMouseListener(this);
		contentPane.add(CAPITAL);
		
		JLabel CAPITAL_NAME = new JLabel("Myself");
		CAPITAL_NAME.setBounds(1450, 561, 50, 18);
		contentPane.add(CAPITAL_NAME);
		
		CITY2 = new JLabel("");
		CITY2.setBounds(1480, 518, 24, 18);
		CITY2.setIcon(city);
		CITY2.addMouseListener(this);
		contentPane.add(CITY2);
		
		CITY2_NAME = new JLabel("Java");
		CITY2_NAME.setBounds(1495, 518, 100, 18);
		contentPane.add(CITY2_NAME);
		
		CITY3 = new JLabel("");
		CITY3.setBounds(1530, 450, 72, 18);
		CITY3.setIcon(city);
		CITY3.addMouseListener(this);
		contentPane.add(CITY3);
		
		JLabel CITY3_NAME = new JLabel("Scientific Research");
		CITY3_NAME.setBounds(1545, 450, 120, 18);
		contentPane.add(CITY3_NAME);
		
		CITY4 = new JLabel("");
		CITY4.setBounds(1495, 550, 72, 18);
		CITY4.setIcon(town);
		contentPane.add(CITY4);
		
		CITY4_NAME = new JLabel("Android");
		CITY4_NAME.setBounds(1510, 550, 72, 18);
		contentPane.add(CITY4_NAME);
		
		FWWB = new JLabel("");
		FWWB.setBounds(1535, 430, 120, 18);
		FWWB.setIcon(town);
		contentPane.add(FWWB);
		
		FWWB_NAME = new JLabel("FWWB");
		FWWB_NAME.setBounds(1550, 430, 120, 18);
		contentPane.add(FWWB_NAME);
		
		TOWN6 = new JLabel("");
		TOWN6.setBounds(1480, 500, 72, 18);
		TOWN6.setIcon(town);
		contentPane.add(TOWN6);
		
		TOWN6_NAME = new JLabel("Swing");
		TOWN6_NAME.setBounds(1495, 500, 72, 18);
		contentPane.add(TOWN6_NAME);
		
		TOWN7 = new JLabel("");
		TOWN7.setBounds(1460, 510, 72, 18);
		TOWN7.setIcon(town);
		contentPane.add(TOWN7);
		
		TOWN7_NAME = new JLabel("JavaWeb");
		TOWN7_NAME.setBounds(1475, 510, 72, 18);
		TOWN7.setIcon(town);
		contentPane.add(TOWN7_NAME);
		
		CITY8 = new JLabel("");
		CITY8.setBounds(1420, 490, 72, 18);
		CITY8.setIcon(city);
		CITY8.addMouseListener(this);
		contentPane.add(CITY8);
		
		CITY8_NAME = new JLabel("Mysql");
		CITY8_NAME.setBounds(1435, 490, 72, 18);
		contentPane.add(CITY8_NAME);
		
		BACKGROUND = new JLabel("");
		BACKGROUND.setBounds(19, 165, 1843, 794);
		BACKGROUND.setIcon(mapBackground);
		contentPane.add(BACKGROUND);
		
		DATE = new JLabel("");
		DATE.setBounds(102, 39, 86, 18);
		contentPane.add(DATE);
		
		STATUS = new JLabel("UP");
		STATUS.setBounds(102, 84, 72, 18);
		contentPane.add(STATUS);
		
		tabDate();
		write();
	}
	public void write() {
	
		File f = null;
		String file = "F:/学习进程/机器学习/Octave/workspace/study.txt";
		BufferedReader bre = null;
		
		try {
			String str;
			bre = new BufferedReader(new FileReader(file));// 此时获取到的bre就是整个文件的缓存流

			ArrayList<String> arr = new ArrayList();

			while ((str = bre.readLine()) != null) // 判断最后一行不存在，为空结束循环
			{
				// 逐行读取文件放入ArrayList数组中
				arr.add(str);
			}
			bre.close();// 关闭流
		
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			sb1.append((arr.get(5)));
			
			String date;
			date=sb1.toString();
			arr.remove(5);
			arr.add(5, date);
			
			String stud;
			sb2.append((arr.get(12)));
			sb2.append(" "+GET_STU_SCORE.getText());
			stud=sb2.toString();
			arr.remove(12);
			arr.add(12, stud);
			
			//自增txt文件中的rows
			String[] str1 = (arr.get(4)).split("\\s+");
			String[] str2 = (arr.get(11)).split("\\s+");
			
			String s1=str1[2];
			String s2=str2[2];
			int num1 = Integer.parseInt(s1),num2=Integer.parseInt(s2);
			
			if(!(GET_STU_SCORE.getText().equals(""))) {
				num2+=1;
			}
			s1=String.valueOf(num1);
			s2=String.valueOf(num2);
			
			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				for (int j = 0; j < arr.size(); j++) {
					if(j==4) {
						fw.write("# columns: "+s1+"\n");
					}else if(j==11){
						fw.write("# columns: "+s2+"\n");
					}else {
						fw.write(arr.get(j)+"\n");
					}
					}
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}catch (Exception e2) {
		e2.getStackTrace();
	}
	}
	
	public void setImage() {
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		write();
	}
	
	public void tabDate() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(date);
		DATE.setText(str);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String command=e.getComponent().toString();
		if(command.equals(CAPITAL.toString())) {
			Myself_SubPage msp=new Myself_SubPage();
			msp.setVisible(true);
		}
		if(command.equals(CITY2.toString())) {
			Java_SubPage js=new Java_SubPage();
			js.setVisible(true);
		}
		if(command.equals(CITY3.toString())) {
			Scientific_Reaseach_SubPage srsp=new Scientific_Reaseach_SubPage();
			srsp.setVisible(true);
		}
		if(command.equals(CITY8.toString())) {
			Scientific_Reaseach_SubPage srsp=new Scientific_Reaseach_SubPage();
			srsp.setVisible(true);
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
