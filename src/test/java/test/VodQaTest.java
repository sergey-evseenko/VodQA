package test;

import org.testng.annotations.*;


public class VodQaTest extends BaseTest{

    @Parameters("platform")
    @BeforeClass
    public void openApp(@Optional("ios") String platform){
        loginPage.login(platform);
    }

    @AfterMethod
    public void backButtonClick(){
        menuPage.clickBack();
    }

    @Test(description = "Native View")
    public void nativeView() {
        nativeViewPage
                .openPage()
                .checkContent();
    }

    @Test(description = "Slider")
    public void slider() {
        sliderPage
                .openPage()
                .moveSlider();
    }

    @Test(description = "Vertical swiping")
    public void verticalSwiping() {
        verticalSwipingPage
                .openPage()
                .swipeDown()
                .getTextBoxes();
    }

    @Test(description = "Drag&Drop")
    public void dragDrop(){
        dragDropPage
                .openPage()
                .dragDrop()
                .verifySuccessMessage("Circle dropped");
    }

    @Test(description = "Double tab")
    public void doubleTab() {
        doubleTabPage
                .openPage()
                .doubleTab()
                .verifySuccessMessage("Double tap successful!")
                .clickOk();
    }

    @Test(description = "Long Press")
    public void longPress(){
        longPressPage
                .openPage()
                .longPress()
                .verifySuccessMessage("you pressed me hard :P")
                .clickOk();
    }

    @Test(description = "Web View")
    public void webView(){
        webViewPage
                .openPage()
                .clickLogin()
                .provideLoginPass();
    }

    @Test(description = "Carousel")
    public void zCarousel(){
        carouselPage
                .openPage()
                .scrollRight()
                .scrollLeft();
    }

    @Test(description = "wheel picker")
    public void zWheelPicker(){
        wheelPickerPage
                .openPage()
                .verifySelectedColor("red")
                .selectColor("black")
                .verifySelectedColor("black");
    }
}
