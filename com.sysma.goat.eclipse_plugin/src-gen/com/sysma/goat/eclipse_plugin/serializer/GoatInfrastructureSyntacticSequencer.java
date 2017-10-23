/*
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.serializer;

import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.services.GoatInfrastructureGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class GoatInfrastructureSyntacticSequencer extends AbstractSyntacticSequencer {

	protected GoatInfrastructureGrammarAccess grammarAccess;
	protected AbstractElementAlias match_SingleServer_RightCurlyBracketKeyword_1_1_a;
	protected AbstractElementAlias match_SingleServer_RightCurlyBracketKeyword_1_1_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (GoatInfrastructureGrammarAccess) access;
		match_SingleServer_RightCurlyBracketKeyword_1_1_a = new TokenAlias(true, true, grammarAccess.getSingleServerAccess().getRightCurlyBracketKeyword_1_1());
		match_SingleServer_RightCurlyBracketKeyword_1_1_p = new TokenAlias(true, false, grammarAccess.getSingleServerAccess().getRightCurlyBracketKeyword_1_1());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_SingleServer_RightCurlyBracketKeyword_1_1_a.equals(syntax))
				emit_SingleServer_RightCurlyBracketKeyword_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SingleServer_RightCurlyBracketKeyword_1_1_p.equals(syntax))
				emit_SingleServer_RightCurlyBracketKeyword_1_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '}'*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'singleserver' name=ID
	 *     (rule start) (ambiguity) 'timeout' ':' timeout=INT
	 *     server=STRING (ambiguity) 'singleserver' name=ID
	 *     server=STRING (ambiguity) 'timeout' ':' timeout=INT
	 *     server=STRING (ambiguity) (rule end)
	 */
	protected void emit_SingleServer_RightCurlyBracketKeyword_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '}'+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 *     timeout=INT (ambiguity) 'singleserver' name=ID
	 *     timeout=INT (ambiguity) 'timeout' ':' timeout=INT
	 *     timeout=INT (ambiguity) (rule end)
	 */
	protected void emit_SingleServer_RightCurlyBracketKeyword_1_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}