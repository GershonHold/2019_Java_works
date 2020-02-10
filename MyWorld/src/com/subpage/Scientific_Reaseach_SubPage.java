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
public class Scientific_Reaseach_SubPage extends JFrame {

	private JPanel contentPane;
	private int compre_stren_score;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scientific_Reaseach_SubPage frame = new Scientific_Reaseach_SubPage();
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
	public Scientific_Reaseach_SubPage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//这里改为HIDE_ON_CLOSE防止该窗口点击关闭导致主窗口也被关闭
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);//居中显示窗口
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourselfTodayAnd = new JLabel("Your Scientific Research Today And Before");
		lblYourselfTodayAnd.setFont(new Font("Monotype Corsiva", Font.PLAIN, 21));
		lblYourselfTodayAnd.setBounds(14, 32, 388, 18);
		contentPane.add(lblYourselfTodayAnd);
		
		JLabel compre_stren = new JLabel("综合实力");
		compre_stren.setFont(new Font("Adobe 宋体 Std L", Font.PLAIN, 15));
		compre_stren.setBounds(14, 82, 72, 18);
		contentPane.add(compre_stren);
		
		int fwwb_score=40;
		compre_stren_score=fwwb_score/1;
		
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
	    
	    JLabel FWWB = new JLabel("FWWB");
	    FWWB.setBounds(14, 125, 72, 18);
	    FWWB.setFont(new Font("Adobe 宋体 Std L", Font.PLAIN, 15));
	    contentPane.add(FWWB);
	    
	    JProgressBar progressBar2 = new JProgressBar();
	    progressBar2.setValue(fwwb_score);
	    progressBar2.setStringPainted(true);
	    progressBar2.setString(Integer.toString(fwwb_score));
	    progressBar2.setOrientation(SwingConstants.HORIZONTAL);
	    progressBar2.setMinimum(0);
	    progressBar2.setMaximum(100);
	    progressBar2.setBounds(81, 125, 200, 18);
	    contentPane.add(progressBar2);
	}
	
	public int get_compre_stren_score() {
		return compre_stren_score;
	}

}
