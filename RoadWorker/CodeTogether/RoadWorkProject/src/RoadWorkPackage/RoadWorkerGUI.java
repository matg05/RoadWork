package RoadWorkPackage;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * Lead Author(s): Thomas Woods
 * @author 
 * @author 
 * 
 * Other contributors: N/A
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 1.0 4/17/2025
 * 
 * Responsibilities of class: Class that creates the GUI page.
 * 
 */
public class RoadWorkerGUI extends JFrame
{
	public RoadWorkerGUI()
	{
		JFrame rwPanel = new JFrame();
		rwPanel.setPreferredSize(new Dimension(200,200));
		
		JPanel Sliders = new JPanel();
		JPanel Sliders2 = new JPanel();
		
		//Adds Button
		JButton RWButton = new RoadWorkerButton();
		JTextField RWSearch = new JTextField();
		
		RWSearch.setPreferredSize(new Dimension(100,30));
		
		Sliders.add(RWButton);
		Sliders2.add(RWSearch);
		this.add(Sliders, BorderLayout.SOUTH);
		this.add(Sliders2, BorderLayout.SOUTH);
		//add(RWButton);
		
		
		
		setName("Gone Fishing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
