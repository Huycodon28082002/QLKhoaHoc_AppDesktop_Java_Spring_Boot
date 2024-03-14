package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BLL.CourseInstructorBLL;
import DTO.courseinstructor;


import javax.swing.UIManager;
import javax.swing.event.AncestorListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CourseInstructorGUI extends JPanel {
	private courseinstructor ci=new courseinstructor();
	private CourseInstructorBLL ciBLL=new CourseInstructorBLL();
	private JTextField txtCourseID;
	private JTextField txtPersonID;
	private JTextField txtSearch;
	private JScrollPane scrollPane;
	private JTable tableList;
	private JButton btnAdd ;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	
	/**
	 * Create the panel.
	 */
	public CourseInstructorGUI() {
		setBorder(UIManager.getBorder("CheckBox.border"));
		setSize(705, 540);
		setLayout(null);
		
		JLabel lblCourseid = new JLabel("CourseID :");
		lblCourseid.setToolTipText("");
		lblCourseid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourseid.setBounds(10, 108, 111, 25);
		add(lblCourseid);
		
		txtCourseID = new JTextField();
		txtCourseID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCourseID.setColumns(10);
		txtCourseID.setBounds(107, 107, 213, 25);
		add(txtCourseID);
		
		JLabel lblPersonID = new JLabel("PersonID :");
		lblPersonID.setToolTipText("");
		lblPersonID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPersonID.setBounds(345, 108, 111, 25);
		add(lblPersonID);
		
		txtPersonID = new JTextField();
		txtPersonID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPersonID.setColumns(10);
		txtPersonID.setBounds(466, 107, 213, 25);
		add(txtPersonID);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int CourseID=Integer.parseInt(txtCourseID.getText());
				int PersonID=Integer.parseInt(txtPersonID.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn phân công"
						+ " cho giảng viên này không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					ci=new courseinstructor(CourseID, PersonID);
					if(ciBLL.InsertCourseInstructorBLL(ci)==true) {
						JOptionPane.showMessageDialog(btnAdd,"Thêm thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnAdd,"Thêm thất bại");
					}
				}
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(10, 192, 89, 40);
		add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int CourseID=Integer.parseInt(txtCourseID.getText());
				int PersonID=Integer.parseInt(txtPersonID.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhập phân công"
						+ " khóa học này không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					ci=new courseinstructor(CourseID, PersonID);
					if(ciBLL.UpdateCourseInstructorBLL(ci)==true) {
						JOptionPane.showMessageDialog(btnUpdate,"Sửa thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnUpdate,"Sửa thất bại");
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(107, 192, 107, 40);
		add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int CourseID=Integer.parseInt(txtCourseID.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phân công này không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					if(ciBLL.RemoveCourseInstructorBLL(CourseID)==true) {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thất bại");
					}
				}
			}
		});
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(224, 192, 89, 40);
		add(btnDelete);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearch.setColumns(10);
		txtSearch.setBounds(442, 195, 147, 35);
		add(txtSearch);
		
		txtSearch.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String search=txtSearch.getText();
				ListTable(ciBLL.SearchCourseInstructorBLL(search));
			}
		});
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search=txtSearch.getText();
				ListTable(ciBLL.SearchCourseInstructorBLL(search));
			}
		});
		
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(599, 195, 95, 35);
		add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("Search Title :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(335, 192, 121, 40);
		add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 278, 684, 235);
		add(scrollPane);
		tableList=new JTable();
		
		tableList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableList.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CourseID","Title", "PersonID","Firstname","Lastname"
				}
			));
		
		tableList.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ListTable(ciBLL.ListCourseInstructorBLL());
			}
			
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
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
		
		scrollPane.setViewportView(tableList);
		
		JLabel lblNewLabel_1 = new JLabel("CourseInstructor");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\icon\\Icon\\BaoCao.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 11, 684, 86);
		add(lblNewLabel_1);
	}
	
	public void ListTable(ArrayList<courseinstructor> ci) {
		DefaultTableModel df= (DefaultTableModel) tableList.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (courseinstructor courseInstructor : ci) {
			Object dataRow[] =new Object[5];
			dataRow[0]=courseInstructor.getCourseID();
			dataRow[1]=courseInstructor.getTitle();
			dataRow[2]=courseInstructor.getPersonID();
			dataRow[3]=courseInstructor.getFirstName();
			dataRow[4]=courseInstructor.getLastName();
			df.addRow(dataRow);
		}
	}
	
	public void getEvent() {
		int indexRow=tableList.getSelectedRow();
		ci=ciBLL.ListCourseInstructorBLL().get(indexRow);
		txtCourseID.setText(String.valueOf(ci.getCourseID()));
		txtPersonID.setText(String.valueOf(ci.getPersonID()));
		
	}
}
