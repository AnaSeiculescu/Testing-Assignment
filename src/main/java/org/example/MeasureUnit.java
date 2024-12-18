package org.example;

import java.security.PrivateKey;

/**
 * The enum Measure unit.
 * Each element is an instance of the enum.
 * The parenthesis can receive arguments for each instance.
 * When defining the constants it is also called the constructor.
 * In this case we are calling the constructor once for each enum constant, with a value for toMeters.
 * So, when we access MeasureUnit.KM.toMeters, the value 1000 is returned because it's the conversion stored in toMeters for the KM constant.
 */
public enum MeasureUnit {

	MM(0.001),
	CM(0.01),
	DM(0.1),
	M(1),
	KM(1000);

	private final double toMeters;

	MeasureUnit(double toMeters) {
		this.toMeters = toMeters;
	}

	public double getToMeters() {
		return this.toMeters;
	}
}
