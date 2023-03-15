import VueRouter from 'vue-router';
import Vue from 'vue';
import  Main  from '../main/Main.vue';
import  My  from '../main/My.vue';
import  UserManage  from '../main/UserManage.vue';
import  TradeManage  from '../main/TradeManage.vue';
import Product from '../main/Product.vue';
import Login from '../login/index.vue';
import  Menu  from '@/main/Menu.vue';
import  Navigation  from '@/main/Navigation.vue';

//将VueRouter设置为Vue的插件
Vue.use(VueRouter)

const router = new VueRouter({
    //指定hash属性与组件的对应关系
    routes:[
        {path:'/login',component:Login},
        //第一次进网页路由重定向
        {path: '/' , component:Login},

        {path:'/navigation',component:Navigation},
        {path:'/menu',component:Menu},
        {
         path: '/main' , 
         component: Main,
         //通过childre属性，嵌套声明子路由
         children:
         [
            {path:'userManage',component:UserManage},
            {
                path:'tradeManage',
                component:TradeManage,
                children:
                [
                    {path:':id',component:Product,props:true},
                ]
            }
         ]
        },
        {path: '/my' , component: My},
    ]
})

export default router