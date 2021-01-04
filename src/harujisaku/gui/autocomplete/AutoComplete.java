package harujisaku.gui.autocomplete;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.*;


/**
 * 自動補完をするクラス
 */
public class AutoComplete implements KeyListener{
	AutoCompleteEngin autoCompleteEngin;
	AutoCompletePanel autoCompletePanel;
	/**
	 * デフォルトコンストラクタ
	 * @param autoCompleteEngin 自動補完文字列を作成するエンジン
	 * @param autoCompletePanel 自動補完文字列を表示するパネル
	 */
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
		if (autoCompleteEngin.canSuggest()) {
			autoCompletePanel.show(Arrays.asList(autoCompleteEngin.getSuggest()));
		}
		for (String a :autoCompleteEngin.getSuggest() ) {
			System.out.println(a);
		};
	}
}