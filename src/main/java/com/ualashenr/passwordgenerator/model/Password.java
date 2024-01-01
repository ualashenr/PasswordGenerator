package com.ualashenr.passwordgenerator.model;

public class Password {
	
	private int length = 15;
	private boolean includeSmallCase = true;
	private boolean includeUpperCase = true;
	private boolean includeNumbers = true;
	private boolean includeSpecialCharacters = true;
	
	public Password() {
	}

	public Password(int length, boolean includeSmallCase, boolean includeUpperCase, boolean includeNumbers,
			boolean includeSpecialCharacters) {
		this.length = length;
		this.includeSmallCase = includeSmallCase;
		this.includeUpperCase = includeUpperCase;
		this.includeNumbers = includeNumbers;
		this.includeSpecialCharacters = includeSpecialCharacters;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isIncludeSmallCase() {
		return includeSmallCase;
	}

	public void setIncludeSmallCase(boolean includeSmallCase) {
		this.includeSmallCase = includeSmallCase;
	}

	public boolean isIncludeUpperCase() {
		return includeUpperCase;
	}

	public void setIncludeUpperCase(boolean includeUpperCase) {
		this.includeUpperCase = includeUpperCase;
	}

	public boolean isIncludeNumbers() {
		return includeNumbers;
	}

	public void setIncludeNumbers(boolean includeNumbers) {
		this.includeNumbers = includeNumbers;
	}

	public boolean isIncludeSpecialCharacters() {
		return includeSpecialCharacters;
	}

	public void setIncludeSpecialCharacters(boolean includeSpecialCharacters) {
		this.includeSpecialCharacters = includeSpecialCharacters;
	}
	
}
