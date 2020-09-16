package com.immoc.girl.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlControllerTest {

    @Autowired
    private GirlController girlController;

    @Test
    public void girlList() {
        girlController.girlList();
    }
}