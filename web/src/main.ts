import { createApp } from 'vue'
import router from './router'
import { pinia } from './store';
import App from './App.vue'
import 'ant-design-vue/dist/antd.css';
// @ts-ignore
const app = createApp(App);
app.use(pinia).use(router).mount('#app');
