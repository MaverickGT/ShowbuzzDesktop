package View;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;



@SuppressWarnings("serial")
public class Browser extends JPanel
{
    private JEditorPane myEditor;
    public Browser(String url)
    {
	myEditor = new JEditorPane();
	myEditor.setEditable(false);
	myEditor.setEnabled(true);
	myEditor.addHyperlinkListener(new HyperlinkListener() {
	    public void hyperlinkUpdate(HyperlinkEvent e) {
	        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	            if(Desktop.isDesktopSupported()) {
	                try {
	                    Desktop.getDesktop().browse(e.getURL().toURI());
	                }
	                catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	    }
	}
	);
	showPage(url);
	initGui();
    }
    
    private void initGui()
    {
	
	
	this.add(myEditor,    BorderLayout.CENTER);
    }

    public void showPage(String url)
    {
	try {
	    myEditor.setPage(url);    
	}
	catch (Exception e) {
	    myEditor.setContentType("text/html");
	    myEditor.setText("<html>Could not load "+url+"</html>");
	}
    }

    public static void main(String args[])
    {
	Browser b = new Browser("http://localhost/PHP%20Projects/news.html");
	b.setSize(600,600);
	b.setLocation(10,20);
	b.setVisible(true);
    }
}
