package writers;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SVGWriter {
    private static final String svgHeader = "<?xml version=\"1.0\"?>\n<svg width=\"5000\" height=\"5000\" viewBox=\"0 0 5000 5000\" xmlns=\"http://www.w3.org/2000/svg\">";
    public static StringBuilder svgBody = new StringBuilder();
    private static final String svgFooter = "</svg>";
    private static final String svgFileName = "items.svg";
    private File file;
    private FileWriter fileWriter;

    public SVGWriter() {
        file = new File(svgFileName);
        try {
            fileWriter = new FileWriter(file, false);
            writeHeader();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public File getFile() {
        return file;
    }

    public void writeHeader() {
        try {
            fileWriter.write(svgHeader);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void writeBody() {
        try {
            if (svgBody != null) {
                fileWriter.write(svgBody.toString());
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writeFooter() {
        try {
            fileWriter.write(svgFooter);
            fileWriter.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writeRect(int x, int y, int w, int h, String color) {
        svgBody.append('\n' + String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" style=\"fill:%s;stroke:%s\"/>",
                x, y, w, h, color, "black"));
    }

    public void writeRoundRect(int x, int y, int w, int h, int r1, int r2, String color) {
        svgBody.append('\n' + String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" rx=\"%d\" ry=\"%d\" style=\"fill:%s;stroke:%s\"/>",
                x, y, w, h, r1, r2, color, "black"));
    }

    public void writeEllipse(int x, int y, int w, int h, String color) {
        svgBody.append('\n' + String.format("<ellipse cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" style=\"fill:%s;stroke:%s;stroke-width:%dpx\"/>",
                x, y, w, h, color, "black", 5));
    }
}
