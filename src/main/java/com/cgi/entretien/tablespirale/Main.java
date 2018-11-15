package com.cgi.entretien.tablespirale;

import java.util.Optional;

import com.cgi.entretien.tablespirale.exceptions.InvalidNumberException;

/**
 * Main class to control the validations and logic of the app
 * 
 * @author Yuri Campolongo
 *
 */
public class Main {

	/**
	 * Starts the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			fillTable(getInputNumber(args));
		} catch (InvalidNumberException | NumberFormatException e) {
			System.err.println("Invalid number passed as argument.");
		}
	}

	/**
	 * Fill the table with spiral values
	 * 
	 * @param n the table size n x n
	 */
	public static void fillTable(Integer n) {
		int border = n;
		int currentNumber = 1;
		int currentSquare = 0;
		Table table = new Table(n);
		while (currentSquare < table.getTotalInnerSquares()) {
			for (int column = 0; column < border; column++) {
				table.addValue(currentSquare, currentSquare + column, currentNumber++);
			}
			for (int line = 1; line < border; line++) {
				table.addValue(currentSquare + line, n - 1 - currentSquare, currentNumber++);
			}
			for (int column = border - 2; column > -1; column--) {
				table.addValue(n - 1 - currentSquare, column + currentSquare, currentNumber++);
			}
			for (int line = border - 2; line > 0; line--) {
				table.addValue(currentSquare + line, currentSquare, currentNumber++);
			}
			currentSquare++;
			border -= 2;
		}
		System.out.println(table.generateHTMLTable());
	}

	/**
	 * Get the number passed as an argument
	 * 
	 * @param args
	 * @return the number passed as an argument
	 * @throws InvalidNumberException if the number passed is invalid
	 */
	public static Integer getInputNumber(String[] args) throws InvalidNumberException {
		if (args.length == 0) {
			throw new InvalidNumberException();
		}
		return Integer.parseInt(Optional.ofNullable(args[0]).orElseThrow(() -> new InvalidNumberException()));
	}

}
