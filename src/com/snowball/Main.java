package com.snowball;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Main {

    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.google.co.kr/search?q=%EB%82%A0%EC%94%A8&oq=%EB%82%A0%EC%94%A8&aqs=" +
                "chrome..69i57j0l5.1760j0j7&sourceid=chrome&ie=UTF-8";
        String expectedTitle = "날씨 - Google 검색";
        String actualTitle = "";

        //launch Chrome and direct it to Base URL
        driver.get(baseUrl);

        //get the actual value of the title
        actualTitle = driver.getTitle();

        if(actualTitle.contentEquals(expectedTitle)){
            System.out.println("Connected");
        }
        else{
            System.out.println("Connection Failed");
            System.exit(0);
        }

        WebElement loc = driver.findElement(By.id("wob_loc"));              //위치
        WebElement dts = driver.findElement(By.id("wob_dts"));              //날짜,시간
        WebElement dc = driver.findElement(By.id("wob_dc"));                //대기정보
        WebElement tm = driver.findElement(By.id("wob_tm"));                //온도
        WebElement pp = driver.findElement(By.id("wob_pp"));                //강수확률
        WebElement hm = driver.findElement(By.id("wob_hm"));                //습도
        WebElement ws = driver.findElement(By.id("wob_ws"));                //풍속

        //close chrome
        driver.close();
    }
}