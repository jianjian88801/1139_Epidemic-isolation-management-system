const menu = {
    list() {
        return [
    {
        "backMenu":[
            {
                "child":[
                    
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"供应商问题类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryGongyingshangwenti"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"用户问题类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryYonghuwenti"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"物品类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryWupin"
                    }
                ],
                "menu":"基础数据管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"地区管理",
                        "menuJump":"列表",
                        "tableName":"diqu"
                    }
                ],
                "menu":"地区管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"用户管理",
                        "menuJump":"列表",
                        "tableName":"yonghu"
                    }
                ],
                "menu":"用户管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"行程管理",
                        "menuJump":"列表",
                        "tableName":"xingcheng"
                    }
                ],
                "menu":"行程管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "修改",
                            "删除"
                        ],
                        "menu":"用户问题管理",
                        "menuJump":"列表",
                        "tableName":"yonghuwenti"
                    }
                ],
                "menu":"用户问题管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"隔离管理",
                        "menuJump":"列表",
                        "tableName":"geli"
                    }
                ],
                "menu":"隔离管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "审核",
                            "修改",
                            "删除"
                        ],
                        "menu":"隔离结束申请管理",
                        "menuJump":"列表",
                        "tableName":"gelishenqing"
                    }
                ],
                "menu":"隔离结束申请管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"供应商管理",
                        "menuJump":"列表",
                        "tableName":"gongyingshang"
                    }
                ],
                "menu":"供应商管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"供应商问题管理",
                        "menuJump":"列表",
                        "tableName":"gongyingshangwenti"
                    }
                ],
                "menu":"供应商问题管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"物品管理",
                        "menuJump":"列表",
                        "tableName":"wupin"
                    }
                ],
                "menu":"物品管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"物品申请管理",
                        "menuJump":"列表",
                        "tableName":"wupinShenqing"
                    }
                ],
                "menu":"物品申请管理"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"管理员",
        "tableName":"users"
    }
	,
	{
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"供应商问题管理",
                        "menuJump":"列表",
                        "tableName":"gongyingshangwenti"
                    }
                ],
                "menu":"供应商问题管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"物品管理",
                        "menuJump":"列表",
                        "tableName":"wupin"
                    }
                ],
                "menu":"物品管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "审核"
                        ],
                        "menu":"物品申请管理",
                        "menuJump":"列表",
                        "tableName":"wupinShenqing"
                    }
                ],
                "menu":"物品申请管理"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"供应商",
        "tableName":"gongyingshang"
    }
	,
	{
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"隔离管理",
                        "menuJump":"列表",
                        "tableName":"geli"
                    }
                ],
                "menu":"隔离管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增"
                        ],
                        "menu":"隔离结束申请管理",
                        "menuJump":"列表",
                        "tableName":"gelishenqing"
                    }
                ],
                "menu":"隔离结束申请管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"物品管理",
                        "menuJump":"列表",
                        "tableName":"wupin"
                    }
                ],
                "menu":"物品管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增"
                        ],
                        "menu":"物品申请管理",
                        "menuJump":"列表",
                        "tableName":"wupinShenqing"
                    }
                ],
                "menu":"物品申请管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"行程管理",
                        "menuJump":"列表",
                        "tableName":"xingcheng"
                    }
                ],
                "menu":"行程管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"用户问题管理",
                        "menuJump":"列表",
                        "tableName":"yonghuwenti"
                    }
                ],
                "menu":"用户问题管理"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"用户",
        "tableName":"yonghu"
    }
]
    }
}
export default menu;