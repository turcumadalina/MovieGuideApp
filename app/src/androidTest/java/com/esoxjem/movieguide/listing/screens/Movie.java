package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class Movie {

    // This is for Favorite movie test
    public static boolean isFavoriteButtonDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withId(R.id.favorite));
    }

    public static void clickFavoriteButton() {
        HelpersMethods.clickUIElement(withId(R.id.favorite));
    }

    public static void clickBackButton() {
        HelpersMethods.clickUIElement(withContentDescription(Constants.NAVIGATE_UP));
    }

    public static void swipeUpTheContent() {
        HelpersMethods.swipeUpOnScreen(withId(R.id.main_content));
    }

    // This is for Movie end to ent test
    public static boolean isMovieNameSelectedTheSameWithSearchedMovie() {
        HelpersMethods.waitForScreenToLoad();
        return HelpersMethods.isUIObjectDisplayed(allOf(withId(R.id.movie_name), withText(Constants.SKYSCRAPER)));
    }

    public static boolean isMoviePosterDisplayed() {
        HelpersMethods.waitForScreenToLoad();
        return HelpersMethods.isUIObjectDisplayed(withId(R.id.movie_poster));
    }

    public static int getNumberOfTextLinesFromMovieDescription() {
        return EspressoMatchers.getNoOfTextLines(withId(R.id.movie_description));
    }

    public static boolean isSummaryTextBold() {
        return HelpersMethods.isUIObjectDisplayed(allOf(withText(Constants.SUMMARY), EspressoMatchers.withBoldStyle()));
    }

    // This is for Highest Rated Movie test
    public static boolean isToolbarDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withId(R.id.toolbar));
    }

    public static void clickOnFirstMovieTrailer() {
        HelpersMethods.clickUIElement(EspressoMatchers.childAtPositionViewGroup(withId(R.id.trailers), 0));
    }

    public static int getSummaryTextSize() {
        return EspressoMatchers.getTextSize(withText(Constants.SUMMARY));
    }

    public static int getTrailersTextSize() {
        return EspressoMatchers.getTextSize(withText(Constants.TRAILERS));
    }

    public static String appActivityName() {
        return HelpersMethods.appActivity();
    }
}