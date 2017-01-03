package com.example.admin.basicproject.io;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2016/12/30.
 */
public class TextTest {
    private Text text = null;
    @Before
    public void setUp() throws Exception {
       text = new Text();
    }

    @Test
    public void all() throws Exception {
       System.out.print("   sum  " +text.all(10));
    }

}