package com.example.kotlinserver.controller;

import com.example.kotlinserver.domain.*;
import com.example.kotlinserver.model.UserInfo;
import com.example.kotlinserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;


@RestController
@RequestMapping("/userCenter")
public class UserInfoController extends BaseController{

    @Autowired
    UserService userService;

    @Value("${web.upload-path}")
    private String dirPath;

    /**
     * 用户上传头像地址
     * @param file
     * @return
     * http://www.outshine.cn/view/25
     * https://blog.csdn.net/zsl129/article/details/52906762
     */
    @RequestMapping(value = {"/uploadUserAvatar"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<String> uploadUserAvatar(@RequestParam MultipartFile file){
        BaseResp resp = new BaseResp();
        resp.setMessage(file.getOriginalFilename());
        String token = this.request.getHeader("token");
        UserInfo info = userService.getUserById(Integer.parseInt(token));
        if(null==token || StringUtils.isEmpty(token)){
            resp.setMessage("需要token");
            resp.setStatus(-1);
            resp.setData(null);
        }else{
            try{

                File dir = new File( dirPath);
                if(!dir.exists()){
                    dir.mkdir();
                }
                String fileName = UUID.randomUUID().toString()+".jpg";
                File serverFile = new File(dirPath+fileName);
                file.transferTo(serverFile);
                info.setUserIcon(serverFile.getAbsolutePath());
                userService.modifyUser(info);
                resp.setMessage("图片上传成功");
                resp.setStatus(1);
                resp.setData(info);
            }catch(Exception e){
                resp.setMessage("图片上传失败"+e.toString());
                resp.setStatus(-1);
            }
        }
        return resp;
    }

    /**
     * 修改用户信息
     * @param req
     * @return
     */
    @RequestMapping(value = {"/editUser"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<UserInfo> editUser(@RequestBody EditUserReq req){
        BaseResp resp = new BaseResp();
        String token = this.request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            resp.setMessage("需要token");
            resp.setStatus(-1);
            resp.setData(null);
        }
        UserInfo userInfo = userService.getUserById(Integer.parseInt(token));
        userInfo.setUserName(req.getUserName());
        userInfo.setUserGender(req.getGender());
        userInfo.setUserSign(req.getSign());
        this.userService.modifyUser(userInfo);
        resp.setStatus(0);
        resp.setData(userInfo);
        return resp;
    }

    /**
     * 重置密码
     * @param req
     * @return
     */
    @RequestMapping(value = {"/resetPwd"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<String> resetPwd(@RequestBody ModifyPwdReq req){
        BaseResp resp = new BaseResp();

        String mobile = req.getMobile();
        String pwd = req.getPwd();

        if (StringUtils.isEmpty(mobile)) {
            resp.setStatus(-1);
            resp.setMessage("手机号码为空");
            return resp;
        }

        if (StringUtils.isEmpty(pwd)) {
            resp.setStatus(-1);
            resp.setMessage("密码为空");
            return resp;
        }

        UserInfo userInfo = this.userService.getUserByMobile(mobile);
        if (userInfo == null) {
            resp.setStatus(-1);
            resp.setMessage("用户不存在");
            return resp;
        }


        userInfo.setUserPwd(pwd);
        int result = this.userService.modifyUser(userInfo);

        if (result > 0) {
            resp.setStatus(0);
            resp.setMessage("密码修改成功");
            return resp;
        }
        resp.setStatus(-1);
        resp.setMessage("密码修改失败");
        return resp;
    }

    /**
     * 登录
     * @param req
     * @return
     */
    @RequestMapping(value = {"/login"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public BaseResp<UserInfo> loginByPwd(@RequestBody LoginReq req) {
        BaseResp resp = new BaseResp();
        String mobile = req.getMobile();
        String pwd = req.getPwd();

        if (StringUtils.isEmpty(mobile)) {
            resp.setStatus(-1);
            resp.setMessage("手机号码为空");
            return resp;
        }

        if (StringUtils.isEmpty(pwd)) {
            resp.setStatus(-1);
            resp.setMessage("密码为空");
            return resp;
        }

        UserInfo userInfo = userService.getUserByMobile(mobile);
        if (null == userInfo) {
            resp.setStatus(-1);
            resp.setMessage("登录失败,没有找到相关用户");
        }
        if (null != userInfo) {
            if(userInfo.getUserPwd().equals(pwd)) {
                resp.setStatus(1);
                resp.setMessage("登录成功");
                resp.setData(userInfo);
            }else{
                resp.setStatus(-1);
                resp.setMessage("登录失败，用户密码错误");
                resp.setData(null);
            }
        }
        return resp;
    }


    /**
     * 注册
     * @param req
     * @return
     */
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResp<String> register(@RequestBody RegisterReq req) {
        BaseResp resp = new BaseResp();

        String mobile = req.getMobile();
        String verifyCode = req.getVerifyCode();

        UserInfo userInfo = this.userService.getUserByMobile(mobile);
        if (userInfo != null) {
            resp.setStatus(-1);
            resp.setMessage("账号已被注册");
            return resp;
        }
        if (!"123456".equals(verifyCode)) {
            resp.setStatus(-1);
            resp.setMessage("验证码错误");
            return resp;
        }
        userInfo = new UserInfo();
        userInfo.setUserMobile(mobile);
        userInfo.setUserName(mobile);
        userInfo.setUserPwd(req.getPwd());
        this.userService.addUser(userInfo);
        resp.setStatus(1);
        resp.setData(userInfo);
        resp.setMessage("注册成功");
        return resp;
    }
}
