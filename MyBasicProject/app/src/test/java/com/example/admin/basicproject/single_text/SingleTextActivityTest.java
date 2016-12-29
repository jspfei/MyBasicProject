package com.example.admin.basicproject.single_text;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import com.example.admin.basicproject.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by admin on 2016/12/27.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SingleTextActivityTest {
    private static final String STRING_TO_BE_TYPED = "androidTest";

    @Rule
    public ActivityTestRule<SingleTextActivity> mActivityRule = new ActivityTestRule<>(
            SingleTextActivity.class);

    @Test
    public void sayHello() {
        //获取editText并输入字符串
        onView(withId(R.id.et)).perform(typeText(STRING_TO_BE_TYPED), ViewActions.closeSoftKeyboard()); //line 1

        //获取button并模拟点击
//        onView(withText("Say hello!")).perform(click()); //line 2
        onView(withId(R.id.btn)).perform(click());

        //比较应用中textView与期望字符自否匹配
        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
        onView(withId(R.id.tv)).check(matches(withText(expectedText))); //line 3
    }
}