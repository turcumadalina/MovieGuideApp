package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Favorites {

    public static void clickOnTheFirstMovieFromFavoriteList() {
        HelpersMethods.clickUIElement((EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 0)));
    }

    public static int isFavoriteListWithOneMovie() {
        return EspressoMatchers.getListViewChildCountFromRecyclerView(withId(R.id.movies_listing));
    }

    public static String firstWordFromFirstMovieName() {
        return HelpersMethods.getMovieNameFirstWord(EspressoMatchers.getElementFromMatchAtPosition((withId(R.id.movie_name)), 0));
    }

    public static String firstWordFromSecondMovieName() {
        return HelpersMethods.getMovieNameFirstWord(EspressoMatchers.getElementFromMatchAtPosition((withId(R.id.movie_name)), 1));
    }
}