package view;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AddUser;
import controller.DeleteUser;
import controller.EditInfo;



@SuppressWarnings("serial")
public class AdministratorPanel extends JFrame implements ActionListener {
	/*
	 * ����Ա��½�����������
	 */
	JButton deleteUser, addUser, selfInfo;
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
		selfInfo.setBounds(70, 45, 140, 30);
		addUser.setBounds(70, 100, 140, 30);
		deleteUser.setBounds(70, 155, 140, 30);
		contain.add(selfInfo);
		contain.add(addUser);
		contain.add(deleteUser);
		selfInfo.addActionListener(this);
		addUser.addActionListener(this);
		deleteUser.addActionListener(this);
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
	}

	public void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
			setVisible(false);
			System.exit(0);
		}
	}
}