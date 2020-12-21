package harujisaku.gui.autocomplete;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public abstract class AutoCompleteEngin implements KeyListener{
	StringBuffer word = new StringBuffer();
	SuggestString suggestString=null;
	public AutoCompleteEngin(){
		
	}
	
	public AutoCompleteEngin(SuggestString suggestString){
		this.suggestString=suggestString;
		List<String> wordList = suggestString.getList();
	}
	
	@Override
	public void keyTyped(KeyEvent e){
		
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		if (Character.isLetterOrDigit(e.getKeyChar())) {
			word.append(e.getKeyChar());
			return;
		}
		word.delete(0,word.length());
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		
	}
	
	public boolean canSuggest(){
		if (word.length()>=2) {
			return true;
		}
	}
	
	public String[] getSuggest(){
		String[] words=suggestString.searchOf(word.toString());
		if (words.length<1) {
			return {""};
		}
		return words;
	}
}