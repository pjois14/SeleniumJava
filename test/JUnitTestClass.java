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

/**
 *
 * @author DonalGeraghty
 */
public class JUnitTestClass {
    
    static WebDriver driver = new FirefoxDriver();
    
    public JUnitTestClass() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void test001() {
        driver.navigate().to("http://www.bing.com");
        driver.findElement(By.id("sb_form_q")).sendKeys("Hello World");
        // This test will demonstrate a fail as this id does not exist.
        driver.findElement(By.id("FAIL_ID")).click();
        driver.close();
    }
    
    @Test
    public void test002() {
        driver.navigate().to("http://www.bing.com");
        driver.findElement(By.id("sb_form_q")).sendKeys("Hello World");
        driver.findElement(By.id("sb_form_go")).click();
        driver.close();
    }
    
    @After
    public void tearDown() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
}
