package io.minio.nifi.s3fs.FileSystemProvider;

import io.minio.nifi.s3fs.S3FileSystem;
import io.minio.nifi.s3fs.S3FileSystemProvider;
import io.minio.nifi.s3fs.S3UnitTestBase;
import io.minio.nifi.s3fs.util.AmazonS3ClientMock;
import io.minio.nifi.s3fs.util.AmazonS3MockFactory;
import io.minio.nifi.s3fs.util.S3EndpointConstant;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class GetFileStoreTest extends S3UnitTestBase {

    private S3FileSystemProvider s3fsProvider;

    @Before
    public void setup() throws IOException {
        s3fsProvider = getS3fsProvider();
        s3fsProvider.newFileSystem(S3EndpointConstant.S3_GLOBAL_URI_TEST, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFileStore() throws IOException {
        // fixtures
        AmazonS3ClientMock client = AmazonS3MockFactory.getAmazonClientMock();
        client.bucket("bucketA").dir("dir").file("dir/file1");

        // act
        Path file1 = createNewS3FileSystem().getPath("/bucketA/dir/file1");
        // assert
        s3fsProvider.getFileStore(file1);
    }

    /**
     * create a new file system for s3 scheme with fake credentials
     * and global endpoint
     *
     * @return FileSystem
     * @throws IOException
     */
    private S3FileSystem createNewS3FileSystem() throws IOException {
        try {
            return s3fsProvider.getFileSystem(S3EndpointConstant.S3_GLOBAL_URI_TEST);
        } catch (FileSystemNotFoundException e) {
            return (S3FileSystem) FileSystems.newFileSystem(S3EndpointConstant.S3_GLOBAL_URI_TEST, null);
        }

    }
}
