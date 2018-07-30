package com.esoxjem.movieguide.listing.tests;

import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;

import org.junit.Test;

public class HighestRatedMoviesTest extends EspressoTestBase {

    @Test
     public void testHighestMoviesTest() {
        // Step: Click on Hamburger

        // Verify: A Linear Layout is displayed with first child with text "Sort By"

        // Verify: The second child of sorting_group has text "Highest Rated"

        // Step: Click on "Highest Rated"

        // Verify: The first four movies in the list have a rating higher than 8

        // Step: Click on first movie

        // Verify: Movie_poster is displayed

        // Step: Swipe up

        // Verify: Toolbar is displayed

        // Verify: "Summary" and "Trailers" have the same font size

        // Step: Click on first trailer

        // Verify: The page redirects to Youtube

        // Step: Click back twice

        // Verify: The first four movies in the list have a rating higher than 8

    }
}
