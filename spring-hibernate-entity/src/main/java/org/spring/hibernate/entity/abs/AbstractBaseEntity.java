package org.spring.hibernate.entity.abs;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 描述：基础实体虚类
 * 
 * @author Aaric
 *
 */
public abstract class AbstractBaseEntity extends AbstractEntityObject {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 6725613657960263070L;

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
