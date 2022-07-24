package com.movie.hybridframework.testCases;

import com.movie.hybridframework.pageObjects.IMDBHomePage;
import com.movie.hybridframework.pageObjects.IMDBResultpage;
import com.movie.hybridframework.pageObjects.WikiHomePage;
import com.movie.hybridframework.pageObjects.WikiResultpage;
import com.movie.hybridframework.util.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01 extends BaseClass {

    @Test
    public void IMDBTest() throws InterruptedException, IOException {

        ReadConfig readConfig = new ReadConfig();

        IMDBHomePage homePage = new IMDBHomePage(driver);
        IMDBResultpage resultPage = new IMDBResultpage(driver);

        driver.get(readConfig.getIMDBApplicationUrl());
        logger.info("opening base url: " + String.format("%s", readConfig.getIMDBApplicationUrl()));
        Thread.sleep(2000);
        //homePage.setMovieName("Pushpa: The Rise-Part 1");
        homePage.setMovieName(readConfig.getMovieName());
        homePage.performSearch();
        Thread.sleep(2000);
        homePage.selectMovie();
        logger.info("search operation performed successfully");

        String releaseDetails = resultPage.getReleaseDetails();
        String originDetails = resultPage.getOriginDetails();

        if (driver.getTitle().equalsIgnoreCase(readConfig.getPageTitleIMDB())) {
            if ((releaseDetails.equals(readConfig.getReleaseDetails())) && (originDetails.equals(readConfig.getOrigin()))) {
                Assert.assertTrue(true);
                logger.info("IMDBTest passed");
            }
        } else {
            captureScreenShot(driver, "IMDBTest");
            Assert.assertTrue(false);
            logger.error("IMDBTest failed");
        }
    }

    @Test
    public void WikiTest() throws InterruptedException, IOException {

        ReadConfig readConfig = new ReadConfig();
        WikiHomePage homePage = new WikiHomePage(driver);
        WikiResultpage resultPage = new WikiResultpage(driver);

        driver.get(readConfig.getWikiApplicationUrl());
        logger.info("opening base url: " + String.format("%s", readConfig.getWikiApplicationUrl()));
        Thread.sleep(2000);
        homePage.setMovieName(readConfig.getMovieNameWiki());
        homePage.performSearch();
        logger.info("search operation performed successfully");
        Thread.sleep(2000);
        String releaseDetails = resultPage.getReleaseDetails();
        String originDetails = resultPage.getOriginDetails();

        if (driver.getTitle().equalsIgnoreCase(readConfig.getPageTitleWiki())) {
            if ((releaseDetails.equals(readConfig.getReleaseDetailsWiki())) && (originDetails.equals(readConfig.getOriginWiki()))) {
                logger.info("WikiTest passed");
                Assert.assertTrue(true);
            }
        } else {
            captureScreenShot(driver, "WikiTest");
            logger.info("WikiTest failed");
            Assert.assertTrue(false);
        }
    }
}
