/*
 * SimpleBoardRenderer.java
 */

package ua.edu.donntu.cs.chess.components.board.impl;

import java.awt.*;
import java.awt.Color;
import java.io.Console;

import ua.edu.donntu.cs.chess.components.board.BoardRenderer;
import ua.edu.donntu.cs.chess.components.board.Constants;
import ua.edu.donntu.cs.chess.components.generic.chess.*;
import ua.edu.donntu.cs.chess.components.generic.chess.impl.StandardArea;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class SimpleBoardRenderer
	implements BoardRenderer, Constants
{
// BoardRenderer Implementation ----------------------------------------------------------------------------------------

	public void renderBoard(Component component, Graphics2D g, Board board)
	{
		final Dimension size = component.getSize();

		//int areaWidth = (int) (size.getWidth() / board.getWidth());
		//int areaHeight = (int) (size.getHeight() / board.getHeight());
		final Color blackColor = new Color(0x4F, 0x4F, 0xAF);
		final Color whiteColor = new Color(0xAF, 0xAF, 0xFF);
		int x, y;
		for (x = 0; x < board.getWidth(); x++)
		{
			for (y = 0; y < board.getHeight(); y++)
			{
				final Area area = board.getAreaAt(x, y);
				LOG.info("Rendering area: position=" + area.getPosition() + ", area=" + area);
				if (area.getColor() == ua.edu.donntu.cs.chess.components.generic.chess.Color.BLACK)
					g.setColor(whiteColor);
				else
					g.setColor(blackColor);
				int areaWidth = (int) (size.getWidth() / board.getWidth());
				int areaHeight = (int) (size.getHeight() / board.getHeight());
				g.fillRect(x * areaWidth, y * areaHeight, areaWidth, areaHeight);

				g.setColor(new Color(0x00, 0xFF, 0x00));
				g.drawString(area.getPosition().getXLabel(), (x + 1) * areaWidth - board.getWidth(), board.getHeight() * areaHeight - 1);
				g.drawString(area.getPosition().getYLabel(), 0, y * areaHeight + board.getHeight() + 5);

				//g.drawString(area.getPosition().getXLabel().toString(),(x+1)*areaWidth-board.getWidth(),board.getHeight()*areaHeight);
				//g.drawString(String.valueOf(board.getHeight()-area.getPosition().getY()),0,y*areaHeight+(int)1.95*board.getHeight());
				Piece piece = area.getPiece();
				if (piece != null)
				{
					String path = ((RenderablePiece) piece).getPath();
					//  Image image = new

					//  нарисовать на доске фигуры в дефолтной расстановке
					//g.drawImage();
				}
			}
		}
		g.setColor(new Color(0x00, 0x00, 0x00));
		g.drawRect(0, 0, (int)size.getWidth() - 1, (int)size.getHeight() - 1);

	}

	public void renderPieceSet(Component component, Graphics2D g, Board board, Area area, Piece piece)
	{
		// TODO: Implement the method
		throw new UnsupportedOperationException("Still not implemented");
	}

	public void renderPieceMove(Component component, Graphics2D g, Board board, Area from, Area to, Piece movedPiece, Piece takenPiece, Area castlingFrom, Area castlingTo, Piece castlingPiece, Piece promotionPiece)
	{
		// TODO: Implement the method
		throw new UnsupportedOperationException("Still not implemented");
	}
}
