package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.*;

public class MyTest {
    @Test
    public void testSelectStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//动态绑定机制
        Student student = new Student();
        //  student.setName("张飞");
        student.setAge(25);
        List<Student> studentList = dao.selectStudentIf(student);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }

    @Test
    public void testSelectStudentWhere() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//动态绑定机制
        Student student = new Student();
        // student.setName("张飞");
        student.setAge(25);
        List<Student> studentList = dao.selectStudentWhere(student);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }

    @Test
    public void selectStudentForeachOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//动态绑定机制
        List<Integer> list1 = new ArrayList<>();
        list1.add(1001);
        list1.add(1002);
        list1.add(1003);
        List<Student> studentList = dao.selectStudentForeachOne(list1);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }

    @Test
    public void selectStudentForeachTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//动态绑定机制
        List<Student> list2 = new ArrayList<>();
       Student student=new Student();
       student.setId(1002);
       list2.add(student);
       student=new Student();
       student.setId(1005);
       list2.add(student);
       student=new Student();
       student.setId(1004);
       list2.add(student);
        List<Student> studentList = dao.selectStudentForeachTwo(list2);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }
}
