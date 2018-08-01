package com.esoxjem.movieguide.listing.screen;

import android.support.test.espresso.contrib.RecyclerViewActions;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMethods;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class Movie {
    public static void clickMoviesAndCheckTheValueOfTheNotes() {
        EspressoMethods.checkTheNoteValue(3);
    }

    public static void clickBackButton() {
        HelpersMethods.clickAction(withContentDescription(Constants.NAVIGATE_UP));
    }

    public static void clickOnRequiredMovie() {
        onView(withId(R.id.movies_listing)).perform(RecyclerViewActions.actionOnItemAtPosition(0, EspressoMethods.MyViewAction.clickChildViewWithId(R.id.movie_container)));
    }

    public static boolean isMoviePosterVisible() {
        return HelpersMethods.isVisible(withId(R.id.movie_poster));
    }

    public static void swipeUpTheMoviePage() {
        HelpersMethods.swipeUpAction(withId(R.id.main_content));
    }

    public static boolean isToolbarVisible() {
        return HelpersMethods.isVisible(withId(R.id.toolbar));
    }

    public static void clickOnTheSpecificTrailer() {
        HelpersMethods.clickAction(EspressoMethods.getFirstChild(withId(R.id.video_thumb)));
    }

    public static void clickOnTheSpecificMovie() {
        HelpersMethods.clickAction(EspressoMethods.getFirstChild(withId(R.id.movie_container)));
    }

    public static boolean isTheMovieNameVisible() {
        onView(isRoot()).perform(EspressoMethods.waitForXSeconds(2000));
        return HelpersMethods.isVisible(withId(R.id.movie_name));
    }

    public static boolean isTextStyleBold() {
        return HelpersMethods.isVisible(allOf(withText(Constants.SUMMARY), EspressoMethods.hasBoldText()));
    }

    public static int getTheNumberOfTextLinesOfMovieDescription() {
        return EspressoMethods.getTheNumberOfTextLines(withId(R.id.movie_description));
    }

    public static boolean isFavoriteButtonVisible() {
        return HelpersMethods.isVisible(withId(R.id.favorite));
    }

    public static void clickFavoriteButton() {
        HelpersMethods.clickAction(withId(R.id.favorite));
    }
}