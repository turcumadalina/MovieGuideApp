package com.esoxjem.movieguide.listing.tests;

import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.screens.Home;
import com.esoxjem.movieguide.listing.screens.Movie;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MovieEndToEndTest extends EspressoTestBase {

    @Test
    public void testMovieEndToEnd() {
        // Step: Start the app.

        // Step: Search for the "Skyscraper" movie.
        Home.clickSearchButton();
        Home.typeSkyscraper();
        Home.pressEnterKey();
        Home.waitToLoad();

        // Verify: On the list, select the first movie with the name you are looking for.
        Home.clickOnFirstMovie();
        Home.waitToLoad();

        // Verify: Check if the movie name selected is the same with the movie name you are looking for
        assertEquals("The movie name selected is the same with the movie name you are looking for", Home.searchedMovie(), Movie.getMovieName());

        // Verify: Verify if "Summary" text is bold.
        assertTrue("Summary text is not bold", Movie.isTextBold());

        // Step: Scroll down the page.

        // Verify: Check the movie poster is not visible.


        // Step: Get number of text lines from movie description.


        // Verify: Check if the number of text lines from movie description are equals to text lines.


        // Verify: Verify if "Favorites" button is displayed.


        // Step: Add movie selected to favorites.


        // Step: Go back to search page.


        // Verify: On toolbar, click "Sort Action" and select "Favorites".


        // Verify: On "Favorites" screen, the movie you are looking for is displayed.


    }
}
