package com.esoxjem.movieguide.listing.tests;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.screens.HighestRated;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;

public class HighestRatedMoviesTest extends EspressoTestBase {
    @Test
    public void testHighestMoviesTest() {
        // The commented code below is part of some demo framework

        //activityTestRule.launchActivity(null);
        //Home.rotateRight();
        //Home.performGeneralScrollCustom(allOf(withId(R.id.movie_name), withText("Insurgent")), 15);
        //onView(allOf(withId(R.id.movie_name), withText("Insurgent"))).perform(click());
        //onView(withId(R.id.favorite)).perform(click());

        //The actual test starts from here

        // Step: Click on Hamburger
        Movie.clickSortAction();

        // Verify: A Linear Layout is displayed with first child with text "Sort By"
        assertTrue("A Linear Layout is not displayed with first child with text \"Sort By\"", Home.isLinearLayoutWithFirstChildWithTextSortBy());

        // Verify: The second child of sorting_group has text "Highest Rated"
        assertTrue("The second child of sorting_group has not text \"Highest Rated\".", Home.isSecondChildOfSortingGroupWithTextHighestRated());

        // Step: Click on "Highest Rated"
        Home.clickHighestRated();

        // Verify: The first four movies in the list have a rating higher than 8
        assertTrue("The first four movies in the list have not a rating higher than 8", HighestRated.isFirstFourMoviesRatingHigherThan8());

        // Step: Click on first movie
        HighestRated.clickFirstMovie();

        // Verify: Movie_poster is displayed
        assertTrue("Movie_poster is not displayed", HighestRated.isMoviePosterDisplayed());

        // Step: Swipe up
        EspressoMatchers.XYSmallScroll();

        // Verify: Toolbar is displayed
        assertTrue("Toolbar is not displayed", HighestRated.isToolbarDisplayed());

        // Verify: "Summary" and "Trailers" have the same font size
        assertEquals("\"Summary\" and \"Trailers\" have not the same font size", HighestRated.getSummaryFontSize(), HighestRated.getTrailersFontSize());

        // Get local Class Name for App Activity
        String movieAppName = HighestRated.movieAppActivity();

        // Step: Click on first trailer
        HighestRated.clickFirstTrailer();

        // Verify: The page redirects to Youtube
        assertNotSame("The page does not redirects to Youtube", movieAppName, HighestRated.getCurrentActivity().getLocalClassName());

        // Step: Click back
        Espresso.pressBack();

        // Verify: The first four movies in the list have a rating higher than 8
        assertTrue("The first four movies in the list have not a rating higher than 8", HighestRated.isFirstFourMoviesRatingHigherThan8());
    }
}