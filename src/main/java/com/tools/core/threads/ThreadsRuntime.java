package com.tools.core.threads;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tools.AppContext;
import com.tools.core.model.ThreadsAccount;
import com.tools.core.model.ThreadsPost;

public class ThreadsRuntime implements IThreadsRuntime {
    private ThreadsAccount threadsAccount;
    private ThreadsRuntimeConfig threadsRuntimeConfig;
    private WebDriver driver;

    public ThreadsRuntime(ThreadsAccount threadsAccount, ThreadsRuntimeConfig threadsRuntimeConfig, WebDriver driver) {
        this.threadsAccount = threadsAccount;
        this.threadsRuntimeConfig = threadsRuntimeConfig;
        this.driver = driver;
    }

    @Override
    public void login() {
        driver.get("https://www.threads.com/login");

        // wait for input username and password to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(threadsRuntimeConfig.getInputUsernameXpath())));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(threadsRuntimeConfig.getInputPasswordXpath())));

        // find the username and password input fields and fill them
        WebElement usernameInput = driver.findElement(By.xpath(threadsRuntimeConfig.getInputUsernameXpath()));
        WebElement passwordInput = driver.findElement(By.xpath(threadsRuntimeConfig.getInputPasswordXpath()));

        usernameInput.sendKeys(threadsAccount.getUsername());
        passwordInput.sendKeys(threadsAccount.getPassword());

        // find the login button and click it
        WebElement loginButton = driver.findElement(By.xpath(threadsRuntimeConfig.getLoginButtonXpath()));
        loginButton.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Chờ đến khi URL không còn chứa "/login" => đã chuyển hướng thành công
        wait1.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("/login")));

        System.out.println("Đăng nhập thành công! URL hiện tại: " + driver.getCurrentUrl());

        // wait for the page to load after login
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<WebElement> getAllUniquePostElements() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Set<WebElement> uniquePosts = new LinkedHashSet<>();

        int sameCount = 0;
        int lastCount = 0;

        while (sameCount < 3) {
            List<WebElement> posts = driver.findElements(By.cssSelector(threadsRuntimeConfig.getPostCssSelector()));

            for (WebElement post : posts) {
                uniquePosts.add(post);
            }

            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (uniquePosts.size() == lastCount) {
                sameCount++;
            } else {
                sameCount = 0;
                lastCount = uniquePosts.size();
            }
        }

        return uniquePosts;
    }

    public void gotoUserProfile(String username) {
        driver.get("https://www.threads.com/@" + username);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(threadsRuntimeConfig.getPostCssSelector())));
    }

    public List<ThreadsPost> getPosts(Set<WebElement> posts) {
        List<ThreadsPost> threadsPosts = new LinkedList<>();

        System.out.println("Number of posts: " + posts.size());
        for (WebElement post : posts) {
            String postContent = getPostContent(post);
            List<String> postPhotos = getPostPhotos(post);
            List<String> postVideos = getPostVideos(post);
            if (postContent != null) {
                System.out.println(String.format("\nPost content: %s", postContent));
                threadsPosts.add(ThreadsPost.builder()
                        .content(postContent)
                        .photos(postPhotos)
                        .videos(postVideos)
                        .build());
            } else {
                System.out.println("Post content could not be extracted.");
            }
        }

        return threadsPosts;

    }

    private String getPostContent(WebElement post) {
        try {
            WebElement contentDiv = post.findElement(By.cssSelector(
                    AppContext.getInstance().getConfig().getThreadsRuntimeConfig().getPostContentCssSelector()));
            String postContent = contentDiv.findElement(By.tagName("span")).getText();
            return postContent;
        } catch (Exception e) {
            return null;
        }
    }

    private List<String> getPostPhotos(WebElement post) {
        List<String> photos = new LinkedList<>();
        try {
            List<WebElement> imgElements = post.findElements(By.tagName("img"));
            for (WebElement img : imgElements) {
                String src = img.getAttribute("src");
                if (src != null && !src.isEmpty()) {
                    photos.add(src);
                }
            }
        } catch (Exception e) {
        }
        return photos;
    }

    private List<String> getPostVideos(WebElement post) {
        List<String> videos = new LinkedList<>();
        try {
            List<WebElement> videoElements = post.findElements(By.tagName("video"));
            for (WebElement video : videoElements) {
                String src = video.getAttribute("src");
                if (src != null && !src.isEmpty()) {
                    videos.add(src);
                }
            }
        } catch (Exception e) {
        }
        return videos;
    }

}
