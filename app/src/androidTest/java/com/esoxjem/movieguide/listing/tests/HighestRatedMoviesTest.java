package com.esoxjem.movieguide.listing.tests;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;
import com.esoxjem.movieguide.listing.screens.HighestRated;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;
import com.esoxjem.movieguide.listing.screens.SearchResults;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class HighestRatedMoviesTest extends EspressoTestBase {

    @Test
    public void testHighestRatedMovies() {
        // Step: Click on Hamburger
        SearchResults.clickSortButton();

        // Verify: A Linear Layout is displayed with first child with text "Sort By"
        assertTrue("A Linear Layout is not displayed with first child with text Sort By", Home.isFirstChildOfALinearLayoutWithTextDisplayed());

        // Verify: The second child of sorting_group has text "Highest Rated"
        assertTrue("The second child of sorting_group hasn't text Highest Rated", Home.isSecondChildOfSortingGroupWithTextHighestRated());

        // Step: Click on "Highest Rated"
        Home.clickOnHighestRatedButton();

        // Verify: The first four movies in the list have a rating higher than 8
        //assertTrue("The first four movies in the list hasn't a rating higher than 8", HighestRated.isFirstFourMoviesWithRated());
        HelpersMethods.swipeOnXY();
        assertTrue("The first four movies in the list hasn't a rating higher than 8", HighestRated.isFirstFourMoviesWithRated());

        // Step: Click on first movie
        SearchResults.clickOnFirstMovie();

        // Verify: Movie_poster is displayed
        assertTrue("Movie_poster is not displayed", Movie.isMoviePosterDisplayed());

        // Step: Swipe up
        Movie.swipeUpTheContent();

        // Verify: Toolbar is displayed
        assertTrue("Toolbar is not displayed", Movie.isToolbarDisplayed());

        // Verify: "Summary" and "Trailers" have the same font size
        assertEquals("Summary and Trailers have the same font size", Movie.getSummaryTextSize(), Movie.getTrailersTextSize());

        // Step: Click on first trailer
        Movie.clickOnFirstMovieTrailer();

        // Verify: The page redirects to Youtube


        // Step: Click back twice
        Espresso.pressBack();
        //Movie.clickBackButton();

        // Verify: The first four movies in the list have a rating higher than 8
        assertTrue("The first four movies in the list hasn't a rating higher than 8", HighestRated.isFirstFourMoviesWithRated());
    }
}