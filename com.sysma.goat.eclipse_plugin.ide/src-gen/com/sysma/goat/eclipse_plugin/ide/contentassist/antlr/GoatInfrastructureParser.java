/*
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.ide.contentassist.antlr.internal.InternalGoatInfrastructureParser;
import com.sysma.goat.eclipse_plugin.services.GoatInfrastructureGrammarAccess;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class GoatInfrastructureParser extends AbstractContentAssistParser {

	@Inject
	private GoatInfrastructureGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalGoatInfrastructureParser createParser() {
		InternalGoatInfrastructureParser result = new InternalGoatInfrastructureParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getInfrastructureAccess().getAlternatives(), "rule__Infrastructure__Alternatives");
					put(grammarAccess.getSingleServerAccess().getGroup_0(), "rule__SingleServer__Group_0__0");
					put(grammarAccess.getSingleServerAccess().getGroup_0_3(), "rule__SingleServer__Group_0_3__0");
					put(grammarAccess.getSingleServerAccess().getGroup_1(), "rule__SingleServer__Group_1__0");
					put(grammarAccess.getSingleServerAccess().getGroup_1_0(), "rule__SingleServer__Group_1_0__0");
					put(grammarAccess.getClusterAccess().getGroup_0(), "rule__Cluster__Group_0__0");
					put(grammarAccess.getClusterAccess().getGroup_0_3(), "rule__Cluster__Group_0_3__0");
					put(grammarAccess.getClusterAccess().getGroup_1(), "rule__Cluster__Group_1__0");
					put(grammarAccess.getClusterAccess().getGroup_2(), "rule__Cluster__Group_2__0");
					put(grammarAccess.getClusterAccess().getGroup_3(), "rule__Cluster__Group_3__0");
					put(grammarAccess.getClusterAccess().getGroup_3_0(), "rule__Cluster__Group_3_0__0");
					put(grammarAccess.getClusterAccess().getGroup_3_0_4(), "rule__Cluster__Group_3_0_4__0");
					put(grammarAccess.getRingAccess().getGroup_0(), "rule__Ring__Group_0__0");
					put(grammarAccess.getRingAccess().getGroup_0_3(), "rule__Ring__Group_0_3__0");
					put(grammarAccess.getRingAccess().getGroup_1(), "rule__Ring__Group_1__0");
					put(grammarAccess.getRingAccess().getGroup_2(), "rule__Ring__Group_2__0");
					put(grammarAccess.getRingAccess().getGroup_2_0(), "rule__Ring__Group_2_0__0");
					put(grammarAccess.getRingAccess().getGroup_2_0_4(), "rule__Ring__Group_2_0_4__0");
					put(grammarAccess.getTreeAccess().getGroup_0(), "rule__Tree__Group_0__0");
					put(grammarAccess.getTreeAccess().getGroup_0_3(), "rule__Tree__Group_0_3__0");
					put(grammarAccess.getTreeAccess().getGroup_1(), "rule__Tree__Group_1__0");
					put(grammarAccess.getTreeAccess().getGroup_1_0(), "rule__Tree__Group_1_0__0");
					put(grammarAccess.getTreeNodeAccess().getGroup(), "rule__TreeNode__Group__0");
					put(grammarAccess.getTreeNodeAccess().getGroup_1(), "rule__TreeNode__Group_1__0");
					put(grammarAccess.getTreeNodeAccess().getGroup_1_2(), "rule__TreeNode__Group_1_2__0");
					put(grammarAccess.getSingleServerAccess().getNameAssignment_0_1(), "rule__SingleServer__NameAssignment_0_1");
					put(grammarAccess.getSingleServerAccess().getServerAssignment_0_3_2(), "rule__SingleServer__ServerAssignment_0_3_2");
					put(grammarAccess.getSingleServerAccess().getTimeoutAssignment_1_0_2(), "rule__SingleServer__TimeoutAssignment_1_0_2");
					put(grammarAccess.getClusterAccess().getNameAssignment_0_1(), "rule__Cluster__NameAssignment_0_1");
					put(grammarAccess.getClusterAccess().getMessage_queueAssignment_0_3_2(), "rule__Cluster__Message_queueAssignment_0_3_2");
					put(grammarAccess.getClusterAccess().getRegistrationAssignment_1_2(), "rule__Cluster__RegistrationAssignment_1_2");
					put(grammarAccess.getClusterAccess().getMid_assignerAssignment_2_2(), "rule__Cluster__Mid_assignerAssignment_2_2");
					put(grammarAccess.getClusterAccess().getNodesAssignment_3_0_3(), "rule__Cluster__NodesAssignment_3_0_3");
					put(grammarAccess.getClusterAccess().getNodesAssignment_3_0_4_1(), "rule__Cluster__NodesAssignment_3_0_4_1");
					put(grammarAccess.getRingAccess().getNameAssignment_0_1(), "rule__Ring__NameAssignment_0_1");
					put(grammarAccess.getRingAccess().getRegistrationAssignment_0_3_2(), "rule__Ring__RegistrationAssignment_0_3_2");
					put(grammarAccess.getRingAccess().getMid_assignerAssignment_1_2(), "rule__Ring__Mid_assignerAssignment_1_2");
					put(grammarAccess.getRingAccess().getNodesAssignment_2_0_3(), "rule__Ring__NodesAssignment_2_0_3");
					put(grammarAccess.getRingAccess().getNodesAssignment_2_0_4_1(), "rule__Ring__NodesAssignment_2_0_4_1");
					put(grammarAccess.getTreeAccess().getNameAssignment_0_1(), "rule__Tree__NameAssignment_0_1");
					put(grammarAccess.getTreeAccess().getRegistrationAssignment_0_3_2(), "rule__Tree__RegistrationAssignment_0_3_2");
					put(grammarAccess.getTreeAccess().getRootAssignment_1_0_2(), "rule__Tree__RootAssignment_1_0_2");
					put(grammarAccess.getTreeNodeAccess().getAddressAssignment_0(), "rule__TreeNode__AddressAssignment_0");
					put(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1(), "rule__TreeNode__ChildrenAssignment_1_1");
					put(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_2_1(), "rule__TreeNode__ChildrenAssignment_1_2_1");
					put(grammarAccess.getSingleServerAccess().getUnorderedGroup(), "rule__SingleServer__UnorderedGroup");
					put(grammarAccess.getClusterAccess().getUnorderedGroup(), "rule__Cluster__UnorderedGroup");
					put(grammarAccess.getRingAccess().getUnorderedGroup(), "rule__Ring__UnorderedGroup");
					put(grammarAccess.getTreeAccess().getUnorderedGroup(), "rule__Tree__UnorderedGroup");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public GoatInfrastructureGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(GoatInfrastructureGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
