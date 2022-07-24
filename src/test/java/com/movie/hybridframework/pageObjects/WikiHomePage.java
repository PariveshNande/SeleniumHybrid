package com.movie.hybridframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage {

    public WikiHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='searchInput']")
    @CacheLookup
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"searchButton\"]")
    @CacheLookup
    WebElement searchBtn;

    public void setMovieName(String movieName) {
        searchBox.sendKeys(movieName);
    }

    public void performSearch() {
        searchBtn.click();
    }




}
