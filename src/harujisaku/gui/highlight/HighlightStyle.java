package harujisaku.gui.highlight;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.StyleContext;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;

public abstract class HighlightStyle{
	public HighlightSet[] getHighLightSet(){
		HighlightSet[] highlightSet = new HighlightSet[1];
		highlightSet[0] = new HighlightSet(0,10,StyleContext.getDefaultStyleContext().addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,Color.RED));
		return highlightSet;
	}
	
	public void setText(String text){
		
	}
}