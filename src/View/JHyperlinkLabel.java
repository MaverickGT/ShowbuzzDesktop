package View;

import java.awt.Color;
import java.awt.Cursor;

import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JLabel;

public class JHyperlinkLabel extends JLabel {

	private static final long serialVersionUID = 1L;
private Color underlineColor = null;

  public JHyperlinkLabel(String label) {
    super(label);

    setForeground(Color.BLUE.darker());
    setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(underlineColor == null ? getForeground() : underlineColor);

    Insets insets = getInsets();

    int left = insets.left;
    if (getIcon() != null)
      left += getIcon().getIconWidth() + getIconTextGap();

    g.drawLine(left, getHeight() - 1 - insets.bottom, (int) getPreferredSize().getWidth()
        - insets.right, getHeight() - 1 - insets.bottom);
  }



  public Color getUnderlineColor() {
    return underlineColor;
  }

  public void setUnderlineColor(Color underlineColor) {
    this.underlineColor = underlineColor;
  }
}
