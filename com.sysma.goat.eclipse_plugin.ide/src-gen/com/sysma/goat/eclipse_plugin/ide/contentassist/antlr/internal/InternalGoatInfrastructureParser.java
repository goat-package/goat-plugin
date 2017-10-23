package com.sysma.goat.eclipse_plugin.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import com.sysma.goat.eclipse_plugin.services.GoatInfrastructureGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGoatInfrastructureParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Message_queue", "Mid_assigner", "Registration", "Singleserver", "Cluster", "Timeout", "Server", "Nodes", "Ring", "Tree", "Comma", "Colon", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Server=10;
    public static final int RULE_STRING=22;
    public static final int RULE_SL_COMMENT=24;
    public static final int Comma=14;
    public static final int Mid_assigner=5;
    public static final int Registration=6;
    public static final int Message_queue=4;
    public static final int Tree=13;
    public static final int Colon=15;
    public static final int RightCurlyBracket=19;
    public static final int EOF=-1;
    public static final int RightSquareBracket=17;
    public static final int RULE_ID=20;
    public static final int RULE_WS=25;
    public static final int Timeout=9;
    public static final int LeftCurlyBracket=18;
    public static final int Cluster=8;
    public static final int RULE_ANY_OTHER=26;
    public static final int Nodes=11;
    public static final int Ring=12;
    public static final int RULE_INT=21;
    public static final int Singleserver=7;
    public static final int RULE_ML_COMMENT=23;
    public static final int LeftSquareBracket=16;

    // delegates
    // delegators


        public InternalGoatInfrastructureParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGoatInfrastructureParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGoatInfrastructureParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGoatInfrastructureParser.g"; }


    	private GoatInfrastructureGrammarAccess grammarAccess;
    	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
    	
    	{
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("LeftCurlyBracket", "'{'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("Ring", "'ring'");
    		tokenNameToValue.put("Tree", "'tree'");
    		tokenNameToValue.put("Nodes", "'nodes'");
    		tokenNameToValue.put("Server", "'server'");
    		tokenNameToValue.put("Cluster", "'cluster'");
    		tokenNameToValue.put("Timeout", "'timeout'");
    		tokenNameToValue.put("Mid_assigner", "'mid_assigner'");
    		tokenNameToValue.put("Registration", "'registration'");
    		tokenNameToValue.put("Singleserver", "'singleserver'");
    		tokenNameToValue.put("Message_queue", "'message_queue'");
    	}

    	public void setGrammarAccess(GoatInfrastructureGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		String result = tokenNameToValue.get(tokenName);
    		if (result == null)
    			result = tokenName;
    		return result;
    	}



    // $ANTLR start "entryRuleInfrastructure"
    // InternalGoatInfrastructureParser.g:71:1: entryRuleInfrastructure : ruleInfrastructure EOF ;
    public final void entryRuleInfrastructure() throws RecognitionException {
        try {
            // InternalGoatInfrastructureParser.g:72:1: ( ruleInfrastructure EOF )
            // InternalGoatInfrastructureParser.g:73:1: ruleInfrastructure EOF
            {
             before(grammarAccess.getInfrastructureRule()); 
            pushFollow(FOLLOW_1);
            ruleInfrastructure();

            state._fsp--;

             after(grammarAccess.getInfrastructureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInfrastructure"


    // $ANTLR start "ruleInfrastructure"
    // InternalGoatInfrastructureParser.g:80:1: ruleInfrastructure : ( ( rule__Infrastructure__Alternatives ) ) ;
    public final void ruleInfrastructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:84:2: ( ( ( rule__Infrastructure__Alternatives ) ) )
            // InternalGoatInfrastructureParser.g:85:2: ( ( rule__Infrastructure__Alternatives ) )
            {
            // InternalGoatInfrastructureParser.g:85:2: ( ( rule__Infrastructure__Alternatives ) )
            // InternalGoatInfrastructureParser.g:86:3: ( rule__Infrastructure__Alternatives )
            {
             before(grammarAccess.getInfrastructureAccess().getAlternatives()); 
            // InternalGoatInfrastructureParser.g:87:3: ( rule__Infrastructure__Alternatives )
            // InternalGoatInfrastructureParser.g:87:4: rule__Infrastructure__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Infrastructure__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInfrastructure"


    // $ANTLR start "entryRuleSingleServer"
    // InternalGoatInfrastructureParser.g:96:1: entryRuleSingleServer : ruleSingleServer EOF ;
    public final void entryRuleSingleServer() throws RecognitionException {
        try {
            // InternalGoatInfrastructureParser.g:97:1: ( ruleSingleServer EOF )
            // InternalGoatInfrastructureParser.g:98:1: ruleSingleServer EOF
            {
             before(grammarAccess.getSingleServerRule()); 
            pushFollow(FOLLOW_1);
            ruleSingleServer();

            state._fsp--;

             after(grammarAccess.getSingleServerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSingleServer"


    // $ANTLR start "ruleSingleServer"
    // InternalGoatInfrastructureParser.g:105:1: ruleSingleServer : ( ( rule__SingleServer__UnorderedGroup ) ) ;
    public final void ruleSingleServer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:109:2: ( ( ( rule__SingleServer__UnorderedGroup ) ) )
            // InternalGoatInfrastructureParser.g:110:2: ( ( rule__SingleServer__UnorderedGroup ) )
            {
            // InternalGoatInfrastructureParser.g:110:2: ( ( rule__SingleServer__UnorderedGroup ) )
            // InternalGoatInfrastructureParser.g:111:3: ( rule__SingleServer__UnorderedGroup )
            {
             before(grammarAccess.getSingleServerAccess().getUnorderedGroup()); 
            // InternalGoatInfrastructureParser.g:112:3: ( rule__SingleServer__UnorderedGroup )
            // InternalGoatInfrastructureParser.g:112:4: rule__SingleServer__UnorderedGroup
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getSingleServerAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSingleServer"


    // $ANTLR start "entryRuleCluster"
    // InternalGoatInfrastructureParser.g:121:1: entryRuleCluster : ruleCluster EOF ;
    public final void entryRuleCluster() throws RecognitionException {
        try {
            // InternalGoatInfrastructureParser.g:122:1: ( ruleCluster EOF )
            // InternalGoatInfrastructureParser.g:123:1: ruleCluster EOF
            {
             before(grammarAccess.getClusterRule()); 
            pushFollow(FOLLOW_1);
            ruleCluster();

            state._fsp--;

             after(grammarAccess.getClusterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCluster"


    // $ANTLR start "ruleCluster"
    // InternalGoatInfrastructureParser.g:130:1: ruleCluster : ( ( rule__Cluster__UnorderedGroup ) ) ;
    public final void ruleCluster() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:134:2: ( ( ( rule__Cluster__UnorderedGroup ) ) )
            // InternalGoatInfrastructureParser.g:135:2: ( ( rule__Cluster__UnorderedGroup ) )
            {
            // InternalGoatInfrastructureParser.g:135:2: ( ( rule__Cluster__UnorderedGroup ) )
            // InternalGoatInfrastructureParser.g:136:3: ( rule__Cluster__UnorderedGroup )
            {
             before(grammarAccess.getClusterAccess().getUnorderedGroup()); 
            // InternalGoatInfrastructureParser.g:137:3: ( rule__Cluster__UnorderedGroup )
            // InternalGoatInfrastructureParser.g:137:4: rule__Cluster__UnorderedGroup
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCluster"


    // $ANTLR start "entryRuleRing"
    // InternalGoatInfrastructureParser.g:146:1: entryRuleRing : ruleRing EOF ;
    public final void entryRuleRing() throws RecognitionException {
        try {
            // InternalGoatInfrastructureParser.g:147:1: ( ruleRing EOF )
            // InternalGoatInfrastructureParser.g:148:1: ruleRing EOF
            {
             before(grammarAccess.getRingRule()); 
            pushFollow(FOLLOW_1);
            ruleRing();

            state._fsp--;

             after(grammarAccess.getRingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRing"


    // $ANTLR start "ruleRing"
    // InternalGoatInfrastructureParser.g:155:1: ruleRing : ( ( rule__Ring__UnorderedGroup ) ) ;
    public final void ruleRing() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:159:2: ( ( ( rule__Ring__UnorderedGroup ) ) )
            // InternalGoatInfrastructureParser.g:160:2: ( ( rule__Ring__UnorderedGroup ) )
            {
            // InternalGoatInfrastructureParser.g:160:2: ( ( rule__Ring__UnorderedGroup ) )
            // InternalGoatInfrastructureParser.g:161:3: ( rule__Ring__UnorderedGroup )
            {
             before(grammarAccess.getRingAccess().getUnorderedGroup()); 
            // InternalGoatInfrastructureParser.g:162:3: ( rule__Ring__UnorderedGroup )
            // InternalGoatInfrastructureParser.g:162:4: rule__Ring__UnorderedGroup
            {
            pushFollow(FOLLOW_2);
            rule__Ring__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRing"


    // $ANTLR start "entryRuleTree"
    // InternalGoatInfrastructureParser.g:171:1: entryRuleTree : ruleTree EOF ;
    public final void entryRuleTree() throws RecognitionException {
        try {
            // InternalGoatInfrastructureParser.g:172:1: ( ruleTree EOF )
            // InternalGoatInfrastructureParser.g:173:1: ruleTree EOF
            {
             before(grammarAccess.getTreeRule()); 
            pushFollow(FOLLOW_1);
            ruleTree();

            state._fsp--;

             after(grammarAccess.getTreeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTree"


    // $ANTLR start "ruleTree"
    // InternalGoatInfrastructureParser.g:180:1: ruleTree : ( ( rule__Tree__UnorderedGroup ) ) ;
    public final void ruleTree() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:184:2: ( ( ( rule__Tree__UnorderedGroup ) ) )
            // InternalGoatInfrastructureParser.g:185:2: ( ( rule__Tree__UnorderedGroup ) )
            {
            // InternalGoatInfrastructureParser.g:185:2: ( ( rule__Tree__UnorderedGroup ) )
            // InternalGoatInfrastructureParser.g:186:3: ( rule__Tree__UnorderedGroup )
            {
             before(grammarAccess.getTreeAccess().getUnorderedGroup()); 
            // InternalGoatInfrastructureParser.g:187:3: ( rule__Tree__UnorderedGroup )
            // InternalGoatInfrastructureParser.g:187:4: rule__Tree__UnorderedGroup
            {
            pushFollow(FOLLOW_2);
            rule__Tree__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getTreeAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTree"


    // $ANTLR start "entryRuleTreeNode"
    // InternalGoatInfrastructureParser.g:196:1: entryRuleTreeNode : ruleTreeNode EOF ;
    public final void entryRuleTreeNode() throws RecognitionException {
        try {
            // InternalGoatInfrastructureParser.g:197:1: ( ruleTreeNode EOF )
            // InternalGoatInfrastructureParser.g:198:1: ruleTreeNode EOF
            {
             before(grammarAccess.getTreeNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTreeNode"


    // $ANTLR start "ruleTreeNode"
    // InternalGoatInfrastructureParser.g:205:1: ruleTreeNode : ( ( rule__TreeNode__Group__0 ) ) ;
    public final void ruleTreeNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:209:2: ( ( ( rule__TreeNode__Group__0 ) ) )
            // InternalGoatInfrastructureParser.g:210:2: ( ( rule__TreeNode__Group__0 ) )
            {
            // InternalGoatInfrastructureParser.g:210:2: ( ( rule__TreeNode__Group__0 ) )
            // InternalGoatInfrastructureParser.g:211:3: ( rule__TreeNode__Group__0 )
            {
             before(grammarAccess.getTreeNodeAccess().getGroup()); 
            // InternalGoatInfrastructureParser.g:212:3: ( rule__TreeNode__Group__0 )
            // InternalGoatInfrastructureParser.g:212:4: rule__TreeNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTreeNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTreeNode"


    // $ANTLR start "rule__Infrastructure__Alternatives"
    // InternalGoatInfrastructureParser.g:220:1: rule__Infrastructure__Alternatives : ( ( ruleSingleServer ) | ( ruleCluster ) | ( ruleRing ) | ( ruleTree ) );
    public final void rule__Infrastructure__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:224:1: ( ( ruleSingleServer ) | ( ruleCluster ) | ( ruleRing ) | ( ruleTree ) )
            int alt1=4;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:225:2: ( ruleSingleServer )
                    {
                    // InternalGoatInfrastructureParser.g:225:2: ( ruleSingleServer )
                    // InternalGoatInfrastructureParser.g:226:3: ruleSingleServer
                    {
                     before(grammarAccess.getInfrastructureAccess().getSingleServerParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSingleServer();

                    state._fsp--;

                     after(grammarAccess.getInfrastructureAccess().getSingleServerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGoatInfrastructureParser.g:231:2: ( ruleCluster )
                    {
                    // InternalGoatInfrastructureParser.g:231:2: ( ruleCluster )
                    // InternalGoatInfrastructureParser.g:232:3: ruleCluster
                    {
                     before(grammarAccess.getInfrastructureAccess().getClusterParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleCluster();

                    state._fsp--;

                     after(grammarAccess.getInfrastructureAccess().getClusterParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGoatInfrastructureParser.g:237:2: ( ruleRing )
                    {
                    // InternalGoatInfrastructureParser.g:237:2: ( ruleRing )
                    // InternalGoatInfrastructureParser.g:238:3: ruleRing
                    {
                     before(grammarAccess.getInfrastructureAccess().getRingParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleRing();

                    state._fsp--;

                     after(grammarAccess.getInfrastructureAccess().getRingParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalGoatInfrastructureParser.g:243:2: ( ruleTree )
                    {
                    // InternalGoatInfrastructureParser.g:243:2: ( ruleTree )
                    // InternalGoatInfrastructureParser.g:244:3: ruleTree
                    {
                     before(grammarAccess.getInfrastructureAccess().getTreeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTree();

                    state._fsp--;

                     after(grammarAccess.getInfrastructureAccess().getTreeParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Infrastructure__Alternatives"


    // $ANTLR start "rule__SingleServer__Group_0__0"
    // InternalGoatInfrastructureParser.g:253:1: rule__SingleServer__Group_0__0 : rule__SingleServer__Group_0__0__Impl rule__SingleServer__Group_0__1 ;
    public final void rule__SingleServer__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:257:1: ( rule__SingleServer__Group_0__0__Impl rule__SingleServer__Group_0__1 )
            // InternalGoatInfrastructureParser.g:258:2: rule__SingleServer__Group_0__0__Impl rule__SingleServer__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__SingleServer__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__0"


    // $ANTLR start "rule__SingleServer__Group_0__0__Impl"
    // InternalGoatInfrastructureParser.g:265:1: rule__SingleServer__Group_0__0__Impl : ( Singleserver ) ;
    public final void rule__SingleServer__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:269:1: ( ( Singleserver ) )
            // InternalGoatInfrastructureParser.g:270:1: ( Singleserver )
            {
            // InternalGoatInfrastructureParser.g:270:1: ( Singleserver )
            // InternalGoatInfrastructureParser.g:271:2: Singleserver
            {
             before(grammarAccess.getSingleServerAccess().getSingleserverKeyword_0_0()); 
            match(input,Singleserver,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getSingleserverKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__0__Impl"


    // $ANTLR start "rule__SingleServer__Group_0__1"
    // InternalGoatInfrastructureParser.g:280:1: rule__SingleServer__Group_0__1 : rule__SingleServer__Group_0__1__Impl rule__SingleServer__Group_0__2 ;
    public final void rule__SingleServer__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:284:1: ( rule__SingleServer__Group_0__1__Impl rule__SingleServer__Group_0__2 )
            // InternalGoatInfrastructureParser.g:285:2: rule__SingleServer__Group_0__1__Impl rule__SingleServer__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__SingleServer__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__1"


    // $ANTLR start "rule__SingleServer__Group_0__1__Impl"
    // InternalGoatInfrastructureParser.g:292:1: rule__SingleServer__Group_0__1__Impl : ( ( rule__SingleServer__NameAssignment_0_1 ) ) ;
    public final void rule__SingleServer__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:296:1: ( ( ( rule__SingleServer__NameAssignment_0_1 ) ) )
            // InternalGoatInfrastructureParser.g:297:1: ( ( rule__SingleServer__NameAssignment_0_1 ) )
            {
            // InternalGoatInfrastructureParser.g:297:1: ( ( rule__SingleServer__NameAssignment_0_1 ) )
            // InternalGoatInfrastructureParser.g:298:2: ( rule__SingleServer__NameAssignment_0_1 )
            {
             before(grammarAccess.getSingleServerAccess().getNameAssignment_0_1()); 
            // InternalGoatInfrastructureParser.g:299:2: ( rule__SingleServer__NameAssignment_0_1 )
            // InternalGoatInfrastructureParser.g:299:3: rule__SingleServer__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getSingleServerAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__1__Impl"


    // $ANTLR start "rule__SingleServer__Group_0__2"
    // InternalGoatInfrastructureParser.g:307:1: rule__SingleServer__Group_0__2 : rule__SingleServer__Group_0__2__Impl rule__SingleServer__Group_0__3 ;
    public final void rule__SingleServer__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:311:1: ( rule__SingleServer__Group_0__2__Impl rule__SingleServer__Group_0__3 )
            // InternalGoatInfrastructureParser.g:312:2: rule__SingleServer__Group_0__2__Impl rule__SingleServer__Group_0__3
            {
            pushFollow(FOLLOW_5);
            rule__SingleServer__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__2"


    // $ANTLR start "rule__SingleServer__Group_0__2__Impl"
    // InternalGoatInfrastructureParser.g:319:1: rule__SingleServer__Group_0__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__SingleServer__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:323:1: ( ( LeftCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:324:1: ( LeftCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:324:1: ( LeftCurlyBracket )
            // InternalGoatInfrastructureParser.g:325:2: LeftCurlyBracket
            {
             before(grammarAccess.getSingleServerAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getLeftCurlyBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__2__Impl"


    // $ANTLR start "rule__SingleServer__Group_0__3"
    // InternalGoatInfrastructureParser.g:334:1: rule__SingleServer__Group_0__3 : rule__SingleServer__Group_0__3__Impl ;
    public final void rule__SingleServer__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:338:1: ( rule__SingleServer__Group_0__3__Impl )
            // InternalGoatInfrastructureParser.g:339:2: rule__SingleServer__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__3"


    // $ANTLR start "rule__SingleServer__Group_0__3__Impl"
    // InternalGoatInfrastructureParser.g:345:1: rule__SingleServer__Group_0__3__Impl : ( ( rule__SingleServer__Group_0_3__0 ) ) ;
    public final void rule__SingleServer__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:349:1: ( ( ( rule__SingleServer__Group_0_3__0 ) ) )
            // InternalGoatInfrastructureParser.g:350:1: ( ( rule__SingleServer__Group_0_3__0 ) )
            {
            // InternalGoatInfrastructureParser.g:350:1: ( ( rule__SingleServer__Group_0_3__0 ) )
            // InternalGoatInfrastructureParser.g:351:2: ( rule__SingleServer__Group_0_3__0 )
            {
             before(grammarAccess.getSingleServerAccess().getGroup_0_3()); 
            // InternalGoatInfrastructureParser.g:352:2: ( rule__SingleServer__Group_0_3__0 )
            // InternalGoatInfrastructureParser.g:352:3: rule__SingleServer__Group_0_3__0
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0_3__0();

            state._fsp--;


            }

             after(grammarAccess.getSingleServerAccess().getGroup_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0__3__Impl"


    // $ANTLR start "rule__SingleServer__Group_0_3__0"
    // InternalGoatInfrastructureParser.g:361:1: rule__SingleServer__Group_0_3__0 : rule__SingleServer__Group_0_3__0__Impl rule__SingleServer__Group_0_3__1 ;
    public final void rule__SingleServer__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:365:1: ( rule__SingleServer__Group_0_3__0__Impl rule__SingleServer__Group_0_3__1 )
            // InternalGoatInfrastructureParser.g:366:2: rule__SingleServer__Group_0_3__0__Impl rule__SingleServer__Group_0_3__1
            {
            pushFollow(FOLLOW_6);
            rule__SingleServer__Group_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0_3__0"


    // $ANTLR start "rule__SingleServer__Group_0_3__0__Impl"
    // InternalGoatInfrastructureParser.g:373:1: rule__SingleServer__Group_0_3__0__Impl : ( Server ) ;
    public final void rule__SingleServer__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:377:1: ( ( Server ) )
            // InternalGoatInfrastructureParser.g:378:1: ( Server )
            {
            // InternalGoatInfrastructureParser.g:378:1: ( Server )
            // InternalGoatInfrastructureParser.g:379:2: Server
            {
             before(grammarAccess.getSingleServerAccess().getServerKeyword_0_3_0()); 
            match(input,Server,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getServerKeyword_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0_3__0__Impl"


    // $ANTLR start "rule__SingleServer__Group_0_3__1"
    // InternalGoatInfrastructureParser.g:388:1: rule__SingleServer__Group_0_3__1 : rule__SingleServer__Group_0_3__1__Impl rule__SingleServer__Group_0_3__2 ;
    public final void rule__SingleServer__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:392:1: ( rule__SingleServer__Group_0_3__1__Impl rule__SingleServer__Group_0_3__2 )
            // InternalGoatInfrastructureParser.g:393:2: rule__SingleServer__Group_0_3__1__Impl rule__SingleServer__Group_0_3__2
            {
            pushFollow(FOLLOW_7);
            rule__SingleServer__Group_0_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0_3__1"


    // $ANTLR start "rule__SingleServer__Group_0_3__1__Impl"
    // InternalGoatInfrastructureParser.g:400:1: rule__SingleServer__Group_0_3__1__Impl : ( Colon ) ;
    public final void rule__SingleServer__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:404:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:405:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:405:1: ( Colon )
            // InternalGoatInfrastructureParser.g:406:2: Colon
            {
             before(grammarAccess.getSingleServerAccess().getColonKeyword_0_3_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getColonKeyword_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0_3__1__Impl"


    // $ANTLR start "rule__SingleServer__Group_0_3__2"
    // InternalGoatInfrastructureParser.g:415:1: rule__SingleServer__Group_0_3__2 : rule__SingleServer__Group_0_3__2__Impl ;
    public final void rule__SingleServer__Group_0_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:419:1: ( rule__SingleServer__Group_0_3__2__Impl )
            // InternalGoatInfrastructureParser.g:420:2: rule__SingleServer__Group_0_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_0_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0_3__2"


    // $ANTLR start "rule__SingleServer__Group_0_3__2__Impl"
    // InternalGoatInfrastructureParser.g:426:1: rule__SingleServer__Group_0_3__2__Impl : ( ( rule__SingleServer__ServerAssignment_0_3_2 ) ) ;
    public final void rule__SingleServer__Group_0_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:430:1: ( ( ( rule__SingleServer__ServerAssignment_0_3_2 ) ) )
            // InternalGoatInfrastructureParser.g:431:1: ( ( rule__SingleServer__ServerAssignment_0_3_2 ) )
            {
            // InternalGoatInfrastructureParser.g:431:1: ( ( rule__SingleServer__ServerAssignment_0_3_2 ) )
            // InternalGoatInfrastructureParser.g:432:2: ( rule__SingleServer__ServerAssignment_0_3_2 )
            {
             before(grammarAccess.getSingleServerAccess().getServerAssignment_0_3_2()); 
            // InternalGoatInfrastructureParser.g:433:2: ( rule__SingleServer__ServerAssignment_0_3_2 )
            // InternalGoatInfrastructureParser.g:433:3: rule__SingleServer__ServerAssignment_0_3_2
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__ServerAssignment_0_3_2();

            state._fsp--;


            }

             after(grammarAccess.getSingleServerAccess().getServerAssignment_0_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_0_3__2__Impl"


    // $ANTLR start "rule__SingleServer__Group_1__0"
    // InternalGoatInfrastructureParser.g:442:1: rule__SingleServer__Group_1__0 : rule__SingleServer__Group_1__0__Impl rule__SingleServer__Group_1__1 ;
    public final void rule__SingleServer__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:446:1: ( rule__SingleServer__Group_1__0__Impl rule__SingleServer__Group_1__1 )
            // InternalGoatInfrastructureParser.g:447:2: rule__SingleServer__Group_1__0__Impl rule__SingleServer__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__SingleServer__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1__0"


    // $ANTLR start "rule__SingleServer__Group_1__0__Impl"
    // InternalGoatInfrastructureParser.g:454:1: rule__SingleServer__Group_1__0__Impl : ( ( rule__SingleServer__Group_1_0__0 )? ) ;
    public final void rule__SingleServer__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:458:1: ( ( ( rule__SingleServer__Group_1_0__0 )? ) )
            // InternalGoatInfrastructureParser.g:459:1: ( ( rule__SingleServer__Group_1_0__0 )? )
            {
            // InternalGoatInfrastructureParser.g:459:1: ( ( rule__SingleServer__Group_1_0__0 )? )
            // InternalGoatInfrastructureParser.g:460:2: ( rule__SingleServer__Group_1_0__0 )?
            {
             before(grammarAccess.getSingleServerAccess().getGroup_1_0()); 
            // InternalGoatInfrastructureParser.g:461:2: ( rule__SingleServer__Group_1_0__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Timeout) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:461:3: rule__SingleServer__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleServer__Group_1_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSingleServerAccess().getGroup_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1__0__Impl"


    // $ANTLR start "rule__SingleServer__Group_1__1"
    // InternalGoatInfrastructureParser.g:469:1: rule__SingleServer__Group_1__1 : rule__SingleServer__Group_1__1__Impl ;
    public final void rule__SingleServer__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:473:1: ( rule__SingleServer__Group_1__1__Impl )
            // InternalGoatInfrastructureParser.g:474:2: rule__SingleServer__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1__1"


    // $ANTLR start "rule__SingleServer__Group_1__1__Impl"
    // InternalGoatInfrastructureParser.g:480:1: rule__SingleServer__Group_1__1__Impl : ( RightCurlyBracket ) ;
    public final void rule__SingleServer__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:484:1: ( ( RightCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:485:1: ( RightCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:485:1: ( RightCurlyBracket )
            // InternalGoatInfrastructureParser.g:486:2: RightCurlyBracket
            {
             before(grammarAccess.getSingleServerAccess().getRightCurlyBracketKeyword_1_1()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getRightCurlyBracketKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1__1__Impl"


    // $ANTLR start "rule__SingleServer__Group_1_0__0"
    // InternalGoatInfrastructureParser.g:496:1: rule__SingleServer__Group_1_0__0 : rule__SingleServer__Group_1_0__0__Impl rule__SingleServer__Group_1_0__1 ;
    public final void rule__SingleServer__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:500:1: ( rule__SingleServer__Group_1_0__0__Impl rule__SingleServer__Group_1_0__1 )
            // InternalGoatInfrastructureParser.g:501:2: rule__SingleServer__Group_1_0__0__Impl rule__SingleServer__Group_1_0__1
            {
            pushFollow(FOLLOW_6);
            rule__SingleServer__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1_0__0"


    // $ANTLR start "rule__SingleServer__Group_1_0__0__Impl"
    // InternalGoatInfrastructureParser.g:508:1: rule__SingleServer__Group_1_0__0__Impl : ( Timeout ) ;
    public final void rule__SingleServer__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:512:1: ( ( Timeout ) )
            // InternalGoatInfrastructureParser.g:513:1: ( Timeout )
            {
            // InternalGoatInfrastructureParser.g:513:1: ( Timeout )
            // InternalGoatInfrastructureParser.g:514:2: Timeout
            {
             before(grammarAccess.getSingleServerAccess().getTimeoutKeyword_1_0_0()); 
            match(input,Timeout,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getTimeoutKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1_0__0__Impl"


    // $ANTLR start "rule__SingleServer__Group_1_0__1"
    // InternalGoatInfrastructureParser.g:523:1: rule__SingleServer__Group_1_0__1 : rule__SingleServer__Group_1_0__1__Impl rule__SingleServer__Group_1_0__2 ;
    public final void rule__SingleServer__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:527:1: ( rule__SingleServer__Group_1_0__1__Impl rule__SingleServer__Group_1_0__2 )
            // InternalGoatInfrastructureParser.g:528:2: rule__SingleServer__Group_1_0__1__Impl rule__SingleServer__Group_1_0__2
            {
            pushFollow(FOLLOW_9);
            rule__SingleServer__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1_0__1"


    // $ANTLR start "rule__SingleServer__Group_1_0__1__Impl"
    // InternalGoatInfrastructureParser.g:535:1: rule__SingleServer__Group_1_0__1__Impl : ( Colon ) ;
    public final void rule__SingleServer__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:539:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:540:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:540:1: ( Colon )
            // InternalGoatInfrastructureParser.g:541:2: Colon
            {
             before(grammarAccess.getSingleServerAccess().getColonKeyword_1_0_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getColonKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1_0__1__Impl"


    // $ANTLR start "rule__SingleServer__Group_1_0__2"
    // InternalGoatInfrastructureParser.g:550:1: rule__SingleServer__Group_1_0__2 : rule__SingleServer__Group_1_0__2__Impl ;
    public final void rule__SingleServer__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:554:1: ( rule__SingleServer__Group_1_0__2__Impl )
            // InternalGoatInfrastructureParser.g:555:2: rule__SingleServer__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1_0__2"


    // $ANTLR start "rule__SingleServer__Group_1_0__2__Impl"
    // InternalGoatInfrastructureParser.g:561:1: rule__SingleServer__Group_1_0__2__Impl : ( ( rule__SingleServer__TimeoutAssignment_1_0_2 ) ) ;
    public final void rule__SingleServer__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:565:1: ( ( ( rule__SingleServer__TimeoutAssignment_1_0_2 ) ) )
            // InternalGoatInfrastructureParser.g:566:1: ( ( rule__SingleServer__TimeoutAssignment_1_0_2 ) )
            {
            // InternalGoatInfrastructureParser.g:566:1: ( ( rule__SingleServer__TimeoutAssignment_1_0_2 ) )
            // InternalGoatInfrastructureParser.g:567:2: ( rule__SingleServer__TimeoutAssignment_1_0_2 )
            {
             before(grammarAccess.getSingleServerAccess().getTimeoutAssignment_1_0_2()); 
            // InternalGoatInfrastructureParser.g:568:2: ( rule__SingleServer__TimeoutAssignment_1_0_2 )
            // InternalGoatInfrastructureParser.g:568:3: rule__SingleServer__TimeoutAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__TimeoutAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getSingleServerAccess().getTimeoutAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__Group_1_0__2__Impl"


    // $ANTLR start "rule__Cluster__Group_0__0"
    // InternalGoatInfrastructureParser.g:577:1: rule__Cluster__Group_0__0 : rule__Cluster__Group_0__0__Impl rule__Cluster__Group_0__1 ;
    public final void rule__Cluster__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:581:1: ( rule__Cluster__Group_0__0__Impl rule__Cluster__Group_0__1 )
            // InternalGoatInfrastructureParser.g:582:2: rule__Cluster__Group_0__0__Impl rule__Cluster__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__Cluster__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__0"


    // $ANTLR start "rule__Cluster__Group_0__0__Impl"
    // InternalGoatInfrastructureParser.g:589:1: rule__Cluster__Group_0__0__Impl : ( Cluster ) ;
    public final void rule__Cluster__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:593:1: ( ( Cluster ) )
            // InternalGoatInfrastructureParser.g:594:1: ( Cluster )
            {
            // InternalGoatInfrastructureParser.g:594:1: ( Cluster )
            // InternalGoatInfrastructureParser.g:595:2: Cluster
            {
             before(grammarAccess.getClusterAccess().getClusterKeyword_0_0()); 
            match(input,Cluster,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getClusterKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__0__Impl"


    // $ANTLR start "rule__Cluster__Group_0__1"
    // InternalGoatInfrastructureParser.g:604:1: rule__Cluster__Group_0__1 : rule__Cluster__Group_0__1__Impl rule__Cluster__Group_0__2 ;
    public final void rule__Cluster__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:608:1: ( rule__Cluster__Group_0__1__Impl rule__Cluster__Group_0__2 )
            // InternalGoatInfrastructureParser.g:609:2: rule__Cluster__Group_0__1__Impl rule__Cluster__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__Cluster__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__1"


    // $ANTLR start "rule__Cluster__Group_0__1__Impl"
    // InternalGoatInfrastructureParser.g:616:1: rule__Cluster__Group_0__1__Impl : ( ( rule__Cluster__NameAssignment_0_1 ) ) ;
    public final void rule__Cluster__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:620:1: ( ( ( rule__Cluster__NameAssignment_0_1 ) ) )
            // InternalGoatInfrastructureParser.g:621:1: ( ( rule__Cluster__NameAssignment_0_1 ) )
            {
            // InternalGoatInfrastructureParser.g:621:1: ( ( rule__Cluster__NameAssignment_0_1 ) )
            // InternalGoatInfrastructureParser.g:622:2: ( rule__Cluster__NameAssignment_0_1 )
            {
             before(grammarAccess.getClusterAccess().getNameAssignment_0_1()); 
            // InternalGoatInfrastructureParser.g:623:2: ( rule__Cluster__NameAssignment_0_1 )
            // InternalGoatInfrastructureParser.g:623:3: rule__Cluster__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__1__Impl"


    // $ANTLR start "rule__Cluster__Group_0__2"
    // InternalGoatInfrastructureParser.g:631:1: rule__Cluster__Group_0__2 : rule__Cluster__Group_0__2__Impl rule__Cluster__Group_0__3 ;
    public final void rule__Cluster__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:635:1: ( rule__Cluster__Group_0__2__Impl rule__Cluster__Group_0__3 )
            // InternalGoatInfrastructureParser.g:636:2: rule__Cluster__Group_0__2__Impl rule__Cluster__Group_0__3
            {
            pushFollow(FOLLOW_10);
            rule__Cluster__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__2"


    // $ANTLR start "rule__Cluster__Group_0__2__Impl"
    // InternalGoatInfrastructureParser.g:643:1: rule__Cluster__Group_0__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__Cluster__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:647:1: ( ( LeftCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:648:1: ( LeftCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:648:1: ( LeftCurlyBracket )
            // InternalGoatInfrastructureParser.g:649:2: LeftCurlyBracket
            {
             before(grammarAccess.getClusterAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getLeftCurlyBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__2__Impl"


    // $ANTLR start "rule__Cluster__Group_0__3"
    // InternalGoatInfrastructureParser.g:658:1: rule__Cluster__Group_0__3 : rule__Cluster__Group_0__3__Impl ;
    public final void rule__Cluster__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:662:1: ( rule__Cluster__Group_0__3__Impl )
            // InternalGoatInfrastructureParser.g:663:2: rule__Cluster__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__3"


    // $ANTLR start "rule__Cluster__Group_0__3__Impl"
    // InternalGoatInfrastructureParser.g:669:1: rule__Cluster__Group_0__3__Impl : ( ( rule__Cluster__Group_0_3__0 ) ) ;
    public final void rule__Cluster__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:673:1: ( ( ( rule__Cluster__Group_0_3__0 ) ) )
            // InternalGoatInfrastructureParser.g:674:1: ( ( rule__Cluster__Group_0_3__0 ) )
            {
            // InternalGoatInfrastructureParser.g:674:1: ( ( rule__Cluster__Group_0_3__0 ) )
            // InternalGoatInfrastructureParser.g:675:2: ( rule__Cluster__Group_0_3__0 )
            {
             before(grammarAccess.getClusterAccess().getGroup_0_3()); 
            // InternalGoatInfrastructureParser.g:676:2: ( rule__Cluster__Group_0_3__0 )
            // InternalGoatInfrastructureParser.g:676:3: rule__Cluster__Group_0_3__0
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0_3__0();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getGroup_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0__3__Impl"


    // $ANTLR start "rule__Cluster__Group_0_3__0"
    // InternalGoatInfrastructureParser.g:685:1: rule__Cluster__Group_0_3__0 : rule__Cluster__Group_0_3__0__Impl rule__Cluster__Group_0_3__1 ;
    public final void rule__Cluster__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:689:1: ( rule__Cluster__Group_0_3__0__Impl rule__Cluster__Group_0_3__1 )
            // InternalGoatInfrastructureParser.g:690:2: rule__Cluster__Group_0_3__0__Impl rule__Cluster__Group_0_3__1
            {
            pushFollow(FOLLOW_6);
            rule__Cluster__Group_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0_3__0"


    // $ANTLR start "rule__Cluster__Group_0_3__0__Impl"
    // InternalGoatInfrastructureParser.g:697:1: rule__Cluster__Group_0_3__0__Impl : ( Message_queue ) ;
    public final void rule__Cluster__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:701:1: ( ( Message_queue ) )
            // InternalGoatInfrastructureParser.g:702:1: ( Message_queue )
            {
            // InternalGoatInfrastructureParser.g:702:1: ( Message_queue )
            // InternalGoatInfrastructureParser.g:703:2: Message_queue
            {
             before(grammarAccess.getClusterAccess().getMessage_queueKeyword_0_3_0()); 
            match(input,Message_queue,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getMessage_queueKeyword_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0_3__0__Impl"


    // $ANTLR start "rule__Cluster__Group_0_3__1"
    // InternalGoatInfrastructureParser.g:712:1: rule__Cluster__Group_0_3__1 : rule__Cluster__Group_0_3__1__Impl rule__Cluster__Group_0_3__2 ;
    public final void rule__Cluster__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:716:1: ( rule__Cluster__Group_0_3__1__Impl rule__Cluster__Group_0_3__2 )
            // InternalGoatInfrastructureParser.g:717:2: rule__Cluster__Group_0_3__1__Impl rule__Cluster__Group_0_3__2
            {
            pushFollow(FOLLOW_7);
            rule__Cluster__Group_0_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0_3__1"


    // $ANTLR start "rule__Cluster__Group_0_3__1__Impl"
    // InternalGoatInfrastructureParser.g:724:1: rule__Cluster__Group_0_3__1__Impl : ( Colon ) ;
    public final void rule__Cluster__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:728:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:729:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:729:1: ( Colon )
            // InternalGoatInfrastructureParser.g:730:2: Colon
            {
             before(grammarAccess.getClusterAccess().getColonKeyword_0_3_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getColonKeyword_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0_3__1__Impl"


    // $ANTLR start "rule__Cluster__Group_0_3__2"
    // InternalGoatInfrastructureParser.g:739:1: rule__Cluster__Group_0_3__2 : rule__Cluster__Group_0_3__2__Impl ;
    public final void rule__Cluster__Group_0_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:743:1: ( rule__Cluster__Group_0_3__2__Impl )
            // InternalGoatInfrastructureParser.g:744:2: rule__Cluster__Group_0_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_0_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0_3__2"


    // $ANTLR start "rule__Cluster__Group_0_3__2__Impl"
    // InternalGoatInfrastructureParser.g:750:1: rule__Cluster__Group_0_3__2__Impl : ( ( rule__Cluster__Message_queueAssignment_0_3_2 ) ) ;
    public final void rule__Cluster__Group_0_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:754:1: ( ( ( rule__Cluster__Message_queueAssignment_0_3_2 ) ) )
            // InternalGoatInfrastructureParser.g:755:1: ( ( rule__Cluster__Message_queueAssignment_0_3_2 ) )
            {
            // InternalGoatInfrastructureParser.g:755:1: ( ( rule__Cluster__Message_queueAssignment_0_3_2 ) )
            // InternalGoatInfrastructureParser.g:756:2: ( rule__Cluster__Message_queueAssignment_0_3_2 )
            {
             before(grammarAccess.getClusterAccess().getMessage_queueAssignment_0_3_2()); 
            // InternalGoatInfrastructureParser.g:757:2: ( rule__Cluster__Message_queueAssignment_0_3_2 )
            // InternalGoatInfrastructureParser.g:757:3: rule__Cluster__Message_queueAssignment_0_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Message_queueAssignment_0_3_2();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getMessage_queueAssignment_0_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_0_3__2__Impl"


    // $ANTLR start "rule__Cluster__Group_1__0"
    // InternalGoatInfrastructureParser.g:766:1: rule__Cluster__Group_1__0 : rule__Cluster__Group_1__0__Impl rule__Cluster__Group_1__1 ;
    public final void rule__Cluster__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:770:1: ( rule__Cluster__Group_1__0__Impl rule__Cluster__Group_1__1 )
            // InternalGoatInfrastructureParser.g:771:2: rule__Cluster__Group_1__0__Impl rule__Cluster__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__Cluster__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_1__0"


    // $ANTLR start "rule__Cluster__Group_1__0__Impl"
    // InternalGoatInfrastructureParser.g:778:1: rule__Cluster__Group_1__0__Impl : ( Registration ) ;
    public final void rule__Cluster__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:782:1: ( ( Registration ) )
            // InternalGoatInfrastructureParser.g:783:1: ( Registration )
            {
            // InternalGoatInfrastructureParser.g:783:1: ( Registration )
            // InternalGoatInfrastructureParser.g:784:2: Registration
            {
             before(grammarAccess.getClusterAccess().getRegistrationKeyword_1_0()); 
            match(input,Registration,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getRegistrationKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_1__0__Impl"


    // $ANTLR start "rule__Cluster__Group_1__1"
    // InternalGoatInfrastructureParser.g:793:1: rule__Cluster__Group_1__1 : rule__Cluster__Group_1__1__Impl rule__Cluster__Group_1__2 ;
    public final void rule__Cluster__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:797:1: ( rule__Cluster__Group_1__1__Impl rule__Cluster__Group_1__2 )
            // InternalGoatInfrastructureParser.g:798:2: rule__Cluster__Group_1__1__Impl rule__Cluster__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Cluster__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_1__1"


    // $ANTLR start "rule__Cluster__Group_1__1__Impl"
    // InternalGoatInfrastructureParser.g:805:1: rule__Cluster__Group_1__1__Impl : ( Colon ) ;
    public final void rule__Cluster__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:809:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:810:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:810:1: ( Colon )
            // InternalGoatInfrastructureParser.g:811:2: Colon
            {
             before(grammarAccess.getClusterAccess().getColonKeyword_1_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_1__1__Impl"


    // $ANTLR start "rule__Cluster__Group_1__2"
    // InternalGoatInfrastructureParser.g:820:1: rule__Cluster__Group_1__2 : rule__Cluster__Group_1__2__Impl ;
    public final void rule__Cluster__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:824:1: ( rule__Cluster__Group_1__2__Impl )
            // InternalGoatInfrastructureParser.g:825:2: rule__Cluster__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_1__2"


    // $ANTLR start "rule__Cluster__Group_1__2__Impl"
    // InternalGoatInfrastructureParser.g:831:1: rule__Cluster__Group_1__2__Impl : ( ( rule__Cluster__RegistrationAssignment_1_2 ) ) ;
    public final void rule__Cluster__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:835:1: ( ( ( rule__Cluster__RegistrationAssignment_1_2 ) ) )
            // InternalGoatInfrastructureParser.g:836:1: ( ( rule__Cluster__RegistrationAssignment_1_2 ) )
            {
            // InternalGoatInfrastructureParser.g:836:1: ( ( rule__Cluster__RegistrationAssignment_1_2 ) )
            // InternalGoatInfrastructureParser.g:837:2: ( rule__Cluster__RegistrationAssignment_1_2 )
            {
             before(grammarAccess.getClusterAccess().getRegistrationAssignment_1_2()); 
            // InternalGoatInfrastructureParser.g:838:2: ( rule__Cluster__RegistrationAssignment_1_2 )
            // InternalGoatInfrastructureParser.g:838:3: rule__Cluster__RegistrationAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__RegistrationAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getRegistrationAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_1__2__Impl"


    // $ANTLR start "rule__Cluster__Group_2__0"
    // InternalGoatInfrastructureParser.g:847:1: rule__Cluster__Group_2__0 : rule__Cluster__Group_2__0__Impl rule__Cluster__Group_2__1 ;
    public final void rule__Cluster__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:851:1: ( rule__Cluster__Group_2__0__Impl rule__Cluster__Group_2__1 )
            // InternalGoatInfrastructureParser.g:852:2: rule__Cluster__Group_2__0__Impl rule__Cluster__Group_2__1
            {
            pushFollow(FOLLOW_6);
            rule__Cluster__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_2__0"


    // $ANTLR start "rule__Cluster__Group_2__0__Impl"
    // InternalGoatInfrastructureParser.g:859:1: rule__Cluster__Group_2__0__Impl : ( Mid_assigner ) ;
    public final void rule__Cluster__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:863:1: ( ( Mid_assigner ) )
            // InternalGoatInfrastructureParser.g:864:1: ( Mid_assigner )
            {
            // InternalGoatInfrastructureParser.g:864:1: ( Mid_assigner )
            // InternalGoatInfrastructureParser.g:865:2: Mid_assigner
            {
             before(grammarAccess.getClusterAccess().getMid_assignerKeyword_2_0()); 
            match(input,Mid_assigner,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getMid_assignerKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_2__0__Impl"


    // $ANTLR start "rule__Cluster__Group_2__1"
    // InternalGoatInfrastructureParser.g:874:1: rule__Cluster__Group_2__1 : rule__Cluster__Group_2__1__Impl rule__Cluster__Group_2__2 ;
    public final void rule__Cluster__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:878:1: ( rule__Cluster__Group_2__1__Impl rule__Cluster__Group_2__2 )
            // InternalGoatInfrastructureParser.g:879:2: rule__Cluster__Group_2__1__Impl rule__Cluster__Group_2__2
            {
            pushFollow(FOLLOW_7);
            rule__Cluster__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_2__1"


    // $ANTLR start "rule__Cluster__Group_2__1__Impl"
    // InternalGoatInfrastructureParser.g:886:1: rule__Cluster__Group_2__1__Impl : ( Colon ) ;
    public final void rule__Cluster__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:890:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:891:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:891:1: ( Colon )
            // InternalGoatInfrastructureParser.g:892:2: Colon
            {
             before(grammarAccess.getClusterAccess().getColonKeyword_2_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getColonKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_2__1__Impl"


    // $ANTLR start "rule__Cluster__Group_2__2"
    // InternalGoatInfrastructureParser.g:901:1: rule__Cluster__Group_2__2 : rule__Cluster__Group_2__2__Impl ;
    public final void rule__Cluster__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:905:1: ( rule__Cluster__Group_2__2__Impl )
            // InternalGoatInfrastructureParser.g:906:2: rule__Cluster__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_2__2"


    // $ANTLR start "rule__Cluster__Group_2__2__Impl"
    // InternalGoatInfrastructureParser.g:912:1: rule__Cluster__Group_2__2__Impl : ( ( rule__Cluster__Mid_assignerAssignment_2_2 ) ) ;
    public final void rule__Cluster__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:916:1: ( ( ( rule__Cluster__Mid_assignerAssignment_2_2 ) ) )
            // InternalGoatInfrastructureParser.g:917:1: ( ( rule__Cluster__Mid_assignerAssignment_2_2 ) )
            {
            // InternalGoatInfrastructureParser.g:917:1: ( ( rule__Cluster__Mid_assignerAssignment_2_2 ) )
            // InternalGoatInfrastructureParser.g:918:2: ( rule__Cluster__Mid_assignerAssignment_2_2 )
            {
             before(grammarAccess.getClusterAccess().getMid_assignerAssignment_2_2()); 
            // InternalGoatInfrastructureParser.g:919:2: ( rule__Cluster__Mid_assignerAssignment_2_2 )
            // InternalGoatInfrastructureParser.g:919:3: rule__Cluster__Mid_assignerAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Mid_assignerAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getMid_assignerAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_2__2__Impl"


    // $ANTLR start "rule__Cluster__Group_3__0"
    // InternalGoatInfrastructureParser.g:928:1: rule__Cluster__Group_3__0 : rule__Cluster__Group_3__0__Impl rule__Cluster__Group_3__1 ;
    public final void rule__Cluster__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:932:1: ( rule__Cluster__Group_3__0__Impl rule__Cluster__Group_3__1 )
            // InternalGoatInfrastructureParser.g:933:2: rule__Cluster__Group_3__0__Impl rule__Cluster__Group_3__1
            {
            pushFollow(FOLLOW_8);
            rule__Cluster__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3__0"


    // $ANTLR start "rule__Cluster__Group_3__0__Impl"
    // InternalGoatInfrastructureParser.g:940:1: rule__Cluster__Group_3__0__Impl : ( ( rule__Cluster__Group_3_0__0 ) ) ;
    public final void rule__Cluster__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:944:1: ( ( ( rule__Cluster__Group_3_0__0 ) ) )
            // InternalGoatInfrastructureParser.g:945:1: ( ( rule__Cluster__Group_3_0__0 ) )
            {
            // InternalGoatInfrastructureParser.g:945:1: ( ( rule__Cluster__Group_3_0__0 ) )
            // InternalGoatInfrastructureParser.g:946:2: ( rule__Cluster__Group_3_0__0 )
            {
             before(grammarAccess.getClusterAccess().getGroup_3_0()); 
            // InternalGoatInfrastructureParser.g:947:2: ( rule__Cluster__Group_3_0__0 )
            // InternalGoatInfrastructureParser.g:947:3: rule__Cluster__Group_3_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0__0();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getGroup_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3__0__Impl"


    // $ANTLR start "rule__Cluster__Group_3__1"
    // InternalGoatInfrastructureParser.g:955:1: rule__Cluster__Group_3__1 : rule__Cluster__Group_3__1__Impl ;
    public final void rule__Cluster__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:959:1: ( rule__Cluster__Group_3__1__Impl )
            // InternalGoatInfrastructureParser.g:960:2: rule__Cluster__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3__1"


    // $ANTLR start "rule__Cluster__Group_3__1__Impl"
    // InternalGoatInfrastructureParser.g:966:1: rule__Cluster__Group_3__1__Impl : ( RightCurlyBracket ) ;
    public final void rule__Cluster__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:970:1: ( ( RightCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:971:1: ( RightCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:971:1: ( RightCurlyBracket )
            // InternalGoatInfrastructureParser.g:972:2: RightCurlyBracket
            {
             before(grammarAccess.getClusterAccess().getRightCurlyBracketKeyword_3_1()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getRightCurlyBracketKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3__1__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0__0"
    // InternalGoatInfrastructureParser.g:982:1: rule__Cluster__Group_3_0__0 : rule__Cluster__Group_3_0__0__Impl rule__Cluster__Group_3_0__1 ;
    public final void rule__Cluster__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:986:1: ( rule__Cluster__Group_3_0__0__Impl rule__Cluster__Group_3_0__1 )
            // InternalGoatInfrastructureParser.g:987:2: rule__Cluster__Group_3_0__0__Impl rule__Cluster__Group_3_0__1
            {
            pushFollow(FOLLOW_6);
            rule__Cluster__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__0"


    // $ANTLR start "rule__Cluster__Group_3_0__0__Impl"
    // InternalGoatInfrastructureParser.g:994:1: rule__Cluster__Group_3_0__0__Impl : ( Nodes ) ;
    public final void rule__Cluster__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:998:1: ( ( Nodes ) )
            // InternalGoatInfrastructureParser.g:999:1: ( Nodes )
            {
            // InternalGoatInfrastructureParser.g:999:1: ( Nodes )
            // InternalGoatInfrastructureParser.g:1000:2: Nodes
            {
             before(grammarAccess.getClusterAccess().getNodesKeyword_3_0_0()); 
            match(input,Nodes,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getNodesKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__0__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0__1"
    // InternalGoatInfrastructureParser.g:1009:1: rule__Cluster__Group_3_0__1 : rule__Cluster__Group_3_0__1__Impl rule__Cluster__Group_3_0__2 ;
    public final void rule__Cluster__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1013:1: ( rule__Cluster__Group_3_0__1__Impl rule__Cluster__Group_3_0__2 )
            // InternalGoatInfrastructureParser.g:1014:2: rule__Cluster__Group_3_0__1__Impl rule__Cluster__Group_3_0__2
            {
            pushFollow(FOLLOW_11);
            rule__Cluster__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__1"


    // $ANTLR start "rule__Cluster__Group_3_0__1__Impl"
    // InternalGoatInfrastructureParser.g:1021:1: rule__Cluster__Group_3_0__1__Impl : ( Colon ) ;
    public final void rule__Cluster__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1025:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:1026:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:1026:1: ( Colon )
            // InternalGoatInfrastructureParser.g:1027:2: Colon
            {
             before(grammarAccess.getClusterAccess().getColonKeyword_3_0_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getColonKeyword_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__1__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0__2"
    // InternalGoatInfrastructureParser.g:1036:1: rule__Cluster__Group_3_0__2 : rule__Cluster__Group_3_0__2__Impl rule__Cluster__Group_3_0__3 ;
    public final void rule__Cluster__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1040:1: ( rule__Cluster__Group_3_0__2__Impl rule__Cluster__Group_3_0__3 )
            // InternalGoatInfrastructureParser.g:1041:2: rule__Cluster__Group_3_0__2__Impl rule__Cluster__Group_3_0__3
            {
            pushFollow(FOLLOW_7);
            rule__Cluster__Group_3_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__2"


    // $ANTLR start "rule__Cluster__Group_3_0__2__Impl"
    // InternalGoatInfrastructureParser.g:1048:1: rule__Cluster__Group_3_0__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Cluster__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1052:1: ( ( LeftSquareBracket ) )
            // InternalGoatInfrastructureParser.g:1053:1: ( LeftSquareBracket )
            {
            // InternalGoatInfrastructureParser.g:1053:1: ( LeftSquareBracket )
            // InternalGoatInfrastructureParser.g:1054:2: LeftSquareBracket
            {
             before(grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_0_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__2__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0__3"
    // InternalGoatInfrastructureParser.g:1063:1: rule__Cluster__Group_3_0__3 : rule__Cluster__Group_3_0__3__Impl rule__Cluster__Group_3_0__4 ;
    public final void rule__Cluster__Group_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1067:1: ( rule__Cluster__Group_3_0__3__Impl rule__Cluster__Group_3_0__4 )
            // InternalGoatInfrastructureParser.g:1068:2: rule__Cluster__Group_3_0__3__Impl rule__Cluster__Group_3_0__4
            {
            pushFollow(FOLLOW_12);
            rule__Cluster__Group_3_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__3"


    // $ANTLR start "rule__Cluster__Group_3_0__3__Impl"
    // InternalGoatInfrastructureParser.g:1075:1: rule__Cluster__Group_3_0__3__Impl : ( ( rule__Cluster__NodesAssignment_3_0_3 ) ) ;
    public final void rule__Cluster__Group_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1079:1: ( ( ( rule__Cluster__NodesAssignment_3_0_3 ) ) )
            // InternalGoatInfrastructureParser.g:1080:1: ( ( rule__Cluster__NodesAssignment_3_0_3 ) )
            {
            // InternalGoatInfrastructureParser.g:1080:1: ( ( rule__Cluster__NodesAssignment_3_0_3 ) )
            // InternalGoatInfrastructureParser.g:1081:2: ( rule__Cluster__NodesAssignment_3_0_3 )
            {
             before(grammarAccess.getClusterAccess().getNodesAssignment_3_0_3()); 
            // InternalGoatInfrastructureParser.g:1082:2: ( rule__Cluster__NodesAssignment_3_0_3 )
            // InternalGoatInfrastructureParser.g:1082:3: rule__Cluster__NodesAssignment_3_0_3
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__NodesAssignment_3_0_3();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getNodesAssignment_3_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__3__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0__4"
    // InternalGoatInfrastructureParser.g:1090:1: rule__Cluster__Group_3_0__4 : rule__Cluster__Group_3_0__4__Impl rule__Cluster__Group_3_0__5 ;
    public final void rule__Cluster__Group_3_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1094:1: ( rule__Cluster__Group_3_0__4__Impl rule__Cluster__Group_3_0__5 )
            // InternalGoatInfrastructureParser.g:1095:2: rule__Cluster__Group_3_0__4__Impl rule__Cluster__Group_3_0__5
            {
            pushFollow(FOLLOW_12);
            rule__Cluster__Group_3_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__4"


    // $ANTLR start "rule__Cluster__Group_3_0__4__Impl"
    // InternalGoatInfrastructureParser.g:1102:1: rule__Cluster__Group_3_0__4__Impl : ( ( rule__Cluster__Group_3_0_4__0 )* ) ;
    public final void rule__Cluster__Group_3_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1106:1: ( ( ( rule__Cluster__Group_3_0_4__0 )* ) )
            // InternalGoatInfrastructureParser.g:1107:1: ( ( rule__Cluster__Group_3_0_4__0 )* )
            {
            // InternalGoatInfrastructureParser.g:1107:1: ( ( rule__Cluster__Group_3_0_4__0 )* )
            // InternalGoatInfrastructureParser.g:1108:2: ( rule__Cluster__Group_3_0_4__0 )*
            {
             before(grammarAccess.getClusterAccess().getGroup_3_0_4()); 
            // InternalGoatInfrastructureParser.g:1109:2: ( rule__Cluster__Group_3_0_4__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Comma) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGoatInfrastructureParser.g:1109:3: rule__Cluster__Group_3_0_4__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Cluster__Group_3_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getClusterAccess().getGroup_3_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__4__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0__5"
    // InternalGoatInfrastructureParser.g:1117:1: rule__Cluster__Group_3_0__5 : rule__Cluster__Group_3_0__5__Impl ;
    public final void rule__Cluster__Group_3_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1121:1: ( rule__Cluster__Group_3_0__5__Impl )
            // InternalGoatInfrastructureParser.g:1122:2: rule__Cluster__Group_3_0__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__5"


    // $ANTLR start "rule__Cluster__Group_3_0__5__Impl"
    // InternalGoatInfrastructureParser.g:1128:1: rule__Cluster__Group_3_0__5__Impl : ( RightSquareBracket ) ;
    public final void rule__Cluster__Group_3_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1132:1: ( ( RightSquareBracket ) )
            // InternalGoatInfrastructureParser.g:1133:1: ( RightSquareBracket )
            {
            // InternalGoatInfrastructureParser.g:1133:1: ( RightSquareBracket )
            // InternalGoatInfrastructureParser.g:1134:2: RightSquareBracket
            {
             before(grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_0_5()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0__5__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0_4__0"
    // InternalGoatInfrastructureParser.g:1144:1: rule__Cluster__Group_3_0_4__0 : rule__Cluster__Group_3_0_4__0__Impl rule__Cluster__Group_3_0_4__1 ;
    public final void rule__Cluster__Group_3_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1148:1: ( rule__Cluster__Group_3_0_4__0__Impl rule__Cluster__Group_3_0_4__1 )
            // InternalGoatInfrastructureParser.g:1149:2: rule__Cluster__Group_3_0_4__0__Impl rule__Cluster__Group_3_0_4__1
            {
            pushFollow(FOLLOW_7);
            rule__Cluster__Group_3_0_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0_4__0"


    // $ANTLR start "rule__Cluster__Group_3_0_4__0__Impl"
    // InternalGoatInfrastructureParser.g:1156:1: rule__Cluster__Group_3_0_4__0__Impl : ( Comma ) ;
    public final void rule__Cluster__Group_3_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1160:1: ( ( Comma ) )
            // InternalGoatInfrastructureParser.g:1161:1: ( Comma )
            {
            // InternalGoatInfrastructureParser.g:1161:1: ( Comma )
            // InternalGoatInfrastructureParser.g:1162:2: Comma
            {
             before(grammarAccess.getClusterAccess().getCommaKeyword_3_0_4_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getCommaKeyword_3_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0_4__0__Impl"


    // $ANTLR start "rule__Cluster__Group_3_0_4__1"
    // InternalGoatInfrastructureParser.g:1171:1: rule__Cluster__Group_3_0_4__1 : rule__Cluster__Group_3_0_4__1__Impl ;
    public final void rule__Cluster__Group_3_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1175:1: ( rule__Cluster__Group_3_0_4__1__Impl )
            // InternalGoatInfrastructureParser.g:1176:2: rule__Cluster__Group_3_0_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__Group_3_0_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0_4__1"


    // $ANTLR start "rule__Cluster__Group_3_0_4__1__Impl"
    // InternalGoatInfrastructureParser.g:1182:1: rule__Cluster__Group_3_0_4__1__Impl : ( ( rule__Cluster__NodesAssignment_3_0_4_1 ) ) ;
    public final void rule__Cluster__Group_3_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1186:1: ( ( ( rule__Cluster__NodesAssignment_3_0_4_1 ) ) )
            // InternalGoatInfrastructureParser.g:1187:1: ( ( rule__Cluster__NodesAssignment_3_0_4_1 ) )
            {
            // InternalGoatInfrastructureParser.g:1187:1: ( ( rule__Cluster__NodesAssignment_3_0_4_1 ) )
            // InternalGoatInfrastructureParser.g:1188:2: ( rule__Cluster__NodesAssignment_3_0_4_1 )
            {
             before(grammarAccess.getClusterAccess().getNodesAssignment_3_0_4_1()); 
            // InternalGoatInfrastructureParser.g:1189:2: ( rule__Cluster__NodesAssignment_3_0_4_1 )
            // InternalGoatInfrastructureParser.g:1189:3: rule__Cluster__NodesAssignment_3_0_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__NodesAssignment_3_0_4_1();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getNodesAssignment_3_0_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group_3_0_4__1__Impl"


    // $ANTLR start "rule__Ring__Group_0__0"
    // InternalGoatInfrastructureParser.g:1198:1: rule__Ring__Group_0__0 : rule__Ring__Group_0__0__Impl rule__Ring__Group_0__1 ;
    public final void rule__Ring__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1202:1: ( rule__Ring__Group_0__0__Impl rule__Ring__Group_0__1 )
            // InternalGoatInfrastructureParser.g:1203:2: rule__Ring__Group_0__0__Impl rule__Ring__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__Ring__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__0"


    // $ANTLR start "rule__Ring__Group_0__0__Impl"
    // InternalGoatInfrastructureParser.g:1210:1: rule__Ring__Group_0__0__Impl : ( Ring ) ;
    public final void rule__Ring__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1214:1: ( ( Ring ) )
            // InternalGoatInfrastructureParser.g:1215:1: ( Ring )
            {
            // InternalGoatInfrastructureParser.g:1215:1: ( Ring )
            // InternalGoatInfrastructureParser.g:1216:2: Ring
            {
             before(grammarAccess.getRingAccess().getRingKeyword_0_0()); 
            match(input,Ring,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getRingKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__0__Impl"


    // $ANTLR start "rule__Ring__Group_0__1"
    // InternalGoatInfrastructureParser.g:1225:1: rule__Ring__Group_0__1 : rule__Ring__Group_0__1__Impl rule__Ring__Group_0__2 ;
    public final void rule__Ring__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1229:1: ( rule__Ring__Group_0__1__Impl rule__Ring__Group_0__2 )
            // InternalGoatInfrastructureParser.g:1230:2: rule__Ring__Group_0__1__Impl rule__Ring__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__Ring__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__1"


    // $ANTLR start "rule__Ring__Group_0__1__Impl"
    // InternalGoatInfrastructureParser.g:1237:1: rule__Ring__Group_0__1__Impl : ( ( rule__Ring__NameAssignment_0_1 ) ) ;
    public final void rule__Ring__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1241:1: ( ( ( rule__Ring__NameAssignment_0_1 ) ) )
            // InternalGoatInfrastructureParser.g:1242:1: ( ( rule__Ring__NameAssignment_0_1 ) )
            {
            // InternalGoatInfrastructureParser.g:1242:1: ( ( rule__Ring__NameAssignment_0_1 ) )
            // InternalGoatInfrastructureParser.g:1243:2: ( rule__Ring__NameAssignment_0_1 )
            {
             before(grammarAccess.getRingAccess().getNameAssignment_0_1()); 
            // InternalGoatInfrastructureParser.g:1244:2: ( rule__Ring__NameAssignment_0_1 )
            // InternalGoatInfrastructureParser.g:1244:3: rule__Ring__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Ring__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__1__Impl"


    // $ANTLR start "rule__Ring__Group_0__2"
    // InternalGoatInfrastructureParser.g:1252:1: rule__Ring__Group_0__2 : rule__Ring__Group_0__2__Impl rule__Ring__Group_0__3 ;
    public final void rule__Ring__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1256:1: ( rule__Ring__Group_0__2__Impl rule__Ring__Group_0__3 )
            // InternalGoatInfrastructureParser.g:1257:2: rule__Ring__Group_0__2__Impl rule__Ring__Group_0__3
            {
            pushFollow(FOLLOW_14);
            rule__Ring__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__2"


    // $ANTLR start "rule__Ring__Group_0__2__Impl"
    // InternalGoatInfrastructureParser.g:1264:1: rule__Ring__Group_0__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__Ring__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1268:1: ( ( LeftCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:1269:1: ( LeftCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:1269:1: ( LeftCurlyBracket )
            // InternalGoatInfrastructureParser.g:1270:2: LeftCurlyBracket
            {
             before(grammarAccess.getRingAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getLeftCurlyBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__2__Impl"


    // $ANTLR start "rule__Ring__Group_0__3"
    // InternalGoatInfrastructureParser.g:1279:1: rule__Ring__Group_0__3 : rule__Ring__Group_0__3__Impl ;
    public final void rule__Ring__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1283:1: ( rule__Ring__Group_0__3__Impl )
            // InternalGoatInfrastructureParser.g:1284:2: rule__Ring__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__3"


    // $ANTLR start "rule__Ring__Group_0__3__Impl"
    // InternalGoatInfrastructureParser.g:1290:1: rule__Ring__Group_0__3__Impl : ( ( rule__Ring__Group_0_3__0 ) ) ;
    public final void rule__Ring__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1294:1: ( ( ( rule__Ring__Group_0_3__0 ) ) )
            // InternalGoatInfrastructureParser.g:1295:1: ( ( rule__Ring__Group_0_3__0 ) )
            {
            // InternalGoatInfrastructureParser.g:1295:1: ( ( rule__Ring__Group_0_3__0 ) )
            // InternalGoatInfrastructureParser.g:1296:2: ( rule__Ring__Group_0_3__0 )
            {
             before(grammarAccess.getRingAccess().getGroup_0_3()); 
            // InternalGoatInfrastructureParser.g:1297:2: ( rule__Ring__Group_0_3__0 )
            // InternalGoatInfrastructureParser.g:1297:3: rule__Ring__Group_0_3__0
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_0_3__0();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getGroup_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0__3__Impl"


    // $ANTLR start "rule__Ring__Group_0_3__0"
    // InternalGoatInfrastructureParser.g:1306:1: rule__Ring__Group_0_3__0 : rule__Ring__Group_0_3__0__Impl rule__Ring__Group_0_3__1 ;
    public final void rule__Ring__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1310:1: ( rule__Ring__Group_0_3__0__Impl rule__Ring__Group_0_3__1 )
            // InternalGoatInfrastructureParser.g:1311:2: rule__Ring__Group_0_3__0__Impl rule__Ring__Group_0_3__1
            {
            pushFollow(FOLLOW_6);
            rule__Ring__Group_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_0_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0_3__0"


    // $ANTLR start "rule__Ring__Group_0_3__0__Impl"
    // InternalGoatInfrastructureParser.g:1318:1: rule__Ring__Group_0_3__0__Impl : ( Registration ) ;
    public final void rule__Ring__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1322:1: ( ( Registration ) )
            // InternalGoatInfrastructureParser.g:1323:1: ( Registration )
            {
            // InternalGoatInfrastructureParser.g:1323:1: ( Registration )
            // InternalGoatInfrastructureParser.g:1324:2: Registration
            {
             before(grammarAccess.getRingAccess().getRegistrationKeyword_0_3_0()); 
            match(input,Registration,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getRegistrationKeyword_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0_3__0__Impl"


    // $ANTLR start "rule__Ring__Group_0_3__1"
    // InternalGoatInfrastructureParser.g:1333:1: rule__Ring__Group_0_3__1 : rule__Ring__Group_0_3__1__Impl rule__Ring__Group_0_3__2 ;
    public final void rule__Ring__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1337:1: ( rule__Ring__Group_0_3__1__Impl rule__Ring__Group_0_3__2 )
            // InternalGoatInfrastructureParser.g:1338:2: rule__Ring__Group_0_3__1__Impl rule__Ring__Group_0_3__2
            {
            pushFollow(FOLLOW_7);
            rule__Ring__Group_0_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_0_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0_3__1"


    // $ANTLR start "rule__Ring__Group_0_3__1__Impl"
    // InternalGoatInfrastructureParser.g:1345:1: rule__Ring__Group_0_3__1__Impl : ( Colon ) ;
    public final void rule__Ring__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1349:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:1350:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:1350:1: ( Colon )
            // InternalGoatInfrastructureParser.g:1351:2: Colon
            {
             before(grammarAccess.getRingAccess().getColonKeyword_0_3_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getColonKeyword_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0_3__1__Impl"


    // $ANTLR start "rule__Ring__Group_0_3__2"
    // InternalGoatInfrastructureParser.g:1360:1: rule__Ring__Group_0_3__2 : rule__Ring__Group_0_3__2__Impl ;
    public final void rule__Ring__Group_0_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1364:1: ( rule__Ring__Group_0_3__2__Impl )
            // InternalGoatInfrastructureParser.g:1365:2: rule__Ring__Group_0_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_0_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0_3__2"


    // $ANTLR start "rule__Ring__Group_0_3__2__Impl"
    // InternalGoatInfrastructureParser.g:1371:1: rule__Ring__Group_0_3__2__Impl : ( ( rule__Ring__RegistrationAssignment_0_3_2 ) ) ;
    public final void rule__Ring__Group_0_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1375:1: ( ( ( rule__Ring__RegistrationAssignment_0_3_2 ) ) )
            // InternalGoatInfrastructureParser.g:1376:1: ( ( rule__Ring__RegistrationAssignment_0_3_2 ) )
            {
            // InternalGoatInfrastructureParser.g:1376:1: ( ( rule__Ring__RegistrationAssignment_0_3_2 ) )
            // InternalGoatInfrastructureParser.g:1377:2: ( rule__Ring__RegistrationAssignment_0_3_2 )
            {
             before(grammarAccess.getRingAccess().getRegistrationAssignment_0_3_2()); 
            // InternalGoatInfrastructureParser.g:1378:2: ( rule__Ring__RegistrationAssignment_0_3_2 )
            // InternalGoatInfrastructureParser.g:1378:3: rule__Ring__RegistrationAssignment_0_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Ring__RegistrationAssignment_0_3_2();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getRegistrationAssignment_0_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_0_3__2__Impl"


    // $ANTLR start "rule__Ring__Group_1__0"
    // InternalGoatInfrastructureParser.g:1387:1: rule__Ring__Group_1__0 : rule__Ring__Group_1__0__Impl rule__Ring__Group_1__1 ;
    public final void rule__Ring__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1391:1: ( rule__Ring__Group_1__0__Impl rule__Ring__Group_1__1 )
            // InternalGoatInfrastructureParser.g:1392:2: rule__Ring__Group_1__0__Impl rule__Ring__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__Ring__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_1__0"


    // $ANTLR start "rule__Ring__Group_1__0__Impl"
    // InternalGoatInfrastructureParser.g:1399:1: rule__Ring__Group_1__0__Impl : ( Mid_assigner ) ;
    public final void rule__Ring__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1403:1: ( ( Mid_assigner ) )
            // InternalGoatInfrastructureParser.g:1404:1: ( Mid_assigner )
            {
            // InternalGoatInfrastructureParser.g:1404:1: ( Mid_assigner )
            // InternalGoatInfrastructureParser.g:1405:2: Mid_assigner
            {
             before(grammarAccess.getRingAccess().getMid_assignerKeyword_1_0()); 
            match(input,Mid_assigner,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getMid_assignerKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_1__0__Impl"


    // $ANTLR start "rule__Ring__Group_1__1"
    // InternalGoatInfrastructureParser.g:1414:1: rule__Ring__Group_1__1 : rule__Ring__Group_1__1__Impl rule__Ring__Group_1__2 ;
    public final void rule__Ring__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1418:1: ( rule__Ring__Group_1__1__Impl rule__Ring__Group_1__2 )
            // InternalGoatInfrastructureParser.g:1419:2: rule__Ring__Group_1__1__Impl rule__Ring__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Ring__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_1__1"


    // $ANTLR start "rule__Ring__Group_1__1__Impl"
    // InternalGoatInfrastructureParser.g:1426:1: rule__Ring__Group_1__1__Impl : ( Colon ) ;
    public final void rule__Ring__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1430:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:1431:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:1431:1: ( Colon )
            // InternalGoatInfrastructureParser.g:1432:2: Colon
            {
             before(grammarAccess.getRingAccess().getColonKeyword_1_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_1__1__Impl"


    // $ANTLR start "rule__Ring__Group_1__2"
    // InternalGoatInfrastructureParser.g:1441:1: rule__Ring__Group_1__2 : rule__Ring__Group_1__2__Impl ;
    public final void rule__Ring__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1445:1: ( rule__Ring__Group_1__2__Impl )
            // InternalGoatInfrastructureParser.g:1446:2: rule__Ring__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_1__2"


    // $ANTLR start "rule__Ring__Group_1__2__Impl"
    // InternalGoatInfrastructureParser.g:1452:1: rule__Ring__Group_1__2__Impl : ( ( rule__Ring__Mid_assignerAssignment_1_2 ) ) ;
    public final void rule__Ring__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1456:1: ( ( ( rule__Ring__Mid_assignerAssignment_1_2 ) ) )
            // InternalGoatInfrastructureParser.g:1457:1: ( ( rule__Ring__Mid_assignerAssignment_1_2 ) )
            {
            // InternalGoatInfrastructureParser.g:1457:1: ( ( rule__Ring__Mid_assignerAssignment_1_2 ) )
            // InternalGoatInfrastructureParser.g:1458:2: ( rule__Ring__Mid_assignerAssignment_1_2 )
            {
             before(grammarAccess.getRingAccess().getMid_assignerAssignment_1_2()); 
            // InternalGoatInfrastructureParser.g:1459:2: ( rule__Ring__Mid_assignerAssignment_1_2 )
            // InternalGoatInfrastructureParser.g:1459:3: rule__Ring__Mid_assignerAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Mid_assignerAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getMid_assignerAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_1__2__Impl"


    // $ANTLR start "rule__Ring__Group_2__0"
    // InternalGoatInfrastructureParser.g:1468:1: rule__Ring__Group_2__0 : rule__Ring__Group_2__0__Impl rule__Ring__Group_2__1 ;
    public final void rule__Ring__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1472:1: ( rule__Ring__Group_2__0__Impl rule__Ring__Group_2__1 )
            // InternalGoatInfrastructureParser.g:1473:2: rule__Ring__Group_2__0__Impl rule__Ring__Group_2__1
            {
            pushFollow(FOLLOW_8);
            rule__Ring__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2__0"


    // $ANTLR start "rule__Ring__Group_2__0__Impl"
    // InternalGoatInfrastructureParser.g:1480:1: rule__Ring__Group_2__0__Impl : ( ( rule__Ring__Group_2_0__0 ) ) ;
    public final void rule__Ring__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1484:1: ( ( ( rule__Ring__Group_2_0__0 ) ) )
            // InternalGoatInfrastructureParser.g:1485:1: ( ( rule__Ring__Group_2_0__0 ) )
            {
            // InternalGoatInfrastructureParser.g:1485:1: ( ( rule__Ring__Group_2_0__0 ) )
            // InternalGoatInfrastructureParser.g:1486:2: ( rule__Ring__Group_2_0__0 )
            {
             before(grammarAccess.getRingAccess().getGroup_2_0()); 
            // InternalGoatInfrastructureParser.g:1487:2: ( rule__Ring__Group_2_0__0 )
            // InternalGoatInfrastructureParser.g:1487:3: rule__Ring__Group_2_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0__0();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getGroup_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2__0__Impl"


    // $ANTLR start "rule__Ring__Group_2__1"
    // InternalGoatInfrastructureParser.g:1495:1: rule__Ring__Group_2__1 : rule__Ring__Group_2__1__Impl ;
    public final void rule__Ring__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1499:1: ( rule__Ring__Group_2__1__Impl )
            // InternalGoatInfrastructureParser.g:1500:2: rule__Ring__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2__1"


    // $ANTLR start "rule__Ring__Group_2__1__Impl"
    // InternalGoatInfrastructureParser.g:1506:1: rule__Ring__Group_2__1__Impl : ( RightCurlyBracket ) ;
    public final void rule__Ring__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1510:1: ( ( RightCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:1511:1: ( RightCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:1511:1: ( RightCurlyBracket )
            // InternalGoatInfrastructureParser.g:1512:2: RightCurlyBracket
            {
             before(grammarAccess.getRingAccess().getRightCurlyBracketKeyword_2_1()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getRightCurlyBracketKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2__1__Impl"


    // $ANTLR start "rule__Ring__Group_2_0__0"
    // InternalGoatInfrastructureParser.g:1522:1: rule__Ring__Group_2_0__0 : rule__Ring__Group_2_0__0__Impl rule__Ring__Group_2_0__1 ;
    public final void rule__Ring__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1526:1: ( rule__Ring__Group_2_0__0__Impl rule__Ring__Group_2_0__1 )
            // InternalGoatInfrastructureParser.g:1527:2: rule__Ring__Group_2_0__0__Impl rule__Ring__Group_2_0__1
            {
            pushFollow(FOLLOW_6);
            rule__Ring__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__0"


    // $ANTLR start "rule__Ring__Group_2_0__0__Impl"
    // InternalGoatInfrastructureParser.g:1534:1: rule__Ring__Group_2_0__0__Impl : ( Nodes ) ;
    public final void rule__Ring__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1538:1: ( ( Nodes ) )
            // InternalGoatInfrastructureParser.g:1539:1: ( Nodes )
            {
            // InternalGoatInfrastructureParser.g:1539:1: ( Nodes )
            // InternalGoatInfrastructureParser.g:1540:2: Nodes
            {
             before(grammarAccess.getRingAccess().getNodesKeyword_2_0_0()); 
            match(input,Nodes,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getNodesKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__0__Impl"


    // $ANTLR start "rule__Ring__Group_2_0__1"
    // InternalGoatInfrastructureParser.g:1549:1: rule__Ring__Group_2_0__1 : rule__Ring__Group_2_0__1__Impl rule__Ring__Group_2_0__2 ;
    public final void rule__Ring__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1553:1: ( rule__Ring__Group_2_0__1__Impl rule__Ring__Group_2_0__2 )
            // InternalGoatInfrastructureParser.g:1554:2: rule__Ring__Group_2_0__1__Impl rule__Ring__Group_2_0__2
            {
            pushFollow(FOLLOW_11);
            rule__Ring__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__1"


    // $ANTLR start "rule__Ring__Group_2_0__1__Impl"
    // InternalGoatInfrastructureParser.g:1561:1: rule__Ring__Group_2_0__1__Impl : ( Colon ) ;
    public final void rule__Ring__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1565:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:1566:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:1566:1: ( Colon )
            // InternalGoatInfrastructureParser.g:1567:2: Colon
            {
             before(grammarAccess.getRingAccess().getColonKeyword_2_0_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getColonKeyword_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__1__Impl"


    // $ANTLR start "rule__Ring__Group_2_0__2"
    // InternalGoatInfrastructureParser.g:1576:1: rule__Ring__Group_2_0__2 : rule__Ring__Group_2_0__2__Impl rule__Ring__Group_2_0__3 ;
    public final void rule__Ring__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1580:1: ( rule__Ring__Group_2_0__2__Impl rule__Ring__Group_2_0__3 )
            // InternalGoatInfrastructureParser.g:1581:2: rule__Ring__Group_2_0__2__Impl rule__Ring__Group_2_0__3
            {
            pushFollow(FOLLOW_7);
            rule__Ring__Group_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__2"


    // $ANTLR start "rule__Ring__Group_2_0__2__Impl"
    // InternalGoatInfrastructureParser.g:1588:1: rule__Ring__Group_2_0__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Ring__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1592:1: ( ( LeftSquareBracket ) )
            // InternalGoatInfrastructureParser.g:1593:1: ( LeftSquareBracket )
            {
            // InternalGoatInfrastructureParser.g:1593:1: ( LeftSquareBracket )
            // InternalGoatInfrastructureParser.g:1594:2: LeftSquareBracket
            {
             before(grammarAccess.getRingAccess().getLeftSquareBracketKeyword_2_0_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getLeftSquareBracketKeyword_2_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__2__Impl"


    // $ANTLR start "rule__Ring__Group_2_0__3"
    // InternalGoatInfrastructureParser.g:1603:1: rule__Ring__Group_2_0__3 : rule__Ring__Group_2_0__3__Impl rule__Ring__Group_2_0__4 ;
    public final void rule__Ring__Group_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1607:1: ( rule__Ring__Group_2_0__3__Impl rule__Ring__Group_2_0__4 )
            // InternalGoatInfrastructureParser.g:1608:2: rule__Ring__Group_2_0__3__Impl rule__Ring__Group_2_0__4
            {
            pushFollow(FOLLOW_12);
            rule__Ring__Group_2_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__3"


    // $ANTLR start "rule__Ring__Group_2_0__3__Impl"
    // InternalGoatInfrastructureParser.g:1615:1: rule__Ring__Group_2_0__3__Impl : ( ( rule__Ring__NodesAssignment_2_0_3 ) ) ;
    public final void rule__Ring__Group_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1619:1: ( ( ( rule__Ring__NodesAssignment_2_0_3 ) ) )
            // InternalGoatInfrastructureParser.g:1620:1: ( ( rule__Ring__NodesAssignment_2_0_3 ) )
            {
            // InternalGoatInfrastructureParser.g:1620:1: ( ( rule__Ring__NodesAssignment_2_0_3 ) )
            // InternalGoatInfrastructureParser.g:1621:2: ( rule__Ring__NodesAssignment_2_0_3 )
            {
             before(grammarAccess.getRingAccess().getNodesAssignment_2_0_3()); 
            // InternalGoatInfrastructureParser.g:1622:2: ( rule__Ring__NodesAssignment_2_0_3 )
            // InternalGoatInfrastructureParser.g:1622:3: rule__Ring__NodesAssignment_2_0_3
            {
            pushFollow(FOLLOW_2);
            rule__Ring__NodesAssignment_2_0_3();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getNodesAssignment_2_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__3__Impl"


    // $ANTLR start "rule__Ring__Group_2_0__4"
    // InternalGoatInfrastructureParser.g:1630:1: rule__Ring__Group_2_0__4 : rule__Ring__Group_2_0__4__Impl rule__Ring__Group_2_0__5 ;
    public final void rule__Ring__Group_2_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1634:1: ( rule__Ring__Group_2_0__4__Impl rule__Ring__Group_2_0__5 )
            // InternalGoatInfrastructureParser.g:1635:2: rule__Ring__Group_2_0__4__Impl rule__Ring__Group_2_0__5
            {
            pushFollow(FOLLOW_12);
            rule__Ring__Group_2_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__4"


    // $ANTLR start "rule__Ring__Group_2_0__4__Impl"
    // InternalGoatInfrastructureParser.g:1642:1: rule__Ring__Group_2_0__4__Impl : ( ( rule__Ring__Group_2_0_4__0 )* ) ;
    public final void rule__Ring__Group_2_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1646:1: ( ( ( rule__Ring__Group_2_0_4__0 )* ) )
            // InternalGoatInfrastructureParser.g:1647:1: ( ( rule__Ring__Group_2_0_4__0 )* )
            {
            // InternalGoatInfrastructureParser.g:1647:1: ( ( rule__Ring__Group_2_0_4__0 )* )
            // InternalGoatInfrastructureParser.g:1648:2: ( rule__Ring__Group_2_0_4__0 )*
            {
             before(grammarAccess.getRingAccess().getGroup_2_0_4()); 
            // InternalGoatInfrastructureParser.g:1649:2: ( rule__Ring__Group_2_0_4__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Comma) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalGoatInfrastructureParser.g:1649:3: rule__Ring__Group_2_0_4__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Ring__Group_2_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getRingAccess().getGroup_2_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__4__Impl"


    // $ANTLR start "rule__Ring__Group_2_0__5"
    // InternalGoatInfrastructureParser.g:1657:1: rule__Ring__Group_2_0__5 : rule__Ring__Group_2_0__5__Impl ;
    public final void rule__Ring__Group_2_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1661:1: ( rule__Ring__Group_2_0__5__Impl )
            // InternalGoatInfrastructureParser.g:1662:2: rule__Ring__Group_2_0__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__5"


    // $ANTLR start "rule__Ring__Group_2_0__5__Impl"
    // InternalGoatInfrastructureParser.g:1668:1: rule__Ring__Group_2_0__5__Impl : ( RightSquareBracket ) ;
    public final void rule__Ring__Group_2_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1672:1: ( ( RightSquareBracket ) )
            // InternalGoatInfrastructureParser.g:1673:1: ( RightSquareBracket )
            {
            // InternalGoatInfrastructureParser.g:1673:1: ( RightSquareBracket )
            // InternalGoatInfrastructureParser.g:1674:2: RightSquareBracket
            {
             before(grammarAccess.getRingAccess().getRightSquareBracketKeyword_2_0_5()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getRightSquareBracketKeyword_2_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0__5__Impl"


    // $ANTLR start "rule__Ring__Group_2_0_4__0"
    // InternalGoatInfrastructureParser.g:1684:1: rule__Ring__Group_2_0_4__0 : rule__Ring__Group_2_0_4__0__Impl rule__Ring__Group_2_0_4__1 ;
    public final void rule__Ring__Group_2_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1688:1: ( rule__Ring__Group_2_0_4__0__Impl rule__Ring__Group_2_0_4__1 )
            // InternalGoatInfrastructureParser.g:1689:2: rule__Ring__Group_2_0_4__0__Impl rule__Ring__Group_2_0_4__1
            {
            pushFollow(FOLLOW_7);
            rule__Ring__Group_2_0_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0_4__0"


    // $ANTLR start "rule__Ring__Group_2_0_4__0__Impl"
    // InternalGoatInfrastructureParser.g:1696:1: rule__Ring__Group_2_0_4__0__Impl : ( Comma ) ;
    public final void rule__Ring__Group_2_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1700:1: ( ( Comma ) )
            // InternalGoatInfrastructureParser.g:1701:1: ( Comma )
            {
            // InternalGoatInfrastructureParser.g:1701:1: ( Comma )
            // InternalGoatInfrastructureParser.g:1702:2: Comma
            {
             before(grammarAccess.getRingAccess().getCommaKeyword_2_0_4_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getCommaKeyword_2_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0_4__0__Impl"


    // $ANTLR start "rule__Ring__Group_2_0_4__1"
    // InternalGoatInfrastructureParser.g:1711:1: rule__Ring__Group_2_0_4__1 : rule__Ring__Group_2_0_4__1__Impl ;
    public final void rule__Ring__Group_2_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1715:1: ( rule__Ring__Group_2_0_4__1__Impl )
            // InternalGoatInfrastructureParser.g:1716:2: rule__Ring__Group_2_0_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ring__Group_2_0_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0_4__1"


    // $ANTLR start "rule__Ring__Group_2_0_4__1__Impl"
    // InternalGoatInfrastructureParser.g:1722:1: rule__Ring__Group_2_0_4__1__Impl : ( ( rule__Ring__NodesAssignment_2_0_4_1 ) ) ;
    public final void rule__Ring__Group_2_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1726:1: ( ( ( rule__Ring__NodesAssignment_2_0_4_1 ) ) )
            // InternalGoatInfrastructureParser.g:1727:1: ( ( rule__Ring__NodesAssignment_2_0_4_1 ) )
            {
            // InternalGoatInfrastructureParser.g:1727:1: ( ( rule__Ring__NodesAssignment_2_0_4_1 ) )
            // InternalGoatInfrastructureParser.g:1728:2: ( rule__Ring__NodesAssignment_2_0_4_1 )
            {
             before(grammarAccess.getRingAccess().getNodesAssignment_2_0_4_1()); 
            // InternalGoatInfrastructureParser.g:1729:2: ( rule__Ring__NodesAssignment_2_0_4_1 )
            // InternalGoatInfrastructureParser.g:1729:3: rule__Ring__NodesAssignment_2_0_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Ring__NodesAssignment_2_0_4_1();

            state._fsp--;


            }

             after(grammarAccess.getRingAccess().getNodesAssignment_2_0_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Group_2_0_4__1__Impl"


    // $ANTLR start "rule__Tree__Group_0__0"
    // InternalGoatInfrastructureParser.g:1738:1: rule__Tree__Group_0__0 : rule__Tree__Group_0__0__Impl rule__Tree__Group_0__1 ;
    public final void rule__Tree__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1742:1: ( rule__Tree__Group_0__0__Impl rule__Tree__Group_0__1 )
            // InternalGoatInfrastructureParser.g:1743:2: rule__Tree__Group_0__0__Impl rule__Tree__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__Tree__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__0"


    // $ANTLR start "rule__Tree__Group_0__0__Impl"
    // InternalGoatInfrastructureParser.g:1750:1: rule__Tree__Group_0__0__Impl : ( Tree ) ;
    public final void rule__Tree__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1754:1: ( ( Tree ) )
            // InternalGoatInfrastructureParser.g:1755:1: ( Tree )
            {
            // InternalGoatInfrastructureParser.g:1755:1: ( Tree )
            // InternalGoatInfrastructureParser.g:1756:2: Tree
            {
             before(grammarAccess.getTreeAccess().getTreeKeyword_0_0()); 
            match(input,Tree,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getTreeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__0__Impl"


    // $ANTLR start "rule__Tree__Group_0__1"
    // InternalGoatInfrastructureParser.g:1765:1: rule__Tree__Group_0__1 : rule__Tree__Group_0__1__Impl rule__Tree__Group_0__2 ;
    public final void rule__Tree__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1769:1: ( rule__Tree__Group_0__1__Impl rule__Tree__Group_0__2 )
            // InternalGoatInfrastructureParser.g:1770:2: rule__Tree__Group_0__1__Impl rule__Tree__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__Tree__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__1"


    // $ANTLR start "rule__Tree__Group_0__1__Impl"
    // InternalGoatInfrastructureParser.g:1777:1: rule__Tree__Group_0__1__Impl : ( ( rule__Tree__NameAssignment_0_1 ) ) ;
    public final void rule__Tree__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1781:1: ( ( ( rule__Tree__NameAssignment_0_1 ) ) )
            // InternalGoatInfrastructureParser.g:1782:1: ( ( rule__Tree__NameAssignment_0_1 ) )
            {
            // InternalGoatInfrastructureParser.g:1782:1: ( ( rule__Tree__NameAssignment_0_1 ) )
            // InternalGoatInfrastructureParser.g:1783:2: ( rule__Tree__NameAssignment_0_1 )
            {
             before(grammarAccess.getTreeAccess().getNameAssignment_0_1()); 
            // InternalGoatInfrastructureParser.g:1784:2: ( rule__Tree__NameAssignment_0_1 )
            // InternalGoatInfrastructureParser.g:1784:3: rule__Tree__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Tree__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTreeAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__1__Impl"


    // $ANTLR start "rule__Tree__Group_0__2"
    // InternalGoatInfrastructureParser.g:1792:1: rule__Tree__Group_0__2 : rule__Tree__Group_0__2__Impl rule__Tree__Group_0__3 ;
    public final void rule__Tree__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1796:1: ( rule__Tree__Group_0__2__Impl rule__Tree__Group_0__3 )
            // InternalGoatInfrastructureParser.g:1797:2: rule__Tree__Group_0__2__Impl rule__Tree__Group_0__3
            {
            pushFollow(FOLLOW_14);
            rule__Tree__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__2"


    // $ANTLR start "rule__Tree__Group_0__2__Impl"
    // InternalGoatInfrastructureParser.g:1804:1: rule__Tree__Group_0__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__Tree__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1808:1: ( ( LeftCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:1809:1: ( LeftCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:1809:1: ( LeftCurlyBracket )
            // InternalGoatInfrastructureParser.g:1810:2: LeftCurlyBracket
            {
             before(grammarAccess.getTreeAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getLeftCurlyBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__2__Impl"


    // $ANTLR start "rule__Tree__Group_0__3"
    // InternalGoatInfrastructureParser.g:1819:1: rule__Tree__Group_0__3 : rule__Tree__Group_0__3__Impl ;
    public final void rule__Tree__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1823:1: ( rule__Tree__Group_0__3__Impl )
            // InternalGoatInfrastructureParser.g:1824:2: rule__Tree__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__3"


    // $ANTLR start "rule__Tree__Group_0__3__Impl"
    // InternalGoatInfrastructureParser.g:1830:1: rule__Tree__Group_0__3__Impl : ( ( rule__Tree__Group_0_3__0 ) ) ;
    public final void rule__Tree__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1834:1: ( ( ( rule__Tree__Group_0_3__0 ) ) )
            // InternalGoatInfrastructureParser.g:1835:1: ( ( rule__Tree__Group_0_3__0 ) )
            {
            // InternalGoatInfrastructureParser.g:1835:1: ( ( rule__Tree__Group_0_3__0 ) )
            // InternalGoatInfrastructureParser.g:1836:2: ( rule__Tree__Group_0_3__0 )
            {
             before(grammarAccess.getTreeAccess().getGroup_0_3()); 
            // InternalGoatInfrastructureParser.g:1837:2: ( rule__Tree__Group_0_3__0 )
            // InternalGoatInfrastructureParser.g:1837:3: rule__Tree__Group_0_3__0
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group_0_3__0();

            state._fsp--;


            }

             after(grammarAccess.getTreeAccess().getGroup_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0__3__Impl"


    // $ANTLR start "rule__Tree__Group_0_3__0"
    // InternalGoatInfrastructureParser.g:1846:1: rule__Tree__Group_0_3__0 : rule__Tree__Group_0_3__0__Impl rule__Tree__Group_0_3__1 ;
    public final void rule__Tree__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1850:1: ( rule__Tree__Group_0_3__0__Impl rule__Tree__Group_0_3__1 )
            // InternalGoatInfrastructureParser.g:1851:2: rule__Tree__Group_0_3__0__Impl rule__Tree__Group_0_3__1
            {
            pushFollow(FOLLOW_6);
            rule__Tree__Group_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_0_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0_3__0"


    // $ANTLR start "rule__Tree__Group_0_3__0__Impl"
    // InternalGoatInfrastructureParser.g:1858:1: rule__Tree__Group_0_3__0__Impl : ( Registration ) ;
    public final void rule__Tree__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1862:1: ( ( Registration ) )
            // InternalGoatInfrastructureParser.g:1863:1: ( Registration )
            {
            // InternalGoatInfrastructureParser.g:1863:1: ( Registration )
            // InternalGoatInfrastructureParser.g:1864:2: Registration
            {
             before(grammarAccess.getTreeAccess().getRegistrationKeyword_0_3_0()); 
            match(input,Registration,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getRegistrationKeyword_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0_3__0__Impl"


    // $ANTLR start "rule__Tree__Group_0_3__1"
    // InternalGoatInfrastructureParser.g:1873:1: rule__Tree__Group_0_3__1 : rule__Tree__Group_0_3__1__Impl rule__Tree__Group_0_3__2 ;
    public final void rule__Tree__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1877:1: ( rule__Tree__Group_0_3__1__Impl rule__Tree__Group_0_3__2 )
            // InternalGoatInfrastructureParser.g:1878:2: rule__Tree__Group_0_3__1__Impl rule__Tree__Group_0_3__2
            {
            pushFollow(FOLLOW_7);
            rule__Tree__Group_0_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_0_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0_3__1"


    // $ANTLR start "rule__Tree__Group_0_3__1__Impl"
    // InternalGoatInfrastructureParser.g:1885:1: rule__Tree__Group_0_3__1__Impl : ( Colon ) ;
    public final void rule__Tree__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1889:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:1890:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:1890:1: ( Colon )
            // InternalGoatInfrastructureParser.g:1891:2: Colon
            {
             before(grammarAccess.getTreeAccess().getColonKeyword_0_3_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getColonKeyword_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0_3__1__Impl"


    // $ANTLR start "rule__Tree__Group_0_3__2"
    // InternalGoatInfrastructureParser.g:1900:1: rule__Tree__Group_0_3__2 : rule__Tree__Group_0_3__2__Impl ;
    public final void rule__Tree__Group_0_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1904:1: ( rule__Tree__Group_0_3__2__Impl )
            // InternalGoatInfrastructureParser.g:1905:2: rule__Tree__Group_0_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group_0_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0_3__2"


    // $ANTLR start "rule__Tree__Group_0_3__2__Impl"
    // InternalGoatInfrastructureParser.g:1911:1: rule__Tree__Group_0_3__2__Impl : ( ( rule__Tree__RegistrationAssignment_0_3_2 ) ) ;
    public final void rule__Tree__Group_0_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1915:1: ( ( ( rule__Tree__RegistrationAssignment_0_3_2 ) ) )
            // InternalGoatInfrastructureParser.g:1916:1: ( ( rule__Tree__RegistrationAssignment_0_3_2 ) )
            {
            // InternalGoatInfrastructureParser.g:1916:1: ( ( rule__Tree__RegistrationAssignment_0_3_2 ) )
            // InternalGoatInfrastructureParser.g:1917:2: ( rule__Tree__RegistrationAssignment_0_3_2 )
            {
             before(grammarAccess.getTreeAccess().getRegistrationAssignment_0_3_2()); 
            // InternalGoatInfrastructureParser.g:1918:2: ( rule__Tree__RegistrationAssignment_0_3_2 )
            // InternalGoatInfrastructureParser.g:1918:3: rule__Tree__RegistrationAssignment_0_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Tree__RegistrationAssignment_0_3_2();

            state._fsp--;


            }

             after(grammarAccess.getTreeAccess().getRegistrationAssignment_0_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_0_3__2__Impl"


    // $ANTLR start "rule__Tree__Group_1__0"
    // InternalGoatInfrastructureParser.g:1927:1: rule__Tree__Group_1__0 : rule__Tree__Group_1__0__Impl rule__Tree__Group_1__1 ;
    public final void rule__Tree__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1931:1: ( rule__Tree__Group_1__0__Impl rule__Tree__Group_1__1 )
            // InternalGoatInfrastructureParser.g:1932:2: rule__Tree__Group_1__0__Impl rule__Tree__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Tree__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1__0"


    // $ANTLR start "rule__Tree__Group_1__0__Impl"
    // InternalGoatInfrastructureParser.g:1939:1: rule__Tree__Group_1__0__Impl : ( ( rule__Tree__Group_1_0__0 ) ) ;
    public final void rule__Tree__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1943:1: ( ( ( rule__Tree__Group_1_0__0 ) ) )
            // InternalGoatInfrastructureParser.g:1944:1: ( ( rule__Tree__Group_1_0__0 ) )
            {
            // InternalGoatInfrastructureParser.g:1944:1: ( ( rule__Tree__Group_1_0__0 ) )
            // InternalGoatInfrastructureParser.g:1945:2: ( rule__Tree__Group_1_0__0 )
            {
             before(grammarAccess.getTreeAccess().getGroup_1_0()); 
            // InternalGoatInfrastructureParser.g:1946:2: ( rule__Tree__Group_1_0__0 )
            // InternalGoatInfrastructureParser.g:1946:3: rule__Tree__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group_1_0__0();

            state._fsp--;


            }

             after(grammarAccess.getTreeAccess().getGroup_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1__0__Impl"


    // $ANTLR start "rule__Tree__Group_1__1"
    // InternalGoatInfrastructureParser.g:1954:1: rule__Tree__Group_1__1 : rule__Tree__Group_1__1__Impl ;
    public final void rule__Tree__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1958:1: ( rule__Tree__Group_1__1__Impl )
            // InternalGoatInfrastructureParser.g:1959:2: rule__Tree__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1__1"


    // $ANTLR start "rule__Tree__Group_1__1__Impl"
    // InternalGoatInfrastructureParser.g:1965:1: rule__Tree__Group_1__1__Impl : ( RightCurlyBracket ) ;
    public final void rule__Tree__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1969:1: ( ( RightCurlyBracket ) )
            // InternalGoatInfrastructureParser.g:1970:1: ( RightCurlyBracket )
            {
            // InternalGoatInfrastructureParser.g:1970:1: ( RightCurlyBracket )
            // InternalGoatInfrastructureParser.g:1971:2: RightCurlyBracket
            {
             before(grammarAccess.getTreeAccess().getRightCurlyBracketKeyword_1_1()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getRightCurlyBracketKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1__1__Impl"


    // $ANTLR start "rule__Tree__Group_1_0__0"
    // InternalGoatInfrastructureParser.g:1981:1: rule__Tree__Group_1_0__0 : rule__Tree__Group_1_0__0__Impl rule__Tree__Group_1_0__1 ;
    public final void rule__Tree__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1985:1: ( rule__Tree__Group_1_0__0__Impl rule__Tree__Group_1_0__1 )
            // InternalGoatInfrastructureParser.g:1986:2: rule__Tree__Group_1_0__0__Impl rule__Tree__Group_1_0__1
            {
            pushFollow(FOLLOW_6);
            rule__Tree__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1_0__0"


    // $ANTLR start "rule__Tree__Group_1_0__0__Impl"
    // InternalGoatInfrastructureParser.g:1993:1: rule__Tree__Group_1_0__0__Impl : ( Nodes ) ;
    public final void rule__Tree__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:1997:1: ( ( Nodes ) )
            // InternalGoatInfrastructureParser.g:1998:1: ( Nodes )
            {
            // InternalGoatInfrastructureParser.g:1998:1: ( Nodes )
            // InternalGoatInfrastructureParser.g:1999:2: Nodes
            {
             before(grammarAccess.getTreeAccess().getNodesKeyword_1_0_0()); 
            match(input,Nodes,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getNodesKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1_0__0__Impl"


    // $ANTLR start "rule__Tree__Group_1_0__1"
    // InternalGoatInfrastructureParser.g:2008:1: rule__Tree__Group_1_0__1 : rule__Tree__Group_1_0__1__Impl rule__Tree__Group_1_0__2 ;
    public final void rule__Tree__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2012:1: ( rule__Tree__Group_1_0__1__Impl rule__Tree__Group_1_0__2 )
            // InternalGoatInfrastructureParser.g:2013:2: rule__Tree__Group_1_0__1__Impl rule__Tree__Group_1_0__2
            {
            pushFollow(FOLLOW_7);
            rule__Tree__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tree__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1_0__1"


    // $ANTLR start "rule__Tree__Group_1_0__1__Impl"
    // InternalGoatInfrastructureParser.g:2020:1: rule__Tree__Group_1_0__1__Impl : ( Colon ) ;
    public final void rule__Tree__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2024:1: ( ( Colon ) )
            // InternalGoatInfrastructureParser.g:2025:1: ( Colon )
            {
            // InternalGoatInfrastructureParser.g:2025:1: ( Colon )
            // InternalGoatInfrastructureParser.g:2026:2: Colon
            {
             before(grammarAccess.getTreeAccess().getColonKeyword_1_0_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getColonKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1_0__1__Impl"


    // $ANTLR start "rule__Tree__Group_1_0__2"
    // InternalGoatInfrastructureParser.g:2035:1: rule__Tree__Group_1_0__2 : rule__Tree__Group_1_0__2__Impl ;
    public final void rule__Tree__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2039:1: ( rule__Tree__Group_1_0__2__Impl )
            // InternalGoatInfrastructureParser.g:2040:2: rule__Tree__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tree__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1_0__2"


    // $ANTLR start "rule__Tree__Group_1_0__2__Impl"
    // InternalGoatInfrastructureParser.g:2046:1: rule__Tree__Group_1_0__2__Impl : ( ( rule__Tree__RootAssignment_1_0_2 ) ) ;
    public final void rule__Tree__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2050:1: ( ( ( rule__Tree__RootAssignment_1_0_2 ) ) )
            // InternalGoatInfrastructureParser.g:2051:1: ( ( rule__Tree__RootAssignment_1_0_2 ) )
            {
            // InternalGoatInfrastructureParser.g:2051:1: ( ( rule__Tree__RootAssignment_1_0_2 ) )
            // InternalGoatInfrastructureParser.g:2052:2: ( rule__Tree__RootAssignment_1_0_2 )
            {
             before(grammarAccess.getTreeAccess().getRootAssignment_1_0_2()); 
            // InternalGoatInfrastructureParser.g:2053:2: ( rule__Tree__RootAssignment_1_0_2 )
            // InternalGoatInfrastructureParser.g:2053:3: rule__Tree__RootAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__Tree__RootAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTreeAccess().getRootAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__Group_1_0__2__Impl"


    // $ANTLR start "rule__TreeNode__Group__0"
    // InternalGoatInfrastructureParser.g:2062:1: rule__TreeNode__Group__0 : rule__TreeNode__Group__0__Impl rule__TreeNode__Group__1 ;
    public final void rule__TreeNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2066:1: ( rule__TreeNode__Group__0__Impl rule__TreeNode__Group__1 )
            // InternalGoatInfrastructureParser.g:2067:2: rule__TreeNode__Group__0__Impl rule__TreeNode__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__TreeNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__0"


    // $ANTLR start "rule__TreeNode__Group__0__Impl"
    // InternalGoatInfrastructureParser.g:2074:1: rule__TreeNode__Group__0__Impl : ( ( rule__TreeNode__AddressAssignment_0 ) ) ;
    public final void rule__TreeNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2078:1: ( ( ( rule__TreeNode__AddressAssignment_0 ) ) )
            // InternalGoatInfrastructureParser.g:2079:1: ( ( rule__TreeNode__AddressAssignment_0 ) )
            {
            // InternalGoatInfrastructureParser.g:2079:1: ( ( rule__TreeNode__AddressAssignment_0 ) )
            // InternalGoatInfrastructureParser.g:2080:2: ( rule__TreeNode__AddressAssignment_0 )
            {
             before(grammarAccess.getTreeNodeAccess().getAddressAssignment_0()); 
            // InternalGoatInfrastructureParser.g:2081:2: ( rule__TreeNode__AddressAssignment_0 )
            // InternalGoatInfrastructureParser.g:2081:3: rule__TreeNode__AddressAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__AddressAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTreeNodeAccess().getAddressAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__0__Impl"


    // $ANTLR start "rule__TreeNode__Group__1"
    // InternalGoatInfrastructureParser.g:2089:1: rule__TreeNode__Group__1 : rule__TreeNode__Group__1__Impl ;
    public final void rule__TreeNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2093:1: ( rule__TreeNode__Group__1__Impl )
            // InternalGoatInfrastructureParser.g:2094:2: rule__TreeNode__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__1"


    // $ANTLR start "rule__TreeNode__Group__1__Impl"
    // InternalGoatInfrastructureParser.g:2100:1: rule__TreeNode__Group__1__Impl : ( ( rule__TreeNode__Group_1__0 )? ) ;
    public final void rule__TreeNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2104:1: ( ( ( rule__TreeNode__Group_1__0 )? ) )
            // InternalGoatInfrastructureParser.g:2105:1: ( ( rule__TreeNode__Group_1__0 )? )
            {
            // InternalGoatInfrastructureParser.g:2105:1: ( ( rule__TreeNode__Group_1__0 )? )
            // InternalGoatInfrastructureParser.g:2106:2: ( rule__TreeNode__Group_1__0 )?
            {
             before(grammarAccess.getTreeNodeAccess().getGroup_1()); 
            // InternalGoatInfrastructureParser.g:2107:2: ( rule__TreeNode__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LeftSquareBracket) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2107:3: rule__TreeNode__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TreeNode__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTreeNodeAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group__1__Impl"


    // $ANTLR start "rule__TreeNode__Group_1__0"
    // InternalGoatInfrastructureParser.g:2116:1: rule__TreeNode__Group_1__0 : rule__TreeNode__Group_1__0__Impl rule__TreeNode__Group_1__1 ;
    public final void rule__TreeNode__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2120:1: ( rule__TreeNode__Group_1__0__Impl rule__TreeNode__Group_1__1 )
            // InternalGoatInfrastructureParser.g:2121:2: rule__TreeNode__Group_1__0__Impl rule__TreeNode__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TreeNode__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__0"


    // $ANTLR start "rule__TreeNode__Group_1__0__Impl"
    // InternalGoatInfrastructureParser.g:2128:1: rule__TreeNode__Group_1__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__TreeNode__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2132:1: ( ( LeftSquareBracket ) )
            // InternalGoatInfrastructureParser.g:2133:1: ( LeftSquareBracket )
            {
            // InternalGoatInfrastructureParser.g:2133:1: ( LeftSquareBracket )
            // InternalGoatInfrastructureParser.g:2134:2: LeftSquareBracket
            {
             before(grammarAccess.getTreeNodeAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getTreeNodeAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__0__Impl"


    // $ANTLR start "rule__TreeNode__Group_1__1"
    // InternalGoatInfrastructureParser.g:2143:1: rule__TreeNode__Group_1__1 : rule__TreeNode__Group_1__1__Impl rule__TreeNode__Group_1__2 ;
    public final void rule__TreeNode__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2147:1: ( rule__TreeNode__Group_1__1__Impl rule__TreeNode__Group_1__2 )
            // InternalGoatInfrastructureParser.g:2148:2: rule__TreeNode__Group_1__1__Impl rule__TreeNode__Group_1__2
            {
            pushFollow(FOLLOW_12);
            rule__TreeNode__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__1"


    // $ANTLR start "rule__TreeNode__Group_1__1__Impl"
    // InternalGoatInfrastructureParser.g:2155:1: rule__TreeNode__Group_1__1__Impl : ( ( rule__TreeNode__ChildrenAssignment_1_1 ) ) ;
    public final void rule__TreeNode__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2159:1: ( ( ( rule__TreeNode__ChildrenAssignment_1_1 ) ) )
            // InternalGoatInfrastructureParser.g:2160:1: ( ( rule__TreeNode__ChildrenAssignment_1_1 ) )
            {
            // InternalGoatInfrastructureParser.g:2160:1: ( ( rule__TreeNode__ChildrenAssignment_1_1 ) )
            // InternalGoatInfrastructureParser.g:2161:2: ( rule__TreeNode__ChildrenAssignment_1_1 )
            {
             before(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1()); 
            // InternalGoatInfrastructureParser.g:2162:2: ( rule__TreeNode__ChildrenAssignment_1_1 )
            // InternalGoatInfrastructureParser.g:2162:3: rule__TreeNode__ChildrenAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__ChildrenAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__1__Impl"


    // $ANTLR start "rule__TreeNode__Group_1__2"
    // InternalGoatInfrastructureParser.g:2170:1: rule__TreeNode__Group_1__2 : rule__TreeNode__Group_1__2__Impl rule__TreeNode__Group_1__3 ;
    public final void rule__TreeNode__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2174:1: ( rule__TreeNode__Group_1__2__Impl rule__TreeNode__Group_1__3 )
            // InternalGoatInfrastructureParser.g:2175:2: rule__TreeNode__Group_1__2__Impl rule__TreeNode__Group_1__3
            {
            pushFollow(FOLLOW_12);
            rule__TreeNode__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__2"


    // $ANTLR start "rule__TreeNode__Group_1__2__Impl"
    // InternalGoatInfrastructureParser.g:2182:1: rule__TreeNode__Group_1__2__Impl : ( ( rule__TreeNode__Group_1_2__0 )* ) ;
    public final void rule__TreeNode__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2186:1: ( ( ( rule__TreeNode__Group_1_2__0 )* ) )
            // InternalGoatInfrastructureParser.g:2187:1: ( ( rule__TreeNode__Group_1_2__0 )* )
            {
            // InternalGoatInfrastructureParser.g:2187:1: ( ( rule__TreeNode__Group_1_2__0 )* )
            // InternalGoatInfrastructureParser.g:2188:2: ( rule__TreeNode__Group_1_2__0 )*
            {
             before(grammarAccess.getTreeNodeAccess().getGroup_1_2()); 
            // InternalGoatInfrastructureParser.g:2189:2: ( rule__TreeNode__Group_1_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Comma) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGoatInfrastructureParser.g:2189:3: rule__TreeNode__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__TreeNode__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getTreeNodeAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__2__Impl"


    // $ANTLR start "rule__TreeNode__Group_1__3"
    // InternalGoatInfrastructureParser.g:2197:1: rule__TreeNode__Group_1__3 : rule__TreeNode__Group_1__3__Impl ;
    public final void rule__TreeNode__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2201:1: ( rule__TreeNode__Group_1__3__Impl )
            // InternalGoatInfrastructureParser.g:2202:2: rule__TreeNode__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__3"


    // $ANTLR start "rule__TreeNode__Group_1__3__Impl"
    // InternalGoatInfrastructureParser.g:2208:1: rule__TreeNode__Group_1__3__Impl : ( RightSquareBracket ) ;
    public final void rule__TreeNode__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2212:1: ( ( RightSquareBracket ) )
            // InternalGoatInfrastructureParser.g:2213:1: ( RightSquareBracket )
            {
            // InternalGoatInfrastructureParser.g:2213:1: ( RightSquareBracket )
            // InternalGoatInfrastructureParser.g:2214:2: RightSquareBracket
            {
             before(grammarAccess.getTreeNodeAccess().getRightSquareBracketKeyword_1_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getTreeNodeAccess().getRightSquareBracketKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1__3__Impl"


    // $ANTLR start "rule__TreeNode__Group_1_2__0"
    // InternalGoatInfrastructureParser.g:2224:1: rule__TreeNode__Group_1_2__0 : rule__TreeNode__Group_1_2__0__Impl rule__TreeNode__Group_1_2__1 ;
    public final void rule__TreeNode__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2228:1: ( rule__TreeNode__Group_1_2__0__Impl rule__TreeNode__Group_1_2__1 )
            // InternalGoatInfrastructureParser.g:2229:2: rule__TreeNode__Group_1_2__0__Impl rule__TreeNode__Group_1_2__1
            {
            pushFollow(FOLLOW_7);
            rule__TreeNode__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1_2__0"


    // $ANTLR start "rule__TreeNode__Group_1_2__0__Impl"
    // InternalGoatInfrastructureParser.g:2236:1: rule__TreeNode__Group_1_2__0__Impl : ( Comma ) ;
    public final void rule__TreeNode__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2240:1: ( ( Comma ) )
            // InternalGoatInfrastructureParser.g:2241:1: ( Comma )
            {
            // InternalGoatInfrastructureParser.g:2241:1: ( Comma )
            // InternalGoatInfrastructureParser.g:2242:2: Comma
            {
             before(grammarAccess.getTreeNodeAccess().getCommaKeyword_1_2_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getTreeNodeAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1_2__0__Impl"


    // $ANTLR start "rule__TreeNode__Group_1_2__1"
    // InternalGoatInfrastructureParser.g:2251:1: rule__TreeNode__Group_1_2__1 : rule__TreeNode__Group_1_2__1__Impl ;
    public final void rule__TreeNode__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2255:1: ( rule__TreeNode__Group_1_2__1__Impl )
            // InternalGoatInfrastructureParser.g:2256:2: rule__TreeNode__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__Group_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1_2__1"


    // $ANTLR start "rule__TreeNode__Group_1_2__1__Impl"
    // InternalGoatInfrastructureParser.g:2262:1: rule__TreeNode__Group_1_2__1__Impl : ( ( rule__TreeNode__ChildrenAssignment_1_2_1 ) ) ;
    public final void rule__TreeNode__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2266:1: ( ( ( rule__TreeNode__ChildrenAssignment_1_2_1 ) ) )
            // InternalGoatInfrastructureParser.g:2267:1: ( ( rule__TreeNode__ChildrenAssignment_1_2_1 ) )
            {
            // InternalGoatInfrastructureParser.g:2267:1: ( ( rule__TreeNode__ChildrenAssignment_1_2_1 ) )
            // InternalGoatInfrastructureParser.g:2268:2: ( rule__TreeNode__ChildrenAssignment_1_2_1 )
            {
             before(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_2_1()); 
            // InternalGoatInfrastructureParser.g:2269:2: ( rule__TreeNode__ChildrenAssignment_1_2_1 )
            // InternalGoatInfrastructureParser.g:2269:3: rule__TreeNode__ChildrenAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TreeNode__ChildrenAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__Group_1_2__1__Impl"


    // $ANTLR start "rule__SingleServer__UnorderedGroup"
    // InternalGoatInfrastructureParser.g:2278:1: rule__SingleServer__UnorderedGroup : rule__SingleServer__UnorderedGroup__0 {...}?;
    public final void rule__SingleServer__UnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getSingleServerAccess().getUnorderedGroup());
        	
        try {
            // InternalGoatInfrastructureParser.g:2283:1: ( rule__SingleServer__UnorderedGroup__0 {...}?)
            // InternalGoatInfrastructureParser.g:2284:2: rule__SingleServer__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getSingleServerAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__SingleServer__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getSingleServerAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getSingleServerAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__UnorderedGroup"


    // $ANTLR start "rule__SingleServer__UnorderedGroup__Impl"
    // InternalGoatInfrastructureParser.g:2292:1: rule__SingleServer__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__SingleServer__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__SingleServer__Group_1__0 ) ) ) ) ) ;
    public final void rule__SingleServer__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalGoatInfrastructureParser.g:2297:1: ( ( ({...}? => ( ( ( rule__SingleServer__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__SingleServer__Group_1__0 ) ) ) ) ) )
            // InternalGoatInfrastructureParser.g:2298:3: ( ({...}? => ( ( ( rule__SingleServer__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__SingleServer__Group_1__0 ) ) ) ) )
            {
            // InternalGoatInfrastructureParser.g:2298:3: ( ({...}? => ( ( ( rule__SingleServer__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__SingleServer__Group_1__0 ) ) ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( LA7_0 == Singleserver && getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0) ) {
                alt7=1;
            }
            else if ( ( LA7_0 == Timeout || LA7_0 == RightCurlyBracket ) && getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2299:3: ({...}? => ( ( ( rule__SingleServer__Group_0__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2299:3: ({...}? => ( ( ( rule__SingleServer__Group_0__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2300:4: {...}? => ( ( ( rule__SingleServer__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__SingleServer__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0)");
                    }
                    // InternalGoatInfrastructureParser.g:2300:106: ( ( ( rule__SingleServer__Group_0__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2301:5: ( ( rule__SingleServer__Group_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2307:5: ( ( rule__SingleServer__Group_0__0 ) )
                    // InternalGoatInfrastructureParser.g:2308:6: ( rule__SingleServer__Group_0__0 )
                    {
                     before(grammarAccess.getSingleServerAccess().getGroup_0()); 
                    // InternalGoatInfrastructureParser.g:2309:6: ( rule__SingleServer__Group_0__0 )
                    // InternalGoatInfrastructureParser.g:2309:7: rule__SingleServer__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleServer__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSingleServerAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGoatInfrastructureParser.g:2314:3: ({...}? => ( ( ( rule__SingleServer__Group_1__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2314:3: ({...}? => ( ( ( rule__SingleServer__Group_1__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2315:4: {...}? => ( ( ( rule__SingleServer__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__SingleServer__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1)");
                    }
                    // InternalGoatInfrastructureParser.g:2315:106: ( ( ( rule__SingleServer__Group_1__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2316:5: ( ( rule__SingleServer__Group_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2322:5: ( ( rule__SingleServer__Group_1__0 ) )
                    // InternalGoatInfrastructureParser.g:2323:6: ( rule__SingleServer__Group_1__0 )
                    {
                     before(grammarAccess.getSingleServerAccess().getGroup_1()); 
                    // InternalGoatInfrastructureParser.g:2324:6: ( rule__SingleServer__Group_1__0 )
                    // InternalGoatInfrastructureParser.g:2324:7: rule__SingleServer__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleServer__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSingleServerAccess().getGroup_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSingleServerAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__UnorderedGroup__Impl"


    // $ANTLR start "rule__SingleServer__UnorderedGroup__0"
    // InternalGoatInfrastructureParser.g:2337:1: rule__SingleServer__UnorderedGroup__0 : rule__SingleServer__UnorderedGroup__Impl ( rule__SingleServer__UnorderedGroup__1 )? ;
    public final void rule__SingleServer__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2341:1: ( rule__SingleServer__UnorderedGroup__Impl ( rule__SingleServer__UnorderedGroup__1 )? )
            // InternalGoatInfrastructureParser.g:2342:2: rule__SingleServer__UnorderedGroup__Impl ( rule__SingleServer__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_15);
            rule__SingleServer__UnorderedGroup__Impl();

            state._fsp--;

            // InternalGoatInfrastructureParser.g:2343:2: ( rule__SingleServer__UnorderedGroup__1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 == Singleserver && getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0) ) {
                alt8=1;
            }
            else if ( ( LA8_0 == Timeout || LA8_0 == RightCurlyBracket ) && getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2343:2: rule__SingleServer__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleServer__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__UnorderedGroup__0"


    // $ANTLR start "rule__SingleServer__UnorderedGroup__1"
    // InternalGoatInfrastructureParser.g:2349:1: rule__SingleServer__UnorderedGroup__1 : rule__SingleServer__UnorderedGroup__Impl ;
    public final void rule__SingleServer__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2353:1: ( rule__SingleServer__UnorderedGroup__Impl )
            // InternalGoatInfrastructureParser.g:2354:2: rule__SingleServer__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleServer__UnorderedGroup__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__UnorderedGroup__1"


    // $ANTLR start "rule__Cluster__UnorderedGroup"
    // InternalGoatInfrastructureParser.g:2361:1: rule__Cluster__UnorderedGroup : rule__Cluster__UnorderedGroup__0 {...}?;
    public final void rule__Cluster__UnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getClusterAccess().getUnorderedGroup());
        	
        try {
            // InternalGoatInfrastructureParser.g:2366:1: ( rule__Cluster__UnorderedGroup__0 {...}?)
            // InternalGoatInfrastructureParser.g:2367:2: rule__Cluster__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getClusterAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__Cluster__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getClusterAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getClusterAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__UnorderedGroup"


    // $ANTLR start "rule__Cluster__UnorderedGroup__Impl"
    // InternalGoatInfrastructureParser.g:2375:1: rule__Cluster__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__Cluster__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_3__0 ) ) ) ) ) ;
    public final void rule__Cluster__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalGoatInfrastructureParser.g:2380:1: ( ( ({...}? => ( ( ( rule__Cluster__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_3__0 ) ) ) ) ) )
            // InternalGoatInfrastructureParser.g:2381:3: ( ({...}? => ( ( ( rule__Cluster__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_3__0 ) ) ) ) )
            {
            // InternalGoatInfrastructureParser.g:2381:3: ( ({...}? => ( ( ( rule__Cluster__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cluster__Group_3__0 ) ) ) ) )
            int alt9=4;
            int LA9_0 = input.LA(1);

            if ( LA9_0 == Cluster && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 == Registration && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1) ) {
                alt9=2;
            }
            else if ( LA9_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2) ) {
                alt9=3;
            }
            else if ( LA9_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3) ) {
                alt9=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2382:3: ({...}? => ( ( ( rule__Cluster__Group_0__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2382:3: ({...}? => ( ( ( rule__Cluster__Group_0__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2383:4: {...}? => ( ( ( rule__Cluster__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Cluster__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0)");
                    }
                    // InternalGoatInfrastructureParser.g:2383:101: ( ( ( rule__Cluster__Group_0__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2384:5: ( ( rule__Cluster__Group_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 0);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2390:5: ( ( rule__Cluster__Group_0__0 ) )
                    // InternalGoatInfrastructureParser.g:2391:6: ( rule__Cluster__Group_0__0 )
                    {
                     before(grammarAccess.getClusterAccess().getGroup_0()); 
                    // InternalGoatInfrastructureParser.g:2392:6: ( rule__Cluster__Group_0__0 )
                    // InternalGoatInfrastructureParser.g:2392:7: rule__Cluster__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Cluster__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClusterAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGoatInfrastructureParser.g:2397:3: ({...}? => ( ( ( rule__Cluster__Group_1__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2397:3: ({...}? => ( ( ( rule__Cluster__Group_1__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2398:4: {...}? => ( ( ( rule__Cluster__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Cluster__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1)");
                    }
                    // InternalGoatInfrastructureParser.g:2398:101: ( ( ( rule__Cluster__Group_1__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2399:5: ( ( rule__Cluster__Group_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 1);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2405:5: ( ( rule__Cluster__Group_1__0 ) )
                    // InternalGoatInfrastructureParser.g:2406:6: ( rule__Cluster__Group_1__0 )
                    {
                     before(grammarAccess.getClusterAccess().getGroup_1()); 
                    // InternalGoatInfrastructureParser.g:2407:6: ( rule__Cluster__Group_1__0 )
                    // InternalGoatInfrastructureParser.g:2407:7: rule__Cluster__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Cluster__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClusterAccess().getGroup_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGoatInfrastructureParser.g:2412:3: ({...}? => ( ( ( rule__Cluster__Group_2__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2412:3: ({...}? => ( ( ( rule__Cluster__Group_2__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2413:4: {...}? => ( ( ( rule__Cluster__Group_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Cluster__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2)");
                    }
                    // InternalGoatInfrastructureParser.g:2413:101: ( ( ( rule__Cluster__Group_2__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2414:5: ( ( rule__Cluster__Group_2__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 2);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2420:5: ( ( rule__Cluster__Group_2__0 ) )
                    // InternalGoatInfrastructureParser.g:2421:6: ( rule__Cluster__Group_2__0 )
                    {
                     before(grammarAccess.getClusterAccess().getGroup_2()); 
                    // InternalGoatInfrastructureParser.g:2422:6: ( rule__Cluster__Group_2__0 )
                    // InternalGoatInfrastructureParser.g:2422:7: rule__Cluster__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Cluster__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClusterAccess().getGroup_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGoatInfrastructureParser.g:2427:3: ({...}? => ( ( ( rule__Cluster__Group_3__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2427:3: ({...}? => ( ( ( rule__Cluster__Group_3__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2428:4: {...}? => ( ( ( rule__Cluster__Group_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Cluster__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3)");
                    }
                    // InternalGoatInfrastructureParser.g:2428:101: ( ( ( rule__Cluster__Group_3__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2429:5: ( ( rule__Cluster__Group_3__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 3);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2435:5: ( ( rule__Cluster__Group_3__0 ) )
                    // InternalGoatInfrastructureParser.g:2436:6: ( rule__Cluster__Group_3__0 )
                    {
                     before(grammarAccess.getClusterAccess().getGroup_3()); 
                    // InternalGoatInfrastructureParser.g:2437:6: ( rule__Cluster__Group_3__0 )
                    // InternalGoatInfrastructureParser.g:2437:7: rule__Cluster__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Cluster__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClusterAccess().getGroup_3()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClusterAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__UnorderedGroup__Impl"


    // $ANTLR start "rule__Cluster__UnorderedGroup__0"
    // InternalGoatInfrastructureParser.g:2450:1: rule__Cluster__UnorderedGroup__0 : rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__1 )? ;
    public final void rule__Cluster__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2454:1: ( rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__1 )? )
            // InternalGoatInfrastructureParser.g:2455:2: rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_16);
            rule__Cluster__UnorderedGroup__Impl();

            state._fsp--;

            // InternalGoatInfrastructureParser.g:2456:2: ( rule__Cluster__UnorderedGroup__1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 == Cluster && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 == Registration && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2456:2: rule__Cluster__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Cluster__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__UnorderedGroup__0"


    // $ANTLR start "rule__Cluster__UnorderedGroup__1"
    // InternalGoatInfrastructureParser.g:2462:1: rule__Cluster__UnorderedGroup__1 : rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__2 )? ;
    public final void rule__Cluster__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2466:1: ( rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__2 )? )
            // InternalGoatInfrastructureParser.g:2467:2: rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_16);
            rule__Cluster__UnorderedGroup__Impl();

            state._fsp--;

            // InternalGoatInfrastructureParser.g:2468:2: ( rule__Cluster__UnorderedGroup__2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 == Cluster && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 == Registration && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2468:2: rule__Cluster__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Cluster__UnorderedGroup__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__UnorderedGroup__1"


    // $ANTLR start "rule__Cluster__UnorderedGroup__2"
    // InternalGoatInfrastructureParser.g:2474:1: rule__Cluster__UnorderedGroup__2 : rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__3 )? ;
    public final void rule__Cluster__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2478:1: ( rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__3 )? )
            // InternalGoatInfrastructureParser.g:2479:2: rule__Cluster__UnorderedGroup__Impl ( rule__Cluster__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_16);
            rule__Cluster__UnorderedGroup__Impl();

            state._fsp--;

            // InternalGoatInfrastructureParser.g:2480:2: ( rule__Cluster__UnorderedGroup__3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 == Cluster && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0) ) {
                alt12=1;
            }
            else if ( LA12_0 == Registration && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1) ) {
                alt12=1;
            }
            else if ( LA12_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2) ) {
                alt12=1;
            }
            else if ( LA12_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2480:2: rule__Cluster__UnorderedGroup__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Cluster__UnorderedGroup__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__UnorderedGroup__2"


    // $ANTLR start "rule__Cluster__UnorderedGroup__3"
    // InternalGoatInfrastructureParser.g:2486:1: rule__Cluster__UnorderedGroup__3 : rule__Cluster__UnorderedGroup__Impl ;
    public final void rule__Cluster__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2490:1: ( rule__Cluster__UnorderedGroup__Impl )
            // InternalGoatInfrastructureParser.g:2491:2: rule__Cluster__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Cluster__UnorderedGroup__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__UnorderedGroup__3"


    // $ANTLR start "rule__Ring__UnorderedGroup"
    // InternalGoatInfrastructureParser.g:2498:1: rule__Ring__UnorderedGroup : rule__Ring__UnorderedGroup__0 {...}?;
    public final void rule__Ring__UnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getRingAccess().getUnorderedGroup());
        	
        try {
            // InternalGoatInfrastructureParser.g:2503:1: ( rule__Ring__UnorderedGroup__0 {...}?)
            // InternalGoatInfrastructureParser.g:2504:2: rule__Ring__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__Ring__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getRingAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__Ring__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getRingAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getRingAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__UnorderedGroup"


    // $ANTLR start "rule__Ring__UnorderedGroup__Impl"
    // InternalGoatInfrastructureParser.g:2512:1: rule__Ring__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__Ring__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_2__0 ) ) ) ) ) ;
    public final void rule__Ring__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalGoatInfrastructureParser.g:2517:1: ( ( ({...}? => ( ( ( rule__Ring__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_2__0 ) ) ) ) ) )
            // InternalGoatInfrastructureParser.g:2518:3: ( ({...}? => ( ( ( rule__Ring__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_2__0 ) ) ) ) )
            {
            // InternalGoatInfrastructureParser.g:2518:3: ( ({...}? => ( ( ( rule__Ring__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Ring__Group_2__0 ) ) ) ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( LA13_0 == Ring && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0) ) {
                alt13=1;
            }
            else if ( LA13_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1) ) {
                alt13=2;
            }
            else if ( LA13_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2) ) {
                alt13=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2519:3: ({...}? => ( ( ( rule__Ring__Group_0__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2519:3: ({...}? => ( ( ( rule__Ring__Group_0__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2520:4: {...}? => ( ( ( rule__Ring__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Ring__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0)");
                    }
                    // InternalGoatInfrastructureParser.g:2520:98: ( ( ( rule__Ring__Group_0__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2521:5: ( ( rule__Ring__Group_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getRingAccess().getUnorderedGroup(), 0);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2527:5: ( ( rule__Ring__Group_0__0 ) )
                    // InternalGoatInfrastructureParser.g:2528:6: ( rule__Ring__Group_0__0 )
                    {
                     before(grammarAccess.getRingAccess().getGroup_0()); 
                    // InternalGoatInfrastructureParser.g:2529:6: ( rule__Ring__Group_0__0 )
                    // InternalGoatInfrastructureParser.g:2529:7: rule__Ring__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Ring__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRingAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGoatInfrastructureParser.g:2534:3: ({...}? => ( ( ( rule__Ring__Group_1__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2534:3: ({...}? => ( ( ( rule__Ring__Group_1__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2535:4: {...}? => ( ( ( rule__Ring__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Ring__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1)");
                    }
                    // InternalGoatInfrastructureParser.g:2535:98: ( ( ( rule__Ring__Group_1__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2536:5: ( ( rule__Ring__Group_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getRingAccess().getUnorderedGroup(), 1);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2542:5: ( ( rule__Ring__Group_1__0 ) )
                    // InternalGoatInfrastructureParser.g:2543:6: ( rule__Ring__Group_1__0 )
                    {
                     before(grammarAccess.getRingAccess().getGroup_1()); 
                    // InternalGoatInfrastructureParser.g:2544:6: ( rule__Ring__Group_1__0 )
                    // InternalGoatInfrastructureParser.g:2544:7: rule__Ring__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Ring__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRingAccess().getGroup_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGoatInfrastructureParser.g:2549:3: ({...}? => ( ( ( rule__Ring__Group_2__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2549:3: ({...}? => ( ( ( rule__Ring__Group_2__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2550:4: {...}? => ( ( ( rule__Ring__Group_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Ring__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2)");
                    }
                    // InternalGoatInfrastructureParser.g:2550:98: ( ( ( rule__Ring__Group_2__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2551:5: ( ( rule__Ring__Group_2__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getRingAccess().getUnorderedGroup(), 2);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2557:5: ( ( rule__Ring__Group_2__0 ) )
                    // InternalGoatInfrastructureParser.g:2558:6: ( rule__Ring__Group_2__0 )
                    {
                     before(grammarAccess.getRingAccess().getGroup_2()); 
                    // InternalGoatInfrastructureParser.g:2559:6: ( rule__Ring__Group_2__0 )
                    // InternalGoatInfrastructureParser.g:2559:7: rule__Ring__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Ring__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRingAccess().getGroup_2()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRingAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__UnorderedGroup__Impl"


    // $ANTLR start "rule__Ring__UnorderedGroup__0"
    // InternalGoatInfrastructureParser.g:2572:1: rule__Ring__UnorderedGroup__0 : rule__Ring__UnorderedGroup__Impl ( rule__Ring__UnorderedGroup__1 )? ;
    public final void rule__Ring__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2576:1: ( rule__Ring__UnorderedGroup__Impl ( rule__Ring__UnorderedGroup__1 )? )
            // InternalGoatInfrastructureParser.g:2577:2: rule__Ring__UnorderedGroup__Impl ( rule__Ring__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_17);
            rule__Ring__UnorderedGroup__Impl();

            state._fsp--;

            // InternalGoatInfrastructureParser.g:2578:2: ( rule__Ring__UnorderedGroup__1 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( LA14_0 == Ring && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0) ) {
                alt14=1;
            }
            else if ( LA14_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1) ) {
                alt14=1;
            }
            else if ( LA14_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2578:2: rule__Ring__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Ring__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__UnorderedGroup__0"


    // $ANTLR start "rule__Ring__UnorderedGroup__1"
    // InternalGoatInfrastructureParser.g:2584:1: rule__Ring__UnorderedGroup__1 : rule__Ring__UnorderedGroup__Impl ( rule__Ring__UnorderedGroup__2 )? ;
    public final void rule__Ring__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2588:1: ( rule__Ring__UnorderedGroup__Impl ( rule__Ring__UnorderedGroup__2 )? )
            // InternalGoatInfrastructureParser.g:2589:2: rule__Ring__UnorderedGroup__Impl ( rule__Ring__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_17);
            rule__Ring__UnorderedGroup__Impl();

            state._fsp--;

            // InternalGoatInfrastructureParser.g:2590:2: ( rule__Ring__UnorderedGroup__2 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( LA15_0 == Ring && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0) ) {
                alt15=1;
            }
            else if ( LA15_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1) ) {
                alt15=1;
            }
            else if ( LA15_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2590:2: rule__Ring__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Ring__UnorderedGroup__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__UnorderedGroup__1"


    // $ANTLR start "rule__Ring__UnorderedGroup__2"
    // InternalGoatInfrastructureParser.g:2596:1: rule__Ring__UnorderedGroup__2 : rule__Ring__UnorderedGroup__Impl ;
    public final void rule__Ring__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2600:1: ( rule__Ring__UnorderedGroup__Impl )
            // InternalGoatInfrastructureParser.g:2601:2: rule__Ring__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Ring__UnorderedGroup__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__UnorderedGroup__2"


    // $ANTLR start "rule__Tree__UnorderedGroup"
    // InternalGoatInfrastructureParser.g:2608:1: rule__Tree__UnorderedGroup : rule__Tree__UnorderedGroup__0 {...}?;
    public final void rule__Tree__UnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTreeAccess().getUnorderedGroup());
        	
        try {
            // InternalGoatInfrastructureParser.g:2613:1: ( rule__Tree__UnorderedGroup__0 {...}?)
            // InternalGoatInfrastructureParser.g:2614:2: rule__Tree__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__Tree__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTreeAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__Tree__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getTreeAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getTreeAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__UnorderedGroup"


    // $ANTLR start "rule__Tree__UnorderedGroup__Impl"
    // InternalGoatInfrastructureParser.g:2622:1: rule__Tree__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__Tree__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Tree__Group_1__0 ) ) ) ) ) ;
    public final void rule__Tree__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalGoatInfrastructureParser.g:2627:1: ( ( ({...}? => ( ( ( rule__Tree__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Tree__Group_1__0 ) ) ) ) ) )
            // InternalGoatInfrastructureParser.g:2628:3: ( ({...}? => ( ( ( rule__Tree__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Tree__Group_1__0 ) ) ) ) )
            {
            // InternalGoatInfrastructureParser.g:2628:3: ( ({...}? => ( ( ( rule__Tree__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Tree__Group_1__0 ) ) ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( LA16_0 == Tree && getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 0) ) {
                alt16=1;
            }
            else if ( LA16_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 1) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2629:3: ({...}? => ( ( ( rule__Tree__Group_0__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2629:3: ({...}? => ( ( ( rule__Tree__Group_0__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2630:4: {...}? => ( ( ( rule__Tree__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Tree__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 0)");
                    }
                    // InternalGoatInfrastructureParser.g:2630:98: ( ( ( rule__Tree__Group_0__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2631:5: ( ( rule__Tree__Group_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTreeAccess().getUnorderedGroup(), 0);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2637:5: ( ( rule__Tree__Group_0__0 ) )
                    // InternalGoatInfrastructureParser.g:2638:6: ( rule__Tree__Group_0__0 )
                    {
                     before(grammarAccess.getTreeAccess().getGroup_0()); 
                    // InternalGoatInfrastructureParser.g:2639:6: ( rule__Tree__Group_0__0 )
                    // InternalGoatInfrastructureParser.g:2639:7: rule__Tree__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Tree__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTreeAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGoatInfrastructureParser.g:2644:3: ({...}? => ( ( ( rule__Tree__Group_1__0 ) ) ) )
                    {
                    // InternalGoatInfrastructureParser.g:2644:3: ({...}? => ( ( ( rule__Tree__Group_1__0 ) ) ) )
                    // InternalGoatInfrastructureParser.g:2645:4: {...}? => ( ( ( rule__Tree__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Tree__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 1)");
                    }
                    // InternalGoatInfrastructureParser.g:2645:98: ( ( ( rule__Tree__Group_1__0 ) ) )
                    // InternalGoatInfrastructureParser.g:2646:5: ( ( rule__Tree__Group_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTreeAccess().getUnorderedGroup(), 1);
                    				

                    					selected = true;
                    				
                    // InternalGoatInfrastructureParser.g:2652:5: ( ( rule__Tree__Group_1__0 ) )
                    // InternalGoatInfrastructureParser.g:2653:6: ( rule__Tree__Group_1__0 )
                    {
                     before(grammarAccess.getTreeAccess().getGroup_1()); 
                    // InternalGoatInfrastructureParser.g:2654:6: ( rule__Tree__Group_1__0 )
                    // InternalGoatInfrastructureParser.g:2654:7: rule__Tree__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Tree__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTreeAccess().getGroup_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTreeAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__UnorderedGroup__Impl"


    // $ANTLR start "rule__Tree__UnorderedGroup__0"
    // InternalGoatInfrastructureParser.g:2667:1: rule__Tree__UnorderedGroup__0 : rule__Tree__UnorderedGroup__Impl ( rule__Tree__UnorderedGroup__1 )? ;
    public final void rule__Tree__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2671:1: ( rule__Tree__UnorderedGroup__Impl ( rule__Tree__UnorderedGroup__1 )? )
            // InternalGoatInfrastructureParser.g:2672:2: rule__Tree__UnorderedGroup__Impl ( rule__Tree__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_18);
            rule__Tree__UnorderedGroup__Impl();

            state._fsp--;

            // InternalGoatInfrastructureParser.g:2673:2: ( rule__Tree__UnorderedGroup__1 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( LA17_0 == Tree && getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 0) ) {
                alt17=1;
            }
            else if ( LA17_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 1) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:2673:2: rule__Tree__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Tree__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__UnorderedGroup__0"


    // $ANTLR start "rule__Tree__UnorderedGroup__1"
    // InternalGoatInfrastructureParser.g:2679:1: rule__Tree__UnorderedGroup__1 : rule__Tree__UnorderedGroup__Impl ;
    public final void rule__Tree__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2683:1: ( rule__Tree__UnorderedGroup__Impl )
            // InternalGoatInfrastructureParser.g:2684:2: rule__Tree__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tree__UnorderedGroup__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__UnorderedGroup__1"


    // $ANTLR start "rule__SingleServer__NameAssignment_0_1"
    // InternalGoatInfrastructureParser.g:2691:1: rule__SingleServer__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__SingleServer__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2695:1: ( ( RULE_ID ) )
            // InternalGoatInfrastructureParser.g:2696:2: ( RULE_ID )
            {
            // InternalGoatInfrastructureParser.g:2696:2: ( RULE_ID )
            // InternalGoatInfrastructureParser.g:2697:3: RULE_ID
            {
             before(grammarAccess.getSingleServerAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__NameAssignment_0_1"


    // $ANTLR start "rule__SingleServer__ServerAssignment_0_3_2"
    // InternalGoatInfrastructureParser.g:2706:1: rule__SingleServer__ServerAssignment_0_3_2 : ( RULE_STRING ) ;
    public final void rule__SingleServer__ServerAssignment_0_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2710:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2711:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2711:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2712:3: RULE_STRING
            {
             before(grammarAccess.getSingleServerAccess().getServerSTRINGTerminalRuleCall_0_3_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getServerSTRINGTerminalRuleCall_0_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__ServerAssignment_0_3_2"


    // $ANTLR start "rule__SingleServer__TimeoutAssignment_1_0_2"
    // InternalGoatInfrastructureParser.g:2721:1: rule__SingleServer__TimeoutAssignment_1_0_2 : ( RULE_INT ) ;
    public final void rule__SingleServer__TimeoutAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2725:1: ( ( RULE_INT ) )
            // InternalGoatInfrastructureParser.g:2726:2: ( RULE_INT )
            {
            // InternalGoatInfrastructureParser.g:2726:2: ( RULE_INT )
            // InternalGoatInfrastructureParser.g:2727:3: RULE_INT
            {
             before(grammarAccess.getSingleServerAccess().getTimeoutINTTerminalRuleCall_1_0_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getSingleServerAccess().getTimeoutINTTerminalRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleServer__TimeoutAssignment_1_0_2"


    // $ANTLR start "rule__Cluster__NameAssignment_0_1"
    // InternalGoatInfrastructureParser.g:2736:1: rule__Cluster__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Cluster__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2740:1: ( ( RULE_ID ) )
            // InternalGoatInfrastructureParser.g:2741:2: ( RULE_ID )
            {
            // InternalGoatInfrastructureParser.g:2741:2: ( RULE_ID )
            // InternalGoatInfrastructureParser.g:2742:3: RULE_ID
            {
             before(grammarAccess.getClusterAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__NameAssignment_0_1"


    // $ANTLR start "rule__Cluster__Message_queueAssignment_0_3_2"
    // InternalGoatInfrastructureParser.g:2751:1: rule__Cluster__Message_queueAssignment_0_3_2 : ( RULE_STRING ) ;
    public final void rule__Cluster__Message_queueAssignment_0_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2755:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2756:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2756:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2757:3: RULE_STRING
            {
             before(grammarAccess.getClusterAccess().getMessage_queueSTRINGTerminalRuleCall_0_3_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getMessage_queueSTRINGTerminalRuleCall_0_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Message_queueAssignment_0_3_2"


    // $ANTLR start "rule__Cluster__RegistrationAssignment_1_2"
    // InternalGoatInfrastructureParser.g:2766:1: rule__Cluster__RegistrationAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__Cluster__RegistrationAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2770:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2771:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2771:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2772:3: RULE_STRING
            {
             before(grammarAccess.getClusterAccess().getRegistrationSTRINGTerminalRuleCall_1_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getRegistrationSTRINGTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__RegistrationAssignment_1_2"


    // $ANTLR start "rule__Cluster__Mid_assignerAssignment_2_2"
    // InternalGoatInfrastructureParser.g:2781:1: rule__Cluster__Mid_assignerAssignment_2_2 : ( RULE_STRING ) ;
    public final void rule__Cluster__Mid_assignerAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2785:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2786:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2786:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2787:3: RULE_STRING
            {
             before(grammarAccess.getClusterAccess().getMid_assignerSTRINGTerminalRuleCall_2_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getMid_assignerSTRINGTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Mid_assignerAssignment_2_2"


    // $ANTLR start "rule__Cluster__NodesAssignment_3_0_3"
    // InternalGoatInfrastructureParser.g:2796:1: rule__Cluster__NodesAssignment_3_0_3 : ( RULE_STRING ) ;
    public final void rule__Cluster__NodesAssignment_3_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2800:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2801:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2801:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2802:3: RULE_STRING
            {
             before(grammarAccess.getClusterAccess().getNodesSTRINGTerminalRuleCall_3_0_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getNodesSTRINGTerminalRuleCall_3_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__NodesAssignment_3_0_3"


    // $ANTLR start "rule__Cluster__NodesAssignment_3_0_4_1"
    // InternalGoatInfrastructureParser.g:2811:1: rule__Cluster__NodesAssignment_3_0_4_1 : ( RULE_STRING ) ;
    public final void rule__Cluster__NodesAssignment_3_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2815:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2816:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2816:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2817:3: RULE_STRING
            {
             before(grammarAccess.getClusterAccess().getNodesSTRINGTerminalRuleCall_3_0_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClusterAccess().getNodesSTRINGTerminalRuleCall_3_0_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__NodesAssignment_3_0_4_1"


    // $ANTLR start "rule__Ring__NameAssignment_0_1"
    // InternalGoatInfrastructureParser.g:2826:1: rule__Ring__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Ring__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2830:1: ( ( RULE_ID ) )
            // InternalGoatInfrastructureParser.g:2831:2: ( RULE_ID )
            {
            // InternalGoatInfrastructureParser.g:2831:2: ( RULE_ID )
            // InternalGoatInfrastructureParser.g:2832:3: RULE_ID
            {
             before(grammarAccess.getRingAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__NameAssignment_0_1"


    // $ANTLR start "rule__Ring__RegistrationAssignment_0_3_2"
    // InternalGoatInfrastructureParser.g:2841:1: rule__Ring__RegistrationAssignment_0_3_2 : ( RULE_STRING ) ;
    public final void rule__Ring__RegistrationAssignment_0_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2845:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2846:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2846:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2847:3: RULE_STRING
            {
             before(grammarAccess.getRingAccess().getRegistrationSTRINGTerminalRuleCall_0_3_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getRegistrationSTRINGTerminalRuleCall_0_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__RegistrationAssignment_0_3_2"


    // $ANTLR start "rule__Ring__Mid_assignerAssignment_1_2"
    // InternalGoatInfrastructureParser.g:2856:1: rule__Ring__Mid_assignerAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__Ring__Mid_assignerAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2860:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2861:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2861:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2862:3: RULE_STRING
            {
             before(grammarAccess.getRingAccess().getMid_assignerSTRINGTerminalRuleCall_1_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getMid_assignerSTRINGTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__Mid_assignerAssignment_1_2"


    // $ANTLR start "rule__Ring__NodesAssignment_2_0_3"
    // InternalGoatInfrastructureParser.g:2871:1: rule__Ring__NodesAssignment_2_0_3 : ( RULE_STRING ) ;
    public final void rule__Ring__NodesAssignment_2_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2875:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2876:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2876:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2877:3: RULE_STRING
            {
             before(grammarAccess.getRingAccess().getNodesSTRINGTerminalRuleCall_2_0_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getNodesSTRINGTerminalRuleCall_2_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__NodesAssignment_2_0_3"


    // $ANTLR start "rule__Ring__NodesAssignment_2_0_4_1"
    // InternalGoatInfrastructureParser.g:2886:1: rule__Ring__NodesAssignment_2_0_4_1 : ( RULE_STRING ) ;
    public final void rule__Ring__NodesAssignment_2_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2890:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2891:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2891:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2892:3: RULE_STRING
            {
             before(grammarAccess.getRingAccess().getNodesSTRINGTerminalRuleCall_2_0_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getRingAccess().getNodesSTRINGTerminalRuleCall_2_0_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ring__NodesAssignment_2_0_4_1"


    // $ANTLR start "rule__Tree__NameAssignment_0_1"
    // InternalGoatInfrastructureParser.g:2901:1: rule__Tree__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Tree__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2905:1: ( ( RULE_ID ) )
            // InternalGoatInfrastructureParser.g:2906:2: ( RULE_ID )
            {
            // InternalGoatInfrastructureParser.g:2906:2: ( RULE_ID )
            // InternalGoatInfrastructureParser.g:2907:3: RULE_ID
            {
             before(grammarAccess.getTreeAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__NameAssignment_0_1"


    // $ANTLR start "rule__Tree__RegistrationAssignment_0_3_2"
    // InternalGoatInfrastructureParser.g:2916:1: rule__Tree__RegistrationAssignment_0_3_2 : ( RULE_STRING ) ;
    public final void rule__Tree__RegistrationAssignment_0_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2920:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2921:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2921:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2922:3: RULE_STRING
            {
             before(grammarAccess.getTreeAccess().getRegistrationSTRINGTerminalRuleCall_0_3_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTreeAccess().getRegistrationSTRINGTerminalRuleCall_0_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__RegistrationAssignment_0_3_2"


    // $ANTLR start "rule__Tree__RootAssignment_1_0_2"
    // InternalGoatInfrastructureParser.g:2931:1: rule__Tree__RootAssignment_1_0_2 : ( ruleTreeNode ) ;
    public final void rule__Tree__RootAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2935:1: ( ( ruleTreeNode ) )
            // InternalGoatInfrastructureParser.g:2936:2: ( ruleTreeNode )
            {
            // InternalGoatInfrastructureParser.g:2936:2: ( ruleTreeNode )
            // InternalGoatInfrastructureParser.g:2937:3: ruleTreeNode
            {
             before(grammarAccess.getTreeAccess().getRootTreeNodeParserRuleCall_1_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeAccess().getRootTreeNodeParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tree__RootAssignment_1_0_2"


    // $ANTLR start "rule__TreeNode__AddressAssignment_0"
    // InternalGoatInfrastructureParser.g:2946:1: rule__TreeNode__AddressAssignment_0 : ( RULE_STRING ) ;
    public final void rule__TreeNode__AddressAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2950:1: ( ( RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:2951:2: ( RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:2951:2: ( RULE_STRING )
            // InternalGoatInfrastructureParser.g:2952:3: RULE_STRING
            {
             before(grammarAccess.getTreeNodeAccess().getAddressSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTreeNodeAccess().getAddressSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__AddressAssignment_0"


    // $ANTLR start "rule__TreeNode__ChildrenAssignment_1_1"
    // InternalGoatInfrastructureParser.g:2961:1: rule__TreeNode__ChildrenAssignment_1_1 : ( ruleTreeNode ) ;
    public final void rule__TreeNode__ChildrenAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2965:1: ( ( ruleTreeNode ) )
            // InternalGoatInfrastructureParser.g:2966:2: ( ruleTreeNode )
            {
            // InternalGoatInfrastructureParser.g:2966:2: ( ruleTreeNode )
            // InternalGoatInfrastructureParser.g:2967:3: ruleTreeNode
            {
             before(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__ChildrenAssignment_1_1"


    // $ANTLR start "rule__TreeNode__ChildrenAssignment_1_2_1"
    // InternalGoatInfrastructureParser.g:2976:1: rule__TreeNode__ChildrenAssignment_1_2_1 : ( ruleTreeNode ) ;
    public final void rule__TreeNode__ChildrenAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGoatInfrastructureParser.g:2980:1: ( ( ruleTreeNode ) )
            // InternalGoatInfrastructureParser.g:2981:2: ( ruleTreeNode )
            {
            // InternalGoatInfrastructureParser.g:2981:2: ( ruleTreeNode )
            // InternalGoatInfrastructureParser.g:2982:3: ruleTreeNode
            {
             before(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTreeNode();

            state._fsp--;

             after(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TreeNode__ChildrenAssignment_1_2_1"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\1\5\2\uffff\2\17\2\uffff\1\26\1\20\1\uffff\1\26\1\16\1\26\1\23\1\16\1\uffff";
    static final String dfa_3s = "\1\23\2\uffff\2\17\2\uffff\2\26\1\uffff\1\26\1\21\1\26\1\23\1\21\1\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\2\uffff\1\2\5\uffff\1\2";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\1\2\1\1\1\2\1\1\1\uffff\1\4\1\5\1\6\5\uffff\1\1",
            "",
            "",
            "\1\7",
            "\1\10",
            "",
            "",
            "\1\11",
            "\1\12\5\uffff\1\6",
            "",
            "\1\13",
            "\1\14\2\uffff\1\15",
            "\1\16",
            "\1\17",
            "\1\14\2\uffff\1\15",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "220:1: rule__Infrastructure__Alternatives : ( ( ruleSingleServer ) | ( ruleCluster ) | ( ruleRing ) | ( ruleTree ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080282L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000962L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000001822L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000002802L});

}
