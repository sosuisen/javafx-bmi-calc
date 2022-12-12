package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MyAppController {

	@FXML
	private Label bmiLabel;

	@FXML
	private TextField heightField;

	@FXML
	private TextField weightField;

	private String calcBMI() {
		var height = heightField.getText();
		var weight = weightField.getText();
		if (!height.matches("\\d+") || !weight.matches("\\d+"))
			return "-";
		double bmi = BigDecimal.valueOf(10000).multiply(new BigDecimal(weight))
				.divide((new BigDecimal(height)).pow(2), 3, RoundingMode.HALF_UP).doubleValue();
		System.out.println(bmi);
		return String.valueOf(bmi);
	}

	public void initialize() {
		bmiLabel.textProperty().bind(
				Bindings.createStringBinding(() -> calcBMI(), heightField.textProperty(), weightField.textProperty()));
	}

}
