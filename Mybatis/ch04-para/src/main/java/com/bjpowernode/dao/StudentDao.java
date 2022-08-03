package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.*;


public interface StudentDao {
   /**
    * 一个简单的类型参数：
    *     简单类型：mybatis把Java的基础数据类型和String都叫简单类型
    * 在mapper文件中获取简单类型一个参数值，使用#{任意字符}
    * @param id
    * @return int
    */
   public Student selectStudentById(Integer id);
   /**
    * 多个参数：命名参数，在形参定义的前面加入@param("自定义参数名称")
    */
   List<Student> selectMulitParam(@Param("myname") String name,
                                  @Param("myage") Integer age);

   /**
    * 多个参数，使用Java对象作为接口中的方法的参数
    */
   List<Student> selectMultiObject(QueryParam queryParam);

   /**
    * 按位置传输，了解
    * mybatis 3.4之前使用的是#{0} #{1}
    * mybatis 3。4之后使用的是#{arg0} #{arg1}
    */
   List<Student> selectMultiPosition(String name,Integer age);

   /**
    * Map传值
    */
   List<Student> selectMultiMap(Map<String,Object> map);
}
