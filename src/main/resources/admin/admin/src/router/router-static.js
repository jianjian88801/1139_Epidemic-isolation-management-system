import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import diqu from '@/views/modules/diqu/list'
    import geli from '@/views/modules/geli/list'
    import gelishenqing from '@/views/modules/gelishenqing/list'
    import gongyingshang from '@/views/modules/gongyingshang/list'
    import gongyingshangwenti from '@/views/modules/gongyingshangwenti/list'
    import wupin from '@/views/modules/wupin/list'
    import wupinShenqing from '@/views/modules/wupinShenqing/list'
    import xingcheng from '@/views/modules/xingcheng/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yonghuwenti from '@/views/modules/yonghuwenti/list'
    import dictionaryDiqu from '@/views/modules/dictionaryDiqu/list'
    import dictionaryGeli from '@/views/modules/dictionaryGeli/list'
    import dictionaryGelishenqingYesno from '@/views/modules/dictionaryGelishenqingYesno/list'
    import dictionaryGongyingshangwenti from '@/views/modules/dictionaryGongyingshangwenti/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryWupin from '@/views/modules/dictionaryWupin/list'
    import dictionaryWupinShenqingYesno from '@/views/modules/dictionaryWupinShenqingYesno/list'
    import dictionaryYonghuwenti from '@/views/modules/dictionaryYonghuwenti/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryDiqu',
        name: '风险等级',
        component: dictionaryDiqu
    }
    ,{
        path: '/dictionaryGeli',
        name: '隔离类型',
        component: dictionaryGeli
    }
    ,{
        path: '/dictionaryGelishenqingYesno',
        name: '申请状态',
        component: dictionaryGelishenqingYesno
    }
    ,{
        path: '/dictionaryGongyingshangwenti',
        name: '供应商问题类型',
        component: dictionaryGongyingshangwenti
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryWupin',
        name: '物品类型',
        component: dictionaryWupin
    }
    ,{
        path: '/dictionaryWupinShenqingYesno',
        name: '申请状态',
        component: dictionaryWupinShenqingYesno
    }
    ,{
        path: '/dictionaryYonghuwenti',
        name: '用户问题类型',
        component: dictionaryYonghuwenti
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/diqu',
        name: '地区',
        component: diqu
      }
    ,{
        path: '/geli',
        name: '隔离',
        component: geli
      }
    ,{
        path: '/gelishenqing',
        name: '隔离结束申请',
        component: gelishenqing
      }
    ,{
        path: '/gongyingshang',
        name: '供应商',
        component: gongyingshang
      }
    ,{
        path: '/gongyingshangwenti',
        name: '供应商问题',
        component: gongyingshangwenti
      }
    ,{
        path: '/wupin',
        name: '物品',
        component: wupin
      }
    ,{
        path: '/wupinShenqing',
        name: '物品申请',
        component: wupinShenqing
      }
    ,{
        path: '/xingcheng',
        name: '行程',
        component: xingcheng
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yonghuwenti',
        name: '用户问题',
        component: yonghuwenti
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
