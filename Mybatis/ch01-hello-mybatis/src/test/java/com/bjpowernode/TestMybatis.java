package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class TestMybatis {
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        //访问mybatis读取student数据
        //1、定义mybatis主配置文件，从类路径的根开始(target/clasess)
        String config = "mybatis.xml";
        //读取这个config表示文件
        InputStream in = Resources.getResourceAsStream(config);
        //创建SqlSessionFactoryBuilder对象
        builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        factory = builder.build(in);
        //获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        sqlSession = factory.openSession(); //sqlSession对象不是线程安全的，执行完后需要关闭

    }

    @After
    public void after() {
        sqlSession.close();
    }

    //测试方法，测试功能, 插入数据操作
    @Test
    public void insert() throws IOException {
        before();
        //指定要执行的sql语句的标签，SQL映射文件中的namespace+","+标签的ID值
        String sqlId = "com.bjpowernode.dao.StudentDao.insertStudent";
        //执行SQL语句，通过sqlId执行
        Student student = new Student();
        student.setId(1003);
        student.setName("张飞");
        student.setEmail("zhangfei@qq.com");
        student.setAge(20);
        int nums = sqlSession.insert(sqlId, student);
        //默认不是自动提交事务，需要手工提交事务
        sqlSession.commit();
        //输出结果
        //  studentList.forEach(stu -> System.out.println(stu));
        System.out.println("nums=" + nums);
        //关闭
        after();
    }
}
