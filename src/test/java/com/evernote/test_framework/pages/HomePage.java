package com.evernote.test_framework.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;

@DefaultUrl("https://www.evernote.com/client/web")
public class HomePage extends PageObject {

    @FindBy(id = "qa-CREATE_NOTE")
    WebElementFacade newButton;

    @FindBy(xpath = "//*[@id='ActionMenu']/ul[1]/li[1]/button/span")
    WebElementFacade newNoteButton;

    @FindBy(xpath = "//*[@id='en-note']/div")
    WebElementFacade noteText;

    @FindBy(xpath = "//*[@id='qa-NAV_USER']/div/div")
    WebElementFacade navUserMenu;

    @FindBy(xpath = "//*[@id='qa-ACCOUNT_DROPDOWN_LOGOUT']")
    WebElementFacade logOutButton;

    @FindBy(xpath = "//*[@id='qa-LOGOUT_CONFIRM_DIALOG_SUBMIT']")
    WebElementFacade confirmLogOutButton;

    @FindBy(xpath = "//*[@id='qa-NOTES_SIDEBAR']/div/div/div/div/div/div/article/div/div/div/div[2]")
    WebElementFacade noteTextInTheNoteSideBar;

    @FindBy(xpath = "//*[@id='qa-NAV_ALL_NOTES']")
    WebElementFacade notesMenu;


    @WhenPageOpens
    public void waitUntilNewButtonAppears() {
        newButton.shouldBePresent();
    }

    public void clickOnNewButton() {
        newButton.click();
    }

    public void clickOnNoteText() {
        noteText.click();
    }

    public void typeAText(String text) {

        this.getDriver().switchTo().frame("qa-COMMON_EDITOR_IFRAME");
        JavascriptExecutorFacade js = new JavascriptExecutorFacade(this.getDriver());
        js.executeScript("document.evaluate('//*[@id=\"en-note\"]/div', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.innerHTML = '" + text + "'");

    }

    public void clickOnNewNoteButton() {
        newNoteButton.click();
    }

    public boolean isNoteTextPresentInSideBar(String text, int timesToCheck) throws InterruptedException {
        for (int i = 0; i <= timesToCheck; i++)
        {
            Thread.sleep(10000);
            if (noteTextInTheNoteSideBar.getText().equals(text))
                return true;
        }
        return false;
    }

    public void isNewNoteFieldVisible(){
        newNoteButton.shouldBePresent();
    }

    public boolean isANoteSaved(String text) throws InterruptedException {
        this.getDriver().switchTo().defaultContent();
        return this.isNoteTextPresentInSideBar(text, 3);
    }

    public void clickOnNotesMenu(){
        notesMenu.click();
    }

    public void clickLogOutButton() {
            navUserMenu.click();
            logOutButton.click();
    }
}
