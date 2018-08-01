package com.esoxjem.movieguide.listing.helpers;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;

public class HelpersMethods extends EspressoMethods {
    public static boolean isVisible(Matcher<View> matcher) {
        try {
            onView(allOf(matcher, isCompletelyDisplayed())).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static void clickAction(Matcher<View> matcher) {
        onView(matcher).perform(click());
    }

    public static void swipeUpAction(Matcher<View> matcher) {
        onView(matcher).perform(swipeUp());
    }

    public static void typeTextAction(Matcher<View> matcher, String itemName) {
        onView(matcher).perform(typeText(itemName));
    }
}