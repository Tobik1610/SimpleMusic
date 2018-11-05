package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.net.ssl.ExtendedSSLSession;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import logic.Sounds;
import model.TableModel;

public class MainFrame extends JFrame {

	private Controller controller;
	private JLabel bpmLabel, beatLabel;
	private SoundButton crash, kick, snare, open_hihat, closed_hihat, low_tom, medium_tom, high_tom;
	private JTable table;

	public MainFrame(Controller controller) {

		this.controller = controller;

		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1200, 600));
		setVisible(true);
		pack();
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		//Buttons
		JPanel pan = new JPanel();
		add(pan);
		pan.setPreferredSize(new Dimension(400, 300));
		pan.setLayout(new GridLayout(9, 1));

		pan.add(bpmLabel = new JLabel());
		pan.add(beatLabel = new JLabel());
		pan.add(crash = new SoundButton(Sounds.CRASH, 0));
		pan.add(kick = new SoundButton(Sounds.KICK, 1));
		pan.add(snare = new SoundButton(Sounds.SNARE, 2));
		pan.add(open_hihat = new SoundButton(Sounds.OPEN_HIHAT, 3));
		pan.add(closed_hihat = new SoundButton(Sounds.CLOSED_HIHAT, 4));
		pan.add(low_tom = new SoundButton(Sounds.LOW_TOM, 5));
		pan.add(medium_tom = new SoundButton(Sounds.MEDIUM_TOM, 6));
		pan.add(high_tom = new SoundButton(Sounds.HIGH_TOM, 7));

		setBtnListener(controller);

		//Tabelle
		JPanel pan2 = new JPanel();
		add(pan2);

		table = new JTable(new TableModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		TableColumn column = null;
		for (int i = 1; i < 17; i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(20);
		}
		pan2.setLayout(new BorderLayout());
		pan2.add(table.getTableHeader(), BorderLayout.PAGE_START);
		pan2.add(table, BorderLayout.CENTER);

		//Export
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BorderLayout());
		add(pan3);
		
		JButton exportBtn = new JButton("Export");
		pan3.add(exportBtn, BorderLayout.CENTER);
	}

	public void setBtnListener(ActionListener listener) {
		crash.addActionListener(listener);
		kick.addActionListener(listener);
		snare.addActionListener(listener);
		open_hihat.addActionListener(listener);
		closed_hihat.addActionListener(listener);
		low_tom.addActionListener(listener);
		medium_tom.addActionListener(listener);
		high_tom.addActionListener(listener);
	}

	public Object getTableData(int rowIndex, int columnIndex) {
		return table.getModel().getValueAt(rowIndex, columnIndex);
	}

	public void setTableData(Object value, int rowIndex, int columnIndex) {
		table.getModel().setValueAt(value, rowIndex, columnIndex);
		table.updateUI();
	}

	public JLabel getBpmLabel() {
		return bpmLabel;
	}

	public JLabel getBeatLabel() {
		return beatLabel;
	}

}
