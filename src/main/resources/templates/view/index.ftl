<!doctype html>
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <title>Quartz定时任务</title>
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<div id="app">
    <button @click="query">查询定时任务</button>
    <button @click="">添加定时任务</button>
    <p v-show="isShow" ><font style="background-color: aquamarine">{{msg}}</font></p>
    <table class="table" style="line-break: auto">
        <thead>
        <tr v-show="showFlag">
            <th>序号</th>
            <th>批处理名称</th>
            <th>批处理所属组</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(item, index) in list" >
            <td>{{index+1}}</td>
            <td>{{item.jobName}}</td>
            <td>{{item.jobGroup}}</td>
            <td @click="start(item.jobName,item.jobGroup)">启动</td>
            <td @click="stop(item.jobName,item.jobGroup)">暂停</td>
<#--            <td @click="update()">修改</td>-->
<#--            <td @click="delete()">删除</td>-->
        </tr>
        </tbody>
    </table>

</div>

</body>
<script>
    var app = new Vue({
        el:'#app',
        data:{
            list:[],
            showFlag:false,
            job:{
                jobClassName:'',
                jobGroupName:''
            },
            msg:'',
            isShow:false
        },
        methods:{
            query:function () {
                var that = this;
                axios.get("/query/jobs").then(function (response) {
                    that.list = response.data.data;
                    that.isShow=false;
                    console.log(response)
                    if (that!=null){
                        that.showFlag=true;
                    }
                })
            },
            start:function (jobName,jobGroup) {
                this.job.jobClassName=jobName;
                this.job.jobGroupName=jobGroup;
                var that = this;
                axios.post("/job/start",this.job).then(function (response) {
                    that.msg = response.data.msg;
                    that.isShow=true;
                },function (err) {
                    that.isShow=false;
                })
            },
            stop:function (jobName,jobGroup) {
                this.job.jobClassName=jobName;
                this.job.jobGroupName=jobGroup;
                var that = this;
                axios.post("/job/stop",this.job).then(function (response) {
                    that.msg = response.data.msg;
                    that.isShow=true;
                },function (err) {
                    that.isShow=false;
                })
            }
        }
    });
</script>
</html>
