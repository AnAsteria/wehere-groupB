
<template>
  <div class="login-wrapper">
    <img class="logo" :src="logo" />
    <el-form
      ref="login"
      :rules="rules"
      :model="form"
      label-width="0"
      style="width:100%;"
      @keydown.enter.native="submit"
    >
      <!-- Github登录方式 -->
    <!--  <el-form-item prop="userID">
        <el-select v-model="form.userID" class="user-selector">
          <el-option
            v-for="index in 30"
            :key="index"
            :label="`user${index-1}`"
            :value="`user${index-1}`"
          ></el-option>
        </el-select>
<<<<<<< HEAD
      </el-form-item>-->
      <!-- 线上版本登录方式 -->
      <el-form-item prop="userID">
        <el-input v-model="form.userID" placeholder="请输入用户名" type="text" clearable></el-input>
      </el-form-item>
      <!--<el-form-item prop="password">
        <el-input
          v-model="form.password"
          placeholder="请输入密码"
          type="password"
          show-password
          clearable
        ></el-input>
      </el-form-item>-->
=======
      /el-form-item>
>>>>>>> ebe0f96a0c44c1cb48b383697ca9be851bba3bc1
    </el-form>

    <el-button
      type="primary"
      @click="submit"
      style="width:100%; margin-top: 6px;"
      :loading="loading"
    >登录</el-button>

  </div>
</template>

<script>
import { Form, FormItem, Select, Option } from 'element-ui'
import logo from '../../assets/image/logo.png'
import tim from '../../../../../tim.js'
import { getUserSig, SDKAppID } from '../../../../../api/im/api/usersig.js'
<<<<<<< HEAD
import { getUserProfile } from "@/api/system/user"

=======
import {getUserProfile} from "@/api/system/user";

import userAvatar from "../../../user/profile/userAvatar";
import userInfo from "../../../user/profile/userInfo";
import resetPwd from "../../../user/profile/resetPwd";
>>>>>>> ebe0f96a0c44c1cb48b383697ca9be851bba3bc1

export default {
  name: 'Login',
  components: {
    ElForm: Form,
    ElFormItem: FormItem,
    ElSelect: Select,
    ElOption: Option,
    userAvatar,
    userInfo,
    resetPwd
  },
  data() {
    const checkUserID = (rule, value, callback) => {
      if (!/^[a-zA-Z][a-zA-Z0-9_]{3,23}$/.test(value)) {
        callback(new Error('不合法（字母开头+字母/数字，长度4-24)'))
      } else {
        callback()
      }
    }

    return {
      user: {},
      form: {
        userID: 'user0',
        password: ''
      },
      rules: {
        userID: [
          { required: true, message: '请输入 userID', trigger: 'blur' },
          { validator: checkUserID, trigger: 'blur' }
        ],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
      },
      logo: logo,
      registerVisible: false,
      loading: false,
      user:{}
    }
  },
  created(){
    this.getUser()
  },
  watch:{
    user(){
      this.$nextTick( ()=>{
        this.form.userID=this.user.userName
        console.log(this.user.userName)
        this.submit()
      } )
    }
  },
  mounted() {
    getUserProfile().then(response => {
      this.form.userID =  response.data.userName
      this.submit()
    });
  },
  methods: {
    getUser(){
      getUserProfile().then(response => {
        this.user = response.data;
      })
    },
    submit() {
      this.$refs['login'].validate(valid => {
        if (valid) {
          this.login()
        }
      })
    },
    login() {
      this.loading = true
      getUserSig(this.form.userID)
        .then((res) => {
          console.log(res)
          return res["im-user-sig"]
        }).then((userSig) => {
          console.log("UserSig", userSig)

          tim
            .login({
              userID: this.form.userID,
              userSig: userSig
            })
            .then(() => {
              this.loading = false
              this.$store.commit('toggleIsLogin', true)
              this.$store.commit('startComputeCurrent')
              this.$store.commit('showMessage', { type: 'success', message: '登录成功' })
              this.$store.commit({
                type: 'GET_USER_INFO',
                userID: this.form.userID,
                userSig: userSig,
                sdkAppID: SDKAppID
              })
              this.$store.commit('showMessage', {
                type: 'success',
                message: '登录成功'
              })
            })
            .catch(error => {
              this.loading = false
              this.$store.commit('showMessage', {
                message: '登录失败：' + error.message,
                type: 'error'
              })
            })
        })
    },
  }
}
</script>

<style lang="stylus" scoped>
.login-wrapper
  display flex
  align-items center
  flex-direction column
  width 450px
  background #ffffff
  color #000000
  border-radius 5px
  box-shadow: 0 11px 20px 0 rgba(0,0,0,0.3)
  .row-div
    display flex
    justify-content center
    align-items center
    flex-direction row
  .logo
    width 110px
    height 110px
  .loginBox
    width 320px
    margin 0 0 20px 0
    .send-code
      width 112px
    .login-im-btn
      width 100%
  .loginFooter
    color: #8c8a8ac7
    text-align: center
    padding: 0 0 20px 0
    cursor: pointer
.login-wrapper {
  display: flex;
  align-items: center;
  flex-direction: column;
  width: 400px;
  padding: 20px 80px 50px;
  background: #ffffff;
  color: #000000;
  border-radius: 5px;
  box-shadow: 0 11px 20px 0 rgba(0, 0, 0, 0.3);

  .logo {
    width: 130px;
    height: 130px;
  }

  .register-button {
    width: 100%;
    margin: 6px 0 0 0;
  }

  .user-selector {
    width: 100%;
  }
}
</style>
