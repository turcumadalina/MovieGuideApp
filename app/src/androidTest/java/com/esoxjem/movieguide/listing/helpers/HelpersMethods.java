package com.esoxjem.movieguide.listing.helpers;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

public class HelpersMethods {

    public static boolean isObjectDisplayed(Matcher<View> matcher) {
        try {
            onView(allOf(matcher, isCompletelyDisplayed())).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void performClick(Matcher<View> matcher) {
        onView(matcher).perform(click());
    }

    public static void typeSomeText(Matcher<View> matcher, String textInput) {
        onView(matcher).perform(typeText(textInput));
    }

    public static void pressEnterKeyAndroid(Matcher<View> matcher) {
        onView(matcher).perform(pressImeActionButton());
    }

    public static void performSwipeUp(Matcher<View> matcher) {
        onView(matcher).perform(swipeUp());
    }

    public static String getMovieFirstWord(Matcher<View> matcher) {
        String movieTitle = EspressoMatchers.getText(matcher);
        String[] movieTitleWords = movieTitle.split(" ");
        return movieTitleWords[0];
    }
}