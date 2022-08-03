package com.bjpowernode;

import com.bjpowernode.impl.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import org.testng.annotations.Test;

import java.util.List;


public class MyTest {

    @Test  //传统dao的使用
    public void test1() {
        //com.bjpowernode.dao.StudentDao
        StudentDaoImpl dao = new StudentDaoImpl();
        List<Student> studentLis = dao.selectStudents();
        for (Student student : studentLis) {
            System.out.println(student);
        }
    }
    @Test //mybatis的动态代理
    public void test11() {
        //com.bjpowernode.dao.StudentDao
       // StudentDaoImpl dao = new StudentDaoImpl();
        /**
         *    myabtis的
         *   List<Student> studentLis = dao.selectStudents();调用
         *   1、dao对象，类型是StudentDao，全限定名称：com.bjpowernode.dao.StudentDao
         *      全限定名称和namespace一样的
         *   2、方法名称  selectStudents 这就是 mapper中id
         *
         *   3、通过dao方法中的返回值也可以确定MyBatis要调用的sqlSession的方法
         *     如果返回值是List，调用的是sqlSession.selectStudents()方法
         *     如果返回值是int，或者是非List，看mapper文件中的标签是<insert><update> 就是调用的是sqlSession.insert update
         *
         *     mybatis的动态代理：mybatis根据dao的方法调用，获取执行sql语句的信息
         *           mybatis根据你的dao接口，创建出一个dao的实现类，并创建这个对象
         *           完成sqlSession调用方法，访问数据库。
         */
//        List<Student> studentLis = dao.selectStudents();
//        for (Student student : studentLis) {
//            System.out.println(student);
//        }


    }
    //插入
    @Test
    public void test2(){
        StudentDaoImpl dao=new StudentDaoImpl();
        Student student1=new Student();
        student1.setId(1005);
        student1.setName("李华");
        student1.setEmail("lihua@qq.com");
        student1.setAge(31);
        int nums=dao.insertStudent(student1);
        System.out.println(nums);
    }
}
