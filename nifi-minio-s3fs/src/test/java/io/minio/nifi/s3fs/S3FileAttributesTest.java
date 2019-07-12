package io.minio.nifi.s3fs;

import static org.junit.Assert.assertTrue;

import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

import io.minio.nifi.s3fs.attribute.S3BasicFileAttributes;
import org.junit.Test;

public class S3FileAttributesTest {
    @Test
    public void toStringPrintsBasicInfo() {
        final String key = "a key";
        final FileTime fileTime = FileTime.from(100, TimeUnit.SECONDS);
        final int size = 10;
        final boolean isDirectory = true;
        final boolean isRegularFile = true;
        S3BasicFileAttributes fileAttributes = new S3BasicFileAttributes(key, fileTime, size, isDirectory, isRegularFile);

        String print = fileAttributes.toString();

        assertTrue(print.contains(isRegularFile + ""));
        assertTrue(print.contains(isDirectory + ""));
        assertTrue(print.contains(size + ""));
        assertTrue(print.contains(fileTime.toString()));
        assertTrue(print.contains(key));
    }

    @Test
    public void anotherToStringPrintsBasicInfo() {
        final String key = "another complex key";
        final FileTime fileTime = FileTime.from(472931, TimeUnit.SECONDS);
        final int size = 138713;
        final boolean isDirectory = false;
        final boolean isRegularFile = false;
        S3BasicFileAttributes fileAttributes = new S3BasicFileAttributes(key, fileTime, size, isDirectory, isRegularFile);

        String print = fileAttributes.toString();

        assertTrue(print.contains(isRegularFile + ""));
        assertTrue(print.contains(isDirectory + ""));
        assertTrue(print.contains(size + ""));
        assertTrue(print.contains(fileTime.toString()));
        assertTrue(print.contains(key));
    }
}
