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

  float[] result = null;

  public SortGradeFrame() {
    super("输入课程号和成绩标准");
    setSize(300, 300);
    setLocation(600, 400);
    contain = new JPanel();
    contain.setLayout(null);
    add(contain);
    id = new JLabel("课程号");
    idt = new JTextField();

    pass = new JLabel("及格");
    passt = new JTextField();
    good = new JLabel("良好");
    goodt = new JTextField();
    excellent = new JLabel("优秀");
    excellentt = new JTextField();
    
    submit = new JButton("提交");
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
        JOptionPane.showMessageDialog(null, "信息不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);

      }
      else if (new GradeSort(idt.getText(), Float.parseFloat(passt.getText()), Float.parseFloat(goodt.getText()),
          Float.parseFloat(excellentt.getText())).isValidate() == 1) {

        JOptionPane.showMessageDialog(null, "成绩标准设置错误！", "提示", JOptionPane.INFORMATION_MESSAGE);

      }
      else {
        GradeSort gradeSort = new GradeSort(idt.getText(), Float.parseFloat(passt.getText()),
            Float.parseFloat(goodt.getText()), Float.parseFloat(excellentt.getText()));

        if (gradeSort.hasCourse() == 0) {
          JOptionPane.showMessageDialog(null, "此课程不存在！", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        else {

          this.result = gradeSort.sortGrade();
          showResult();
        }
      }

    }
  }

  void showResult() {

    JFrame fm = new JFrame("成绩统计结果");
    fm.setSize(300, 340);
    JPanel contain = new JPanel();
    fm.setLocation(600, 400);
    contain.setLayout(null);

    JLabel fail = new JLabel("不及格");
    JLabel pass = new JLabel("及格");
    JLabel good = new JLabel("良好");
    JLabel excellent = new JLabel("优秀");
    JLabel average=new JLabel("平均分");
    
    JTextField failt = new JTextField();
    JTextField passt = new JTextField();
    JTextField goodt = new JTextField();
    JTextField excellentt = new JTextField();
    JTextField averaget = new JTextField();
    
    fail.setBounds(38, 60, 75, 35);
    failt.setBounds(80, 60, 150, 35);
    pass.setBounds(38, 100, 75, 35);
    passt.setBounds(80, 100, 150, 35);
    good.setBounds(38, 140, 75, 35);
    goodt.setBounds(80, 140, 150, 35);
    excellent.setBounds(38, 180, 75, 35);
    excellentt.setBounds(80, 180, 150, 35);
    average.setBounds(38, 220, 75, 35);
    averaget.setBounds(80, 220, 150, 35);

    contain.add(fail);
    contain.add(failt);
    contain.add(pass);
    contain.add(passt);
    contain.add(good);
    contain.add(goodt);
    contain.add(excellent);
    contain.add(excellentt);
    contain.add(average);
    contain.add(averaget);
    fm.add(contain);

    failt.setText(Integer.toString((int)this.result[0]) + "人");
    passt.setText(Integer.toString((int)this.result[1]) + "人");
    goodt.setText(Integer.toString((int)this.result[2]) + "人");
    excellentt.setText(Integer.toString((int)this.result[3]) + "人");
    averaget.setText(Float.toString(this.result[4]));

    fm.setVisible(true);

  }

}
