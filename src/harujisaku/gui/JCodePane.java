package harujisaku.gui;

import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;

import harujisaku.gui.highlight.*;
import harujisaku.gui.autocomplete.*;

public class JCodePane extends JTextPane{
	
	HighlightStyle style;
	AutoComplete autoComplete;
	public JCodePane(){
		super();
	}
	
	public JCodePane(StyledDocument doc){
		super(doc);
	}
	
	public void setHighlight(HighlightStyle style){
		this.style=style;
	}
	
	public void setAutoComplete(AutoComplete autoComplete){
		this.autoComplete=autoComplete;
		addKeyListener(autoComplete);
	}
	
	public void highlight(){
		HighlightSet[] highlightSets = style.getHighLightSet();
		for (HighlightSet highlightSet :highlightSets ) {
			getStyledDocument().setCharacterAttributes(highlightSet.start,highlightSet.end-highlightSet.start,highlightSet.aset,true);
		}
	}
}