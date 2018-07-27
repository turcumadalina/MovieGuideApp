package com.esoxjem.movieguide.listing.test;

import com.esoxjem.movieguide.listing.helpers.StartTheApplication;
import com.esoxjem.movieguide.listing.screen.Home;
import com.esoxjem.movieguide.listing.screen.Movie;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class HighestRatedMoviesTest extends StartTheApplication {

    @Test
    public void testHighestRatedMovies() {
        // Step 1. Click on Hamburger
        Home.clickOnHamburgerButton();

        // Expected Result: A Linear Layout is displayed with first child with text "Sort By"
        assertTrue("", Movie.isLinearLayoutVisible());

        // Expected Result: The second child of sorting_group has text "Highest Rated"

        // Step 2. Click on "Highest Rated"

        // Expected Result: The first four movies in the list have a rating higher than 8

        // Step 3. Click on first movie

        // Expected Result: Movie_poster is displayed

        // Step 4. Swipe up

        // Expected Result: Toolbar is displayed

        // Expected Result: "Summary" and "Trailers" have the same font size

        // Step 5. Click on first trailer

        // Expected Result: The page redirects to Youtube

        // Step 6. Click back (twice)

        // The first four movies in the list have a rating higher than 8

    }
}
