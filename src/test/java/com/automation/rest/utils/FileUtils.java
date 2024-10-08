package com.automation.rest.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

  public static String fileContent(final String filePath) throws IOException {
    String content = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
    if (content == null || content.isEmpty()) throw new FileNotFoundException();
    return content;
  }

}
