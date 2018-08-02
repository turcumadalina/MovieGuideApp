package com.esoxjem.movieguide.listing.helpers;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static com.esoxjem.movieguide.listing.helpers.EspressoTestBase.device;

public class EspressoMatchers {

    public static Matcher<View> nthChildOf(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with " + childPosition + " child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }
                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
            }
        };
    }

    public static Matcher<View> nthChildOfRadioGroup(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with " + childPosition + " child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof RadioGroup)) {
                    return parentMatcher.matches(view.getParent());
                }
                RadioGroup group = (RadioGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
            }
        };
    }

    public static Matcher<View> withFontSize(final float expectedSize) {
        return new BoundedMatcher<View, View>(View.class) {

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

    public static int getTextSize(final Matcher<View> matcher) {
        final int[] stringHolder = new int[1];
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting textSize from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                float pixels = tv.getTextSize();
                float scaledPixels = pixels / view.getResources().getDisplayMetrics().scaledDensity;
                stringHolder[0] = (int) scaledPixels;
            }
        });
        return stringHolder[0];
    }

    public static int getTextLineNo(final Matcher<View> matcher) {
        final int[] stringHolder = new int[1];
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text lines from a TextView";
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

    public static TypeSafeMatcher<View> isTextInLines(final int lines) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                return ((TextView) item).getLineCount() == lines;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("isTextInLines");
            }
        };
    }

    public static int getRecyclerViewChildCount(Matcher<View> matcher) {
        final int[] count = {0};
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(RecyclerView.class);
            }

            @Override
            public String getDescription() {
                return "getting child count";
            }

            @Override
            public void perform(UiController uiController, View view) {
                RecyclerView rv = (RecyclerView) view;
                count[0] = rv.getChildCount();
            }
        });
        return count[0];
    }

    public static <T> Matcher<T> getFirstElement(final Matcher<T> matcher) {
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
                description.appendText("should return first matching item");
            }
        };
    }

    public static String getText(final Matcher<View> matcher) {
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
                TextView tv = (TextView) view;
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }

    public static String getTextFromRadioButton(final Matcher<View> matcher) {
        final String[] stringHolder = {null};
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(RadioButton.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a RadioGroup";
            }

            @Override
            public void perform(UiController uiController, View view) {
                RadioButton rb = (RadioButton) view;
                stringHolder[0] = rb.getText().toString();
            }
        });
        return stringHolder[0];
    }

    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

    public static Matcher<View> withBoldStyle() {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("the resource is with Bold style");
            }

            @Override
            public boolean matchesSafely(View view) {
                TextView textView = (TextView) view;
                return (textView.getTypeface().isBold());
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
                description.appendText("Element at hierarchy position " + position);
            }
        };
    }

    public static ViewAction swipeFromBottomToTop() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    // The commented code below is part of some demo framework

//    public static boolean XYSwipe() {
//        return device.swipe(device.getDisplayWidth()/2, device.getDisplayHeight() - 10, device.getDisplayWidth()/2, 0, 20);
//    }

    public static boolean XYSmallScroll() {
        return device.swipe(device.getDisplayWidth() / 2, device.getDisplayHeight() / 4 * 3, device.getDisplayWidth() / 2, device.getDisplayHeight() / 4, 20);
    }
}