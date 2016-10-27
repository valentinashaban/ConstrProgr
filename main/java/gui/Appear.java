package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import control.Executor;
import model.Block;

@SuppressWarnings("serial")
public class Appear extends JFrame implements ActionListener {
	ArrayList<Block> blocks = new ArrayList<>();
	
	String blockName;
	int blockTime;
	int blockNum;
	ArrayList<String> blockCons;

	int x = 110;
	JFrame frame;
	JPanel panel;
	JLabel mainLabel;
	JLabel name;
	JLabel time;
	JLabel consNum;
	JLabel cons;
	JTextField inputName;
	JTextField inputTime;
	JTextField inputNumCons;
	JTextField inputCons;
	JButton addBlock;
	JButton calc;
	JTextArea result;
	JTextField newName;
	JTextField newTime;
	JTextField newNumCons;
	ArrayList<JTextField> newCons;
	JLabel newNameLabel;
	JLabel newTimeLabel;
	JLabel newNumLabel;
	JLabel newConsLabel;

	public void init() {
		createFrame();

		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 254, 245));

		createLabels();
		createInputs();
		createButtons();
		createResult();
	}

	public void createFrame() {
		frame = new JFrame("Programming in Constraints");
		frame.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize);
	}

	public void createLabels() {
		mainLabel = new JLabel("Enter executing blocks: ");
		name = new JLabel("Name: ");
		time = new JLabel("Time: ");
		consNum = new JLabel("Constraint number: ");
		cons = new JLabel("Constraints: ");

		panel.add(mainLabel);
		panel.add(name);
		panel.add(time);
		panel.add(consNum);
		panel.add(cons);

		mainLabel.setBounds(75, 30, 150, 25);
		name.setBounds(75, 60, 150, 25);
		time.setBounds(75, 85, 150, 25);
		consNum.setBounds(75, 110, 150, 25);
		cons.setBounds(75, 135, 150, 25);
	}

	public void createInputs() {
		inputName = new JTextField();
		inputTime = new JTextField();
		inputNumCons = new JTextField();
		inputCons = new JTextField();

		panel.add(inputName);
		panel.add(inputTime);
		panel.add(inputNumCons);
		panel.add(inputCons);

		inputName.setBounds(230, 60, 150, 25);
		inputTime.setBounds(230, 85, 150, 25);
		inputNumCons.setBounds(230, 110, 150, 25);
		inputCons.setBounds(230, x += 25, 150, 25);
	}

	public void createButtons() {
		addBlock = new JButton("Add block");
		panel.add(addBlock);
		addBlock.setBounds(230, 30, 100, 25);
		addBlock.addActionListener(this);

		calc = new JButton("Calculate");
		panel.add(calc);
		calc.setBounds(850, 400, 100, 25);
	}

	public void createResult() {
		result = new JTextArea();
		panel.add(result);
		result.setEnabled(false);
		result.setBounds(500, 60, 800, 300);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		result.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	}

	public void createNewBlock() {
		int y = x + 40;

		newName = new JTextField();
		newTime = new JTextField();
		newNumCons = new JTextField();
		newCons = new ArrayList<>();
		newCons.add(new JTextField());

		panel.add(newName);
		panel.add(newTime);
		panel.add(newNumCons);
		for (int i = 0; i < newCons.size(); i++)
			panel.add(newCons.get(i));

		newName.setBounds(230, x += 40, 150, 25);
		newTime.setBounds(230, x += 25, 150, 25);
		newNumCons.setBounds(230, x += 25, 150, 25);

		for (int i = 0; i < newCons.size(); i++)
			newCons.get(i).setBounds(230, x += 25, 150, 25);

		newNameLabel = new JLabel();
		newTimeLabel = new JLabel();
		newNumLabel = new JLabel();
		newConsLabel = new JLabel();

		panel.add(newNameLabel);
		panel.add(newTimeLabel);
		panel.add(newNumLabel);

		for (int i = 0; i < newCons.size(); i++)
			panel.add(newCons.get(i));

		newNameLabel.setBounds(75, y, 150, 25);
		newTimeLabel.setBounds(75, y += 25, 150, 25);
		newNumLabel.setBounds(75, y += 25, 150, 25);
		newConsLabel.setBounds(75, y += 25, 150, 25);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addBlock)) {
			createNewBlock();
			String[] constraints;

			if (!inputName.getText().equals("") && !inputTime.getText().equals("") && !inputNumCons.getText().equals("")) {
				blockName = inputName.getText();
				blockTime = Integer.parseInt(inputTime.getText());
				blockNum = Integer.parseInt(inputNumCons.getText());
				blockCons = new ArrayList<>();
				constraints = inputCons.getText().split(", ");
				if (constraints.length != 0)
					for (int i = 0; i < constraints.length; i++)
						blockCons.add(constraints[i]);

				blocks.add(new Block(blockName, blockTime, blockNum, blockCons));
			}
		}
		
		if (e.getSource().equals(calc)) {
			Executor.getPath(blocks);
			
			for (Block i : blocks)
				result.setText(result.getText() + i + "\n");
			
			result.setText(result.getText() + Executor.getTimeResult() + " " + Executor.getResult());
			
			System.out.println(result.getText());
		}
	}
}
