package io.minio.nifi.s3fs.spike;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import io.minio.nifi.s3fs.S3FileSystemProvider;

public class SpecTest {

	@Test
	public void parentOfRelativeSinglePathIsNull() {
		Path path = FileSystems.getDefault().getPath("relative");
		assertNull(path.getParent());
	}

	@Test
	public void readAttributes() throws IOException {
		Path path = Files.createTempFile("asdas", "sdasda");
		Map<String,Object> attrs = Files.readAttributes(path, "*");
		Map<String,Object> attrs2 = Files.readAttributes(path, "lastModifiedTime");
	}

	@Test
	public void installedFileSystemsLoadFromMetaInf() {
		List<FileSystemProvider> providers = FileSystemProvider.installedProviders();
		boolean installed = false;
		for (FileSystemProvider prov : providers) {
			if (prov instanceof S3FileSystemProvider) {
				installed = true;
				return;
			}
		}
		assertTrue(installed);
	}
}
