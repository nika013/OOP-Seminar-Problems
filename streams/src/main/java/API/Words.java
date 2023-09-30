package API;

import java.io.File;

public class Words {
    public static void main(String[] args) {
        File root = new File("/home/nika/Desktop/Freeuni (V Semester)/OOP/OOP-seminars/streams");
        Sequence<File> allFiles = recursiveListFiles(root);
    }

    private static Sequence<File> recursiveListFiles(File root) {
        Sequence<File> children = new ArraySequence(root.listFiles());
        Sequence<File> dirs = children.filter(File::isDirectory);
        Sequence<Sequence<File>> subDirs = dirs.map(Words::recursiveListFiles);
        Sequence<File> outsideFiles = Sequence.flatten(subDirs);
        // combine this two
        return null;
    }
}
