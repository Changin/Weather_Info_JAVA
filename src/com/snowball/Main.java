package com.snowball;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("Webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.google.co.kr/";
        String expectedTitle = "Google";
        String actualTitle = "";

        //launch Chrome and direct it to Base URL
        driver.get(baseUrl);

        //get the actual value of the title
        actualTitle = driver.getTitle();

        if(!actualTitle.contentEquals(expectedTitle)){
            System.out.println("Connection Failed");
            driver.close();
            System.exit(0);
        }

        String inputString = "weather";
        WebElement src = driver.findElement(By.id("lst-ib"));
        src.sendKeys(inputString);
        src.sendKeys(Keys.RETURN);

        WebElement loc = driver.findElement(By.id("wob_loc"));  //위치
        WebElement dts = driver.findElement(By.id("wob_dts"));  //날짜,시간
        WebElement dc = driver.findElement(By.id("wob_dc"));    //대기정보
        WebElement tm = driver.findElement(By.id("wob_tm"));    //온도
        WebElement pp = driver.findElement(By.id("wob_pp"));    //강수확률
        WebElement hm = driver.findElement(By.id("wob_hm"));    //습도
        WebElement ws = driver.findElement(By.id("wob_ws"));    //풍속

        PrintUI printer = new PrintUI();
        printer.printInterface();

        String info[] = {
                "위치 : \t\t"+loc.getText(),
                "기준시각 : \t"+dts.getText(),
                "날씨 : \t\t"+dc.getText(),
                "기온 : \t\t"+tm.getText()+"°C",
                "강수확률 : \t"+pp.getText(),
                "습도 : \t\t"+hm.getText(),
                "풍속 : \t\t"+ws.getText()
        };

        printer.printText(info);

        //close chrome
        driver.close();
    }
}