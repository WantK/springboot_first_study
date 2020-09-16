package com.immoc.girl.Controller;

import com.immoc.girl.Domain.Girl;
import com.immoc.girl.Domain.Result;
import com.immoc.girl.Repository.GirlRepository;
import com.immoc.girl.Service.GirlService;
import com.immoc.girl.Utils.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 测试微信小程序发送http请求
     * @return
     */
    @GetMapping(value= "/testWechatRequest")
    public String testWechatRequest(){
        return "testSucceed";
    }

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {   //查询所有女生列表
        logger.info("girlList");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult) { //新建一个Girl对象
        if (bindingResult.hasErrors()) {
            return resultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setName(girl.getName());
        girl.setAge(girl.getAge());

        return resultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girls={id}")
    //根据id获取一个Girl对象
    public Girl girlFindOne(@PathVariable("id2") Integer id) { //查询一个女生
        return girlRepository.findById(id).orElse(null);
    }

    @PutMapping(value = "girls/{id}")
    //更新一个Girl对象
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age) {  //更新
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {  //删除
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {  //通过年龄来查询列表
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}


