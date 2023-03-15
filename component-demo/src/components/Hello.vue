<template>
    <el-table
    :data="tableData"
    style="width: 100%"
    :row-class-name="tableRowClassName">
    <!-- <el-table-column>
        <i class="fa fa-circle-o-notch fa-spin"></i>
    </el-table-column> -->
    <el-table-column
      prop="username"
      label="用户名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="password"
      label="密码"
      width="180">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="电话"
      width="180">
    </el-table-column>
    <el-table-column
      prop="birthday"
      label="生日">
    </el-table-column>
  </el-table>
</template>

<script>

export default{
    methods: {
        //表格颜色的改变
      tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      }
    },
    created:function(){
        console.log("app被创建了！")
        //一般网络请求在创建是发送
        this.$http.get("/user/trade").then((response) => {
            this.tableData = response.data.list
            //console.log(response)
        }).catch(function (error){
            console.log(error);
        }).then(function (){
            //这块程序总是会执行
            console.log("网络请求已发送")
        })
    },
    data() {
      return {
        tableData:[]
      }
    }
}
</script>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>