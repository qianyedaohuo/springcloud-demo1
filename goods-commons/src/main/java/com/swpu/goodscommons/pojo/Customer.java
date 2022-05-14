package com.swpu.goodscommons.pojo;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiModelProperty;

//@Api(value = "顾客对象")
public class Customer {

//    @ApiModelProperty(value = "顾客id", dataType = "int", required = true)
    public Integer id;

//    @ApiModelProperty(value = "顾客姓名", dataType = "String")
    public String customerName;

//    @ApiModelProperty(value = "顾客地址", dataType = "String")
    public String customerAddress;

//    @ApiModelProperty(value = "顾客价格", dataType = "int")
    public Integer customerTicket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerTicket() {
        return customerTicket;
    }

    public void setCustomerTicket(Integer customerTicket) {
        this.customerTicket = customerTicket;
    }
}
