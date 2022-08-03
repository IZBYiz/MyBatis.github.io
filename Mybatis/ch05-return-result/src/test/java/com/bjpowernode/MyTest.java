package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class MyTest {
    @Test
    public void select() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//动态绑定机制
        Student student = dao.selectStudentById(1002);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void selectMulitParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectMulitParam("李四", 20);
        for (Student o : student) {
            System.out.println(o);
        }
        sqlSession.close();
    }

    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selectStudentReturnViewStudent(1005);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testCount() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int counts = dao.countStudent();
        System.out.println(counts);
        sqlSession.close();
    }

    @Test
    public void testMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println("map=" + map);
        sqlSession.close();
    }

    @Test
    public void testSelectMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectAllStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> studentList = dao.selectStudents();
        for (MyStudent student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> studentList = dao.selectDiffColProperty();
        for (MyStudent student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectLikeOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备好like的内容
        String name = "%张%";
        List<Student> studentList = dao.selectLikeOne(name);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }


    @Test
    public void selectLikeTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备好like的内容
        String name = "李";
        List<Student> studentList = dao.selectLikeTwo(name);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
