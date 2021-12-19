package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Course {

  private String courseId;
  private String courseName;
  private String teacherId;
  private String teacherName;
  private String credit;
  private String hour;
  private float fail, pass, good, excellent;// ռ��

  public Course(String courseId, float pass, float good, float excellent) {
    super();
    this.courseId = courseId;
    this.pass = pass;
    this.good = good;
    this.excellent = excellent;
  }

  public Course(String courseId, String courseName, String teacherId, String teacherName, String credit, String hour) {

    this.courseId = courseId;
    this.courseName = courseName;
    this.teacherId = teacherId;
    this.teacherName = teacherName;
    this.credit = credit;
    this.hour = hour;
  }

  public Course(String courseId, String courseName, String teacherId, String teacherName, float fail, float pass,
      float good, float excellent) {

    this.courseId = courseId;
    this.courseName = courseName;
    this.teacherId = teacherId;
    this.teacherName = teacherName;
    this.fail = fail;
    this.pass = pass;
    this.good = good;
    this.excellent = excellent;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  public float getFial() {
    return fail;
  }

  public void setFial(float fial) {
    this.fail = fial;
  }

  public float getPass() {
    return pass;
  }

  public void setPass(float pass) {
    this.pass = pass;
  }

  public float getGood() {
    return good;
  }

  public void setGood(float good) {
    this.good = good;
  }

  public float getExcellent() {
    return excellent;
  }

  public void setExcellent(float excellent) {
    this.excellent = excellent;
  }

  public String getCredit() {
    return credit;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }

  public String getHour() {
    return hour;
  }

  public void setHour(String hour) {
    this.hour = hour;
  }

  public float getFail() {
    return fail;
  }

  public void setFail(float fail) {
    this.fail = fail;
  }

  // �ж�course.txt�Ƿ����
  public int hasCourse() {
    String file = new File(System.getProperty("user.dir")).getParent() + "/data/course.txt";
    // String file = "D://test//course.txt";
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String s = null;
      while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��
        String[] result = s.split(" ");
        if (result[0].equals(this.courseId)) {
          br.close();
          return 1;
        }
      }
      br.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  // ͳ�Ƹ�������ѧ��������ƽ����
  public float[] sortGrade() {
    int failCount = 0, passCount = 0, goodCount = 0, excellentCount = 0,count=0;
    float average=0;
    String path = new File(System.getProperty("user.dir")).getParent() + "/data/grade";

    List<String> fileNameList = new ArrayList<>(); // Ŀ¼�������ļ�
    File filePath = new File(path);
    File[] fileDirArray = filePath.listFiles();// javaû��Directory��

    for (File element : fileDirArray) {
      if (element.isFile()) {
        fileNameList.add(element.toString());
        // �ļ�����������·��
        // String fileName = tempList[i].getName();
      }
      if (element.isDirectory()) {

      }
    }

    BufferedReader br = null;
    String targetFile = null;

    // Ѱ�Ҷ�Ӧ���γ̵ĳɼ��ļ�����ʵֱ��ͨ���ļ����жϲ�����ݣ���
    try {
      for (String fileName : fileNameList) {
        br = new BufferedReader(new FileReader(fileName));
        String s = null;
        if ((s = br.readLine()) != null) {
          String[] result = s.split(" ");
          if (result[0].equals(this.courseId)) {
            targetFile = fileName;
            break;
          }
        }
        br.close();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    try {
      br = new BufferedReader(new FileReader(targetFile));
      String s = null;
      while ((s = br.readLine()) != null) {
        String[] result = s.split(" ");
        if (Float.parseFloat(result[6]) < this.pass) {
          failCount += 1;
        }
        else if (Float.parseFloat(result[6]) < this.good) {
          passCount += 1;
        }
        else if (Float.parseFloat(result[6]) < this.excellent) {
          goodCount += 1;
        }
        else {
          excellentCount += 1;
        }
        average+=Float.parseFloat(result[6]);
        count+=1;
      }
      br.close();
      average=average/count;
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return new float[] { failCount, passCount, goodCount, excellentCount,average };
  }

  public int isValidate() { // ����ĳɼ���׼�Ƿ�����������[0, 100],�Լ�pass<good<excellent
    if (this.pass < 0 || this.pass > 100 || this.good < 0 || this.good > 100 || this.excellent < 0
        || this.excellent > 100 || this.pass >= good || this.pass >= excellent || this.good >= excellent) {
      return 1;
    }
    return 0;
  }

}
