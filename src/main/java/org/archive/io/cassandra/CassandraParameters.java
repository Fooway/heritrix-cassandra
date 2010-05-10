package org.archive.io.cassandra;

/**
 * Configures the values of the column family, super/sub columns used
 * for the crawl. Also contains a full set of default values.
 *
 * Meant to be configured within the Spring framework either inline
 * of CassandraWriterProcessor or as a named bean and referenced later on.
 *
 * <pre>
 * {@code
 * <bean id="cassandraParameters" class="org.archive.io.cassandra.CassandraParameters">
 *   <!-- The 'keyspace' parameter is the minimum required -->
 *   <property name="keyspace" value="MyApplication" />
 *   <!-- Changing the default column family from "crawl" to "crawl_table" -->
 *   <property name="crawlColumnFamily" value="crawl_table" />
 *   <!-- Overwrite more options here -->
 * </bean>
 * }
 * </pre>
 *
 * @see org.archive.modules.writer.CassandraWriterProcessor
 *  {@link org.archive.modules.writer.CassandraWriterProcessor} for a full example
 *
 * @author greglu
 */
public class CassandraParameters {

	/** DEFAULT OPTIONS **/

	// Defaults to writing to the "crawl" table
	public static final String CRAWL_COLUMN_FAMILY = "crawl";
	public static final String ENCODING_SCHEME = "UTF-8";

	// "content" logical grouping
    public static final String CONTENT_PREFIX = "content";
    public static final String CONTENT_COLUMN_NAME = "raw_data";

    // "curi" logical grouping
    public static final String CURI_PREFIX = "curi";
    public static final String IP_COLUMN_NAME = "ip";
    public static final String PATH_FROM_SEED_COLUMN_NAME = "path-from-seed";
    public static final String IS_SEED_COLUMN_NAME = "is-seed";
    public static final String VIA_COLUMN_NAME = "via";
    public static final String URL_COLUMN_NAME = "url";
    public static final String REQUEST_COLUMN_NAME = "request";


	/** ACTUAL OPTIONS INITIALIZED TO DEFAULTS **/
    private String keyspace = "";

	private String crawlColumnFamily = CRAWL_COLUMN_FAMILY;
    private String encodingScheme = ENCODING_SCHEME;

	private String contentPrefix = CONTENT_PREFIX;
    private String contentColumnName = contentPrefix + ":" + CONTENT_COLUMN_NAME;

    private String curiPrefix = CURI_PREFIX;
    private String ipColumnName = curiPrefix + ":" + IP_COLUMN_NAME;
    private String pathFromSeedColumnName = curiPrefix + ":" + PATH_FROM_SEED_COLUMN_NAME;
    private String isSeedColumnName = curiPrefix + ":" + IS_SEED_COLUMN_NAME;
    private String viaColumnName = curiPrefix + ":" + VIA_COLUMN_NAME;
    private String urlColumnName = curiPrefix + ":" + URL_COLUMN_NAME;
    private String requestColumnName = curiPrefix + ":" + REQUEST_COLUMN_NAME;


    public String getKeyspace() {
    	if (keyspace.isEmpty())
    		throw new RuntimeException("A keyspace was never set for this object. " +
    				"Define one before trying to access it.");

		return keyspace;
	}
	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}
    public String getCrawlColumnFamily() {
        return crawlColumnFamily;
    }
    public void setCrawlColumnFamily(String crawlColumnFamily) {
        this.crawlColumnFamily = crawlColumnFamily;
    }
    public String getEncodingScheme() {
		return encodingScheme;
	}
	public void setEncodingScheme(String encodingScheme) {
		this.encodingScheme = encodingScheme;
	}
	public String getContentPrefix() {
        return contentPrefix;
    }
    public void setContentPrefix(String contentPrefix) {
        this.contentPrefix = contentPrefix;
    }
    public String getContentColumnName() {
        return contentColumnName;
    }
    public void setContentColumnName(String contentColumnName) {
        this.contentColumnName = contentColumnName;
    }
    public String getCuriPrefix() {
        return curiPrefix;
    }
    public void setCuriPrefix(String curiPrefix) {
        this.curiPrefix = curiPrefix;
    }
    public String getIpColumnName() {
        return ipColumnName;
    }
    public void setIpColumnName(String ipColumnName) {
        this.ipColumnName = ipColumnName;
    }
    public String getPathFromSeedColumnName() {
        return pathFromSeedColumnName;
    }
    public void setPathFromSeedColumnName(String pathFromSeedColumnName) {
        this.pathFromSeedColumnName = pathFromSeedColumnName;
    }
    public String getIsSeedColumnName() {
        return isSeedColumnName;
    }
    public void setIsSeedColumnName(String isSeedColumnName) {
        this.isSeedColumnName = isSeedColumnName;
    }
    public String getViaColumnName() {
        return viaColumnName;
    }
    public void setViaColumnName(String viaColumnName) {
        this.viaColumnName = viaColumnName;
    }
    public String getUrlColumnName() {
        return urlColumnName;
    }
    public void setUrlColumnName(String urlColumnName) {
        this.urlColumnName = urlColumnName;
    }
    public String getRequestColumnName() {
        return requestColumnName;
    }
    public void setRequestColumnName(String requestColumnName) {
        this.requestColumnName = requestColumnName;
    }
}