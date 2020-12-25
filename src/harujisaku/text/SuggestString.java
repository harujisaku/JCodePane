package harujisaku.text;

import java.util.List;
import java.util.ArrayList;

public class SuggestString{
	List<String> list;
	public SuggestString(List<String> list){
		this.list=list;
	}
	
	public String[] searchOf(String text){
		List<String> words = new ArrayList<String>();
		for (String word :list.toArray(new String[list.size()]) ) {
			if (word.startsWith(text)) {
				words.add(word);
			}
		}
		return words.toArray(new String[words.size()]);
	}
	
	public String[] searchOf(StringSearchEngin searchEngin,String text){
		List<String> words = new ArrayList<String>();
		for (String word :list.toArray(new String[list.size()]) ) {
			if (searchEngin.search(word,text)) {
				words.add(word);
			}
		}
		return words.toArray(new String[words.size()]);
	}
	
	public List<String> getList(){
		return list;
	}
}