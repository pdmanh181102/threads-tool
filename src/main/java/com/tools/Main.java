package com.tools;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tools.core.loader.ConfigLoader;
import com.tools.core.model.ThreadsAccount;
import com.tools.core.model.ThreadsPost;
import com.tools.core.model.ThreadsToolConfig;
import com.tools.core.threads.IThreadsRuntime;
import com.tools.core.threads.ThreadsRuntime;
import com.tools.core.threads.ThreadsRuntimeConfig;
import com.tools.core.util.JsonUtils;
import com.tools.ui.ScreenManager;
import com.tools.ui.home.HomeView;

public class Main {

//     public static String postCssSelector = ".xrvj5dj.xd0jker.x1evr45z";
//     public static String contentDivCssSelector = ".x1a6qonq.x6ikm8r.x10wlt62.xj0a0fe.x126k92a.x6prxxf.x7r5mf7";
//     public static String username = "phungducmanh666@gmail.com";
//     public static String password = "Phungducmanh6264$";

//     public static String inputUsernameXpath = "/html/body/div[2]/div/div/div[3]/div/div/div/div[1]/div[1]/div[3]/form/div/input";
//     public static String inputPasswordXpath = "/html/body/div[2]/div/div/div[3]/div/div/div/div[1]/div[1]/div[3]/form/div/div[1]/div[1]/input";
//     public static String buttonLoginXPath = "/html/body/div[2]/div/div/div[3]/div/div/div/div[1]/div[1]/div[3]/form/div/div[1]/div[2]/div[2]";

//     public static WebDriver webDriver;

//     public static String postVideoSelector = ".x1lliihq.x5yr21d.xh8yej3";

//     public static String trackingUsername = "phun.gducmanh666";

//     public static String getPostContent(WebElement post) {
//         // get text content of the post
//         try {
//             // get the first div inside the post
//             // get the text content of the first div
//             WebElement contentDiv = post.findElement(By.cssSelector(contentDivCssSelector));
//             String postContent = contentDiv.findElement(By.tagName("span")).getText();
//             // return the post content
//             return postContent;
//         } catch (Exception e) {
//             // if there is an exception, return null
//             // e.printStackTrace();
//             return null;
//         }
//     }

//     public static List<String> getPostPhotos(WebElement post) {
//         // get all photos in the post
//         List<String> photos = new LinkedList<>();
//         try {
//             // find all img elements inside the post
//             List<WebElement> imgElements = post.findElements(By.tagName("img"));
//             for (WebElement img : imgElements) {
//                 String src = img.getAttribute("src");
//                 if (src != null && !src.isEmpty()) {
//                     photos.add(src);
//                 }
//             }
//         } catch (Exception e) {
//             // e.printStackTrace();
//         }
//         return photos;
//     }

//     public static List<String> getPostVideos(WebElement post) {
//         // get all videos in the post
//         List<String> videos = new LinkedList<>();
//         try {
//             // find all video elements inside the post
//             List<WebElement> videoElements = post.findElements(By.tagName("video"));
//             for (WebElement video : videoElements) {
//                 String src = video.getAttribute("src");
//                 if (src != null && !src.isEmpty()) {
//                     videos.add(src);
//                 }
//             }
//         } catch (Exception e) {
//             // e.printStackTrace();
//         }
//         return videos;
//     }

//     public static void test(){
// // selenium open threads.com
//         WebDriver driver = new ChromeDriver();
//         driver.get("https://www.threads.com/@aalahna");
//         // wait for the page to load. use drive wait page loaded
//         driver.manage().window().maximize();
//         // wait for the page to load
//         try {
//             Thread.sleep(5000);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//         // convert css selector to true of selenium: #barcelona-page-layout > div > div > div.xb57i2i.x1q594ok.x5lxg6s.x1ja2u2z.x1pq812k.x1rohswg.xfk6m8.x1yqm8si.xjx87ck.x1l7klhg.xs83m0k.x2lwn1j.xx8ngbg.xwo3gff.x1oyok0e.x1odjw0f.x1n2onr6.xq1qtft.xz401s1.x195bbgf.xgb0k9h.x1l19134.xgjo3nb.x1ga7v0g.x15mokao.x18b5jzi.x1q0q8m5.x1t7ytsu.x1ejq31n.xt8cgyo.x128c8uf.x1co6499.xc5fred.x1ma7e2m.x9f619.x78zum5.xdt5ytf.x1iyjqo2.x6ikm8r.xy5w88m.xh8yej3.xbwb3hm.xgh35ic.x19xvnzb.x87ppg5.xev1tu8.xpr2fh2.xgzc8be.x1iorvi4 > div.x78zum5.xdt5ytf.x1iyjqo2.x1n2onr6 > div.x1c1b4dv.x13dflua.x11xpdln > div > div.x78zum5.xdt5ytf.x1iyjqo2.x1n2onr6 > div:nth-child(1) > div > div > div
//         // 
//         // find all by css selector
//         List<WebElement> posts = driver.findElements(By.cssSelector(postCssSelector));

//         System.out.println("Number of posts: " + posts.size());

//         for (WebElement post : posts) {
//             String postContent = getPostContent(post);
  
//             if (postContent != null) {
//                 System.out.println(String.format("\nPost content: %s", postContent));
//             } else {
//                 System.out.println("Post content could not be extracted.");
//             }
//         }

//             try {
//             Thread.sleep(5000);
//         } catch (InterruptedException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         } // wait for 5 seconds to see the page
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
//         driver.quit();
//     }

//     public static void login(WebDriver driver){
//         driver.get("https://www.threads.com/login");

//         // wait for input username and password to be visible
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputUsernameXpath)));
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPasswordXpath)));

//         // find the username and password input fields and fill them
//         WebElement usernameInput = driver.findElement(By.xpath(inputUsernameXpath));
//         WebElement passwordInput = driver.findElement(By.xpath(inputPasswordXpath));

//         usernameInput.sendKeys(username);
//         passwordInput.sendKeys(password);

//         // find the login button and click it
//         WebElement loginButton = driver.findElement(By.xpath(buttonLoginXPath));
//         loginButton.click();

//                 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

//         // Chờ đến khi URL không còn chứa "/login" => đã chuyển hướng thành công
//         wait1.until(ExpectedConditions.not(
//             ExpectedConditions.urlContains("/login")
//         ));

//         System.out.println("Đăng nhập thành công! URL hiện tại: " + driver.getCurrentUrl());


//         // wait for the page to load after login
//         try {
//             Thread.sleep(5000);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }

//     }

//     public static void countPosts(WebDriver driver, String username){
//         driver.get("https://www.threads.com/@" + username);

//                 JavascriptExecutor js = (JavascriptExecutor) driver;

//         int lastHeight = ((Number) js.executeScript("return document.body.scrollHeight")).intValue();
//         int sameCount = 0;

//         while (sameCount < 3) { // dừng lại nếu không thấy thay đổi trong 3 lần
//             js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//             try {
//                 Thread.sleep(2000); // đợi trang load bài viết mới
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }

//             int newHeight = ((Number) js.executeScript("return document.body.scrollHeight")).intValue();
//             if (newHeight == lastHeight) {
//                 sameCount++;
//             } else {
//                 sameCount = 0;
//                 lastHeight = newHeight;
//             }
//         }

//         // Sau khi cuộn xong, lấy các bài viết (selector giả định)
//         List<WebElement> posts = driver.findElements(By.cssSelector(postCssSelector)); // hoặc selector phù hợp
//         System.out.println("Tổng số bài viết tìm được: " + posts.size());

//     }

//     public static List<ThreadsPost> getPosts(Set<WebElement> posts) {
//         List<ThreadsPost> threadsPosts = new LinkedList<>();

//         System.out.println("Number of posts: " + posts.size());
//         for (WebElement post : posts) {
//             String postContent = getPostContent(post);
//             List<String> postPhotos = getPostPhotos(post);
//             List<String> postVideos = getPostVideos(post);
//             if (postContent != null) {
//                 System.out.println(String.format("\nPost content: %s", postContent));
//                 threadsPosts.add(ThreadsPost.builder()
//                         .content(postContent)
//                         .photos(postPhotos)
//                         .videos(postVideos)
//                         .build());
//             } else {
//                 System.out.println("Post content could not be extracted.");
//             }
//         }

//         return threadsPosts;

//     }

//     public static Set<WebElement> getAllUniquePostElements(WebDriver driver, String postSelector) {

//     JavascriptExecutor js = (JavascriptExecutor) driver;

//     Set<WebElement> uniquePosts = new LinkedHashSet<>();

//     int sameCount = 0;
//     int lastCount = 0;

//     while (sameCount < 3) {
//         List<WebElement> posts = driver.findElements(By.cssSelector(postSelector));

//         for (WebElement post : posts) {
//             String text = post.getText().trim();

//                             uniquePosts.add(post);

//         }

//         js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//         try {
//             Thread.sleep(2000);
//         } catch (InterruptedException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }

//         if (uniquePosts.size() == lastCount) {
//             sameCount++;
//         } else {
//             sameCount = 0;
//             lastCount = uniquePosts.size();
//         }
//     }

//     return uniquePosts;
// }

// public static void testTHreadsRuntime() {
//     WebDriver driver = new ChromeDriver();
//         // login(driver);
//         // countPosts(driver, "davidthestella");
//         // Set<WebElement> threadsPosts = getAllUniquePostElements(driver, postCssSelector);
//         // List<ThreadsPost> posts = getPosts(threadsPosts);
//         // JsonUtils.saveToJson(posts);

//         ThreadsRuntimeConfig threadsRuntimeConfig = new ThreadsRuntimeConfig();
//         threadsRuntimeConfig.setInputUsernameXpath(inputUsernameXpath);
//         threadsRuntimeConfig.setInputPasswordXpath(inputPasswordXpath);
//         threadsRuntimeConfig.setLoginButtonXpath(buttonLoginXPath);
//         threadsRuntimeConfig.setPostCssSelector(postCssSelector);
//         threadsRuntimeConfig.setPostContentCssSelector(contentDivCssSelector);
//         threadsRuntimeConfig.setPostImageTagnameSelector("img");
//         threadsRuntimeConfig.setPostVideoCssSelector(postVideoSelector);
//         threadsRuntimeConfig.setScrollRetryCount(3);
//         threadsRuntimeConfig.setScrollRetryInterval(1000);
//         threadsRuntimeConfig.setTimeOut(10000);
//         ThreadsAccount threadsAccount = ThreadsAccount.builder()
//                 .username(username)
//                 .password(password)
//                 .build();

//         IThreadsRuntime threadsRuntime = new ThreadsRuntime(threadsAccount, threadsRuntimeConfig, trackingUsername, driver);

//         threadsRuntime.login();
//         Set<WebElement> threadsPosts = threadsRuntime.getAllUniquePostElements();
//         List<ThreadsPost> posts = getPosts(threadsPosts);
//         JsonUtils.saveToJson(posts);


//         driver.quit();
// }

    public static void main(String[] args) {

        ThreadsToolConfig config = ConfigLoader.getInstance().loadConfig();
        if (config == null) {
            System.err.println("Failed to load config. Please check your config file.");
            return;
        }
        System.out.println("Loaded config: " + config);

        AppContext.getInstance().setConfig(config);

        SwingUtilities.invokeLater(() -> {
            ScreenManager.getInstance().setView(new HomeView());
        });
        
    }
}