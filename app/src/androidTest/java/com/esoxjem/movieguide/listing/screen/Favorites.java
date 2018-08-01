package com.esoxjem.movieguide.listing.screen;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.EspressoMethods;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Favorites {
    public static boolean isTheMovieVisible() {
        return HelpersMethods.isVisible(EspressoMethods.getFirstChild(withId(R.id.movies_listing)));
    }
}