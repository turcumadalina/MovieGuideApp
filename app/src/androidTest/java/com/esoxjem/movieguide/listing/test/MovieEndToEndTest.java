package com.esoxjem.movieguide.listing.test;

import com.esoxjem.movieguide.listing.helpers.EspressoMethods;
import com.esoxjem.movieguide.listing.helpers.StartTheApplication;
import com.esoxjem.movieguide.listing.screen.Favorites;
import com.esoxjem.movieguide.listing.screen.Home;
import com.esoxjem.movieguide.listing.screen.Movie;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MovieEndToEndTest extends StartTheApplication {
    @Test
    public void testMovieEndToEnd() {
        // Step 1. Start the app.

        // Step 2. Search for the "Skyscraper" movie.
        Home.clickSearchButton();
        Home.typeSpecificTextOnSearchBox();

        //Wait 2 seconds.
        onView(isRoot()).perform(EspressoMethods.waitForXSeconds(2000));

        // Step 3. On the list, select the first movie with the name you are looking for.
        Movie.clickOnTheSpecificMovie();

        // Expected Result: Check if the movie name selected is the same with the movie name you are looking for.
        assertTrue("The name of the selected movie is NOT the same as the one I was looking for.", Movie.isTheMovieNameVisible());

        //Verify "Summary" text is not bold.
        assertFalse("\"Summary\" text is bold.", Movie.isTextStyleBold());

        // Step 4. Scroll down the page.
        Movie.swipeUpTheMoviePage();

        // Expected Result: Check the movie poster is not visible.
        assertFalse("The movie poster is visible.", Movie.isMoviePosterVisible());

        // Step 5. Get number of text lines from movie description.
        Movie.getTheNumberOfTextLinesOfMovieDescription();

        // Expected Result: Check if the number of text lines from movie description are equals to text lines.
        assertEquals("The number of text lines from movie description is NOT equal to text lines.", 3, Movie.getTheNumberOfTextLinesOfMovieDescription());

        // Verify if "Favorites" button is displayed.
        assertTrue("\"Favorites\" button is NOT displayed", Movie.isFavoriteButtonVisible());

        // Step 6. Add movie selected to favorites.
        Movie.clickFavoriteButton();

        // Step 7. Go back to search page.
        Movie.clickBackButton();

        // Step 8. On toolbar, click "Sort Action" and select "Favorites".
        Home.clickOnHamburgerButton();
        Home.clickOnFavoritesButton();

        // wait 3 seconds
        onView(isRoot()).perform(EspressoMethods.waitForXSeconds(3000));

        // Expected Result: On "Favorites" screen, the movie you are looking for is displayed.
        assertTrue("The specific movie is NOT displayed.", Favorites.isTheMovieVisible());
    }
}