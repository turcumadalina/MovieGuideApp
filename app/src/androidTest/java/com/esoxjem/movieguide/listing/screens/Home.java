package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

public class Home {

    public static void clickSearchButton() {
        HelpersMethods.performClick(withId(R.id.action_search));
    }

    public static void typeSkyscraper() {
        HelpersMethods.typeSomeText(withId(R.id.search_src_text), Constants.SKYSCRAPER);
    }

    public static void pressEnterKey() {
        HelpersMethods.pressEnterKeyAndroid(withId(R.id.search_src_text));
    }

    public static void clickOnFirstMovie() {
        HelpersMethods.performClick(EspressoMatchers.getFirstElement(withId(R.id.movie_container)));
    }

    public static void waitToLoad() {
        onView(isRoot()).perform(EspressoMatchers.waitFor(2000));
    }

    public static boolean isMovieGuideDisplayed() {
        return HelpersMethods.isObjectDisplayed(withText(Constants.MOVIE_GUIDE));
    }

    public static void typePurge() {
        HelpersMethods.typeSomeText(withId(R.id.search_src_text), Constants.PURGE);
    }

    public static void clickOnSecondMovie() {
        HelpersMethods.performClick(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 1));
    }

    public static void clickOnThirdMovie() {
        HelpersMethods.performClick(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 2));
    }

    public static void performScrollCustom() {
        int count = 0;
        while (!HelpersMethods.isObjectDisplayed(allOf(withId(R.id.movie_name), withText("The First Purge"))) && count < 10) {
            onView(withId(R.id.movies_listing)).perform(EspressoMatchers.swipeFromBottomToTop());
            count++;
        }
    }

    public static boolean isRadioGroupChildrenDifferent() {
        boolean isTextDifferent = false;

        for (int i = 0; i < 3; i++) {
            String firstText = EspressoMatchers.getTextFromRadioButton(EspressoMatchers.nthChildOfRadioGroup(withId(R.id.sorting_group), i));
            String secondText = EspressoMatchers.getTextFromRadioButton(EspressoMatchers.nthChildOfRadioGroup(withId(R.id.sorting_group), i + 1));

            if (firstText.equals(secondText)) {
                isTextDifferent = false;
            } else {
                isTextDifferent = true;
                break;
            }
        }
        return isTextDifferent;
    }

    // The commented code below is part of some demo framework

//    public static void performGeneralScrollCustom(Matcher<View> matcher, int maxNoOfScrolls) {
//        int count = 0;
//        while (!HelpersMethods.isObjectDisplayed(matcher) && count < maxNoOfScrolls) {
//            EspressoMatchers.XYSwipe();
//            Home.waitToLoad();
//            count++;
//        }
//    }
//
//    public static void rotateRight() throws RemoteException {
//         device.setOrientationRight();
//    }

    public static boolean isLinearLayoutWithFirstChildWithTextSortBy() {
        return HelpersMethods.isObjectDisplayed(allOf(EspressoMatchers.nthChildOf(instanceOf(android.widget.LinearLayout.class), 0), withText(Constants.SORT_BY)));
    }

    public static boolean isSecondChildOfSortingGroupWithTextHighestRated() {
        return HelpersMethods.isObjectDisplayed(allOf(EspressoMatchers.nthChildOfRadioGroup(withId(R.id.sorting_group), 1), withText(Constants.HIGHEST_RATED)));
    }

    public static void clickHighestRated() {
        HelpersMethods.performClick(withId(R.id.highest_rated));
    }
}