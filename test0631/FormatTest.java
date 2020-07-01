package test0631;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

public class FormatTest {
	public static void main(String[] args) {
	
	String pattern = "60#D|70#C|80#B|90#A";
	int [] score = {91,90,80,88,70,52,60};
	
	ChoiceFormat form = new ChoiceFormat(pattern);
	for(int i=0; i<score.length; i++) {
		System.out.println(score[i]+":"+form.format(score[i]));
		}
	
	String msg = "Name:{0}\n Tel:{1}\n Age:{2}\n Birthday:{3}";
	Object [] arguments = {
			"이자바","02-123-1234","27","07-09"
	};
	String result = MessageFormat.format(msg, arguments);
	System.out.println(result);
	}
}
