package com.esoxjem.movieguide.listing.helpers;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.screen.Movie;

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
                description.appendText("Child at position " + position + " in parent ");
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
                    return "Click on a child view with specified id.";
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
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }

    public static Matcher<View> withFontSize(final float expectedSize) {
        return new BoundedMatcher<View, View>(TextView.class) {

            @Override
            public boolean matchesSafely(View target) {
                if (!(target instanceof TextView)) {
                    return false;
                }
                TextView targetEditText = (TextView) target;
                float pixels = targetEditText.getTextSize();
                float actualSize = pixels / target.getResources().getDisplayMetrics().scaledDensity;
                return Float.compare(actualSize, expectedSize) == 0;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with fontSize: ");
                description.appendValue(expectedSize);
            }
        };
    }

    public static void checkFontSize(Matcher<View> myMatcher) {
        String myString = getText(myMatcher);
    }

    public class FontSizeMatcher extends TypeSafeMatcher<View> {

        private final float expectedSize;

        public FontSizeMatcher(float expectedSize) {
            super(View.class);
            this.expectedSize = expectedSize;
        }

        @Override
        protected boolean matchesSafely(View target) {
            if (!(target instanceof TextView)) {
                return false;
            }
            TextView targetEditText = (TextView) target;
            return targetEditText.getTextSize() == expectedSize;
        }


        @Override
        public void describeTo(Description description) {
            description.appendText("with fontSize: ");
            description.appendValue(expectedSize);
        }
    }
}