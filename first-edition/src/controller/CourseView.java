package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CourseView extends JFrame {
  /*
   * ѧ����ѯ�γ̣���ʦ��ѯ�����ڿγ�
   */

  JPanel contain;
  JTextArea list;

  public CourseView(String id, int flag) {
    super("�γ�");
    setSize(330, 400);
    contain = new JPanel();
    setLocation(600, 400);
    list = new JTextArea();
    list.setEditable(false);
    contain.add(list);
    list.append("�γ̱��\t�γ���\tѧ��\tѧʱ\n");

    String courseid;
    String coursename;
    String credit = null;
    String classhour = null;

    if (flag == 0) { // ѧ����ѯ�γ�

      // String path = "D://test//course_student";
      String path = System.getProperty("user.dir") + "/data/course_student";
      List<String> files = new ArrayList<>(); // Ŀ¼�������ļ�
      File file = new File(path);
      File[] tempList = file.listFiles();

      for (File element : tempList) {
        if (element.isFile()) {
          files.add(element.toString());
          // �ļ�����������·��
          // String fileName = tempList[i].getName();
        }
        if (element.isDirectory()) {
          // ����Ͳ��ݹ���
        }
      }

      try {
        for (String file2 : files) {
          BufferedReader br = new BufferedReader(new FileReader(file2));
          String s = null;
          while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��
            String[] result = s.split(" ");
            if (result[2].equals(id)) { // ѧ��ѧ�����ʱ
              courseid = result[0];
              coursename = result[1];

              // �Ȳ�ÿ�ſ�ע��ѧ���ļ����ٲ�γ���Ϣ�ļ�
              String path1 = System.getProperty("user.dir") + "/data/course.txt";
              BufferedReader br1 = new BufferedReader(new FileReader(path1)); // ����һ��BufferedReader������ȡ�ļ�
              while ((s = br1.readLine()) != null) { // ʹ��readLine������һ�ζ�һ��
                String[] result1 = s.split(" ");
                if (result[0].equals(result1[0])) {
                  credit = result1[2];
                  classhour = result1[3];
                }
              }

              list.append(courseid + "\t");
              list.append(coursename + "\t");
              list.append(credit + "\t");
              list.append(classhour + "\n");

              br1.close();
            }

          }

          br.close();
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    else if (flag == 1) { // ��ʦ��ѯ�Լ����ڿγ�
      String path = System.getProperty("user.dir") + "/data/course.txt";
      // String path = "D://test//course.txt";
      String s = null;

      try {
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((s = br.readLine()) != null) { // ʹ��readLine������һ�ζ�һ��
          String[] result = s.split(" ");
          if (result[4].equals(id)) {
            courseid = result[0];
            coursename = result[1];
            credit = result[2];
            classhour = result[3];

            list.append(courseid + "\t");
            list.append(coursename + "\t");
            list.append(credit + "\t");
            list.append(classhour + "\n");

          }
        }
        br.close();
      }
      catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    add(contain);
    setVisible(true);
  }
}
