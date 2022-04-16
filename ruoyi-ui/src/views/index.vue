<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 14px">
          社会心理咨询服务系统
          <br />
          <br />
          面向大众的社会心理咨询服务
          <br />
          通过适当的调解，劝导，心理咨询,
          &nbsp;&nbsp;&nbsp; 提升社会群众的心理健康水平
          <br /> <br />
          <h4 class="text-danger">
            本产品不收取任何费用
          </h4>
        </blockquote>

        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>社会心理咨询服务管理框架</h2>
        <p>
          提供面向大众的社会心理服务，不再需要通过拨打热线电话进行咨询服务，将咨询服务与互联网相结合，通过微信小程序，实现实时便捷的平台咨询服务。通过咨询师，督导等角色分工，保证咨询服务的有效性与可靠性。
        </p>
        <p>
          <b>当前版本:</b> <span>v0.3</span>
        </p>


      </el-col>


    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> github：<el-link
                href="https://github.com/ECNU22Team9/wehere-groupB"
                target="_blank"
                >https://github.com/ECNU22Team9/wehere-groupB</el-link
              >
            </p>

            <p>
              <i class="el-icon-chat-dot-round"></i> 小组：<a
                href="javascript:;"
                >Group 09(A, B)</a
              >
            </p>

          </div>
        </el-card>
      </el-col>


    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.1",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

