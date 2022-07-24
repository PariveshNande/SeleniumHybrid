package com.movie.hybridframework.testCases;

import com.movie.hybridframework.pageObjects.WikiHomePage;
import com.movie.hybridframework.pageObjects.WikiResultpage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_Wiki extends BaseClass {

    @Test
    public void WikiTest() throws InterruptedException {
    WikiHomePage homePage = new WikiHomePage(driver);
    WikiResultpage resultPage = new WikiResultpage(driver);

        driver.get(baseUrl);
        Thread.sleep(2000);
        homePage.setMovieName("Pushpa: The Rise");
        homePage.performSearch();
        Thread.sleep(2000);
        //homePage.selectMovie();

    String releaseDetails = resultPage.getReleaseDetails();
    String originDetails = resultPage.getOriginDetails();

        if (driver.getTitle().equalsIgnoreCase("Pushpa: The Rise - Wikipedia")) {
        if((releaseDetails.equals("17 December 2021")) && (originDetails.equals("India"))){
            Assert.assertTrue(true);
        }
    } else {
        Assert.assertTrue(false);
    }
}
}
