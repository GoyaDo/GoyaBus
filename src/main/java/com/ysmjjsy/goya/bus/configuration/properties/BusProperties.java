package com.ysmjjsy.goya.bus.configuration.properties;

import com.ysmjjsy.goya.bus.enums.TransportType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Unified MQ 配置属性
 *
 * @author goya
 * @since 2025/6/24
 */
@Data
@ConfigurationProperties(prefix = "bus")
public class BusProperties {

    /**
     * 是否启用Bus
     */
    private boolean enabled = true;

    /**
     * 默认业务域
     * 完整为applicationName + "." + busPrefix+ ".eventKey"
     */
    private String busPrefix = "bus";

    /**
     * 默认传输层类型
     */
    private TransportType defaultTransport = TransportType.RABBITMQ;

    /**
     * 默认重试次数
     */
    private Integer defaultRetryTimes = 3;

    /**
     * 默认重试延迟时间（毫秒）
     */
    private Long defaultRetryDelay = 3000L;

    /**
     * 线程池配置
     */
    private Executor executor = new Executor();

    /**
     * Redis传输配置
     */
    private Redis redis = new Redis();

    /**
     * RabbitMQ传输配置
     */
    private RabbitMQ rabbitmq = new RabbitMQ();

    /**
     * RabbitMQ传输配置
     */
    private Kafka kafka = new Kafka();

    /**
     * 线程池配置
     */
    @Data
    public static class Executor {
        /**
         * 核心线程数
         */
        private int corePoolSize = 8;

        /**
         * 最大线程数
         */
        private int maxPoolSize = 32;

        /**
         * 队列容量
         */
        private int queueCapacity = 1000;

        /**
         * 线程名称前缀
         */
        private String threadNamePrefix = "unified-mq-";

        /**
         * 线程保活时间（秒）
         */
        private int keepAliveSeconds = 60;
    }

    @Setter
    @Getter
    public static class Redis {
        /**
         * 是否启用Redis传输
         */
        private boolean enabled = false;
    }

    /**
     * RabbitMQ传输配置
     */
    @Setter
    @Getter
    public static class RabbitMQ {
        /**
         * 是否启用RabbitMQ传输
         */
        private boolean enabled = false;
    }

    @Setter
    @Getter
    public static class Kafka {
        /**
         * 是否启用Kafka传输
         */
        private boolean enabled = false;
    }

} 