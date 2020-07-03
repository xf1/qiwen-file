package com.mac.scp.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文件存储
 *
 * @author ma116
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@Table(name = "file_store", uniqueConstraints = {
		@UniqueConstraint(name = "uk_name", columnNames = {"name"}),
		@UniqueConstraint(name = "uk_md5_size", columnNames = {"md5", "size"})
})
@Entity
@TableName("file_store")
public class FileStore extends Model<FileStore> {
	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TableId(type = IdType.AUTO)
	private Long id;

	private String md5;

	/**
	 * 日期 + 文件名 + 后缀
	 * 文件名生成方式 IdWorker.getId()
	 * 例如: 20200501/1264881628283518978.png
	 */
	private String name;

	private Long size;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime modifyTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}