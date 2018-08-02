package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;

public class Home {

    // This is for Favorite movie test
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

    // This is for Movie end to ent test
    public static void searchForSkyscraperMovie() {
        HelpersMethods.clickUIElement(withId(R.id.action_search));
        HelpersMethods.typeItemText(withId(R.id.search_src_text), Constants.SKYSCRAPER);
        onView(withId(R.id.search_src_text)).perform(pressImeActionButton());
    }

    // This is for Highest Rated Movies Test
    public static void clickOnHighestRatedButton() {
        HelpersMethods.clickUIElement(withId(R.id.highest_rated));
    }

    public static boolean isFirstChildOfALinearLayoutWithTextDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(allOf(EspressoMatchers.childAtPositionViewGroup(instanceOf(android.widget.LinearLayout.class), 0), withText(Constants.SORT_BY)));
    }

    public static boolean isSecondChildOfSortingGroupWithTextHighestRated() {
        return HelpersMethods.isUIObjectDisplayed(allOf(EspressoMatchers.childAtPositionViewGroup(withId(R.id.sorting_group), 1), withText(Constants.HIGHEST_RATED)));
    }
}