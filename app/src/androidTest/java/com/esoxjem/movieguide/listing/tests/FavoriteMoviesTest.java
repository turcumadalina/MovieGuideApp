package com.esoxjem.movieguide.listing.tests;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;
import com.esoxjem.movieguide.listing.screens.Favorites;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;
import com.esoxjem.movieguide.listing.screens.SearchResults;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
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

        // Step: Click back (NOT android).
        Movie.clickBackButton();

        // Step: Close the keyboard.
        Espresso.closeSoftKeyboard();

        // Step: Click on the third movie from your list and swipeUp.
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
        assertTrue("Highest button is not sibling with Favorites button", SearchResults.isHighestButtonSiblingWithFavoritesButton());

        // Verify: There are 4 different buttons, descendants of a RadioGroup.
        assertEquals("On Radio Group are more/less then 4 children", 4, SearchResults.isRadioGroupWithFourChildren());
        assertTrue("Most Popular button is not displayed", SearchResults.isMostPopularButtonDisplayed());
        assertTrue("Highest Rated button is not displayed", SearchResults.isHighestRatedButtonDisplayed());
        assertTrue("Favorites button is not displayed", SearchResults.isFavoritesButtonDisplayed());
        assertTrue("Newest button is not displayed", SearchResults.isNewestButtonDisplayed());

        // Step: Click on "Favorites" button.
        HelpersMethods.waitForScreenToLoad();
        SearchResults.clickOnFavoritesButton();
        HelpersMethods.waitForScreenToLoad();

        Espresso.closeSoftKeyboard();

        // Verify: The first word is the same for both movies.


        // Step: Click on the first movie and click on "Favorites" button.
        HelpersMethods.waitForScreenToLoad();
        Favorites.clickOnTheFirstMovieFromFavoriteList();
        Movie.clickFavoriteButton();

        // Step: Click back (NOT android).
        Movie.clickBackButton();

        // Step: Click on sort button.
        SearchResults.clickSortButton();

        // Step: Click back (android).
        Espresso.pressBack();
        HelpersMethods.waitForScreenToLoad();

        // Verify: There is only one movie in your list.
        assertEquals("Favorites list has more/less then one movie", 1, Favorites.isFavoriteListWithOneMovie());
    }
}