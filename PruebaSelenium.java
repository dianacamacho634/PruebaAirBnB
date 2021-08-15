package Prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PruebaSelenium {
    public WebDriver driver;

    @BeforeMethod
    public void openpage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://airbnb.com/");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "busqueda", dataProviderClass = dataProvider.class)
    public void busquedaAirbnb(String unDestino) throws InterruptedException {

        Thread.sleep(6000);

        driver.findElement(By.xpath("//*[@data-testid='main-cookies-banner-container']//*[button='Aceptar']//*[@data-testid='accept-btn']")).click();
        driver.findElement(By.xpath("//*[@id=\"bigsearch-query-detached-query-input\"]")).sendKeys(unDestino);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@role='button']//*[text()='Llegada']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@role='button']//*[@data-testid='datepicker-day-2021-08-14']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@role='button']//*[@data-testid='datepicker-day-2021-09-15']")).click();
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']")).click();
        driver.findElement(By.xpath("//*[@data-testid='stepper-adults-increase-button']")).click();
        driver.findElement(By.xpath("//*[@data-testid='stepper-adults-increase-button']")).click();
    }

    @Test
    public void validarExperiencias() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[button='Aceptar']//*[@data-testid='accept-btn']")).click();
        driver.findElement(By.id("search-block-tab-false-EXPERIENCES")).click();
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-query']")).sendKeys("Madrid");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@role='button']//*[text()='Fecha']")).click();
        driver.findElement(By.xpath("//*[@role='button']//*[@data-testid='datepicker-day-2021-08-14']")).click();
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']")).click();
        System.out.println("URL --> " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("Madrid"));

    }

    
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}





