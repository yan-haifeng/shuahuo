package com.shuahuo.controller;

import com.shuahuo.bean.Order;
import com.shuahuo.service.OrderService;
import com.shuahuo.util.GenerateImage;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class OrderConteoller {
    @Autowired
    private OrderService orderService;

    //查询所有的玩具
    @CrossOrigin
    @RequestMapping("/findAllOrder")
    public JsonUtil<Order> findAllToys() {
        return JsonUtil.success().addData(orderService.findAllOrder());
    }

    //根据userId查询玩具
    @CrossOrigin
    @RequestMapping("/findOrderByUserId")
    public JsonUtil<Order> findOrderByUserId(int id) {
        return JsonUtil.success().addData(orderService.findOrderByUserId(id));
    }

    //根据StudioId查询玩具
    @CrossOrigin
    @RequestMapping("/findOrderByStudioId")
    public JsonUtil<Order> findOrderByStudioId(int id) {
        return JsonUtil.success().addData(orderService.findOrderByStudioId(id));
    }

    //根据Id查询玩具
    @CrossOrigin
    @RequestMapping("/findOrderById")
    public JsonUtil<Order> findOrderById(int id) {
        return JsonUtil.success().addData(orderService.findOrderById(id));
    }

    //订单定制完成
    @CrossOrigin
    @RequestMapping("/finishOrder")
    public JsonUtil<Order> finishOrder(int id) {
        int statu = 4;
        Order order = orderService.findOrderById(id).get(0);
        order.setOrder_statu(statu);
        int code = orderService.updateOrder(order);
        if(code == 1){
            return JsonUtil.success();
        }else{
            return JsonUtil.fail("修改失败");
        }
    }

    //接受订单
    @CrossOrigin
    @RequestMapping("/acceptedOrder")
    public JsonUtil<Order> acceptedOrder(int id) {
        int statu = 1;
        Order order = orderService.findOrderById(id).get(0);
        order.setOrder_statu(statu);
        int code = orderService.updateOrder(order);
        if(code == 1){
            return JsonUtil.success();
        }else{
            return JsonUtil.fail("接受失败");
        }
    }

    //拒绝订单
    @CrossOrigin
    @RequestMapping("/refuseOrder")
    public JsonUtil<Order> refuseOrder(int id) {
        int statu = 5;
        Order order = orderService.findOrderById(id).get(0);
        order.setOrder_statu(statu);
        int code = orderService.updateOrder(order);
        if(code == 1){
            return JsonUtil.success();
        }else{
            return JsonUtil.fail("拒绝失败");
        }
    }

    //修改订单状态
    @CrossOrigin
    @RequestMapping("/changeOrderStatu")
    public JsonUtil<Order> changeOrderStatu(int id ,int statu ) {
        Order order = orderService.findOrderById(id).get(0);
        order.setOrder_statu(statu);
        int code = orderService.updateOrder(order);
        if(code == 1){
            return JsonUtil.success();
        }else{
            return JsonUtil.fail("失败");
        }
    }

    //添加订单
    @CrossOrigin
    @RequestMapping("/addOrder")
    public JsonUtil<Order> AddDynamic(Order order) {
        int code = orderService.addOrder(order);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("添加失败");
        }
    }

    //订单图片上传
    @CrossOrigin
    @RequestMapping(value = "uploadOrderImg", method = RequestMethod.POST)
    public JsonUtil<Order> uploadOrderImg(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String UPLOAD_FILE_PATH = ResourceUtils.getURL("classpath:").getPath() + "static/page/shuaHuoProject/resources/upload/orderimg";
                String name = file.getOriginalFilename();//上传图片的真实名称
                String imgname = GenerateImage.uploadFile(file, UPLOAD_FILE_PATH, name);
                System.out.println("工作室图片上传成功:" + UPLOAD_FILE_PATH + "/" + imgname);
                return JsonUtil.success().addMsg(imgname);
            } catch (IOException e) {
                e.printStackTrace();
                return JsonUtil.fail("错误");
            }
        } else {
            return null;
        }
    }

    /**
     * 根据用户id修改用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("changeOrderData")
    public JsonUtil<Order> changeOrderData(Order order) {
        int code = orderService.updateOrder(order);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("修改失败");
        }
    }

    @CrossOrigin
    @RequestMapping("deleteOrderById")
    public JsonUtil<Order> deleteOrderById(@RequestParam(value="id", defaultValue="-1") Integer id) {
        int code = orderService.deleteOrder(id);
        if(code==1){
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("删除失败");
        }
    }
}
