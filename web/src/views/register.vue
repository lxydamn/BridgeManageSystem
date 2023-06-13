<template>

    <div class="login-box">
        <a-form
        :model="formState"
        name="normal_login"
        class="login-form"
        @finish="onFinish"
        @finishFailed="onFinishFailed"
      >

        <a-form-item
            label="用户账号"
            name="username"
            class="sign-input"
            :rules="[{ required: true, message: '不能输入空用户账号' }]"
      >
        <a-input size="large"  v-model:value="formState.username">
          <template #prefix>
            <UserOutlined class="site-form-item-icon" />
          </template>
        </a-input>
      </a-form-item>
  
      <a-form-item
        label="用户密码"
        name="password"
        class="sign-input"
        :rules="[{ required: true, message: '不能输入空密码' }]"
      >
        <a-input-password size="large" v-model:value="formState.password">
          <template #prefix>
            <LockOutlined class="site-form-item-icon" />
          </template>
        </a-input-password>
      </a-form-item>

      <a-form-item
        label="确认密码"
        name="confirmedPassword"
        class="sign-input"
        :rules="[{ required: true, message: '不能输入空密码' }]"
      >
        <a-input-password size="large" v-model:value="formState.confirmedPassword">
          <template #prefix>
            <LockOutlined class="site-form-item-icon" />
          </template>
        </a-input-password>
      </a-form-item>
        
        <div class="login-btn-box">
            <a-form-item >
                <a-button type="primary" class="login-form-button">
                  <RouterLink to="login">
                    登录
                  </RouterLink>
                </a-button>
              </a-form-item>
      
              <a-form-item>
                  <a-button type="primary" class="login-form-button">
                    注册
                  </a-button>
            </a-form-item>
        </div>
       
      </a-form>

    </div>
    
  </template>
  <script lang="ts">
  import { defineComponent, reactive } from 'vue';
  import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';
  interface FormState {
    username: string;
    password: string;
    confirmedPassword: string;
  }
  export default defineComponent({
    components: {
      UserOutlined,
      LockOutlined,
    },
    setup() {

      const formState = reactive<FormState>({
        username: '',
        password: '',
        confirmedPassword: '',
      });

      const onFinish = (values: any) => {
        console.log('Success:', values);
      };
  
      const onFinishFailed = (errorInfo: any) => {
        console.log('Failed:', errorInfo);
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
    width: 23rem;
    display: flex;
    flex-direction: column;
    background-color: rgba(255, 255, 255, 0.5);
    padding: 20px;
    border-radius: 10px;
  }
  .sign-input {
    margin-top: 1rem;
  }

  </style>
  