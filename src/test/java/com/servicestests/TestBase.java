package com.servicestests;

import com.converters.ApiResponseConverter;
import com.converters.OrderConverter;
import com.converters.PetConverter;
import com.converters.UserConverter;
import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@Converters({UserConverter.class, PetConverter.class, OrderConverter.class, ApiResponseConverter.class})
@Display(fields = "description")
public class TestBase {

}
