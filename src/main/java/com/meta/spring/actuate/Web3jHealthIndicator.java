package com.meta.spring.actuate;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.util.Assert;
import org.web3j.protocol.Web3j;

public class Web3jHealthIndicator extends AbstractHealthIndicator {

    private Web3j web3j;

    public Web3jHealthIndicator( Web3j web3j) {
        Assert.notNull(web3j, "Web3j must not be null");
        this.web3j = web3j;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        try {
            boolean listening = web3j.netListening().send().isListening();
            if (!listening) {
                builder.down().withDetail("message", "web3j net listening is down");
            } else {
                builder.up().withDetail("message", "web3j net listening is ok");
            }
        } catch (Exception ex) {
            builder.down(ex);
        }
    }
}
