package com;

import com.datamodels.converters.ApiResponseConverter;
import com.datamodels.converters.OrderConverter;
import com.datamodels.converters.PetConverter;
import com.datamodels.converters.UserConverter;
import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@Converters({UserConverter.class, PetConverter.class, OrderConverter.class, ApiResponseConverter.class})
@Display(fields = "description")
public class TestBase {

    @Before
    public void setUpLogger(){

    }

}
