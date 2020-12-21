package harujisaku.gui.autocomplete;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AutoComplete implements KeyListener{
	AutoCompleteEngin autoCompleteEngin;
	AutoCompletePanel autoCompletePanel;
	public AutoComplete(AutoCompleteEngin autoCompleteEngin,AutoCompletePanel autoCompletePanel){
		this.autoCompleteEngin=autoCompleteEngin;
		this.autoCompletePanel=autoCompletePanel;
	}
	
	@Override
	public keyTyped(KeyEvent e){
		
	}
	
	@Override
	public keyPressed(KeyEvent e){
		
	}
	
	@Override
	public keyReleased(KeyEvent e){
		
	}
}