package com.esoxjem.movieguide.listing.tests;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;
import com.esoxjem.movieguide.listing.screens.SearchResults;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class FavoriteMoviesTest extends EspressoTestBase {

    @Test
    public void testFavoriteMovies() {
        // Verify: "MovieGuide" text is displayed.
        assertTrue("Movie Guide text is not displayed", Home.isMovieGuideTextDisplayed());

        // Step: Click Search button.
        Home.clickSearchButton();

        // Step: Search "purge" and click on search(android).
        Home.typeMovieName();
        Home.clickAndroidSearchButton();

        // Step: Click on the second movie from your list.
        HelpersMethods.waitForScreenToLoad();
        SearchResults.clickOnSecondMovie();

        // Verify: "Favorite" button is visible.
        assertTrue("Favorite button is not visible", Movie.isFavoriteButtonDisplayed());

        // Step: Click "Favorites" button.
        Movie.clickFavoriteButton();

        // Step: Click back (NOT android) twice.
        Movie.clickBackButton();

        // Step: Click on the third movie from your list and swipeUp.
        Espresso.closeSoftKeyboard();
        SearchResults.swipeUpTheMovieList();
        HelpersMethods.waitForScreenToLoad();
        SearchResults.clickOnThirdMovie();
        Movie.swipeUpTheContent();

        // Verify: "Favorite" button is visible.
        assertTrue("Favorite button is not visible", Movie.isFavoriteButtonDisplayed());

        // Step: Click "Favorites" button.
        Movie.clickFavoriteButton();

        // Step: Click back (NOT android).
        Movie.clickBackButton();

        // Step: Click sort button.
        SearchResults.clickSortButton();

        // Verify: "Highest Rated" button and "Favorites" button are sibling.


        // Verify: There are 4 different buttons, descendants of a RadioGroup.


        // Step: Click on "Favorites" button.


        // Verify: The first word is the same for both movies.


        // Step: Click on the first movie and click on "Favorites" button.


        // Step: Click back (NOT android).


        // Step: Click on sort button.


        // Step: Click back (android).


        // Verify: There is only one movie in your list.

    }
}