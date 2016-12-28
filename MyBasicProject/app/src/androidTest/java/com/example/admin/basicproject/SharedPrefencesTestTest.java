package com.example.admin.basicproject;

import com.example.admin.basicproject.data_save.bean.Userbean;
import com.example.admin.basicproject.data_save.utils.ListDataSave;

import org.junit.Test;

import java.util.ArrayList;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.*;

/**
 * Created by admin on 2016/12/27.
 */
public class SharedPrefencesTestTest {
    @Test
    public void testSharedPreferences() throws Exception {
        ArrayList<Userbean> listBean = new ArrayList<Userbean>();
        ListDataSave listDataSave = new ListDataSave(getContext(),"jf");
        Userbean user = new Userbean();
        user.setName("小凡");
        user.setAge(16);
        listBean.add(user);
        listDataSave.setDataList("javaBean",listBean);

        System.out.println(listDataSave.getDataList("javaBean").toString()) ;
    }

}