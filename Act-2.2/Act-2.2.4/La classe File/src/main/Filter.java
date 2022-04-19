package main;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String filenamefilter) {
        String lowercaseName = filenamefilter.toLowerCase();
        if (lowercaseName.endsWith(".java")) {
            return true;
        } else {
            return false;
        }
    }
}
