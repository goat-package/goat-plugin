package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeInfrastructure;
import com.sysma.goat.eclipse_plugin.generator.Utils;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CodeTree implements CodeInfrastructure {
  private final Tree tree;
  
  public CodeTree(final Tree tree) {
    this.tree = tree;
  }
  
  private static List<String> makePlainList(final TreeNode node) {
    final Function1<TreeNode, String> _function = (TreeNode it) -> {
      return it.getAddress();
    };
    return ListExtensions.<TreeNode, String>map(CodeTree.nodesList(node), _function);
  }
  
  private static TreeNode parentNode(final TreeNode node) {
    TreeNode _xifexpression = null;
    EObject _eContainer = node.eContainer();
    if ((_eContainer instanceof TreeNode)) {
      EObject _eContainer_1 = node.eContainer();
      _xifexpression = ((TreeNode) _eContainer_1);
    } else {
      _xifexpression = ((TreeNode) null);
    }
    return _xifexpression;
  }
  
  private static List<TreeNode> nodesList(final TreeNode node) {
    ArrayList<TreeNode> _xblockexpression = null;
    {
      final ArrayList<TreeNode> out = CollectionLiterals.<TreeNode>newArrayList(node);
      final Function1<TreeNode, List<TreeNode>> _function = (TreeNode it) -> {
        return CodeTree.nodesList(it);
      };
      final Consumer<List<TreeNode>> _function_1 = (List<TreeNode> it) -> {
        out.addAll(it);
      };
      ListExtensions.<TreeNode, List<TreeNode>>map(node.getChildren(), _function).forEach(_function_1);
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getCode() {
    String _xblockexpression = null;
    {
      final boolean mustWait = (Utils.isLocalAddress(this.tree.getRegistration()) || 
        (!IterableExtensions.isEmpty(IterableExtensions.<TreeNode>filter(CodeTree.nodesList(this.tree.getRoot()), ((Function1<TreeNode, Boolean>) (TreeNode it) -> {
          return Boolean.valueOf(Utils.isLocalAddress(it.getAddress()));
        })))));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package main");
      _builder.newLine();
      _builder.append("import (");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _importPath = Utils.getImportPath();
      _builder.append(_importPath, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("\"fmt\"");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.newLine();
      _builder.append("func main(){");
      _builder.newLine();
      {
        boolean _isLocalAddress = Utils.isLocalAddress(this.tree.getRegistration());
        if (_isLocalAddress) {
          _builder.append("\t");
          _builder.append("go goat.NewTreeAgentRegistration(");
          int _portNumber = Utils.getPortNumber(this.tree.getRegistration());
          _builder.append(_portNumber, "\t");
          _builder.append(", ");
          CharSequence _goList = Utils.goList(CodeTree.makePlainList(this.tree.getRoot()));
          _builder.append(_goList, "\t");
          _builder.append(").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        final Function1<TreeNode, Boolean> _function = (TreeNode it) -> {
          return Boolean.valueOf(Utils.isLocalAddress(it.getAddress()));
        };
        Iterable<TreeNode> _filter = IterableExtensions.<TreeNode>filter(CodeTree.nodesList(this.tree.getRoot()), _function);
        for(final TreeNode node : _filter) {
          _builder.append("\t");
          _builder.append("go goat.NewTreeNode(");
          int _portNumber_1 = Utils.getPortNumber(node.getAddress());
          _builder.append(_portNumber_1, "\t");
          _builder.append(", \"");
          String _elvis = null;
          TreeNode _parentNode = CodeTree.parentNode(node);
          String _address = null;
          if (_parentNode!=null) {
            _address=_parentNode.getAddress();
          }
          if (_address != null) {
            _elvis = _address;
          } else {
            _elvis = "";
          }
          _builder.append(_elvis, "\t");
          _builder.append("\", ");
          final Function1<TreeNode, String> _function_1 = (TreeNode it) -> {
            return it.getAddress();
          };
          CharSequence _goList_1 = Utils.goList(ListExtensions.<TreeNode, String>map(node.getChildren(), _function_1));
          _builder.append(_goList_1, "\t");
          _builder.append(").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("fmt.Println(\"Started\")");
      _builder.newLine();
      {
        if (mustWait) {
          _builder.append("\t");
          _builder.append("<- make(chan bool)");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("_ = goat.NewClusterCounter");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
