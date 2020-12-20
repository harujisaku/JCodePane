package harujisaku.minicode.gui;

import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;

import harujisaku.gui.highlight.*;
import harujisaku.gui.autocomplete.*;

public class JCodePane extends JTextPane{
	public JCodePane(){
		super();
		
	}
	
	public JCodePane(StyledDocument doc){
		super(doc);
	}
	
	public void setHighlight(HighlightStyle style){
		
	}
	
	public void setAutoComplete(AutoCompleteEngin autoComplete){
		
	}
}