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
          <el-input size="small" v-model="confirm_password" placeholder="请确认密码" show-password>
          </el-input>
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
export default {
  name: 'register',
  data() {
    return {
      username: "",
      password: "",
      confirm_password:""
    }
  },
  methods: {
    register() {
      console.log("点击注册")
     
      if(this.confirm_password != this.password){
        Message.error("输入密码不一致，请确认密码！")
        return
      }
      const self = this;
      axios.post("/register",{
        username:this.username,
        password:this.password
      }).then(function(respon){
        console.log(respon)
        
        if(respon.data.code == 1){
          console.log("注册成功 "+ self.username);
          self.$router.push({ 
            name: 'login' ,
            params: {  
              username:self.username,
              password:self.password 
            }
          });
        }else{
          console.log("注册失败")
        }
      });
    }
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
