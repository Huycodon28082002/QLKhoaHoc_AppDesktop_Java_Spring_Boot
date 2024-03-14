package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnQuanLyThongPhanCongGiangDay;
	private JButton btnQuanLyThongTinKhoaHoc;
	private JButton btnQuanLyKetQuaKhoaHoc ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setBackground(new Color(255, 255, 255));
		setTitle("Quản lý khóa học");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lbQuanLyKhoaHoc =new JLabel("Course Management");
		lbQuanLyKhoaHoc.setBackground(new Color(45, 78, 83));
		lbQuanLyKhoaHoc.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbQuanLyKhoaHoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbQuanLyKhoaHoc.setBounds(0, 0,1006, 63);
		contentPane.add(lbQuanLyKhoaHoc);
		panel=new JPanel();
		panel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				panel.removeAll();
				panel.add(new CourseInstructorGUI());
				contentPane.repaint();
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(265, 85,705, 540);
		contentPane.add(panel);
		
		
		btnQuanLyThongTinKhoaHoc =new JButton("Course");
		btnQuanLyThongTinKhoaHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				panel.add(new CourseGUI());
				
				contentPane.repaint();
				
			}
		});
		
		btnQuanLyThongTinKhoaHoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnQuanLyThongTinKhoaHoc.setBounds(25, 291, 205, 50);
		
		btnQuanLyThongPhanCongGiangDay =new JButton("CourseInstructor");
		btnQuanLyThongPhanCongGiangDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				panel.add(new CourseInstructorGUI());
				contentPane.repaint();
			}
		});
		btnQuanLyThongPhanCongGiangDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnQuanLyThongPhanCongGiangDay.setBounds(25, 230, 205, 50);
		
		btnQuanLyKetQuaKhoaHoc =new JButton("StudentGrade");
		btnQuanLyKetQuaKhoaHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new StudentGradeGUI());
				contentPane.repaint();
			}
		});
		
		
		btnQuanLyKetQuaKhoaHoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnQuanLyKetQuaKhoaHoc.setBounds(25, 352, 205, 50);
		
		contentPane.add(btnQuanLyThongTinKhoaHoc);
		contentPane.add(btnQuanLyThongPhanCongGiangDay);
		contentPane.add(btnQuanLyKetQuaKhoaHoc);
		
		
		
	}
	

}
