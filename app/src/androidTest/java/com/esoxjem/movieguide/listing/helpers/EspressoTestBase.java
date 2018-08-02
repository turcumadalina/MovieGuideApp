package com.esoxjem.movieguide.listing.helpers;

import android.support.test.filters.LargeTest;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.esoxjem.movieguide.listing.MoviesListingActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;


@LargeTest
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)

public class EspressoTestBase {

    // The commented code below is part of some demo framework
    @Before
    public void clearData() throws UiObjectNotFoundException {
        device.pressHome();
        UiObject appButton = device.findObject(new UiSelector().description("Apps"));
        UiObject movieGuideButton = device.findObject(new UiSelector().description("MovieGuide"));
        UiObject storage = device.findObject(new UiSelector().text("Storage"));
        UiObject clear = device.findObject(new UiSelector().text("CLEAR DATA"));
        UiObject ok = device.findObject(new UiSelector().text("OK"));
        if (appButton.exists()) {
            appButton.click();
        }
        if (movieGuideButton.exists()) {
            movieGuideButton.dragTo(device.getDisplayWidth() / 4, device.getDisplayHeight() / 10, 40);
        }
        if (storage.exists()) {
            storage.click();
        }
        if (clear.exists()) {
            clear.click();
        }
        if (ok.exists()) {
            ok.click();
        }
        device.pressHome();
    }

    @Rule
    public final ActivityTestRule<MoviesListingActivity> activityTestRule = new ActivityTestRule<>(MoviesListingActivity.class, false, false);

    public static UiDevice device = UiDevice.getInstance(getInstrumentation());
}