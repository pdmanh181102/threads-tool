package com.tools.ui.home;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tools.AppContext;
import com.tools.core.model.ThreadsAccount;
import com.tools.core.model.ThreadsPost;
import com.tools.core.model.ThreadsProfile;
import com.tools.core.threads.ThreadsRuntime;
import com.tools.core.threads.ThreadsRuntimeConfig;
import com.tools.core.util.JsonUtils;

public class HomeController {
    private HomeView view;

    public HomeController(HomeView view) {
        this.view = view;
    }

    public void execute() {

        Logger logger = Logger.getLogger(HomeController.class.getName());
        logger.info("Starting Threads tool execution...");

        WebDriver driver = new ChromeDriver();
        ThreadsAccount account = AppContext.getInstance().getConfig().getAccount();
        ThreadsRuntimeConfig config = AppContext.getInstance().getConfig().getThreadsRuntimeConfig();
        List<String> trackingUsernames = AppContext.getInstance().getConfig().getTrackingUsernames();
        ThreadsRuntime runtime = new ThreadsRuntime(account, config, driver);

        logger.info("Initializing ThreadsRuntime with account: " + account.getUsername());

        runtime.login();
        for (String username : trackingUsernames) {

            logger.info("Navigating to user profile: " + username);

            runtime.gotoUserProfile(username);
            Set<WebElement> posts = runtime.getAllUniquePostElements();
            List<ThreadsPost> threadsPosts = runtime.getPosts(posts);
            ThreadsProfile threadsProfile = new ThreadsProfile(username, threadsPosts);
            JsonUtils.saveToJson(threadsProfile, username);

            logger.info("Finished processing user profile: " + username);
        }

        logger.info("All user profiles processed successfully.");

        driver.quit();
    }
}
