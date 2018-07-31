package com.esoxjem.movieguide.listing.tests;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.helpers.EspressoTestBase;
import com.esoxjem.movieguide.listing.screens.Home;

import org.junit.Test;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class HighestRatedMoviesTest extends EspressoTestBase {

    @Test
     public void testHighestMoviesTest() {
        Home.performGeneralScrollCustom(allOf(withId(R.id.movie_name), withText("Insurgent")), 10);
        //Home.clickOnFirstMovie();
//        onView(allOf(withId(R.id.review_author), withText("TopKek"))).check(matches(isDisplayed()));
//        onView(withText("TopKek")).check(matches(isDisplayed()));
//        onView(allOf(withText("TopKek"), instanceOf(android.widget.TextView.class))).check(matches(isDisplayed()));
//        onView(allOf(withText("TopKek"), hasSibling(withId(R.id.review_content)))).check(matches(isDisplayed()));
//        onView(allOf(withText("TopKek"), withParent(withId(R.id.review)))).check(matches(isDisplayed()));
//        onView(allOf(withId(R.id.review), hasDescendant(withText("TopKek")))).check(matches(isDisplayed()));
//        onView(EspressoMatchers.getElementFromMatchAtPosition(withId(R.id.review_author), 0)).check(matches(isDisplayed()));
//        onView(EspressoMatchers.getFirstElement(withId(R.id.review_author))).check(matches(isDisplayed()));
//        onView(EspressoMatchers.nthChildOf(allOf(withId(R.id.review), hasDescendant(withText("TopKek"))), 0)).check(matches(isDisplayed()));
//
//        onView(withId(R.id.review_author)).check(matches(isCompletelyDisplayed()));
//        onView(withText("MohamedElsharkawy")).check(matches(isCompletelyDisplayed()));
//        onView(allOf(is(instanceOf(LinearLayout.class)), withChild(withText("MohamedElsharkawy")))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review), withChild(withText("MohamedElsharkawy")))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review_author), isDescendantOfA(withId(R.id.review)))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review), hasDescendant(withId(R.id.review_author)))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review), hasDescendant(withText("MohamedElsharkawy")))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(is(instanceOf(TextView.class)), withText("MohamedElsharkawy"))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review_content), hasSibling(withId(R.id.review_author)))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review_content), hasSibling(withText("MohamedElsharkawy")))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withParent(withId(R.id.review)), withId(R.id.review_author))).check(matches(isCompletelyDisplayed()));
//
//        onView(withId(R.id.review_author)).check(matches(isCompletelyDisplayed()));
//        onView(withText("MohamedElsharkawy")).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review), withChild(withId(R.id.review_author)))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(isDescendantOfA(withId(R.id.review)), withId(R.id.review_author))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(is(instanceOf(android.widget.TextView.class)), withId(R.id.review_author), withText("MohamedElsharkawy"))).check(matches(isCompletelyDisplayed()));
//        onView(allOf(withId(R.id.review_author), withText("MohamedElsharkawy"), withParent(withId(R.id.review)), isDescendantOfA(withId(R.id.review))));

        // Step: Click on Hamburger

        // Verify: A Linear Layout is displayed with first child with text "Sort By"

        // Verify: The second child of sorting_group has text "Highest Rated"

        // Step: Click on "Highest Rated"

        // Verify: The first four movies in the list have a rating higher than 8

        // Step: Click on first movie

        // Verify: Movie_poster is displayed

        // Step: Swipe up

        // Verify: Toolbar is displayed

        // Verify: "Summary" and "Trailers" have the same font size

        // Step: Click on first trailer

        // Verify: The page redirects to Youtube

        // Step: Click back twice

        // Verify: The first four movies in the list have a rating higher than 8

    }
}
