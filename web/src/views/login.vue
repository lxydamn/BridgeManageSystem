<template>
  <div class="login-box">
    <a-form :model="formState" name="normal_login" class="login-form" @finish="onFinish" @finishFailed="onFinishFailed">
      <a-form-item label="用户账号" name="account" class="sign-input"
        :rules="[{ required: true, message: '不能输入空用户账号，账号只允许是数字' }]">
        <a-input size="large" pattern="[0-9]*" v-model:value="formState.account">
          <template #prefix>
            <UserOutlined class="site-form-item-icon" />
          </template>
        </a-input>
      </a-form-item>

      <a-form-item label="用户密码" name="password" :rules="[{ required: true, message: '不能输入空密码' }]" class="sign-input">
        <a-input-password size="large" v-model:value="formState.password">
          <template #prefix>
            <LockOutlined class="site-form-item-icon" />
          </template>
        </a-input-password>
      </a-form-item>

      <div class="login-btn-box">
        <a-form-item>
          <a-button type="primary" html-type="submit" class="login-form-button">
            登录
          </a-button>
        </a-form-item>
      </div>
    </a-form>
  </div>
</template>
<script lang="ts">
import { defineComponent, reactive } from 'vue';
import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';
import axios from 'axios';
import { notification } from 'ant-design-vue';
import { useUserStore } from '../store/user';
import router from '../router';
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
            notification.error({
              message: '登录出现错误',
              description: "请检查账号或密码",
            })
          }

        })
    };

    const onFinishFailed = (errorInfo: any) => {
      notification.error({
        message: "登录出现错误",
        description: errorInfo,
      })
    };

    return {
      formState,
      onFinish,
      onFinishFailed,
    };
  },
});
</script>
<style scoped>
.login-form {
  width: 22rem;
  height: 45vh;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  background-color: rgba(255, 255, 255, 0.5);
  padding: 20px;
  border-radius: 10px;
}

.sign-input {
  margin-top: 1rem;
}
</style>
  