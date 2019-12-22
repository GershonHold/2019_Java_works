package com.student;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Index_Student extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private Vector Data;
	private Vector ColName;
	private DefaultTableModel dtm;
	private JLabel label_help;
	private static String ID;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel;
	private String text;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_12;
	private JLabel id;
	private JLabel name;
	private JLabel age;
	private JLabel sex;
	private JPanel panel_1;
	private JTextField Up_pwd;
	private String command;
	private JPanel panel_2;
	private JTable table;
	private JLabel score_1;
	private JLabel score_2;
	private JLabel score_3;
	private JLabel score_4;
	private JLabel score_5;
	private JLabel WELCOME;
	private JLabel label_EXIT;

	/**
	 * Create the frame.
	 */
	public Index_Student(String ID) {

		this.ID = ID;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 456);
		setLocation(442, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		dtm = new DefaultTableModel(Data, ColName);
		dtm.setDataVector(Data, ColName);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-2, 78, 706, 253);
		contentPane.add(tabbedPane);

		panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("基本信息", null, panel, null);

		label_3 = new JLabel("你的基本信息");
		label_3.setBounds(302, 0, 97, 18);
		panel.add(label_3);

		label_4 = new JLabel("ID");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(14, 28, 72, 18);
		panel.add(label_4);

		label_5 = new JLabel("姓名");
		label_5.setBounds(113, 28, 72, 18);
		panel.add(label_5);

		label_6 = new JLabel("年龄");
		label_6.setBounds(221, 28, 72, 18);
		panel.add(label_6);

		label_7 = new JLabel("性别");
		label_7.setBounds(312, 28, 72, 18);
		panel.add(label_7);

		id = new JLabel("");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(14, 77, 72, 18);
		panel.add(id);

		name = new JLabel("");
		name.setBounds(113, 77, 65, 18);
		panel.add(name);

		age = new JLabel("");
		age.setBounds(221, 77, 41, 18);
		panel.add(age);

		sex = new JLabel("");
		sex.setBounds(316, 77, 51, 18);
		panel.add(sex);

		panel_2 = new JPanel();
		panel_2.setLayout(null);

		tabbedPane.addTab("查看成绩", null, panel_2, null);

		JLabel lblNewLabel_1 = new JLabel("Java");
		lblNewLabel_1.setBounds(14, 31, 60, 18);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("C++");
		lblNewLabel_2.setBounds(14, 62, 60, 18);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("C");
		lblNewLabel_3.setBounds(14, 92, 60, 18);
		panel_2.add(lblNewLabel_3);

		JLabel label_10 = new JLabel("离散数学");
		label_10.setBounds(14, 123, 60, 18);
		panel_2.add(label_10);

		score_1 = new JLabel("");
		score_1.setBounds(100, 31, 72, 18);
		panel_2.add(score_1);

		score_2 = new JLabel("");
		score_2.setBounds(100, 62, 72, 18);
		panel_2.add(score_2);

		score_3 = new JLabel("");
		score_3.setBounds(100, 92, 72, 18);
		panel_2.add(score_3);

		label_12 = new JLabel("数据结构");
		label_12.setBounds(14, 154, 72, 18);
		panel_2.add(label_12);

		score_4 = new JLabel("");
		score_4.setBounds(100, 123, 72, 18);
		panel_2.add(score_4);

		score_5 = new JLabel("");
		score_5.setBounds(100, 154, 72, 18);
		panel_2.add(score_5);

		dtm = new DefaultTableModel(Data, ColName);
		dtm.setDataVector(Data, ColName);
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("账号", null, panel_1, null);

		JLabel label_8 = new JLabel("修改密码");
		label_8.setBounds(320, 13, 72, 18);
		panel_1.add(label_8);

		Up_pwd = new JTextField();
		Up_pwd.setBounds(309, 44, 86, 24);
		panel_1.add(Up_pwd);
		Up_pwd.setColumns(10);

		JLabel label_9 = new JLabel("请输入新密码");
		label_9.setBounds(180, 47, 115, 18);
		panel_1.add(label_9);

		JButton button = new JButton("Update");
		button.addActionListener(this);
		button.setBounds(409, 43, 96, 27);
		panel_1.add(button);

		JLabel label = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u5B66\u751F\u7248");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Dialog", Font.PLAIN, 32));
		label.setBounds(202, 13, 315, 34);
		contentPane.add(label);

		label_help = new JLabel("\u5E2E\u52A9\uFF1F");
		label_help.setBounds(594, 13, 45, 18);
		contentPane.add(label_help);

		label_1 = new JLabel("\u7CFB\u7EDF\u65F6\u95F4");
		label_1.setBounds(0, 0, 65, 18);
		contentPane.add(label_1);

		label_2 = new JLabel("");
		label_2.setBounds(63, 0, 121, 18);
		contentPane.add(label_2);
		label_help.addMouseListener(this);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(14, 120, 51, 18);
		contentPane.add(lblNewLabel);

		MyThread mt = new MyThread(label_2);

		WELCOME = new JLabel("同学，欢迎回来！");
		WELCOME.setBounds(14, 47, 147, 18);
		contentPane.add(WELCOME);

		JLabel label_11 = new JLabel("|");
		label_11.setBounds(639, 13, 8, 18);
		contentPane.add(label_11);

		label_EXIT = new JLabel("退出登陆");
		label_EXIT.setBounds(644, 13, 60, 18);
		contentPane.add(label_EXIT);
		label_EXIT.addMouseListener(this);

		Thread t = new Thread(mt);
		t.start();
		showData(ID);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		String command1 = (me.getComponent()).toString();
		if (command1.equals(label_EXIT.toString())) {
			int if_EXIT = JOptionPane.showConfirmDialog(null, "要退出当前登陆账号吗？");
			if (if_EXIT == 0) {
				this.setVisible(false);
				Login relogin = new Login();
				relogin.setVisible(true);
				relogin.get_identify_code();
				relogin.setVisible(true);
			}
		}
		if (command1.equals(label_help.toString())) {
			JOptionPane.showMessageDialog(null, "1.本地学生数据保存在目录C://MIS//lib下", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		String command1 = (me.getComponent()).toString();

		if (command1.equals(label_help.toString())) {
			label_help.setForeground(Color.blue);
		}
		if (command1.equals(label_EXIT.toString())) {
			label_EXIT.setForeground(Color.blue);
		}

	}

	@Override
	public void mouseExited(MouseEvent me) {
		String command1 = (me.getComponent()).toString();
		if (command1.equals(label_help.toString())) {
			label_help.setForeground(Color.black);
		}
		if (command1.equals(label_EXIT.toString())) {
			label_EXIT.setForeground(Color.black);
		}
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void showData(String ID) {

		BufferedReader bre = null;
		try {
			String file = "C:/MIS/lib/Student.txt";
			String str;
			bre = new BufferedReader(new FileReader(file));// 此时获取到的bre就是整个文件的缓存流

			ArrayList<String> arr = new ArrayList();

			while ((str = bre.readLine()) != null) // 判断最后一行不存在，为空结束循环
			{
				// 逐行读取文件放入ArrayList数组中
				arr.add(str);
			}
			bre.close();// 关闭流

			// 遍历arr中的字符串，获取学号子串和需要删除的学号比较
			for (int j = 0; j < arr.size(); j++) {
				if (ID.equals((arr.get(j).substring(0, 9)))) {
					String[] str1 = (arr.get(j)).split("\\s+");

					id.setText(str1[0]);
					name.setText(str1[1]);
					age.setText(str1[2]);
					sex.setText(str1[3]);
					score_1.setText(str1[4]);
					score_2.setText(str1[5]);
					score_3.setText(str1[6]);
					score_4.setText(str1[7]);
					score_5.setText(str1[8]);

					WELCOME.setText(str1[1] + "同学，欢迎回来！");
				}

			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		if (command.equals("Update")) {

			BufferedReader bre = null;
			try {
				String file = "C:/MIS/data/password.txt";
				String str;
				bre = new BufferedReader(new FileReader(file));// 此时获取到的bre就是整个文件的缓存流

				ArrayList<String> arr = new ArrayList();

				while ((str = bre.readLine()) != null) // 判断最后一行不存在，为空结束循环
				{
					// 逐行读取文件放入ArrayList数组中
					arr.add(str);
				}
				bre.close();// 关闭流

				// 遍历arr中的字符串，获取学号子串和需要删除的学号比较，不匹配的就覆盖写入文件
				FileWriter bw = null;
				bw = new FileWriter(file);
				for (int j = 0; j < arr.size(); j++) {
					if (!ID.equals((arr.get(j).substring(0, 9)))) {
						bw.write(arr.get(j) + "\n");
					} else {
						// 修改对应分数信息
						String[] str1 = (arr.get(j)).split("\\s+");
						if (!Up_pwd.getText().equals("")) {
							str1[1] = Up_pwd.getText();
							JOptionPane.showMessageDialog(null, "修改成功！");
							Up_pwd.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "密码为空！");
						}

						StringBuilder sb = new StringBuilder();
						for (int k = 0; k < str1.length; k++) {
							sb.append(str1[k] + " ");
						}
						sb.append("\n");
						bw.write(sb.toString());
					}
				}
				bw.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}

	}

	public void ShowData() {

		File bf = new File("C://MIS//lib//Student.txt");
		FileOutputStream os = null;
		if (!bf.exists()) {
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
			while ((data = br.readLine()) != null) {
				String[] str = data.split("\\s+");

				Vector row = new Vector();
				for (String s : str) {
					System.out.println(s);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}