package io.smartcat;

import java.net.InetAddress;
import java.util.List;

import org.apache.cassandra.locator.AbstractEndpointSnitch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dummy Snitch implementation which will log messages to show it is alive (copy of SimpleSnitch with logging in
 * constructor to make sure that Snitch is properly loaded when Cassandra starts up).
 */
public class SmartCatSnitch extends AbstractEndpointSnitch {

    protected static final Logger logger = LoggerFactory.getLogger(SmartCatSnitch.class);

    public SmartCatSnitch() {
        logger.info("SmartCat Snitch loaded.");
    }

    public String getRack(InetAddress endpoint)
    {
        return "rack1";
    }

    public String getDatacenter(InetAddress endpoint) {
        return "datacenter1";
    }

    @Override
    public void sortByProximity(final InetAddress address, List<InetAddress> addresses) {
        // Optimization to avoid walking the list
    }

    public int compareEndpoints(InetAddress target, InetAddress a1, InetAddress a2) {
        // Making all endpoints equal ensures we won't change the original ordering (since
        // Collections.sort is guaranteed to be stable)
        return 0;
    }
}