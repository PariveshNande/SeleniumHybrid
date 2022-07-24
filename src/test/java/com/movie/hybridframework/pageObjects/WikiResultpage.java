package com.movie.hybridframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiResultpage {

    public static String releaseData = null;
    public static String originData = null;

    public WikiResultpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[normalize-space()='Release date']")
    static WebElement releaseHeader;

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")
    static WebElement releaseDetails;

    @FindBy(xpath = "//th[normalize-space()='Country']")
    static WebElement originHeader;

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td")
    static WebElement originDetail;

    public String getReleaseDetails() {

            if (releaseHeader.getText().equalsIgnoreCase("Release date")) {
                releaseData = releaseDetails.getText();
            }

        return releaseData;
    }

    public String getOriginDetails() {

            if (originHeader.getText().equalsIgnoreCase("Country")) {
                originData = originDetail.getText();
            }

        return originData;


    }
}
