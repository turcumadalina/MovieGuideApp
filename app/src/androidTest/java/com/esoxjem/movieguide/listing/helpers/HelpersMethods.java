package com.esoxjem.movieguide.listing.helpers;

import android.support.test.espresso.AppNotIdleException;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.NoMatchingViewException;
import android.view.View;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static com.esoxjem.movieguide.listing.helpers.EspressoTestBase.device;

public class HelpersMethods {

    public static void clickUIElement(Matcher<View> matcher) {
        onView(matcher).perform(click());
    }

    public static void typeItemText(Matcher<View> matcher, String textToBeTyped) {
        onView(matcher).perform(typeText(textToBeTyped));
    }

    public static boolean isUIObjectDisplayed(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isCompletelyDisplayed()));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static void waitForScreenToLoad() {
        onView(isRoot()).perform(EspressoMatchers.waitToLoad(2000));
    }

    public static void swipeUpOnScreen(Matcher<View> matcher) {
        onView(matcher).perform(swipeUp());
    }

    public static String getMovieNameFirstWord(Matcher<View> matcher) {
        String movieTitle = EspressoMatchers.getText(matcher);
        String[] movieTitleWords = movieTitle.split(" ");
        return movieTitleWords[0];
    }

    public static boolean swipeOnXYCoordinates() {
        return device.swipe(device.getDisplayWidth() / 2, device.getDisplayHeight() - 45 * device.getDisplayHeight() / 100,
                device.getDisplayWidth() / 2, device.getDisplayHeight() - 60 * device.getDisplayHeight() / 100, 10);
    }
}