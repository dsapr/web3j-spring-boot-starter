package com.meta.spring.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.meta.spring.autoconfigure.Web3jProperties.WEB3J_PREFIX;

@ConfigurationProperties(prefix = WEB3J_PREFIX) // 配置文件中web3j开头的文件绑定到POJO
public class Web3jProperties {

    public static final String WEB3J_PREFIX = "web3j";

    private String clientAddress;

    private Boolean adminClient;

    private String networkId;

    private Long httpTimeoutSeconds;

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Boolean getAdminClient() {
        return adminClient;
    }

    public void setAdminClient(Boolean adminClient) {
        this.adminClient = adminClient;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public Long getHttpTimeoutSeconds() {
        return httpTimeoutSeconds;
    }

    public void setHttpTimeoutSeconds(Long httpTimeoutSeconds) {
        this.httpTimeoutSeconds = httpTimeoutSeconds;
    }
}
