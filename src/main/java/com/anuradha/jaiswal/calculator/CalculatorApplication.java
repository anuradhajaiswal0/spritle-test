package com.anuradha.jaiswal.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalculatorApplication {

	private final Logger logger = LoggerFactory.getLogger(CalculatorApplication.class);

	@Autowired
	private Calculator calculator;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CalculatorApplication.class, args);
		CalculatorApplication calculatorApplication = context.getBean(CalculatorApplication.class);
		calculatorApplication.test();
	}

	public void test() {
		int num1 = 10;
		int num2 = 5;

		logger.atInfo().log("Addition of " + num1 + " and " + num2 + ": " + calculator.add(num1, num2));
		logger.atInfo().log("Subtraction of " + num1 + " and " + num2 + ": " + calculator.subtract(num1, num2));
		logger.atInfo().log("Multiplication of " + num1 + " and " + num2 + ": " + calculator.multiply(num1, num2));
		try {
			logger.atInfo().log("Division of " + num1 + " and " + num2 + ": " + calculator.divide(num1, num2));
			logger.atInfo().log("Division of " + num1 + " and " + 0 + ": " + calculator.divide(num1, 0));
		} catch (ArithmeticException e) {
			logger.atError().log(e.getMessage());
		}
	}

}
