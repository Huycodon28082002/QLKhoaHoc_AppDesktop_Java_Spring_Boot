package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import BLL.OnlineCourseBLL;
import BLL.OnsiteCourseBLL;
import DTO.onlinecourse;
import DTO.onsitecourse;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class CourseGUI extends JPanel {
	private onlinecourse olc=new onlinecourse();
	private OnlineCourseBLL olcBLL=new OnlineCourseBLL();
	private onsitecourse osc=new onsitecourse();
	private OnsiteCourseBLL oscBLL=new OnsiteCourseBLL();
	private JPanel panelOnlineCourse;
	private JPanel panelOnsiteCourse;
	private JTextField txtCourseIDOnlineCourse ;
	private JTextField txtTitleOnlineCourse;
	private JTextField txtCreditsOnlineCourse;
	private JTextField txtDepartmentIDOnlineCourse;
	private JTextField txtSearchOnlineCourse;
	private JTextField txturl;
	private JTextField txtCourseIDOnsiteCourse ;
	private JTextField txtTitleOnsiteCourse;
	private JTextField txtCreditsOnsiteCourse;
	private JTextField txtDepartmentIDOnsiteCourse;
	private JTextField txtSearchOnsiteCourse;
	private JTextField txtLocation;
	private JTextField txtTime;
	private JTextField txtDays;
	private JButton btnSearchOnlineCourse;
	private JButton btnSearchOnsiteCourse;
	private JTabbedPane tabPane;
	private JLabel lblCourseID;
	private JLabel lblTitle ;
	private JLabel lblCredits;
	private JLabel lblDepartmentID;
	private JLabel lblurl;
	private JScrollPane scrollPane;
	private JTable tableListOnlineCourse;
	private JTable tableListOnsiteCourse;
	private JLabel lblLocation;
	private JLabel lblTime;
	private JLabel lblDays;

	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblSearchTitle;
	private JLabel lblSearchTitle_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	public CourseGUI() {
		setBorder(UIManager.getBorder("CheckBox.border"));
		setSize(705, 540);
		setLayout(null);
		panelOnlineCourse=new JPanel();
		panelOnsiteCourse=new JPanel();
		
		
		
		JScrollPane jScrollPane=new JScrollPane();
		jScrollPane.setBounds(0, 0,705, 540);
		add(jScrollPane);
		//
		tabPane = new JTabbedPane();
		tabPane.addTab( "Khóa học online", panelOnlineCourse);
		panelOnlineCourse.setLayout(null);
		//
		lblCourseID = new JLabel("CourseID :");
		lblCourseID.setBounds(10, 95, 129, 25);
		lblCourseID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourseID.setToolTipText("");
		panelOnlineCourse.add(lblCourseID);
		
		lblTitle = new JLabel("Title :");
		lblTitle.setBounds(10, 131, 111, 25);
		lblTitle.setToolTipText("");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelOnlineCourse.add(lblTitle);
		
		lblCredits = new JLabel("Credits :");
		lblCredits.setBounds(334, 95, 111, 25);
		lblCredits.setToolTipText("");
		lblCredits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelOnlineCourse.add(lblCredits);
		
		lblDepartmentID = new JLabel("DepartmentID:");
		lblDepartmentID.setBounds(334, 131, 129, 25);
		lblDepartmentID.setToolTipText("");
		lblDepartmentID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelOnlineCourse.add(lblDepartmentID);
		
		lblurl = new JLabel("url :");
		lblurl.setBounds(10, 167, 111, 25);
		lblurl.setToolTipText("");
		lblurl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelOnlineCourse.add(lblurl);
		
		txtCourseIDOnlineCourse = new JTextField();
		txtCourseIDOnlineCourse.setBounds(99, 94, 213, 25);
		txtCourseIDOnlineCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCourseIDOnlineCourse.setColumns(10);
		panelOnlineCourse.add(txtCourseIDOnlineCourse);
		
		txtTitleOnlineCourse = new JTextField();
		txtTitleOnlineCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitleOnlineCourse.setColumns(10);
		txtTitleOnlineCourse.setBounds(99, 130, 213, 25);
		panelOnlineCourse.add(txtTitleOnlineCourse);
		
		txtCreditsOnlineCourse = new JTextField();
		txtCreditsOnlineCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCreditsOnlineCourse.setColumns(10);
		txtCreditsOnlineCourse.setBounds(473, 94, 213, 25);
		panelOnlineCourse.add(txtCreditsOnlineCourse);
		
		txtDepartmentIDOnlineCourse = new JTextField();
		txtDepartmentIDOnlineCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDepartmentIDOnlineCourse.setColumns(10);
		txtDepartmentIDOnlineCourse.setBounds(473, 130, 213, 25);
		panelOnlineCourse.add(txtDepartmentIDOnlineCourse);
		
		txturl = new JTextField();
		txturl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txturl.setColumns(10);
		txturl.setBounds(99, 166, 213, 25);
		panelOnlineCourse.add(txturl);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int  CourseID=Integer.parseInt(txtCourseIDOnlineCourse.getText());
				String Title=txtTitleOnlineCourse.getText();
				int Credits=Integer.parseInt(txtCreditsOnlineCourse.getText());
				int DepartmentID=Integer.parseInt(txtDepartmentIDOnlineCourse.getText());
				String url= txturl.getText();
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm khóa học Online không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					olc=new onlinecourse(CourseID, Title, Credits, DepartmentID, url);
					if(olcBLL.InsertOnlineBLL(olc)==true) {
						JOptionPane.showMessageDialog(btnAdd,"Thêm thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnAdd,"Thêm thất bại");
					}
				}
			}
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(129, 212, 89, 40);
		panelOnlineCourse.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  CourseID=Integer.parseInt(txtCourseIDOnlineCourse.getText());
				String Title=txtTitleOnlineCourse.getText();
				int Credits=Integer.parseInt(txtCreditsOnlineCourse.getText());
				int DepartmentID=Integer.parseInt(txtDepartmentIDOnlineCourse.getText());
				String url= txturl.getText();
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhập khóa học Online không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					olc=new onlinecourse(CourseID, Title, Credits, DepartmentID, url);
					if(olcBLL.UpdateOnlineBLL(olc)==true) {
						JOptionPane.showMessageDialog(btnUpdate,"Sửa thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnUpdate,"Sửa thất bại");
					}
				}
			}
		});
		
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(228, 212, 107, 40);
		panelOnlineCourse.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  CourseID=Integer.parseInt(txtCourseIDOnlineCourse.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khóa học Online không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
					}
				else {
					if(olcBLL.RemoveOnlineBLL(CourseID)==true) {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thất bại");
					}
				}
			}
		});
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(345, 212, 89, 40);
		panelOnlineCourse.add(btnDelete);
		
		txtSearchOnlineCourse = new JTextField();
		txtSearchOnlineCourse.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String name=txtSearchOnlineCourse.getText();
				ListTableOnlineCourse(olcBLL.SearchOnlineBLL(name));
				}
		});
		
		txtSearchOnlineCourse.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearchOnlineCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearchOnlineCourse.setColumns(10);
		txtSearchOnlineCourse.setBounds(444, 215, 147, 35);
		panelOnlineCourse.add(txtSearchOnlineCourse);
		
		
		btnSearchOnlineCourse = new JButton("Search");
		btnSearchOnlineCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtSearchOnlineCourse.getText();
				ListTableOnlineCourse(olcBLL.SearchOnlineBLL(name));
				}
		});
		
		btnSearchOnlineCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearchOnlineCourse.setBounds(601, 215, 95, 35);
		panelOnlineCourse.add(btnSearchOnlineCourse);

		scrollPane=new JScrollPane();
		scrollPane.setBounds(10, 294, 676, 205);
		panelOnlineCourse.add(scrollPane);
		
		tableListOnlineCourse = new JTable();
		tableListOnlineCourse.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ListTableOnlineCourse(olcBLL.ListOnlineBLL());
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setViewportView(tableListOnlineCourse);
		
		
		tableListOnlineCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableListOnlineCourse.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CourseID ", "Title", "Credits", "DepartmentID","url"
				}
			));
		
		tableListOnlineCourse.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				getEventOnlineCourse();
				
			}
			
		});
		tableListOnlineCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventOnlineCourse();
				
				
			}
		});

		scrollPane.setViewportView(tableListOnlineCourse);
		
		lblSearchTitle = new JLabel("Search Title :");
		lblSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchTitle.setBounds(444, 172, 147, 40);
		panelOnlineCourse.add(lblSearchTitle);
		
		lblNewLabel = new JLabel("Online Course");
		lblNewLabel.setIcon(new ImageIcon("E:\\icon\\Icon\\NhanVien.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 676, 73);
		panelOnlineCourse.add(lblNewLabel);
		
		tabPane.addTab( "Khóa học onsite", panelOnsiteCourse);
		panelOnsiteCourse.setLayout(null);
		
		lblCourseID = new JLabel("CourseID :");
		lblCourseID.setBounds(10, 96, 129, 25);
		lblCourseID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourseID.setToolTipText("");
		panelOnsiteCourse.add(lblCourseID);
		
		lblTitle = new JLabel("Title :");
		lblTitle.setBounds(10, 132, 111, 25);
		lblTitle.setToolTipText("");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelOnsiteCourse.add(lblTitle);
		
		lblCredits = new JLabel("Credits :");
		lblCredits.setBounds(352, 96, 111, 25);
		lblCredits.setToolTipText("");
		lblCredits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelOnsiteCourse.add(lblCredits);
		
		lblDepartmentID = new JLabel("DepartmentID:");
		lblDepartmentID.setBounds(352, 132, 129, 25);
		lblDepartmentID.setToolTipText("");
		lblDepartmentID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelOnsiteCourse.add(lblDepartmentID);
		
		lblLocation = new JLabel("Location :");
		lblLocation.setToolTipText("");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocation.setBounds(10, 168, 129, 25);
		panelOnsiteCourse.add(lblLocation);
		
		lblTime = new JLabel("Time :");
		lblTime.setToolTipText("");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(352, 168, 129, 25);
		panelOnsiteCourse.add(lblTime);
		
		lblDays = new JLabel("Days :");
		lblDays.setToolTipText("");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDays.setBounds(10, 204, 129, 25);
		panelOnsiteCourse.add(lblDays);
		
		txtCourseIDOnsiteCourse = new JTextField();
		txtCourseIDOnsiteCourse.setBounds(99, 95, 213, 25);
		txtCourseIDOnsiteCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCourseIDOnsiteCourse.setColumns(10);
		panelOnsiteCourse.add(txtCourseIDOnsiteCourse);
		
		txtTitleOnsiteCourse = new JTextField();
		txtTitleOnsiteCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitleOnsiteCourse.setColumns(10);
		txtTitleOnsiteCourse.setBounds(99, 131, 213, 25);
		panelOnsiteCourse.add(txtTitleOnsiteCourse);
		
		txtCreditsOnsiteCourse = new JTextField();
		txtCreditsOnsiteCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCreditsOnsiteCourse.setColumns(10);
		txtCreditsOnsiteCourse.setBounds(473, 95, 213, 25);
		panelOnsiteCourse.add(txtCreditsOnsiteCourse);
		
		txtDepartmentIDOnsiteCourse = new JTextField();
		txtDepartmentIDOnsiteCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDepartmentIDOnsiteCourse.setColumns(10);
		txtDepartmentIDOnsiteCourse.setBounds(473, 131, 213, 25);
		panelOnsiteCourse.add(txtDepartmentIDOnsiteCourse);
		
		txtLocation = new JTextField();
		txtLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLocation.setColumns(10);
		txtLocation.setBounds(99, 167, 213, 25);
		panelOnsiteCourse.add(txtLocation);
		
		txtTime = new JTextField();
		txtTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTime.setColumns(10);
		txtTime.setBounds(473, 167, 213, 25);
		panelOnsiteCourse.add(txtTime);
		
		txtDays = new JTextField();
		txtDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDays.setColumns(10);
		txtDays.setBounds(99, 203, 213, 25);
		panelOnsiteCourse.add(txtDays);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  CourseID=Integer.parseInt(txtCourseIDOnsiteCourse.getText());
				String Title=txtTitleOnsiteCourse.getText();
				int Credits=Integer.parseInt(txtCreditsOnsiteCourse.getText());
				int DepartmentID=Integer.parseInt(txtDepartmentIDOnsiteCourse.getText());
				String Location=txtLocation.getText();
				String Days=txtDays.getText();
				try {
			    	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			    	Date date = (Date) sdf.parse(txtTime.getText());
				
			    	Time Time =new Time(date.getTime());
			    	int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm khóa học Onsite không!","Xác nhận",JOptionPane.YES_OPTION);
			    	if(result==JOptionPane.NO_OPTION) {
			    		return ;
					}else {
			    		osc=new onsitecourse(CourseID, Title, Credits, DepartmentID, Location, Days, Time);
			    		if(oscBLL.InsertsiteneBLL(osc)==true) {
			    			JOptionPane.showMessageDialog(btnAdd,"Thêm thành công");
			    		}
			    		else {
			    			JOptionPane.showMessageDialog(btnAdd,"Thêm thất bại");
			    		}
			    	}
			    } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(113, 240, 89, 40);
		panelOnsiteCourse.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  CourseID=Integer.parseInt(txtCourseIDOnsiteCourse.getText());
				String Title=txtTitleOnsiteCourse.getText();
				int Credits=Integer.parseInt(txtCreditsOnsiteCourse.getText());
				int DepartmentID=Integer.parseInt(txtDepartmentIDOnsiteCourse.getText());
				String Location=txtLocation.getText();
				String Days=txtDays.getText();
				try {
			    	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			    	Date date = (Date) sdf.parse(txtTime.getText());
				
			    	Time Time =new Time(date.getTime());
			    	int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhập khóa học Onsite không!","Xác nhận",JOptionPane.YES_OPTION);
					if(result==JOptionPane.NO_OPTION) {
						return ;
					}else {
						osc=new onsitecourse(CourseID, Title, Credits, DepartmentID, Location, Days, Time);
				    	if(oscBLL.UpdateOnsiteBLL(osc)==true) {
				    		JOptionPane.showMessageDialog(btnAdd,"Sửa thành công");
				    	}
				    	else {
				    		JOptionPane.showMessageDialog(btnAdd,"Sửa thất bại");
				    	}
					}
			    } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(212, 240, 107, 40);
		panelOnsiteCourse.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  CourseID=Integer.parseInt(txtCourseIDOnsiteCourse.getText());
				int result =JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khóa học Onsite không!","Xác nhận",JOptionPane.YES_OPTION);
				if(result==JOptionPane.NO_OPTION) {
					return ;
				}
				else {
					if(oscBLL.RemoveOnsiteBLL(CourseID)==true) {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thành công");
					}
					else {
						JOptionPane.showMessageDialog(btnDelete,"Xóa thất bại");
					}
				}
			}
		});
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(329, 240, 89, 40);
		panelOnsiteCourse.add(btnDelete);
		
		txtSearchOnsiteCourse = new JTextField();
		
		txtSearchOnsiteCourse.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String name=txtSearchOnsiteCourse.getText();
				ListTableOnsiteCourse(oscBLL.SearchOnsiteBLL(name));
				
				}
		});
		
		txtSearchOnsiteCourse.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearchOnsiteCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearchOnsiteCourse.setColumns(10);
		txtSearchOnsiteCourse.setBounds(428, 243, 153, 35);
		panelOnsiteCourse.add(txtSearchOnsiteCourse);
		
		
		btnSearchOnsiteCourse = new JButton("Search");
		btnSearchOnsiteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtSearchOnsiteCourse.getText();
				ListTableOnsiteCourse(oscBLL.SearchOnsiteBLL(name));
				}
		});
		
		btnSearchOnsiteCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearchOnsiteCourse.setBounds(591, 243, 95, 35);
		panelOnsiteCourse.add(btnSearchOnsiteCourse);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(10, 291, 676, 208);
		panelOnsiteCourse.add(scrollPane);
		
		tableListOnsiteCourse = new JTable();
		tableListOnsiteCourse.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ListTableOnsiteCourse(oscBLL.ListOnsiteBLL());
			}
			
			
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane.setViewportView(tableListOnsiteCourse);
		
		
		tableListOnsiteCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableListOnsiteCourse.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CourseID ", "Title", "Credits", "DepartmentID","Location","Days","Time"
				}
			));
		
		lblSearchTitle_1 = new JLabel("Search Title :");
		lblSearchTitle_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchTitle_1.setBounds(428, 208, 147, 40);
		panelOnsiteCourse.add(lblSearchTitle_1);
		
		lblNewLabel_1 = new JLabel("Onsite Course");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\icon\\Icon\\home.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 676, 74);
		panelOnsiteCourse.add(lblNewLabel_1);
		
		tableListOnsiteCourse.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				getEventOnsiteCourse();
				
			}
			
		});
		tableListOnsiteCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getEventOnsiteCourse();
				
				
			}
		});

		
		

		jScrollPane.setViewportView(tabPane);

		
		
		
		
	}
	
	public void ListTableOnlineCourse(ArrayList<onlinecourse> olc) {
		DefaultTableModel df= (DefaultTableModel) tableListOnlineCourse.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (onlinecourse onlineCourse : olc) {
			Object dataRow[] =new Object[5];
			dataRow[0]=onlineCourse.getCourseID();
			dataRow[1]=onlineCourse.getTitle();
			dataRow[2]=onlineCourse.getCredits();
			dataRow[3]=onlineCourse.getDepartmentID();
			dataRow[4]=onlineCourse.getUrl();
			df.addRow(dataRow);
		}
	}
	
	public void ListTableOnsiteCourse(ArrayList<onsitecourse> osc) {
		DefaultTableModel df= (DefaultTableModel) tableListOnsiteCourse.getModel();
		//xoa data trong table
		df.setRowCount(0);
		for (onsitecourse onsiteCourse : osc) {
			Object dataRow[] =new Object[7];
			dataRow[0]=onsiteCourse.getCourseID();
			dataRow[1]=onsiteCourse.getTitle();
			dataRow[2]=onsiteCourse.getCredits();
			dataRow[3]=onsiteCourse.getDepartmentID();
			dataRow[4]=onsiteCourse.getLocation();
			dataRow[5]=onsiteCourse.getDays();
			dataRow[6]=onsiteCourse.getTime();
			df.addRow(dataRow);
		}
	}
	
	public void getEventOnlineCourse() {
		int indexRow=tableListOnlineCourse.getSelectedRow();
		olc=olcBLL.ListOnlineBLL().get(indexRow);
		txtCourseIDOnlineCourse.setText(String.valueOf(olc.getCourseID()));
		txtTitleOnlineCourse.setText(olc.getTitle());
		txtCreditsOnlineCourse.setText(String.valueOf(olc.getCredits()));
		txtDepartmentIDOnlineCourse.setText(String.valueOf(olc.getDepartmentID()));
		txturl.setText(olc.getUrl());
	}
	public void getEventOnsiteCourse() {
		int indexRow=tableListOnsiteCourse.getSelectedRow();
		osc=oscBLL.ListOnsiteBLL().get(indexRow);
		txtCourseIDOnsiteCourse.setText(String.valueOf(osc.getCourseID()));
		txtTitleOnsiteCourse.setText(String.valueOf(osc.getTitle()));
		txtCreditsOnsiteCourse.setText(String.valueOf(osc.getCredits()));
		txtDepartmentIDOnsiteCourse.setText(String.valueOf(osc.getDepartmentID()));
		txtLocation.setText(osc.getLocation());
		txtDays.setText(osc.getDays());
		txtTime.setText(String.valueOf(osc.getTime()));
	}
}
