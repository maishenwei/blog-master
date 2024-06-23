<template>
    <div style="width: 100%;background:white;float: left;">
        <div
            style="margin-bottom:10px;margin-top:10px;float:left;width:97%;margin-left:1.5%;font-size:19px;height:30px;line-height:20px;border-bottom:1px solid #DCDFE6;">
            <div style="margin-left:10px;margin-right:10px;">留言板</div>
        </div>
        <el-input style="width:97%;margin-left:1.5%;" type="textarea" v-model="message.content" :rows="5"
            placeholder="请输入留言内容"></el-input>
        <div style="float:left;width:97%;margin-left:1.5%;margin-top: 10px;margin-bottom: 10px;">
            <el-button style="margin-left: 20px;float:right;" type="primary" @click="postMessage()">发表留言</el-button>
        </div>
        <div style="border-top:2px solid #1abc9c;height: 10px;width: 100%;float: left;"></div>
        <div style="border-bottom:1px solid #DCDFE6;float:left;width:100%;margin-bottom: 10px;background: white;"
            v-for="item in tableData">
            <div style="float:left;height: 70px;width: 90px;">
                <img src="../../../static/images/user.jpg"
                    style="height:70px;width:70px;margin-left:10px;margin-top:10px;" />
            </div>
            <div style="float:left;width: 680px;">
                <div style="width:100%;height: 15px;margin-top:10px;font-weight: 600;font-size: 13px;">
                    {{ item.name }}
                </div>
                <div style="width:100%;height: 20px;line-height: 20px;font-size: 12px;">
                    {{ item.createTime }}
                </div>
                <div style="margin-bottom: 5px;width:100%;min-height: 50px;font-size: 14px;line-height: 20px;">
                    {{ item.content }}
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
import formatDate from '../../utils/dateUtil.js';
import {getlocalStorage} from "../../utils/localStorageUtil.js";
export default {
    data() {
        return {
            message: {
                content: ""
            },
            pageSize:5,
            tableData: []
        };
    },
    methods: {
        getMessagePage(response) {
            this.tableData = response.data.data;
            this.total = response.data.count;
            for (var i = 0; i < this.tableData.length; i++) {
                this.tableData[i].createTime = formatDate(new Date(this.tableData[i].createTime), 'yyyy-MM-dd hh:mm:ss');
            }
            if (response.data.count / this.pageSize > parseInt(response.data.count / this.pageSize)) {
                this.totalPage = parseInt(response.data.count / this.pageSize) + 1;
            } else {
                this.totalPage = parseInt(response.data.count / this.pageSize);
            }
        },

        postMessage(){
            const self = this
            let uid = getlocalStorage("uid");

            axios.post("/message/post",{
                userId:uid,
                content:this.message.content
            }).then(function(response){
                self.fetchData();
            });
        },

        fetchData(){
            const self = this
            axios.get("/message/list").then(function(response){
                self.getMessagePage(response);
            })
        }
    },
    mounted() {
       this.fetchData();
    }
}
</script>
<style></style>