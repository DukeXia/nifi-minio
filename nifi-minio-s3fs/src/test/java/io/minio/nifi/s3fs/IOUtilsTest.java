package io.minio.nifi.s3fs;

import org.junit.Test;

import io.minio.nifi.s3fs.util.IOUtils;

/**
 * http://stackoverflow.com/questions/9700179/junit-testing-helper-class-with-only-static-methods
 */
public class IOUtilsTest {
    @Test
    public void just_to_silence_coverage() {
        new IOUtils() {
            // ignore this
        };
    }
}
