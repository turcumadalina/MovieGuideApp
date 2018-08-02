package com.esoxjem.movieguide.listing.tests;

import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.screens.Favorites;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class MovieEndToEndTest extends EspressoTestBase {

    @Test
    public void testMovieEndToEnd() {
        // Step: Start the app.

        // Step: Search for the "Skyscraper" movie.
        Home.clickSearchButton();
        Home.typeSkyscraper();
        Home.pressEnterKey();

        // Wait 2 seconds
        Home.waitToLoad();

        // Verify: On the list, select the first movie with the name you are looking for.
        Home.clickOnFirstMovie();

        // Wait 2 seconds
        Home.waitToLoad();

        // Verify: Check if the movie name selected is the same with the movie name you are looking for
        assertEquals("The movie name selected is the same with the movie name you are looking for", Constants.SKYSCRAPER, Movie.getMovieName());

        // Verify: Verify if "Summary" text is not bold.
        assertFalse("Summary text is bold", Movie.isSummaryTextBold());

        // Step: Scroll down the page.
        Movie.performSwipeUp();

        // Wait 2 seconds
        Home.waitToLoad();

        // Verify: Check the movie poster is not visible.
        assertFalse("The movie poster is visible", Movie.isMoviePosterDisplayed());

        // Step: Get number of text lines from movie description.
        Movie.getMovieDescriptionTextLineNo();

        // Verify: Check if the number of text lines from movie description are equals to text lines.
        assertEquals("The number of text lines from movie description are not equals to text lines", 2, Movie.getMovieDescriptionTextLineNo());

        // Verify: Verify if "Favorites" button is displayed.
        assertTrue(" \"Favorites\" button is not displayed", Movie.isFavouritesButtonDisplayed());

        // Step: Add movie selected to favorites.
        Movie.clickFavouritesButton();

        // Step: Go back to search page.
        Movie.navigateBack();

        // Verify: On toolbar, click "Sort Action" and select "Favorites".
        Movie.clickSortAction();
        Movie.clickFavorites();

        // Verify: On "Favorites" screen, the movie you are looking for is displayed.
        assertTrue("The movie you are looking for is not displayed", Favorites.isSkyscraperMovieDisplayed());
    }
}