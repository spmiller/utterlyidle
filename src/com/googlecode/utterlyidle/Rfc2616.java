package com.googlecode.utterlyidle;

import com.googlecode.totallylazy.predicates.Predicate;

import static com.googlecode.totallylazy.Sequences.characters;
import static com.googlecode.totallylazy.numbers.Numbers.range;
import static com.googlecode.totallylazy.numbers.Numbers.toCharacter;

public class Rfc2616 {
    public static final String SEPARATORS = "()<>@,;:\\\"/[]?={} \t";
    public static final String CTLs = range(0,31).append(127).map(toCharacter()).toString("");
    public static final String HTTP_LINE_SEPARATOR = "\r\n";

    public static boolean isValidToken(String value) {
        if(value == null || value.length()==0)return false;
        return characters(value).forAll(isValidTokenCharacter());
    }

    public static Predicate<? super Character> isValidTokenCharacter() {
        return character -> SEPARATORS.indexOf(character) < 0 && CTLs.indexOf(character) < 0;
    }

    public static String toQuotedString(String value) {
        return String.format("\"%s\"", value.replace("\"", "\\\""));
    }

    public static String toUnquotedString(String value) {
        return value.replaceFirst("^\"", "").replaceFirst("\"$", "").replace("\\\"", "\"");
    }
}
