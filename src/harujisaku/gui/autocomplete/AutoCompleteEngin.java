package harujisaku.gui.autocomplete;

import harujisaku.text.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.JTextComponent;
import javax.swing.text.BadLocationException;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * 自動補完文字列を作成するエンジン
 */

public abstract class AutoCompleteEngin implements KeyListener{
	StringBuffer word = new StringBuffer();
	SuggestString suggestString=null;
	List<String> wordList;
	JTextComponent textpane;
	/**
	 * デフォルトコンストラクタ
	 */

	public AutoCompleteEngin(){

	}
	/**
	 * 自動補完文字列を定義するクラスを設定できるコンストラクタ
	 * @param suggestString 自動補完文字列を定義するコンストラクタ
	 */
	public AutoCompleteEngin(SuggestString suggestString,JTextComponent textpane){
		this.suggestString=suggestString;
		this.textpane=textpane;
		wordList = suggestString.getList();
	}

	@Override
	public void keyTyped(KeyEvent e){

	}

	@Override
	public void keyPressed(KeyEvent e){
		if (Character.isLetterOrDigit(e.getKeyChar())) {
			if (word.length()==0) {
				word.append(Util.getWord(textpane.getText(),textpane.getCaretPosition()-1));
			}
			word.append(e.getKeyChar());
			return;
		}
		if (e.getKeyChar()!='\n'&&canSuggest()) {
			word.delete(0,word.length());
		}
	}

	@Override
	public void keyReleased(KeyEvent e){
	}
	/**
	 * 自動補完が可能かを返す
	 * @return 自動補完が可能な文字列の長さに達していたらtrue
	 */
	public boolean canSuggest(){
		if (word.length()>=2) {
			return true;
		}
		return false;
	}
	/**
	 * 自動補完文字列の文字列型配列を返す
	 * @return 自動補完文字列の文字列型配列を返します。該当する文字列がない場合はnullが返されます。
	 */
	public String[] getSuggest(){
		String[] words=suggestString.searchOf(word.toString());
		if (words.length<1) {
			return null;
		}
		return words;
	}

	public boolean suggest(int index){
		int position = textpane.getCaretPosition();
		String suggestString = getSuggest()[index];
		try {
			textpane.getDocument().insertString(position,suggestString.substring(Math.min(word.length(),suggestString.length())),null);
			word.delete(0,word.length());
		} catch(BadLocationException e) {
			e.printStackTrace();
		}
		return true;
	}
}
