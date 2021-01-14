package harujisaku.gui.highlight;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.StyleContext;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;
/**
 * シンタックスハイライトを設定するクラス.
 * <br>
 * 言語によってシンタックスハイライトを設定する時に使います。
 */
public abstract class HighlightStyle{
	/**
	 * ハイライトを取得する
	 * @return 設定されたハイライトのHighlightSet
	 */
	public HighlightSet[] getHighLightSet(){
		HighlightSet[] highlightSet = new HighlightSet[1];
		highlightSet[0] = new HighlightSet(0,10,StyleContext.getDefaultStyleContext().addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,Color.BLACK));
		return highlightSet;
	}
	/**
	 * テキストを指定
	 * @param text ハイライトを設定するもととなる文字を指定します。
	 */
	public void setText(String text){

	}

	public HighlightSet[] getHighLightSet(int start,int end){
		HighlightSet[] highlightSet = new HighlightSet[1];
		highlightSet[0] = new HighlightSet(start,end,StyleContext.getDefaultStyleContext().addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,Color.BLACK));
		return highlightSet;
	}
}
