package com.esoxjem.movieguide.listing.helpers;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.graphics.Typeface.BOLD;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
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

    public static boolean isObjectClickable(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isClickable()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectAboveSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isAbove(matcher2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectBelowSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isBelow(matcher2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectRightOfSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isRightOf(matcher2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectLeftOfSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isLeftOf(matcher2));
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

    public static void typeSomeTextANoOfTimes(Matcher<View> matcher, String textInput, int noOfTimes) {
        for (int i = 0; i < noOfTimes; i++) {
            onView(matcher).perform(typeText(textInput), pressImeActionButton());
        }
    }

    public static boolean isFontSizeExpectedSize(Matcher<View> matcher, float expectedSize) {
        try {
            onView(matcher).check(matches(EspressoMatchers.withFontSize(expectedSize)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNoOfLinesExpectedSize(Matcher<View> matcher, int expectedSize) {
        try {
            onView(matcher).check(matches(EspressoMatchers.isTextInLines(expectedSize)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void deleteElement(Matcher<View> matcher) {
        onView(matcher).perform(swipeRight());
    }

    public static void pressEnterKeyAndroid(Matcher<View> matcher) {
        onView(matcher).perform(pressImeActionButton());
    }

    public static void performSwipeUp(Matcher<View> matcher) {
        onView(matcher).perform(swipeUp());
    }

    public static boolean isFirstObjectSiblingWithSecondObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(matches(hasSibling(matcher2)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
