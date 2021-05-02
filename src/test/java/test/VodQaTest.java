package test;

import org.testng.annotations.*;


public class VodQaTest extends BaseTest{

    @BeforeClass
    public void openApp(){
        loginPage.login();
    }

    @AfterMethod
    public void backButtonClick(){
        menuPage.clickBack();
    }

    @Test(description = "Native View")
    public void nativeView() {
        nativeViewPage
                .openPage("Native View")
                .checkContent();
    }

    @Test(description = "Slider")
    public void slider() {
        sliderPage
                .openPage("Slider")
                .isPageOpened()
                .moveSlider();
    }

    @Test(description = "Vertical swiping")
    public void verticalSwiping() {
        verticalSwipingPage
                .openPage("Vertical swiping")
                .isPageOpened()
                .swipeDown()
                .getTextBoxes();
    }

    @Test(description = "Drag&Drop")
    public void dragDrop(){
        dragDropPage
                .openPage("Drag & Drop")
                .dragDrop()
                .verifySuccessMessage("Circle dropped");
    }

    @Test(description = "Double tab")
    public void doubleTab() {
        doubleTabPage
                .openPage("Double Tap")
                .doubleTab()
                .verifySuccessMessage("Double tap successful!")
                .clickOk();
    }

    @Test(description = "Long Press")
    public void longPress(){
        longPressPage
                .openPage("Long Press")
                .longPress()
                .verifySuccessMessage("you pressed me hard :P")
                .clickOk();
    }

    @Test(description = "Web View")
    public void webView(){
        webViewPage
                .openPage("Web View")
                .clickLogin()
                .provideLoginPass();
    }

    @Test(description = "Carousel")
    public void zCarousel(){
        carouselPage
                .openPage("Carousel")
                .scrollRight()
                .scrollLeft();
    }

    @Test(description = "wheel picker")
    public void zWheelPicker(){
        wheelPickerPage
                .openPage("Wheel Picker")
                .isPageOpened()
                .verifySelectedColor("red")
                .selectColor("black")
                .verifySelectedColor("black");
    }
}
