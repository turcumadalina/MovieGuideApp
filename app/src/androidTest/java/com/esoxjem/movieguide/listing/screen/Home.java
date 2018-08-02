package com.esoxjem.movieguide.listing.screen;

import android.widget.LinearLayout;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMethods;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class Home {
    public static void clickOnHamburgerButton() {
        HelpersMethods.clickAction(withId(R.id.action_sort));
    }

    public static boolean isLinearLayoutVisibleAndHisFirstChildHasSortByText() {
        return HelpersMethods.isVisible(allOf(is(instanceOf(LinearLayout.class)), withChild(withText(R.string.sort_by))));
    }

    public static boolean isHighestRatedTheSecondChildOfSortingGroupVisible() {
        return HelpersMethods.isVisible(EspressoMethods.childAtPosition(withId(R.id.sorting_group), 1));
    }

    public static void clickOnHighestRatedButton() {
        HelpersMethods.clickAction(withId(R.id.highest_rated));
    }

    public static void clickSearchButton() {
        HelpersMethods.clickAction(withId(R.id.action_search));
    }

    public static void typeSkyscraperTextOnSearchBox() {
        HelpersMethods.typeTextAction(withId(R.id.search_src_text), Constants.SKYSCRAPER);
    }

    public static void clickOnFavoritesButton() {
        HelpersMethods.clickAction(withId(R.id.favorites));
    }

    public static boolean isMovieGuideTextVisible() {
        return HelpersMethods.isVisible(withText(Constants.MOVIE_GUIDE));
    }

    public static void typePurgeTextOnSearchBox() {
        HelpersMethods.typeTextAction(withId(R.id.search_src_text), Constants.PURGE);
    }

    public static void clickOnTheSecondMovieFromTheList() {
        HelpersMethods.clickAction(EspressoMethods.childAtPosition(withId(R.id.movies_listing), 1));
    }

    public static void clickOnTheThirdMovieFromTheList() {
        HelpersMethods.clickAction(EspressoMethods.childAtPosition(withId(R.id.movies_listing), 2));
    }

    public static boolean isHighestRatedButtonSiblingWithFavoriteButton() {
        return HelpersMethods.isVisible(allOf(withId(R.id.highest_rated), hasSibling(withId(R.id.favorites))));
    }

    public static int hasTheRadioGroupASpecificNumberOfChildren() {
        return EspressoMethods.getCountChildrenFromTheRadioGroupList(withId(R.id.sorting_group));
    }

    public static boolean hasTheRadioGroupChildrenWithDifferentNames() {
        return HelpersMethods.isVisible(allOf(withId(R.id.sorting_group), withChild(withId(R.id.most_popular)), withChild(withId(R.id.highest_rated)), withChild(withId(R.id.favorites)), withChild(withId(R.id.newest))));
    }
}