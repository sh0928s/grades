package controller;

import model.Course;

public class GradeSort {
  /*
   * ��ʦ��ѯ�ɼ�ͳ�ƽ��
   */

  String courseId;
  float pass, good, excellent; // ��������������
  Course course;

  public GradeSort(String courseId, float pass, float good, float excellent) {

    this.course = new Course(courseId, pass, good, excellent);
  }

  public int hasCourse() {
    return this.course.hasCourse();
  }

  public int[] sortGrade() {

    return this.course.sortGrade();
  }

  public int isValidate() { // ����ĳɼ���׼�Ƿ�����������[0, 100],�Լ�pass<good<excellent
    return this.course.isValidate();
  }

}
