package com.bjpowernode.dao;
import com.bjpowernode.domain.Student;
import java.util.*;

public interface StudentDao {

    //动态SQL，使用Java对象作为参数
    List<Student> selectStudentIf(Student student);

    //使用where
    List<Student> selectStudentWhere(Student student);

    //foreach使用
    List<Student> selectStudentForeachOne(List<Integer> idlist);

    //foreach使用2
    List<Student> selectStudentForeachTwo(List<Student> stulist);
}
