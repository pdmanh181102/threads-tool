package com.tools.core.threads;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

public interface IThreadsRuntime {
    public void login();
    public Set<WebElement> getAllUniquePostElements();
}
