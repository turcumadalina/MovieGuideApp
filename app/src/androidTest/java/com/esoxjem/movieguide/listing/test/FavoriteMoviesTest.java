package com.esoxjem.movieguide.listing.test;

import android.support.test.espresso.Espresso;

import com.esoxjem.movieguide.listing.helpers.EspressoMethods;
import com.esoxjem.movieguide.listing.helpers.StartTheApplication;
import com.esoxjem.movieguide.listing.screen.Favorites;
import com.esoxjem.movieguide.listing.screen.Home;
import com.esoxjem.movieguide.listing.screen.Movie;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FavoriteMoviesTest extends StartTheApplication {
    @Test
    public void testFavoriteMovies() {
        // Step 1. Start the app.

        // Expected Result: "MovieGuide" text is displayed.
        assertTrue("MovieGuide\" text is NOT displayed.", Home.isMovieGuideTextVisible());

        // Step 2. Click Search button.
        Home.clickSearchButton();

        // Step 3. Search "purge" and click on search(android).
        Home.typePurgeTextOnSearchBox();

        // Wait 2 seconds.
        Home.waitForSpecificSeconds(2000);

        // Step 4. Click on the second movie from your list.
        Home.clickOnTheSecondMovieFromTheList();

        // Expected Result: "Favorite" button is visible.
        assertTrue("\"Favorite\" button is NOT visible.", Movie.isFavoriteButtonVisible());

        // Step 5. Click "Favorites" button.
        Movie.clickFavoriteButton();

        // Step 6. Click back (NOT android).
        Movie.clickBackButton();

        // Step 7. Close the keyboard.
        Espresso.closeSoftKeyboard();

        // Swipe the page to see the third movie and wait 2 seconds.
        Home.customSwipeUpTheHomePage();
        Home.waitForSpecificSeconds(2000);


        // Step 8. Click on the third movie from your list and swipeUp.
        Home.clickOnTheThirdMovieFromTheList();
        Movie.swipeUpTheMoviePage();

        // Expected Result: "Favorite" button is visible.
        assertTrue("\"Favorite\" button is NOT visible.", Movie.isFavoriteButtonVisible());

        // Step 9. Click "Favorites" button.
        Movie.clickFavoriteButton();

        // Step 10. Click back (NOT android).
        Movie.clickBackButton();

        // Step 11. Click sort button.
        Home.clickOnHamburgerButton();

        // Expected Result: "Highest Rated" button and "Favorites" button are sibling.
        assertTrue("\"Highest Rated\" button and \"Favorites\" button are NOT sibling.", Home.isHighestRatedButtonSiblingWithFavoriteButton());

        // Expected Result: There are 4 different buttons, descendants of a RadioGroup.
        assertEquals("There are more/less then 4 buttons descendants of a RadioGroup.", 4, Home.hasTheRadioGroupASpecificNumberOfChildren());
        assertTrue("There are 4 different buttons, descendants of a RadioGroup.", Home.hasTheRadioGroupChildrenWithDifferentNames());

        // Step 12. Click on "Favorites" button.
        Home.clickOnFavoritesButton();

        // Expected Result: The first word is the same for both movies.
        assertTrue("the word aren't equal.", EspressoMethods.checkTheFirstWord());

        // Step 13. Click on the first movie and click on "Favorites" button.
        Favorites.clickOnTheFirstMovieFromTheList();

        // Step 14. Click back (NOT android).
        Movie.clickBackButton();

        // Step 15. Click on sort button.
        Home.clickOnHamburgerButton();

        // Step 16. Click back (android).
        Espresso.pressBack();

        // Expected Result: There is only one movie in your list.
        assertTrue(" There is move/less then one movie in favorite movies list.", Favorites.isJustOneMovieInTheFavoriteMoviesList());
    }
}