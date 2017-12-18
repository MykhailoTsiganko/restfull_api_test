package com;

import com.datamodels.converters.ApiResponseConverter;
import com.datamodels.converters.OrderConverter;
import com.datamodels.converters.PetConverter;
import com.datamodels.converters.UserConverter;
import io.qameta.allure.Attachment;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(DataDrivenTestRunner.class)
@Converters({UserConverter.class, PetConverter.class, OrderConverter.class, ApiResponseConverter.class})
@Display(fields = "description")
public class TestBase {

    Logger LOGGER = Logger.getRootLogger();
    ThreadLocal<String> filePath = new ThreadLocal<>();
    ThreadLocal<FileAppender> fileAppender = new ThreadLocal<>();

    @Before
    public void setUpLogger() {
        filePath.set(String.format("test%d%d", Thread.currentThread().getId(), System.currentTimeMillis()));
        fileAppender.set(new FileAppender());
        fileAppender.get().setFile(String.format("log/%s.txt", filePath.get()));
        fileAppender.get().setLayout(new PatternLayout());
        fileAppender.get().activateOptions();
        LOGGER.setAdditivity(false);
        LOGGER.addAppender(fileAppender.get());

    }

    @Attachment("Logs")
    public byte[] addLogFileToReport() throws IOException {
        LOGGER.removeAppender(fileAppender.get());
        return Files.readAllBytes(Paths.get(String.format("log/%s.txt", filePath.get())));
    }


    @After
    public void finish() {
        try {
            addLogFileToReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
