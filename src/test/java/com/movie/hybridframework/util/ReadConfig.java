package com.movie.hybridframework.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig() {
        File src = new File("src/test/resources/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.println(String.format("%s", e.getMessage()));
        }
    }

    /**
     *IMDB details
     */

    public String getIMDBApplicationUrl(){
        String url = properties.getProperty("baseURLIMDB");
        return url;
    }

    public String getMovieName(){
        String movieName = properties.getProperty("movieName");
        return movieName;
    }

    public String getPageTitleIMDB(){
        String title = properties.getProperty("pageTitleIMDB");
        return title;
    }

    public String getReleaseDetails(){
        String releaseDetail = properties.getProperty("releaseDetail");
        return releaseDetail;
    }

    public String getOrigin(){
        String origin = properties.getProperty("origin");
        return origin;
    }

    /**
     *WIki details
     */

    public String getWikiApplicationUrl(){
        String url = properties.getProperty("baseURLWIKI");
        return url;
    }

    public String getMovieNameWiki(){
        String movieName = properties.getProperty("movieNameWIKI");
        return movieName;
    }
    public String getPageTitleWiki(){
        String title = properties.getProperty("pageTitleWiki");
        return title;
    }
    public String getReleaseDetailsWiki(){
        String releaseDetail = properties.getProperty("releaseDetailWiki");
        return releaseDetail;
    }
    public String getOriginWiki(){
        String origin = properties.getProperty("originWiki");
        return origin;
    }
}
