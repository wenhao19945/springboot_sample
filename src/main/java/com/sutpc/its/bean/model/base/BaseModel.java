package com.sutpc.its.bean.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: BaseModel
 * @Author: lixin
 * @Description: base实体
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@Setter
@Getter
@ToString
public class BaseModel {

  private String id;

  @JSONField(serialize = false)
  private String sysUuid;

  public String getSysUuid() {
    return UUID.randomUUID().toString().replace("-", "");
  }

}
