package com.ysmjjsy.goya.example;

import com.ysmjjsy.goya.bus.domain.AbstractBaseEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户创建事件示例
 *
 * @author goya
 * @since 2025/6/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AdinCreatedEvent extends AbstractBaseEvent {
    private String userId;
    private String username;
    private String email;
    private String phone;
    private String department;
}