package RoadWorkPackage;

import javax.swing.*;
import java.awt.*;
/**
 * Lead Author(s):
 * @author Thomas Woods
 * @author Mateo Guerrero
 * 
 * Other contributors: N/A
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 1.0 4/17/2025
 * 
 * Responsibilities of class: Responsible for showing the search window to the user, collecting input, and displaying search results.
 */

public class RoadWorkerGUI extends JFrame {
    private JTextField searchField; // RoadWorkerGUI has-a searchField
    private JTextArea resultsArea; // RoadWorkerGUI has-a resultsArea
    private RoadWorkOrganizer organizer; // RoadWorker has-a organizer

    /**
     * Creates the Frame and sets a action listener to a button.
     * @param organizer
     */
    public RoadWorkerGUI(RoadWorkOrganizer organizer) 
    {
    	//Sets the title.
        super("Road Worker Search");
        this.organizer = organizer;
        setPreferredSize(new Dimension(600, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates the panel where the Results are stored.
        resultsArea = new JTextArea(15, 40);
        resultsArea.setEditable(false);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        //Creates the search Panel.
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Simple instructions
        JLabel instructions = new JLabel(
            "<html>Type in <b>ID</b> to search with ID<br>Type in <b>title</b> or part of the title to find what you are looking for, "
            + "Example: Water. ID Example: 3</html>"
        );
        instructions.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        searchPanel.add(instructions, BorderLayout.NORTH);
        
        //Creates the Search Field.
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(0, 30));
        searchField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        searchPanel.add(searchField, BorderLayout.CENTER);

        //Creates the Button and adds a action lisner to it.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton searchButton = new RoadWorkerButton();
        searchButton.addActionListener(e -> performSearch());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        buttonPanel.add(searchButton);
        searchPanel.add(buttonPanel, BorderLayout.SOUTH);

        //Adds the search panel to the frame.
        add(searchPanel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        searchField.addActionListener(e -> performSearch());
    }

    /**
     * Performs the search when and looks at the text in the search when someone clicks the button.
     */
    private void performSearch() 
    {
        String query = searchField.getText();
        String result = organizer.searchId(query);
        if (result == null || result.isEmpty()) 
        {
            // If not found by ID, search by title
            result = organizer.searchTitle(query);
        }
        if (result == null || result.isEmpty()) {
            resultsArea.setText("No matching results found.");
        } 
        else 
        {
            resultsArea.setText(result);
        }
    }
}