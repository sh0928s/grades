package view;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AddUser;
import controller.DeleteCourse;
import controller.DeleteUser;
import controller.EditInfo;



@SuppressWarnings("serial")
public class AdministratorPanel extends JFrame implements ActionListener {
	/*
	 * ����Ա��½�����������
	 */
	JButton deleteUser, addUser, selfInfo,deleteCourse,return_button;
	JPanel contain;
	String idd;

	public AdministratorPanel(String idd) {
		super("ϵͳ����Ա");
		this.idd = idd;
		setLocation(300, 200);
		setSize(300, 340);
		contain = new JPanel();
		contain.setLayout(null);
		add(contain);
		selfInfo = new JButton("�޸���Ϣ");
		addUser = new JButton("�����û�");
		deleteUser = new JButton("ɾ���û�");
		deleteCourse=new JButton("ɾ���γ�");
		return_button=new JButton("����");
		selfInfo.setBounds(70, 45, 140, 30);
		addUser.setBounds(70, 80, 140, 30);
		deleteUser.setBounds(70, 115, 140, 30);
		deleteCourse.setBounds(70,150,140,30);
		return_button.setBounds(70,185,140,30);
		contain.add(selfInfo);
		contain.add(addUser);
		contain.add(deleteUser);
		contain.add(deleteCourse);
		contain.add(return_button);
		selfInfo.addActionListener(this);
		addUser.addActionListener(this);
		deleteUser.addActionListener(this);
		deleteCourse.addActionListener(this);
		return_button.addActionListener(this);
		setVisible(true);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addUser) {
			new AddUser();    // �û������ʼ��ͳһΪ123456
		} else if (e.getSource() == deleteUser) {
			new DeleteUser();
		} else if (e.getSource() == selfInfo) {
			new EditInfo(idd, 3);
		}
		else if(e.getSource()==deleteCourse) {
			new DeleteCourse();
		}
		else {
			new MainFrame();
		}
	}

	public void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
			setVisible(false);
			System.exit(0);
		}
	}
}