package com.placamas.vista;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;
import javax.swing.text.Segment;

class LimiteJTextField extends PlainDocument {
	private int limite;
	
	public LimiteJTextField(int i){
		super();//lamando a la super clase
		this.limite=i;
	}
	
	public void insertString(int compensacion, String str,AttributeSet attr)throws BadLocationException{
		if (str == null)return;//no hacer nada y terminar
		if((getLength()+ str.length()) <=limite ){
			//se envia el String
			super.insertString(compensacion, str , attr);
		}
		
	} 
	
	
	

	
	

}
