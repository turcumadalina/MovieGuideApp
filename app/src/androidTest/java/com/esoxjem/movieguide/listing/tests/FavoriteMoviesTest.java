package com.esoxjem.movieguide.listing.tests;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.screens.Favorites;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FavoriteMoviesTest extends EspressoTestBase {

    @Test
    public void testFavoriteMovies() {
        // Step: Start the app.

        // Verify: "MovieGuide" text is displayed.
        assertTrue("MovieGuide text is not displayed", Home.isMovieGuideDisplayed());

        // Step: Click Search button.
        Home.clickSearchButton();

        // Step: Search "purge" and click on search(android).
        Home.typePurge();
        Home.pressEnterKey();
        Home.waitToLoad();

        // Step: Click on the second movie from your list.
        Home.clickOnSecondMovie();
        Home.waitToLoad();

        // Verify: "Favorite" button is visible.
        assertTrue(" \"Favorites\" button is not displayed", Movie.isFavouritesButtonDisplayed());

        // Step: Click "Favorites" button.
        Movie.clickFavouritesButton();

        // Step: Click back (NOT android).
        Movie.navigateBack();

        // Step: Close the keyboard
        Espresso.closeSoftKeyboard();

        // Step: Click on the third movie from your list and swipeUp.
        Home.performScrollCustom();
        Home.clickOnThirdMovie();

        // Verify: "Favorite" button is visible.
        assertTrue(" \"Favorites\" button is not displayed", Movie.isFavouritesButtonDisplayed());

        // Step: Click "Favorites" button.
        Movie.clickFavouritesButton();

        // Step: Click back (NOT android).
        Movie.navigateBack();

        // Step: Click sort button.
        Movie.clickSortAction();

        // Verify: "Highest Rated" button and "Favorites" button are sibling.
        assertTrue("\"Highest Rated\" button and \"Favorites\" button are not sibling.", Movie.isHighestRatingSiblingWithFavorites());

        // Verify: There are 4 different buttons, descendants of a RadioGroup.
        assertTrue("There are not 4 different buttons, descendants of a RadioGroup.", Home.isRadioGroupChildrenDifferent());

        // Step: Click on "Favorites" button.
        Movie.clickFavorites();

        // Verify: The first word is the same for both movies.
        assertEquals("The first word is not the same for both movies.", Favorites.getFirstMovieFirstWord(), Favorites.getSecondMovieFirstWord());

        // Step: Click on the first movie and click on "Favorites" button.
        Home.clickOnFirstMovie();
        Movie.clickFavouritesButton();

        // Step: Click back (NOT android).
        Movie.navigateBack();

        // Step: Click on sort button.
        Movie.clickSortAction();

        // Step: Click back (android).
        Espresso.pressBack();


        // Verify: There is only one movie in your list.
        assertEquals("There is not one movie in your list.", 1, Favorites.getFavoritesListChildrenNo());
    }
}