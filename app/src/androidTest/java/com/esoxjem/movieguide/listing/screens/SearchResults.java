package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SearchResults {

    public static void clickOnSecondMovie() {
        HelpersMethods.clickUIElement(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 1));
    }

    public static void clickOnThirdMovie() {
        HelpersMethods.clickUIElement(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 2));
    }

    public static void swipeUpTheMovieList() {
        HelpersMethods.swipeUpOnScreen(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 1));
    }

    public static void clickSortButton() {
        HelpersMethods.clickUIElement(withId(R.id.action_sort));
    }
}