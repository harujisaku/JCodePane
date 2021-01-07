package harujisaku.gui.autocomplete;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.*;


/**
 * 自動補完をするクラス
 */
public class AutoComplete implements KeyListener,MouseListener{
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
		autoCompletePanel.getJList().addMouseListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e){
		autoCompleteEngin.keyTyped(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		autoCompleteEngin.keyPressed(e);
		if (e.getKeyChar()=='\n'&&autoCompleteEngin.canSuggest()) {
			e.consume();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		autoCompleteEngin.keyReleased(e);
		System.out.println(autoCompleteEngin.canSuggest());
		if (autoCompleteEngin.getSuggest()==null) {
			autoCompletePanel.hide();
			return;
		}
		if (autoCompleteEngin.canSuggest()) {
			if (e.getKeyChar()=='\n') {
				autoCompleteEngin.suggest(0);
				autoCompletePanel.hide();
				e.consume();
				return;
			}
			autoCompletePanel.show(autoCompleteEngin.getSuggest());
		}else{
			autoCompletePanel.hide();
		}
		for (String a :autoCompleteEngin.getSuggest() ) {
			System.out.println(a);
		};
	}

	
	@Override
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount()==2) {
			autoCompleteEngin.suggest(autoCompletePanel.getSelectedIndex());
			autoCompletePanel.hide();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
}