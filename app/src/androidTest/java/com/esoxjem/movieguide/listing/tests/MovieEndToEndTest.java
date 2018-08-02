package com.esoxjem.movieguide.listing.tests;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.screens.Favorites;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;
import com.esoxjem.movieguide.listing.screens.SearchResults;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class MovieEndToEndTest extends EspressoTestBase {

    @Test
    public void testMovieEndToEnd() {
        // Step: Start the app.

        // Step: Search for the "Skyscraper" movie.
        Home.searchForSkyscraperMovie();

        // Step: On the list, select the first movie with the name you are looking for.
        SearchResults.clickOnFirstMovie();

        // Verify: Check if the movie name selected is the same with the movie name you are looking for
        assertTrue("The movie name selected is not the same with the movie name you are looking for", Movie.isMovieNameSelectedTheSameWithSearchedMovie());

        // Verify: "Summary" text is not bold.
        assertFalse("Summary text is bold", Movie.isSummaryTextBold());

        // Step: Scroll down the page.
        Movie.swipeUpTheContent();

        // Verify: Check the movie poster is not visible.
        assertFalse("The movie poster is still visible", Movie.isMoviePosterDisplayed());

        // Step: Get number of text lines from movie description.
        Movie.getNumberOfTextLinesFromMovieDescription();

        // Verify: Check if the number of text lines from movie description are equals to text lines.
        assertEquals("The number of text lines from movie description are not equals to text lines", 2, Movie.getNumberOfTextLinesFromMovieDescription());

        // Verify: Verify if "Favorites" button is displayed.
        Movie.isFavoriteButtonDisplayed();

        // Step: Add movie selected to favorites.
        Movie.clickFavoriteButton();

        // Step: Go back to search page.
        Movie.clickBackButton();

        // Step: On toolbar, click "Sort Action" and select "Favorites".
        SearchResults.clickSortButton();
        SearchResults.clickOnFavoritesButton();
        Espresso.closeSoftKeyboard();

        // Verify: On "Favorites" screen, the movie you are looking for is displayed.
        assertTrue("The movie you are looking for is not displayed", Favorites.isSearchedMovieDisplayed());
    }
}