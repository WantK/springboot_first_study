package com.immoc.girl.Service;

import com.immoc.girl.Domain.Girl;
import com.immoc.girl.Enums.ResultEnum;
import com.immoc.girl.MyException.GirlException;
import com.immoc.girl.Repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void getAge(Integer id) throws GirlException {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回 "小学" code = 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age >= 10 && age < 16) {
            //返回 "中学" code = 101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            //返回 "大学以上" code = 102
            throw new GirlException(ResultEnum.COLLEGE);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findById(id).orElse(null);
    }
}
