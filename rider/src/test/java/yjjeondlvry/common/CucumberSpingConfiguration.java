package yjjeondlvry.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import yjjeondlvry.RiderApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { RiderApplication.class })
public class CucumberSpingConfiguration {}
