package com.esoxjem.movieguide.listing.helpers;

import android.support.test.rule.ActivityTestRule;

import com.esoxjem.movieguide.listing.MoviesListingActivity;

import org.junit.Rule;

public class EspressoTestBase {
    @Rule
    public final ActivityTestRule<MoviesListingActivity> activityTestRule = new ActivityTestRule<>(MoviesListingActivity.class);
}
