package com.splogad.myapp.util;

import java.util.Locale;

import javax.xml.transform.Source;

import org.eclipse.jdt.internal.compiler.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import antlr.debug.MessageEvent;

@Component
public class messageUtil {

	private static MessageSource source;
	
	@Autowired
	public messageUtil(MessageSource source){
		this.source = source;
	}
	
	public static void flash(RedirectAttributes att, String kind, String message){
		att.addFlashAttribute("flashKind",kind);
		att.addFlashAttribute("flashMessage",getMessage(message));
	}
	
	private static String getMessage(String key, Object...arg1){
		return source.getMessage(key, arg1,Locale.getDefault()); 
	}
	
}
