package harujisaku.gui.highlight;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.StyleContext;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;

/**
 * シンタックスハイライトの範囲とAttributeSetを定義するクラス
 */
public class HighlightSet {
	/**
	 * 始点、終点
	 */
	public final int start,end;
	/**
	 * 設定するAttributeSet
	 */
	public final AttributeSet aset;
	/**
	 * デフォルトコンストラクタ.
	 * 範囲とAttributeSetを指定するコンストラクタ
	 * @param start 始点index
	 * @param end   終点index
	 * @param aset  指定するAttributeSet
	 */
	public HighlightSet(int start,int end,AttributeSet aset){
		this.start=start;
		this.end=end;
		this.aset=aset;
	}
	/**
	 * 空のセットを作るコンストラクタ
	 */
	public HighlightSet(){
		start=0;
		end=0;
		aset=StyleContext.getDefaultStyleContext().addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,Color.BLACK);
	}
}