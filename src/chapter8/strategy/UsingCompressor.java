package chapter8.strategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

public class UsingCompressor {
    private static final String dir = System.getProperty("user.dir") + "/src/chapter8/compression/";

    public static void main(String[] args) throws IOException {
        Path inFile = Paths.get(dir + "wait2Compress");
        String fileName = dir + "alreadyCompress";
        //specify(inFile, fileName);
        methodReference(inFile, fileName);
    }

    private static void specify(Path inFile, String fileName) throws IOException {
        Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
        File outGzipFile = new File(fileName + ".gzip");
        gzipCompressor.compress(inFile, outGzipFile);

        Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
        File outZipFile = new File(fileName + ".zip");
        zipCompressor.compress(inFile, outZipFile);
    }

    private static void methodReference(Path inFile, String fileName) throws IOException {
        Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
        File outGzipFile = new File(fileName + ".gzip");
        gzipCompressor.compress(inFile, outGzipFile);

        Compressor zipCompressor = new Compressor(ZipOutputStream::new);
        File outZipFile = new File(fileName + ".zip");
        zipCompressor.compress(inFile, outZipFile);
    }
}
