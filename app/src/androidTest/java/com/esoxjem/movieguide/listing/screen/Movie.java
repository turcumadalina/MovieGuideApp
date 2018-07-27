package com.esoxjem.movieguide.listing.screen;

import android.widget.LinearLayout;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import org.hamcrest.Matchers;

import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Movie {

    public static void swipeUpMoviePage() {
        HelpersMethods.swipeUpAction(withId(R.id.movie_details_container));
    }

    public static boolean isTheMoviePosterVisible() {
        return HelpersMethods.isVisible(withId(R.id.movie_poster));
    }

    public static boolean isTheToolbarVisible() {
        return HelpersMethods.isVisible(withId(R.id.toolbar));
    }

    public static boolean isLinearLayoutVisible() {
//        return HelpersMethods.isVisible(allOf(instanceOf(LinearLayout.class), withChild(withText(R.string.action_filter))));
//        return HelpersMethods.isVisible(allOf(withParent(instanceOf(LinearLayout.class)))), withText("Sort By"));
//        return HelpersMethods.isVisible(allOf(instanceOf(LinearLayout.class), withChild(withText(R.string.action_filter))));
//        return HelpersMethods.isVisible(allOf(instanceOf(android.widget.LinearLayout.class)), withText("Sort By"));
        return HelpersMethods.isVisible(withClassName(Matchers.equalTo(LinearLayout.class.toString())));
    }


}
