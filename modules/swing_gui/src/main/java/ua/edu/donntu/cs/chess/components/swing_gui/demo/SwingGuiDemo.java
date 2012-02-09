/*
 * BoardDemo.java
 */

package ua.edu.donntu.cs.chess.components.swing_gui.demo;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.edu.donntu.cs.chess.components.swing_gui.Constants;
import ua.edu.donntu.cs.chess.components.swing_gui.impl.SimpleBoardController;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class SwingGuiDemo
	implements Constants
{
	public static void main(String[] args)
	{
		LOG.info(SwingGuiDemo.class.getSimpleName());

		final SimpleBoardController boardController = new SimpleBoardController();

		final JFrame boardFrame = new JFrame("BoardDemo");

		final JPanel contentPanel = new JPanel(new BorderLayout(5, 5));
		contentPanel.add((Component)boardController.getBoardView(), BorderLayout.CENTER);
		boardFrame.setContentPane(contentPanel);
		boardFrame.pack();

		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boardFrame.setVisible(true);
	}
}
