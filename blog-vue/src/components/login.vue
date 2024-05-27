<template>
  <div id="content">
    <el-card>
      <el-form>
        <el-form-item style="text-align: center;">
          <div style="font-size:20px;position: relative;">
            星空个人博客系统
          </div>
        </el-form-item>
        <el-form-item>
          <el-input size="small" v-model="username" placeholder="请输入用户名">
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input size="small" v-model="password" placeholder="请输入密码" show-password>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%;" @click="login">登录</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%;" @click="register">注册</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";
import { Message } from "element-ui";
import global from '../components/data/data.js';
import {getToken,setToken} from "../utils/token.js";
import {getlocalStorage,setlocalStorage} from "../utils/localStorageUtil.js";
export default {
  name: 'login',
  data() {
    return {
      username: this.$route.params.username,
      password: this.$route.params.password
    }
  },
  methods: {
    login() {
      console.log("点击登录")
      const self = this;
      axios.post("/login",{
        username:this.username,
        password:this.password
      }).then(function(respon){
        console.log(respon)
        if(respon.data.code == 0){
          console.log("登录失败");
          return;
        }

        setToken(respon.data.data.token)
        setlocalStorage("uid",respon.data.data.id)
        self.$router.push({ 
          name: 'index2' ,
          params: {  
              id:respon.data.data.id
            }
        });
      });
    },

    register() {
      console.log("点击注册")
      this.$router.push({
        path: '/register'
      });
    },
  },
  created() {
  },
  beforeCreate() {
    document.querySelector('body').setAttribute('style', 'background:url(../../static/images/login2.png);background-size:100% 100%');
  },
  beforeDestroy() {
    document.querySelector('body').removeAttribute('style');
  }
}
</script>

<style>
html,
body {
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
  overflow: hidden;
}

#content {
  width: 300px;
  margin: auto;
  margin-top: 150px;
}
</style>
