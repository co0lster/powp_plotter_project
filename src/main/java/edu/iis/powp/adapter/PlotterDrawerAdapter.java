package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

import javax.swing.*;

public class PlotterDrawerAdapter extends DrawPanelController implements IPlotter
{ 
	private int startX = 0, startY = 0;
	DrawPanelController drawPanel;
	
    public PlotterDrawerAdapter(DrawPanelController drawPanel) {
		super();
		this.drawPanel = drawPanel;
	}

	@Override
    public void setPosition(int x, int y)
    {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void drawTo(int x, int y)
    {
        ILine line = LineFactory.getBasicLine();
    	line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
		setPosition(x,y);
		drawPanel.drawLine(line);
    }

    @Override
    public String toString()
    {
        return "Plotter Demo";
    }


}
