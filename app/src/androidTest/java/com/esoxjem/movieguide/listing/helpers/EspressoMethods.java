package com.esoxjem.movieguide.listing.helpers;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.screen.Movie;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class EspressoMethods {
    public static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText(Constants.CHILD_AT_POSITION + position + Constants.IN_PARENT);
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static class MyViewAction {

        public static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return null;
                }

                @Override
                public String getDescription() {
                    return Constants.CLICK_ON_A_CHILD_VIEW_WITH_SPECIFIED_ID;
                }

                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    v.performClick();
                }
            };
        }
    }

    public static void checkTheNoteValue(int xItemsRequired) {
        for (int moviePosition = 0; moviePosition <= xItemsRequired; moviePosition++) {
            onView(withId(R.id.movies_listing)).perform(RecyclerViewActions.actionOnItemAtPosition(moviePosition, EspressoMethods.MyViewAction.clickChildViewWithId(R.id.movie_container)));
            String myStringValue = getText(withId(R.id.movie_rating));
            myStringValue = myStringValue.substring(0, myStringValue.length() - 3);
            double myParsedValue = Double.parseDouble(myStringValue);
            if (myParsedValue >= 8) {
                Movie.clickBackButton();
            }
        }
    }

    private static String getText(final Matcher<View> matcher) {
        final String[] stringHolder = {null};
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return Constants.GETTING_TEXT_FROM_A_TEXTVIEW;
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }

    public static int getFontSize(final Matcher<View> matcher) {
        final int[] stringHolder = new int[1];
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return Constants.GETTING_TEXT_SIZE_FROM_A_TEXTVIEW;
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                float pixels = tv.getTextSize();
                float actualSize = pixels / view.getResources().getDisplayMetrics().scaledDensity;
                stringHolder[0] = (int) actualSize;
            }
        });
        return stringHolder[0];
    }

    public static <T> Matcher<T> first(final Matcher<T> matcher) {
        return new BaseMatcher<T>() {
            boolean isFirst = true;

            @Override
            public boolean matches(final Object item) {
                if (isFirst && matcher.matches(item)) {
                    isFirst = false;
                    return true;
                }
                return false;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText(Constants.SHOULD_RETURN_FIRST_MATCHING_ITEM);
            }
        };
    }
}