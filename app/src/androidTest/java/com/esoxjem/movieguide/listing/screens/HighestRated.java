package com.esoxjem.movieguide.listing.screens;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class HighestRated {

    public static boolean isFirstFourMoviesWithRated() {
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            HelpersMethods.clickUIElement(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), i));
            HelpersMethods.waitForScreenToLoad();
            String rating = EspressoMatchers.getText(withId(R.id.movie_rating));
            String[] ratingTarget = rating.split("/");
            String ratingSplit = ratingTarget[0];
            float ratingNo = Float.parseFloat(ratingSplit);
            if (ratingNo > 8) {
                result = true;
            } else {
                break;
            }
            Movie.clickBackButton();
            HelpersMethods.waitForScreenToLoad();
        }
        return result;
    }
}