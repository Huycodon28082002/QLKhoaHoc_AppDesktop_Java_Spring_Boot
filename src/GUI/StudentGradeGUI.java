package GUI;

import javax.swing.JPanel;

import DTO.studentgrade;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;
import BLL.StudentGradeBLL;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class StudentGradeGUI extends JPanel {
	private StudentGradeBLL sgBLL=new StudentGradeBLL();
	private studentgrade sg=new studentgrade();
	private JTextField txtEnrollmentID;
	private JTextField txtCourseID;
	private JTextField txtStudentID;
	private JTextField txtGrade;
	private JTextField txtSearch;
	private JButton btnAdd ;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable tableList;
	private JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	
	public StudentGradeGUI() {
		setBorder(UIManager.getBorder("CheckBox.border"));
		
		setSize(705, 540);
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("EnrollmentID :");
		lblNewLabel.setBounds(10, 104, 129, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setToolTipText("");
		add(lblNewLabel);
		
		JLabel lblCourseid = new JLabel("CourseID :");
		lblCourseid.setBounds(10, 140, 111, 25);
		lblCourseid.setToolTipText("");
		lblCourseid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCourseid);
		
		JLabel lblStudentid = new JLabel("StudentID :");
		lblStudentid.setBounds(352, 104, 111, 25);
		lblStudentid.setToolTipText("");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblStudentid);
		
		JLabel lblGrade = new JLabel("Grade :");
		lblGrade.setBounds(352, 139, 111, 25);
		lblGrade.setToolTipText("");
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblGrade);
		
		txtEnrollmentID = new JTextField();
		txtEnrollmentID.setBounds(131, 103, 213, 25);
		txtEnrollmentID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtEnrollmentID);
		txtEnrollmentID.setColumns(10);
		
		txtCourseID = new JTextField();
		txtCourseID.setBounds(131, 139, 213, 25);
		txtCourseID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCourseID.setColumns(10);
		add(txtCourseID);
		
		txtStudentID = new JTextField();
		txtStudentID.setBounds(471, 103, 224, 25);
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStudentID.setColumns(10);
		add(txtStudentID);
		
		txtGrade = new JTextField();
		txtGrade.setBounds(471, 139, 224, 25);
		txtGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGrade.setColumns(10);
		add(txtGrade);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 294, 685, 235);
		add(scrollPane);
		tableList=new JTable();
		
		tableList.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				getEvent();
			}
			
		});
		tableList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEvent();
				
				
			}
		});
		
		
		

		tableList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableList.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"EnrollmentID", "CourseID", "StudentID", "Grade"
				}
			));
		
		tableList.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				 ListTable(sgBLL.ListStudentGradeBLL());
			}
			
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		
		

		//
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  EnrollmentID=Integer.parseInt(txtEnrollmentID.getText());
				int CourseID=Integer.parseInt(txtCourseID.getText());
				int StudentID=Integer.parseInt(txtStudentID.getText());
				BigDecimal Grade= new BigDecimal(txtGrade.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa điểm cho học sinh này không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					sg= new studentgrade(EnrollmentID, CourseID, StudentID, Grade);
					if(sgBLL.UpdateStudentGradeBLL(sg)==true) {
						JOptionPane.showMessageDialog(btnUpdate,"Sửa thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnUpdate,"Sửa thất bại");
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(228, 203, 107, 40);
		add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  EnrollmentID=Integer.parseInt(txtEnrollmentID.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa điểm cho học sinh này không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					if(sgBLL.RemoveStudentGradeBLL(EnrollmentID)==true) {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thất bại");
					}
				}
			}
		});
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(345, 203, 89, 40);
		add(btnDelete);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int  EnrollmentID=Integer.parseInt(txtEnrollmentID.getText());
				int CourseID=Integer.parseInt(txtCourseID.getText());
				int StudentID=Integer.parseInt(txtStudentID.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thêm điểm cho"
						+ " học sinh này không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					BigDecimal Grade= new BigDecimal(txtGrade.getText());
					sg= new studentgrade(EnrollmentID, CourseID, StudentID, Grade);
					if(sgBLL.InsertStudentGradeBLL(sg)==true) {
						JOptionPane.showMessageDialog(btnAdd,"Thêm thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnAdd,"Thêm thất bại");
					}
				}
			}
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(129, 203, 89, 40);
		add(btnAdd);
		
		txtSearch = new JTextField();
		
		txtSearch.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				int search=Integer.parseInt(txtSearch.getText());
				ListTable(sgBLL.SearchStudentGradeBLL(search));
			}
		});
		
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearch.setColumns(10);
		txtSearch.setBounds(444, 206, 147, 35);
		add(txtSearch);
		
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int search=Integer.parseInt(txtSearch.getText());
				ListTable(sgBLL.SearchStudentGradeBLL(search));
					
				
				}
		});
		
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(600, 206, 95, 35);
		add(btnSearch);
		scrollPane.setViewportView(tableList);
		
		JLabel lblSearchCourseid = new JLabel("Search EnrollmentID :");
		lblSearchCourseid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchCourseid.setBounds(444, 166, 193, 40);
		add(lblSearchCourseid);
		
		lblNewLabel_1 = new JLabel("StudentGrade");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\icon\\Icon\\DonHang.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 11, 685, 82);
		add(lblNewLabel_1);
		
	}
	
	
	public void ListTable(ArrayList<studentgrade> sg) {
		DefaultTableModel df= (DefaultTableModel) tableList.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (studentgrade studentGrade : sg) {
			Object dataRow[] =new Object[4];
			dataRow[0]=studentGrade.getEnrollmentID();
			dataRow[1]=studentGrade.getCourseID();
			dataRow[2]=studentGrade.getStudentID();
			dataRow[3]=studentGrade.getGrade();
			df.addRow(dataRow);
		}
	}
	
	public void getEvent() {
		int indexRow=tableList.getSelectedRow();
		sg=sgBLL.ListStudentGradeBLL().get(indexRow);
		txtEnrollmentID.setText(String.valueOf(sg.getEnrollmentID()));
		txtCourseID.setText(String.valueOf(sg.getCourseID()));
		txtStudentID.setText(String.valueOf(sg.getStudentID()));
		txtGrade.setText(String.valueOf(sg.getGrade()));
	}
	
}
