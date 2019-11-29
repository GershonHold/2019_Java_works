package com.student;

import java.awt.Color;
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
import java.io.RandomAccessFile;
import java.util.ArrayList;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Index_Teacher extends JFrame implements ActionListener, MouseListener {

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
	private JTextField tAddScore1;
	private JButton btnAdd;
	private JTextField tDelID;
	private JPanel pDel;
	private JLabel lDelName;
	private JTextField tDelName;
	private JButton btnDel;
	private JPanel pUp;
	private DefaultTableModel dtm;
	private JButton btnUp;
	private JLabel lblSex;
	private JLabel lblScore;
	private String command;
	private JLabel label;
	private JLabel label_1;
	private FileReader fr;
	private JTextField getDelID;
	private JTextField Upt_ID;
	private JLabel lblJava;
	private JLabel lblC;
	private JLabel lblC_1;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField Upt_1;
	private JTextField Upt_2;
	private JTextField Upt_3;
	private JTextField Upt_4;
	private JTextField Upt_5;
	private JLabel lblC_2;
	private JLabel lblC_3;
	private JLabel label_4;
	private JTextField tAddScore2;
	private JTextField tAddScore3;
	private JTextField tAddScore4;
	private JTextField tAddScore5;
	private JLabel label_5;
	private JPanel p_pwd_Up;
	private JLabel label_8;
	private JTextField Up_order;
	private JLabel label_9;
	private JButton btnChange;
	private static String ID;
	private JPanel p_add_adminer;
	private JTextField Add_account;
	private JTextField Add_order;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Index_Teacher frame = new Index_Teacher(ID);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Index_Teacher(String ID) {

		this.ID = ID;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 456);
		setLocation(442, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Data = new Vector();

		ColName = new Vector();
		ColName.add("ID");
		ColName.add("name");
		ColName.add("age");
		ColName.add("sex");
		ColName.add("Java");
		ColName.add("C++");
		ColName.add("C");
		ColName.add("离散数学");
		ColName.add("数据结构");
		ShowData();

		dtm = new DefaultTableModel(Data, ColName);
		dtm.setDataVector(Data, ColName);
		contentPane.setLayout(null);

		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 187, 704, 209);
		contentPane.add(scrollPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 45, 704, 142);
		contentPane.add(tabbedPane);

		pAdd = new JPanel();
		tabbedPane.addTab("录入学生信息", pAdd);
		pAdd.setLayout(null);

		lAddName = new JLabel("Name");
		lAddName.setBounds(106, 11, 40, 18);
		pAdd.add(lAddName);

		tAddName = new JTextField();
		tAddName.setBounds(149, 8, 50, 24);
		tAddName.setColumns(8);
		pAdd.add(tAddName);

		lAddAge = new JLabel("Age");
		lAddAge.setBounds(202, 14, 24, 18);
		pAdd.add(lAddAge);

		tAddAge = new JTextField();
		tAddAge.setBounds(240, 11, 50, 24);
		tAddAge.setColumns(8);
		pAdd.add(tAddAge);

		btnAdd = new JButton("add");
		btnAdd.setBounds(618, 7, 57, 27);
		btnAdd.addActionListener(this);

		lblSex = new JLabel("Sex");
		lblSex.setBounds(319, 11, 24, 18);
		pAdd.add(lblSex);

		tAddSex = new JTextField();
		tAddSex.setBounds(374, 8, 50, 24);
		pAdd.add(tAddSex);
		tAddSex.setColumns(8);

		lblScore = new JLabel("Java");
		lblScore.setBounds(0, 66, 40, 18);
		pAdd.add(lblScore);

		tAddScore1 = new JTextField();
		tAddScore1.setBounds(37, 63, 50, 24);
		pAdd.add(tAddScore1);
		tAddScore1.setColumns(8);
		pAdd.add(btnAdd);

		tAddID = new JTextField();
		tAddID.setColumns(8);
		tAddID.setBounds(37, 8, 50, 24);
		pAdd.add(tAddID);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(0, 14, 24, 18);
		pAdd.add(lblId);

		lblC_2 = new JLabel("C++");
		lblC_2.setBounds(101, 66, 32, 18);
		pAdd.add(lblC_2);

		lblC_3 = new JLabel("C");
		lblC_3.setBounds(207, 66, 32, 18);
		pAdd.add(lblC_3);

		label_4 = new JLabel("离散数学");
		label_4.setBounds(304, 66, 68, 18);
		pAdd.add(label_4);

		tAddScore2 = new JTextField();
		tAddScore2.setBounds(149, 63, 50, 24);
		pAdd.add(tAddScore2);
		tAddScore2.setColumns(10);

		tAddScore3 = new JTextField();
		tAddScore3.setColumns(10);
		tAddScore3.setBounds(240, 63, 50, 24);
		pAdd.add(tAddScore3);

		tAddScore4 = new JTextField();
		tAddScore4.setColumns(10);
		tAddScore4.setBounds(374, 63, 50, 24);
		pAdd.add(tAddScore4);

		tAddScore5 = new JTextField();
		tAddScore5.setColumns(10);
		tAddScore5.setBounds(502, 63, 50, 24);
		pAdd.add(tAddScore5);

		label_5 = new JLabel("数据结构");
		label_5.setBounds(432, 66, 72, 18);
		pAdd.add(label_5);

		pDel = new JPanel();
		tabbedPane.addTab("删除学生信息", null, pDel, null);
		pDel.setLayout(null);

		lDelName = new JLabel("请输入学生ID");
		lDelName.setBounds(189, 48, 105, 18);
		pDel.add(lDelName);

		btnDel = new JButton("Delete");
		btnDel.setBounds(391, 44, 81, 27);
		btnDel.addActionListener(this);
		pDel.add(btnDel);

		getDelID = new JTextField();
		getDelID.setBounds(291, 45, 86, 24);
		pDel.add(getDelID);
		getDelID.setColumns(10);
		btnDel.addActionListener(this);

		pUp = new JPanel();
		tabbedPane.addTab("更新分数信息", null, pUp, null);

		btnUp = new JButton("Update");
		btnUp.setBounds(544, 44, 81, 27);
		btnUp.addActionListener(this);
		pUp.setLayout(null);

		JLabel lblNewLabel = new JLabel("学生ID");
		lblNewLabel.setBounds(14, 9, 57, 18);
		pUp.add(lblNewLabel);
		pUp.add(btnUp);

		Upt_ID = new JTextField();
		Upt_ID.setBounds(66, 6, 86, 24);
		pUp.add(Upt_ID);
		Upt_ID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(156, 9, 72, 18);
		pUp.add(lblNewLabel_1);

		lblJava = new JLabel("Java");
		lblJava.setBounds(14, 48, 41, 18);
		pUp.add(lblJava);

		lblC = new JLabel("C++");
		lblC.setBounds(14, 79, 41, 18);
		pUp.add(lblC);

		lblC_1 = new JLabel("C");
		lblC_1.setBounds(166, 48, 57, 18);
		pUp.add(lblC_1);

		label_6 = new JLabel("离散数学");
		label_6.setBounds(163, 79, 81, 18);
		pUp.add(label_6);

		label_7 = new JLabel("数据结构");
		label_7.setBounds(331, 48, 81, 18);
		pUp.add(label_7);

		Upt_1 = new JTextField();
		Upt_1.setBounds(66, 45, 86, 24);
		pUp.add(Upt_1);
		Upt_1.setColumns(10);

		Upt_2 = new JTextField();
		Upt_2.setBounds(66, 76, 86, 24);
		pUp.add(Upt_2);
		Upt_2.setColumns(10);

		Upt_3 = new JTextField();
		Upt_3.setBounds(231, 45, 86, 24);
		pUp.add(Upt_3);
		Upt_3.setColumns(10);

		Upt_4 = new JTextField();
		Upt_4.setBounds(231, 76, 86, 24);
		pUp.add(Upt_4);
		Upt_4.setColumns(10);

		Upt_5 = new JTextField();
		Upt_5.setBounds(401, 45, 86, 24);
		pUp.add(Upt_5);
		Upt_5.setColumns(10);

		p_pwd_Up = new JPanel();
		p_pwd_Up.setLayout(null);
		tabbedPane.addTab("修改管理员口令", null, p_pwd_Up, null);

		label_8 = new JLabel("修改口令");
		label_8.setBounds(320, 13, 72, 18);
		p_pwd_Up.add(label_8);

		Up_order = new JTextField();
		Up_order.setColumns(10);
		Up_order.setBounds(309, 44, 86, 24);
		p_pwd_Up.add(Up_order);

		label_9 = new JLabel("请输入新口令");
		label_9.setBounds(180, 47, 115, 18);
		p_pwd_Up.add(label_9);

		btnChange = new JButton("Submit");
		btnChange.addActionListener(this);
		btnChange.setBounds(409, 43, 96, 27);
		btnChange.addActionListener(this);
		p_pwd_Up.add(btnChange);

		p_add_adminer = new JPanel();
		p_add_adminer.setLayout(null);
		tabbedPane.addTab("添加管理员账号", null, p_add_adminer, null);

		JLabel label_10 = new JLabel("添加管理员");
		label_10.setBounds(285, 13, 87, 18);
		p_add_adminer.add(label_10);

		JLabel label_11 = new JLabel("设置管理员编号");
		label_11.setBounds(141, 38, 105, 18);
		p_add_adminer.add(label_11);

		JLabel label_12 = new JLabel("设置管理员口令");
		label_12.setBounds(141, 66, 114, 18);
		p_add_adminer.add(label_12);

		Add_account = new JTextField();
		Add_account.setBounds(281, 35, 86, 24);
		p_add_adminer.add(Add_account);
		Add_account.setColumns(10);

		Add_order = new JTextField();
		Add_order.setBounds(281, 63, 86, 24);
		p_add_adminer.add(Add_order);
		Add_order.setColumns(10);

		label = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u6559\u5E08\u7248");
		label.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 32));
		label.setBounds(218, 13, 319, 34);
		contentPane.add(label);

		label_1 = new JLabel("\u5E2E\u52A9\uFF1F");
		label_1.setBounds(634, 14, 56, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(67, 0, 126, 18);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("系统时间");
		label_3.setBounds(0, 0, 66, 18);
		contentPane.add(label_3);
		label_1.addMouseListener(this);

		MyThread mt2 = new MyThread(label_2);
		Thread t = new Thread(mt2);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		Vector row = new Vector();
		if (command.equals("add")) {
			if (tAddName.getText() != null && tAddAge.getText() != null && tAddSex.getText() != null
					&& tAddScore1.getText() != null) {
				String addID = tAddID.getText();
				String addName = tAddName.getText();
				String addAge = tAddAge.getText();
				String addSex = tAddSex.getText();
				String addScore1 = tAddScore1.getText();
				String addScore2 = tAddScore2.getText();
				String addScore3 = tAddScore3.getText();
				String addScore4 = tAddScore4.getText();
				String addScore5 = tAddScore5.getText();

				if (!(addID.equals("")) && !(addName.equals("")) && !(addAge.equals("")) && !(addSex.equals(""))
						&& !(addScore1.equals("")) && !(addScore2.equals("")) && !(addScore3.equals(""))
						&& !(addScore4.equals("")) && !(addScore5.equals(""))) {
					Outputdata(addID);
					Outputdata(addName);
					Outputdata(addAge);
					Outputdata(addSex);
					Outputdata(addScore1);
					Outputdata(addScore2);
					Outputdata(addScore3);
					Outputdata(addScore4);
					Outputdata(addScore5);

					Outputpassword(addID + " 123" + "\n");

					RandomAccessFile raf = null;
					try {
						raf = new RandomAccessFile(new File("C://MIS//lib//Student.txt"), "rw");
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
					row.add(addScore1);
					row.add(addScore2);
					row.add(addScore3);
					row.add(addScore4);
					row.add(addScore5);

					Data.add(row);
					dtm.setDataVector(Data, ColName);
					tAddID.setText("");
					tAddName.setText("");
					tAddAge.setText("");
					tAddSex.setText("");
					tAddScore1.setText("");
					tAddScore2.setText("");
					tAddScore3.setText("");
					tAddScore4.setText("");
					tAddScore5.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "您未输入信息或者信息不完整", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		String delID = getDelID.getText();
		Object n = null, obj = null;
		Vector v;
		if (command.equals("Delete")) {
			if (!(delID.equals(""))) {

				for (int i = 0; i < Data.size(); i++) {
					obj = Data.get(i);
					v = (Vector) obj;
					n = v.get(0);

					String rowDataName = String.valueOf(n);
					if (delID.equals(rowDataName)) {
						System.out.println(delID);
						Data.remove(obj);
						dtm.setDataVector(Data, ColName);

						// 后台数据删除
						// 删除信息
						String file_lib = "C:/MIS/lib/Student.txt";
						String file_password = "C:/MIS/data/password.txt";
						del_data(file_lib, delID);
						del_data(file_password, delID);
					}
				}

			}
			getDelID.setText("");
		}

		if (command.equals("Update")) {
			String Upt_id = Upt_ID.getText();

			if (!(Upt_id.equals(""))) {
				for (int i = 0; i < Data.size(); i++) {
					obj = Data.get(i);
					v = (Vector) obj;
					n = v.get(0);

					String rowDataName = String.valueOf(n);
					if (Upt_id.equals(rowDataName)) {
						System.out.println(Upt_id);
						Data.remove(obj);
						dtm.setDataVector(Data, ColName);

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

							// 遍历arr中的字符串，获取学号子串和需要删除的学号比较，不匹配的就覆盖写入文件
							FileWriter bw = null;
							bw = new FileWriter(file);
							for (int j = 0; j < arr.size(); j++) {
								if (!Upt_id.equals((arr.get(j).substring(0, 9)))) {
									bw.write(arr.get(j) + "\n");
								} else {
									// 修改对应分数信息
									String[] str1 = (arr.get(j)).split("\\s+");
									if (!(Upt_1.getText().equals(""))) {
										str1[4] = Upt_1.getText();
									}
									if (!(Upt_2.getText().equals(""))) {
										str1[5] = Upt_2.getText();
									}
									if (!(Upt_3.getText().equals(""))) {
										str1[6] = Upt_3.getText();
									}
									if (!(Upt_4.getText().equals(""))) {
										str1[7] = Upt_4.getText();
									}
									if (!(Upt_5.getText().equals(""))) {
										str1[8] = Upt_5.getText();
									}

									StringBuilder sb = new StringBuilder();
									for (int k = 0; k < str1.length; k++) {
										sb.append(str1[k] + " ");
									}
									sb.append("\n");
									bw.write(sb.toString());

									row.add(str1[0]);
									row.add(str1[1]);
									row.add(str1[2]);
									row.add(str1[3]);
									row.add(str1[4]);
									row.add(str1[5]);
									row.add(str1[6]);
									row.add(str1[7]);
									row.add(str1[8]);
									Data.add(row);
								}
							}
							bw.close();
						} catch (Exception e2) {
							e2.getStackTrace();
						}
					}
				}

			}
			Upt_ID.setText("");
			Upt_1.setText("");
			Upt_2.setText("");
			Upt_3.setText("");
			Upt_4.setText("");
			Upt_5.setText("");

		}
		if (command.equals("Submit")) {
			BufferedReader bre = null;
			try {
				String file = "C:/MIS/data/order.txt";
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
					if (!ID.equals((arr.get(j).substring(0, 3)))) {
						bw.write(arr.get(j) + "\n");
					} else {
						String[] str1 = (arr.get(j)).split("\\s+");
						if (!Up_order.getText().equals("")) {
							str1[1] = Up_order.getText();
							JOptionPane.showMessageDialog(null, "修改成功！");
							Up_order.setText("");
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
			raf = new RandomAccessFile(new File("C://MIS//lib//Student.txt"), "rw");
			try {
				raf.seek(raf.length());
				raf.write((str + " ").getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf == null) {
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
					row.add(s);
				}
				Data.add(row);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Outputpassword(String str) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(new File("C://MIS//data//password.txt"), "rw");
			try {
				raf.seek(raf.length());
				raf.write((str).getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf == null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void del_data(String file, String delID) {
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

			// 遍历arr中的字符串，获取学号子串和需要删除的学号比较，不匹配的就覆盖写入文件
			FileWriter bw = null;
			bw = new FileWriter(file);
			for (int j = 0; j < arr.size(); j++) {
				if (!delID.equals((arr.get(j).substring(0, 9))))
					bw.write(arr.get(j) + "\n");
			}

//		String[] str1 = (arr.get(2)).split("\\s+");
			bw.close();
		} catch (Exception e2) {
			e2.getStackTrace();
		}
	}
}
