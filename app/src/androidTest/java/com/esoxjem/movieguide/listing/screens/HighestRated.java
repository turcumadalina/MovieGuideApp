package com.esoxjem.movieguide.listing.screens;

import android.app.Activity;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.Constants;
import com.esoxjem.movieguide.listing.helpers.EspressoMatchers;
import com.esoxjem.movieguide.listing.helpers.HelpersMethods;

import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.runner.lifecycle.Stage.RESUMED;

public class HighestRated {

    public static boolean isFirstFourMoviesRatingHigherThan8() {
        boolean ratedHigher = false;
        for (int i = 0; i < 4; i++) {
            HelpersMethods.performClick(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), i));
            String fullRating = EspressoMatchers.getText(withId(R.id.movie_rating));
            String[] splittedFullRating = fullRating.split("/");
            String rating = splittedFullRating[0];
            float ratingNo = Float.parseFloat(rating);
            if (ratingNo > 8) {
                ratedHigher = true;
            } else {
                break;
            }
            HelpersMethods.performClick(withContentDescription(Constants.NAVIGATE_UP));
        }
        return ratedHigher;
    }

    public static void clickFirstMovie() {
        HelpersMethods.performClick(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.movie_container), 0));
    }

    public static boolean isMoviePosterDisplayed() {
        return HelpersMethods.isObjectDisplayed(withId(R.id.movie_poster));
    }

    public static boolean isToolbarDisplayed() {
        return HelpersMethods.isObjectDisplayed(withId(R.id.toolbar));
    }

    public static int getSummaryFontSize() {
        return EspressoMatchers.getTextSize(withText(Constants.SUMMARY));
    }

    public static int getTrailersFontSize() {
        return EspressoMatchers.getTextSize(withText(Constants.TRAILERS));
    }

    public static void clickFirstTrailer() {
        HelpersMethods.performClick(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.video_thumb), 0));
    }

    public static Activity getCurrentActivity() throws IllegalStateException {
        final Activity[] resumedActivity = new Activity[1];

        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance()
                        .getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext()) {
                    resumedActivity[0] = (Activity) resumedActivities.iterator().next();
                } else {
                    throw new IllegalStateException("No Activity in stage RESUMED");
                }
            }
        });
        return resumedActivity[0];
    }

    public static String movieAppActivity() {
        return getCurrentActivity().getLocalClassName();
    }
}