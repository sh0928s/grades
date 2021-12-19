package controller;

import java.awt.AWTEvent;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddUser extends JFrame implements ActionListener {
  /*
   * �������Ա����û����������ѧ������ʦ������Ա
   */
	//���ƽ���
  JPanel contain;
  JLabel id, name, birthday, institute, major; //JLabel�����ʾ����һ����ǩ��������������ʾ��Ϣ��
  JTextField idt, namet, birthdayt, institutet, majort;
  Checkbox check1, check2; //JCheckBox(String text,boolean selected)������һ��ָ���ı���ѡ��״̬�ĸ�ѡ��
  CheckboxGroup group;
  JButton submit;
  Choice chooice; //java.awt.Choice��һ�������б����

  String file = new File(System.getProperty("user.dir")).getParent() + "/data/";
  // String file = "D://test//";

  public AddUser() {
    super("����û�");
    setSize(300, 350);
    setLocation(600, 400);
    contain = new JPanel();
    contain.setLayout(null); //����JPanel�Ĳ��ֹ�����Ϊ�գ������Լ��ֶ����������������λ�úʹ�С
    id = new JLabel("�ʺ�");
    name = new JLabel("����");
    group = new CheckboxGroup();
    check1 = new Checkbox("��", group, true);
    check2 = new Checkbox("Ů", group, false);
    birthday = new JLabel("����");
    institute = new JLabel("ѧԺ");
    major = new JLabel("רҵ");

    submit = new JButton("�ύ");
    chooice = new Choice();
    chooice.addItem("ѧ��");
    chooice.addItem("��ʦ");
    chooice.addItem("����Ա");

    idt = new JTextField();
    namet = new JTextField();

    birthdayt = new JTextField();
    institutet = new JTextField();
    majort = new JTextField();

    id.setBounds(42, 45, 75, 35);
    idt.setBounds(80, 45, 150, 35);
    // name.setBounds(40, 100, 75, 35);
    // namet.setBounds(80, 100, 150, 35);

    name.setBounds(42, 20, 75, 35);
    namet.setBounds(80, 20, 150, 35);
    check1.setBounds(80, 67, 80, 40);
    check2.setBounds(160, 67, 80, 40);
    birthday.setBounds(42, 100, 75, 35);
    birthdayt.setBounds(80, 100, 150, 35);
    institute.setBounds(40, 145, 75, 35);
    institutet.setBounds(80, 145, 150, 35);
    major.setBounds(40, 220, 75, 35);
    majort.setBounds(80, 220, 150, 35);

    chooice.setBounds(80, 180, 150, 35);
    submit.setBounds(102, 260, 70, 30);
    contain.add(id);
    contain.add(idt);
    contain.add(name);
    contain.add(namet);

    contain.add(birthday);
    contain.add(birthdayt);
    contain.add(institute);
    contain.add(institutet);
    contain.add(major);
    contain.add(majort);
    contain.add(check1);
    contain.add(check2);

    contain.add(chooice);
    contain.add(submit);
    submit.addActionListener(this); //�¼�����
    add(contain);
    setVisible(true);
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
      if (idt.getText().equals("") || namet.getText().equals("") || birthdayt.getText().equals("")
          || institutet.getText().equals("") || majort.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ�գ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);//����
      }
      else {
        String ch = chooice.getSelectedItem();
        if (ch == "ѧ��") {
          if (new CheckInfo().isMember("student", idt.getText(), namet.getText()) == 2) {
            JOptionPane.showMessageDialog(null, "��ѧ���Ѿ����ڣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          }
          else {
            file = file + "student.txt";

            ArrayList<String> modifiedContent = new ArrayList<>();
            // StringBuilder result = new StringBuilder();
            try {
              BufferedReader br = new BufferedReader(new FileReader(file));
              String s = null;
              // �Ƚ�ԭ�����ڵ���Ϣ�洢����(��ʵ����ֱ�Ӳ����ļ����)
              while ((s = br.readLine()) != null) {
                String[] result = s.split(" ");

                String s1 = "";
                for (int i = 0; i < result.length - 1; i++) {
                  s1 = s1 + result[i];
                  s1 = s1 + " ";
                }
                s1 = s1 + result[result.length - 1];
                // System.out.println(s1);
                modifiedContent.add(s1);
              }
              br.close();

            }
            catch (Exception e1) {
              e1.printStackTrace();
            }

            String m;
            if (check1.getState()) {
              m = "male";
            }
            else {
              m = "female";
            }

            String user = idt.getText() + " " + "123456" + " " + namet.getText() + " " + m + " " + birthdayt.getText()
                + " " + institutet.getText() + " " + majort.getText();

            modifiedContent.add(user);

            try {
              FileWriter fw = new FileWriter(file);
              BufferedWriter bw = new BufferedWriter(fw);

              for (String element : modifiedContent) {
                bw.write(element);
                bw.newLine();
              }

              bw.close();
              fw.close();
            }
            catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "�ɹ����һ��ѧ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          }
          
        }
        else if (ch == "��ʦ") {
          if (new CheckInfo().isMember("teacher", idt.getText(), namet.getText()) == 2) {
            JOptionPane.showMessageDialog(null, "�˽�ʦ�Ѿ����ڣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          }
          else {

            file = file + "teacher.txt";

            ArrayList<String> modifiedContent = new ArrayList<>();
            // StringBuilder result = new StringBuilder();
            try {
              BufferedReader br = new BufferedReader(new FileReader(file));
              String s = null;
              while ((s = br.readLine()) != null) { // �Ƚ�ԭ�����ڵ���Ϣ�洢����
                String[] result = s.split(" ");

                String s1 = "";
                for (int i = 0; i < result.length - 1; i++) {
                  s1 = s1 + result[i];
                  s1 = s1 + " ";
                }
                s1 = s1 + result[result.length - 1];
                // System.out.println(s1);
                modifiedContent.add(s1);
              }
              br.close();

            }
            catch (Exception e1) {
              e1.printStackTrace();
            }

            String m;
            if (check1.getState()) {
              m = "male";
            }
            else {
              m = "female";
            }

            String user = idt.getText() + " " + "123456" + " " + namet.getText() + " " + m + " " + birthdayt.getText()
                + " " + institutet.getText() + " " + majort.getText();

            modifiedContent.add(user);

            try {
              FileWriter fw = new FileWriter(file);
              BufferedWriter bw = new BufferedWriter(fw);

              for (String element : modifiedContent) {
                bw.write(element);
                bw.newLine();
              }

              bw.close();
              fw.close();
            }
            catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "�ɹ����һ����ʦ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          }
        }
        else {
          if (new CheckInfo().isMember("administrator", idt.getText(), namet.getText()) == 2) {
            JOptionPane.showMessageDialog(null, "�˽���Ա�Ѿ����ڣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          }
          else {

            file = file.concat("administrator.txt");

            ArrayList<String> modifiedContent = new ArrayList<>();
            // StringBuilder result = new StringBuilder();
            try {
              BufferedReader br = new BufferedReader(new FileReader(file));
              String s = null;
              while ((s = br.readLine()) != null) { // �Ƚ�ԭ�����ڵ���Ϣ�洢����
                String[] result = s.split(" ");

                String s1 = "";
                for (int i = 0; i < result.length - 1; i++) {
                  s1 = s1 + result[i];
                  s1 = s1 + " ";
                }
                s1 = s1 + result[result.length - 1];
                // System.out.println(s1);
                modifiedContent.add(s1);
              }
              br.close();

            }
            catch (Exception e1) {
              e1.printStackTrace();
            }

            String m;
            if (check1.getState()) {
              m = "male";
            }
            else {
              m = "female";
            }

            String user = idt.getText() + " " + "123456" + " " + namet.getText() + " " + m + " " + birthdayt.getText()
                + " " + institutet.getText() + " " + majort.getText();

            modifiedContent.add(user);

            try {
              FileWriter fw = new FileWriter(file);
              BufferedWriter bw = new BufferedWriter(fw);

              for (String element : modifiedContent) {
                bw.write(element);
                bw.newLine();
              }

              bw.close();
              fw.close();
            }
            catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "�ɹ����һ������Ա��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    }
  }

  @Override
  public void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      this.dispose();
      setVisible(false);
    }
  }
}
