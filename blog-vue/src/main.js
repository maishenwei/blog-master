// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// 引入element-ui当中的所有组件
import ElementUI from 'element-ui';
//引入element-ui的所有样式
import 'element-ui/lib/theme-chalk/index.css';
import axios from './utils/axiosInterceptors.js';
import * as echarts from 'echarts';
import { getToken } from '@/utils/token'

Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
// 配置 Vue 插件
Vue.use(ElementUI);

//axios.defaults.baseURL = "https://xuezhabiji.com/api";
axios.defaults.baseURL = "http://localhost:9090";
Vue.prototype.$http = axios;
//关闭弹框点击遮罩之外的地方关闭弹框
ElementUI.Dialog.props.closeOnClickModal.default = false;

// 全局挂载路由导航守卫： 验证用户是否登录
router.beforeEach((to, from, next) => {
  if (to.name !== 'login' && !getToken())  next('/login')   // 如果用户不是访问登录页而且没有登录，则强制跳转到登录页
  else next()
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})