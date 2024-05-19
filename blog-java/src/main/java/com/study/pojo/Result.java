package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code; //响应码 1成功 0失败
    private String msg; //响应信息 描述字符串
    private Object data; //返回的数据

    public static Result success(){
        return new Result(1,"success",null);
        //成功
    }

    public static Result success(Object data){
        //成功
        return new Result(1,"success",data);
    }

    public static Result success(Object data,String msg){
        //成功
        return new Result(1,msg,data);
    }

    public static Result error(String msg){
        //失败
        return new Result(0,msg,null);
    }
}
