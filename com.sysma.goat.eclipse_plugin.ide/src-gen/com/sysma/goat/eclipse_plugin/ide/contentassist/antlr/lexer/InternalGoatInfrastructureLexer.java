package com.sysma.goat.eclipse_plugin.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGoatInfrastructureLexer extends Lexer {
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

    public InternalGoatInfrastructureLexer() {;} 
    public InternalGoatInfrastructureLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalGoatInfrastructureLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalGoatInfrastructureLexer.g"; }

    // $ANTLR start "Message_queue"
    public final void mMessage_queue() throws RecognitionException {
        try {
            int _type = Message_queue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:14:15: ( 'message_queue' )
            // InternalGoatInfrastructureLexer.g:14:17: 'message_queue'
            {
            match("message_queue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Message_queue"

    // $ANTLR start "Mid_assigner"
    public final void mMid_assigner() throws RecognitionException {
        try {
            int _type = Mid_assigner;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:16:14: ( 'mid_assigner' )
            // InternalGoatInfrastructureLexer.g:16:16: 'mid_assigner'
            {
            match("mid_assigner"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mid_assigner"

    // $ANTLR start "Registration"
    public final void mRegistration() throws RecognitionException {
        try {
            int _type = Registration;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:18:14: ( 'registration' )
            // InternalGoatInfrastructureLexer.g:18:16: 'registration'
            {
            match("registration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Registration"

    // $ANTLR start "Singleserver"
    public final void mSingleserver() throws RecognitionException {
        try {
            int _type = Singleserver;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:20:14: ( 'singleserver' )
            // InternalGoatInfrastructureLexer.g:20:16: 'singleserver'
            {
            match("singleserver"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Singleserver"

    // $ANTLR start "Cluster"
    public final void mCluster() throws RecognitionException {
        try {
            int _type = Cluster;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:22:9: ( 'cluster' )
            // InternalGoatInfrastructureLexer.g:22:11: 'cluster'
            {
            match("cluster"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Cluster"

    // $ANTLR start "Timeout"
    public final void mTimeout() throws RecognitionException {
        try {
            int _type = Timeout;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:24:9: ( 'timeout' )
            // InternalGoatInfrastructureLexer.g:24:11: 'timeout'
            {
            match("timeout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Timeout"

    // $ANTLR start "Server"
    public final void mServer() throws RecognitionException {
        try {
            int _type = Server;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:26:8: ( 'server' )
            // InternalGoatInfrastructureLexer.g:26:10: 'server'
            {
            match("server"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Server"

    // $ANTLR start "Nodes"
    public final void mNodes() throws RecognitionException {
        try {
            int _type = Nodes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:28:7: ( 'nodes' )
            // InternalGoatInfrastructureLexer.g:28:9: 'nodes'
            {
            match("nodes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Nodes"

    // $ANTLR start "Ring"
    public final void mRing() throws RecognitionException {
        try {
            int _type = Ring;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:30:6: ( 'ring' )
            // InternalGoatInfrastructureLexer.g:30:8: 'ring'
            {
            match("ring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ring"

    // $ANTLR start "Tree"
    public final void mTree() throws RecognitionException {
        try {
            int _type = Tree;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:32:6: ( 'tree' )
            // InternalGoatInfrastructureLexer.g:32:8: 'tree'
            {
            match("tree"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Tree"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:34:7: ( ',' )
            // InternalGoatInfrastructureLexer.g:34:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:36:7: ( ':' )
            // InternalGoatInfrastructureLexer.g:36:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:38:19: ( '[' )
            // InternalGoatInfrastructureLexer.g:38:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:40:20: ( ']' )
            // InternalGoatInfrastructureLexer.g:40:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:42:18: ( '{' )
            // InternalGoatInfrastructureLexer.g:42:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:44:19: ( '}' )
            // InternalGoatInfrastructureLexer.g:44:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:46:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalGoatInfrastructureLexer.g:46:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalGoatInfrastructureLexer.g:46:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalGoatInfrastructureLexer.g:46:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalGoatInfrastructureLexer.g:46:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGoatInfrastructureLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:48:10: ( ( '0' .. '9' )+ )
            // InternalGoatInfrastructureLexer.g:48:12: ( '0' .. '9' )+
            {
            // InternalGoatInfrastructureLexer.g:48:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGoatInfrastructureLexer.g:48:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:50:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalGoatInfrastructureLexer.g:50:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalGoatInfrastructureLexer.g:50:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalGoatInfrastructureLexer.g:50:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalGoatInfrastructureLexer.g:50:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalGoatInfrastructureLexer.g:50:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalGoatInfrastructureLexer.g:50:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalGoatInfrastructureLexer.g:50:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalGoatInfrastructureLexer.g:50:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalGoatInfrastructureLexer.g:50:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalGoatInfrastructureLexer.g:50:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:52:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalGoatInfrastructureLexer.g:52:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalGoatInfrastructureLexer.g:52:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGoatInfrastructureLexer.g:52:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:54:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalGoatInfrastructureLexer.g:54:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalGoatInfrastructureLexer.g:54:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGoatInfrastructureLexer.g:54:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalGoatInfrastructureLexer.g:54:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGoatInfrastructureLexer.g:54:41: ( '\\r' )? '\\n'
                    {
                    // InternalGoatInfrastructureLexer.g:54:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalGoatInfrastructureLexer.g:54:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:56:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalGoatInfrastructureLexer.g:56:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalGoatInfrastructureLexer.g:56:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGoatInfrastructureLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalGoatInfrastructureLexer.g:58:16: ( . )
            // InternalGoatInfrastructureLexer.g:58:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalGoatInfrastructureLexer.g:1:8: ( Message_queue | Mid_assigner | Registration | Singleserver | Cluster | Timeout | Server | Nodes | Ring | Tree | Comma | Colon | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=23;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalGoatInfrastructureLexer.g:1:10: Message_queue
                {
                mMessage_queue(); 

                }
                break;
            case 2 :
                // InternalGoatInfrastructureLexer.g:1:24: Mid_assigner
                {
                mMid_assigner(); 

                }
                break;
            case 3 :
                // InternalGoatInfrastructureLexer.g:1:37: Registration
                {
                mRegistration(); 

                }
                break;
            case 4 :
                // InternalGoatInfrastructureLexer.g:1:50: Singleserver
                {
                mSingleserver(); 

                }
                break;
            case 5 :
                // InternalGoatInfrastructureLexer.g:1:63: Cluster
                {
                mCluster(); 

                }
                break;
            case 6 :
                // InternalGoatInfrastructureLexer.g:1:71: Timeout
                {
                mTimeout(); 

                }
                break;
            case 7 :
                // InternalGoatInfrastructureLexer.g:1:79: Server
                {
                mServer(); 

                }
                break;
            case 8 :
                // InternalGoatInfrastructureLexer.g:1:86: Nodes
                {
                mNodes(); 

                }
                break;
            case 9 :
                // InternalGoatInfrastructureLexer.g:1:92: Ring
                {
                mRing(); 

                }
                break;
            case 10 :
                // InternalGoatInfrastructureLexer.g:1:97: Tree
                {
                mTree(); 

                }
                break;
            case 11 :
                // InternalGoatInfrastructureLexer.g:1:102: Comma
                {
                mComma(); 

                }
                break;
            case 12 :
                // InternalGoatInfrastructureLexer.g:1:108: Colon
                {
                mColon(); 

                }
                break;
            case 13 :
                // InternalGoatInfrastructureLexer.g:1:114: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 14 :
                // InternalGoatInfrastructureLexer.g:1:132: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 15 :
                // InternalGoatInfrastructureLexer.g:1:151: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 16 :
                // InternalGoatInfrastructureLexer.g:1:168: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 17 :
                // InternalGoatInfrastructureLexer.g:1:186: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 18 :
                // InternalGoatInfrastructureLexer.g:1:194: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 19 :
                // InternalGoatInfrastructureLexer.g:1:203: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 20 :
                // InternalGoatInfrastructureLexer.g:1:215: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 21 :
                // InternalGoatInfrastructureLexer.g:1:231: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 22 :
                // InternalGoatInfrastructureLexer.g:1:247: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 23 :
                // InternalGoatInfrastructureLexer.g:1:255: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\6\27\6\uffff\1\24\2\uffff\3\24\2\uffff\2\27\1\uffff\10\27\13\uffff\15\27\1\102\4\27\1\107\4\27\1\uffff\4\27\1\uffff\1\120\4\27\1\125\2\27\1\uffff\4\27\1\uffff\1\134\1\135\4\27\2\uffff\15\27\1\157\1\160\1\161\1\162\4\uffff";
    static final String DFA12_eofS =
        "\163\uffff";
    static final String DFA12_minS =
        "\1\0\3\145\1\154\1\151\1\157\6\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\163\1\144\1\uffff\1\147\2\156\1\162\1\165\1\155\1\145\1\144\13\uffff\1\163\1\137\1\151\2\147\1\166\1\163\3\145\2\141\1\163\1\60\1\154\1\145\1\164\1\157\1\60\1\163\1\147\1\163\1\164\1\uffff\1\145\1\162\1\145\1\165\1\uffff\1\60\1\145\1\163\1\162\1\163\1\60\1\162\1\164\1\uffff\1\137\1\151\1\141\1\145\1\uffff\2\60\1\161\1\147\1\164\1\162\2\uffff\1\165\1\156\1\151\1\166\2\145\1\157\1\145\1\165\1\162\1\156\1\162\1\145\4\60\4\uffff";
    static final String DFA12_maxS =
        "\1\uffff\3\151\1\154\1\162\1\157\6\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\163\1\144\1\uffff\1\147\2\156\1\162\1\165\1\155\1\145\1\144\13\uffff\1\163\1\137\1\151\2\147\1\166\1\163\3\145\2\141\1\163\1\172\1\154\1\145\1\164\1\157\1\172\1\163\1\147\1\163\1\164\1\uffff\1\145\1\162\1\145\1\165\1\uffff\1\172\1\145\1\163\1\162\1\163\1\172\1\162\1\164\1\uffff\1\137\1\151\1\141\1\145\1\uffff\2\172\1\161\1\147\1\164\1\162\2\uffff\1\165\1\156\1\151\1\166\2\145\1\157\1\145\1\165\1\162\1\156\1\162\1\145\4\172\4\uffff";
    static final String DFA12_acceptS =
        "\7\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\uffff\1\21\1\22\3\uffff\1\26\1\27\2\uffff\1\21\10\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\22\1\23\1\24\1\25\1\26\27\uffff\1\11\4\uffff\1\12\10\uffff\1\10\4\uffff\1\7\6\uffff\1\5\1\6\21\uffff\1\2\1\3\1\4\1\1";
    static final String DFA12_specialS =
        "\1\1\17\uffff\1\0\1\2\141\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\24\2\23\2\24\1\23\22\24\1\23\1\24\1\20\4\24\1\21\4\24\1\7\2\24\1\22\12\17\1\10\6\24\32\16\1\11\1\24\1\12\1\15\1\16\1\24\2\16\1\4\11\16\1\1\1\6\3\16\1\2\1\3\1\5\6\16\1\13\1\24\1\14\uff82\24",
            "\1\25\3\uffff\1\26",
            "\1\30\3\uffff\1\31",
            "\1\33\3\uffff\1\32",
            "\1\34",
            "\1\35\10\uffff\1\36",
            "\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "\0\47",
            "\0\47",
            "\1\50\4\uffff\1\51",
            "",
            "",
            "\1\53",
            "\1\54",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\126",
            "\1\127",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "",
            "",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Message_queue | Mid_assigner | Registration | Singleserver | Cluster | Timeout | Server | Nodes | Ring | Tree | Comma | Colon | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_16 = input.LA(1);

                        s = -1;
                        if ( ((LA12_16>='\u0000' && LA12_16<='\uFFFF')) ) {s = 39;}

                        else s = 20;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='m') ) {s = 1;}

                        else if ( (LA12_0=='r') ) {s = 2;}

                        else if ( (LA12_0=='s') ) {s = 3;}

                        else if ( (LA12_0=='c') ) {s = 4;}

                        else if ( (LA12_0=='t') ) {s = 5;}

                        else if ( (LA12_0=='n') ) {s = 6;}

                        else if ( (LA12_0==',') ) {s = 7;}

                        else if ( (LA12_0==':') ) {s = 8;}

                        else if ( (LA12_0=='[') ) {s = 9;}

                        else if ( (LA12_0==']') ) {s = 10;}

                        else if ( (LA12_0=='{') ) {s = 11;}

                        else if ( (LA12_0=='}') ) {s = 12;}

                        else if ( (LA12_0=='^') ) {s = 13;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='d' && LA12_0<='l')||(LA12_0>='o' && LA12_0<='q')||(LA12_0>='u' && LA12_0<='z')) ) {s = 14;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 15;}

                        else if ( (LA12_0=='\"') ) {s = 16;}

                        else if ( (LA12_0=='\'') ) {s = 17;}

                        else if ( (LA12_0=='/') ) {s = 18;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 19;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='+')||(LA12_0>='-' && LA12_0<='.')||(LA12_0>=';' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 20;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_17 = input.LA(1);

                        s = -1;
                        if ( ((LA12_17>='\u0000' && LA12_17<='\uFFFF')) ) {s = 39;}

                        else s = 20;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}