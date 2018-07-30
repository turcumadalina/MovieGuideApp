package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class Favorites {

    public static boolean isSkyscraperMovieDisplayed() {
        return HelpersMethods.isObjectDisplayed(allOf(withText(Constants.SKYSCRAPER), withId(R.id.movie_name)));
    }
}
