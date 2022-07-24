package com.movie.hybridframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBResultpage {

    public static String releaseData = null;
    public static String originData = null;

    public IMDBResultpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[normalize-space()='Details']")
    static WebElement detailSection;

    @FindBy(xpath = "//a[normalize-space()='Release date']")
    static WebElement releaseHeader;

    @FindBy(xpath = "//a[normalize-space()='January 7, 2022 (United States)']")
    static WebElement releaseDetails;

    @FindBy(xpath = "//span[normalize-space()='Country of origin']")
    static WebElement originHeader;

    @FindBy(xpath = "//a[normalize-space()='India']")
    static WebElement originDetail;

    public String getReleaseDetails() {
        if (detailSection.getText().equalsIgnoreCase("Details")) {
            if (releaseHeader.getText().equalsIgnoreCase("Release Date")) {
                releaseData = releaseDetails.getText();
            }
        }
        return releaseData;
    }

    public String getOriginDetails() {
        if (detailSection.getText().equalsIgnoreCase("Details")) {
            if (originHeader.getText().equalsIgnoreCase("Country of origin")) {
                originData = originDetail.getText();
            }
        }
        return originData;
    }
}
