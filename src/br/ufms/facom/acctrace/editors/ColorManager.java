package br.ufms.facom.acctrace.editors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * The Class ColorManager.
 */
public class ColorManager {

	/** The color table. */
	protected Map<RGB, Color> fColorTable = new HashMap<RGB, Color>(10);

	/**
	 * Dispose.
	 */
	public void dispose() {
		Iterator<Color> e = fColorTable.values().iterator();
		while (e.hasNext())
			((Color) e.next()).dispose();
	}

	/**
	 * Gets the color.
	 * 
	 * @param rgb
	 *            the rgb
	 * @return the color
	 */
	public Color getColor(RGB rgb) {
		Color color = (Color) fColorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			fColorTable.put(rgb, color);
		}
		return color;
	}
}
