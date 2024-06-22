package com.example.costcoautomation;

import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

public class TestListener extends ExitCodeListener {

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        takeScreenshot("failure");
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] takeScreenshot(String name) {
        // Implement logic to take screenshot and return byte array
        return new byte[0];
    }
}
