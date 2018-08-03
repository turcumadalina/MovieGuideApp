package com.esoxjem.movieguide.listing.test;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMethods;
import com.esoxjem.movieguide.listing.helpers.StartTheApplication;
import com.esoxjem.movieguide.listing.screen.Home;
import com.esoxjem.movieguide.listing.screen.Movie;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class HighestRatedMoviesTest extends StartTheApplication {

    @Test
    public void testHighestRatedMovies() {
        // Step 1. Click on Hamburger.
        Home.clickOnHamburgerButton();

        // Expected Result: A Linear Layout is displayed with first child with text "Sort By".
        assertTrue("A Linear Layout is NOT displayed with first child with text \"Sort By\".", Home.isLinearLayoutVisibleAndHisFirstChildHasSortByText());

        // Expected Result: The second child of sorting_group has text "Highest Rated".
        assertTrue("The second child of sorting_group has NOT text \"Highest Rated\".", Home.isHighestRatedTheSecondChildOfSortingGroupVisible());

        //Wait 2 seconds.
        Home.waitForSpecificSeconds(2000);

        // Step 2. Click on "Highest Rated".
        Home.clickOnHighestRatedButton();

        // Expected Result: The first four movies in the list have a rating higher than 8.
        Movie.clickMoviesAndCheckTheValueOfTheNotes();

        // Step 3. Click on first movie.
        Movie.clickOnRequiredMovie();

        // Expected Result: Movie_poster is displayed.
        assertTrue("Movie_poster is NOT displayed.", Movie.isMoviePosterVisible());

        // Step 4. Swipe up.
        Movie.swipeUpTheMoviePage();

        // Expected Result: Toolbar is displayed.
        assertTrue("Toolbar is NOT displayed.", Movie.isToolbarVisible());

        // Expected Result: "Summary" and "Trailers" have the same font size.
        assertEquals("\"Summary\" and \"Trailers\" have NOT the same font size.", EspressoMethods.getFontSize(withText(Constants.SUMMARY)), EspressoMethods.getFontSize(withText(Constants.TRAILERS)));

        // Step 5. Click on first trailer.
        String actualApplicationActivity = Home.actualApplicationActivity();
        Movie.clickOnTheSpecificTrailer();

        // Wait at least 5 seconds.
        onView(isRoot()).perform(EspressoMethods.waitForXSeconds(5000));

        // Expected Result: The page redirects to Youtube.
        assertTrue("MoviesListingActivity application is NOT in progress.", activityTestRule.getActivity() != null);
        String previousApplicationActivity = Home.actualApplicationActivity();
        actualApplicationActivity.equals(previousApplicationActivity);

        // Step 6. Click back.
        Espresso.pressBack();

        // The first four movies in the list have a rating higher than 8.
        Movie.clickMoviesAndCheckTheValueOfTheNotes();
    }
}