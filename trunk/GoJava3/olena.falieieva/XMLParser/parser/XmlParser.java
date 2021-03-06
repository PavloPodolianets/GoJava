package ua.goit.alg.parser;

import java.io.File;
import java.io.IOException;
//import java.util.logging.Handler;

import ua.goit.alg.parser.StateMachine.State;

/**
 * Created by kossovec on 09.04.15.
 */
public interface XmlParser {
 
  public void parse(String xml) throws IOException;

  public void parse(File file) throws IOException;

  public void onOpenTag(Handler handler);

  public void onCloseTag(Handler handler);

  public void onTextValue(Handler handler);

  public void onStart(Handler handler);

  public void onEnd(Handler handler);

  public void onError(Handler handler);

  public void handle(State state, Tag tag);
  
  
 
}