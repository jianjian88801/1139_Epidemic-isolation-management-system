
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
 * 物品申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wupinShenqing")
public class WupinShenqingController {
    private static final Logger logger = LoggerFactory.getLogger(WupinShenqingController.class);

    @Autowired
    private WupinShenqingService wupinShenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private WupinService wupinService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private GongyingshangService gongyingshangService;


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
        PageUtils page = wupinShenqingService.queryPage(params);

        //字典表数据转换
        List<WupinShenqingView> list =(List<WupinShenqingView>)page.getList();
        for(WupinShenqingView c:list){
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
        WupinShenqingEntity wupinShenqing = wupinShenqingService.selectById(id);
        if(wupinShenqing !=null){
            //entity转view
            WupinShenqingView view = new WupinShenqingView();
            BeanUtils.copyProperties( wupinShenqing , view );//把实体数据重构到view中

                //级联表
                WupinEntity wupin = wupinService.selectById(wupinShenqing.getWupinId());
                if(wupin != null){
                    BeanUtils.copyProperties( wupin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWupinId(wupin.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(wupinShenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R save(@RequestBody WupinShenqingEntity wupinShenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wupinShenqing:{}",this.getClass().getName(),wupinShenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wupinShenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wupinShenqing.setWupinShenqingYesnoTypes(1);
            wupinShenqing.setInsertTime(new Date());
            wupinShenqing.setCreateTime(new Date());
            wupinShenqingService.insert(wupinShenqing);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WupinShenqingEntity wupinShenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wupinShenqing:{}",this.getClass().getName(),wupinShenqing.toString());

            wupinShenqingService.updateById(wupinShenqing);//根据id更新
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/shenqing")
    public R shenqing(@RequestBody WupinShenqingEntity wupinShenqing, HttpServletRequest request){
        logger.debug("shenqing方法:,,Controller:{},,wupinShenqing:{}",this.getClass().getName(),wupinShenqing.toString());

        if(wupinShenqing.getWupinShenqingYesnoTypes().intValue() == 2){
            WupinShenqingEntity wupinShenqingEntity = wupinShenqingService.selectById(wupinShenqing.getId());//查出原先的
            WupinEntity wupinEntity = wupinService.selectById(wupinShenqingEntity.getWupinId());
            if(wupinEntity == null)
                return R.error(511,"查不到申请物品");
            int shengyu = wupinEntity.getWupinKucunNumber() - wupinShenqingEntity.getWupinShenqingNumber();
            if(shengyu<0)
                return R.error(511,"申请数量不能大于库存数量");
            wupinEntity.setWupinKucunNumber(shengyu);
            wupinService.updateById(wupinEntity);



        }


        wupinShenqingService.updateById(wupinShenqing);//根据id更新
        return R.ok();

    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        wupinShenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<WupinShenqingEntity> wupinShenqingList = new ArrayList<>();//上传的东西
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
                            WupinShenqingEntity wupinShenqingEntity = new WupinShenqingEntity();
//                            wupinShenqingEntity.setWupinShenqingUuidNumber(data.get(0));                    //申请流水号 要改的
//                            wupinShenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wupinShenqingEntity.setWupinId(Integer.valueOf(data.get(0)));   //物品 要改的
//                            wupinShenqingEntity.setWupinShenqingNumber(Integer.valueOf(data.get(0)));   //申请数量 要改的
//                            wupinShenqingEntity.setWupinContent("");//照片
//                            wupinShenqingEntity.setWupinShenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            wupinShenqingEntity.setWupinShenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            wupinShenqingEntity.setInsertTime(date);//时间
//                            wupinShenqingEntity.setCreateTime(date);//时间
                            wupinShenqingList.add(wupinShenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //申请流水号
                                if(seachFields.containsKey("wupinShenqingUuidNumber")){
                                    List<String> wupinShenqingUuidNumber = seachFields.get("wupinShenqingUuidNumber");
                                    wupinShenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wupinShenqingUuidNumber = new ArrayList<>();
                                    wupinShenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wupinShenqingUuidNumber",wupinShenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请流水号
                        List<WupinShenqingEntity> wupinShenqingEntities_wupinShenqingUuidNumber = wupinShenqingService.selectList(new EntityWrapper<WupinShenqingEntity>().in("wupin_shenqing_uuid_number", seachFields.get("wupinShenqingUuidNumber")));
                        if(wupinShenqingEntities_wupinShenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WupinShenqingEntity s:wupinShenqingEntities_wupinShenqingUuidNumber){
                                repeatFields.add(s.getWupinShenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wupinShenqingService.insertBatch(wupinShenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
