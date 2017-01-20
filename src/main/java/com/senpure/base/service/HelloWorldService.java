package com.senpure.base.service;

import com.senpure.base.dao.HelloWorldDao;
import com.senpure.base.entity.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2017/1/16.
 */


@Service
@Transactional
public class HelloWorldService {

    @Autowired
    private HelloWorldDao dao;



    public void addOne() {


        for (int i = 0; i < 10; i++) {
            HelloWorld helloWorld = new HelloWorld();
            helloWorld.setNumber(i);
            helloWorld.setStr("str_"+i);
            if(i==5)
            {  helloWorld.setStr("12340");}
            dao.save(helloWorld);
        }

    }
    public  void update(int id)
    {
        HelloWorld helloWorld = new HelloWorld();

        helloWorld.setId(id);
        helloWorld.setStr("up");
        dao.save(helloWorld);
    }
}
