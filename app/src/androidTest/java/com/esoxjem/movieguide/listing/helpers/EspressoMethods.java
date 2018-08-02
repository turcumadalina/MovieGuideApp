package com.esoxjem.movieguide.listing.helpers;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.screen.Movie;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
                return Constants.GETTING_TEXT_FROM_A_TEXT_VIEW;
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
                return Constants.GETTING_TEXT_SIZE_FROM_A_TEXT_VIEW;
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

    public static <T> Matcher<T> getFirstChild(final Matcher<T> matcher) {
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

    public static ViewAction waitForXSeconds(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return Constants.WAIT_FOR + millis + Constants.MILLIS;
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

    public static Matcher<View> getElementFromMatchAtPosition(final Matcher<View> matcher, final int position) {
        return new BaseMatcher<View>() {
            int counter = 0;

            @Override
            public boolean matches(final Object item) {
                if (matcher.matches(item)) {
                    if (counter == position) {
                        counter++;
                        return true;
                    }
                    counter++;
                }
                return false;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText(Constants.ELEMENT_AT_HIERARCHY_POSITION + position);
            }
        };
    }

    public static Matcher<View> hasBoldText() {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText(Constants.HAS_BOLD_TEXT);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (view instanceof TextView) {
                    TextView tv = (TextView) view;
                    return tv.getTypeface().isBold();
                }
                return false;
            }
        };
    }

    public static int getTheNumberOfTextLines(final Matcher<View> matcher) {
        final int[] stringHolder = new int[1];
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return Constants.GETTING_TEXT_LINES_FROM_A_TEXT_VIEW;
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                int lineNo = tv.getLineCount();
                stringHolder[0] = lineNo;
            }
        });
        return stringHolder[0];
    }

    public static Matcher<View> withChildViewCount(final int count, final Matcher<View> childMatcher) {
        return new BoundedMatcher<View, ViewGroup>(ViewGroup.class) {
            @Override
            protected boolean matchesSafely(ViewGroup viewGroup) {
                int matchCount = 0;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (childMatcher.matches(viewGroup.getChildAt(i))) {
                        matchCount++;
                    }
                }
                return matchCount == count;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("ViewGroup with child-count=" + count + " and");
                childMatcher.describeTo(description);
            }
        };
    }

    public static class RecyclerViewItemCountAssertion implements ViewAssertion {
        private final int expectedCount;

        public RecyclerViewItemCountAssertion(int expectedCount) {
            this.expectedCount = expectedCount;
        }

        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }

            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            assertThat(adapter.getItemCount(), is(expectedCount));
        }
    }

    private static int getTextViewCount(ViewGroup viewGroup) {
        int count = 0;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childView = viewGroup.getChildAt(i);

            if (childView instanceof TextView) {
                count++;
            }
            if (childView instanceof ViewGroup) {
                count += getTextViewCount((ViewGroup) childView);
            }
        }
        return count;
    }

    public static int getCountChildrenFromTheRadioGroupList(Matcher<View> matcher) {
        final int[] count = {0};
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(RadioGroup.class);
            }

            @Override
            public String getDescription() {
                return Constants.GETTING_CHILD_COUNT;
            }

            @Override
            public void perform(UiController uiController, View view) {
                RadioGroup radioGroup = (RadioGroup) view;
                count[0] = radioGroup.getChildCount();
            }
        });
        return count[0];
    }

    public static boolean checkTheFirstWord() {
        String theFirstWordOfTheSecondMovie = getText(withText(Constants.THE_FIRST_PURGE)).substring(0, 3);
        String theFirstWordOfTheThirdMovie = getText(withText(Constants.THE_PURGE_ANARCHY)).substring(0, 3);
        return theFirstWordOfTheSecondMovie.equals(theFirstWordOfTheThirdMovie);
    }
}