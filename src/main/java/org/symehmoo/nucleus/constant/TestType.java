package org.symehmoo.nucleus.constant;

/**
 * Enum to represent test type. Not in used as of now
 */
public enum TestType {

	LOAD("load"), STRESS("stress"), ENDURANCE("endurance");

	private String value;

	TestType(String value) {
		this.value = value;
	}

	/**
	 * Method to fetch test type enum based on value
	 * 
	 * @param value
	 * @return {@link TestType}
	 */
	public static TestType fromValue(String value) {
		TestType testTypeEnum = null;
		for (TestType source : TestType.values()) {
			if (source.getValue().equalsIgnoreCase(value)) {
				testTypeEnum = source;
				break;
			}
		}
		return testTypeEnum;
	}

	public String getValue() {
		return value;
	}
}
