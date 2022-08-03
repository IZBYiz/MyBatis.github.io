package com.bjpowernode.vo;

/**
 * 使用对象传递参数
 */
public class QueryParam {
    private String paramName;
    private Integer paramAge;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "paramName='" + paramName + '\'' +
                ", paramAge=" + paramAge +
                '}';
    }
}