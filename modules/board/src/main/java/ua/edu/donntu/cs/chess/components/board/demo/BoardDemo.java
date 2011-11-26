/*
 * BoardDemo.java
 */

package ua.edu.donntu.cs.chess.components.board.demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.edu.donntu.cs.chess.components.board.Constants;
import ua.edu.donntu.cs.chess.components.board.impl.SimpleBoardController;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class BoardDemo
	implements Constants
{
	public static void main(String[] args)
	{
		LOG.info(BoardDemo.class.getSimpleName());

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
