package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class Movie {

    public static String getMovieName() {
        return EspressoMatchers.getText(withId(R.id.movie_name));
    }

    public static boolean isTextBold() {
        return HelpersMethods.isObjectDisplayed(allOf(withText(Constants.SUMMARY), EspressoMatchers.withBoldStyle()));
    }
}
