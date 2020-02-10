/**
 * 
 */
package com.subpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 
 * @version 2020年2月10日下午11:43:51
 * @author Gershon
 *
 * 
 */
public class Java_SubPage extends JFrame {

	private JPanel contentPane;
	private int compre_stren_score;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Java_SubPage frame = new Java_SubPage();
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
	public Java_SubPage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//这里改为HIDE_ON_CLOSE防止该窗口点击关闭导致主窗口也被关闭
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);//居中显示窗口
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourselfTodayAnd = new JLabel("Your Java Today And Before");
		lblYourselfTodayAnd.setFont(new Font("Monotype Corsiva", Font.PLAIN, 21));
		lblYourselfTodayAnd.setBounds(14, 32, 388, 18);
		contentPane.add(lblYourselfTodayAnd);
		
		JLabel compre_stren = new JLabel("综合实力");
		compre_stren.setFont(new Font("Adobe 宋体 Std L", Font.PLAIN, 15));
		compre_stren.setBounds(14, 82, 72, 18);
		contentPane.add(compre_stren);
		
		int source_code_score=5;
		int base_score=50;
		int java_web_score=10;
		int android_score=60;//安卓为本人非重点内容故不参与综合实力评分
		compre_stren_score = (source_code_score+base_score+java_web_score)/3;
		
		final JProgressBar progressBar1 = new JProgressBar();
		progressBar1.setLocation(81, 82);
		progressBar1.setOrientation(JProgressBar.HORIZONTAL);
		progressBar1.setSize(200, 18);
		progressBar1.setMinimum(0);
		progressBar1.setMaximum(100);
		progressBar1.setValue(compre_stren_score);
		progressBar1.setString(Integer.toString(compre_stren_score));
		progressBar1.setStringPainted(true);
		
	    contentPane.add(progressBar1);
	    
	    JLabel JAVA = new JLabel("Java源码");
	    JAVA.setBounds(14, 126, 72, 18);
	    JAVA.setFont(new Font("Adobe 宋体 Std L", Font.PLAIN, 15));
	    contentPane.add(JAVA);
	    
	    JProgressBar progressBar2 = new JProgressBar();
	    progressBar2.setValue(source_code_score);
	    progressBar2.setStringPainted(true);
	    progressBar2.setString(Integer.toString(source_code_score));
	    progressBar2.setOrientation(SwingConstants.HORIZONTAL);
	    progressBar2.setMinimum(0);
	    progressBar2.setMaximum(100);
	    progressBar2.setBounds(81, 126, 200, 18);
	    contentPane.add(progressBar2);
	    
	    JLabel BASE = new JLabel("基础知识");
	    BASE.setBounds(14, 174, 72, 18);
	    BASE.setFont(new Font("Adobe 宋体 Std L", Font.PLAIN, 15));
	    contentPane.add(BASE);
	    
	    JProgressBar progressBar3 = new JProgressBar();
	    progressBar3.setValue(base_score);
	    progressBar3.setStringPainted(true);
	    progressBar3.setString(Integer.toString(base_score));
	    progressBar3.setOrientation(SwingConstants.HORIZONTAL);
	    progressBar3.setMinimum(0);
	    progressBar3.setMaximum(100);
	    progressBar3.setBounds(81, 174, 200, 18);
	    contentPane.add(progressBar3);
	    
	    JLabel JAVAWEB = new JLabel("JavaWeb");
	    JAVAWEB.setBounds(14, 216, 72, 18);
	    JAVAWEB.setFont(new Font("Adobe 宋体 Std L", Font.PLAIN, 15));
	    contentPane.add(JAVAWEB);
	    
	    JProgressBar progressBar4 = new JProgressBar();
	    progressBar4.setValue(java_web_score);
	    progressBar4.setStringPainted(true);
	    progressBar4.setString(Integer.toString(java_web_score));
	    progressBar4.setOrientation(SwingConstants.HORIZONTAL);
	    progressBar4.setMinimum(0);
	    progressBar4.setMaximum(100);
	    progressBar4.setBounds(81, 216, 200, 18);
	    contentPane.add(progressBar4);
	    
	    JLabel ANDROID = new JLabel("Android");
	    ANDROID.setBounds(14, 258, 72, 18);
	    ANDROID.setFont(new Font("Adobe 宋体 Std L", Font.PLAIN, 15));
	    contentPane.add(ANDROID);
	    
	    JProgressBar progressBar5 = new JProgressBar();
	    progressBar5.setValue(android_score);
	    progressBar5.setStringPainted(true);
	    progressBar5.setString(Integer.toString(android_score));
	    progressBar5.setOrientation(SwingConstants.HORIZONTAL);
	    progressBar5.setMinimum(0);
	    progressBar5.setMaximum(100);
	    progressBar5.setBounds(81, 258, 200, 18);
	    contentPane.add(progressBar5);
	}
	
	public int get_compre_stren_score() {
		return compre_stren_score;
	}
}
