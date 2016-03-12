/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author DonalGeraghty
 */
public class JUnitTestClass {
    
    static WebDriver driver = new FirefoxDriver();
    
    public JUnitTestClass() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        driver.navigate().to("http://donaljamesgeraghty.com/SeleniumTestPage.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void Enter_Text_Using_Name_Locator() throws Exception {
        driver.findElement(By.name("firstname")).sendKeys("Testing Selenium");
        driver.findElement(By.name("lastname")).sendKeys("Name Locator");
    }
    
    @Test
    public void Verify_Title() throws Exception {
        assertEquals("Light Theme" , driver.getTitle());
    }
    
    @Test
    public void Test_Buttons_CSSselector() throws Exception {
        driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
    }
    
    @Test
    public void Test_Buttons_XPath() throws Exception {
        driver.findElement(By.xpath("//div[2]/p[2]/button")).click();
        driver.findElement(By.xpath("//div[3]/p[2]/button")).click();
        driver.findElement(By.xpath("//div[4]/p[2]/button")).click();
    }
    
    @Test
    public void Test_Radio_Buttons_XPath() throws Exception {
        driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click(); // Female
        driver.findElement(By.xpath("(//input[@name='gender'])[6]")).click(); // Other
        driver.findElement(By.xpath("(//input[@name='gender'])[8]")).click(); // Female
        driver.findElement(By.xpath("(//input[@name='gender'])[10]")).click(); // Male
    }
    
    @Test
    public void Test_Dropdowns() throws Exception {
        
        Select dropdown1 = new Select(driver.findElement(By.id("dropdown_1")));
        dropdown1.selectByVisibleText("Mercedes");
        
        Select dropdown2 = new Select(driver.findElement(By.id("dropdown_2")));
        dropdown2.selectByVisibleText("Saab");
        
        Select dropdown3 = new Select(driver.findElement(By.id("dropdown_3")));
        dropdown3.selectByVisibleText("Saab");
        
        Select dropdown4 = new Select(driver.findElement(By.id("dropdown_4")));
        dropdown4.selectByVisibleText("Audi");
    }
    
    @Test
    public void Assert_Text () throws Exception {
        // Breaking down the selection process.
        
        // By xpath, id, classname, name, css, etc ...
        By locator = By.xpath("//div[5]/div/p[3]");
        
        // Stored in webelement.
        WebElement element = driver.findElement(locator);
        
        // Storing the target text.
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed augue tellus, consectetur sed ante ut, tincidunt convallis nunc.";
        
        // Asserting they are the same.
        assertEquals(text , element.getText());
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        Thread.sleep(5000); // Static wait at the end to let the tester view the page.
        driver.close();
    }
    
}
