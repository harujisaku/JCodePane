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
	public void keyTyped(KeyEvent e){
		autoCompleteEngin.keyTyped(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		autoCompleteEngin.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		autoCompleteEngin.keyReleased(e);
		System.out.println(autoCompleteEngin.canSuggest());
		if (autoCompleteEngin.getSuggest()==null) {
			return;
		}
		for (String a :autoCompleteEngin.getSuggest() ) {
			System.out.println(a);
		};
	}
}