// 6️⃣ File Converter System
// Interface: FileConverter
// •	convert(String inputFile, String outputFile)
// Implementations:
// •	PdfConverter
// •	WordConverter
// •	ImageConverter
// ConversionManager:
// •	accepts any FileConverter implementation
// Task:
// Use polymorphism to convert files without changing manager code.

interface FileConverter {
    void convert(String inputFile, String outputFile);
}

class PdfConverter implements FileConverter {

    @Override
    public void convert(String inputFile, String outputFile) {
        System.out.println("PDF converting...");
    }
}


class WordConverter implements FileConverter {

    @Override
    public void convert(String inputFile, String outputFile) {
        System.out.println("Word converting...");
    }
}

class ImageConverter implements FileConverter {

    @Override
    public void convert(String inputFile, String outputFile) {
        System.out.println("Image converting...");
    }
}

class ConversionManager {

    public void processConversion(FileConverter converter,
                                  String inputFile,
                                  String outputFile) {
        converter.convert(inputFile, outputFile);
    }
}

public class FileConverterSystem {
    public static void main(String[] args) {

        ConversionManager manager = new ConversionManager();

        manager.processConversion(new PdfConverter(), "file.txt", "file.pdf");
        manager.processConversion(new WordConverter(), "file.pdf", "file.docx");
        manager.processConversion(new ImageConverter(), "photo.png", "photo.jpeg");
    }
}