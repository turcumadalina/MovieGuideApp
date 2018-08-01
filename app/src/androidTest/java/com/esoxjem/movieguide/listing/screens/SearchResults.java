package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class SearchResults {

    public static void clickOnSecondMovie() {
        HelpersMethods.clickUIElement(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 1));
    }

    public static void clickOnThirdMovie() {
        HelpersMethods.clickUIElement(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 2));
    }

    public static void swipeUpTheMovieList() {
        HelpersMethods.swipeOnXYCoordinates();
    }

    public static void clickSortButton() {
        HelpersMethods.clickUIElement(withId(R.id.action_sort));
    }

    public static boolean isHighestButtonSiblingWithFavoritesButton() {
        return HelpersMethods.isUIObjectDisplayed(allOf(withId(R.id.highest_rated), hasSibling(withId(R.id.favorites))));
    }

    public static int isRadioGroupWithFourChildren() {
        return EspressoMatchers.getListViewChildCountFromRadioGroup(withId(R.id.sorting_group));
    }

    public static boolean isRadioGroupWithDifferentChildren() {
        return HelpersMethods.isUIObjectDisplayed(allOf(withId(R.id.sorting_group), withChild(withId(R.id.most_popular)), withChild(withId(R.id.highest_rated)),
                withChild(withId(R.id.favorites)), withChild(withId(R.id.newest))));
    }

    public static void clickOnFavoritesButton() {
        HelpersMethods.clickUIElement(withId(R.id.favorites));
    }
}