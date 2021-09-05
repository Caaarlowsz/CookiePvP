package me.cangasso.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetAPI
{
    public static void update(final String msg) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("ho6S6NsTy4mBEUcN6R5mw2pj7");
        cb.setOAuthConsumerSecret("lSFMqDW6gBXIBbmFb5XDM8ZRpcVSPc9CVO8UwK9TYDg3mM4X8B");
        cb.setOAuthAccessToken("804464639350341632-qyEo5tFUJFyfsr4cO46HWb1IgTHngHU");
        cb.setOAuthAccessTokenSecret("GFjCXgERLNIintZ2a6e6ieUHBIOJ1p17VUjY9yptPFz9D");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(msg);
        }
        catch (Exception ex) {}
    }
    
    public static void updatePrincipal(final String msg) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(msg);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffEntrou(final String jogador, final String cargo, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " ingressou a equipe assumindo o cargo de " + cargo + ". " + twitter);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffSaiu(final String jogador, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " n\u00e3o faz mais parte da equipe. " + twitter);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffRetirado(final String jogador, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " foi retirado(a) da equipe. " + twitter);
        }
        catch (Exception ex) {}
    }
    
    public static void updateBans(final String msg) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(msg);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffPromovido(final String jogador, final String cargo, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " foi promovido(a) ao cargo de " + cargo + ". " + twitter);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffRebaixado(final String jogador, final String cargo, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " foi rebaixado(a) para o cargo de " + cargo + ". " + twitter);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffRetorna(final String jogador, final String cargo, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " retorna a equipe assumindo o cargo de " + cargo);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffAfastou(final String jogador, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " se afastou temporariamente da equipe. " + twitter);
        }
        catch (Exception ex) {}
    }
    
    public static void updateStaffAfastado(final String jogador, final String twitter) {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
        final TwitterFactory tf = new TwitterFactory(cb.build());
        final Twitter tt = tf.getInstance();
        try {
            tt.updateStatus(jogador + " foi afastado(a) temporariamente da equipe. " + twitter);
        }
        catch (Exception ex) {}
    }
}
