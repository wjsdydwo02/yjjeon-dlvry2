package yjjeondlvry.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import yjjeondlvry.ShopApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { ShopApplication.class })
public class CucumberSpingConfiguration {}
