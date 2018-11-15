package com.cgi.entretien.tablespirale;

import java.util.Arrays;

/**
 * Class to controls the stats of the table
 * @author Yuri Campolongo
 *
 */
public class Table {

	private Integer[][] table;

	public Table(Integer n) {
		super();
		table = new Integer[n][n];
	}

	/**
	 * Adds a value in an specific position of the table
	 * @param line index
	 * @param column index
	 * @param value to insert
	 */
	public void addValue(int line, int column, int value) {
		table[line][column] = value;
	}

	/**
	 * Get the total number of inner squares available in this table
	 * @return
	 */
	public int getTotalInnerSquares() {
		return Math.round((table.length / 2) + 0.5f);
	}

	/**
	 * Generate this table in an HTML way
	 * @return
	 */
	public String generateHTMLTable() {
		StringBuilder htmlTable = new StringBuilder("<table border=\"1\" >\n");

		Arrays.stream(table).forEach(x -> {
			htmlTable.append("<tr>");
			Arrays.stream(x).forEach(y -> {
				htmlTable.append("<td>" + y + "</td>");
			});
			htmlTable.append("</tr>\n");
		});

		htmlTable.append("</table>");
		return htmlTable.toString();
	}

}
