package com.shivamdev.daggerpoc;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.shivamdev.daggerpoc.features.git.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by shivam on 31/8/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule mMainActivityActivityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void submitButtonClick() {

    }
}
