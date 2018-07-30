package com.esoxjem.movieguide.listing.helpers;

import android.support.test.espresso.AppNotIdleException;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
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

    public static ViewAction swipeFromTopToBottom() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }


}