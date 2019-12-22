package com.student;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import com.student.CodeUtil;
public class Login extends JFrame implements ActionListener, MouseListener {
	private JPanel contentPane;
	JTextField usernamefield;
	private JPasswordField passwordfield;
	private ArrayList al;
	private JRadioButton Student;
	private JRadioButton Teacher;
	private ButtonGroup Bg;
	private boolean flag = false;
	private String username_input;
	private String password_input;
	private JTextField GET_IDENTIFY_CODE;
	private String identify_code;
	private JLabel label_1 ;
	private JLabel IDENTIFY_CODE;
	private ImageIcon img;
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
		newFolder("C://MIS//data//Image");
		// 初次安装系统的初始化工作
		init();
		CodeUtil uc=new CodeUtil();
		identify_code=uc.make_identify_code();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 435);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		usernamefield = new JTextField();
		usernamefield.setBounds(278, 117, 130, 26);
		usernamefield.setBackground(Color.WHITE);
		contentPane.add(usernamefield);
		usernamefield.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setBounds(155, 24, 313, 89);
		lblNewLabel_1.setFont(new Font("Adobe ���� Std L", Font.PLAIN, 32));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		contentPane.add(lblNewLabel_1);

		JLabel username = new JLabel("UserName");
		username.setBounds(170, 117, 77, 16);
		username.setForeground(SystemColor.activeCaptionText);
		contentPane.add(username);

		JLabel password = new JLabel("Password");
		password.setBounds(170, 166, 77, 16);
		password.setForeground(Color.BLACK);
		contentPane.add(password);

		passwordfield = new JPasswordField();
		passwordfield.setBounds(278, 164, 130, 21);
		passwordfield.setBackground(Color.WHITE);
		contentPane.add(passwordfield);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(151, 339, 117, 29);
		btnLogin.setForeground(Color.MAGENTA);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(291, 339, 117, 29);
		btnReset.setForeground(Color.MAGENTA);
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(this);
		contentPane.add(btnReset);

		Student = new JRadioButton("\u6211\u662F\u5B66\u751F");
		Student.setBounds(168, 207, 100, 27);
		Student.setForeground(Color.BLUE);
		Student.setSelected(true);
		contentPane.add(Student);

		Teacher = new JRadioButton("\u6211\u662F\u8001\u5E08");
		Teacher.setBounds(280, 207, 100, 27);
		Teacher.setForeground(Color.MAGENTA);
		contentPane.add(Teacher);

		Bg = new ButtonGroup();
		Bg.add(Teacher);
		Bg.add(Student);
		
		JLabel label = new JLabel("请输入验证码进行验证");
		label.setBounds(155, 242, 185, 18);
		contentPane.add(label);
		
		 img = new ImageIcon("C://MIS//data/Image/code_image.jpg");
		 IDENTIFY_CODE = new JLabel();
		 IDENTIFY_CODE.setBackground(Color.WHITE);
		 IDENTIFY_CODE.setBounds(290, 273, 90, 53);
		 IDENTIFY_CODE.setIcon(img);
		contentPane.add(IDENTIFY_CODE);
		this.getLayeredPane().add(IDENTIFY_CODE, new Integer(Integer.MIN_VALUE));
		
		GET_IDENTIFY_CODE = new JTextField();
		GET_IDENTIFY_CODE.setBounds(170, 286, 86, 24);
		contentPane.add(GET_IDENTIFY_CODE);
		GET_IDENTIFY_CODE.setColumns(10);
		
		label_1 = new JLabel("看不清! 给我换！");
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(396, 289, 130, 18);
		label_1.addMouseListener(this);
		contentPane.add(label_1);
		
		setBack();
	}

	public void actionPerformed(ActionEvent e) {

		String str = e.getActionCommand();

		if (str.equals("Login")) {

			username_input = usernamefield.getText();
			password_input = passwordfield.getText();
			// 教师登陆操作
			if (Teacher.isSelected()) {
				if (if_success(get_pwd_teacher(usernamefield.getText()))&&if_code_right(identify_code)) {
					Index_Teacher m = new Index_Teacher(usernamefield.getText());
					m.setVisible(true);
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "用户名、密码或验证码错误");
					get_identify_code();
					GET_IDENTIFY_CODE.setText("");
				}
			}
			// 学生登陆操作
			if (Student.isSelected()) {
				// 将输入框获得的帐号信息以传参的方式传入Index_Student类以便使用
				if (if_success(get_pwd(usernamefield.getText()))&&if_code_right(identify_code)) {
					Index_Student m = new Index_Student(usernamefield.getText());
					m.setVisible(true);
					this.setVisible(false);
				} else {
					// 用户名或密码不匹配弹出错误信息
					JOptionPane.showMessageDialog(null, "用户名、密码或验证码错误");
					get_identify_code();
					GET_IDENTIFY_CODE.setText("");
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
    
public boolean if_code_right(String str) {
	boolean if_success=false;
	if(str.equals(GET_IDENTIFY_CODE.getText())) {
		if_success=true;
	}
	return if_success;
}

@Override
public void mouseClicked(MouseEvent e) {
	String command1 = (e.getComponent()).toString();
	if (command1.equals(label_1.toString())) {
		get_identify_code();
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
public void get_identify_code() {
	CodeUtil uc=new CodeUtil();
	identify_code=uc.make_identify_code();
	img = new ImageIcon("C://MIS//data/Image/code_image.jpg");
	img.getImage().flush();
	IDENTIFY_CODE.setIcon(img);
}
//设置背景
public void setBack() {
    ((JPanel) this.getContentPane()).setOpaque(false);
    ImageIcon img = new ImageIcon(Login.class.getResource("/OK.png"));
    JLabel background = new JLabel(img);
    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
    background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
}
}