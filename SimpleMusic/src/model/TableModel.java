package model;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private String[] columnNames = { "Sound", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16" };

	private Object[][] data = { { "CRASH", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "KICK", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "SNARE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "OPEN HIHAT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "CLOSED HIHAT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "LOW TOM", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "MEDIUM TOM", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "HIGH TOM", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" } };;

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

}
