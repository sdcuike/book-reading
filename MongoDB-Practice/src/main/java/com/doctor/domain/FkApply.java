package com.doctor.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.JSON;

/**
 * @author sdcuike
 *
 * @time 2015年12月24日 下午2:42:47
 */

@Document(collection = "fk_qc_apply")
public class FkApply {
    private Long apply_id;

    private Long apply_type;
    private Long item_type;
    private String serial_no;
    private Long status;
    private String title;

    private Long user_id;

    private ConstCenter cost_center;

    public Long getApply_id() {
        return apply_id;
    }

    public void setApply_id(Long apply_id) {
        this.apply_id = apply_id;
    }

    public Long getApply_type() {
        return apply_type;
    }

    public void setApply_type(Long apply_type) {
        this.apply_type = apply_type;
    }

    public Long getItem_type() {
        return item_type;
    }

    public void setItem_type(Long item_type) {
        this.item_type = item_type;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public ConstCenter getCost_center() {
        return cost_center;
    }

    public void setCost_center(ConstCenter cost_center) {
        this.cost_center = cost_center;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
