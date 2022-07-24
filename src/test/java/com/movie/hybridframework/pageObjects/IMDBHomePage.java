package com.movie.hybridframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = about:blank
public class IMDBHomePage {
    // No page elements added

    public IMDBHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='suggestion-search']")
    @CacheLookup
    WebElement searchBox;

    @FindBy(xpath = "//button[@id='suggestion-search-button']//*[name()='svg']")
    @CacheLookup
    WebElement searchBtn;

    @FindBy(xpath = "//a[normalize-space()='Pushpa: The Rise - Part 1']")
    @CacheLookup
    WebElement movie;

    public void setMovieName(String movieName) {
        searchBox.sendKeys(movieName);
    }

    public void performSearch() {
        searchBtn.click();
    }

    public void selectMovie(){
        movie.click();
    }
}