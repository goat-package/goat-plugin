package com.sysma.goat.eclipse_plugin.ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

@SuppressWarnings("all")
public class StreamCopier implements Runnable {
  private final InputStream from;
  
  private final OutputStream to;
  
  private final Map<String, ArrayList<Procedure0>> listeners = new HashMap<String, ArrayList<Procedure0>>();
  
  public StreamCopier(final InputStream from, final OutputStream to) {
    this.from = from;
    this.to = to;
  }
  
  public StreamCopier addListener(final String line, final Procedure0 todo) {
    StreamCopier _xblockexpression = null;
    {
      boolean _containsKey = this.listeners.containsKey(line);
      if (_containsKey) {
        this.listeners.get(line).add(todo);
      } else {
        this.listeners.put(line, CollectionLiterals.<Procedure0>newArrayList(todo));
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  public void run() {
    try {
      String line = "";
      int chr = 0;
      while (((chr = this.from.read()) != (-1))) {
        {
          this.to.write(chr);
          if ((chr == 10)) {
            this.to.flush();
            this.check(line);
            line = "";
          } else {
            String _line = line;
            line = (_line + Character.valueOf(((char) chr)));
          }
        }
      }
      this.to.flush();
      this.check(line);
      line = "";
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private ArrayList<Procedure0> check(final String line) {
    ArrayList<Procedure0> _xblockexpression = null;
    {
      ArrayList<Procedure0> _get = this.listeners.get(line);
      if (_get!=null) {
        final Consumer<Procedure0> _function = new Consumer<Procedure0>() {
          public void accept(final Procedure0 it) {
            it.apply();
          }
        };
        _get.forEach(_function);
      }
      _xblockexpression = this.listeners.remove(line);
    }
    return _xblockexpression;
  }
}
