package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Movie {

    public static boolean isFavoriteButtonDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withId(R.id.favorite));
    }

    public static void clickFavoriteButton() {
        HelpersMethods.clickUIElement(withId(R.id.favorite));
    }

    public static void clickBackButton() {
        HelpersMethods.clickUIElement(withContentDescription(Constants.NAVIGATE_UP));
    }

    public static void swipeUpTheContent() {
        HelpersMethods.swipeUpOnScreen(withId(R.id.main_content));
    }
}