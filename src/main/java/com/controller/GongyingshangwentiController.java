
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.GongyingshangEntity;
import com.entity.GongyingshangwentiEntity;
import com.entity.view.GongyingshangwentiView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * 供应商问题
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongyingshangwenti")
public class GongyingshangwentiController {
    private static final Logger logger = LoggerFactory.getLogger(GongyingshangwentiController.class);

    @Autowired
    private GongyingshangwentiService gongyingshangwentiService;


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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = gongyingshangwentiService.queryPage(params);

        //字典表数据转换
        List<GongyingshangwentiView> list =(List<GongyingshangwentiView>)page.getList();
        for(GongyingshangwentiView c:list){
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
        GongyingshangwentiEntity gongyingshangwenti = gongyingshangwentiService.selectById(id);
        if(gongyingshangwenti !=null){
            //entity转view
            GongyingshangwentiView view = new GongyingshangwentiView();
            BeanUtils.copyProperties( gongyingshangwenti , view );//把实体数据重构到view中

                //级联表
                GongyingshangEntity gongyingshang = gongyingshangService.selectById(gongyingshangwenti.getGongyingshangId());
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
    public R save(@RequestBody GongyingshangwentiEntity gongyingshangwenti, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongyingshangwenti:{}",this.getClass().getName(),gongyingshangwenti.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("供应商".equals(role))
            gongyingshangwenti.setGongyingshangId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            gongyingshangwenti.setInsertTime(new Date());
            gongyingshangwenti.setCreateTime(new Date());
            gongyingshangwentiService.insert(gongyingshangwenti);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongyingshangwentiEntity gongyingshangwenti, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongyingshangwenti:{}",this.getClass().getName(),gongyingshangwenti.toString());

            gongyingshangwentiService.updateById(gongyingshangwenti);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongyingshangwentiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GongyingshangwentiEntity> gongyingshangwentiList = new ArrayList<>();//上传的东西
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
                            GongyingshangwentiEntity gongyingshangwentiEntity = new GongyingshangwentiEntity();
//                            gongyingshangwentiEntity.setGongyingshangId(Integer.valueOf(data.get(0)));   //供应商 要改的
//                            gongyingshangwentiEntity.setGongyingshangwentiName(data.get(0));                    //问题名称 要改的
//                            gongyingshangwentiEntity.setGongyingshangwentiTypes(Integer.valueOf(data.get(0)));   //供应商问题类型 要改的
//                            gongyingshangwentiEntity.setGongyingshangwentiContent("");//照片
//                            gongyingshangwentiEntity.setInsertTime(date);//时间
//                            gongyingshangwentiEntity.setHuifuContent("");//照片
//                            gongyingshangwentiEntity.setCreateTime(date);//时间
                            gongyingshangwentiList.add(gongyingshangwentiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        gongyingshangwentiService.insertBatch(gongyingshangwentiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
