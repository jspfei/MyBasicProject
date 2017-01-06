package com.example.admin.basicproject.litepal;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by admin on 2017/1/6.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LitePalActivityTest {

    @Rule
    public ActivityTestRule<LitePalActivity> mActivityRule = new ActivityTestRule<>(
            LitePalActivity.class);

    @Test
    public void updateData() throws Exception {

    }

}