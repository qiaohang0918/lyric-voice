package com.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 9:45
 * @Modified By:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MyService {
}
