
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
 * 物品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wupin")
public class WupinController {
    private static final Logger logger = LoggerFactory.getLogger(WupinController.class);

    @Autowired
    private WupinService wupinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private GongyingshangService gongyingshangService;

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
        params.put("wupinDeleteStart",1);params.put("wupinDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = wupinService.queryPage(params);

        //字典表数据转换
        List<WupinView> list =(List<WupinView>)page.getList();
        for(WupinView c:list){
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
        WupinEntity wupin = wupinService.selectById(id);
        if(wupin !=null){
            //entity转view
            WupinView view = new WupinView();
            BeanUtils.copyProperties( wupin , view );//把实体数据重构到view中

                //级联表
                GongyingshangEntity gongyingshang = gongyingshangService.selectById(wupin.getGongyingshangId());
                if(gongyingshang != null){
                    BeanUtils.copyProperties( gongyingshang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongyingshangId(gongyingshang.getId());
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
    public R save(@RequestBody WupinEntity wupin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wupin:{}",this.getClass().getName(),wupin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("供应商".equals(role))
            wupin.setGongyingshangId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WupinEntity> queryWrapper = new EntityWrapper<WupinEntity>()
            .eq("gongyingshang_id", wupin.getGongyingshangId())
            .eq("wupin_name", wupin.getWupinName())
            .eq("wupin_types", wupin.getWupinTypes())
            .eq("wupin_kucun_number", wupin.getWupinKucunNumber())
            .eq("wupin_delete", wupin.getWupinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WupinEntity wupinEntity = wupinService.selectOne(queryWrapper);
        if(wupinEntity==null){
            wupin.setWupinDelete(1);
            wupin.setCreateTime(new Date());
            wupinService.insert(wupin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WupinEntity wupin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wupin:{}",this.getClass().getName(),wupin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("供应商".equals(role))
//            wupin.setGongyingshangId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<WupinEntity> queryWrapper = new EntityWrapper<WupinEntity>()
            .notIn("id",wupin.getId())
            .andNew()
            .eq("gongyingshang_id", wupin.getGongyingshangId())
            .eq("wupin_name", wupin.getWupinName())
            .eq("wupin_types", wupin.getWupinTypes())
            .eq("wupin_kucun_number", wupin.getWupinKucunNumber())
            .eq("wupin_delete", wupin.getWupinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WupinEntity wupinEntity = wupinService.selectOne(queryWrapper);
        if("".equals(wupin.getWupinPhoto()) || "null".equals(wupin.getWupinPhoto())){
                wupin.setWupinPhoto(null);
        }
        if(wupinEntity==null){
            wupinService.updateById(wupin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<WupinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WupinEntity wupinEntity = new WupinEntity();
            wupinEntity.setId(id);
            wupinEntity.setWupinDelete(2);
            list.add(wupinEntity);
        }
        if(list != null && list.size() >0){
            wupinService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<WupinEntity> wupinList = new ArrayList<>();//上传的东西
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
                            WupinEntity wupinEntity = new WupinEntity();
//                            wupinEntity.setGongyingshangId(Integer.valueOf(data.get(0)));   //供应商 要改的
//                            wupinEntity.setWupinName(data.get(0));                    //物品名称 要改的
//                            wupinEntity.setWupinPhoto("");//照片
//                            wupinEntity.setWupinTypes(Integer.valueOf(data.get(0)));   //物品类型 要改的
//                            wupinEntity.setWupinKucunNumber(Integer.valueOf(data.get(0)));   //物品库存 要改的
//                            wupinEntity.setWupinDelete(1);//逻辑删除字段
//                            wupinEntity.setWupinContent("");//照片
//                            wupinEntity.setCreateTime(date);//时间
                            wupinList.add(wupinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wupinService.insertBatch(wupinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
