package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

public class Movie {

    public static String getMovieName() {
        return EspressoMatchers.getText(withId(R.id.movie_name));
    }

    public static boolean isSummaryTextBold() {
        return HelpersMethods.isObjectDisplayed(allOf(withText(Constants.SUMMARY), EspressoMatchers.withBoldStyle()));
    }

    public static void performSwipeUp() {
        HelpersMethods.performSwipeUp(isRoot());
    }

    public static boolean isMoviePosterDisplayed() {
        return HelpersMethods.isObjectDisplayed(withId(R.id.movie_poster));
    }

    public static int getMovieDescriptionTextLineNo() {
        return EspressoMatchers.getTextLineNo(withId(R.id.movie_description));
    }

    public static boolean isFavouritesButtonDisplayed() {
        return HelpersMethods.isObjectDisplayed(withId(R.id.favorite));
    }

    public static void clickFavouritesButton() {
        HelpersMethods.performClick(withId(R.id.favorite));
    }

    public static void navigateBack() {
        HelpersMethods.performClick(allOf(withParent(withId(R.id.toolbar)), instanceOf(android.widget.ImageButton.class)));
    }

    public static void clickSortAction() {
        HelpersMethods.performClick(withId(R.id.action_sort));
    }

    public static void clickFavorites() {
        HelpersMethods.performClick(withId(R.id.favorites));
    }

    public static boolean isHighestRatingSiblingWithFavorites() {
        return HelpersMethods.isObjectDisplayed(allOf(withId(R.id.highest_rated), hasSibling(withId(R.id.favorites))));
    }
}
