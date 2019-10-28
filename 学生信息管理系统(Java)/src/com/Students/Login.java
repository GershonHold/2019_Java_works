
package com.Students;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usernamefield;
	private JPasswordField passwordfield;
	private ArrayList al;
	private JRadioButton Student;
	private JRadioButton Teacher;
	private ButtonGroup Bg;

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
		
		newFolder("C://MIS");
		newFolder("C://MIS//lib");
		al = new ArrayList(); 
		User u1=new User("Bob","123456");
		User u2=new User("David","123456");
		al.add(u1);
		al.add(u2);
		
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
		lblNewLabel_1.setBounds(100, 0, 255, 89);
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
		
		Bg=new ButtonGroup();                                  
	      Bg.add(Teacher);                                
	      Bg.add(Student);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		if (str.equals("Login")) {
		
		String username=usernamefield.getText();
		String password=passwordfield.getText();
		
		User u=new User(username,password);
//		boolean flag=validUser(al,u);
		boolean flag=false;
		if(usernamefield.getText().equals(u.getUsername())&&passwordfield.getText().equals(u.getPassword())) {
			flag=true;
		}
		if(flag) {
			if(Teacher.isSelected()) {
				Index_Teacher m=new Index_Teacher();
				m.setVisible(true);
				this.setVisible(false);
		}
		
			if(Student.isSelected()) {
				Index_Student m=new Index_Student(usernamefield.getText());
				m.setVisible(true);
				this.setVisible(false);
			}
		}
		else{
			
			JOptionPane.showMessageDialog(null, "用户名或密码错误");
		}
		}else if(str.equals("Reset")) {
			usernamefield.setText("");
			passwordfield.setText("");
		}
		
}
	
	public void newFolder(String rootPath){
        File dir=new File(rootPath);
        if(!dir.exists())
            dir.mkdir();
    }

	private boolean validUser(ArrayList al2, User u) {
				return false;
	}
	}
