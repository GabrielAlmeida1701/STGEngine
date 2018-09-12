package STG.Utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Stroke;

public class EditorDefaults {

	public final static Font defaultEditor_font = new Font("Arial", Font.PLAIN, 10);
	
	public final static Color defaultEditor = new Color(200,200,200);
	public final static Color defaultEditor_Bnt = new Color(170,170,170);
	public final static Color selectEditor_Bnt = new Color(74,161,190);
	public final static Color selectObjGameView = new Color(0, 255, 0);
	
	public final static Stroke gameViewStroke = new BasicStroke(3);
	public final static Stroke defaultEditorStroke = new BasicStroke(1);
	
	public final static Cursor cursor_hand = new Cursor(Cursor.HAND_CURSOR);
	public final static Cursor cursor_default = new Cursor(Cursor.DEFAULT_CURSOR);
}
