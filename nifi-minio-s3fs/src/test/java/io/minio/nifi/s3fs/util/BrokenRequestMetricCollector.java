package io.minio.nifi.s3fs.util;

public class BrokenRequestMetricCollector extends NoOpRequestMetricCollector {
    /**
     * @param name to make the constructor non default
     */
    public BrokenRequestMetricCollector(String name) {
        // only non default constructor
    }
}