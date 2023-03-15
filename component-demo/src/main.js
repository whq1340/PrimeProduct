import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'font-awesome/css/font-awesome.min.css';
import App from './App.vue'
import axios from 'axios'
//导入路由配置
import router from './router/index'

//配置根目录
axios.defaults.baseURL = "http://localhost:8088"
//将axios作为全局的自定义属性，每个组件可以在内部直接使用
Vue.prototype.$http = axios

Vue.config.productionTip = false
//注册element组件
Vue.use(ElementUI);

new Vue({
  render: h => h(App),
  router:router
}).$mount('#app')
