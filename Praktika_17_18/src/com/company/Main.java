package com.company;


import java.io.*;

public class Main {
    static PrintWriter printWriter;

    static {
        try {
            printWriter = new PrintWriter("AllFiles.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getFiles(String path){
        File file = new File(path);
        if(file.isDirectory()){
            String[] contents = file.list();
            for (String s:contents) {
                getFiles(path+"/"+s);
            }
        }
        if(file.isFile() ) {
            if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".java")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    printWriter.write("###### " + path + "\n```java\n");
                    String line = reader.readLine();
                    while (line != null) {
                        printWriter.write(line + "\n");
                        line = reader.readLine();
                    }
                    printWriter.write("```\n");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {

        String basePath = "C:\\Users\\Рома\\IdeaProjects";
        File file = new File(basePath);

        String[] files = file.list();
        String[]  filePaths = new String[files.length];

        for (int i = 0; i <files.length ; i++) {
            filePaths[i]=basePath+"\\"+files[i]+"\\src\\com\\company";
            getFiles(filePaths[i]);
        }

        printWriter.close();
    }
}