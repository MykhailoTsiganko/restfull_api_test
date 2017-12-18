package com;

import com.datamodels.converters.ApiResponseConverter;
import com.datamodels.converters.OrderConverter;
import com.datamodels.converters.PetConverter;
import com.datamodels.converters.UserConverter;
import io.qameta.allure.Attachment;
import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(DataDrivenTestRunner.class)
@Converters({UserConverter.class, PetConverter.class, OrderConverter.class, ApiResponseConverter.class})
@Display(fields = "description")
public class TestBase {

    @Before
    public void setUpLogger() {

    }

    @Attachment("Logs")
    public static byte[] someAtt() throws IOException {
       return Files.readAllBytes(Paths.get("log/log.out"));
    }


    @After
    public void finish() {
        try {
            someAtt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
