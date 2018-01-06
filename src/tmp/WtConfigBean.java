package tmp;

import java.io.Serializable;
import java.util.Date;


/**
 * <b>项目名称：</b>wap_ServicePackage<br>
 * <b>创建人：</b>王志<br>
 * <b>类描述：</b>网厅弹窗配置化		TF_WT_CONFIG<br>
 * <b>创建时间：</b>2017-02-14 下午02:49:50<br>
 * <b>@Copyright:</b>2017-新东网科技
 */
public class WtConfigBean  implements Serializable {

	private static final long serialVersionUID = 7564255522887144785L;
	
	/** id */
	private Long id;	
	/** 配置名称 */
	private String configName;	
	/** 展示开始时间 */
	private Date showStarttime;	
	/** 展示结束时间 */
	private Date showEndtime;	
	/** 地市编码字符串 */
	private String cityCodelist;	
	/** 展示位置 中：middle，下：down */
	private String showPosition;	
	/** 是否关闭  是：1，否：0 */
	private String isclosed;	
	/** 状态   删除：D,   上架：E,   下架：U */
	private String status;	
	/** 创建时间 */
	private Date creatTime;	
	/** 备注 */
	private String remark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public Date getShowStarttime() {
		return showStarttime;
	}
	public void setShowStarttime(Date showStarttime) {
		this.showStarttime = showStarttime;
	}
	public Date getShowEndtime() {
		return showEndtime;
	}
	public void setShowEndtime(Date showEndtime) {
		this.showEndtime = showEndtime;
	}
	public String getCityCodelist() {
		return cityCodelist;
	}
	public void setCityCodelist(String cityCodelist) {
		this.cityCodelist = cityCodelist;
	}
	public String getShowPosition() {
		return showPosition;
	}
	public void setShowPosition(String showPosition) {
		this.showPosition = showPosition;
	}
	public String getIsclosed() {
		return isclosed;
	}
	public void setIsclosed(String isclosed) {
		this.isclosed = isclosed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
