package com.example.admin.basicproject.single_text;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2016/12/28.
 */
public class JavaTextActivityTest {
    private JavaTextActivity javaTextActivity = null;
    @Before
    public void setUp() throws Exception {
        javaTextActivity = new JavaTextActivity();
    }

    @After
    public void tearDown() throws Exception {
        javaTextActivity = null;
    }

    @Test
    public void sayHello() throws Exception {

    }

    @Test
    public void testSayHelloInTheMorning() throws Exception{
        int date = 2;
        String user = "煲约二";
        String result = javaTextActivity.sayHello(date,user);
        assertEquals(result,"Hi,煲约二.Good morning!");
    }

}