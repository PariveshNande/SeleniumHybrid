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

    public static String releaseDetailsImdb = null;
    public static String originDetailsImdb = null;
    public static String releaseDetailsWiki = null;
    public static String originDetailsWiki = null;

    @Test
    public void MovieTest() throws InterruptedException {

        ReadConfig readConfig = new ReadConfig();

        IMDBHomePage homePage = new IMDBHomePage(driver);
        IMDBResultpage resultPage = new IMDBResultpage(driver);
        WikiHomePage homePageWiki = new WikiHomePage(driver);
        WikiResultpage resultWiki = new WikiResultpage(driver);

        //imdb
        driver.get(readConfig.getIMDBApplicationUrl());
        logger.info("opening base url: " + String.format("%s", readConfig.getIMDBApplicationUrl()));
        Thread.sleep(2000);
        //homePage.setMovieName("Pushpa: The Rise-Part 1");
        homePage.setMovieName(readConfig.getMovieName());
        homePage.performSearch();
        Thread.sleep(2000);
        homePage.selectMovie();
        logger.info("search operation performed successfully");

        releaseDetailsImdb = resultPage.getReleaseDetails();
        originDetailsImdb = resultPage.getOriginDetails();

        //wiki
        driver.get(readConfig.getWikiApplicationUrl());
        logger.info("opening base url: " + String.format("%s", readConfig.getWikiApplicationUrl()));
        Thread.sleep(2000);
        homePageWiki.setMovieName(readConfig.getMovieNameWiki());
        homePageWiki.performSearch();
        logger.info("search operation performed successfully");
        Thread.sleep(2000);
        releaseDetailsWiki = resultWiki.getReleaseDetails();
        originDetailsWiki = resultWiki.getOriginDetails();


        if (releaseDetailsImdb.equals(releaseDetailsWiki)) {
            if (originDetailsImdb.equals(originDetailsWiki)) {
                Assert.assertTrue(true);
                logger.info("Test passed");
            }
        } else {
            Assert.assertTrue(false);
            logger.error("Test failed");
        }
    }
}
