package org.example.patterns;

import org.example.patterns.action.SloganAction;

import java.nio.file.FileSystems;
import java.util.List;

public class Patterns {
    private static final List<String> EXTRA_WORDS = List.of(
            "Current Event", "Op-ed:", "OP-ED", "Op/Ed:", "op-ed", "&amp;", "QA:", "\\(more&#8230;\\)",
            "\\(more#8230;\\)", "\\(more&hellip;\\)", "()"
    );
    private static String stripExtraWords(String headline) {
        String cleanedHeadline = headline;
        for (String extraWord : EXTRA_WORDS) {
            if (cleanedHeadline.contains(extraWord) || cleanedHeadline.toLowerCase().contains(extraWord.toLowerCase())) {
                cleanedHeadline = cleanedHeadline.replaceAll(extraWord.toLowerCase(),"")
                        .replaceAll(extraWord,"").strip();
            }
        }
        return cleanedHeadline;
    }
    public static void main(String[] args) {
        // System.setProperty("user.dir", ".");
        List<String> headlineList = List.of("PRISTINA, June 25 /ATA/- A woman and her 5-year-old son (more&#8230;)");
        System.out.println(System.getProperty("user.dir").toString());
        System.out.println(FileSystems.getDefault().toString());
        SloganAction firstObject = new SloganAction ();
        firstObject.printSlogan();
        for (String headline : headlineList) {
            System.out.println(stripExtraWords(headline));
        }
    }
}