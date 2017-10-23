package com.sysma.goat.eclipse_plugin.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.sysma.goat.eclipse_plugin.services.GoatInfrastructureGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGoatInfrastructureParser extends AbstractInternalAntlrParser {
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

        public InternalGoatInfrastructureParser(TokenStream input, GoatInfrastructureGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Infrastructure";
       	}

       	@Override
       	protected GoatInfrastructureGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleInfrastructure"
    // InternalGoatInfrastructureParser.g:57:1: entryRuleInfrastructure returns [EObject current=null] : iv_ruleInfrastructure= ruleInfrastructure EOF ;
    public final EObject entryRuleInfrastructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructure = null;


        try {
            // InternalGoatInfrastructureParser.g:57:55: (iv_ruleInfrastructure= ruleInfrastructure EOF )
            // InternalGoatInfrastructureParser.g:58:2: iv_ruleInfrastructure= ruleInfrastructure EOF
            {
             newCompositeNode(grammarAccess.getInfrastructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInfrastructure=ruleInfrastructure();

            state._fsp--;

             current =iv_ruleInfrastructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfrastructure"


    // $ANTLR start "ruleInfrastructure"
    // InternalGoatInfrastructureParser.g:64:1: ruleInfrastructure returns [EObject current=null] : (this_SingleServer_0= ruleSingleServer | this_Cluster_1= ruleCluster | this_Ring_2= ruleRing | this_Tree_3= ruleTree ) ;
    public final EObject ruleInfrastructure() throws RecognitionException {
        EObject current = null;

        EObject this_SingleServer_0 = null;

        EObject this_Cluster_1 = null;

        EObject this_Ring_2 = null;

        EObject this_Tree_3 = null;



        	enterRule();

        try {
            // InternalGoatInfrastructureParser.g:70:2: ( (this_SingleServer_0= ruleSingleServer | this_Cluster_1= ruleCluster | this_Ring_2= ruleRing | this_Tree_3= ruleTree ) )
            // InternalGoatInfrastructureParser.g:71:2: (this_SingleServer_0= ruleSingleServer | this_Cluster_1= ruleCluster | this_Ring_2= ruleRing | this_Tree_3= ruleTree )
            {
            // InternalGoatInfrastructureParser.g:71:2: (this_SingleServer_0= ruleSingleServer | this_Cluster_1= ruleCluster | this_Ring_2= ruleRing | this_Tree_3= ruleTree )
            int alt1=4;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:72:3: this_SingleServer_0= ruleSingleServer
                    {

                    			newCompositeNode(grammarAccess.getInfrastructureAccess().getSingleServerParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingleServer_0=ruleSingleServer();

                    state._fsp--;


                    			current = this_SingleServer_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGoatInfrastructureParser.g:81:3: this_Cluster_1= ruleCluster
                    {

                    			newCompositeNode(grammarAccess.getInfrastructureAccess().getClusterParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Cluster_1=ruleCluster();

                    state._fsp--;


                    			current = this_Cluster_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGoatInfrastructureParser.g:90:3: this_Ring_2= ruleRing
                    {

                    			newCompositeNode(grammarAccess.getInfrastructureAccess().getRingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Ring_2=ruleRing();

                    state._fsp--;


                    			current = this_Ring_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalGoatInfrastructureParser.g:99:3: this_Tree_3= ruleTree
                    {

                    			newCompositeNode(grammarAccess.getInfrastructureAccess().getTreeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Tree_3=ruleTree();

                    state._fsp--;


                    			current = this_Tree_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfrastructure"


    // $ANTLR start "entryRuleSingleServer"
    // InternalGoatInfrastructureParser.g:111:1: entryRuleSingleServer returns [EObject current=null] : iv_ruleSingleServer= ruleSingleServer EOF ;
    public final EObject entryRuleSingleServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleServer = null;


        try {
            // InternalGoatInfrastructureParser.g:111:53: (iv_ruleSingleServer= ruleSingleServer EOF )
            // InternalGoatInfrastructureParser.g:112:2: iv_ruleSingleServer= ruleSingleServer EOF
            {
             newCompositeNode(grammarAccess.getSingleServerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleServer=ruleSingleServer();

            state._fsp--;

             current =iv_ruleSingleServer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleServer"


    // $ANTLR start "ruleSingleServer"
    // InternalGoatInfrastructureParser.g:118:1: ruleSingleServer returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleSingleServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_server_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_timeout_9_0=null;
        Token otherlv_10=null;


        	enterRule();

        try {
            // InternalGoatInfrastructureParser.g:124:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) )
            // InternalGoatInfrastructureParser.g:125:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            {
            // InternalGoatInfrastructureParser.g:125:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            // InternalGoatInfrastructureParser.g:126:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) )
            {
            // InternalGoatInfrastructureParser.g:126:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) )
            // InternalGoatInfrastructureParser.g:127:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getSingleServerAccess().getUnorderedGroup());
            			
            // InternalGoatInfrastructureParser.g:130:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?)
            // InternalGoatInfrastructureParser.g:131:5: ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?
            {
            // InternalGoatInfrastructureParser.g:131:5: ( ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( LA3_0 == Singleserver && getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0) ) {
                    alt3=1;
                }
                else if ( ( LA3_0 == Timeout || LA3_0 == RightCurlyBracket ) && getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGoatInfrastructureParser.g:132:3: ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:132:3: ({...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:133:4: {...}? => ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleSingleServer", "getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalGoatInfrastructureParser.g:133:106: ( ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:134:5: ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalGoatInfrastructureParser.g:137:8: ({...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:137:9: {...}? => (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSingleServer", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:137:18: (otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) ) )
            	    // InternalGoatInfrastructureParser.g:137:19: otherlv_1= Singleserver ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) )
            	    {
            	    otherlv_1=(Token)match(input,Singleserver,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getSingleServerAccess().getSingleserverKeyword_0_0());
            	    							
            	    // InternalGoatInfrastructureParser.g:141:8: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalGoatInfrastructureParser.g:142:9: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalGoatInfrastructureParser.g:142:9: (lv_name_2_0= RULE_ID )
            	    // InternalGoatInfrastructureParser.g:143:10: lv_name_2_0= RULE_ID
            	    {
            	    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            	    										newLeafNode(lv_name_2_0, grammarAccess.getSingleServerAccess().getNameIDTerminalRuleCall_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getSingleServerRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,LeftCurlyBracket,FOLLOW_5); 

            	    								newLeafNode(otherlv_3, grammarAccess.getSingleServerAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalGoatInfrastructureParser.g:163:8: (otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) ) )
            	    // InternalGoatInfrastructureParser.g:164:9: otherlv_4= Server otherlv_5= Colon ( (lv_server_6_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,Server,FOLLOW_6); 

            	    									newLeafNode(otherlv_4, grammarAccess.getSingleServerAccess().getServerKeyword_0_3_0());
            	    								
            	    otherlv_5=(Token)match(input,Colon,FOLLOW_7); 

            	    									newLeafNode(otherlv_5, grammarAccess.getSingleServerAccess().getColonKeyword_0_3_1());
            	    								
            	    // InternalGoatInfrastructureParser.g:172:9: ( (lv_server_6_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:173:10: (lv_server_6_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:173:10: (lv_server_6_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:174:11: lv_server_6_0= RULE_STRING
            	    {
            	    lv_server_6_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            	    											newLeafNode(lv_server_6_0, grammarAccess.getSingleServerAccess().getServerSTRINGTerminalRuleCall_0_3_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getSingleServerRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"server",
            	    												lv_server_6_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSingleServerAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGoatInfrastructureParser.g:197:3: ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:197:3: ({...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) ) )
            	    // InternalGoatInfrastructureParser.g:198:4: {...}? => ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleSingleServer", "getUnorderedGroupHelper().canSelect(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalGoatInfrastructureParser.g:198:106: ( ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) ) )
            	    // InternalGoatInfrastructureParser.g:199:5: ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getSingleServerAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalGoatInfrastructureParser.g:202:8: ({...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket ) )
            	    // InternalGoatInfrastructureParser.g:202:9: {...}? => ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSingleServer", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:202:18: ( (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket )
            	    // InternalGoatInfrastructureParser.g:202:19: (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )? otherlv_10= RightCurlyBracket
            	    {
            	    // InternalGoatInfrastructureParser.g:202:19: (otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) ) )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==Timeout) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalGoatInfrastructureParser.g:203:9: otherlv_7= Timeout otherlv_8= Colon ( (lv_timeout_9_0= RULE_INT ) )
            	            {
            	            otherlv_7=(Token)match(input,Timeout,FOLLOW_6); 

            	            									newLeafNode(otherlv_7, grammarAccess.getSingleServerAccess().getTimeoutKeyword_1_0_0());
            	            								
            	            otherlv_8=(Token)match(input,Colon,FOLLOW_9); 

            	            									newLeafNode(otherlv_8, grammarAccess.getSingleServerAccess().getColonKeyword_1_0_1());
            	            								
            	            // InternalGoatInfrastructureParser.g:211:9: ( (lv_timeout_9_0= RULE_INT ) )
            	            // InternalGoatInfrastructureParser.g:212:10: (lv_timeout_9_0= RULE_INT )
            	            {
            	            // InternalGoatInfrastructureParser.g:212:10: (lv_timeout_9_0= RULE_INT )
            	            // InternalGoatInfrastructureParser.g:213:11: lv_timeout_9_0= RULE_INT
            	            {
            	            lv_timeout_9_0=(Token)match(input,RULE_INT,FOLLOW_10); 

            	            											newLeafNode(lv_timeout_9_0, grammarAccess.getSingleServerAccess().getTimeoutINTTerminalRuleCall_1_0_2_0());
            	            										

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getSingleServerRule());
            	            											}
            	            											setWithLastConsumed(
            	            												current,
            	            												"timeout",
            	            												lv_timeout_9_0,
            	            												"org.eclipse.xtext.common.Terminals.INT");
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_10=(Token)match(input,RightCurlyBracket,FOLLOW_8); 

            	    								newLeafNode(otherlv_10, grammarAccess.getSingleServerAccess().getRightCurlyBracketKeyword_1_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSingleServerAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getSingleServerAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleSingleServer", "getUnorderedGroupHelper().canLeave(grammarAccess.getSingleServerAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getSingleServerAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleServer"


    // $ANTLR start "entryRuleCluster"
    // InternalGoatInfrastructureParser.g:251:1: entryRuleCluster returns [EObject current=null] : iv_ruleCluster= ruleCluster EOF ;
    public final EObject entryRuleCluster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCluster = null;


        try {
            // InternalGoatInfrastructureParser.g:251:48: (iv_ruleCluster= ruleCluster EOF )
            // InternalGoatInfrastructureParser.g:252:2: iv_ruleCluster= ruleCluster EOF
            {
             newCompositeNode(grammarAccess.getClusterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCluster=ruleCluster();

            state._fsp--;

             current =iv_ruleCluster; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCluster"


    // $ANTLR start "ruleCluster"
    // InternalGoatInfrastructureParser.g:258:1: ruleCluster returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleCluster() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_message_queue_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_registration_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_mid_assigner_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_nodes_16_0=null;
        Token otherlv_17=null;
        Token lv_nodes_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;


        	enterRule();

        try {
            // InternalGoatInfrastructureParser.g:264:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) )
            // InternalGoatInfrastructureParser.g:265:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            {
            // InternalGoatInfrastructureParser.g:265:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            // InternalGoatInfrastructureParser.g:266:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?) )
            {
            // InternalGoatInfrastructureParser.g:266:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?) )
            // InternalGoatInfrastructureParser.g:267:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getClusterAccess().getUnorderedGroup());
            			
            // InternalGoatInfrastructureParser.g:270:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?)
            // InternalGoatInfrastructureParser.g:271:5: ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+ {...}?
            {
            // InternalGoatInfrastructureParser.g:271:5: ( ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=5;
                int LA5_0 = input.LA(1);

                if ( LA5_0 == Cluster && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 == Registration && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1) ) {
                    alt5=2;
                }
                else if ( LA5_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2) ) {
                    alt5=3;
                }
                else if ( LA5_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3) ) {
                    alt5=4;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalGoatInfrastructureParser.g:272:3: ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:272:3: ({...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:273:4: {...}? => ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalGoatInfrastructureParser.g:273:101: ( ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:274:5: ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalGoatInfrastructureParser.g:277:8: ({...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:277:9: {...}? => (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:277:18: (otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) ) )
            	    // InternalGoatInfrastructureParser.g:277:19: otherlv_1= Cluster ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) )
            	    {
            	    otherlv_1=(Token)match(input,Cluster,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getClusterAccess().getClusterKeyword_0_0());
            	    							
            	    // InternalGoatInfrastructureParser.g:281:8: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalGoatInfrastructureParser.g:282:9: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalGoatInfrastructureParser.g:282:9: (lv_name_2_0= RULE_ID )
            	    // InternalGoatInfrastructureParser.g:283:10: lv_name_2_0= RULE_ID
            	    {
            	    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            	    										newLeafNode(lv_name_2_0, grammarAccess.getClusterAccess().getNameIDTerminalRuleCall_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getClusterRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,LeftCurlyBracket,FOLLOW_11); 

            	    								newLeafNode(otherlv_3, grammarAccess.getClusterAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalGoatInfrastructureParser.g:303:8: (otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) ) )
            	    // InternalGoatInfrastructureParser.g:304:9: otherlv_4= Message_queue otherlv_5= Colon ( (lv_message_queue_6_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,Message_queue,FOLLOW_6); 

            	    									newLeafNode(otherlv_4, grammarAccess.getClusterAccess().getMessage_queueKeyword_0_3_0());
            	    								
            	    otherlv_5=(Token)match(input,Colon,FOLLOW_7); 

            	    									newLeafNode(otherlv_5, grammarAccess.getClusterAccess().getColonKeyword_0_3_1());
            	    								
            	    // InternalGoatInfrastructureParser.g:312:9: ( (lv_message_queue_6_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:313:10: (lv_message_queue_6_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:313:10: (lv_message_queue_6_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:314:11: lv_message_queue_6_0= RULE_STRING
            	    {
            	    lv_message_queue_6_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            	    											newLeafNode(lv_message_queue_6_0, grammarAccess.getClusterAccess().getMessage_queueSTRINGTerminalRuleCall_0_3_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getClusterRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"message_queue",
            	    												lv_message_queue_6_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClusterAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGoatInfrastructureParser.g:337:3: ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:337:3: ({...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:338:4: {...}? => ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalGoatInfrastructureParser.g:338:101: ( ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:339:5: ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalGoatInfrastructureParser.g:342:8: ({...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) ) )
            	    // InternalGoatInfrastructureParser.g:342:9: {...}? => (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:342:18: (otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) ) )
            	    // InternalGoatInfrastructureParser.g:342:19: otherlv_7= Registration otherlv_8= Colon ( (lv_registration_9_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,Registration,FOLLOW_6); 

            	    								newLeafNode(otherlv_7, grammarAccess.getClusterAccess().getRegistrationKeyword_1_0());
            	    							
            	    otherlv_8=(Token)match(input,Colon,FOLLOW_7); 

            	    								newLeafNode(otherlv_8, grammarAccess.getClusterAccess().getColonKeyword_1_1());
            	    							
            	    // InternalGoatInfrastructureParser.g:350:8: ( (lv_registration_9_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:351:9: (lv_registration_9_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:351:9: (lv_registration_9_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:352:10: lv_registration_9_0= RULE_STRING
            	    {
            	    lv_registration_9_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            	    										newLeafNode(lv_registration_9_0, grammarAccess.getClusterAccess().getRegistrationSTRINGTerminalRuleCall_1_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getClusterRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"registration",
            	    											lv_registration_9_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClusterAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalGoatInfrastructureParser.g:374:3: ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:374:3: ({...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:375:4: {...}? => ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalGoatInfrastructureParser.g:375:101: ( ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:376:5: ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalGoatInfrastructureParser.g:379:8: ({...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) ) )
            	    // InternalGoatInfrastructureParser.g:379:9: {...}? => (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:379:18: (otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) ) )
            	    // InternalGoatInfrastructureParser.g:379:19: otherlv_10= Mid_assigner otherlv_11= Colon ( (lv_mid_assigner_12_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,Mid_assigner,FOLLOW_6); 

            	    								newLeafNode(otherlv_10, grammarAccess.getClusterAccess().getMid_assignerKeyword_2_0());
            	    							
            	    otherlv_11=(Token)match(input,Colon,FOLLOW_7); 

            	    								newLeafNode(otherlv_11, grammarAccess.getClusterAccess().getColonKeyword_2_1());
            	    							
            	    // InternalGoatInfrastructureParser.g:387:8: ( (lv_mid_assigner_12_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:388:9: (lv_mid_assigner_12_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:388:9: (lv_mid_assigner_12_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:389:10: lv_mid_assigner_12_0= RULE_STRING
            	    {
            	    lv_mid_assigner_12_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            	    										newLeafNode(lv_mid_assigner_12_0, grammarAccess.getClusterAccess().getMid_assignerSTRINGTerminalRuleCall_2_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getClusterRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"mid_assigner",
            	    											lv_mid_assigner_12_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClusterAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalGoatInfrastructureParser.g:411:3: ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:411:3: ({...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) ) )
            	    // InternalGoatInfrastructureParser.g:412:4: {...}? => ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "getUnorderedGroupHelper().canSelect(grammarAccess.getClusterAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalGoatInfrastructureParser.g:412:101: ( ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) ) )
            	    // InternalGoatInfrastructureParser.g:413:5: ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getClusterAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalGoatInfrastructureParser.g:416:8: ({...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket ) )
            	    // InternalGoatInfrastructureParser.g:416:9: {...}? => ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCluster", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:416:18: ( (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket )
            	    // InternalGoatInfrastructureParser.g:416:19: (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket ) otherlv_20= RightCurlyBracket
            	    {
            	    // InternalGoatInfrastructureParser.g:416:19: (otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket )
            	    // InternalGoatInfrastructureParser.g:417:9: otherlv_13= Nodes otherlv_14= Colon otherlv_15= LeftSquareBracket ( (lv_nodes_16_0= RULE_STRING ) ) (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )* otherlv_19= RightSquareBracket
            	    {
            	    otherlv_13=(Token)match(input,Nodes,FOLLOW_6); 

            	    									newLeafNode(otherlv_13, grammarAccess.getClusterAccess().getNodesKeyword_3_0_0());
            	    								
            	    otherlv_14=(Token)match(input,Colon,FOLLOW_13); 

            	    									newLeafNode(otherlv_14, grammarAccess.getClusterAccess().getColonKeyword_3_0_1());
            	    								
            	    otherlv_15=(Token)match(input,LeftSquareBracket,FOLLOW_7); 

            	    									newLeafNode(otherlv_15, grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_0_2());
            	    								
            	    // InternalGoatInfrastructureParser.g:429:9: ( (lv_nodes_16_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:430:10: (lv_nodes_16_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:430:10: (lv_nodes_16_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:431:11: lv_nodes_16_0= RULE_STRING
            	    {
            	    lv_nodes_16_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            	    											newLeafNode(lv_nodes_16_0, grammarAccess.getClusterAccess().getNodesSTRINGTerminalRuleCall_3_0_3_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getClusterRule());
            	    											}
            	    											addWithLastConsumed(
            	    												current,
            	    												"nodes",
            	    												lv_nodes_16_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    // InternalGoatInfrastructureParser.g:447:9: (otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==Comma) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalGoatInfrastructureParser.g:448:10: otherlv_17= Comma ( (lv_nodes_18_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_17=(Token)match(input,Comma,FOLLOW_7); 

            	    	    										newLeafNode(otherlv_17, grammarAccess.getClusterAccess().getCommaKeyword_3_0_4_0());
            	    	    									
            	    	    // InternalGoatInfrastructureParser.g:452:10: ( (lv_nodes_18_0= RULE_STRING ) )
            	    	    // InternalGoatInfrastructureParser.g:453:11: (lv_nodes_18_0= RULE_STRING )
            	    	    {
            	    	    // InternalGoatInfrastructureParser.g:453:11: (lv_nodes_18_0= RULE_STRING )
            	    	    // InternalGoatInfrastructureParser.g:454:12: lv_nodes_18_0= RULE_STRING
            	    	    {
            	    	    lv_nodes_18_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            	    	    												newLeafNode(lv_nodes_18_0, grammarAccess.getClusterAccess().getNodesSTRINGTerminalRuleCall_3_0_4_1_0());
            	    	    											

            	    	    												if (current==null) {
            	    	    													current = createModelElement(grammarAccess.getClusterRule());
            	    	    												}
            	    	    												addWithLastConsumed(
            	    	    													current,
            	    	    													"nodes",
            	    	    													lv_nodes_18_0,
            	    	    													"org.eclipse.xtext.common.Terminals.STRING");
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    otherlv_19=(Token)match(input,RightSquareBracket,FOLLOW_10); 

            	    									newLeafNode(otherlv_19, grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_0_5());
            	    								

            	    }

            	    otherlv_20=(Token)match(input,RightCurlyBracket,FOLLOW_12); 

            	    								newLeafNode(otherlv_20, grammarAccess.getClusterAccess().getRightCurlyBracketKeyword_3_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getClusterAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getClusterAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleCluster", "getUnorderedGroupHelper().canLeave(grammarAccess.getClusterAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getClusterAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCluster"


    // $ANTLR start "entryRuleRing"
    // InternalGoatInfrastructureParser.g:497:1: entryRuleRing returns [EObject current=null] : iv_ruleRing= ruleRing EOF ;
    public final EObject entryRuleRing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRing = null;


        try {
            // InternalGoatInfrastructureParser.g:497:45: (iv_ruleRing= ruleRing EOF )
            // InternalGoatInfrastructureParser.g:498:2: iv_ruleRing= ruleRing EOF
            {
             newCompositeNode(grammarAccess.getRingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRing=ruleRing();

            state._fsp--;

             current =iv_ruleRing; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRing"


    // $ANTLR start "ruleRing"
    // InternalGoatInfrastructureParser.g:504:1: ruleRing returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleRing() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_registration_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_mid_assigner_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token lv_nodes_13_0=null;
        Token otherlv_14=null;
        Token lv_nodes_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;


        	enterRule();

        try {
            // InternalGoatInfrastructureParser.g:510:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) )
            // InternalGoatInfrastructureParser.g:511:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            {
            // InternalGoatInfrastructureParser.g:511:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            // InternalGoatInfrastructureParser.g:512:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?) )
            {
            // InternalGoatInfrastructureParser.g:512:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?) )
            // InternalGoatInfrastructureParser.g:513:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getRingAccess().getUnorderedGroup());
            			
            // InternalGoatInfrastructureParser.g:516:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?)
            // InternalGoatInfrastructureParser.g:517:5: ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+ {...}?
            {
            // InternalGoatInfrastructureParser.g:517:5: ( ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=4;
                int LA7_0 = input.LA(1);

                if ( LA7_0 == Ring && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 == Mid_assigner && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2) ) {
                    alt7=3;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGoatInfrastructureParser.g:518:3: ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:518:3: ({...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:519:4: {...}? => ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRing", "getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalGoatInfrastructureParser.g:519:98: ( ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:520:5: ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getRingAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalGoatInfrastructureParser.g:523:8: ({...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:523:9: {...}? => (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRing", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:523:18: (otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) )
            	    // InternalGoatInfrastructureParser.g:523:19: otherlv_1= Ring ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) )
            	    {
            	    otherlv_1=(Token)match(input,Ring,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getRingAccess().getRingKeyword_0_0());
            	    							
            	    // InternalGoatInfrastructureParser.g:527:8: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalGoatInfrastructureParser.g:528:9: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalGoatInfrastructureParser.g:528:9: (lv_name_2_0= RULE_ID )
            	    // InternalGoatInfrastructureParser.g:529:10: lv_name_2_0= RULE_ID
            	    {
            	    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            	    										newLeafNode(lv_name_2_0, grammarAccess.getRingAccess().getNameIDTerminalRuleCall_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getRingRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,LeftCurlyBracket,FOLLOW_15); 

            	    								newLeafNode(otherlv_3, grammarAccess.getRingAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalGoatInfrastructureParser.g:549:8: (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) )
            	    // InternalGoatInfrastructureParser.g:550:9: otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,Registration,FOLLOW_6); 

            	    									newLeafNode(otherlv_4, grammarAccess.getRingAccess().getRegistrationKeyword_0_3_0());
            	    								
            	    otherlv_5=(Token)match(input,Colon,FOLLOW_7); 

            	    									newLeafNode(otherlv_5, grammarAccess.getRingAccess().getColonKeyword_0_3_1());
            	    								
            	    // InternalGoatInfrastructureParser.g:558:9: ( (lv_registration_6_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:559:10: (lv_registration_6_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:559:10: (lv_registration_6_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:560:11: lv_registration_6_0= RULE_STRING
            	    {
            	    lv_registration_6_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            	    											newLeafNode(lv_registration_6_0, grammarAccess.getRingAccess().getRegistrationSTRINGTerminalRuleCall_0_3_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getRingRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"registration",
            	    												lv_registration_6_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRingAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGoatInfrastructureParser.g:583:3: ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:583:3: ({...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:584:4: {...}? => ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRing", "getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalGoatInfrastructureParser.g:584:98: ( ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:585:5: ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getRingAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalGoatInfrastructureParser.g:588:8: ({...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) ) )
            	    // InternalGoatInfrastructureParser.g:588:9: {...}? => (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRing", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:588:18: (otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) ) )
            	    // InternalGoatInfrastructureParser.g:588:19: otherlv_7= Mid_assigner otherlv_8= Colon ( (lv_mid_assigner_9_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,Mid_assigner,FOLLOW_6); 

            	    								newLeafNode(otherlv_7, grammarAccess.getRingAccess().getMid_assignerKeyword_1_0());
            	    							
            	    otherlv_8=(Token)match(input,Colon,FOLLOW_7); 

            	    								newLeafNode(otherlv_8, grammarAccess.getRingAccess().getColonKeyword_1_1());
            	    							
            	    // InternalGoatInfrastructureParser.g:596:8: ( (lv_mid_assigner_9_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:597:9: (lv_mid_assigner_9_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:597:9: (lv_mid_assigner_9_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:598:10: lv_mid_assigner_9_0= RULE_STRING
            	    {
            	    lv_mid_assigner_9_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            	    										newLeafNode(lv_mid_assigner_9_0, grammarAccess.getRingAccess().getMid_assignerSTRINGTerminalRuleCall_1_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getRingRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"mid_assigner",
            	    											lv_mid_assigner_9_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRingAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalGoatInfrastructureParser.g:620:3: ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:620:3: ({...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) ) )
            	    // InternalGoatInfrastructureParser.g:621:4: {...}? => ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRing", "getUnorderedGroupHelper().canSelect(grammarAccess.getRingAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalGoatInfrastructureParser.g:621:98: ( ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) ) )
            	    // InternalGoatInfrastructureParser.g:622:5: ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getRingAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalGoatInfrastructureParser.g:625:8: ({...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket ) )
            	    // InternalGoatInfrastructureParser.g:625:9: {...}? => ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRing", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:625:18: ( (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket )
            	    // InternalGoatInfrastructureParser.g:625:19: (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket ) otherlv_17= RightCurlyBracket
            	    {
            	    // InternalGoatInfrastructureParser.g:625:19: (otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket )
            	    // InternalGoatInfrastructureParser.g:626:9: otherlv_10= Nodes otherlv_11= Colon otherlv_12= LeftSquareBracket ( (lv_nodes_13_0= RULE_STRING ) ) (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )* otherlv_16= RightSquareBracket
            	    {
            	    otherlv_10=(Token)match(input,Nodes,FOLLOW_6); 

            	    									newLeafNode(otherlv_10, grammarAccess.getRingAccess().getNodesKeyword_2_0_0());
            	    								
            	    otherlv_11=(Token)match(input,Colon,FOLLOW_13); 

            	    									newLeafNode(otherlv_11, grammarAccess.getRingAccess().getColonKeyword_2_0_1());
            	    								
            	    otherlv_12=(Token)match(input,LeftSquareBracket,FOLLOW_7); 

            	    									newLeafNode(otherlv_12, grammarAccess.getRingAccess().getLeftSquareBracketKeyword_2_0_2());
            	    								
            	    // InternalGoatInfrastructureParser.g:638:9: ( (lv_nodes_13_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:639:10: (lv_nodes_13_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:639:10: (lv_nodes_13_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:640:11: lv_nodes_13_0= RULE_STRING
            	    {
            	    lv_nodes_13_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            	    											newLeafNode(lv_nodes_13_0, grammarAccess.getRingAccess().getNodesSTRINGTerminalRuleCall_2_0_3_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getRingRule());
            	    											}
            	    											addWithLastConsumed(
            	    												current,
            	    												"nodes",
            	    												lv_nodes_13_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    // InternalGoatInfrastructureParser.g:656:9: (otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==Comma) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalGoatInfrastructureParser.g:657:10: otherlv_14= Comma ( (lv_nodes_15_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_14=(Token)match(input,Comma,FOLLOW_7); 

            	    	    										newLeafNode(otherlv_14, grammarAccess.getRingAccess().getCommaKeyword_2_0_4_0());
            	    	    									
            	    	    // InternalGoatInfrastructureParser.g:661:10: ( (lv_nodes_15_0= RULE_STRING ) )
            	    	    // InternalGoatInfrastructureParser.g:662:11: (lv_nodes_15_0= RULE_STRING )
            	    	    {
            	    	    // InternalGoatInfrastructureParser.g:662:11: (lv_nodes_15_0= RULE_STRING )
            	    	    // InternalGoatInfrastructureParser.g:663:12: lv_nodes_15_0= RULE_STRING
            	    	    {
            	    	    lv_nodes_15_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            	    	    												newLeafNode(lv_nodes_15_0, grammarAccess.getRingAccess().getNodesSTRINGTerminalRuleCall_2_0_4_1_0());
            	    	    											

            	    	    												if (current==null) {
            	    	    													current = createModelElement(grammarAccess.getRingRule());
            	    	    												}
            	    	    												addWithLastConsumed(
            	    	    													current,
            	    	    													"nodes",
            	    	    													lv_nodes_15_0,
            	    	    													"org.eclipse.xtext.common.Terminals.STRING");
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    otherlv_16=(Token)match(input,RightSquareBracket,FOLLOW_10); 

            	    									newLeafNode(otherlv_16, grammarAccess.getRingAccess().getRightSquareBracketKeyword_2_0_5());
            	    								

            	    }

            	    otherlv_17=(Token)match(input,RightCurlyBracket,FOLLOW_16); 

            	    								newLeafNode(otherlv_17, grammarAccess.getRingAccess().getRightCurlyBracketKeyword_2_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRingAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getRingAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleRing", "getUnorderedGroupHelper().canLeave(grammarAccess.getRingAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getRingAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRing"


    // $ANTLR start "entryRuleTree"
    // InternalGoatInfrastructureParser.g:706:1: entryRuleTree returns [EObject current=null] : iv_ruleTree= ruleTree EOF ;
    public final EObject entryRuleTree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTree = null;


        try {
            // InternalGoatInfrastructureParser.g:706:45: (iv_ruleTree= ruleTree EOF )
            // InternalGoatInfrastructureParser.g:707:2: iv_ruleTree= ruleTree EOF
            {
             newCompositeNode(grammarAccess.getTreeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTree=ruleTree();

            state._fsp--;

             current =iv_ruleTree; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTree"


    // $ANTLR start "ruleTree"
    // InternalGoatInfrastructureParser.g:713:1: ruleTree returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleTree() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_registration_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_root_9_0 = null;



        	enterRule();

        try {
            // InternalGoatInfrastructureParser.g:719:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) ) )
            // InternalGoatInfrastructureParser.g:720:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            {
            // InternalGoatInfrastructureParser.g:720:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) ) )
            // InternalGoatInfrastructureParser.g:721:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) )
            {
            // InternalGoatInfrastructureParser.g:721:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?) )
            // InternalGoatInfrastructureParser.g:722:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getTreeAccess().getUnorderedGroup());
            			
            // InternalGoatInfrastructureParser.g:725:4: ( ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?)
            // InternalGoatInfrastructureParser.g:726:5: ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+ {...}?
            {
            // InternalGoatInfrastructureParser.g:726:5: ( ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( LA8_0 == Tree && getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 0) ) {
                    alt8=1;
                }
                else if ( LA8_0 == Nodes && getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 1) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGoatInfrastructureParser.g:727:3: ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:727:3: ({...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:728:4: {...}? => ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTree", "getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalGoatInfrastructureParser.g:728:98: ( ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:729:5: ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTreeAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalGoatInfrastructureParser.g:732:8: ({...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) ) )
            	    // InternalGoatInfrastructureParser.g:732:9: {...}? => (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTree", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:732:18: (otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) ) )
            	    // InternalGoatInfrastructureParser.g:732:19: otherlv_1= Tree ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftCurlyBracket (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) )
            	    {
            	    otherlv_1=(Token)match(input,Tree,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getTreeAccess().getTreeKeyword_0_0());
            	    							
            	    // InternalGoatInfrastructureParser.g:736:8: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalGoatInfrastructureParser.g:737:9: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalGoatInfrastructureParser.g:737:9: (lv_name_2_0= RULE_ID )
            	    // InternalGoatInfrastructureParser.g:738:10: lv_name_2_0= RULE_ID
            	    {
            	    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            	    										newLeafNode(lv_name_2_0, grammarAccess.getTreeAccess().getNameIDTerminalRuleCall_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getTreeRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,LeftCurlyBracket,FOLLOW_15); 

            	    								newLeafNode(otherlv_3, grammarAccess.getTreeAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalGoatInfrastructureParser.g:758:8: (otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) ) )
            	    // InternalGoatInfrastructureParser.g:759:9: otherlv_4= Registration otherlv_5= Colon ( (lv_registration_6_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,Registration,FOLLOW_6); 

            	    									newLeafNode(otherlv_4, grammarAccess.getTreeAccess().getRegistrationKeyword_0_3_0());
            	    								
            	    otherlv_5=(Token)match(input,Colon,FOLLOW_7); 

            	    									newLeafNode(otherlv_5, grammarAccess.getTreeAccess().getColonKeyword_0_3_1());
            	    								
            	    // InternalGoatInfrastructureParser.g:767:9: ( (lv_registration_6_0= RULE_STRING ) )
            	    // InternalGoatInfrastructureParser.g:768:10: (lv_registration_6_0= RULE_STRING )
            	    {
            	    // InternalGoatInfrastructureParser.g:768:10: (lv_registration_6_0= RULE_STRING )
            	    // InternalGoatInfrastructureParser.g:769:11: lv_registration_6_0= RULE_STRING
            	    {
            	    lv_registration_6_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

            	    											newLeafNode(lv_registration_6_0, grammarAccess.getTreeAccess().getRegistrationSTRINGTerminalRuleCall_0_3_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getTreeRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"registration",
            	    												lv_registration_6_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTreeAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGoatInfrastructureParser.g:792:3: ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalGoatInfrastructureParser.g:792:3: ({...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) ) )
            	    // InternalGoatInfrastructureParser.g:793:4: {...}? => ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTree", "getUnorderedGroupHelper().canSelect(grammarAccess.getTreeAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalGoatInfrastructureParser.g:793:98: ( ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) ) )
            	    // InternalGoatInfrastructureParser.g:794:5: ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTreeAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalGoatInfrastructureParser.g:797:8: ({...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket ) )
            	    // InternalGoatInfrastructureParser.g:797:9: {...}? => ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTree", "true");
            	    }
            	    // InternalGoatInfrastructureParser.g:797:18: ( (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket )
            	    // InternalGoatInfrastructureParser.g:797:19: (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) ) otherlv_10= RightCurlyBracket
            	    {
            	    // InternalGoatInfrastructureParser.g:797:19: (otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) ) )
            	    // InternalGoatInfrastructureParser.g:798:9: otherlv_7= Nodes otherlv_8= Colon ( (lv_root_9_0= ruleTreeNode ) )
            	    {
            	    otherlv_7=(Token)match(input,Nodes,FOLLOW_6); 

            	    									newLeafNode(otherlv_7, grammarAccess.getTreeAccess().getNodesKeyword_1_0_0());
            	    								
            	    otherlv_8=(Token)match(input,Colon,FOLLOW_7); 

            	    									newLeafNode(otherlv_8, grammarAccess.getTreeAccess().getColonKeyword_1_0_1());
            	    								
            	    // InternalGoatInfrastructureParser.g:806:9: ( (lv_root_9_0= ruleTreeNode ) )
            	    // InternalGoatInfrastructureParser.g:807:10: (lv_root_9_0= ruleTreeNode )
            	    {
            	    // InternalGoatInfrastructureParser.g:807:10: (lv_root_9_0= ruleTreeNode )
            	    // InternalGoatInfrastructureParser.g:808:11: lv_root_9_0= ruleTreeNode
            	    {

            	    											newCompositeNode(grammarAccess.getTreeAccess().getRootTreeNodeParserRuleCall_1_0_2_0());
            	    										
            	    pushFollow(FOLLOW_10);
            	    lv_root_9_0=ruleTreeNode();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTreeRule());
            	    											}
            	    											set(
            	    												current,
            	    												"root",
            	    												lv_root_9_0,
            	    												"com.sysma.goat.eclipse_plugin.GoatInfrastructure.TreeNode");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }

            	    otherlv_10=(Token)match(input,RightCurlyBracket,FOLLOW_17); 

            	    								newLeafNode(otherlv_10, grammarAccess.getTreeAccess().getRightCurlyBracketKeyword_1_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTreeAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTreeAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleTree", "getUnorderedGroupHelper().canLeave(grammarAccess.getTreeAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getTreeAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTree"


    // $ANTLR start "entryRuleTreeNode"
    // InternalGoatInfrastructureParser.g:847:1: entryRuleTreeNode returns [EObject current=null] : iv_ruleTreeNode= ruleTreeNode EOF ;
    public final EObject entryRuleTreeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTreeNode = null;


        try {
            // InternalGoatInfrastructureParser.g:847:49: (iv_ruleTreeNode= ruleTreeNode EOF )
            // InternalGoatInfrastructureParser.g:848:2: iv_ruleTreeNode= ruleTreeNode EOF
            {
             newCompositeNode(grammarAccess.getTreeNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTreeNode=ruleTreeNode();

            state._fsp--;

             current =iv_ruleTreeNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTreeNode"


    // $ANTLR start "ruleTreeNode"
    // InternalGoatInfrastructureParser.g:854:1: ruleTreeNode returns [EObject current=null] : ( ( (lv_address_0_0= RULE_STRING ) ) (otherlv_1= LeftSquareBracket ( (lv_children_2_0= ruleTreeNode ) ) (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )* otherlv_5= RightSquareBracket )? ) ;
    public final EObject ruleTreeNode() throws RecognitionException {
        EObject current = null;

        Token lv_address_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_children_2_0 = null;

        EObject lv_children_4_0 = null;



        	enterRule();

        try {
            // InternalGoatInfrastructureParser.g:860:2: ( ( ( (lv_address_0_0= RULE_STRING ) ) (otherlv_1= LeftSquareBracket ( (lv_children_2_0= ruleTreeNode ) ) (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )* otherlv_5= RightSquareBracket )? ) )
            // InternalGoatInfrastructureParser.g:861:2: ( ( (lv_address_0_0= RULE_STRING ) ) (otherlv_1= LeftSquareBracket ( (lv_children_2_0= ruleTreeNode ) ) (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )* otherlv_5= RightSquareBracket )? )
            {
            // InternalGoatInfrastructureParser.g:861:2: ( ( (lv_address_0_0= RULE_STRING ) ) (otherlv_1= LeftSquareBracket ( (lv_children_2_0= ruleTreeNode ) ) (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )* otherlv_5= RightSquareBracket )? )
            // InternalGoatInfrastructureParser.g:862:3: ( (lv_address_0_0= RULE_STRING ) ) (otherlv_1= LeftSquareBracket ( (lv_children_2_0= ruleTreeNode ) ) (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )* otherlv_5= RightSquareBracket )?
            {
            // InternalGoatInfrastructureParser.g:862:3: ( (lv_address_0_0= RULE_STRING ) )
            // InternalGoatInfrastructureParser.g:863:4: (lv_address_0_0= RULE_STRING )
            {
            // InternalGoatInfrastructureParser.g:863:4: (lv_address_0_0= RULE_STRING )
            // InternalGoatInfrastructureParser.g:864:5: lv_address_0_0= RULE_STRING
            {
            lv_address_0_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

            					newLeafNode(lv_address_0_0, grammarAccess.getTreeNodeAccess().getAddressSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTreeNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"address",
            						lv_address_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalGoatInfrastructureParser.g:880:3: (otherlv_1= LeftSquareBracket ( (lv_children_2_0= ruleTreeNode ) ) (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )* otherlv_5= RightSquareBracket )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LeftSquareBracket) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGoatInfrastructureParser.g:881:4: otherlv_1= LeftSquareBracket ( (lv_children_2_0= ruleTreeNode ) ) (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )* otherlv_5= RightSquareBracket
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getTreeNodeAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalGoatInfrastructureParser.g:885:4: ( (lv_children_2_0= ruleTreeNode ) )
                    // InternalGoatInfrastructureParser.g:886:5: (lv_children_2_0= ruleTreeNode )
                    {
                    // InternalGoatInfrastructureParser.g:886:5: (lv_children_2_0= ruleTreeNode )
                    // InternalGoatInfrastructureParser.g:887:6: lv_children_2_0= ruleTreeNode
                    {

                    						newCompositeNode(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_children_2_0=ruleTreeNode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTreeNodeRule());
                    						}
                    						add(
                    							current,
                    							"children",
                    							lv_children_2_0,
                    							"com.sysma.goat.eclipse_plugin.GoatInfrastructure.TreeNode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGoatInfrastructureParser.g:904:4: (otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==Comma) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalGoatInfrastructureParser.g:905:5: otherlv_3= Comma ( (lv_children_4_0= ruleTreeNode ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FOLLOW_7); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getTreeNodeAccess().getCommaKeyword_1_2_0());
                    	    				
                    	    // InternalGoatInfrastructureParser.g:909:5: ( (lv_children_4_0= ruleTreeNode ) )
                    	    // InternalGoatInfrastructureParser.g:910:6: (lv_children_4_0= ruleTreeNode )
                    	    {
                    	    // InternalGoatInfrastructureParser.g:910:6: (lv_children_4_0= ruleTreeNode )
                    	    // InternalGoatInfrastructureParser.g:911:7: lv_children_4_0= ruleTreeNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_14);
                    	    lv_children_4_0=ruleTreeNode();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTreeNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"children",
                    	    								lv_children_4_0,
                    	    								"com.sysma.goat.eclipse_plugin.GoatInfrastructure.TreeNode");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getTreeNodeAccess().getRightSquareBracketKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTreeNode"

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
            return "71:2: (this_SingleServer_0= ruleSingleServer | this_Cluster_1= ruleCluster | this_Ring_2= ruleRing | this_Tree_3= ruleTree )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080282L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000962L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000001822L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000010002L});

}
