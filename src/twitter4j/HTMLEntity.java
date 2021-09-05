package twitter4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class HTMLEntity
{
    private static final Map<String, String> entityEscapeMap;
    private static final Map<String, String> escapeEntityMap;
    
    static {
        entityEscapeMap = new HashMap<String, String>();
        escapeEntityMap = new HashMap<String, String>();
        final String[][] entities = { { "&nbsp;", "&#160;", " " }, { "&iexcl;", "&#161;", "¡" }, { "&cent;", "&#162;", "¢" }, { "&pound;", "&#163;", "£" }, { "&curren;", "&#164;", "¤" }, { "&yen;", "&#165;", "¥" }, { "&brvbar;", "&#166;", "¦" }, { "&sect;", "&#167;", "§" }, { "&uml;", "&#168;", "¨" }, { "&copy;", "&#169;", "©" }, { "&ordf;", "&#170;", "ª" }, { "&laquo;", "&#171;", "«" }, { "&not;", "&#172;", "¬" }, { "&shy;", "&#173;", "\u00ad" }, { "&reg;", "&#174;", "®" }, { "&macr;", "&#175;", "¯" }, { "&deg;", "&#176;", "°" }, { "&plusmn;", "&#177;", "±" }, { "&sup2;", "&#178;", "²" }, { "&sup3;", "&#179;", "³" }, { "&acute;", "&#180;", "´" }, { "&micro;", "&#181;", "µ" }, { "&para;", "&#182;", "¶" }, { "&middot;", "&#183;", "·" }, { "&cedil;", "&#184;", "¸" }, { "&sup1;", "&#185;", "¹" }, { "&ordm;", "&#186;", "º" }, { "&raquo;", "&#187;", "»" }, { "&frac14;", "&#188;", "¼" }, { "&frac12;", "&#189;", "½" }, { "&frac34;", "&#190;", "¾" }, { "&iquest;", "&#191;", "¿" }, { "&Agrave;", "&#192;", "\u00c0" }, { "&Aacute;", "&#193;", "\u00c1" }, { "&Acirc;", "&#194;", "\u00c2" }, { "&Atilde;", "&#195;", "\u00c3" }, { "&Auml;", "&#196;", "\u00c4" }, { "&Aring;", "&#197;", "\u00c5" }, { "&AElig;", "&#198;", "\u00c6" }, { "&Ccedil;", "&#199;", "\u00c7" }, { "&Egrave;", "&#200;", "\u00c8" }, { "&Eacute;", "&#201;", "\u00c9" }, { "&Ecirc;", "&#202;", "\u00ca" }, { "&Euml;", "&#203;", "\u00cb" }, { "&Igrave;", "&#204;", "\u00cc" }, { "&Iacute;", "&#205;", "\u00cd" }, { "&Icirc;", "&#206;", "\u00ce" }, { "&Iuml;", "&#207;", "\u00cf" }, { "&ETH;", "&#208;", "\u00d0" }, { "&Ntilde;", "&#209;", "\u00d1" }, { "&Ograve;", "&#210;", "\u00d2" }, { "&Oacute;", "&#211;", "\u00d3" }, { "&Ocirc;", "&#212;", "\u00d4" }, { "&Otilde;", "&#213;", "\u00d5" }, { "&Ouml;", "&#214;", "\u00d6" }, { "&times;", "&#215;", "\u00d7" }, { "&Oslash;", "&#216;", "\u00d8" }, { "&Ugrave;", "&#217;", "\u00d9" }, { "&Uacute;", "&#218;", "\u00da" }, { "&Ucirc;", "&#219;", "\u00db" }, { "&Uuml;", "&#220;", "\u00dc" }, { "&Yacute;", "&#221;", "\u00dd" }, { "&THORN;", "&#222;", "\u00de" }, { "&szlig;", "&#223;", "\u00df" }, { "&agrave;", "&#224;", "\u00e0" }, { "&aacute;", "&#225;", "\u00e1" }, { "&acirc;", "&#226;", "\u00e2" }, { "&atilde;", "&#227;", "\u00e3" }, { "&auml;", "&#228;", "\u00e4" }, { "&aring;", "&#229;", "\u00e5" }, { "&aelig;", "&#230;", "\u00e6" }, { "&ccedil;", "&#231;", "\u00e7" }, { "&egrave;", "&#232;", "\u00e8" }, { "&eacute;", "&#233;", "\u00e9" }, { "&ecirc;", "&#234;", "\u00ea" }, { "&euml;", "&#235;", "\u00eb" }, { "&igrave;", "&#236;", "\u00ec" }, { "&iacute;", "&#237;", "\u00ed" }, { "&icirc;", "&#238;", "\u00ee" }, { "&iuml;", "&#239;", "\u00ef" }, { "&eth;", "&#240;", "\u00f0" }, { "&ntilde;", "&#241;", "\u00f1" }, { "&ograve;", "&#242;", "\u00f2" }, { "&oacute;", "&#243;", "\u00f3" }, { "&ocirc;", "&#244;", "\u00f4" }, { "&otilde;", "&#245;", "\u00f5" }, { "&ouml;", "&#246;", "\u00f6" }, { "&divide;", "&#247;", "\u00f7" }, { "&oslash;", "&#248;", "\u00f8" }, { "&ugrave;", "&#249;", "\u00f9" }, { "&uacute;", "&#250;", "\u00fa" }, { "&ucirc;", "&#251;", "\u00fb" }, { "&uuml;", "&#252;", "\u00fc" }, { "&yacute;", "&#253;", "\u00fd" }, { "&thorn;", "&#254;", "\u00fe" }, { "&yuml;", "&#255;", "\u00ff" }, { "&fnof;", "&#402;", "\u0192" }, { "&Alpha;", "&#913;", "\u0391" }, { "&Beta;", "&#914;", "\u0392" }, { "&Gamma;", "&#915;", "\u0393" }, { "&Delta;", "&#916;", "\u0394" }, { "&Epsilon;", "&#917;", "\u0395" }, { "&Zeta;", "&#918;", "\u0396" }, { "&Eta;", "&#919;", "\u0397" }, { "&Theta;", "&#920;", "\u0398" }, { "&Iota;", "&#921;", "\u0399" }, { "&Kappa;", "&#922;", "\u039a" }, { "&Lambda;", "&#923;", "\u039b" }, { "&Mu;", "&#924;", "\u039c" }, { "&Nu;", "&#925;", "\u039d" }, { "&Xi;", "&#926;", "\u039e" }, { "&Omicron;", "&#927;", "\u039f" }, { "&Pi;", "&#928;", "\u03a0" }, { "&Rho;", "&#929;", "\u03a1" }, { "&Sigma;", "&#931;", "\u03a3" }, { "&Tau;", "&#932;", "\u03a4" }, { "&Upsilon;", "&#933;", "\u03a5" }, { "&Phi;", "&#934;", "\u03a6" }, { "&Chi;", "&#935;", "\u03a7" }, { "&Psi;", "&#936;", "\u03a8" }, { "&Omega;", "&#937;", "\u03a9" }, { "&alpha;", "&#945;", "\u03b1" }, { "&beta;", "&#946;", "\u03b2" }, { "&gamma;", "&#947;", "\u03b3" }, { "&delta;", "&#948;", "\u03b4" }, { "&epsilon;", "&#949;", "\u03b5" }, { "&zeta;", "&#950;", "\u03b6" }, { "&eta;", "&#951;", "\u03b7" }, { "&theta;", "&#952;", "\u03b8" }, { "&iota;", "&#953;", "\u03b9" }, { "&kappa;", "&#954;", "\u03ba" }, { "&lambda;", "&#955;", "\u03bb" }, { "&mu;", "&#956;", "\u03bc" }, { "&nu;", "&#957;", "\u03bd" }, { "&xi;", "&#958;", "\u03be" }, { "&omicron;", "&#959;", "\u03bf" }, { "&pi;", "&#960;", "\u03c0" }, { "&rho;", "&#961;", "\u03c1" }, { "&sigmaf;", "&#962;", "\u03c2" }, { "&sigma;", "&#963;", "\u03c3" }, { "&tau;", "&#964;", "\u03c4" }, { "&upsilon;", "&#965;", "\u03c5" }, { "&phi;", "&#966;", "\u03c6" }, { "&chi;", "&#967;", "\u03c7" }, { "&psi;", "&#968;", "\u03c8" }, { "&omega;", "&#969;", "\u03c9" }, { "&thetasym;", "&#977;", "\u03d1" }, { "&upsih;", "&#978;", "\u03d2" }, { "&piv;", "&#982;", "\u03d6" }, { "&bull;", "&#8226;", "\u2022" }, { "&hellip;", "&#8230;", "\u2026" }, { "&prime;", "&#8242;", "\u2032" }, { "&Prime;", "&#8243;", "\u2033" }, { "&oline;", "&#8254;", "\u203e" }, { "&frasl;", "&#8260;", "\u2044" }, { "&weierp;", "&#8472;", "\u2118" }, { "&image;", "&#8465;", "\u2111" }, { "&real;", "&#8476;", "\u211c" }, { "&trade;", "&#8482;", "\u2122" }, { "&alefsym;", "&#8501;", "\u2135" }, { "&larr;", "&#8592;", "\u2190" }, { "&uarr;", "&#8593;", "\u2191" }, { "&rarr;", "&#8594;", "\u2192" }, { "&darr;", "&#8595;", "\u2193" }, { "&harr;", "&#8596;", "\u2194" }, { "&crarr;", "&#8629;", "\u21b5" }, { "&lArr;", "&#8656;", "\u21d0" }, { "&uArr;", "&#8657;", "\u21d1" }, { "&rArr;", "&#8658;", "\u21d2" }, { "&dArr;", "&#8659;", "\u21d3" }, { "&hArr;", "&#8660;", "\u21d4" }, { "&forall;", "&#8704;", "\u2200" }, { "&part;", "&#8706;", "\u2202" }, { "&exist;", "&#8707;", "\u2203" }, { "&empty;", "&#8709;", "\u2205" }, { "&nabla;", "&#8711;", "\u2207" }, { "&isin;", "&#8712;", "\u2208" }, { "&notin;", "&#8713;", "\u2209" }, { "&ni;", "&#8715;", "\u220b" }, { "&prod;", "&#8719;", "\u220f" }, { "&sum;", "&#8721;", "\u2211" }, { "&minus;", "&#8722;", "\u2212" }, { "&lowast;", "&#8727;", "\u2217" }, { "&radic;", "&#8730;", "\u221a" }, { "&prop;", "&#8733;", "\u221d" }, { "&infin;", "&#8734;", "\u221e" }, { "&ang;", "&#8736;", "\u2220" }, { "&and;", "&#8743;", "\u2227" }, { "&or;", "&#8744;", "\u2228" }, { "&cap;", "&#8745;", "\u2229" }, { "&cup;", "&#8746;", "\u222a" }, { "&int;", "&#8747;", "\u222b" }, { "&there4;", "&#8756;", "\u2234" }, { "&sim;", "&#8764;", "\u223c" }, { "&cong;", "&#8773;", "\u2245" }, { "&asymp;", "&#8776;", "\u2248" }, { "&ne;", "&#8800;", "\u2260" }, { "&equiv;", "&#8801;", "\u2261" }, { "&le;", "&#8804;", "\u2264" }, { "&ge;", "&#8805;", "\u2265" }, { "&sub;", "&#8834;", "\u2282" }, { "&sup;", "&#8835;", "\u2283" }, { "&sube;", "&#8838;", "\u2286" }, { "&supe;", "&#8839;", "\u2287" }, { "&oplus;", "&#8853;", "\u2295" }, { "&otimes;", "&#8855;", "\u2297" }, { "&perp;", "&#8869;", "\u22a5" }, { "&sdot;", "&#8901;", "\u22c5" }, { "&lceil;", "&#8968;", "\u2308" }, { "&rceil;", "&#8969;", "\u2309" }, { "&lfloor;", "&#8970;", "\u230a" }, { "&rfloor;", "&#8971;", "\u230b" }, { "&lang;", "&#9001;", "\u2329" }, { "&rang;", "&#9002;", "\u232a" }, { "&loz;", "&#9674;", "\u25ca" }, { "&spades;", "&#9824;", "\u2660" }, { "&clubs;", "&#9827;", "\u2663" }, { "&hearts;", "&#9829;", "\u2665" }, { "&diams;", "&#9830;", "\u2666" }, { "&quot;", "&#34;", "\"" }, { "&amp;", "&#38;", "&" }, { "&lt;", "&#60;", "<" }, { "&gt;", "&#62;", ">" }, { "&OElig;", "&#338;", "\u0152" }, { "&oelig;", "&#339;", "\u0153" }, { "&Scaron;", "&#352;", "\u0160" }, { "&scaron;", "&#353;", "\u0161" }, { "&Yuml;", "&#376;", "\u0178" }, { "&circ;", "&#710;", "\u02c6" }, { "&tilde;", "&#732;", "\u02dc" }, { "&ensp;", "&#8194;", "\u2002" }, { "&emsp;", "&#8195;", "\u2003" }, { "&thinsp;", "&#8201;", "\u2009" }, { "&zwnj;", "&#8204;", "\u200c" }, { "&zwj;", "&#8205;", "\u200d" }, { "&lrm;", "&#8206;", "\u200e" }, { "&rlm;", "&#8207;", "\u200f" }, { "&ndash;", "&#8211;", "\u2013" }, { "&mdash;", "&#8212;", "\u2014" }, { "&lsquo;", "&#8216;", "\u2018" }, { "&rsquo;", "&#8217;", "\u2019" }, { "&sbquo;", "&#8218;", "\u201a" }, { "&ldquo;", "&#8220;", "\u201c" }, { "&rdquo;", "&#8221;", "\u201d" }, { "&bdquo;", "&#8222;", "\u201e" }, { "&dagger;", "&#8224;", "\u2020" }, { "&Dagger;", "&#8225;", "\u2021" }, { "&permil;", "&#8240;", "\u2030" }, { "&lsaquo;", "&#8249;", "\u2039" }, { "&rsaquo;", "&#8250;", "\u203a" }, { "&euro;", "&#8364;", "\u20ac" } };
        String[][] array;
        for (int length = (array = entities).length, i = 0; i < length; ++i) {
            final String[] entity = array[i];
            HTMLEntity.entityEscapeMap.put(entity[2], entity[0]);
            HTMLEntity.escapeEntityMap.put(entity[0], entity[2]);
            HTMLEntity.escapeEntityMap.put(entity[1], entity[2]);
        }
    }
    
    static String escape(final String original) {
        final StringBuilder buf = new StringBuilder(original);
        escape(buf);
        return buf.toString();
    }
    
    static void escape(final StringBuilder original) {
        int index = 0;
        while (index < original.length()) {
            final String escaped = HTMLEntity.entityEscapeMap.get(original.substring(index, index + 1));
            if (escaped != null) {
                original.replace(index, index + 1, escaped);
                index += escaped.length();
            }
            else {
                ++index;
            }
        }
    }
    
    static String unescape(final String original) {
        String returnValue = null;
        if (original != null) {
            final StringBuilder buf = new StringBuilder(original);
            unescape(buf);
            returnValue = buf.toString();
        }
        return returnValue;
    }
    
    static void unescape(final StringBuilder original) {
        for (int index = 0; index < original.length(); ++index) {
            index = original.indexOf("&", index);
            if (-1 == index) {
                break;
            }
            final int semicolonIndex = original.indexOf(";", index);
            if (-1 == semicolonIndex) {
                break;
            }
            final String escaped = original.substring(index, semicolonIndex + 1);
            final String entity = HTMLEntity.escapeEntityMap.get(escaped);
            if (entity != null) {
                original.replace(index, semicolonIndex + 1, entity);
            }
        }
    }
    
    static String unescapeAndSlideEntityIncdices(final String text, final UserMentionEntity[] userMentionEntities, final URLEntity[] urlEntities, final HashtagEntity[] hashtagEntities, final MediaEntity[] mediaEntities) {
        int entityIndexesLength = 0;
        entityIndexesLength += ((userMentionEntities == null) ? 0 : userMentionEntities.length);
        entityIndexesLength += ((urlEntities == null) ? 0 : urlEntities.length);
        entityIndexesLength += ((hashtagEntities == null) ? 0 : hashtagEntities.length);
        entityIndexesLength += ((mediaEntities == null) ? 0 : mediaEntities.length);
        final EntityIndex[] entityIndexes = new EntityIndex[entityIndexesLength];
        int copyStartIndex = 0;
        if (userMentionEntities != null) {
            System.arraycopy(userMentionEntities, 0, entityIndexes, copyStartIndex, userMentionEntities.length);
            copyStartIndex += userMentionEntities.length;
        }
        if (urlEntities != null) {
            System.arraycopy(urlEntities, 0, entityIndexes, copyStartIndex, urlEntities.length);
            copyStartIndex += urlEntities.length;
        }
        if (hashtagEntities != null) {
            System.arraycopy(hashtagEntities, 0, entityIndexes, copyStartIndex, hashtagEntities.length);
            copyStartIndex += hashtagEntities.length;
        }
        if (mediaEntities != null) {
            System.arraycopy(mediaEntities, 0, entityIndexes, copyStartIndex, mediaEntities.length);
        }
        Arrays.sort(entityIndexes);
        boolean handlingStart = true;
        int entityIndex = 0;
        int delta = 0;
        final StringBuilder unescaped = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); ++i) {
            final char c = text.charAt(i);
            if (c == '&') {
                final int semicolonIndex = text.indexOf(";", i);
                if (-1 != semicolonIndex) {
                    final String escaped = text.substring(i, semicolonIndex + 1);
                    final String entity = HTMLEntity.escapeEntityMap.get(escaped);
                    if (entity != null) {
                        unescaped.append(entity);
                        i = semicolonIndex;
                        delta = 1 - escaped.length();
                    }
                    else {
                        unescaped.append(c);
                    }
                }
                else {
                    unescaped.append(c);
                }
            }
            else {
                unescaped.append(c);
            }
            if (entityIndex < entityIndexes.length) {
                if (handlingStart) {
                    if (entityIndexes[entityIndex].getStart() == delta + i) {
                        entityIndexes[entityIndex].setStart(unescaped.length() - 1);
                        handlingStart = false;
                    }
                }
                else if (entityIndexes[entityIndex].getEnd() == delta + i) {
                    entityIndexes[entityIndex].setEnd(unescaped.length() - 1);
                    ++entityIndex;
                    handlingStart = true;
                }
            }
            delta = 0;
        }
        if (entityIndex < entityIndexes.length && entityIndexes[entityIndex].getEnd() == text.length()) {
            entityIndexes[entityIndex].setEnd(unescaped.length());
        }
        return unescaped.toString();
    }
}
