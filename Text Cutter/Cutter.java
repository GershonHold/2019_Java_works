/**
 * 
 */
package com.TextCutter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


/**
 
 * @version 2019年9月17日上午1:06:16
 * @author 何广深
 *
 * 
 */
public class Cutter extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField roadfield;
	private TextArea textArea;
	private String path;
	private int response;
	private Object[] options= new Object[]{"确定","取消","帮助"};
	private String rootPath="C://Cutter";
	private String filename="File_";
	private String order="1";
	private int ordernum=1;
	private JLabel lblNewLabel_3;
	private int per=100;
	private String str;
	private String str1;
	private int index=0;
	private int endindex=0;
	private boolean flag=true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cutter frame = new Cutter();
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
	public Cutter() {
		setTitle("\u6587\u672C\u5206\u5272\u56681.0");
		
		//创建总目录
		newFolder(rootPath);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 504);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		roadfield = new JTextField();
		roadfield.setBounds(77, 80, 414, 26);
		contentPane.add(roadfield);
		roadfield.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6587\u672C\u8DEF\u5F84");
		label_1.setBounds(21, 85, 58, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6587\u672C\u5206\u5272\u5668");
		label_2.setBounds(204, 10, 122, 15);
		label_2.setFont(new Font("汉仪柏青体简", Font.PLAIN, 24));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8BF7\u7C98\u8D34\u6587\u672C\u4E8E\u6B64");
		label_3.setBounds(21, 113, 98, 15);
		contentPane.add(label_3);
		
		textArea=new TextArea();
		textArea.setBounds(24, 137, 482, 87);
		textArea.setForeground(Color.BLACK);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB\u5206\u5272");
		btnNewButton.setBounds(211, 239, 97, 23);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		JButton File_Road = new JButton("\u00B7\u00B7\u00B7");
		File_Road.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		File_Road.setBounds(489, 79, 17, 27);
		File_Road.addActionListener(this);
		contentPane.add(File_Road);
		
		JLabel lbltxt = new JLabel("\u8BF7\u9009\u62E9\u6587\u672C\u8DEF\u5F84\u6216\u8005\u76F4\u63A5\u7C98\u8D34\u6587\u672C");
		lbltxt.setBounds(21, 55, 197, 15);
		contentPane.add(lbltxt);
		
		JLabel label_4 = new JLabel("\u8BF4\u660E\uFF1A");
		label_4.setToolTipText("");
		label_4.setBounds(21, 289, 58, 15);
		contentPane.add(label_4);
		
		JLabel lblNewLabel = new JLabel("\u5EFA\u8BAE\u5728\u89C6\u56FE\u4E2D\u9009\u62E9\u6587\u4EF6\uFF0C\u624B\u52A8\u8F93\u5165\u8DEF\u5F84\u51FA\u73B0\u9519\u8BEF\u53EF\u80FD\u5BFC\u81F4\u65E0\u6CD5\u627E\u5230\u5F85\u5206\u5272\u6587\u4EF6");
		lblNewLabel.setBounds(21, 314, 506, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(21, 328, 367, 15);
		contentPane.add(label_5);
		
		JLabel lblAllRights = new JLabel("Written By Hgs of NJUPT");
		lblAllRights.setFont(new Font("宋体", Font.PLAIN, 8));
		lblAllRights.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllRights.setBounds(24, 425, 494, 19);
		contentPane.add(lblAllRights);
		
		JLabel lblAllRightsReserved = new JLabel("All Rights Reserved");
		lblAllRightsReserved.setFont(new Font("宋体", Font.PLAIN, 8));
		lblAllRightsReserved.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllRightsReserved.setBounds(24, 442, 494, 15);
		contentPane.add(lblAllRightsReserved);
		
		JLabel lblNewLabel_1 = new JLabel("\u5206\u5272\u5B8C\u6210\u540E\uFF0C\u5206\u5272\u6240\u5F97\u6587\u4EF6\u4FDD\u5B58\u5728C://Cutter\u76EE\u5F55\u4E0B");
		lblNewLabel_1.setBounds(21, 353, 405, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(\u8BF7\u5BFC\u5165txt\u6587\u6863\u54E6\uFF01)");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(220, 55, 271, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u5E2E\u52A9");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(474, 230, 64, 26);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(this);
		 
		JButton parameter = new JButton("\u81EA\u5B9A\u4E49\u53C2\u6570");
		parameter.setBounds(396, 51, 110, 23);
		contentPane.add(parameter);
		parameter.addActionListener(this);
	}
	
	public void newFolder(String rootPath){
         File dir=new File(rootPath);
         if(!dir.exists())
             dir.mkdir();
     } 
	
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String command=e.getActionCommand();
	if(command.equalsIgnoreCase("开始分割")){
		
		if(flag) {
			str = textArea.getText();
			if(per>str.length()) {
				str1=str;
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(("C://Cutter//"+filename+order+".txt"));
					fos.write(str1.getBytes());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ordernum++;
				order=Integer.toString(ordernum);
			}else {
				
				while(endindex<str.length()) {
				endindex=endindex+per;
				
				if(endindex>str.length()) {
					endindex=str.length();
				}
				str1=str.substring(index,endindex);
				index=index+per;
				
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(("C://Cutter//"+filename+order+".txt"));
					fos.write(str1.getBytes());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ordernum++;
				order=Integer.toString(ordernum);
				}
			}
				
				JOptionPane.showMessageDialog(null, "文本分割成功！", "文本分割器", JOptionPane.INFORMATION_MESSAGE);
				}else {
					System.out.println("ss");
				try {
					InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "UTF-8");
					char []cbuf=new char[per];
					int i=0;
					while((i=isr.read(cbuf))!=-1) {
						String str=new String(cbuf,0,i);
						FileOutputStream fos;
						try {
			
							fos = new FileOutputStream(("C://Cutter//"+filename+order+".txt"));
							fos.write(str.getBytes());
							ordernum++;
							order=Integer.toString(ordernum);
				
		} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		}
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "分割成功！", "文本分割器", JOptionPane.INFORMATION_MESSAGE);
		
	}}else if(command.equals("···")){
		
	JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File file=jfc.getSelectedFile();
		if(file.isDirectory()){
			System.out.println("文件夹:"+file.getAbsolutePath());
		}else if(file.isFile()){
			System.out.println("文件:"+file.getAbsolutePath());
		}
		System.out.println(jfc.getSelectedFile().getName());
		path=file.getAbsolutePath();
		roadfield.setText(path);
		textArea.setEditable(false);
		textArea.setText("您已选择文件，无法添加文本！");
		flag=false;
		
}else if(command.equalsIgnoreCase("自定义参数")) {
	String input1=JOptionPane.showInputDialog(this, "请输入每次拆分到文档字符数:", 100);
	per=Integer.parseInt(input1);
}
	}

	@Override
	public void mouseClicked(MouseEvent e){
		JOptionPane.showMessageDialog(null, "1.建议在视图中选择文件，手动输入路径出现错误可能导致无法找到待分割文件\n2.分割完成后，分割所得文件保存在C://Cutter目录下\n3.当发现多次分割出现异常时，请重启重新分割", "帮助", JOptionPane.INFORMATION_MESSAGE);
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
		lblNewLabel_3.setForeground(Color.blue);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		lblNewLabel_3.setForeground(Color.black);
	}
}