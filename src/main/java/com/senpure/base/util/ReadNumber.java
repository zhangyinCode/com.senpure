package com.senpure.base.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class ReadNumber {

	private ReadNumber() {
		super();

	}

	private static final String[] UP_NUMBERS = new String[] { "零", "一", "二",
			"三", "四", "五", "六", "七", "八", "九" };
	private static final String[] UNTIS = new String[] { "", "十", "百", "千" };
	private static final String[] GROUPS = new String[] { "", "万", "亿", "兆" };

	private static final String POINT = "点";
	private static final String NEGATIVE = "负";
	private static final String NUMBER_FULL = "数据过大，请人工阅读";
	private static final String NOT_NUMBER = "数字格式不正确";

	/**
	 * 支持任意格式的数字(小数/科学计数法) 但该字符串为参数的方法不推荐使用
	 * 
	 * @param number
	 * @return
	 */
	public static String read(String number) {
		double _number;
		try {
			_number = Double.valueOf(number);
		} catch (NumberFormatException e) {
			return NOT_NUMBER;
		}
		return read(_number);
	}

	private static String readDecimalInteger(int number, boolean negative,
			boolean passOneOfTen) {

		StringBuilder sb = readFourNumbers(number);
		if (number > 9 && number < 20 && passOneOfTen) {

			sb.delete(0, 1);

		}
		if (negative) {
			sb.insert(0, NEGATIVE);
		}
		return sb.toString();
	}

	public static String read(int number) {
		return read(number, false);
	}

	/**
	 * passOneOfTen
	 *            true 11 读作十一 false 11 读作一十一
	 * @param number
	 * @param passOneOfTen
	 *          
	 * @return
	 */
	public static String read(int number, boolean passOneOfTen) {

		boolean negative = number < 0;
		if (negative) {
			number *= -1;

		}
		if (number < 10000) {
			return readDecimalInteger(number, negative, passOneOfTen);
		}
		List<FourNumbers> currentGroups = new ArrayList<FourNumbers>();
		int count = 0;
		while (true) {

			int currentGroup = number % 10000;

			currentGroups.add(new FourNumbers(GROUPS[count], currentGroup));

			number /= 10000;

			if (number == 0) {

				break;
			}
			count++;
		}

		if (negative) {

			return read(currentGroups).insert(0, NEGATIVE).toString();
		}
		return read(currentGroups).toString();
	}

	/**
	 * 单位超过兆不能读出
	 * 
	 * @param number
	 * @return
	 */
	public static String read(long number) {
		if (number > 9999999999999999L || number < -9999999999999999L) {
			StringBuilder sb = new StringBuilder();
			sb.append(NUMBER_FULL).append("【").append(number).append("】");
			return sb.toString();
		}

		boolean negative = number < 0;
		if (negative) {
			number *= -1;

		}
		if (number < 10000) {

			return readDecimalInteger((int) number, negative, false);
		}

		List<FourNumbers> currentGroups = new ArrayList<FourNumbers>();
		int count = 0;
		while (true) {

			int currentGroup = (int) (number % 10000);

			currentGroups.add(new FourNumbers(GROUPS[count], currentGroup));

			number /= 10000;

			if (number == 0) {

				break;
			}
			count++;
		}
		if (negative) {
			return read(currentGroups).insert(0, NEGATIVE).toString();
		}
		return read(currentGroups).toString();
	}

	/**
	 * 最多读出小数点后14位(四舍五入法)
	 * 
	 * @param number
	 * @return
	 */
	public static String read(double number) {
		if (number > 9999999999999999L || number < -9999999999999999L) {
			StringBuilder sb = new StringBuilder();
			sb.append(NUMBER_FULL).append("【").append(number).append("】");
			return sb.toString();
		}

		BigDecimal bd = new BigDecimal(String.valueOf(number));
		boolean negative = number < 0;
		if (negative) {
			bd = bd.abs();

		}
		BigDecimal integer = new BigDecimal(String.valueOf(bd.longValue()));

		StringBuilder sb = new StringBuilder(read(integer.longValue()));
		BigDecimal decimal = bd.subtract(integer);
		if (decimal.compareTo(BigDecimal.ZERO) > 0) {
			sb.append(POINT);
			StringBuilder sdecimal = new StringBuilder(decimal.toString()
					.substring(2));
			int numLength = sdecimal.length();
			for (int i = 0; i < numLength; i++) {
				String t = sdecimal.substring(i, i + 1);
				sb.append(UP_NUMBERS[Integer.valueOf(t)]);
			}

		}
		if (negative) {
			sb.insert(0, NEGATIVE).toString();
		}

		return sb.toString();
	}

	private static StringBuilder read(List<FourNumbers> currentGroups) {
		StringBuilder sb = new StringBuilder();

		int cl = currentGroups.size();
		for (int i = 0; i < cl - 1; i++) {
			FourNumbers fourNumbers = currentGroups.get(i);
			if (fourNumbers.number != 0) {
				if (fourNumbers.full) {

					sb.insert(0, fourNumbers.group).insert(0, fourNumbers.read);

					if (currentGroups.get(i + 1).number == 0) {
						sb.insert(0, UP_NUMBERS[0]);
					}
				} else {
					sb.insert(0, fourNumbers.group).insert(0, fourNumbers.read)
							.insert(0, UP_NUMBERS[0]);
				}
			}

		}
		FourNumbers fourNumbers = currentGroups.get(cl - 1);
		sb.insert(0, fourNumbers.group).insert(0, fourNumbers.read);

		return sb;

	}

	private static StringBuilder readFourNumbers(int number) {
		String str = String.valueOf(number);
		int numLength = str.length();
		StringBuilder sb = new StringBuilder();
		boolean lastNumberIsZero = true;
		for (int i = 0; i < numLength; i++) {
			int currentNumber = number % 10;
			if (currentNumber == 0) {
				if (!lastNumberIsZero) {
					sb.insert(0, UP_NUMBERS[0]);

					lastNumberIsZero = true;
				}
			} else {
				sb.insert(0, UNTIS[i]).insert(0, UP_NUMBERS[currentNumber]);

				lastNumberIsZero = false;
			}

			number /= 10;
		}

		return sb;
	}

	/**
	 * 将数字转换成对应的大写方式
	 * 
	 * @param number
	 * @return
	 */
	public static String toUpperCase(int number) {
		number = number < 0 ? number * -1 : number;
		String str = String.valueOf(number);
		int numLength = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numLength; i++) {
			int currentNumber = number % 10;

			sb.insert(0, UP_NUMBERS[currentNumber]);
			number /= 10;

		}

		return sb.toString();
	}

	/**
	 * 将数字转换成对应的大写方式
	 * 
	 * @param number
	 * @return
	 */
	public static String toUpperCase(long number) {
		number = number < 0 ? number * -1 : number;
		String str = String.valueOf(number);
		int numLength = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numLength; i++) {
			int currentNumber = (int) (number % 10);

			sb.insert(0, UP_NUMBERS[currentNumber]);
			number /= 10;

		}

		return sb.toString();
	}

	/**
	 * 将数字转换成对应的大写方式(小数点不读) 最多读取小数点后14位(四舍五入)
	 * 
	 * @param number
	 * @return
	 */
	public static String toUpperCase(double number) {

		BigDecimal bd = new BigDecimal(String.valueOf(number));
		boolean negative = number < 0;
		if (negative) {
			bd = bd.abs();

		}
		BigDecimal integer = new BigDecimal(String.valueOf(bd.longValue()));

		StringBuilder sb = new StringBuilder(toUpperCase(integer.longValue()));
		BigDecimal decimal = bd.subtract(integer);
		if (decimal.compareTo(BigDecimal.ZERO) > 0) {
			StringBuilder sdecimal = new StringBuilder(decimal.toString()
					.substring(2));
			int numLength = sdecimal.length();
			for (int i = 0; i < numLength; i++) {
				String t = sdecimal.substring(i, i + 1);
				sb.append(UP_NUMBERS[Integer.valueOf(t)]);
			}

		}

		return sb.toString();
	}

	private static class FourNumbers {

		public FourNumbers(String group, int number) {
			super();
			this.group = group;
			this.number = number;
			read = readFourNumbers(number).toString();
			full = String.valueOf(number).length() == 4;

		}

		String read;
		String group;

		boolean full;
		int number;
	}

	public static void main(String[] args) {
		double [] nus={123,123.14,27,88,11.111,1111,123574415,984521};

		for (double n:nus)
		{
			System.out.println(n+" 读作："+read(n));
		}
		System.out.println(11+" 读作："+read(111,true));
		System.out.println(11+" 读作："+read(11,false));

	}
}
