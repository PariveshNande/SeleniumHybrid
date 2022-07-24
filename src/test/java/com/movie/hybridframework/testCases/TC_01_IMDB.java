package com.movie.hybridframework.testCases;

import com.movie.hybridframework.pageObjects.IMDBHomePage;
import com.movie.hybridframework.pageObjects.IMDBResultpage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_IMDB extends BaseClass {

    @Test
    public void IMDBTest() throws InterruptedException {

        IMDBHomePage homePage = new IMDBHomePage(driver);
        IMDBResultpage resultPage = new IMDBResultpage(driver);

        driver.get(baseUrl);
        Thread.sleep(2000);
        homePage.setMovieName("Pushpa: The Rise-Part 1");
        homePage.performSearch();
        Thread.sleep(2000);
        homePage.selectMovie();

        String releaseDetails = resultPage.getReleaseDetails();
        String originDetails = resultPage.getOriginDetails();

        if (driver.getTitle().equalsIgnoreCase("Pushpa: The Rise - Part 1 (2021) - IMDb")) {
            if((releaseDetails.equals("January 7, 2022 (United States)")) && (originDetails.equals("India"))){
                Assert.assertTrue(true);
            }
        } else {
            Assert.assertTrue(false);
        }
    }

}
