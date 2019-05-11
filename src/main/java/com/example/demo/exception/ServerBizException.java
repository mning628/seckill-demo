package com.example.demo.exception;

/**
 * Created by Administrator on 2019/5/10.
 */
public class ServerBizException extends  RuntimeException
{
    private String  code;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public ServerBizException(String code)
    {
        this.code = code;
    }
}
