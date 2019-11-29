
package com.student;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usernamefield;
	private JPasswordField passwordfield;
	private ArrayList al;
	private JRadioButton Student;
	private JRadioButton Teacher;
	private ButtonGroup Bg;
	private boolean flag = false;
	private String username_input;
	private String password_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		// 建立本地文件系统
		newFolder("C://MIS");
		newFolder("C://MIS//lib");
		newFolder("C://MIS//data");
		// 初次安装系统的初始化工作
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		usernamefield = new JTextField();
		usernamefield.setBounds(177, 63, 130, 26);
		contentPane.add(usernamefield);
		usernamefield.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("Adobe ���� Std L", Font.PLAIN, 32));
		lblNewLabel_1.setForeground(SystemColor.activeCaptionText);
		lblNewLabel_1.setBounds(72, 0, 313, 89);
		contentPane.add(lblNewLabel_1);

		JLabel username = new JLabel("UserName");
		username.setBounds(90, 67, 77, 16);
		username.setForeground(SystemColor.activeCaptionText);
		contentPane.add(username);

		JLabel password = new JLabel("Password");
		password.setBounds(90, 123, 77, 16);
		password.setForeground(SystemColor.activeCaptionText);
		contentPane.add(password);

		passwordfield = new JPasswordField();
		passwordfield.setBounds(177, 121, 130, 21);
		contentPane.add(passwordfield);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(88, 189, 117, 29);
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(241, 189, 117, 29);
		btnReset.addActionListener(this);
		contentPane.add(btnReset);

		Student = new JRadioButton("\u6211\u662F\u5B66\u751F");
		Student.setSelected(true);
		Student.setBounds(100, 153, 100, 27);
		contentPane.add(Student);

		Teacher = new JRadioButton("\u6211\u662F\u8001\u5E08");
		Teacher.setBounds(214, 153, 100, 27);
		contentPane.add(Teacher);

		Bg = new ButtonGroup();
		Bg.add(Teacher);
		Bg.add(Student);
	}

	public void actionPerformed(ActionEvent e) {

		String str = e.getActionCommand();

		if (str.equals("Login")) {

			username_input = usernamefield.getText();
			password_input = passwordfield.getText();
			// 教师登陆操作
			if (Teacher.isSelected()) {
				if (if_success(get_pwd_teacher(usernamefield.getText()))) {
					Index_Teacher m = new Index_Teacher(usernamefield.getText());
					m.setVisible(true);
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
			}
			// 学生登陆操作
			if (Student.isSelected()) {
				// 将输入框获得的帐号信息以传参的方式传入Index_Student类以便使用
				if (if_success(get_pwd(usernamefield.getText()))) {
					Index_Student m = new Index_Student(usernamefield.getText());
					m.setVisible(true);
					this.setVisible(false);
				} else {
					// 用户名或密码不匹配弹出错误信息
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
			}
		}
		// 重置登陆界面输入框的输入内容为空，以重新输入
		if (str.equals("Reset")) {
			usernamefield.setText("");
			passwordfield.setText("");
		}
	}

	// 该方法将被调用，用来创建系统依赖的文件系统
	public void newFolder(String rootPath) {
		File dir = new File(rootPath);
		if (!dir.exists())
			dir.mkdir();
	}

	// 该方法用来判断登陆是否成功，返回布尔值
	public boolean if_success(String password) {
		boolean if_success = false;
		if (password_input.equals(password)) {
			if_success = true;
		}

		return if_success;
	}

	// 该方法用来获取本地保存的密码信息
	public String get_pwd(String username) {

		File bf = new File("C://MIS//data//password.txt");
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
			br = new BufferedReader(new InputStreamReader(new FileInputStream("C://MIS//data//password.txt")));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String data = null;
		String password = null;
		String[] str = null;

		try {
			while ((data = br.readLine()) != null) {
				str = data.split("\\s+");
				if (str[0].equals(username)) {
					password = str[1];
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	public String get_pwd_teacher(String username) {

		File bf = new File("C://MIS//data//order.txt");
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
			br = new BufferedReader(new InputStreamReader(new FileInputStream("C://MIS//data//order.txt")));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String data = null;
		String password = null;
		String[] str = null;

		try {
			while ((data = br.readLine()) != null) {
				str = data.split("\\s+");
				if (str[0].equals(username)) {
					password = str[1];
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	public void init() {
		File bf1 = new File("C://MIS//lib//Student.txt");
		if (!bf1.exists()) {
			try {
				bf1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		File bf2 = new File("C://MIS//data//password.txt");
		if (!bf2.exists()) {
			try {
				bf2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		File bf3 = new File("C://MIS//data//order.txt");
		if (!bf3.exists()) {
			try {
				bf3.createNewFile();

				FileWriter bw = null;
				bw = new FileWriter("C://MIS//data//order.txt");
				bw.write("T01 123\n");

				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
