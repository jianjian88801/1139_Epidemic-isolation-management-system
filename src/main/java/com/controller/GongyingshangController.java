
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 供应商
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongyingshang")
public class GongyingshangController {
    private static final Logger logger = LoggerFactory.getLogger(GongyingshangController.class);

    @Autowired
    private GongyingshangService gongyingshangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("供应商".equals(role))
            params.put("gongyingshangId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = gongyingshangService.queryPage(params);

        //字典表数据转换
        List<GongyingshangView> list =(List<GongyingshangView>)page.getList();
        for(GongyingshangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongyingshangEntity gongyingshang = gongyingshangService.selectById(id);
        if(gongyingshang !=null){
            //entity转view
            GongyingshangView view = new GongyingshangView();
            BeanUtils.copyProperties( gongyingshang , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongyingshang:{}",this.getClass().getName(),gongyingshang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GongyingshangEntity> queryWrapper = new EntityWrapper<GongyingshangEntity>()
            .eq("username", gongyingshang.getUsername())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongyingshangEntity gongyingshangEntity = gongyingshangService.selectOne(queryWrapper);
        if(gongyingshangEntity==null){
            gongyingshang.setCreateTime(new Date());
            gongyingshang.setPassword("123456");
            gongyingshangService.insert(gongyingshang);
            return R.ok();
        }else {
            return R.error(511,"账户已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongyingshang:{}",this.getClass().getName(),gongyingshang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GongyingshangEntity> queryWrapper = new EntityWrapper<GongyingshangEntity>()
            .notIn("id",gongyingshang.getId())
            .andNew()
            .eq("username", gongyingshang.getUsername())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongyingshangEntity gongyingshangEntity = gongyingshangService.selectOne(queryWrapper);
        if(gongyingshangEntity==null){
            gongyingshangService.updateById(gongyingshang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongyingshangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GongyingshangEntity> gongyingshangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GongyingshangEntity gongyingshangEntity = new GongyingshangEntity();
//                            gongyingshangEntity.setUsername(data.get(0));                    //账户 要改的
//                            //gongyingshangEntity.setPassword("123456");//密码
//                            gongyingshangEntity.setGongyingshangName(data.get(0));                    //供应商名称 要改的
//                            gongyingshangEntity.setGongyingshangAddress(data.get(0));                    //供应商地址 要改的
//                            gongyingshangEntity.setDiquContent("");//照片
//                            gongyingshangEntity.setCreateTime(date);//时间
                            gongyingshangList.add(gongyingshangEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<GongyingshangEntity> gongyingshangEntities_username = gongyingshangService.selectList(new EntityWrapper<GongyingshangEntity>().in("username", seachFields.get("username")));
                        if(gongyingshangEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongyingshangEntity s:gongyingshangEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongyingshangService.insertBatch(gongyingshangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        GongyingshangEntity gongyingshang = gongyingshangService.selectOne(new EntityWrapper<GongyingshangEntity>().eq("username", username));
        if(gongyingshang==null || !gongyingshang.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(gongyingshang.getId(),username, "gongyingshang", "供应商");
        R r = R.ok();
        r.put("token", token);
        r.put("role","供应商");
        r.put("username",gongyingshang.getGongyingshangName());
        r.put("tableName","gongyingshang");
        r.put("userId",gongyingshang.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody GongyingshangEntity gongyingshang){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<GongyingshangEntity> queryWrapper = new EntityWrapper<GongyingshangEntity>()
            .eq("username", gongyingshang.getUsername())
            ;
        GongyingshangEntity gongyingshangEntity = gongyingshangService.selectOne(queryWrapper);
        if(gongyingshangEntity != null)
            return R.error("账户已经被使用");
        gongyingshang.setCreateTime(new Date());
        gongyingshangService.insert(gongyingshang);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        GongyingshangEntity gongyingshang = new GongyingshangEntity();
        gongyingshang.setPassword("123456");
        gongyingshang.setId(id);
        gongyingshangService.updateById(gongyingshang);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        GongyingshangEntity gongyingshang = gongyingshangService.selectOne(new EntityWrapper<GongyingshangEntity>().eq("username", username));
        if(gongyingshang!=null){
            gongyingshang.setPassword("123456");
            boolean b = gongyingshangService.updateById(gongyingshang);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrGongyingshang(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        GongyingshangEntity gongyingshang = gongyingshangService.selectById(id);
        if(gongyingshang !=null){
            //entity转view
            GongyingshangView view = new GongyingshangView();
            BeanUtils.copyProperties( gongyingshang , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
