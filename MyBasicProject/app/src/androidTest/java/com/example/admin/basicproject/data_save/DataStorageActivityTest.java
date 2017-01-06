package com.example.admin.basicproject.data_save;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.single_text.SingleTextActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by admin on 2017/1/6.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class DataStorageActivityTest {
    private static final String STRING_TO_BE_TYPED = "androidTest";

    @Rule
    public ActivityTestRule<DataStorageActivity> mActivityRule = new ActivityTestRule<>(
            DataStorageActivity.class);

    @Test
    public void sayHello() {

        //获取button并模拟点击
        onView(withId(R.id.btn_lite_pal)).perform(click());
    }
}