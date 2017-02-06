package com.codefoundry.practise.general;

public class Belzabar {

	public Belzabar() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		
		Belzabar b = new Belzabar();
		boolean result = b.is_belzabar_number(14);
		
		System.out.println(result);

	}

	boolean is_belzabar_number(int input) {

		for (int i = 2; i < input; i++) {

			boolean isPrime = isPrimeNumber(i);

			if (isPrime) {
				int result = i * (i + 14);
				
				if(result > input){
					return false;
				}

				if (result == input) {
					return true;
				} else if(i > 14) {
					result = i * (i - 14);
					if (result == input) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean isPrimeNumber(int number) {

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
