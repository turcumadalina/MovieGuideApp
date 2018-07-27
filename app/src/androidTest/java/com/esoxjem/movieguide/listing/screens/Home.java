package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Home {

    public static boolean isMovieGuideTextDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withText(Constants.MOVIE_GUIDE));
    }

    public static void clickSearchButton() {
        HelpersMethods.clickUIElement(withId(R.id.action_search));
    }

    public static void typeMovieName() {
        HelpersMethods.typeItemText(withId(R.id.search_src_text), Constants.PURGE);
    }

    public static void clickAndroidSearchButton() {
        onView(withId(R.id.search_src_text)).perform(pressImeActionButton());
    }
}