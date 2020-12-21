package harujiskau.gui.highlight;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.StyleContext
import javax.swing.text.StyleConstants
import javax.swing.text.SimpleAttributeSet;


public class HighlightSet {
	public final int start,end;
	public final AttributeSet aset;
	public HighlightSet(int start,int end,AttributeSet aset){
		this.start=start;
		this.end=end;
		this.aset=aset;
	}
	
	public HighlightSet(){
		start=0;
		end=0;
		aset=StyleContext.getDefaultStyleContext().addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,Color.BLACK);
	}
}