<template>
  <div class="login-fill">
    <div class="login-box">
        <div class="login-about">
          <div class="text">
            桥梁初始信息检查系统
          </div>
        </div>
        <a-form :model="formState" name="normal_login" class="login-form" @finish="onFinish" >
          <a-form-item  name="account" class="sign-input"
            :rules="[{ required: true, message: '不能输入空用户账号，账号只允许是数字' }]">
            <a-input placeholder="用户账号" size="large" pattern="[0-9]*" v-model:value="formState.account" class="login-input">
              <template #prefix>
                <UserOutlined class="site-form-item-icon" />
              </template>
            </a-input>
          </a-form-item>
          <a-form-item name="password" :rules="[{ required: true, message: '不能输入空密码' }]" class="sign-input">
            <a-input-password placeholder="用户密码" size="large" v-model:value="formState.password" class="login-input">
              <template #prefix>
                <LockOutlined class="site-form-item-icon" />
              </template>
            </a-input-password>
          </a-form-item>
          <div class="login-btn-box">
            <a-form-item>
              <a-button type="primary" html-type="submit" class="login-form-button" style="height: 3em; border-radius:1.2em">
                登录
              </a-button>
            </a-form-item>
          </div>
        </a-form>
    </div>
  </div>

</template>
<script lang="ts">
import { defineComponent, reactive } from 'vue';
import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';
import axios from 'axios';
import { useUserStore } from '../store/user';
import router from '../router';
import { error_message } from '../utils/errorMessage'
interface FormState {
  account: string;
  password: string;
  remember: boolean;
}
export default defineComponent({
  components: {
    UserOutlined,
    LockOutlined,
  },
  setup() {
    const userStore = useUserStore()
    const formState = reactive<FormState>({
      account: '',
      password: '',
      remember: true,
    });


    const onFinish = (values: any) => {
      axios({
        url: 'http://localhost:3000/api/user/login',
        method: 'POST',
        params: {
          account: values.account,
          password: values.password,
        }
      })
        .then((resp) => {
          const data = resp.data;

          if (data.error_info === 'success') {
            userStore.$patch({
              username: data.username,
              unit_no: data.unit_no,
              unit_name: data.unit_name,
              is_login: true,
              account: values.account,
            })
            sessionStorage.setItem("is_login", "true");
            router.push('/index')
          } else {
            error_message("账号或密码错误", "error")
          }

        })
          .catch(() => {
            error_message("出现未知错误", "error")
          })
    };


    return {
      formState,
      onFinish,
    };
  },
});
</script>
<style scoped>
  .login-box {
    height: 75vh;
    width: 75vw;
    box-shadow: 0 0 1em #696969;
    background-image: linear-gradient(to top, #cfd9df 0%, #e2ebf0 100%);
    display: flex;
    justify-content: flex-end;
    align-items: center;
    border-radius: 1em;
  }
  .login-about {
    width: 75%;
    height: 100%;
    background-image: url('../assets/images/bg-3.png');
    border-top-left-radius: 1.2em;
    border-bottom-left-radius: 1.2em;
    background-repeat: no-repeat;
    background-size: cover;
  }
  .login-form {
    width: 25%;
    margin-right: 5em;
    margin-left: 5em;
  }
  .login-box img {
    height: 60vh;
    border-radius: 10px 0 10px 0;
  }
  .text {
    font-size: 3em;
    font-weight: 800;
    text-align: center;
    letter-spacing: .3em;
    margin-top: .6em;
    text-shadow: .1em .1em  #6ea5dc;
    @supports (-webkit-background-clip: text) or (background-clip: text) {
        background-image: linear-gradient(-225deg, #5D9FFF 0%, #B8DCFF 48%, #6BBBFF 100%);
        -webkit-background-clip: text;
        background-clip: text;
        color: transparent;
      }
  }
  .login-fill {
    height: 100vh;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .login-input {
    border-radius: 1.2em;
    opacity: .7;
    height: 3em;
  }
  .sign-input {
    margin-top: 1rem;
  }
</style>
  