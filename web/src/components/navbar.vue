<template>
  <div class="header-box">
      <div class="logo"> 桥梁初始信息管理</div>
      <a-menu
       v-model:selectedKeys="current" 
       mode="horizontal"
       style=" width:10%; display:flex; flex-direction:row-reverse; align-items:center; justify-content:center;" 
       @click="handleClick"
      >
      <a-sub-menu key="user">
          <template #icon>
              <user-outlined />
          </template>
          <template #title>{{ userStore.username }}</template>
          <a-menu-item-group>
            <a-menu-item key="userLogout">
              <template #icon>
                  <logout-outlined />
              </template>
              退出登录
            </a-menu-item>
          </a-menu-item-group>
        </a-sub-menu>
      </a-menu>
  </div>
  
</template>
<script lang="ts">
import { useUserStore } from '../store/user';
import { defineComponent, ref } from 'vue';
import { UserOutlined, LogoutOutlined} from '@ant-design/icons-vue';
const userStore = useUserStore()

export default defineComponent({
  components: {
      UserOutlined,
      LogoutOutlined
  },
  setup() {
    
    const current = ref<string[]>(['user']);

    const handleClick = (item:any) => {
      console.log(item)

      if (item.key === 'userLogout') {
          userStore.logout()
      }
    }
    return {
      current,
      handleClick,
      userStore,
    };
  },
});
</script>

<style scoped>
  .header-box {
    display: flex;
    box-shadow: 0 .25em 0.25em #bebdbd;
    margin-bottom: 0.3em;
    width: 100%;
  }
  .logo {
      display: flex;
      align-items: center;
      height: 4rem;
      width: 90%;
      text-align: center;
      justify-content: center;
      font-size: 30px;
      font-weight: 900;
      @supports (-webkit-background-clip: text) or (background-clip: text) {
          background-image: linear-gradient(to right, #eea2a2 0%, #bbc1bf 19%, #57c6e1 42%, #b49fda 79%, #7ac5d8 100%);
          -webkit-background-clip:text;
          -webkit-text-fill-color:transparent;
      }
  }

</style>


