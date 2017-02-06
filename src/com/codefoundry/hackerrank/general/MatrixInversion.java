/**
 * 
 */
package com.codefoundry.hackerrank.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author vipul
 *
 */
public class MatrixInversion {

	class Value implements Comparable<Value> {

		Integer x;

		Integer y;

		Integer value;

		public Value(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Value [x=" + x + ", y=" + y + ", value=" + value + "]";
		}

		@Override
		public int compareTo(Value o1) {

			return value.compareTo(o1.value);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		

		MatrixInversion matrixInversion = new MatrixInversion();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int matrixSize = Integer.parseInt(br.readLine());
		List<Value> values = new ArrayList<Value>();

		int x = 0;
		int y = 0;

		for (int i = 0; i < matrixSize; i++) {

			String in[] = br.readLine().split(" ");

			for (int j = 0; j < in.length; j++) {
				values.add(matrixInversion.new Value(x, y, Integer.valueOf(in[j])));
				y++;
			}
			x++;
			y = 0;
		}
		Collections.sort(values);
		System.out.println(values);

		int result = 0;

		int currentIndex = values.size() - 1;

		while (currentIndex > 0) {

			Value currentValue = values.get(currentIndex);
			currentIndex--;

			for (int i = currentIndex; i >= 0; i--) {

				Value nextValue = values.get(i);

				if (currentValue.value > nextValue.value && currentValue.x <= nextValue.x
						&& currentValue.y <= nextValue.y) {

					result++;

				}
			}

		}

		System.out.println(result);

	}

}
