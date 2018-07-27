package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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

    public static String searchedMovie() {
        return Constants.SKYSCRAPER;
    }

    public static void waitToLoad() {
        onView(isRoot()).perform(EspressoMatchers.waitFor(2000));
    }
}
