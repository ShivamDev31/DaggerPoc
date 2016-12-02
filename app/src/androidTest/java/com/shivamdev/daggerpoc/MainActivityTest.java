package com.shivamdev.daggerpoc;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.shivamdev.daggerpoc.features.git.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by shivam on 31/8/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void submitButtonClick() {
        onView(withId(R.id.et_name)).perform(ViewActions.typeText("Shivam"));
        onView(withId(R.id.b_submit)).perform(ViewActions.click());
        onView(withId(R.id.tv_text)).check(matches(withText("Hello Shivam")));
    }
}
