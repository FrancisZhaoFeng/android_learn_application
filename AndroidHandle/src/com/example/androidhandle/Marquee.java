package com.example.androidhandle;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class Marquee extends TextView {

	  public Marquee(Context context, AttributeSet attrs){  
	        super(context, attrs);  
	    }
	
    @Override  
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect){  
        if(focused) {
        	super.onFocusChanged(focused, direction, previouslyFocusedRect);  
        }
    }  
      
    @Override  
    public void onWindowFocusChanged(boolean hasWindowFocus){  
        if(hasWindowFocus){
        	super.onWindowFocusChanged(hasWindowFocus);  
        }
    } 
	
	@Override
	public boolean isFocused() {
		// TODO Auto-generated method stub
		return true;
	}

}
