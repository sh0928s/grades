package view;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GradeSort;

@SuppressWarnings("serial")
public class SortGradeFrame extends JFrame implements ActionListener {

  JPanel contain;
  JLabel id, pass, good, excellent;
  JTextField idt, passt, goodt, excellentt;

  JButton submit, bn;

  int[] result = null;

  public SortGradeFrame() {
    super("����γ̺źͳɼ���׼");
    setSize(300, 300);
    setLocation(600, 400);
    contain = new JPanel();
    contain.setLayout(null);
    add(contain);
    id = new JLabel("�γ̺�");
    idt = new JTextField();

    pass = new JLabel("����");
    passt = new JTextField();
    good = new JLabel("����");
    goodt = new JTextField();
    excellent = new JLabel("����");
    excellentt = new JTextField();

    submit = new JButton("�ύ");
    id.setBounds(38, 50, 75, 35);
    idt.setBounds(80, 50, 150, 35);

    pass.setBounds(38, 90, 75, 35);
    passt.setBounds(80, 90, 150, 35);
    good.setBounds(38, 130, 75, 35);
    goodt.setBounds(80, 130, 150, 35);
    excellent.setBounds(38, 170, 75, 35);
    excellentt.setBounds(80, 170, 150, 35);

    submit.setBounds(102, 210, 70, 30);
    contain.add(id);
    contain.add(idt);

    contain.add(pass);
    contain.add(passt);
    contain.add(good);
    contain.add(goodt);
    contain.add(excellent);
    contain.add(excellentt);

    contain.add(submit);
    submit.addActionListener(this);
    setVisible(true);
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);

    idt.setText("");
    passt.setText("");
    goodt.setText("");
    excellentt.setText("");
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == submit) {
      if (idt.getText().equals("") || passt.getText().equals("") || goodt.getText().equals("")
          || excellentt.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ�գ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);

      }
      else if (new GradeSort(idt.getText(), Float.parseFloat(passt.getText()), Float.parseFloat(goodt.getText()),
          Float.parseFloat(excellentt.getText())).isValidate() == 1) {

        JOptionPane.showMessageDialog(null, "�ɼ���׼���ô���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);

      }
      else {
        GradeSort gradeSort = new GradeSort(idt.getText(), Float.parseFloat(passt.getText()),
            Float.parseFloat(goodt.getText()), Float.parseFloat(excellentt.getText()));

        if (gradeSort.hasCourse() == 0) {
          JOptionPane.showMessageDialog(null, "�˿γ̲����ڣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        }
        else {

          this.result = gradeSort.sortGrade();
          showResult();
        }
      }

    }
  }

  void showResult() {

    JFrame fm = new JFrame("�ɼ�ͳ�ƽ��");
    fm.setSize(300, 340);
    JPanel contain = new JPanel();
    fm.setLocation(600, 400);
    contain.setLayout(null);

    JLabel fail = new JLabel("������");
    JLabel pass = new JLabel("����");
    JLabel good = new JLabel("����");
    JLabel excellent = new JLabel("����");

    JTextField failt = new JTextField();
    JTextField passt = new JTextField();
    JTextField goodt = new JTextField();
    JTextField excellentt = new JTextField();

    fail.setBounds(38, 90, 75, 35);
    failt.setBounds(80, 90, 150, 35);
    pass.setBounds(38, 130, 75, 35);
    passt.setBounds(80, 130, 150, 35);
    good.setBounds(38, 170, 75, 35);
    goodt.setBounds(80, 170, 150, 35);
    excellent.setBounds(38, 210, 75, 35);
    excellentt.setBounds(80, 210, 150, 35);

    contain.add(fail);
    contain.add(failt);
    contain.add(pass);
    contain.add(passt);
    contain.add(good);
    contain.add(goodt);
    contain.add(excellent);
    contain.add(excellentt);
    fm.add(contain);

    failt.setText(Integer.toString(this.result[0]) + "��");
    passt.setText(Integer.toString(this.result[1]) + "��");
    goodt.setText(Integer.toString(this.result[2]) + "��");
    excellentt.setText(Integer.toString(this.result[3]) + "��");

    fm.setVisible(true);

  }

}
