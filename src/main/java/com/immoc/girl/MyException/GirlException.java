package com.immoc.girl.MyException;

import com.immoc.girl.Enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        setCode(resultEnum.getCode());
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
