package view;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AddCourse;
import controller.CourseView;
import controller.EditInfo;
import controller.GradeEnter;
import controller.Info;

@SuppressWarnings("serial")
public class TeachersPanel extends JFrame implements ActionListener {
  /*
   * ��ʦ��½�����������
   */

  String idd;
  JPanel contain;
  JButton infoButton, gradeButton, courseButton, editButton, courseView, sortGrade,return_button;

  public TeachersPanel(String idd) {
    super("��ʦ");
    this.idd = idd;
    setLocation(300, 200);
    setSize(300, 340);
    contain = new JPanel();
    contain.setLayout(null);
    add(contain);
    infoButton = new JButton("��Ϣ��ѯ");
    gradeButton = new JButton("�ɼ���¼");
    courseButton = new JButton("ȫ���γ�");
    editButton = new JButton("�޸���Ϣ");
    courseView = new JButton("����");
    sortGrade = new JButton("�ɼ�ͳ��");
    return_button=new JButton("����");

    infoButton.setBounds(70, 30, 140, 30);
    editButton.setBounds(70, 60, 140, 30);
    courseView.setBounds(70, 90, 140, 30);
    courseButton.setBounds(70, 120, 140, 30);
    gradeButton.setBounds(70, 150, 140, 30);
    sortGrade.setBounds(70, 180, 140, 30);
    return_button.setBounds(70,210,140,30);

    contain.add(infoButton);
    infoButton.addActionListener(this);
    contain.add(gradeButton);
    gradeButton.addActionListener(this);
    contain.add(courseView);
    courseView.addActionListener(this);
    contain.add(courseButton);
    courseButton.addActionListener(this);
    contain.add(editButton);
    editButton.addActionListener(this);
    contain.add(sortGrade);
    sortGrade.addActionListener(this);
    contain.add(return_button);
    return_button.addActionListener(this);
    setVisible(true);
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == infoButton) {
      new Info(idd, 0);
    }
    else if (e.getSource() == gradeButton) {
      new GradeEnter(idd);
    }
    else if (e.getSource() == courseButton) {
      new CourseView(idd, 1);
    }
    else if (e.getSource() == editButton) {
      new EditInfo(idd, 1);
    }
    else if (e.getSource() == courseView) {
      new AddCourse();
    }
    else if (e.getSource() == sortGrade) {
      new SortGradeFrame();
    }
    else {
		new MainFrame();
	}
  }

  @Override
  public void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      this.dispose();
      setVisible(false);
      System.exit(0);
    }
  }
}
