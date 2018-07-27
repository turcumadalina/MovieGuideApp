package com.esoxjem.movieguide.listing.screen;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Home {
    public static void clickOnHamburgerButton() {
        HelpersMethods.clickAction(withId(R.id.action_sort));
    }

    public static void clickOnHighestRatedButton() {
        HelpersMethods.clickAction(withId(R.id.highest_rated));
    }
}
